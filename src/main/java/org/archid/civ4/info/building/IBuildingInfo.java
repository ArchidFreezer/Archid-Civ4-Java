package org.archid.civ4.info.building;

import java.util.List;
import java.util.Map;

import org.archid.civ4.info.IInfo;
import org.archid.utils.IPair;

public interface IBuildingInfo extends IInfo {

	String getAdvisor();

	void setAdvisor(String advisor);

	String getArtDefineTag();

	void setArtDefineTag(String artDefineTag);

	String getBuildingClass();

	void setBuildingClass(String buildingClass);

	String getCivicOption();

	void setCivicOption(String civicOption);

	String getCivilopedia();

	void setCivilopedia(String civilopedia);

	String getConstructSound();

	void setConstructSound(String constructSound);

	String getDescription();

	void setDescription(String description);

	String getDiploVoteType();

	void setDiploVoteType(String diploVoteType);

	String getFoundsCorporation();

	void setFoundsCorporation(String foundsCorporation);

	String getFreeBonus();

	void setFreeBonus(String freeBonus);

	String getFreeBuilding();

	void setFreeBuilding(String freeBuilding);

	String getFreePromotion();

	void setFreePromotion(String freePromotion);

	String getFreeStartEra();

	void setFreeStartEra(String freeStartEra);

	String getGlobalCorporationCommerce();

	void setGlobalCorporationCommerce(String globalCorporationCommerce);

	String getGlobalReligionCommerce();

	void setGlobalReligionCommerce(String globalReligionCommerce);

	String getGreatPeopleUnitClass();

	void setGreatPeopleUnitClass(String greatPeopleUnitClass);

	String getHelp();

	void setHelp(String help);

	String getHolyCity();

	void setHolyCity(String holyCity);

	String getHotKey();

	void setHotKey(String hotKey);

	String getMaxStartEra();

	void setMaxStartEra(String maxStartEra);

	String getMinCultureLevel();

	void setMinCultureLevel(String minCultureLevel);

	String getMovieDefineTag();

	void setMovieDefineTag(String movieDefineTag);

	String getNoBonus();

	void setNoBonus(String noBonus);

	String getObsoleteTech();

	void setObsoleteTech(String obsoleteTech);

	String getPowerBonus();

	void setPowerBonus(String powerBonus);

	String getPrereqCorporation();

	void setPrereqCorporation(String prereqCorporation);

	String getPrereqReligion();

	void setPrereqReligion(String prereqReligion);

	String getReligionType();

	void setReligionType(String religionType);

	String getSpecialBuildingType();

	void setSpecialBuildingType(String specialBuildingType);

	String getStateReligion();

	void setStateReligion(String stateReligion);

	String getStrategy();

	void setStrategy(String strategy);

	String getType();

	void setType(String type);

	String getVictoryPrereq();

	void setVictoryPrereq(String victoryPrereq);

	boolean isAllowsNukes();

	void setAllowsNukes(boolean isAllowsNukes);

	boolean isAltDown();

	void setAltDown(boolean isAltDown);

	boolean isAreaCleanPower();

	void setAreaCleanPower(boolean isAreaCleanPower);

	boolean isAutoBuild();

	void setAutoBuild(boolean isAutoBuild);

	boolean isBorderObstacle();

	void setBorderObstacle(boolean isBorderObstacle);

	boolean isBuildingOnlyHealthy();

	void setBuildingOnlyHealthy(boolean isBuildingOnlyHealthy);

	boolean isCapital();

	void setCapital(boolean isCapital);

	boolean isCenterInCity();

	void setCenterInCity(boolean isCenterInCity);

	boolean isCtrlDown();

	void setCtrlDown(boolean isCtrlDown);

	boolean isDirtyPower();

	void setDirtyPower(boolean isDirtyPower);

	boolean isForceDisableStarSigns();

	void setForceDisableStarSigns(boolean isForceDisableStarSigns);

	boolean isForceTeamVoteEligible();

	void setForceTeamVoteEligible(boolean isForceTeamVoteEligible);

	boolean isGoldenAge();

	void setGoldenAge(boolean isGoldenAge);

	boolean isGovernmentCenter();

	void setGovernmentCenter(boolean isGovernmentCenter);

	boolean isMapCentering();

	void setMapCentering(boolean isMapCentering);

	boolean isNeverCapture();

	void setNeverCapture(boolean isNeverCapture);

	boolean isNoUnhappiness();

	void setNoUnhappiness(boolean isNoUnhappiness);

	boolean isNukeImmune();

	void setNukeImmune(boolean isNukeImmune);

	boolean isPower();

	void setPower(boolean isPower);

	boolean isPrereqPower();

	void setPrereqPower(boolean isPrereqPower);

	boolean isPrereqReligion();

	void setPrereqReligion(boolean isPrereqReligion);

