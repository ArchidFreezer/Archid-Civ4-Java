package org.archid.civ4.info.building;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractExporter;
import org.archid.civ4.info.EInfo;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.building.IBuildingWorkbook.SheetHeaders;

public class BuildingExporter extends AbstractExporter<IInfos<IBuildingInfo>, IBuildingInfo>{

	/** Logging facility */
	static Logger log = Logger.getLogger(BuildingExporter.class.getName());
	
	public BuildingExporter(EInfo infoEnum) {
		super(infoEnum);
	}

	@Override
	public List<String> getHeaders() {
		List<String> headers = new ArrayList<String>();
		for (SheetHeaders header: SheetHeaders.values()) {
			headers.add(header.toString());
		}
		return headers;
	}

	@Override
	protected void populateRow(Row row, IBuildingInfo info) {
		int maxHeight = 1;
		int colNum = 0;
		addSingleCell(row.createCell(colNum++), info.getBuildingClass());
		addSingleCell(row.createCell(colNum++), info.getType());
		addSingleCell(row.createCell(colNum++), info.getSpecialBuildingType());
		addSingleCell(row.createCell(colNum++), info.getDescription());
		addSingleCell(row.createCell(colNum++), info.getCivilopedia());
		addSingleCell(row.createCell(colNum++), info.getStrategy());
		addSingleCell(row.createCell(colNum++), info.getHelp());
		addSingleCell(row.createCell(colNum++), info.getAdvisor());
		addSingleCell(row.createCell(colNum++), info.getArtDefineTag());
		addSingleCell(row.createCell(colNum++), info.getMovieDefineTag());
		addSingleCell(row.createCell(colNum++), info.isAutoBuild());
		addSingleCell(row.createCell(colNum++), info.getHolyCity());
		addSingleCell(row.createCell(colNum++), info.getReligionType());
		addSingleCell(row.createCell(colNum++), info.getStateReligion());
		addSingleCell(row.createCell(colNum++), info.isStateReligion());
		addSingleCell(row.createCell(colNum++), info.getPrereqReligion());
		addSingleCell(row.createCell(colNum++), info.getPrereqCorporation());
		addSingleCell(row.createCell(colNum++), info.getFoundsCorporation());
		addSingleCell(row.createCell(colNum++), info.getGlobalReligionCommerce());
		addSingleCell(row.createCell(colNum++), info.getGlobalCorporationCommerce());
		addSingleCell(row.createCell(colNum++), info.getVictoryPrereq());
		addSingleCell(row.createCell(colNum++), info.getFreeStartEra());
		addSingleCell(row.createCell(colNum++), info.getMaxStartEra());
		addSingleCell(row.createCell(colNum++), info.getObsoleteTech());
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqAndTechs(), maxHeight);		
		addSingleCell(row.createCell(colNum++), info.getPrereqBonus());
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqOrBonuses(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqAndCivics(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqOrCivics(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqAndTerrains(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqOrTerrains(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqVicinityAndBonus(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqVicinityOrBonus(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqVicinityImprovements(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqVicinityFeatures(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqWorldViews(), maxHeight);
		addSingleCell(row.createCell(colNum++), info.getMinPopulation());
		addSingleCell(row.createCell(colNum++), info.getMinCultureLevel());
		addSingleCell(row.createCell(colNum++), info.isPrereqPower());
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getProductionTraits(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getHappinessTraits(), maxHeight);
		addSingleCell(row.createCell(colNum++), info.getNoBonus());
		addSingleCell(row.createCell(colNum++), info.getPowerBonus());
		addSingleCell(row.createCell(colNum++), info.getFreeBonus());
		addSingleCell(row.createCell(colNum++), info.getNumFreeBonuses());
		addSingleCell(row.createCell(colNum++), info.getFreeBuilding());
		addSingleCell(row.createCell(colNum++), info.getFreePromotion());
		addSingleCell(row.createCell(colNum++), info.getCivicOption());
		addSingleCell(row.createCell(colNum++), info.getGreatPeopleUnitClass());
		addSingleCell(row.createCell(colNum++), info.getGreatPeopleRateChange());
		addSingleCell(row.createCell(colNum++), info.getHurryAngerModifier());
		addSingleCell(row.createCell(colNum++), info.isBorderObstacle());
		addSingleCell(row.createCell(colNum++), info.isTeamShare());
		addSingleCell(row.createCell(colNum++), info.isWater());
		addSingleCell(row.createCell(colNum++), info.isRiver());
		addSingleCell(row.createCell(colNum++), info.isPower());
		addSingleCell(row.createCell(colNum++), info.isDirtyPower());
		addSingleCell(row.createCell(colNum++), info.isAreaCleanPower());
		addSingleCell(row.createCell(colNum++), info.getDiploVoteType());
		addSingleCell(row.createCell(colNum++), info.isForceTeamVoteEligible());
		addSingleCell(row.createCell(colNum++), info.isCapital());
		addSingleCell(row.createCell(colNum++), info.isGovernmentCenter());
		addSingleCell(row.createCell(colNum++), info.isGoldenAge());
		addSingleCell(row.createCell(colNum++), info.isAllowsNukes());
		addSingleCell(row.createCell(colNum++), info.isMapCentering());
		addSingleCell(row.createCell(colNum++), info.isNoUnhappiness());
		addSingleCell(row.createCell(colNum++), info.getUnhealthyPopulationModifier());
		addSingleCell(row.createCell(colNum++), info.isBuildingOnlyHealthy());
		addSingleCell(row.createCell(colNum++), info.isNeverCapture());
		addSingleCell(row.createCell(colNum++), info.isNukeImmune());
		addSingleCell(row.createCell(colNum++), info.isPrereqReligion());
		addSingleCell(row.createCell(colNum++), info.isCenterInCity());
		addSingleCell(row.createCell(colNum++), info.isSlaveMarket());
		addSingleCell(row.createCell(colNum++), info.isForceDisableStarSigns());
		addSingleCell(row.createCell(colNum++), info.isStarSignGoodOnly());
		addSingleCell(row.createCell(colNum++), info.getStarSignMitigateChangePercent());
		addSingleCell(row.createCell(colNum++), info.getGlobalStarSignMitigateChangePercent());
		addSingleCell(row.createCell(colNum++), info.getStarSignScaleChangePercent());
		addSingleCell(row.createCell(colNum++), info.getGlobalStarSignScaleChangePercent());
		addSingleCell(row.createCell(colNum++), info.getAIWeight());
		addSingleCell(row.createCell(colNum++), info.getCost());
		addSingleCell(row.createCell(colNum++), info.getHurryCostModifier());
		addSingleCell(row.createCell(colNum++), info.getAdvancedStartCost());
		addSingleCell(row.createCell(colNum++), info.getAdvancedStartCostIncrease());
		addSingleCell(row.createCell(colNum++), info.getMinAreaSize());
		addSingleCell(row.createCell(colNum++), info.getConquestProb());
		addSingleCell(row.createCell(colNum++), info.getCitiesPrereq());
		addSingleCell(row.createCell(colNum++), info.getTeamsPrereq());
		addSingleCell(row.createCell(colNum++), info.getLevelPrereq());
		addSingleCell(row.createCell(colNum++), info.getMinLatitude());
		addSingleCell(row.createCell(colNum++), info.getMaxLatitude());
		addSingleCell(row.createCell(colNum++), info.getWorkableRadius());
		addSingleCell(row.createCell(colNum++), info.getGreatPeopleRateModifier());
		addSingleCell(row.createCell(colNum++), info.getGreatGeneralRateModifier());
		addSingleCell(row.createCell(colNum++), info.getDomesticGreatGeneralRateModifier());
		addSingleCell(row.createCell(colNum++), info.getGlobalGreatPeopleRateModifier());
		addSingleCell(row.createCell(colNum++), info.getAnarchyModifier());
		addSingleCell(row.createCell(colNum++), info.getGoldenAgeModifier());
		addSingleCell(row.createCell(colNum++), info.getGlobalHurryModifier());
		addSingleCell(row.createCell(colNum++), info.getExperience());
		addSingleCell(row.createCell(colNum++), info.getGlobalExperience());
		addSingleCell(row.createCell(colNum++), info.getFoodKept());
		addSingleCell(row.createCell(colNum++), info.getAirlift());
		addSingleCell(row.createCell(colNum++), info.getAirModifier());
		addSingleCell(row.createCell(colNum++), info.getAirUnitCapacity());
		addSingleCell(row.createCell(colNum++), info.getNukeModifier());
		addSingleCell(row.createCell(colNum++), info.getNukeExplosionRand());
		addSingleCell(row.createCell(colNum++), info.getFreeSpecialist());
		addSingleCell(row.createCell(colNum++), info.getAreaFreeSpecialist());
		addSingleCell(row.createCell(colNum++), info.getGlobalFreeSpecialist());
		addSingleCell(row.createCell(colNum++), info.getMaintenanceModifier());
		addSingleCell(row.createCell(colNum++), info.getWarWearinessModifier());
		addSingleCell(row.createCell(colNum++), info.getGlobalWarWearinessModifier());
		addSingleCell(row.createCell(colNum++), info.getEnemyWarWearinessModifier());
		addSingleCell(row.createCell(colNum++), info.getHealRateChange());
		addSingleCell(row.createCell(colNum++), info.getHealth());
		addSingleCell(row.createCell(colNum++), info.getAreaHealth());
		addSingleCell(row.createCell(colNum++), info.getGlobalHealth());
		addSingleCell(row.createCell(colNum++), info.getHappiness());
		addSingleCell(row.createCell(colNum++), info.getAreaHappiness());
		addSingleCell(row.createCell(colNum++), info.getGlobalHappiness());
		addSingleCell(row.createCell(colNum++), info.getStateReligionHappiness());
		addSingleCell(row.createCell(colNum++), info.getWorkerSpeedModifier());
		addSingleCell(row.createCell(colNum++), info.getMilitaryProductionModifier());
		addSingleCell(row.createCell(colNum++), info.getSpaceProductionModifier());
		addSingleCell(row.createCell(colNum++), info.getGlobalSpaceProductionModifier());
		addSingleCell(row.createCell(colNum++), info.getTradeRoutes());
		addSingleCell(row.createCell(colNum++), info.getCoastalTradeRoutes());
		addSingleCell(row.createCell(colNum++), info.getGlobalTradeRoutes());
		addSingleCell(row.createCell(colNum++), info.getTradeRouteModifier());
		addSingleCell(row.createCell(colNum++), info.getForeignTradeRouteModifier());
		addSingleCell(row.createCell(colNum++), info.getGlobalPopulationChange());
		addSingleCell(row.createCell(colNum++), info.getFreeTechs());
		addSingleCell(row.createCell(colNum++), info.getDefense());
		addSingleCell(row.createCell(colNum++), info.getBombardDefense());
		addSingleCell(row.createCell(colNum++), info.getAllCityDefense());
		addSingleCell(row.createCell(colNum++), info.getEspionageDefense());
		addSingleCell(row.createCell(colNum++), info.getAsset());
		addSingleCell(row.createCell(colNum++), info.getPower());
		addSingleCell(row.createCell(colNum++), info.getVisibilityPriority());
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getSeaPlotYieldChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getRiverPlotYieldChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getGlobalSeaPlotYieldChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getYieldChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getYieldModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPowerYieldModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getAreaYieldModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getGlobalYieldModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getObsoleteSafeCommerceChanges(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceChangeDoubleTimes(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getGlobalCommerceModifiers(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getSpecialistExtraCommerces(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getStateReligionCommerces(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceHappinesses(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getReligionChanges(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getSpecialistCounts(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getFreeSpecialistCounts(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceFlexibles(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getCommerceChangeOriginalOwners(), maxHeight);
		addSingleCell(row.createCell(colNum++), info.getConstructSound());
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getBonusHealthChanges(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getBonusHappinessChanges(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getBonusProductionModifiers(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getUnitCombatFreeExperiences(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getDomainFreeExperiences(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getDomainProductionModifiers(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getBuildingHappinessChanges(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getPrereqNumOfBuildingClasses(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqAndBuildingClasses(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqOrBuildingClasses(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getPrereqNotBuildingClasses(), maxHeight);
		maxHeight = addRepeatingCell(row.createCell(colNum++), info.getReplacedByBuildingClasses(), maxHeight);
		maxHeight = addMapListCell(row.createCell(colNum++), info.getSpecialistYieldChanges(), maxHeight);
		maxHeight = addMapListCell(row.createCell(colNum++), info.getBonusYieldModifiers(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getImprovementFreeSpecialists(), maxHeight);
		maxHeight = addRepeatingPairCell(row.createCell(colNum++), info.getFlavors(), maxHeight);
		addSingleCell(row.createCell(colNum++), info.getHotKey());
		addSingleCell(row.createCell(colNum++), info.isAltDown());
		addSingleCell(row.createCell(colNum++), info.isShiftDown());
		addSingleCell(row.createCell(colNum++), info.isCtrlDown());
		addSingleCell(row.createCell(colNum++), info.getHotKeyPriority());
		addSingleCell(row.createCell(colNum++), info.getOrderPriority());

		row.setHeightInPoints(maxHeight * row.getSheet().getDefaultRowHeightInPoints());
		
	}

	@Override
	protected int getNumCols() {
		return IBuildingWorkbook.SheetHeaders.values().length;
	}

	@Override
	protected String getInfoListSheetName() {
		return IBuildingWorkbook.SHEETNAME_LIST;
	}
	
}