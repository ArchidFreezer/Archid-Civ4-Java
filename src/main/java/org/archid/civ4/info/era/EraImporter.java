package org.archid.civ4.info.era;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.DefaultXmlFormatter;
import org.archid.civ4.info.IImporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.utils.IPair;
import org.archid.utils.StringUtils;

public class EraImporter extends AbstractImporter<IInfos<IEraInfo>, IEraInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(EraImporter.class.getName());
	
	public EraImporter(EInfos infoEnum) {
		super(infoEnum, new DefaultXmlFormatter(false));
	}

	@Override
	protected IEraInfo parseRow(Row row) {
		
		int colNum = 0;
		String type = row.getCell(colNum++).getStringCellValue();
		// Handle cells that have been moved
		if (type.isEmpty())
			return null;
		
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
		
		return info;
	}

	@Override
	public String getListSheetName() {
		return IEraWorkbook.SHEETNAME_LIST;
	}

}