	boolean isRiver();

	void setRiver(boolean isRiver);

	boolean isShiftDown();

	void setShiftDown(boolean isShiftDown);

	boolean isSlaveMarket();

	void setSlaveMarket(boolean isSlaveMarket);

	boolean isStarSignGoodOnly();

	void setStarSignGoodOnly(boolean isStarSignGoodOnly);

	boolean isStateReligion();

	void setStateReligion(boolean isStateReligion);

	boolean isTeamShare();

	void setTeamShare(boolean isTeamShare);

	boolean isWater();

	void setWater(boolean isWater);
	
	boolean isGraphicalOnly();
	void setGraphicalOnly(boolean isGraphicalOnly);

	float getVisibilityPriority();

	void setVisibilityPriority(float visibilityPriority);

	int getAIWeight();

	void setAIWeight(int aIWeight);

	int getAdvancedStartCost();

	void setAdvancedStartCost(int advancedStartCost);

	int getAdvancedStartCostIncrease();

	void setAdvancedStartCostIncrease(int advancedStartCostIncrease);

	int getAirModifier();

	void setAirModifier(int airModifier);

	int getAirUnitCapacity();

	void setAirUnitCapacity(int airUnitCapacity);

	int getAirlift();

	void setAirlift(int airlift);

	int getAllCityDefense();

	void setAllCityDefense(int allCityDefense);

	int getAnarchyModifier();

	void setAnarchyModifier(int anarchyModifier);

	int getAreaFreeSpecialist();

	void setAreaFreeSpecialist(int areaFreeSpecialist);

	int getAreaHappiness();

	void setAreaHappiness(int areaHappiness);

	int getAreaHealth();

	void setAreaHealth(int areaHealth);

	int getAsset();

	void setAsset(int asset);

	int getBombardDefense();

	void setBombardDefense(int bombardDefense);

	int getCitiesPrereq();

	void setCitiesPrereq(int citiesPrereq);

	int getCoastalTradeRoutes();

	void setCoastalTradeRoutes(int coastalTradeRoutes);

	int getConquestProb();

	void setConquestProb(int conquestProb);

	int getCost();

	void setCost(int cost);

	int getDefense();

	void setDefense(int defense);

	int getDomesticGreatGeneralRateModifier();

	void setDomesticGreatGeneralRateModifier(int domesticGreatGeneralRateModifier);

	int getEnemyWarWearinessModifier();

	void setEnemyWarWearinessModifier(int enemyWarWearinessModifier);

	int getEspionageDefense();

	void setEspionageDefense(int espionageDefense);

	int getExperience();

	void setExperience(int experience);

	int getFoodKept();

	void setFoodKept(int foodKept);

	int getForeignTradeRouteModifier();

	void setForeignTradeRouteModifier(int foreignTradeRouteModifier);

	int getFreeSpecialist();

	void setFreeSpecialist(int freeSpecialist);

	int getFreeTechs();

	void setFreeTechs(int freeTechs);

	int getGlobalExperience();

	void setGlobalExperience(int globalExperience);

	int getGlobalFreeSpecialist();

	void setGlobalFreeSpecialist(int globalFreeSpecialist);

	int getGlobalGreatPeopleRateModifier();

	void setGlobalGreatPeopleRateModifier(int globalGreatPeopleRateModifier);

	int getGlobalHappiness();

	void setGlobalHappiness(int globalHappiness);

	int getGlobalHealth();

	void setGlobalHealth(int globalHealth);

	int getGlobalHurryModifier();

	void setGlobalHurryModifier(int globalHurryModifier);

	int getGlobalPopulationChange();

	void setGlobalPopulationChange(int globalPopulationChange);

	int getGlobalSpaceProductionModifier();

	void setGlobalSpaceProductionModifier(int globalSpaceProductionModifier);

	int getGlobalStarSignMitigateChangePercent();

	void setGlobalStarSignMitigateChangePercent(int globalStarSignMitigateChangePercent);

	int getGlobalStarSignScaleChangePercent();

	void setGlobalStarSignScaleChangePercent(int globalStarSignScaleChangePercent);

	int getGlobalTradeRoutes();

	void setGlobalTradeRoutes(int globalTradeRoutes);

	int getGlobalWarWearinessModifier();

	void setGlobalWarWearinessModifier(int globalWarWearinessModifier);

	int getGoldenAgeModifier();

	void setGoldenAgeModifier(int goldenAgeModifier);

	int getGreatGeneralRateModifier();

	void setGreatGeneralRateModifier(int greatGeneralRateModifier);

	int getGreatPeopleRateChange();

	void setGreatPeopleRateChange(int greatPeopleRateChange);

	int getGreatPeopleRateModifier();

	void setGreatPeopleRateModifier(int greatPeopleRateModifier);

	int getHappiness();

