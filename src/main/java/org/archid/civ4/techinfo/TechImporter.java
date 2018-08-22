package org.archid.civ4.techinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;

public class TechImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechImporter.class.getName());
	
	private static String newline = System.getProperty("line.separator");
	
	private static IPropertyHandler props = PropertyHandler.getInstance();

	public void importXLSX() {
		// Read the xlsx file to create the list of tech infos to update
		Map<String, TechInfo> infos = parseXlsx();
		updateInfosFile(infos);
	}
	
	private void updateInfosFile(Map<String, TechInfo> infos) {

		Pattern patternStartTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_START);
		Pattern patternX = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDX_VALUE);
		Pattern patternY = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDY_VALUE);
		Pattern patternType = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TYPE_VALUE);
		Pattern patternOrTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_START);
		Pattern patternAndTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_AND_TECH_PREREQ_TAG_START);
		Pattern patternEndTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_END);
		
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			boolean bInTech = false;
			boolean bWrittenOrPrereqs = false;
			boolean bWrittenAndPrereqs = false;
			TechInfo info = null;
			String line = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcherStartTag = patternStartTag.matcher(line);
				if (matcherStartTag.matches() && !bInTech)
				{
					bInTech = true;
					bWrittenOrPrereqs = false;
					bWrittenAndPrereqs = false;
					writer.write(line + newline);
					continue;
				}
				Matcher matcherType = patternType.matcher(line);
				if (matcherType.matches() && bInTech)
				{
					info = infos.get(matcherType.group(1));
					writer.write(line + newline);
					continue;
				}
				Matcher matcherX = patternX.matcher(line);
				if (matcherX.matches() && bInTech)
				{
					int currX = Integer.parseInt(matcherX.group(1));
					line = line.replaceAll(Integer.toString(currX), Integer.toString(info.getGridX()));
					writer.write(line + newline);
					continue;
				}
				Matcher matcherY = patternY.matcher(line);
				if (matcherY.matches() && bInTech)
				{
					int currY = Integer.parseInt(matcherY.group(1));
					line = line.replaceAll(Integer.toString(currY), Integer.toString(info.getGridY()));
					writer.write(line + newline);
					continue;
				}
				Matcher matcherOrTechPrereq = patternOrTechPrereq.matcher(line);
				if (matcherOrTechPrereq.matches() && bInTech)
				{
					writer.write(line + newline);
					writer.write(getPrereqTechsElement(reader, info, ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_END));
					bWrittenOrPrereqs = true;
					continue;
				}
				Matcher matcherAndTechPrereq = patternAndTechPrereq.matcher(line);
				if (matcherAndTechPrereq.matches() && bInTech)
				{
					writer.write(line + newline);
					writer.write(getPrereqTechsElement(reader, info, ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_END));
					bWrittenAndPrereqs = true;
					continue;
				}
				Matcher matcherEndTag = patternEndTag.matcher(line);
				if (matcherEndTag.matches() && bInTech)
				{
					if (!bWrittenOrPrereqs && !info.getOrTechPrereqs().isEmpty())
						log.info("Did not write the OrTechPrereqs for " + info.getType());
					if (!bWrittenAndPrereqs && !info.getAndTechPrereqs().isEmpty())
						log.info("Did not write the AndTechPrereqs for " + info.getType());
					bInTech = false;
				}
				writer.write(line + newline);
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			log.error("Could not find the input file", e);
		} catch (IOException e) {
			log.error("Could not access the file", e);
		}
		
	}

	private String getPrereqTechsElement(BufferedReader reader, TechInfo info, String patternRegEX) throws IOException {
		StringBuffer prereqs = new StringBuffer();
		// We are already in the tag so we only need the prereqs and the end tag
		// Get the spacing around the techs first
		Pattern patternTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_PREREQ_NOT_VALUE);	
		Pattern patternEnd = Pattern.compile(patternRegEX);
		boolean bFinished = false;
		String line = "";
		String prereqPrefix = "";
		String prereqPostfix = "";
		while(!bFinished && (line = reader.readLine()) != null)
		{
			Matcher matcherTag = patternTag.matcher(line);
			if (matcherTag.matches())
			{
				prereqPrefix = matcherTag.group(1);
				prereqPostfix = matcherTag.group(2);
				continue;
			}
			Matcher matcherEnd = patternEnd.matcher(line);
			if (matcherEnd.matches())
			{
				for (String prereq: info.getOrTechPrereqs()) {
					prereqs.append(prereqPrefix + prereq + prereqPostfix + newline);
				}
				prereqs.append(line + newline);
				bFinished = true;
			}
		}
		return prereqs.toString();
	}

	private Map<String, TechInfo> parseXlsx() {
		
		Map<String, TechInfo> infos = new HashMap<String, TechInfo>();
		
		// Open the spreadsheet and get the list of infos
		Workbook wb = null;
		try {
			String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_IMPORT_XLSX);
			log.info("Reading workbook: " + filepath);
			wb = new XSSFWorkbook(filepath);
			Sheet sheet = wb.getSheet(ITechWorkbookConstants.SHEETNAME_TREE);
			Iterator<Row> itRow = sheet.rowIterator();
			while (itRow.hasNext()) {
				Row row = itRow.next();
				Iterator<Cell> itCell = row.cellIterator();
				while (itCell.hasNext()) {
					Cell cell = itCell.next();
					TechInfo info = new TechInfo();
					String type = cell.getStringCellValue();
					info.setType(type);
					infos.put(type, parseComment(sheet.getCellComment(cell.getAddress()), info));
				}
			}
		} catch (IOException e) {
			log.error("Error opening workbook", e);
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					log.error("Error closing workbook", e);
				}
			}
		}
		
		return infos;
	}
	
	private TechInfo parseComment(Comment comment, TechInfo info) {
		String text = comment.getString().getString();
		String[] lines = text.split("\\r?\\n");
		Pattern patternX = Pattern.compile("iGridX: (\\d+)");
		Pattern patternY = Pattern.compile("iGridY: (\\d+)");
		Pattern patternOr = Pattern.compile("OrTechPrereqs:");
		Pattern patternAnd = Pattern.compile("AndTechPrereqs:");
		Pattern patternTech = Pattern.compile("\\s*?([A-Z_]+)");
		boolean bOr = false;
		for (String line: lines) {
			Matcher matcherX = patternX.matcher(line);
			if (matcherX.matches()) {
				info.setGridX(Integer.parseInt(matcherX.group(1)));
				continue;
			}
			Matcher matcherY = patternY.matcher(line);
			if (matcherY.matches()) {
				info.setGridY(Integer.parseInt(matcherY.group(1)));
				continue;
			}
			Matcher matcherOr = patternOr.matcher(line);
			if (matcherOr.matches()) {
				bOr = true;
				continue;
			}
			Matcher matcherAnd = patternAnd.matcher(line);
			if (matcherAnd.matches()) {
				bOr = false;
				continue;
			}
			Matcher matcherTech = patternTech.matcher(line);
			if (matcherTech.matches()) {
				if (bOr)
					info.addOrTechPrereq(matcherTech.group(1));
				else
					info.addAndTechPrereq(matcherTech.group(1));
				continue;
			}
			log.info("Comment: " + line);
		}
		return info;
	}

	private BufferedReader  getInputFile() throws IOException {
		String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String copyFile = filepath + "." + sdf.format(cal.getTime());
		log.info("Backing up original file to: " + copyFile);

		File source = new File(copyFile);
		FileUtils.moveFile(new File(filepath), source);
		FileReader reader = new FileReader(source);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
	private BufferedWriter getOutputFile() throws IOException {
		String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		log.info("Writing output to: " + filepath);
		File file = new File(filepath);
		FileUtils.touch(file);
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		return bufferedWriter;
		
	}
}
