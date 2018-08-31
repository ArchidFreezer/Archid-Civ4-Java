package org.archid.civ4.info.era;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.IImporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.IPair;
import org.archid.civ4.utils.PropertyKeys;
import org.archid.civ4.utils.StringUtils;

public class EraImporter extends AbstractImporter<IInfos<IEraInfo>, IEraInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(EraImporter.class.getName());
	
	public EraImporter(EInfos infoEnum) {
		super(infoEnum);
	}

	@Override
	protected void parseXlsx() {

		// Open the spreadsheet and get the list of infos
		Workbook wb = null;
		try {
			String filepath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_IMPORT_XLSX);
			log.info("Reading workbook: " + filepath);
			wb = new XSSFWorkbook(filepath);
			
			Sheet sheet = wb.getSheet(IEraExporter.SHEETNAME_LIST);
			Iterator<Row> itRow = sheet.rowIterator();
			while (itRow.hasNext()) {
				Row row = itRow.next();
				int colNum = 0;
				
				// Ignore the header row
				if (row.getRowNum() == 0)
					continue;
				
				String type = row.getCell(colNum++).getStringCellValue();
				// Handle cells that have been moved
				if (type.isEmpty())
					continue;
				
				IEraInfo info = EraInfos.createInfo(type);
				info.setDescription(row.getCell(colNum++).getStringCellValue());
				info.setStrategy(row.getCell(colNum++).getStringCellValue());
				info.setNoGoodies(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setNoAnimals(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setNoBarbUnits(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setNoBarbCities(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setAdvancedStartPoints(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartingUnitMultiplier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartingDefenseUnits(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartingWorkerUnits(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartingExploreUnits(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartingGold(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setMaxCities(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setFreePopulation(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setStartPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setGrowthPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setTrainPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setConstructPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setCreatePercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setResearchPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setTechCostModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setBuildPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setImprovementPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setGreatPeoplePercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setCulturePercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setAnarchyPercent(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setEventChancePerTurn(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeUnbound(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setUnitTerritoryUnbound(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeChange(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setSoundtrackSpace(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setFirstSoundtrackFirst(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));

				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addEraInfoSoundtrack(str);
				}

				for (IPair<String, String> pair: parsePairs(row.getCell(colNum++), String.class, String.class)) {
					info.addCitySoundscape(pair);
				}
				
				info.setAudioUnitVictoryScript(row.getCell(colNum++).getStringCellValue());
				info.setAudioUnitDefeatScript(row.getCell(colNum++).getStringCellValue());
				
				
				infos.addInfo(info);
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

}