	void setHappiness(int happiness);

	int getHealRateChange();

	void setHealRateChange(int healRateChange);

	int getHealth();

	void setHealth(int health);

	int getHotKeyPriority();

	void setHotKeyPriority(int hotKeyPriority);

	int getHurryAngerModifier();

	void setHurryAngerModifier(int hurryAngerModifier);

	int getHurryCostModifier();

	void setHurryCostModifier(int hurryCostModifier);

	int getLevelPrereq();

	void setLevelPrereq(int levelPrereq);

	int getMaintenanceModifier();

	void setMaintenanceModifier(int maintenanceModifier);

	int getMaxLatitude();

	void setMaxLatitude(int maxLatitude);

	int getMilitaryProductionModifier();

	void setMilitaryProductionModifier(int militaryProductionModifier);

	int getMinAreaSize();

	void setMinAreaSize(int minAreaSize);

	int getMinLatitude();

	void setMinLatitude(int minLatitude);

	int getMinPopulation();

	void setMinPopulation(int minPopulation);

	int getNukeExplosionRand();

	void setNukeExplosionRand(int nukeExplosionRand);

	int getNukeModifier();

	void setNukeModifier(int nukeModifier);

	int getNumFreeBonuses();

	void setNumFreeBonuses(int numFreeBonuses);

	int getObsoleteDefence();

	void setObsoleteDefence(int defence);

	int getOrderPriority();

	void setOrderPriority(int orderPriority);

	int getPower();

	void setPower(int power);

	int getSpaceProductionModifier();

	void setSpaceProductionModifier(int spaceProductionModifier);

	int getStarSignMitigateChangePercent();

	void setStarSignMitigateChangePercent(int starSignMitigateChangePercent);

	int getStarSignScaleChangePercent();

	void setStarSignScaleChangePercent(int starSignScaleChangePercent);

	int getStateReligionHappiness();

	void setStateReligionHappiness(int stateReligionHappiness);

	int getTeamsPrereq();

	void setTeamsPrereq(int teamsPrereq);

	int getTradeRouteModifier();

	void setTradeRouteModifier(int tradeRouteModifier);

	int getTradeRoutes();

	void setTradeRoutes(int tradeRoutes);

	int getUnhealthyPopulationModifier();

	void setUnhealthyPopulationModifier(int unhealthyPopulationModifier);

	int getWarWearinessModifier();

	void setWarWearinessModifier(int warWearinessModifier);

	int getWorkableRadius();

	void setWorkableRadius(int workableRadius);

	int getWorkerSpeedModifier();

	void setWorkerSpeedModifier(int workerSpeedModifier);

	List<Integer> getAreaYieldModifiers();

	void addAreaYieldModifier(Integer areaYieldModifier);

	List<Integer> getCommerceChangeDoubleTimes();

	void addCommerceChangeDoubleTime(Integer commerceChangeDoubleTime);

	List<Integer> getCommerceChangeOriginalOwners();

	void addCommerceChangeOriginalOwner(Integer commerceChangeOriginalOwner);

	List<Integer> getCommerceChanges();

	void addCommerceChange(Integer commerceChange);

	List<Integer> getCommerceFlexibles();

	void addCommerceFlexible(Integer commerceFlexible);

	List<Integer> getCommerceHappinesses();

	void addCommerceHappiness(Integer commerceHappiness);

	List<Integer> getCommerceModifiers();

	void addCommerceModifier(Integer commerceModifier);

	public List<IPair<String, Integer>> getFlavors();
	
	public void addFlavor(IPair<String, Integer> flavor);

	List<Integer> getGlobalCommerceModifiers();

	void addGlobalCommerceModifier(Integer globalCommerceModifier);

	List<Integer> getGlobalSeaPlotYieldChanges();

	void addGlobalSeaPlotYieldChange(Integer globalSeaPlotYieldChange);

	List<Integer> getGlobalYieldModifiers();

	void addGlobalYieldModifier(Integer globalYieldModifier);

	List<Integer> getObsoleteSafeCommerceChanges();

	void addObsoleteSafeCommerceChange(Integer obsoleteSafeCommerceChange);

	List<Integer> getPowerYieldModifiers();

	void addPowerYieldModifier(Integer powerYieldModifier);

	List<String> getPrereqAndBuildingClasses();

	void addPrereqAndBuildingClass(String prereqAndBuildingClass);

	List<String> getPrereqAndCivics();

	void addPrereqAndCivic(String prereqAndCivic);

	List<String> getPrereqAndTechs();

	void addPrereqAndTech(String prereqAndTech);

	List<String> getPrereqAndTerrains();

	void addPrereqAndTerrain(String prereqAndTerrain);

	String getPrereqBonus();

	void setPrereqBonus(String prereqBonus);

	List<String> getPrereqNotBuildingClasses();

