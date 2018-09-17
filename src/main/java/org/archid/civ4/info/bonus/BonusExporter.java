package org.archid.civ4.info.bonus;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractExporter;
import org.archid.civ4.info.EInfo;
import org.archid.civ4.info.IInfoWorkbook;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.bonus.IBonusWorkbook.SheetHeaders;
import org.archid.utils.StringUtils;

public class BonusExporter extends AbstractExporter<IInfos<IBonusInfo>, IBonusInfo>{

	/** Logging facility */
	static Logger log = Logger.getLogger(BonusExporter.class.getName());
	
	public BonusExporter(EInfo infoEnum) {
		super(infoEnum);
	}
	
	@Override
	public List<String> getHeaders() {
		List<String> headers = new ArrayList<>();
		for (SheetHeaders header: SheetHeaders.values()) {
			headers.add(header.toString());
		}
		return headers;
	}

	@Override
	protected void populateRow(Row row, IBonusInfo info) {
		int maxHeight = 1;
		int colNum = 0;
		addSingleCell(row.createCell(colNum++), info.getType());
		addSingleCell(row.createCell(colNum++), info.getDescription());
		addSingleCell(row.createCell(colNum++), info.getCivilopedia());
		addSingleCell(row.createCell(colNum++), info.getHelp());
		addSingleCell(row.createCell(colNum++), info.getBonusClassType());
		addSingleCell(row.createCell(colNum++), info.getArtDefineTag());
		addSingleCell(row.createCell(colNum++), info.getTechReveal());
		addSingleCell(row.createCell(colNum++), info.getTechCityTrade());
		addSingleCell(row.createCell(colNum++), info.getTechObsolete());
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getYieldChanges(), maxHeight);			
		addSingleCell(row.createCell(colNum++), info.getAiTradeModifier());
		addSingleCell(row.createCell(colNum++), info.getAiObjective());
		addSingleCell(row.createCell(colNum++), info.getHealth());
		addSingleCell(row.createCell(colNum++), info.getHappiness());
		addSingleCell(row.createCell(colNum++), info.getPlacementOrder());
		addSingleCell(row.createCell(colNum++), info.getConstAppearance());
		addSingleCell(row.createCell(colNum++), info.getMinAreaSize());
		addSingleCell(row.createCell(colNum++), info.getMinLatitude());
		addSingleCell(row.createCell(colNum++), info.getMaxLatitude());
		String rands = getRandsText(info);
		if (StringUtils.hasCharacters(rands) & maxHeight < 4) maxHeight = 4; 
		addSingleCell(row.createCell(colNum++), rands);
		addSingleCell(row.createCell(colNum++), info.getPlayer());
		addSingleCell(row.createCell(colNum++), info.getTilesPer());
		addSingleCell(row.createCell(colNum++), info.getMinLandPercent());
		addSingleCell(row.createCell(colNum++), info.getUnique());
		addSingleCell(row.createCell(colNum++), info.getGroupRange());
		addSingleCell(row.createCell(colNum++), info.getGroupRand());
		addSingleCell(row.createCell(colNum++), info.isArea());
		addSingleCell(row.createCell(colNum++), info.isHills());
		addSingleCell(row.createCell(colNum++), info.isPeaks());
		addSingleCell(row.createCell(colNum++), info.isFlatlands());
		addSingleCell(row.createCell(colNum++), info.isNoRiverSide());
		addSingleCell(row.createCell(colNum++), info.isNormalize());
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getTerrainBooleans(), maxHeight);			
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getFeatureBooleans(), maxHeight);			
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getFeatureTerrainBooleans(), maxHeight);			
		addSingleCell(row.createCell(colNum++), info.isUseLSystem());

		row.setHeightInPoints(maxHeight * row.getSheet().getDefaultRowHeightInPoints());
	
}

	private String getRandsText(IBonusInfo info) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Integer val: info.getRands()) {
			if (!first) sb.append(IInfoWorkbook.CELL_NEWLINE);
			sb.append(val);
			first = false;
		}
		return sb.toString();
	}

	@Override
	protected int getNumCols() {
		return IBonusWorkbook.SheetHeaders.values().length;
	}

	@Override
	protected String getInfoListSheetName() {
		return IBonusWorkbook.SHEETNAME_LIST;
	}

}
