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
import java.util.List;
import java.util.Map;
import java.util.Vector;
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
import org.archid.civ4.schema.SchemaParser;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;
import org.archid.civ4.utils.PropertyKeys;

public class TechImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechImporter.class.getName());
	
	private static String newline = System.getProperty("line.separator");

	private static IPropertyHandler props = PropertyHandler.getInstance();
	private SchemaParser parser = new SchemaParser();

	public void importXLSX() {
		
		try {
			String modSchema = props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA_DIR, ".") + "\\" + ITechWorkbookConstants.TECHINFO_SCHEMA_NAME;
			parser.parse(modSchema);
			// Read the xlsx file to create the list of tech infos to update
			Map<String, TechInfo> infos = parseXlsx();
			updateInfosFile(infos);
		} catch (FileNotFoundException e) {
			log.error("Could not find schema file", e);
		}
	}
	
	private void updateInfosFile(Map<String, TechInfo> infos) {

		Pattern patternTechsStartTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECHS_TAG_START);
		Pattern patternTechsEndTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECHS_TAG_END);
		Pattern patternTechStartTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_START);
		Pattern patternTechEndTag = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TECH_TAG_END);
		Pattern patternX = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDX_VALUE);
		Pattern patternY = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_IGRIDY_VALUE);
		Pattern patternType = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_TYPE_VALUE);
		Pattern patternOrTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_START);
		Pattern patternAndTechPrereq = Pattern.compile(ITechWorkbookConstants.STYLE_REGEX_AND_TECH_PREREQ_TAG_START);
		
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			
			String line = "";
			
			// First dump  out the header up to and including the <TechInfos> tag
			while((line = reader.readLine()) != null)
			{
				writer.write(line + newline);
				Matcher matcherTechsStartTag = patternTechsStartTag.matcher(line);
				if (matcherTechsStartTag.matches()) {
					break;
				}

			}

			// Now loop through the existing techs in xml file
			// We keep a note of the infos we process so we can add any new entries from the spreadsheet
			List<String> processedInfos = new Vector<String>();
			boolean bInTech = false;
			boolean bWrittenOrPrereqs = false;
			boolean bWrittenAndPrereqs = false;
			TechInfo info = null;
			String techStart = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcherTechStartTag = patternTechStartTag.matcher(line);
				if (matcherTechStartTag.matches() && !bInTech)
				{
					bInTech = true;
					bWrittenOrPrereqs = false;
					bWrittenAndPrereqs = false;
					// Store this line in case we are removing the tech
					techStart = line + newline;
					continue;
				}
				Matcher matcherType = patternType.matcher(line);
				if (matcherType.matches() && bInTech)
				{
					String type = matcherType.group(1);
					info = infos.get(type);
					if (info == null) {
						log.info("Removing tech: " + type);
						continue;
					}
					processedInfos.add(info.getType());
					// Now we know we aren't removing the tech we can add its line
					writer.write(techStart);
					writer.write(line + newline);
					continue;
				}
				Matcher matcherX = patternX.matcher(line);
				if (matcherX.matches() && bInTech)
				{
					if (info == null) continue;
					line = line.replaceAll(matcherX.group(1), Integer.toString(info.getGridX()));
					writer.write(line + newline);
					continue;
				}
				Matcher matcherY = patternY.matcher(line);
				if (matcherY.matches() && bInTech)
				{
					if (info == null) continue;
					line = line.replaceAll(matcherY.group(1), Integer.toString(info.getGridY()));
					writer.write(line + newline);
					continue;
				}
				Matcher matcherOrTechPrereq = patternOrTechPrereq.matcher(line);
				if (matcherOrTechPrereq.matches() && bInTech)
				{
					if (info == null) continue;
					writer.write(line + newline);
					writer.write(getPrereqTechsElement(reader, info.getOrTechPrereqs(), ITechWorkbookConstants.STYLE_REGEX_OR_TECH_PREREQ_TAG_END));
					bWrittenOrPrereqs = true;
					continue;
				}
				Matcher matcherAndTechPrereq = patternAndTechPrereq.matcher(line);
				if (matcherAndTechPrereq.matches() && bInTech)
				{
					if (info == null) continue;
					writer.write(line + newline);
					writer.write(getPrereqTechsElement(reader, info.getAndTechPrereqs(), ITechWorkbookConstants.STYLE_REGEX_AND_TECH_PREREQ_TAG_END));
					bWrittenAndPrereqs = true;
					continue;
				}
				Matcher matcherTechEndTag = patternTechEndTag.matcher(line);
				if (matcherTechEndTag.matches() && bInTech)
				{
					bInTech = false;
					if (info == null) continue;
					if (!bWrittenOrPrereqs && !info.getOrTechPrereqs().isEmpty())
						log.info("Did not write the OrTechPrereqs for " + info.getType());
					if (!bWrittenAndPrereqs && !info.getAndTechPrereqs().isEmpty())
						log.info("Did not write the AndTechPrereqs for " + info.getType());
				}
				
				Matcher matcherTechsEndTag = patternTechsEndTag.matcher(line);
				if (matcherTechsEndTag.matches()) {
					// We have found the end of the <TechInfos> so append any unprocessed infos
					writer.write(appendNewTechs(infos, processedInfos));
				}
				
				if (!bInTech || info != null)
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

	private String appendNewTechs(Map<String, TechInfo> infos, List<String> processedInfos) {
		StringBuffer newTechsString = new StringBuffer();
		
		XMLGenerator xmlGen = new XMLGenerator(parser);
		for (String key: infos.keySet()) {
			if (!processedInfos.contains(key)) {
				log.info("Appending new tech: " + key);
				newTechsString.append(xmlGen.printTag(infos.get(key), parser.getTagDefinition("TechInfo"), 2, false));
			}
		}
		
		return newTechsString.toString();
	}

	private String getPrereqTechsElement(BufferedReader reader, List<String> prereqs, String patternRegEX) throws IOException {
		StringBuffer prereqString = new StringBuffer();
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
				for (String prereq: prereqs) {
					prereqString.append(prereqPrefix + prereq + prereqPostfix + newline);
				}
				prereqString.append(line + newline);
				bFinished = true;
			}
		}
		return prereqString.toString();
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
					String type = cell.getStringCellValue();
					// Handle cells that have been moved
					if (type.isEmpty())
						continue;
					TechInfo info = new TechInfo();
					info.setType(type);
					Integer gridX = getGridXFromCell(cell);
					info.setGridX(gridX);
					Integer gridY = cell.getRowIndex() + 1;
					info.setGridY(gridY);
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
	
	private Integer getGridXFromCell(Cell cell) {
		Integer gridX = 0;
		Integer colIndex = cell.getColumnIndex();
		
		if (colIndex > 0) {
			gridX = colIndex / 2;
		}
		
		return ++gridX;
	}

	private TechInfo parseComment(Comment comment, TechInfo info) {
		String text = comment.getString().getString();
		String[] lines = text.split("\\r?\\n");
		Pattern patternEra = Pattern.compile("Era: ([A-Za-z_]+)");
		Pattern patternOr = Pattern.compile("OrTechPrereqs:");
		Pattern patternAnd = Pattern.compile("AndTechPrereqs:");
		Pattern patternTech = Pattern.compile("\\s*?([A-Z_]+)");
		boolean bOr = false;
		for (String line: lines) {
			Matcher matcherEra = patternEra.matcher(line);
			if (matcherEra.matches()) {
				info.setEra(matcherEra.group(1));
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