	void addPrereqNotBuildingClass(String prereqNotBuildingClass);

	List<String> getPrereqOrBonuses();

	void addPrereqOrBonus(String prereqOrBonus);

	List<String> getPrereqOrBuildingClasses();

	void addPrereqOrBuildingClass(String prereqOrBuildingClass);

	List<String> getPrereqOrCivics();

	void addPrereqOrCivic(String prereqOrCivic);

	List<String> getPrereqOrTerrains();

	void addPrereqOrTerrain(String prereqOrTerrain);

	List<String> getPrereqVicinityAndBonus();

	void addPrereqVicinityAndBonus(String prereqVicinityAndBonus);

	List<String> getPrereqVicinityFeatures();

	void addPrereqVicinityFeature(String prereqVicinityFeature);

	List<String> getPrereqVicinityImprovements();

	void addPrereqVicinityImprovement(String prereqVicinityImprovement);

	List<String> getPrereqVicinityOrBonus();

	void addPrereqVicinityOrBonus(String prereqVicinityOrBonus);

	List<String> getPrereqWorldViews();

	void addPrereqWorldView(String prereqWorldView);

	List<String> getReplacedByBuildingClasses();

	void addReplacedByBuildingClass(String replacedByBuildingClass);

	List<Integer> getRiverPlotYieldChanges();

	void addRiverPlotYieldChange(Integer riverPlotYieldChange);

	List<Integer> getSeaPlotYieldChanges();

	void addSeaPlotYieldChange(Integer seaPlotYieldChange);

	List<Integer> getSpecialistExtraCommerces();

	void addSpecialistExtraCommerce(Integer specialistExtraCommerce);

	List<Integer> getStateReligionCommerces();

	void addStateReligionCommerce(Integer stateReligionCommerce);

	List<Integer> getYieldChanges();

	void addYieldChange(Integer yieldChange);

	List<Integer> getYieldModifiers();

	void addYieldModifier(Integer yieldModifier);

	List<IPair<String, Integer>> getBonusHappinessChanges();

	void addBonusHappinessChange(IPair<String, Integer> bonusHappinessChange);

	List<IPair<String, Integer>> getBonusHealthChanges();

	void addBonusHealthChange(IPair<String, Integer> bonusHealthChange);

	List<IPair<String, Integer>> getBonusProductionModifiers();

	void addBonusProductionModifier(IPair<String, Integer> bonusProductionModifier);

	List<IPair<String, Integer>> getBuildingHappinessChanges();

	void addBuildingHappinessChange(IPair<String, Integer> buildingHappinessChange);

	List<IPair<String, Integer>> getDomainFreeExperiences();

	void addDomainFreeExperience(IPair<String, Integer> domainFreeExperience);

	List<IPair<String, Integer>> getDomainProductionModifiers();

	void addDomainProductionModifier(IPair<String, Integer> domainProductionModifier);

	List<IPair<String, Integer>> getFreeSpecialistCounts();

	void addFreeSpecialistCount(IPair<String, Integer> freeSpecialistCount);

	List<IPair<String, Integer>> getHappinessTraits();

	void addHappinessTrait(IPair<String, Integer> happinessTrait);

	List<IPair<String, Integer>> getImprovementFreeSpecialists();

	void addImprovementFreeSpecialist(IPair<String, Integer> improvementFreeSpecialist);

	List<IPair<String, Integer>> getPrereqNumOfBuildingClasses();

	void addPrereqNumOfBuildingClass(IPair<String, Integer> prereqNumOfBuildingClass);

	List<IPair<String, Integer>> getProductionTraits();

	void addProductionTrait(IPair<String, Integer> productionTrait);

	List<IPair<String, Integer>> getReligionChanges();

	void addReligionChange(IPair<String, Integer> religionChange);

	List<IPair<String, Integer>> getSpecialistCounts();

	void addSpecialistCount(IPair<String, Integer> specialistCount);

	List<IPair<String, Integer>> getUnitCombatFreeExperiences();

	void addUnitCombatFreeExperience(IPair<String, Integer> unitCombatFreeExperience);

	Map<String, List<Integer>> getBonusYieldModifiers();

	void addBonusYieldModifier(String bonus, List<Integer> yieldModifiers);

	Map<String, List<Integer>> getSpecialistYieldChanges();

	void addSpecialistYieldChange(String specialist, List<Integer> yieldChanges);

	Map<String, List<Integer>> getVicinityBonusYieldChanges();
	void addVicinityBonusYieldChange(String bonus, List<Integer> yieldChanges);
	
	Integer getExtraBarbarianCostChange();
	void setExtraBarbarianCostChange(Integer extraBarbarianCostChange);
	
	Integer getBarbarianConversionCostModifier();
	void setBarbarianConversionCostModifier(Integer barbarianConversionCostModifier);

}