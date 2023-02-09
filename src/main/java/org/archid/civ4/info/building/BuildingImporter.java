package org.archid.civ4.info.building;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.EInfo;
import org.archid.civ4.info.IInfos;

public class BuildingImporter extends AbstractImporter<IInfos<IBuildingInfo>, IBuildingInfo> {

	/** Logging facility */
	static Logger log = Logger.getLogger(BuildingImporter.class.getName());
	
	public BuildingImporter(EInfo infoEnum) {
		super(infoEnum, new BuildingInfoXmlFormatter());
	}

	@Override
	protected IBuildingInfo parseRow(Row row) {
		int colNum = 0;
		String clazz = row.getCell(colNum++).getStringCellValue();
		String type = row.getCell(colNum++).getStringCellValue();
		
		// Handle buildings that have been deleted or are incomplete
		if (clazz.isEmpty() || type.isEmpty())
			return null;
		
		IBuildingInfo info = BuildingInfos.createInfo(type);
		info.setBuildingClass(clazz);
		parseCell(row.getCell(colNum++), String.class, info::setSpecialBuildingType);
		parseCell(row.getCell(colNum++), String.class, info::setDescription);
		parseCell(row.getCell(colNum++), String.class, info::setCivilopedia);
		parseCell(row.getCell(colNum++), String.class, info::setStrategy);
		parseCell(row.getCell(colNum++), String.class, info::setHelp);
		parseCell(row.getCell(colNum++), String.class, info::setAdvisor);
		parseCell(row.getCell(colNum++), String.class, info::setArtDefineTag);
		parseCell(row.getCell(colNum++), String.class, info::setMovieDefineTag);
		parseCell(row.getCell(colNum++), Boolean.class, info::setAutoBuild);
		parseCell(row.getCell(colNum++), String.class, info::setHolyCity);
		parseCell(row.getCell(colNum++), String.class, info::setReligionType);
		parseCell(row.getCell(colNum++), String.class, info::setStateReligion);
		parseCell(row.getCell(colNum++), Boolean.class, info::setStateReligion);
		parseCell(row.getCell(colNum++), String.class, info::setPrereqReligion);
		parseCell(row.getCell(colNum++), String.class, info::setPrereqCorporation);
		parseCell(row.getCell(colNum++), String.class, info::setFoundsCorporation);
		parseCell(row.getCell(colNum++), String.class, info::setGlobalReligionCommerce);
		parseCell(row.getCell(colNum++), String.class, info::setGlobalCorporationCommerce);
		parseCell(row.getCell(colNum++), String.class, info::setVictoryPrereq);
		parseCell(row.getCell(colNum++), String.class, info::setFreeStartEra);
		parseCell(row.getCell(colNum++), String.class, info::setMaxStartEra);
		parseCell(row.getCell(colNum++), String.class, info::setObsoleteTech);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqAndTech);
		parseCell(row.getCell(colNum++), String.class, info::setPrereqBonus);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqOrBonus);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqAndCivic);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqOrCivic);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqAndTerrain);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqOrTerrain);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqVicinityAndBonus);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqVicinityOrBonus);
		parseCell(row.getCell(colNum++), Boolean.class, info::setRequirePrereqVicinityBonusConnected);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqVicinityImprovement);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqVicinityFeature);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqWorldView);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinPopulation);
		parseCell(row.getCell(colNum++), String.class, info::setMinCultureLevel);
		parseCell(row.getCell(colNum++), Boolean.class, info::setPrereqPower);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addProductionTrait);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addHappinessTrait);
		parseCell(row.getCell(colNum++), String.class, info::setNoBonus);
		parseCell(row.getCell(colNum++), String.class, info::setPowerBonus);
		parseCell(row.getCell(colNum++), String.class, info::setFreeBonus);
		parseCell(row.getCell(colNum++), Integer.class, info::setNumFreeBonuses);
		parseCell(row.getCell(colNum++), String.class, info::setFreeBuilding);
		parseCell(row.getCell(colNum++), String.class, info::setFreePromotion);
		parseCell(row.getCell(colNum++), String.class, info::setCivicOption);
		parseCell(row.getCell(colNum++), String.class, info::setGreatPeopleUnitClass);
		parseCell(row.getCell(colNum++), Integer.class, info::setGreatPeopleRateChange);
		parseCell(row.getCell(colNum++), Integer.class, info::setHurryAngerModifier);
		parseCell(row.getCell(colNum++), Boolean.class, info::setBorderObstacle);
		parseCell(row.getCell(colNum++), Boolean.class, info::setTeamShare);
		parseCell(row.getCell(colNum++), Boolean.class, info::setWater);
		parseCell(row.getCell(colNum++), Boolean.class, info::setRiver);
		parseCell(row.getCell(colNum++), Boolean.class, info::setPower);
		parseCell(row.getCell(colNum++), Boolean.class, info::setDirtyPower);
		parseCell(row.getCell(colNum++), Boolean.class, info::setAreaCleanPower);
		parseCell(row.getCell(colNum++), String.class, info::setDiploVoteType);
		parseCell(row.getCell(colNum++), Boolean.class, info::setForceTeamVoteEligible);
		parseCell(row.getCell(colNum++), Boolean.class, info::setCapital);
		parseCell(row.getCell(colNum++), Boolean.class, info::setGovernmentCenter);
		parseCell(row.getCell(colNum++), Boolean.class, info::setGoldenAge);
		parseCell(row.getCell(colNum++), Boolean.class, info::setAllowsNukes);
		parseCell(row.getCell(colNum++), Boolean.class, info::setMapCentering);
		parseCell(row.getCell(colNum++), Boolean.class, info::setNoUnhappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setUnhealthyPopulationModifier);
		parseCell(row.getCell(colNum++), Boolean.class, info::setBuildingOnlyHealthy);
		parseCell(row.getCell(colNum++), Boolean.class, info::setNeverCapture);
		parseCell(row.getCell(colNum++), Boolean.class, info::setNukeImmune);
		parseCell(row.getCell(colNum++), Boolean.class, info::setPrereqReligion);
		parseCell(row.getCell(colNum++), Boolean.class, info::setCenterInCity);
		parseCell(row.getCell(colNum++), Boolean.class, info::setSlaveMarket);
		parseCell(row.getCell(colNum++), Boolean.class, info::setForceDisableStarSigns);
		parseCell(row.getCell(colNum++), Boolean.class, info::setStarSignGoodOnly);
		parseCell(row.getCell(colNum++), Integer.class, info::setStarSignMitigateChangePercent);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalStarSignMitigateChangePercent);
		parseCell(row.getCell(colNum++), Integer.class, info::setStarSignScaleChangePercent);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalStarSignScaleChangePercent);
		parseCell(row.getCell(colNum++), Integer.class, info::setAIWeight);
		parseCell(row.getCell(colNum++), Integer.class, info::setCost);
		parseCell(row.getCell(colNum++), Integer.class, info::setHurryCostModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setAdvancedStartCost);
		parseCell(row.getCell(colNum++), Integer.class, info::setAdvancedStartCostIncrease);
		parseCell(row.getCell(colNum++), Integer.class, info::setExtraBarbarianCostChange);
		parseCell(row.getCell(colNum++), Integer.class, info::setBarbarianConversionCostModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinAreaSize);
		parseCell(row.getCell(colNum++), Integer.class, info::setConquestProb);
		parseCell(row.getCell(colNum++), Integer.class, info::setCitiesPrereq);
		parseCell(row.getCell(colNum++), Integer.class, info::setTeamsPrereq);
		parseCell(row.getCell(colNum++), Integer.class, info::setLevelPrereq);
		parseCell(row.getCell(colNum++), Integer.class, info::setMinLatitude);
		parseCell(row.getCell(colNum++), Integer.class, info::setMaxLatitude);
		parseCell(row.getCell(colNum++), Integer.class, info::setWorkableRadius);
		parseCell(row.getCell(colNum++), Integer.class, info::setGreatPeopleRateModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGreatGeneralRateModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setDomesticGreatGeneralRateModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalGreatPeopleRateModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setAnarchyModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGoldenAgeModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalHurryModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setExperience);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalExperience);
		parseCell(row.getCell(colNum++), Integer.class, info::setFoodKept);
		parseCell(row.getCell(colNum++), Integer.class, info::setAirlift);
		parseCell(row.getCell(colNum++), Integer.class, info::setAirModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setAirUnitCapacity);
		parseCell(row.getCell(colNum++), Integer.class, info::setNukeModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setNukeExplosionRand);
		parseCell(row.getCell(colNum++), Integer.class, info::setFreeSpecialist);
		parseCell(row.getCell(colNum++), Integer.class, info::setAreaFreeSpecialist);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalFreeSpecialist);
		parseCell(row.getCell(colNum++), Integer.class, info::setMaintenanceModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setWarWearinessModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalWarWearinessModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setEnemyWarWearinessModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setHealRateChange);
		parseCell(row.getCell(colNum++), Integer.class, info::setHealth);
		parseCell(row.getCell(colNum++), Integer.class, info::setAreaHealth);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalHealth);
		parseCell(row.getCell(colNum++), Integer.class, info::setHappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setAreaHappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalHappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setStateReligionHappiness);
		parseCell(row.getCell(colNum++), Integer.class, info::setWorkerSpeedModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setMilitaryProductionModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setSpaceProductionModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalSpaceProductionModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setTradeRoutes);
		parseCell(row.getCell(colNum++), Integer.class, info::setCoastalTradeRoutes);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalTradeRoutes);
		parseCell(row.getCell(colNum++), Integer.class, info::setTradeRouteModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setForeignTradeRouteModifier);
		parseCell(row.getCell(colNum++), Integer.class, info::setGlobalPopulationChange);
		parseCell(row.getCell(colNum++), Integer.class, info::setFreeTechs);
		parseCell(row.getCell(colNum++), Integer.class, info::setDefense);
		parseCell(row.getCell(colNum++), Integer.class, info::setObsoleteDefence);
		parseCell(row.getCell(colNum++), Integer.class, info::setBombardDefense);
		parseCell(row.getCell(colNum++), Integer.class, info::setAllCityDefense);
		parseCell(row.getCell(colNum++), Integer.class, info::setEspionageDefense);
		parseCell(row.getCell(colNum++), Integer.class, info::setAsset);
		parseCell(row.getCell(colNum++), Integer.class, info::setPower);
		parseCell(row.getCell(colNum++), Float.class, info::setVisibilityPriority);
		parseListCell(row.getCell(colNum++), Integer.class, info::addSeaPlotYieldChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addRiverPlotYieldChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addGlobalSeaPlotYieldChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addYieldChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addYieldModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addPowerYieldModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addAreaYieldModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addGlobalYieldModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addObsoleteSafeCommerceChange);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceChangeDoubleTime);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addGlobalCommerceModifier);
		parseListCell(row.getCell(colNum++), Integer.class, info::addSpecialistExtraCommerce);
		parseListCell(row.getCell(colNum++), Integer.class, info::addStateReligionCommerce);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceHappiness);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addReligionChange);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addSpecialistCount);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addFreeSpecialistCount);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceFlexible);
		parseListCell(row.getCell(colNum++), Integer.class, info::addCommerceChangeOriginalOwner);
		parseCell(row.getCell(colNum++), String.class, info::setConstructSound);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addBonusHealthChange);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addBonusHappinessChange);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addBonusProductionModifier);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addUnitCombatFreeExperience);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addDomainFreeExperience);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addDomainProductionModifier);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addBuildingClassProductionModifier);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addBuildingHappinessChange);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addPrereqNumOfBuildingClass);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqAndBuildingClass);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqOrBuildingClass);
		parseListCell(row.getCell(colNum++), String.class, info::addPrereqNotBuildingClass);
		parseListCell(row.getCell(colNum++), String.class, info::addReplacedByBuildingClass);
		parseMapListCell(row.getCell(colNum++), String.class, Integer.class, info::addSpecialistYieldChange);
		parseMapListCell(row.getCell(colNum++), String.class, Integer.class, info::addBonusYieldModifier);
		parseMapListCell(row.getCell(colNum++), String.class, Integer.class, info::addBonusYieldChange);
		parseMapListCell(row.getCell(colNum++), String.class, Integer.class, info::addVicinityBonusYieldChange);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addImprovementFreeSpecialist);
		parsePairsCell(row.getCell(colNum++), String.class, Integer.class, info::addFlavor);
		parseCell(row.getCell(colNum++), String.class, info::setHotKey);
		parseCell(row.getCell(colNum++), Boolean.class, info::setAltDown);
		parseCell(row.getCell(colNum++), Boolean.class, info::setShiftDown);
		parseCell(row.getCell(colNum++), Boolean.class, info::setCtrlDown);
		parseCell(row.getCell(colNum++), Integer.class, info::setHotKeyPriority);
		parseCell(row.getCell(colNum++), Integer.class, info::setOrderPriority);
		parseCell(row.getCell(colNum++), Boolean.class, info::setGraphicalOnly);

		return info;
	}

	@Override
	public String getListSheetName() {
		return IBuildingWorkbook.SHEETNAME_LIST;
	}

}
