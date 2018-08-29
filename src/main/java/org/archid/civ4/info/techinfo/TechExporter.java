package org.archid.civ4.info.techinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.archid.civ4.info.AbstractExporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;

public class TechExporter extends AbstractExporter<IInfos<ITechInfo>, ITechInfo> implements ITechExporter {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(TechExporter.class.getName());
	
	private Map<Integer, CellStyle> backgrounds;
	
	public TechExporter(EInfos infoEnum) {
		super(infoEnum);
	}

	protected void createSheets() {
		super.createSheets();
		createTechTreeSheet();
	}
	
	protected void createInfoListSheet() {

		Sheet sheet = wb.createSheet(ITechExporter.SHEETNAME_LIST);
		
		int rowNum = 0;
		
		// Create the header row
		Row row = sheet.createRow(rowNum++);
		createSheetHeaders(row);
		
		// Freeze the first row
		sheet.createFreezePane(1, 1);

		// Loop through the techs
		int colNum = 0;
		for (ITechInfo techInfo: infos.getInfos()) {
			row = sheet.createRow(rowNum++);
			int maxHeight = 1;

			colNum = 0;
			addSingleCell(row.createCell(colNum++), techInfo.getType());
			addSingleCell(row.createCell(colNum++), techInfo.getDescription());
			addSingleCell(row.createCell(colNum++), techInfo.getCivilopedia());
			addSingleCell(row.createCell(colNum++), techInfo.getHelp());
			addSingleCell(row.createCell(colNum++), techInfo.getStrategy());
			addSingleCell(row.createCell(colNum++), techInfo.getAdvisor());
			addSingleCell(row.createCell(colNum++), techInfo.getAiWeight());
			addSingleCell(row.createCell(colNum++), techInfo.getAiTradeModifier());
			addSingleCell(row.createCell(colNum++), techInfo.getCost());
			addSingleCell(row.createCell(colNum++), techInfo.getAdvancedStartCost());
			addSingleCell(row.createCell(colNum++), techInfo.getAdvancedStartCostIncrease());
			addSingleCell(row.createCell(colNum++), techInfo.getEra());
			addSingleCell(row.createCell(colNum++), techInfo.getFirstFreeUnitClass());
			addSingleCell(row.createCell(colNum++), techInfo.getFreeUnitClass());
			addSingleCell(row.createCell(colNum++), techInfo.getFeatureProductionModifier());
			addSingleCell(row.createCell(colNum++), techInfo.getWorkerSpeedModifier());
			addSingleCell(row.createCell(colNum++), techInfo.getTradeRoutes());
			addSingleCell(row.createCell(colNum++), techInfo.getHealth());
			addSingleCell(row.createCell(colNum++), techInfo.getHappiness());
			addSingleCell(row.createCell(colNum++), techInfo.getFirstFreeTechs());
			addSingleCell(row.createCell(colNum++), techInfo.getAsset());
			addSingleCell(row.createCell(colNum++), techInfo.getPower());
			addSingleCell(row.createCell(colNum++), techInfo.isRepeat());
			addSingleCell(row.createCell(colNum++), techInfo.isTrade());
			addSingleCell(row.createCell(colNum++), techInfo.isEmbassyTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isFreeTradeAgreementTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isNonAggressionTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isDisable());
			addSingleCell(row.createCell(colNum++), techInfo.isGoodyTech());
			addSingleCell(row.createCell(colNum++), techInfo.isExtraWaterSeeFrom());
			addSingleCell(row.createCell(colNum++), techInfo.isMapCentering());
			addSingleCell(row.createCell(colNum++), techInfo.isMapVisible());
			addSingleCell(row.createCell(colNum++), techInfo.isMapTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isTechTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isGoldTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isOpenBordersTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isLimitedBordersTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isDefensivePactTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isPermanentAllianceTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isVassalTrading());
			addSingleCell(row.createCell(colNum++), techInfo.isBridgeBuilding());
			addSingleCell(row.createCell(colNum++), techInfo.isIrrigation());
			addSingleCell(row.createCell(colNum++), techInfo.isIgnoreIrrigation());
			addSingleCell(row.createCell(colNum++), techInfo.isWaterWork());
			addSingleCell(row.createCell(colNum++), techInfo.isCanPassPeaks());
			addSingleCell(row.createCell(colNum++), techInfo.isMoveFastPeaks());
			addSingleCell(row.createCell(colNum++), techInfo.isCanFoundOnPeaks());
			addSingleCell(row.createCell(colNum++), techInfo.getGridX());
			addSingleCell(row.createCell(colNum++), techInfo.getGridY());
			maxHeight = addRepeatingPairCell(row.createCell(colNum++), techInfo.getDomainExtraMoves(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getCommerceFlexibles(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getTerrainTrades(), maxHeight);
			addSingleCell(row.createCell(colNum++), techInfo.isRiverTrade());
			addSingleCell(row.createCell(colNum++), techInfo.isCaptureCites());
			addSingleCell(row.createCell(colNum++), techInfo.isUnitRangeUnbound());
			addSingleCell(row.createCell(colNum++), techInfo.isUnitTerritoryUnbound());
			addSingleCell(row.createCell(colNum++), techInfo.getUnitRangeChange());
			addSingleCell(row.createCell(colNum++), techInfo.getUnitRangeModifier());
			addSingleCell(row.createCell(colNum++), techInfo.getCultureDefenceModifier());
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getForestPlotYieldChanges(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getRiverPlotYieldChanges(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getSeaPlotYieldChanges(), maxHeight);
			maxHeight = addRepeatingPairCell(row.createCell(colNum++), techInfo.getWorldViewRevoltTurnChanges(), maxHeight);
			maxHeight = addRepeatingPairCell(row.createCell(colNum++), techInfo.getFlavors(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getOrPrereqs(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getAndPrereqs(), maxHeight);
			maxHeight = addRepeatingCell(row.createCell(colNum++), techInfo.getEnabledWorldViews(), maxHeight);
			addSingleCell(row.createCell(colNum++), techInfo.getQuote());
			addSingleCell(row.createCell(colNum++), techInfo.getSound());
			addSingleCell(row.createCell(colNum++), techInfo.getSoundMP());
			addSingleCell(row.createCell(colNum++), techInfo.getButton());
			
			row.setHeightInPoints(maxHeight * sheet.getDefaultRowHeightInPoints());
		}
		
		for (int i = 0; i < colNum; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private void createTechTreeSheet() {
		
		Sheet sheet = wb.createSheet(ITechExporter.SHEETNAME_TREE);
		
		// Add the tech data
		Row row;
		Cell cell;
		int maxGridX = 0; // Used to autosize all the cols
		int maxGridY = 0; // Used to create all the rows at one go
		List<String> eras = new ArrayList<String>(); // Used to add background colour to cells based on era
		for (ITechInfo techInfo: infos.getInfos()) {
			// Get the row (iGridY value from tech)
			int gridY = techInfo.getGridY();
			if (gridY <= 0) {
				log.info("Ignoring tech " + techInfo.getType() + " invalid gridY value: " + gridY);
				continue;
			}
			if (gridY > maxGridY) maxGridY = gridY;
			row = sheet.getRow(gridY - 1);
			if (row == null)
				row = sheet.createRow(gridY - 1);
			
			// Get the col (iGridX from tech)
			int gridX = techInfo.getGridX();
			if (gridX <= 0) {
				log.info("Ignoring tech " + techInfo.getType() + " invalid gridX value: " + gridX);
				continue;
			}
			if (gridX > maxGridX) maxGridX = gridX;
			cell = row.createCell(getCellCol(gridX), CellType.STRING);
			cell.setCellValue(techInfo.getType());
			
			String era = techInfo.getEra();
			if (!eras.contains(era))
				eras.add(era);
			cell.setCellStyle(getStyle(eras.lastIndexOf(era)));
			
			setCellComment(cell, techInfo);
		}
		
		// Autosize the columns
		int iNumCols = getCellCol(maxGridX) + 1;
		for (int i = 0; i < iNumCols; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private int getCellCol(int gridX) {
		return (--gridX * 2);
	}
	
	protected void preCreateCellStyles() {
		
		super.preCreateCellStyles();
		
		// Create the coloured backgrounds for the tech tree
		backgrounds = new HashMap<Integer, CellStyle>();
		CellStyle style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		backgrounds.put(0, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		backgrounds.put(1, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		backgrounds.put(2, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		backgrounds.put(3, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		backgrounds.put(4, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
		backgrounds.put(5, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		backgrounds.put(6, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
		backgrounds.put(7, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		backgrounds.put(8, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
		backgrounds.put(9, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
		backgrounds.put(10, style);
		
}
	
	private CellStyle getStyle(int index) {
		if (index == -1)
			index = 0;
		
		if (!backgrounds.containsKey(index))
			index = index % backgrounds.size();
		
		return backgrounds.get(index);
	}
	
	protected String getCellMessage(ITechInfo info) {
    StringBuilder message = new StringBuilder("iGridX: " + info.getGridX());
    message.append("\niGridY: " + info.getGridY());
    message.append("\niCost: " + info.getCost());
    message.append("\nEra: " + info.getEra());
    if (!info.getOrPrereqs().isEmpty()) {
    	message.append("\nOrTechPrereqs:");
	    for (String prereq: info.getOrPrereqs()) {
	    	message.append("\n  " + prereq);
	    }
    }
    if (!info.getAndPrereqs().isEmpty()) {
    	message.append("\nAndTechPrereqs:");
	    for (String prereq: info.getAndPrereqs()) {
	    	message.append("\n  " + prereq);
	    }
    }
    return message.toString();
	}
	
	@Override
	public List<String> getHeaders() {
		List<String> headers = new ArrayList<>();
		for (SheetHeaders header: SheetHeaders.values()) {
			headers.add(header.toString());
		}
		return headers;
	}
	
}
