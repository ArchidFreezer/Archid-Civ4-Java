package org.archid.civ4.info.bonus;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.EInfo;
import org.archid.civ4.info.IInfos;

public class BonusImporter extends AbstractImporter<IInfos<IBonusInfo>, IBonusInfo>{

	/** Logging facility */
	static Logger log = Logger.getLogger(BonusImporter.class.getName());
	
	public BonusImporter(EInfo infoEnum) {
		super(infoEnum, new BonusInfoXmlFormatter());
	}

	@Override
	public String getListSheetName() {
		return IBonusWorkbook.SHEETNAME_LIST;
	}

	@Override
	protected IBonusInfo parseRow(Row row) {
		
		int colNum = 0;
		String type = row.getCell(colNum++).getStringCellValue();
		// Handle cells that have been moved
		if (type.isEmpty())
			return null;
		
		IBonusInfo info = BonusInfos.createInfo(type);
		parseCell(row.getCell(colNum++), String.class, info::setDescription);
		parseCell(row.getCell(colNum++), String.class, info::setCivilopedia);
		parseCell(row.getCell(colNum++), String.class, info::setHelp);
		parseCell(row.getCell(colNum++), String.class, info::setBonusClassType);
		parseCell(row.getCell(colNum++), String.class, info::setArtDefineTag);
		parseCell(row.getCell(colNum++), String.class, info::setTechReveal);
		parseCell(row.getCell(colNum++), String.class, info::setTechCityTrade);
		parseCell(row.getCell(colNum++), String.class, info::setTechObsolete);
		parseListCell(row.getCell(colNum++), Integer.class, info::addYieldChange);
		parseCell(row.getCell(colNum++), Integer.class, info::setAiTradeModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setAiObjective);
		parseCell(row.getCell(colNum++), Integer.class, info::setHealth);
		parseCell(row.getCell(colNum++), Integer.class, info::setHappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setPlacementOrder);
		parseCell(row.getCell(colNum++), Integer.class, info::setConstAppearance);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinAreaSize);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinLatitude);
		parseCell(row.getCell(colNum++), Integer.class, info::setMaxLatitude);
		parseListCell(row.getCell(colNum++), Integer.class, info::addRand);
		parseCell(row.getCell(colNum++), Integer.class, info::setPlayer);
		parseCell(row.getCell(colNum++), Integer.class, info::setTilesPer);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinLandPercent);
		parseCell(row.getCell(colNum++), Integer.class, info::setUnique);
		parseCell(row.getCell(colNum++), Integer.class, info::setGroupRange);
		parseCell(row.getCell(colNum++), Integer.class, info::setGroupRand);
		parseCell(row.getCell(colNum++), Boolean.class, info::setArea);
		parseCell(row.getCell(colNum++), Boolean.class, info::setHills);
		parseCell(row.getCell(colNum++), Boolean.class, info::setPeaks);
		parseCell(row.getCell(colNum++), Boolean.class, info::setFlatlands);
		parseCell(row.getCell(colNum++), Boolean.class, info::setNoRiverSide);
		parseCell(row.getCell(colNum++), Boolean.class, info::setNormalize);
		parseListCell(row.getCell(colNum++), String.class, info::addTerrainBoolean);
		parseListCell(row.getCell(colNum++), String.class, info::addFeatureBoolean);
		parseListCell(row.getCell(colNum++), String.class, info::addFeatureTerrainBoolean);
		parseCell(row.getCell(colNum++), Boolean.class, info::setUseLSystem);

		return info;
	}
	
}
