package org.archid.civ4.info.techinfo;

import java.io.IOException;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.IImporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.IKeyValuePair;
import org.archid.civ4.utils.PropertyKeys;
import org.archid.civ4.utils.StringUtils;

public class TechImporter extends AbstractImporter<IInfos<ITechInfo>, ITechInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechImporter.class.getName());
	
	public TechImporter(EInfos T) {
		super(T);
	}

	protected void parseXlsx() {
		
		// Open the spreadsheet and get the list of infos
		Workbook wb = null;
		try {
			String filepath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_IMPORT_XLSX);
			log.info("Reading workbook: " + filepath);
			wb = new XSSFWorkbook(filepath);
			
			// Get the iGridX and iGridY values from the tech tree
			Sheet sheet = wb.getSheet(ITechExporter.SHEETNAME_TREE);
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
					infos.addInfo(info);
				}
			}

			// Get the rest of the values from the tech tree
			sheet = wb.getSheet(ITechExporter.SHEETNAME_LIST);
			itRow = sheet.rowIterator();
			while (itRow.hasNext()) {
				Row row = itRow.next();
				int colNum = 0;
				
				String type = row.getCell(colNum++).getStringCellValue();
				// Handle cells that have been moved
				if (type.isEmpty())
					continue;
				ITechInfo info = infos.getInfo(type);
				// Handle deleted techs
				if (info == null)
					continue;
				info.setDescription(row.getCell(colNum++).getStringCellValue());
				info.setCivilopedia(row.getCell(colNum++).getStringCellValue());
				info.setHelp(row.getCell(colNum++).getStringCellValue());
				info.setStrategy(row.getCell(colNum++).getStringCellValue());
				info.setAdvisor(row.getCell(colNum++).getStringCellValue());
				info.setAiWeight(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setAiTradeModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setCost(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setAdvancedStartCost(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setAdvancedStartCostIncrease(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setEra(row.getCell(colNum++).getStringCellValue());
				info.setFirstFreeUnitClass(row.getCell(colNum++).getStringCellValue());
				info.setFreeUnitClass(row.getCell(colNum++).getStringCellValue());
				info.setFeatureProductionModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setWorkerSpeedModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setTradeRoutes(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setHealth(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setHappiness(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setFirstFreeTechs(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setAsset(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setPower(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setRepeat(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setTrade(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setEmbassyTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setFreeTradeAgreementTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setNonAggressionTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setDisable(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setGoodyTech(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setExtraWaterSeeFrom(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setMapCentering(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setMapVisible(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setMapTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setTechTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setGoldTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setOpenBordersTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setLimitedBordersTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setDefensivePactTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setPermanentAllianceTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setVassalTrading(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setBridgeBuilding(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setIrrigation(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setIgnoreIrrigation(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setWaterWork(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setCanPassPeaks(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setMoveFastPeaks(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setCanFoundOnPeaks(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				// We need to skip the iGridX & iGridY rows
				colNum += 2;
				for (IKeyValuePair<String, Integer> pair: parsePairs(row.getCell(colNum++))) {
					info.addDomainExtraMove(pair);
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addCommerceFlexible(Boolean.parseBoolean(str));
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addTerrainTrade(str);
				}
				info.setRiverTrade(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setCaptureCities(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeUnbound(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setUnitTerritoryUnbound(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeChange(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setUnitRangeModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				info.setCultureDefenceModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addForestPlotYieldChange(Integer.parseInt(str));
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addRiverPlotYieldChange(Integer.parseInt(str));
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addSeaPlotYieldChange(Integer.parseInt(str));
				}
				for (IKeyValuePair<String, Integer> pair: parsePairs(row.getCell(colNum++))) {
					info.addWorldViewRevoltTurnChange(pair);
				}
				for (IKeyValuePair<String, Integer> pair: parsePairs(row.getCell(colNum++))) {
					info.addFlavor(pair);
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addOrPrereq(str);
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addAndPrereq(str);
				}
				for (String str: row.getCell(colNum++).getStringCellValue().split("\n")) {
					if (StringUtils.hasCharacters(str))
						info.addEnabledWorldViews(str);
				}
				info.setQuote(row.getCell(colNum++).getStringCellValue());
				info.setSound(row.getCell(colNum++).getStringCellValue());
				info.setSoundMP(row.getCell(colNum++).getStringCellValue());
				info.setButton(row.getCell(colNum++).getStringCellValue());
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
}
