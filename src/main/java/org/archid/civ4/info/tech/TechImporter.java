package org.archid.civ4.info.tech;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.DefaultXmlFormatter;
import org.archid.civ4.info.IImporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.utils.IPair;
import org.archid.utils.StringUtils;

public class TechImporter extends AbstractImporter<IInfos<ITechInfo>, ITechInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(TechImporter.class.getName());
	
	public TechImporter(EInfos infoEnum) {
		super(infoEnum, new DefaultXmlFormatter());
	}


	/**
	 * Overrides the the method from {@link AbstractImporter} to allow the {@code <TechInfo>} objects to be defined
	 * by the tech tree sheet rather than the list sheet. A tech will be created for each one defined in the tech tree
	 * sheet which will provide the {@code <Type>}, {@code <iGridX>} and {@code <iGridY>} tag values. All other values
	 * are then populated from the list sheet.
	 * 
	 * @param wb {@link Workbook} containing the tech tree and list sheets
	 */
	protected void parseXlsx(Workbook wb) {
		
		// Get the iGridX and iGridY values from the tech tree
		Sheet sheet = wb.getSheet(ITechWorkbook.SHEETNAME_TREE);
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
		sheet = wb.getSheet(getListSheetName());
		itRow = sheet.rowIterator();
		while (itRow.hasNext()) {
			Row row = itRow.next();
			int colNum = 0;
			
			String type = row.getCell(colNum++).getStringCellValue();
			log.debug("Processing: " + type);
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
			
			for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
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
			for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
				info.addWorldViewRevoltTurnChange(pair);
			}
			for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
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
	}
	
	private Integer getGridXFromCell(Cell cell) {
		Integer gridX = 0;
		Integer colIndex = cell.getColumnIndex();
		
		if (colIndex > 0) {
			gridX = colIndex / 2;
		}
		
		return ++gridX;
	}

	/* (non-Javadoc)
	 * @see org.archid.civ4.info.IImporter#getListSheetName()
	 */
	@Override
	public String getListSheetName() {
		return ITechWorkbook.SHEETNAME_LIST;
	}

	/**
	 * This method is not used in this class as the {@link AbstractImporter#parseXlsx(Workbook)} method is overriden  
	 */
	@Override
	protected ITechInfo parseRow(Row row) {
		return null;
	}

}
