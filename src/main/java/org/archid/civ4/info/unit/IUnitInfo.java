package org.archid.civ4.info.unit;

import java.util.List;

import org.archid.civ4.info.IInfo;
import org.archid.civ4.info.unit.UnitInfos.UnitMeshGroups;
import org.archid.utils.IPair;

public interface IUnitInfo  extends IInfo {

	String getAdvisor();

	void setAdvisor(String advisor);

	String getBonusType();

	void setBonusType(String bonusType);

	String getCapture();

	void setCapture(String capture);

	String getCivilopedia();

	void setCivilopedia(String civilopedia);

	String getUnitClass();

	void setUnitClass(String unitClass);

	String getCombatType();

	void setCombatType(String combatType);

	String getDefaultUnitAI();

	void setDefaultUnitAI(String defaultUnitAI);

	String getDescription();

	void setDescription(String description);

	String getDomain();

	void setDomain(String domain);

	String getDomainCargo();

	void setDomainCargo(String domainCargo);

	String getFormationType();

	void setFormationType(String formationType);

	String getHelp();

	void setHelp(String help);

	String getHolyCity();

	void setHolyCity(String holyCity);

	String getHotKey();

	void setHotKey(String hotKey);

	String getInvisibleType();

	void setInvisibleType(String invisibleType);

	String getLeaderPromotion();

	void setLeaderPromotion(String leaderPromotion);

	String getMinCultureLevel();

	void setMinCultureLevel(String minCultureLevel);

	String getObsoleteTech();

	void setObsoleteTech(String obsoleteTech);

	String getPrereqBuilding();

	void setPrereqBuilding(String prereqBuilding);

	String getPrereqCorporation();

	void setPrereqCorporation(String prereqCorporation);

	String getPrereqReligionType();

	void setPrereqReligionType(String prereqReligionType);

	String getReligionType();

	void setReligionType(String religionType);

	String getSlaveSpecialistType();

	void setSlaveSpecialistType(String slaveSpecialistType);

	String getSpecial();

	void setSpecial(String special);

	String getSpecialCargo();

	void setSpecialCargo(String specialCargo);

	String getStateReligion();

	void setStateReligion(String stateReligion);

	String getStrategy();

	void setStrategy(String strategy);

	String getUnitRangeType();

	void setUnitRangeType(String unitRangeType);

	int getAiWeight();

	void setAiWeight(int aiWeight);

	int getAdvancedStartCost();

	void setAdvancedStartCost(int advancedStartCost);

	int getAdvancedStartCostIncrease();

	void setAdvancedStartCostIncrease(int advancedStartCostIncrease);

	int getAirCombat();

	void setAirCombat(int airCombat);

	int getAirCombatLimit();

	void setAirCombatLimit(int airCombatLimit);

	int getAirRange();

	void setAirRange(int airRange);

	int getAirUnitCap();

	void setAirUnitCap(int airUnitCap);

	int getAnimalCombat();

	void setAnimalCombat(int animalCombat);

	int getAsset();

	void setAsset(int asset);

	int getBaseDiscover();

	void setBaseDiscover(int baseDiscover);

	int getBaseHurry();

	void setBaseHurry(int baseHurry);

	int getBaseTrade();

	void setBaseTrade(int baseTrade);

	int getBombRate();

	void setBombRate(int bombRate);

	int getBombardRate();

	void setBombardRate(int bombardRate);

	int getCargo();

	void setCargo(int cargo);

	int getChanceFirstStrikes();

	void setChanceFirstStrikes(int chanceFirstStrikes);

	int getCityAttack();

	void setCityAttack(int cityAttack);

	int getCityDefense();

	void setCityDefense(int cityDefense);

	int getCollateralDamage();

	void setCollateralDamage(int collateralDamage);

	int getCollateralDamageLimit();

	void setCollateralDamageLimit(int collateralDamageLimit);

	int getCollateralDamageMaxUnits();

	void setCollateralDamageMaxUnits(int collateralDamageMaxUsers);

	int getCombat();

	void setCombat(int combat);

