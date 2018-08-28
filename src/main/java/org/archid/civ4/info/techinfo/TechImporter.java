package org.archid.civ4.info.techinfo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
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
import org.archid.civ4.info.InfosFactory;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.CollectionUtils;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;
import org.archid.civ4.utils.StringUtils;

public class TechImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechImporter.class.getName());
	
	private static IPropertyHandler props = PropertyHandler.getInstance();
	private TechInfos xlsInfos = new TechInfos();

	public void importXLSX() {
		
		// Read the xlsx file to create the list of tech infos to update
		parseXlsx();
		try {
			backupInfosFile();
			updateInfosFile();
		} catch (IOException e) {
			log.error("Error backing up infos file ... aborting", e);
		}
	}
	
	private void updateInfosFile() {

		TechInfos infos = InfosFactory.getInfos(EInfos.TECH_INFOS, props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE));
		
		for (String xlsType: xlsInfos.getInfoTypes()) {
			ITechInfo newInfo;
			if (infos.containsInfo(xlsType)) {
				newInfo = applyInfo(infos.getInfo(xlsType), xlsInfos.getInfo(xlsType));
			} else {
				newInfo = xlsInfos.getInfo(xlsType);
			}
			infos.addInfo(newInfo);
		}
		
		InfosFactory.writeInfos(EInfos.TECH_INFOS, props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE), infos);
				
	}

	private ITechInfo applyInfo(ITechInfo fileInfo, ITechInfo xlsInfo) {
		fileInfo.setGridX(xlsInfo.getGridX());
		fileInfo.setGridY(xlsInfo.getGridY());
		fileInfo.setCost(xlsInfo.getCost());
		fileInfo.setAdvancedStartCost(xlsInfo.getAdvancedStartCost());
		fileInfo.setAsset(xlsInfo.getAsset());
		fileInfo.setEra(xlsInfo.getEra());
		if (CollectionUtils.hasElements(xlsInfo.getOrPrereqs())) {
			for (String prereq: xlsInfo.getOrPrereqs()) {
				if (StringUtils.hasCharacters(prereq))
					fileInfo.addOrPrereq(prereq);
			}
		}
		if (CollectionUtils.hasElements(xlsInfo.getAndPrereqs())) {
			for (String prereq: xlsInfo.getAndPrereqs()) {
				if (StringUtils.hasCharacters(prereq))
					fileInfo.addAndPrereq(prereq);
			}
		}
		return fileInfo;
	}

	private void parseXlsx() {
		
		
		// Open the spreadsheet and get the list of infos
		Workbook wb = null;
		try {
			String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_IMPORT_XLSX);
			log.info("Reading workbook: " + filepath);
			wb = new XSSFWorkbook(filepath);
			Sheet sheet = wb.getSheet(ITechInfoSpreadsheet.SHEETNAME_TREE);
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
					ITechInfo info = TechInfos.createInfo(type);
					Integer gridX = getGridXFromCell(cell);
					info.setGridX(gridX);
					Integer gridY = cell.getRowIndex() + 1;
					info.setGridY(gridY);
					xlsInfos.addInfo(parseComment(sheet.getCellComment(cell.getAddress()), info));
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
	}
	
	private Integer getGridXFromCell(Cell cell) {
		Integer gridX = 0;
		Integer colIndex = cell.getColumnIndex();
		
		if (colIndex > 0) {
			gridX = colIndex / 2;
		}
		
		return ++gridX;
	}

	private ITechInfo parseComment(Comment comment, ITechInfo info) {
		String text = comment.getString().getString();
		String[] lines = text.split("\\r?\\n");
		Pattern patternCost = Pattern.compile("iCost: (\\d+)");
		Pattern patternAdvStartCost = Pattern.compile("iAdvancedStartCost: (\\d+)");
		Pattern patternAsset = Pattern.compile("iAsset: (\\d+)");
		Pattern patternEra = Pattern.compile("Era: ([A-Za-z_]+)");
		Pattern patternOr = Pattern.compile("OrTechPrereqs:");
		Pattern patternAnd = Pattern.compile("AndTechPrereqs:");
		Pattern patternTech = Pattern.compile("\\s*?([A-Z_]+)");
		boolean bOr = false;
		for (String line: lines) {
			Matcher matcherCost = patternCost.matcher(line);
			if (matcherCost.matches()) {
				info.setCost(Integer.parseInt(matcherCost.group(1)));
				continue;
			}
			Matcher matcherAdvStartCost = patternAdvStartCost.matcher(line);
			if (matcherAdvStartCost.matches()) {
				info.setAdvancedStartCost(Integer.parseInt(matcherAdvStartCost.group(1)));
				continue;
			}
			Matcher matcherAsset = patternAsset.matcher(line);
			if (matcherAsset.matches()) {
				info.setAsset(Integer.parseInt(matcherAsset.group(1)));
				continue;
			}
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
					info.addOrPrereq(matcherTech.group(1));
				else
					info.addAndPrereq(matcherTech.group(1));
				continue;
			}
		}
		return info;
	}

	private void backupInfosFile() throws IOException {
		String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String copyFile = filepath + "." + sdf.format(cal.getTime());
		log.info("Backing up original file to: " + copyFile);

		File source = new File(copyFile);
		FileUtils.copyFile(new File(filepath), source);
	}
}