	int getCombatLimit();

	void setCombatLimit(int combatLimit);

	int getConscription();

	void setConscription(int conscription);

	int getCost();

	void setCost(int cost);

	int getCultureGarrison();

	void setCultureGarrison(int cultureGarrison);

	int getDiscoverMultiplier();

	void setDiscoverMultiplier(int discoverMultiplier);

	int getDropRange();

	void setDropRange(int dropRange);

	int getEnslaveCount();

	void setEnslaveCount(int enslaveCount);

	int getEspionagePoints();

	void setEspionagePoints(int espionagePoints);

	int getEvasionProbability();

	void setEvasionProbability(int evasionProbability);

	int getExtraCost();

	void setExtraCost(int extraCost);

	int getFirstStrikes();

	void setFirstStrikes(int firstStrikes);

	int getGreatWorkCulture();

	void setGreatWorkCulture(int greatWorkCulture);

	int getHillsAttack();

	void setHillsAttack(int hillsAttack);

	int getHillsDefense();

	void setHillsDefense(int hillsDefense);

	int getHotKeyPriority();

	void setHotKeyPriority(int hotKeyPriority);

	int getHurryCostModifier();

	void setHurryCostModifier(int hurryCostMultiplier);

	int getHurryMultiplier();

	void setHurryMultiplier(int hurryMultiplier);

	int getInterceptionProbability();

	void setInterceptionProbability(int interceptionProbability);

	int getLeaderExperience();

	void setLeaderExperience(int leaderExperience);

	int getMaxAmmoTypeTier();

	void setMaxAmmoTypeTier(int maxAmmoTypeTier);

	int getMaxWeaponTypeTier();

	void setMaxWeaponTypeTier(int maxWeaponTypeTier);

	int getMinAreaSize();

	void setMinAreaSize(int minAreaSize);

	int getMinPopulation();

	void setMinPopulation(int minPopulation);

	int getMoves();

	void setMoves(int moves);

	int getNukeRange();

	void setNukeRange(int nukeRange);

	int getOrderPriority();

	void setOrderPriority(int orderPriority);

	int getPower();

	void setPower(int power);

	int getSpyEscapeChance();

	void setSpyEscapeChance(int spyEscapeChance);

	int getSpyEvasionChance();

	void setSpyEvasionChance(int spyEvasionChance);

	int getSpyInterceptChance();

	void setSpyInterceptChance(int spyInterceptChance);

	int getTradeMultiplier();

	void setTradeMultiplier(int tradeMultiplier);

	int getWithdrawalProb();

	void setWithdrawalProb(int withdrawalProb);

	int getWorkRate();

	void setWorkRate(int workRate);

	int getXpValueAttack();

	void setXpValueAttack(int xpValueAttack);

	int getXpValueDefense();

	void setXpValueDefense(int xpValueDefense);

	boolean isAltDown();

	void setAltDown(boolean altDown);

	boolean isAlwaysHostile();

	void setAlwaysHostile(boolean alwaysHostile);

	boolean isAnimal();

	void setAnimal(boolean animal);

	boolean isCanMoveAllTerrain();

	void setCanMoveAllTerrain(boolean canMoveAllTerrain);

	boolean isCanMoveImpassable();

	void setCanMoveImpassable(boolean canMoveImpassable);

	boolean isCounterSpy();

	void setCounterSpy(boolean counterSpy);

	boolean isCtrlDown();

	void setCtrlDown(boolean ctrlDown);

	boolean isDestroy();

	void setDestroy(boolean destroy);

	boolean isFirstStrikeImmune();

	void setFirstStrikeImmune(boolean firstStrikeImmune);

	boolean isFixedAI();

	void setFixedAI(boolean fixedAI);

	boolean isFlatMovementCost();

	void setFlatMovementCost(boolean flatMovementCost);

	boolean isFood();

	void setFood(boolean food);

	boolean isFound();

	void setFound(boolean found);

	boolean isGoldenAge();

	void setGoldenAge(boolean goldenAge);

	boolean isHiddenNationality();

	void setHiddenNationality(boolean hiddenNationality);

	boolean isIgnoreBuildingDefense();

	void setIgnoreBuildingDefense(boolean ignoreBuildingDefense);

	boolean isIgnoreTerrainCost();

	void setIgnoreTerrainCost(boolean ignoreTerrainCost);

	boolean isInvestigate();

	void setInvestigate(boolean investigate);

	boolean isInvisible();

	void setInvisible(boolean invisible);

	boolean isLineOfSight();

	void setLineOfSight(boolean lineOfSight);

	boolean isMechanized();

	void setMechanized(boolean mechanized);

	boolean isMilitaryHappiness();

	void setMilitaryHappiness(boolean militaryHappiness);

	boolean isMilitaryProduction();

	void setMilitaryProduction(boolean militaryProduction);

	boolean isMilitarySupport();

	void setMilitarySupport(boolean militarySupport);

	boolean isMilitaryTrade();

	void setMilitaryTrade(boolean militaryTrade);

	boolean isNoBadGoodies();

	void setNoBadGoodies(boolean noBadGoodies);

	boolean isNoCapture();

	void setNoCapture(boolean noCapture);

	boolean isNoDefensiveBonus();

	void setNoDefensiveBonus(boolean noDefensiveBonus);

	boolean isNoRevealMap();

	void setNoRevealMap(boolean noRevealMap);

	boolean isNukeImmune();

	void setNukeImmune(boolean nukeImmune);

	boolean isOnlyDefensive();

	void setOnlyDefensive(boolean onlyDefensive);

	boolean isPillage();

	void setPillage(boolean pillage);

	boolean isPrereqBonuses();

	void setPrereqBonuses(boolean prereqBonuses);

	boolean isPrereqPower();

	void setPrereqPower(boolean prereqPower);

	boolean isPrereqReligion();

	void setPrereqReligion(boolean prereqReligion);

	boolean isQuickCombat();

	void setQuickCombat(boolean quickCombat);

	boolean isRenderAlways();

	void setRenderAlways(boolean renderAlways);

	boolean isRenderBelowWater();

	void setRenderBelowWater(boolean renderBelowWater);

	boolean isRivalTerritory();

	void setRivalTerritory(boolean rivalTerritory);

	boolean isSabotage();

	void setSabotage(boolean sabotage);

	boolean isShiftDown();

	void setShiftDown(boolean shiftDown);

	boolean isSingleBuild();

	void setSingleBuild(boolean singleBuild);

	boolean isSlave();

	void setSlave(boolean slave);

	boolean isSpy();

	void setSpy(boolean spy);

	boolean isStealPlans();

	void setStealPlans(boolean stealPlans);

	boolean isSuicide();

	void setSuicide(boolean suicide);

	boolean isWorkerTrade();

	void setWorkerTrade(boolean workerTrade);

	List<String> getBuilds();

	void addBuild(String build);

	List<String> getFeatureImpassables();

	void addFeatureImpassable(String featureImpassable);

	List<String> getFeatureNatives();

	void addFeatureNative(String featureNative);

	List<String> getForceBuildings();

	void addForceBuildings(String forceBuilding);

	List<String> getFreePromotions();

	void addFreePromotion(String freePromotion);

	List<String> getGreatPeoples();

	void addGreatPerson(String greatPerson);

	List<String> getNotUnitAIs();

	void addNotUnitAIs(String notUnitAI);

	List<String> getPrereqAndCivics();

	void addPrereqAndCivic(String prereqAndCivic);

	List<String> getPrereqAndTerrains();

	void addPrereqAndTerrain(String prereqAndTerrain);

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

	List<String> getPrereqTechs();

	void addPrereqTech(String prereqTech);

	List<String> getPrereqVicinityAndBonuses();

	void addPrereqVicinityAndBonus(String prereqVicinityAndBonus);

	List<String> getPrereqVicinityFeatures();

	void addPrereqVicinityFeature(String prereqVicinityFeature);

	List<String> getPrereqVicinityImprovements();

	void addPrereqVicinityImprovement(String prereqVicinityImprovement);

	List<String> getPrereqVicinityOrBonuses();

	void addPrereqVicinityOrBonus(String prereqVicinityOrBonus);

	List<String> getPrereqWorldViews();

	void addPrereqWorldView(String prereqWorldView);

	List<String> getSeeInvisbles();

	void addSeeInvisble(String seeInvisble);

	List<String> getSubCombatTypes();

	void addSubCombatType(String subCombatType);

	List<String> getTerrainImpassables();

	void addTerrainImpassable(String terrainImpassable);

	List<String> getTerrainNatives();

	void addTerrainNative(String terrainNative);

	List<String> getUniqueNames();

	void addUniqueName(String uniqueName);

	List<String> getUnitAIs();

	void addUnitAI(String unitAI);

	List<String> getUnitClassDefenders();

	void addUnitClassDefender(String unitClassDefender);

	List<String> getUnitClassTargets();

	void addUnitClassTarget(String unitClassTarget);

	List<String> getUnitClassUpgrades();

	void addUnitClassUpgrade(String unitClassUpgrade);

	List<String> getUnitCombatDefenders();

	void addUnitCombatDefender(String unitCombatDefender);

	List<String> getUnitCombatTargets();

	void addUnitCombatTarget(String unitCombatTarget);

	List<Integer> getCommercesFromKill();

	void addCommerceFromKill(Integer commerce);

	List<Integer> getYieldsFromKill();

	void addYieldFromKill(Integer yield);

	List<IPair<String, Integer>> getBonusProductionModifiers();

	void addBonusProductionModifier(IPair<String, Integer> bonusProductionModifier);

	List<IPair<String, Integer>> getCorporationSpreads();

	void addCorporationSpread(IPair<String, Integer> corporationSpread);

	List<IPair<String, Integer>> getDomainMods();

	void addDomainMod(IPair<String, Integer> domainMod);

	List<IPair<String, Integer>> getFeatureAttacks();

	void addFeatureAttacks(IPair<String, Integer> featureAttack);

	List<IPair<String, Integer>> getFeatureDefenses();

	void addFeatureDefense(IPair<String, Integer> featureDefense);

	List<IPair<String, Integer>> getFlankingStrikes();

	void addFlankingStrike(IPair<String, Integer> flankingStrike);

	List<IPair<String, Integer>> getFlavours();

	void addFlavour(IPair<String, Integer> flavour);

	List<IPair<String, Integer>> getProductionTraits();

	void addProductionTrait(IPair<String, Integer> productionTrait);

	List<IPair<String, Integer>> getReligionSpreads();

	void addReligionSpread(IPair<String, Integer> religionSpread);

	List<IPair<String, Integer>> getTerrainAttacks();

	void addTerrainAttack(IPair<String, Integer> terrainAttack);

	List<IPair<String, Integer>> getTerrainDefenses();

	void addTerrainDefense(IPair<String, Integer> terrainDefense);

	List<IPair<String, Integer>> getUnitClassAttackMods();

	void addUnitClassAttackMod(IPair<String, Integer> unitClassAttackMod);

	List<IPair<String, Integer>> getUnitClassDefenseMods();

	void addUnitClassDefenseMod(IPair<String, Integer> unitClassDefenseMod);

	List<IPair<String, Integer>> getUnitCombatCollateralImmunes();

	void addUnitCombatCollateralImmune(IPair<String, Integer> unitCombatCollateralImmune);

	List<IPair<String, Integer>> getUnitCombatMods();

	void addUnitCombatMod(IPair<String, Integer> unitCombatMod);

	List<IPair<String, String>> getBuildings();

	void addBuilding(IPair<String, String> building);

	List<IPair<String, String>> getFeaturePassableTechs();

	void addFeaturePassableTech(IPair<String, String> featurePassableTech);

	List<IPair<String, String>> getTerrainPassableTechs();

	void addTerrainPassableTech(IPair<String, String> terrainPassableTech);

	UnitMeshGroups getUnitMeshGroups();

	void setUnitMeshGroups(UnitMeshGroups unitMeshGroups);

}