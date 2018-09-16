package org.archid.civ4.info.archid.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.archid.civ4.info.AbstractInfos;
import org.archid.utils.IPair;

@XmlRootElement(name="Civ4UnitInfos", namespace="x-schema:CIV4UnitSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class UnitInfos extends AbstractInfos<IUnitInfo> {

	public UnitInfos() {
		super(new TreeMap<String, IUnitInfo>());
	}

	@XmlJavaTypeAdapter(UnitMapAdapter.class)
	@XmlElement(name="UnitInfos")
	public Map<String, IUnitInfo> getInfoMap() {
		return infos;
	}
	
	@Override
	public void setInfoMap(Map<String, IUnitInfo> infos) {
		this.infos = infos;
	}
	
	public static IUnitInfo createInfo(String type) {
		return new UnitInfo(type);
	}
	
	private static class UnitInfo implements IUnitInfo {
		private String advisor;
		private String bonusType;
		private String capture;
		private String civilopedia;
		private String clazz;
		private String combatType;
		private String defaultUnitAI;
		private String description;
		private String domain;
		private String domainCargo;
		private String formationType;
		private String help;
		private String holyCity;
		private String hotKey;
		private String invisibleType;
		private String leaderPromotion;
		private String minCultureLevel;
		private String obsoleteTech;
		private String prereqBuilding;
		private String prereqCorporation;
		private String prereqReligionType;
		private String religionType;
		private String slaveSpecialistType;
		private String special;
		private String specialCargo;
		private String stateReligion;
		private String strategy;
		private String type;
		private String unitRangeType;
		private int aiWeight;
		private int advancedStartCost;
		private int advancedStartCostIncrease;
		private int airCombat;
		private int airCombatLimit;
		private int airRange;
		private int airUnitCap;
		private int animalCombat;
		private int asset;
		private int baseDiscover;
		private int baseHurry;
		private int baseTrade;
		private int bombRate;
		private int bombardRate;
		private int cargo;
		private int chanceFirstStrikes;
		private int cityAttack;
		private int cityDefense;
		private int collateralDamage;
		private int collateralDamageLimit;
		private int collateralDamageMaxUnits;
		private int combat;
		private int combatLimit;
		private int conscription;
		private int cost;
		private int cultureGarrison;
		private int discoverMultiplier;
		private int dropRange;
		private int enslaveCount;
		private int espionagePoints;
		private int evasionProbability;
		private int extraCost;
		private int firstStrikes;
		private int greatWorkCulture;
		private int hillsAttack;
		private int hillsDefense;
		private int hotKeyPriority;
		private int hurryCostModifier;
		private int hurryMultiplier;
		private int interceptionProbability;
		private int leaderExperience;
		private int maxAmmoTypeTier;
		private int maxWeaponTypeTier;
		private int minAreaSize;
		private int minPopulation;
		private int moves;
		private int nukeRange;
		private int orderPriority;
		private int power;
		private int spyEscapeChance;
		private int spyEvasionChance;
		private int spyInterceptChance;
		private int tradeMultiplier;
		private int withdrawalProb;
		private int workRate;
		private int xpValueAttack;
		private int xpValueDefense;
		private boolean altDown;
		private boolean alwaysHostile;
		private boolean animal;
		private boolean canMoveAllTerrain;
		private boolean canMoveImpassable;
		private boolean counterSpy;
		private boolean ctrlDown;
		private boolean destroy;
		private boolean firstStrikeImmune;
		private boolean fixedAI;
		private boolean flatMovementCost;
		private boolean food;
		private boolean found;
		private boolean goldenAge;
		private boolean hiddenNationality;
		private boolean ignoreBuildingDefense;
		private boolean ignoreTerrainCost;
		private boolean investigate;
		private boolean invisible;
		private boolean lineOfSight;
		private boolean mechanized;
		private boolean militaryHappiness;
		private boolean militaryProduction;
		private boolean militarySupport;
		private boolean militaryTrade;
		private boolean noBadGoodies;
		private boolean noCapture;
		private boolean noDefensiveBonus;
		private boolean noRevealMap;
		private boolean nukeImmune;
		private boolean onlyDefensive;
		private boolean pillage;
		private boolean prereqBonuses;
		private boolean prereqPower;
		private boolean prereqReligion;
		private boolean quickCombat;
		private boolean renderAlways;
		private boolean renderBelowWater;
		private boolean rivalTerritory;
		private boolean sabotage;
		private boolean shiftDown;
		private boolean singleBuild;
		private boolean slave;
		private boolean spy;
		private boolean stealPlans;
		private boolean suicide;
		private boolean workerTrade;
		private List<String> buildings = new ArrayList<String>();
		private List<String> builds = new ArrayList<String>();
		private List<String> featureImpassables = new ArrayList<String>();
		private List<String> featureNatives = new ArrayList<String>();
		private List<String> forceBuildings = new ArrayList<String>();
		private List<String> freePromotions = new ArrayList<String>();
		private List<String> greatPoeples = new ArrayList<String>();
		private List<String> notUnitAIs = new ArrayList<String>();
		private List<String> prereqAndCivics = new ArrayList<String>();
		private List<String> prereqAndTerrains = new ArrayList<String>();
		private List<String> prereqNotBuildingClasses = new ArrayList<String>();
		private List<String> prereqOrBonuses = new ArrayList<String>();
		private List<String> prereqOrBuildingClasses = new ArrayList<String>();
		private List<String> prereqOrCivics = new ArrayList<String>();
		private List<String> prereqOrTerrains = new ArrayList<String>();
		private List<String> prereqTechs = new ArrayList<String>();
		private List<String> prereqVicinityAndBonuses = new ArrayList<String>();
		private List<String> prereqVicinityFeatures = new ArrayList<String>();
		private List<String> prereqVicinityImprovements = new ArrayList<String>();
		private List<String> prereqVicinityOrBonuses = new ArrayList<String>();
		private List<String> prereqWorldViews = new ArrayList<String>();
		private List<String> seeInvisbles = new ArrayList<String>();
		private List<String> subCombatTypes = new ArrayList<String>();
		private List<String> terrainImpassables = new ArrayList<String>();
		private List<String> terrainNatives = new ArrayList<String>();
		private List<String> uniqueNames = new ArrayList<String>();
		private List<String> unitAIs = new ArrayList<String>();
		private List<String> unitClassDefenders = new ArrayList<String>();
		private List<String> unitClassTargets = new ArrayList<String>();
		private List<String> unitClassUpgrades = new ArrayList<String>();
		private List<String> unitCombatDefenders = new ArrayList<String>();
		private List<String> unitCombatTargets = new ArrayList<String>();
		private List<Integer> commercesFromKill = new ArrayList<Integer>();
		private List<Integer> yieldsFromKill = new ArrayList<Integer>();
		private List<IPair<String, Integer>> bonusProductionModifiers = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> corporationSpreads = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> domainMods = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> featureAttacks = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> featureDefenses = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> flankingStrikes = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> flavours = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> productionTraits = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> religionSpreads = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> terrainAttacks = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> terrainDefenses = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> unitClassAttackMods = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> unitClassDefenseMods = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> unitCombatCollateralImmunes = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> unitCombatMods = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, String>> featurePassableTechs = new ArrayList<IPair<String, String>>();
		private List<IPair<String, String>> terrainPassableTechs = new ArrayList<IPair<String, String>>();
		private UnitMeshGroups unitMeshGroups = new UnitMeshGroups();
		
		public UnitInfo(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAdvisor()
		 */
		@Override
		public String getAdvisor() {
			return advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAdvisor(java.lang.String)
		 */
		@Override
		public void setAdvisor(String advisor) {
			this.advisor = advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBonusType()
		 */
		@Override
		public String getBonusType() {
			return bonusType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBonusType(java.lang.String)
		 */
		@Override
		public void setBonusType(String bonusType) {
			this.bonusType = bonusType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCapture()
		 */
		@Override
		public String getCapture() {
			return capture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCapture(java.lang.String)
		 */
		@Override
		public void setCapture(String capture) {
			this.capture = capture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCivilopedia()
		 */
		@Override
		public String getCivilopedia() {
			return civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCivilopedia(java.lang.String)
		 */
		@Override
		public void setCivilopedia(String civilopedia) {
			this.civilopedia = civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClass()
		 */
		@Override
		public String getUnitClass() {
			return clazz;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setUnitClass(java.lang.String)
		 */
		@Override
		public void setUnitClass(String unitClass) {
			this.clazz = unitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCombatType()
		 */
		@Override
		public String getCombatType() {
			return combatType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCombatType(java.lang.String)
		 */
		@Override
		public void setCombatType(String combatType) {
			this.combatType = combatType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDefaultUnitAI()
		 */
		@Override
		public String getDefaultUnitAI() {
			return defaultUnitAI;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDefaultUnitAI(java.lang.String)
		 */
		@Override
		public void setDefaultUnitAI(String defaultUnitAI) {
			this.defaultUnitAI = defaultUnitAI;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDomain()
		 */
		@Override
		public String getDomain() {
			return domain;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDomain(java.lang.String)
		 */
		@Override
		public void setDomain(String domain) {
			this.domain = domain;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDomainCargo()
		 */
		@Override
		public String getDomainCargo() {
			return domainCargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDomainCargo(java.lang.String)
		 */
		@Override
		public void setDomainCargo(String domainCargo) {
			this.domainCargo = domainCargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFormationType()
		 */
		@Override
		public String getFormationType() {
			return formationType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFormationType(java.lang.String)
		 */
		@Override
		public void setFormationType(String formationType) {
			this.formationType = formationType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHelp()
		 */
		@Override
		public String getHelp() {
			return help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHelp(java.lang.String)
		 */
		@Override
		public void setHelp(String help) {
			this.help = help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHolyCity()
		 */
		@Override
		public String getHolyCity() {
			return holyCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHolyCity(java.lang.String)
		 */
		@Override
		public void setHolyCity(String holyCity) {
			this.holyCity = holyCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHotKey()
		 */
		@Override
		public String getHotKey() {
			return hotKey;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHotKey(java.lang.String)
		 */
		@Override
		public void setHotKey(String hotKey) {
			this.hotKey = hotKey;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getInvisibleType()
		 */
		@Override
		public String getInvisibleType() {
			return invisibleType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setInvisibleType(java.lang.String)
		 */
		@Override
		public void setInvisibleType(String invisibleType) {
			this.invisibleType = invisibleType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getLeaderPromotion()
		 */
		@Override
		public String getLeaderPromotion() {
			return leaderPromotion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setLeaderPromotion(java.lang.String)
		 */
		@Override
		public void setLeaderPromotion(String leaderPromotion) {
			this.leaderPromotion = leaderPromotion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMinCultureLevel()
		 */
		@Override
		public String getMinCultureLevel() {
			return minCultureLevel;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMinCultureLevel(java.lang.String)
		 */
		@Override
		public void setMinCultureLevel(String minCultureLevel) {
			this.minCultureLevel = minCultureLevel;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getObsoleteTech()
		 */
		@Override
		public String getObsoleteTech() {
			return obsoleteTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setObsoleteTech(java.lang.String)
		 */
		@Override
		public void setObsoleteTech(String obsoleteTech) {
			this.obsoleteTech = obsoleteTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqBuilding()
		 */
		@Override
		public String getPrereqBuilding() {
			return prereqBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqBuilding(java.lang.String)
		 */
		@Override
		public void setPrereqBuilding(String prereqBuilding) {
			this.prereqBuilding = prereqBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqCorporation()
		 */
		@Override
		public String getPrereqCorporation() {
			return prereqCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqCorporation(java.lang.String)
		 */
		@Override
		public void setPrereqCorporation(String prereqCorporation) {
			this.prereqCorporation = prereqCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqReligionType()
		 */
		@Override
		public String getPrereqReligionType() {
			return prereqReligionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqReligionType(java.lang.String)
		 */
		@Override
		public void setPrereqReligionType(String prereqReligionType) {
			this.prereqReligionType = prereqReligionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getReligionType()
		 */
		@Override
		public String getReligionType() {
			return religionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setReligionType(java.lang.String)
		 */
		@Override
		public void setReligionType(String religionType) {
			this.religionType = religionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSlaveSpecialistType()
		 */
		@Override
		public String getSlaveSpecialistType() {
			return slaveSpecialistType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSlaveSpecialistType(java.lang.String)
		 */
		@Override
		public void setSlaveSpecialistType(String slaveSpecialistType) {
			this.slaveSpecialistType = slaveSpecialistType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSpecial()
		 */
		@Override
		public String getSpecial() {
			return special;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpecial(java.lang.String)
		 */
		@Override
		public void setSpecial(String special) {
			this.special = special;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSpecialCargo()
		 */
		@Override
		public String getSpecialCargo() {
			return specialCargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpecialCargo(java.lang.String)
		 */
		@Override
		public void setSpecialCargo(String specialCargo) {
			this.specialCargo = specialCargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getStateReligion()
		 */
		@Override
		public String getStateReligion() {
			return stateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setStateReligion(java.lang.String)
		 */
		@Override
		public void setStateReligion(String stateReligion) {
			this.stateReligion = stateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getStrategy()
		 */
		@Override
		public String getStrategy() {
			return strategy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setStrategy(java.lang.String)
		 */
		@Override
		public void setStrategy(String strategy) {
			this.strategy = strategy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitRangeType()
		 */
		@Override
		public String getUnitRangeType() {
			return unitRangeType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setUnitRangeType(java.lang.String)
		 */
		@Override
		public void setUnitRangeType(String unitRangeType) {
			this.unitRangeType = unitRangeType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAiWeight()
		 */
		@Override
		public int getAiWeight() {
			return aiWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAiWeight(int)
		 */
		@Override
		public void setAiWeight(int aiWeight) {
			this.aiWeight = aiWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAdvancedStartCost()
		 */
		@Override
		public int getAdvancedStartCost() {
			return advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAdvancedStartCost(int)
		 */
		@Override
		public void setAdvancedStartCost(int advancedStartCost) {
			this.advancedStartCost = advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAdvancedStartCostIncrease()
		 */
		@Override
		public int getAdvancedStartCostIncrease() {
			return advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAdvancedStartCostIncrease(int)
		 */
		@Override
		public void setAdvancedStartCostIncrease(int advancedStartCostIncrease) {
			this.advancedStartCostIncrease = advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAirCombat()
		 */
		@Override
		public int getAirCombat() {
			return airCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAirCombat(int)
		 */
		@Override
		public void setAirCombat(int airCombat) {
			this.airCombat = airCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAirCombatLimit()
		 */
		@Override
		public int getAirCombatLimit() {
			return airCombatLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAirCombatLimit(int)
		 */
		@Override
		public void setAirCombatLimit(int airCombatLimit) {
			this.airCombatLimit = airCombatLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAirRange()
		 */
		@Override
		public int getAirRange() {
			return airRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAirRange(int)
		 */
		@Override
		public void setAirRange(int airRange) {
			this.airRange = airRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAirUnitCap()
		 */
		@Override
		public int getAirUnitCap() {
			return airUnitCap;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAirUnitCap(int)
		 */
		@Override
		public void setAirUnitCap(int airUnitCap) {
			this.airUnitCap = airUnitCap;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAnimalCombat()
		 */
		@Override
		public int getAnimalCombat() {
			return animalCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAnimalCombat(int)
		 */
		@Override
		public void setAnimalCombat(int animalCombat) {
			this.animalCombat = animalCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getAsset()
		 */
		@Override
		public int getAsset() {
			return asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAsset(int)
		 */
		@Override
		public void setAsset(int asset) {
			this.asset = asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBaseDiscover()
		 */
		@Override
		public int getBaseDiscover() {
			return baseDiscover;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBaseDiscover(int)
		 */
		@Override
		public void setBaseDiscover(int baseDiscover) {
			this.baseDiscover = baseDiscover;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBaseHurry()
		 */
		@Override
		public int getBaseHurry() {
			return baseHurry;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBaseHurry(int)
		 */
		@Override
		public void setBaseHurry(int baseHurry) {
			this.baseHurry = baseHurry;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBaseTrade()
		 */
		@Override
		public int getBaseTrade() {
			return baseTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBaseTrade(int)
		 */
		@Override
		public void setBaseTrade(int baseTrade) {
			this.baseTrade = baseTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBombRate()
		 */
		@Override
		public int getBombRate() {
			return bombRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBombRate(int)
		 */
		@Override
		public void setBombRate(int bombRate) {
			this.bombRate = bombRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBombardRate()
		 */
		@Override
		public int getBombardRate() {
			return bombardRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setBombardRate(int)
		 */
		@Override
		public void setBombardRate(int bombardRate) {
			this.bombardRate = bombardRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCargo()
		 */
		@Override
		public int getCargo() {
			return cargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCargo(int)
		 */
		@Override
		public void setCargo(int cargo) {
			this.cargo = cargo;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getChanceFirstStrikes()
		 */
		@Override
		public int getChanceFirstStrikes() {
			return chanceFirstStrikes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setChanceFirstStrikes(int)
		 */
		@Override
		public void setChanceFirstStrikes(int chanceFirstStrikes) {
			this.chanceFirstStrikes = chanceFirstStrikes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCityAttack()
		 */
		@Override
		public int getCityAttack() {
			return cityAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCityAttack(int)
		 */
		@Override
		public void setCityAttack(int cityAttack) {
			this.cityAttack = cityAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCityDefense()
		 */
		@Override
		public int getCityDefense() {
			return cityDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCityDefense(int)
		 */
		@Override
		public void setCityDefense(int cityDefense) {
			this.cityDefense = cityDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCollateralDamage()
		 */
		@Override
		public int getCollateralDamage() {
			return collateralDamage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCollateralDamage(int)
		 */
		@Override
		public void setCollateralDamage(int collateralDamage) {
			this.collateralDamage = collateralDamage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCollateralDamageLimit()
		 */
		@Override
		public int getCollateralDamageLimit() {
			return collateralDamageLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCollateralDamageLimit(int)
		 */
		@Override
		public void setCollateralDamageLimit(int collateralDamageLimit) {
			this.collateralDamageLimit = collateralDamageLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCollateralDamageMaxUnits()
		 */
		@Override
		public int getCollateralDamageMaxUnits() {
			return collateralDamageMaxUnits;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCollateralDamageMaxUnits(int)
		 */
		@Override
		public void setCollateralDamageMaxUnits(int collateralDamageMaxUnits) {
			this.collateralDamageMaxUnits = collateralDamageMaxUnits;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCombat()
		 */
		@Override
		public int getCombat() {
			return combat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCombat(int)
		 */
		@Override
		public void setCombat(int combat) {
			this.combat = combat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCombatLimit()
		 */
		@Override
		public int getCombatLimit() {
			return combatLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCombatLimit(int)
		 */
		@Override
		public void setCombatLimit(int combatLimit) {
			this.combatLimit = combatLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getConscription()
		 */
		@Override
		public int getConscription() {
			return conscription;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setConscription(int)
		 */
		@Override
		public void setConscription(int conscription) {
			this.conscription = conscription;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCost()
		 */
		@Override
		public int getCost() {
			return cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCost(int)
		 */
		@Override
		public void setCost(int cost) {
			this.cost = cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCultureGarrison()
		 */
		@Override
		public int getCultureGarrison() {
			return cultureGarrison;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCultureGarrison(int)
		 */
		@Override
		public void setCultureGarrison(int cultureGarrison) {
			this.cultureGarrison = cultureGarrison;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDiscoverMultiplier()
		 */
		@Override
		public int getDiscoverMultiplier() {
			return discoverMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDiscoverMultiplier(int)
		 */
		@Override
		public void setDiscoverMultiplier(int discoverMultiplier) {
			this.discoverMultiplier = discoverMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDropRange()
		 */
		@Override
		public int getDropRange() {
			return dropRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDropRange(int)
		 */
		@Override
		public void setDropRange(int dropRange) {
			this.dropRange = dropRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getEnslaveCount()
		 */
		@Override
		public int getEnslaveCount() {
			return enslaveCount;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setEnslaveCount(int)
		 */
		@Override
		public void setEnslaveCount(int enslaveCount) {
			this.enslaveCount = enslaveCount;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getEspionagePoints()
		 */
		@Override
		public int getEspionagePoints() {
			return espionagePoints;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setEspionagePoints(int)
		 */
		@Override
		public void setEspionagePoints(int espionagePoints) {
			this.espionagePoints = espionagePoints;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getEvasionProbability()
		 */
		@Override
		public int getEvasionProbability() {
			return evasionProbability;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setEvasionProbability(int)
		 */
		@Override
		public void setEvasionProbability(int evasionProbability) {
			this.evasionProbability = evasionProbability;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getExtraCost()
		 */
		@Override
		public int getExtraCost() {
			return extraCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setExtraCost(int)
		 */
		@Override
		public void setExtraCost(int extraCost) {
			this.extraCost = extraCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFirstStrikes()
		 */
		@Override
		public int getFirstStrikes() {
			return firstStrikes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFirstStrikes(int)
		 */
		@Override
		public void setFirstStrikes(int firstStrikes) {
			this.firstStrikes = firstStrikes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getGreatWorkCulture()
		 */
		@Override
		public int getGreatWorkCulture() {
			return greatWorkCulture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setGreatWorkCulture(int)
		 */
		@Override
		public void setGreatWorkCulture(int greatWorkCulture) {
			this.greatWorkCulture = greatWorkCulture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHillsAttack()
		 */
		@Override
		public int getHillsAttack() {
			return hillsAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHillsAttack(int)
		 */
		@Override
		public void setHillsAttack(int hillsAttack) {
			this.hillsAttack = hillsAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHillsDefense()
		 */
		@Override
		public int getHillsDefense() {
			return hillsDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHillsDefense(int)
		 */
		@Override
		public void setHillsDefense(int hillsDefense) {
			this.hillsDefense = hillsDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHotKeyPriority()
		 */
		@Override
		public int getHotKeyPriority() {
			return hotKeyPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHotKeyPriority(int)
		 */
		@Override
		public void setHotKeyPriority(int hotKeyPriority) {
			this.hotKeyPriority = hotKeyPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHurryCostMultiplier()
		 */
		@Override
		public int getHurryCostModifier() {
			return hurryCostModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHurryCostMultiplier(int)
		 */
		@Override
		public void setHurryCostModifier(int hurryCostModifier) {
			this.hurryCostModifier = hurryCostModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getHurryMultiplier()
		 */
		@Override
		public int getHurryMultiplier() {
			return hurryMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHurryMultiplier(int)
		 */
		@Override
		public void setHurryMultiplier(int hurryMultiplier) {
			this.hurryMultiplier = hurryMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getInterceptionProbability()
		 */
		@Override
		public int getInterceptionProbability() {
			return interceptionProbability;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setInterceptionProbability(int)
		 */
		@Override
		public void setInterceptionProbability(int interceptionProbability) {
			this.interceptionProbability = interceptionProbability;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getLeaderExperience()
		 */
		@Override
		public int getLeaderExperience() {
			return leaderExperience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setLeaderExperience(int)
		 */
		@Override
		public void setLeaderExperience(int leaderExperience) {
			this.leaderExperience = leaderExperience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMaxAmmoTypeTier()
		 */
		@Override
		public int getMaxAmmoTypeTier() {
			return maxAmmoTypeTier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMaxAmmoTypeTier(int)
		 */
		@Override
		public void setMaxAmmoTypeTier(int maxAmmoTypeTier) {
			this.maxAmmoTypeTier = maxAmmoTypeTier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMaxWeaponTypeTier()
		 */
		@Override
		public int getMaxWeaponTypeTier() {
			return maxWeaponTypeTier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMaxWeaponTypeTier(int)
		 */
		@Override
		public void setMaxWeaponTypeTier(int maxWeaponTypeTier) {
			this.maxWeaponTypeTier = maxWeaponTypeTier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMinAreaSize()
		 */
		@Override
		public int getMinAreaSize() {
			return minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMinAreaSize(int)
		 */
		@Override
		public void setMinAreaSize(int minAreaSize) {
			this.minAreaSize = minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMinPopulation()
		 */
		@Override
		public int getMinPopulation() {
			return minPopulation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMinPopulation(int)
		 */
		@Override
		public void setMinPopulation(int minPopulation) {
			this.minPopulation = minPopulation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getMoves()
		 */
		@Override
		public int getMoves() {
			return moves;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMoves(int)
		 */
		@Override
		public void setMoves(int moves) {
			this.moves = moves;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getNukeRange()
		 */
		@Override
		public int getNukeRange() {
			return nukeRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNukeRange(int)
		 */
		@Override
		public void setNukeRange(int nukeRange) {
			this.nukeRange = nukeRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getOrderPriority()
		 */
		@Override
		public int getOrderPriority() {
			return orderPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setOrderPriority(int)
		 */
		@Override
		public void setOrderPriority(int orderPriority) {
			this.orderPriority = orderPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPower()
		 */
		@Override
		public int getPower() {
			return power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPower(int)
		 */
		@Override
		public void setPower(int power) {
			this.power = power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSpyEscapeChance()
		 */
		@Override
		public int getSpyEscapeChance() {
			return spyEscapeChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpyEscapeChance(int)
		 */
		@Override
		public void setSpyEscapeChance(int spyEscapeChance) {
			this.spyEscapeChance = spyEscapeChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSpyEvasionChance()
		 */
		@Override
		public int getSpyEvasionChance() {
			return spyEvasionChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpyEvasionChance(int)
		 */
		@Override
		public void setSpyEvasionChance(int spyEvasionChance) {
			this.spyEvasionChance = spyEvasionChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSpyInterceptChance()
		 */
		@Override
		public int getSpyInterceptChance() {
			return spyInterceptChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpyInterceptChance(int)
		 */
		@Override
		public void setSpyInterceptChance(int spyInterceptChance) {
			this.spyInterceptChance = spyInterceptChance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTradeMultiplier()
		 */
		@Override
		public int getTradeMultiplier() {
			return tradeMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setTradeMultiplier(int)
		 */
		@Override
		public void setTradeMultiplier(int tradeMultiplier) {
			this.tradeMultiplier = tradeMultiplier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getWithdrawalProb()
		 */
		@Override
		public int getWithdrawalProb() {
			return withdrawalProb;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setWithdrawalProb(int)
		 */
		@Override
		public void setWithdrawalProb(int withdrawalProb) {
			this.withdrawalProb = withdrawalProb;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getWorkRate()
		 */
		@Override
		public int getWorkRate() {
			return workRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setWorkRate(int)
		 */
		@Override
		public void setWorkRate(int workRate) {
			this.workRate = workRate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getXpValueAttack()
		 */
		@Override
		public int getXpValueAttack() {
			return xpValueAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setXpValueAttack(int)
		 */
		@Override
		public void setXpValueAttack(int xpValueAttack) {
			this.xpValueAttack = xpValueAttack;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getXpValueDefense()
		 */
		@Override
		public int getXpValueDefense() {
			return xpValueDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setXpValueDefense(int)
		 */
		@Override
		public void setXpValueDefense(int xpValueDefense) {
			this.xpValueDefense = xpValueDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isAltDown()
		 */
		@Override
		public boolean isAltDown() {
			return altDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAltDown(boolean)
		 */
		@Override
		public void setAltDown(boolean altDown) {
			this.altDown = altDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isAlwaysHostile()
		 */
		@Override
		public boolean isAlwaysHostile() {
			return alwaysHostile;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAlwaysHostile(boolean)
		 */
		@Override
		public void setAlwaysHostile(boolean alwaysHostile) {
			this.alwaysHostile = alwaysHostile;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isAnimal()
		 */
		@Override
		public boolean isAnimal() {
			return animal;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setAnimal(boolean)
		 */
		@Override
		public void setAnimal(boolean animal) {
			this.animal = animal;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isCanMoveAllTerrain()
		 */
		@Override
		public boolean isCanMoveAllTerrain() {
			return canMoveAllTerrain;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCanMoveAllTerrain(boolean)
		 */
		@Override
		public void setCanMoveAllTerrain(boolean canMoveAllTerrain) {
			this.canMoveAllTerrain = canMoveAllTerrain;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isCanMoveImpassable()
		 */
		@Override
		public boolean isCanMoveImpassable() {
			return canMoveImpassable;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCanMoveImpassable(boolean)
		 */
		@Override
		public void setCanMoveImpassable(boolean canMoveImpassable) {
			this.canMoveImpassable = canMoveImpassable;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isCounterSpy()
		 */
		@Override
		public boolean isCounterSpy() {
			return counterSpy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCounterSpy(boolean)
		 */
		@Override
		public void setCounterSpy(boolean counterSpy) {
			this.counterSpy = counterSpy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isCtrlDown()
		 */
		@Override
		public boolean isCtrlDown() {
			return ctrlDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setCtrlDown(boolean)
		 */
		@Override
		public void setCtrlDown(boolean ctrlDown) {
			this.ctrlDown = ctrlDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isDestroy()
		 */
		@Override
		public boolean isDestroy() {
			return destroy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setDestroy(boolean)
		 */
		@Override
		public void setDestroy(boolean destroy) {
			this.destroy = destroy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isFirstStrikeImmune()
		 */
		@Override
		public boolean isFirstStrikeImmune() {
			return firstStrikeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFirstStrikeImmune(boolean)
		 */
		@Override
		public void setFirstStrikeImmune(boolean firstStrikeImmune) {
			this.firstStrikeImmune = firstStrikeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isFixedAI()
		 */
		@Override
		public boolean isFixedAI() {
			return fixedAI;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFixedAI(boolean)
		 */
		@Override
		public void setFixedAI(boolean fixedAI) {
			this.fixedAI = fixedAI;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isFlatMovementCost()
		 */
		@Override
		public boolean isFlatMovementCost() {
			return flatMovementCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFlatMovementCost(boolean)
		 */
		@Override
		public void setFlatMovementCost(boolean flatMovementCost) {
			this.flatMovementCost = flatMovementCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isFood()
		 */
		@Override
		public boolean isFood() {
			return food;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFood(boolean)
		 */
		@Override
		public void setFood(boolean food) {
			this.food = food;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isFound()
		 */
		@Override
		public boolean isFound() {
			return found;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setFound(boolean)
		 */
		@Override
		public void setFound(boolean found) {
			this.found = found;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isGoldenAge()
		 */
		@Override
		public boolean isGoldenAge() {
			return goldenAge;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setGoldenAge(boolean)
		 */
		@Override
		public void setGoldenAge(boolean goldenAge) {
			this.goldenAge = goldenAge;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isHiddenNationality()
		 */
		@Override
		public boolean isHiddenNationality() {
			return hiddenNationality;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setHiddenNationality(boolean)
		 */
		@Override
		public void setHiddenNationality(boolean hiddenNationality) {
			this.hiddenNationality = hiddenNationality;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isIgnoreBuildingDefense()
		 */
		@Override
		public boolean isIgnoreBuildingDefense() {
			return ignoreBuildingDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setIgnoreBuildingDefense(boolean)
		 */
		@Override
		public void setIgnoreBuildingDefense(boolean ignoreBuildingDefense) {
			this.ignoreBuildingDefense = ignoreBuildingDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isIgnoreTerrainCost()
		 */
		@Override
		public boolean isIgnoreTerrainCost() {
			return ignoreTerrainCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setIgnoreTerrainCost(boolean)
		 */
		@Override
		public void setIgnoreTerrainCost(boolean ignoreTerrainCost) {
			this.ignoreTerrainCost = ignoreTerrainCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isInvestigate()
		 */
		@Override
		public boolean isInvestigate() {
			return investigate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setInvestigate(boolean)
		 */
		@Override
		public void setInvestigate(boolean investigate) {
			this.investigate = investigate;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isInvisible()
		 */
		@Override
		public boolean isInvisible() {
			return invisible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setInvisible(boolean)
		 */
		@Override
		public void setInvisible(boolean invisible) {
			this.invisible = invisible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isLineOfSight()
		 */
		@Override
		public boolean isLineOfSight() {
			return lineOfSight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setLineOfSight(boolean)
		 */
		@Override
		public void setLineOfSight(boolean lineOfSight) {
			this.lineOfSight = lineOfSight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isMechanized()
		 */
		@Override
		public boolean isMechanized() {
			return mechanized;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMechanized(boolean)
		 */
		@Override
		public void setMechanized(boolean mechanized) {
			this.mechanized = mechanized;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isMilitaryHappiness()
		 */
		@Override
		public boolean isMilitaryHappiness() {
			return militaryHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMilitaryHappiness(boolean)
		 */
		@Override
		public void setMilitaryHappiness(boolean militaryHappiness) {
			this.militaryHappiness = militaryHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isMilitaryProduction()
		 */
		@Override
		public boolean isMilitaryProduction() {
			return militaryProduction;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMilitaryProduction(boolean)
		 */
		@Override
		public void setMilitaryProduction(boolean militaryProduction) {
			this.militaryProduction = militaryProduction;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isMilitarySupport()
		 */
		@Override
		public boolean isMilitarySupport() {
			return militarySupport;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMilitarySupport(boolean)
		 */
		@Override
		public void setMilitarySupport(boolean militarySupport) {
			this.militarySupport = militarySupport;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isMilitaryTrade()
		 */
		@Override
		public boolean isMilitaryTrade() {
			return militaryTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setMilitaryTrade(boolean)
		 */
		@Override
		public void setMilitaryTrade(boolean militaryTrade) {
			this.militaryTrade = militaryTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isNoBadGoodies()
		 */
		@Override
		public boolean isNoBadGoodies() {
			return noBadGoodies;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNoBadGoodies(boolean)
		 */
		@Override
		public void setNoBadGoodies(boolean noBadGoodies) {
			this.noBadGoodies = noBadGoodies;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isNoCapture()
		 */
		@Override
		public boolean isNoCapture() {
			return noCapture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNoCapture(boolean)
		 */
		@Override
		public void setNoCapture(boolean noCapture) {
			this.noCapture = noCapture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isNoDefensiveBonus()
		 */
		@Override
		public boolean isNoDefensiveBonus() {
			return noDefensiveBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNoDefensiveBonus(boolean)
		 */
		@Override
		public void setNoDefensiveBonus(boolean noDefensiveBonus) {
			this.noDefensiveBonus = noDefensiveBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isNoRevealMap()
		 */
		@Override
		public boolean isNoRevealMap() {
			return noRevealMap;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNoRevealMap(boolean)
		 */
		@Override
		public void setNoRevealMap(boolean noRevealMap) {
			this.noRevealMap = noRevealMap;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isNukeImmune()
		 */
		@Override
		public boolean isNukeImmune() {
			return nukeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setNukeImmune(boolean)
		 */
		@Override
		public void setNukeImmune(boolean nukeImmune) {
			this.nukeImmune = nukeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isOnlyDefensive()
		 */
		@Override
		public boolean isOnlyDefensive() {
			return onlyDefensive;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setOnlyDefensive(boolean)
		 */
		@Override
		public void setOnlyDefensive(boolean onlyDefensive) {
			this.onlyDefensive = onlyDefensive;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isPillage()
		 */
		@Override
		public boolean isPillage() {
			return pillage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPillage(boolean)
		 */
		@Override
		public void setPillage(boolean pillage) {
			this.pillage = pillage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isPrereqBonuses()
		 */
		@Override
		public boolean isPrereqBonuses() {
			return prereqBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqBonuses(boolean)
		 */
		@Override
		public void setPrereqBonuses(boolean prereqBonuses) {
			this.prereqBonuses = prereqBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isPrereqPower()
		 */
		@Override
		public boolean isPrereqPower() {
			return prereqPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqPower(boolean)
		 */
		@Override
		public void setPrereqPower(boolean prereqPower) {
			this.prereqPower = prereqPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isPrereqReligion()
		 */
		@Override
		public boolean isPrereqReligion() {
			return prereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setPrereqReligion(boolean)
		 */
		@Override
		public void setPrereqReligion(boolean prereqReligion) {
			this.prereqReligion = prereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isQuickCombat()
		 */
		@Override
		public boolean isQuickCombat() {
			return quickCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setQuickCombat(boolean)
		 */
		@Override
		public void setQuickCombat(boolean quickCombat) {
			this.quickCombat = quickCombat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isRenderAlways()
		 */
		@Override
		public boolean isRenderAlways() {
			return renderAlways;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setRenderAlways(boolean)
		 */
		@Override
		public void setRenderAlways(boolean renderAlways) {
			this.renderAlways = renderAlways;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isRenderBelowWater()
		 */
		@Override
		public boolean isRenderBelowWater() {
			return renderBelowWater;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setRenderBelowWater(boolean)
		 */
		@Override
		public void setRenderBelowWater(boolean renderBelowWater) {
			this.renderBelowWater = renderBelowWater;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isRivalTerritory()
		 */
		@Override
		public boolean isRivalTerritory() {
			return rivalTerritory;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setRivalTerritory(boolean)
		 */
		@Override
		public void setRivalTerritory(boolean rivalTerritory) {
			this.rivalTerritory = rivalTerritory;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isSabotage()
		 */
		@Override
		public boolean isSabotage() {
			return sabotage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSabotage(boolean)
		 */
		@Override
		public void setSabotage(boolean sabotage) {
			this.sabotage = sabotage;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isShiftDown()
		 */
		@Override
		public boolean isShiftDown() {
			return shiftDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setShiftDown(boolean)
		 */
		@Override
		public void setShiftDown(boolean shiftDown) {
			this.shiftDown = shiftDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isSingleBuild()
		 */
		@Override
		public boolean isSingleBuild() {
			return singleBuild;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSingleBuild(boolean)
		 */
		@Override
		public void setSingleBuild(boolean singleBuild) {
			this.singleBuild = singleBuild;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isSlave()
		 */
		@Override
		public boolean isSlave() {
			return slave;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSlave(boolean)
		 */
		@Override
		public void setSlave(boolean slave) {
			this.slave = slave;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isSpy()
		 */
		@Override
		public boolean isSpy() {
			return spy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSpy(boolean)
		 */
		@Override
		public void setSpy(boolean spy) {
			this.spy = spy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isStealPlans()
		 */
		@Override
		public boolean isStealPlans() {
			return stealPlans;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setStealPlans(boolean)
		 */
		@Override
		public void setStealPlans(boolean stealPlans) {
			this.stealPlans = stealPlans;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isSuicide()
		 */
		@Override
		public boolean isSuicide() {
			return suicide;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setSuicide(boolean)
		 */
		@Override
		public void setSuicide(boolean suicide) {
			this.suicide = suicide;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#isWorkerTrade()
		 */
		@Override
		public boolean isWorkerTrade() {
			return workerTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setWorkerTrade(boolean)
		 */
		@Override
		public void setWorkerTrade(boolean workerTrade) {
			this.workerTrade = workerTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBuilds()
		 */
		@Override
		public List<String> getBuilds() {
			return builds;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addBuild(java.lang.String)
		 */
		@Override
		public void addBuild(String build) {
			builds.add(build);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFeatureImpassables()
		 */
		@Override
		public List<String> getFeatureImpassables() {
			return featureImpassables;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFeatureImpassable(java.lang.String)
		 */
		@Override
		public void addFeatureImpassable(String featureImpassable) {
			featureImpassables.add(featureImpassable);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFeatureNatives()
		 */
		@Override
		public List<String> getFeatureNatives() {
			return featureNatives;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFeatureNative(java.lang.String)
		 */
		@Override
		public void addFeatureNative(String featureNative) {
			featureNatives.add(featureNative);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getForceBuildings()
		 */
		@Override
		public List<String> getForceBuildings() {
			return forceBuildings;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addForceBuildings(java.lang.String)
		 */
		@Override
		public void addForceBuildings(String forceBuilding) {
			forceBuildings.add(forceBuilding);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFreePromotions()
		 */
		@Override
		public List<String> getFreePromotions() {
			return freePromotions;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFreePromotion(java.lang.String)
		 */
		@Override
		public void addFreePromotion(String freePromotion) {
			freePromotions.add(freePromotion);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getGreatPoeples()
		 */
		@Override
		public List<String> getGreatPeoples() {
			return greatPoeples;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addGreatPoeple(java.lang.String)
		 */
		@Override
		public void addGreatPerson(String greatPerson) {
			greatPoeples.add(greatPerson);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getNotUnitAIs()
		 */
		@Override
		public List<String> getNotUnitAIs() {
			return notUnitAIs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addNotUnitAIs(java.lang.String)
		 */
		@Override
		public void addNotUnitAIs(String notUnitAI) {
			notUnitAIs.add(notUnitAI);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqAndCivics()
		 */
		@Override
		public List<String> getPrereqAndCivics() {
			return prereqAndCivics;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqAndCivic(java.lang.String)
		 */
		@Override
		public void addPrereqAndCivic(String prereqAndCivic) {
			prereqAndCivics.add(prereqAndCivic);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqAndTerrains()
		 */
		@Override
		public List<String> getPrereqAndTerrains() {
			return prereqAndTerrains;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqAndTerrain(java.lang.String)
		 */
		@Override
		public void addPrereqAndTerrain(String prereqAndTerrain) {
			prereqAndTerrains.add(prereqAndTerrain);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqNotBuildingClasses()
		 */
		@Override
		public List<String> getPrereqNotBuildingClasses() {
			return prereqNotBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqNotBuildingClass(java.lang.String)
		 */
		@Override
		public void addPrereqNotBuildingClass(String prereqNotBuildingClass) {
			prereqNotBuildingClasses.add(prereqNotBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqOrBonuses()
		 */
		@Override
		public List<String> getPrereqOrBonuses() {
			return prereqOrBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqOrBonus(java.lang.String)
		 */
		@Override
		public void addPrereqOrBonus(String prereqOrBonus) {
			prereqOrBonuses.add(prereqOrBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqOrBuildingClasses()
		 */
		@Override
		public List<String> getPrereqOrBuildingClasses() {
			return prereqOrBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqOrBuildingClass(java.lang.String)
		 */
		@Override
		public void addPrereqOrBuildingClass(String prereqOrBuildingClass) {
			prereqOrBuildingClasses.add(prereqOrBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqOrCivics()
		 */
		@Override
		public List<String> getPrereqOrCivics() {
			return prereqOrCivics;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqOrCivic(java.lang.String)
		 */
		@Override
		public void addPrereqOrCivic(String prereqOrCivic) {
			prereqOrCivics.add(prereqOrCivic);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqOrTerrains()
		 */
		@Override
		public List<String> getPrereqOrTerrains() {
			return prereqOrTerrains;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqOrTerrain(java.lang.String)
		 */
		@Override
		public void addPrereqOrTerrain(String prereqOrTerrain) {
			prereqOrTerrains.add(prereqOrTerrain);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqTechs()
		 */
		@Override
		public List<String> getPrereqTechs() {
			return prereqTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqTech(java.lang.String)
		 */
		@Override
		public void addPrereqTech(String prereqTech) {
			prereqTechs.add(prereqTech);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqVicinityAndBonus()
		 */
		@Override
		public List<String> getPrereqVicinityAndBonuses() {
			return prereqVicinityAndBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqVicinityAndBonus(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityAndBonus(String prereqVicinityAndBonus) {
			this.prereqVicinityAndBonuses.add(prereqVicinityAndBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqVicinityFeatures()
		 */
		@Override
		public List<String> getPrereqVicinityFeatures() {
			return prereqVicinityFeatures;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqVicinityFeature(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityFeature(String prereqVicinityFeature) {
			prereqVicinityFeatures.add(prereqVicinityFeature);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqVicinityImprovements()
		 */
		@Override
		public List<String> getPrereqVicinityImprovements() {
			return prereqVicinityImprovements;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqVicinityImprovement(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityImprovement(String prereqVicinityImprovement) {
			prereqVicinityImprovements.add(prereqVicinityImprovement);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqVicinityOrBonus()
		 */
		@Override
		public List<String> getPrereqVicinityOrBonuses() {
			return prereqVicinityOrBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqVicinityOrBonus(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityOrBonus(String prereqVicinityOrBonus) {
			prereqVicinityOrBonuses.add(prereqVicinityOrBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getPrereqWorldViews()
		 */
		@Override
		public List<String> getPrereqWorldViews() {
			return prereqWorldViews;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addPrereqWorldView(java.lang.String)
		 */
		@Override
		public void addPrereqWorldView(String prereqWorldView) {
			prereqWorldViews.add(prereqWorldView);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSeeInvisbles()
		 */
		@Override
		public List<String> getSeeInvisbles() {
			return seeInvisbles;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addSeeInvisble(java.lang.String)
		 */
		@Override
		public void addSeeInvisble(String seeInvisble) {
			seeInvisbles.add(seeInvisble);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getSubCombatTypes()
		 */
		@Override
		public List<String> getSubCombatTypes() {
			return subCombatTypes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addSubCombatType(java.lang.String)
		 */
		@Override
		public void addSubCombatType(String subCombatType) {
			subCombatTypes.add(subCombatType);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTerrainImpassables()
		 */
		@Override
		public List<String> getTerrainImpassables() {
			return terrainImpassables;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addTerrainImpassable(java.lang.String)
		 */
		@Override
		public void addTerrainImpassable(String terrainImpassable) {
			terrainImpassables.add(terrainImpassable);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTerrainNatives()
		 */
		@Override
		public List<String> getTerrainNatives() {
			return terrainNatives;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addTerrainNative(java.lang.String)
		 */
		@Override
		public void addTerrainNative(String terrainNative) {
			terrainNatives.add(terrainNative);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUniqueNames()
		 */
		@Override
		public List<String> getUniqueNames() {
			return uniqueNames;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUniqueName(java.lang.String)
		 */
		@Override
		public void addUniqueName(String uniqueName) {
			uniqueNames.add(uniqueName);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitAIs()
		 */
		@Override
		public List<String> getUnitAIs() {
			return unitAIs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitAI(java.lang.String)
		 */
		@Override
		public void addUnitAI(String unitAI) {
			unitAIs.add(unitAI);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClassDefenders()
		 */
		@Override
		public List<String> getUnitClassDefenders() {
			return unitClassDefenders;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitClassDefender(java.lang.String)
		 */
		@Override
		public void addUnitClassDefender(String unitClassDefender) {
			unitClassDefenders.add(unitClassDefender);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClassTargets()
		 */
		@Override
		public List<String> getUnitClassTargets() {
			return unitClassTargets;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitClassTarget(java.lang.String)
		 */
		@Override
		public void addUnitClassTarget(String unitClassTarget) {
			unitClassTargets.add(unitClassTarget);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClassUpgrades()
		 */
		@Override
		public List<String> getUnitClassUpgrades() {
			return unitClassUpgrades;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitClassUpgrade(java.lang.String)
		 */
		@Override
		public void addUnitClassUpgrade(String unitClassUpgrade) {
			unitClassUpgrades.add(unitClassUpgrade);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitCombatDefenders()
		 */
		@Override
		public List<String> getUnitCombatDefenders() {
			return unitCombatDefenders;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitCombatDefender(java.lang.String)
		 */
		@Override
		public void addUnitCombatDefender(String unitCombatDefender) {
			unitCombatDefenders.add(unitCombatDefender);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitCombatTargets()
		 */
		@Override
		public List<String> getUnitCombatTargets() {
			return unitCombatTargets;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitCombatTarget(java.lang.String)
		 */
		@Override
		public void addUnitCombatTarget(String unitCombatTarget) {
			unitCombatTargets.add(unitCombatTarget);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCommercesFromKill()
		 */
		@Override
		public List<Integer> getCommercesFromKill() {
			return commercesFromKill;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addCommerceFromKill(java.lang.Integer)
		 */
		@Override
		public void addCommerceFromKill(Integer commerce) {
			commercesFromKill.add(commerce);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getYieldsFromKill()
		 */
		@Override
		public List<Integer> getYieldsFromKill() {
			return yieldsFromKill;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addYieldFromKill(java.lang.Integer)
		 */
		@Override
		public void addYieldFromKill(Integer yield) {
			yieldsFromKill.add(yield);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBonusProductionModifiers()
		 */
		@Override
		public List<IPair<String, Integer>> getBonusProductionModifiers() {
			return bonusProductionModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addBonusProductionModifier(org.archid.utils.IPair)
		 */
		@Override
		public void addBonusProductionModifier(IPair<String, Integer> bonusProductionModifier) {
			bonusProductionModifiers.add(bonusProductionModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getCorporationSpreads()
		 */
		@Override
		public List<IPair<String, Integer>> getCorporationSpreads() {
			return corporationSpreads;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addCorporationSpread(org.archid.utils.IPair)
		 */
		@Override
		public void addCorporationSpread(IPair<String, Integer> corporationSpread) {
			corporationSpreads.add(corporationSpread);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getDomainMods()
		 */
		@Override
		public List<IPair<String, Integer>> getDomainMods() {
			return domainMods;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addDomainMod(org.archid.utils.IPair)
		 */
		@Override
		public void addDomainMod(IPair<String, Integer> domainMod) {
			domainMods.add(domainMod);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFeatureAttacks()
		 */
		@Override
		public List<IPair<String, Integer>> getFeatureAttacks() {
			return featureAttacks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFeatureAttacks(org.archid.utils.IPair)
		 */
		@Override
		public void addFeatureAttacks(IPair<String, Integer> featureAttack) {
			featureAttacks.add(featureAttack);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFeatureDefenses()
		 */
		@Override
		public List<IPair<String, Integer>> getFeatureDefenses() {
			return featureDefenses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFeatureDefense(org.archid.utils.IPair)
		 */
		@Override
		public void addFeatureDefense(IPair<String, Integer> featureDefense) {
			featureDefenses.add(featureDefense);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFlankingStrikes()
		 */
		@Override
		public List<IPair<String, Integer>> getFlankingStrikes() {
			return flankingStrikes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFlankingStrike(org.archid.utils.IPair)
		 */
		@Override
		public void addFlankingStrike(IPair<String, Integer> flankingStrike) {
			flankingStrikes.add(flankingStrike);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFlavours()
		 */
		@Override
		public List<IPair<String, Integer>> getFlavours() {
			return flavours;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFlavour(org.archid.utils.IPair)
		 */
		@Override
		public void addFlavour(IPair<String, Integer> flavour) {
			flavours.add(flavour);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getProductionTraits()
		 */
		@Override
		public List<IPair<String, Integer>> getProductionTraits() {
			return productionTraits;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addProductionTrait(org.archid.utils.IPair)
		 */
		@Override
		public void addProductionTrait(IPair<String, Integer> productionTrait) {
			productionTraits.add(productionTrait);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getReligionSpreads()
		 */
		@Override
		public List<IPair<String, Integer>> getReligionSpreads() {
			return religionSpreads;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addReligionSpread(org.archid.utils.IPair)
		 */
		@Override
		public void addReligionSpread(IPair<String, Integer> religionSpread) {
			religionSpreads.add(religionSpread);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTerrainAttacks()
		 */
		@Override
		public List<IPair<String, Integer>> getTerrainAttacks() {
			return terrainAttacks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addTerrainAttack(org.archid.utils.IPair)
		 */
		@Override
		public void addTerrainAttack(IPair<String, Integer> terrainAttack) {
			terrainAttacks.add(terrainAttack);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTerrainDefenses()
		 */
		@Override
		public List<IPair<String, Integer>> getTerrainDefenses() {
			return terrainDefenses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addTerrainDefense(org.archid.utils.IPair)
		 */
		@Override
		public void addTerrainDefense(IPair<String, Integer> terrainDefense) {
			terrainDefenses.add(terrainDefense);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClassAttackMods()
		 */
		@Override
		public List<IPair<String, Integer>> getUnitClassAttackMods() {
			return unitClassAttackMods;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#UnitClassAttackMod(org.archid.utils.IPair)
		 */
		@Override
		public void addUnitClassAttackMod(IPair<String, Integer> unitClassAttackMod) {
			unitClassAttackMods.add(unitClassAttackMod);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitClassDefenseMods()
		 */
		@Override
		public List<IPair<String, Integer>> getUnitClassDefenseMods() {
			return unitClassDefenseMods;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitClassDefenseMod(org.archid.utils.IPair)
		 */
		@Override
		public void addUnitClassDefenseMod(IPair<String, Integer> unitClassDefenseMod) {
			unitClassDefenseMods.add(unitClassDefenseMod);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitCombatCollateralImmunes()
		 */
		@Override
		public List<IPair<String, Integer>> getUnitCombatCollateralImmunes() {
			return unitCombatCollateralImmunes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitCombatCollateralImmune(org.archid.utils.IPair)
		 */
		@Override
		public void addUnitCombatCollateralImmune(IPair<String, Integer> unitCombatCollateralImmune) {
			unitCombatCollateralImmunes.add(unitCombatCollateralImmune);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitCombatMods()
		 */
		@Override
		public List<IPair<String, Integer>> getUnitCombatMods() {
			return unitCombatMods;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addUnitCombatMod(org.archid.utils.IPair)
		 */
		@Override
		public void addUnitCombatMod(IPair<String, Integer> unitCombatMod) {
			unitCombatMods.add(unitCombatMod);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getBuildings()
		 */
		@Override
		public List<String> getBuildings() {
			return buildings;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addBuilding(org.archid.utils.IPair)
		 */
		@Override
		public void addBuilding(String building) {
			buildings.add(building);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getFeaturePassableTechs()
		 */
		@Override
		public List<IPair<String, String>> getFeaturePassableTechs() {
			return featurePassableTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addFeaturePassableTech(org.archid.utils.IPair)
		 */
		@Override
		public void addFeaturePassableTech(IPair<String, String> featurePassableTech) {
			featurePassableTechs.add(featurePassableTech);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getTerrainPassableTechs()
		 */
		@Override
		public List<IPair<String, String>> getTerrainPassableTechs() {
			return terrainPassableTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#addTerrainPassableTech(org.archid.utils.IPair)
		 */
		@Override
		public void addTerrainPassableTech(IPair<String, String> terrainPassableTech) {
			terrainPassableTechs.add(terrainPassableTech);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#getUnitMeshGroups()
		 */
		@Override
		public UnitMeshGroups getUnitMeshGroups() {
			return unitMeshGroups;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.unit.IUnitInfo#setUnitMeshGroups(org.archid.civ4.info.unit.UnitInfos.UnitMeshGroups)
		 */
		@Override
		public void setUnitMeshGroups(UnitMeshGroups unitMeshGroups) {
			this.unitMeshGroups = unitMeshGroups;
		}
	}
	
	@XmlJavaTypeAdapter(UnitMeshGroupsAdapter.class)
	static class UnitMeshGroups {
		private int groupSize;
		private int meleeWaveSize;
		private int rangedWaveSize;
		private float maxSpeed;
		private float padTime;
		private List<UnitMeshGroup> unitMeshGroupList = new ArrayList<UnitMeshGroup>();
		
		public int getGroupSize() {
			return groupSize;
		}
		
		public void setGroupSize(int groupSize) {
			this.groupSize = groupSize;
		}
		
		public int getMeleeWaveSize() {
			return meleeWaveSize;
		}
		
		public void setMeleeWaveSize(int meleeWaveSize) {
			this.meleeWaveSize = meleeWaveSize;
		}
		
		public int getRangedWaveSize() {
			return rangedWaveSize;
		}
		
		public void setRangedWaveSize(int rangedWaveSize) {
			this.rangedWaveSize = rangedWaveSize;
		}
		
		public float getMaxSpeed() {
			return maxSpeed;
		}
		
		public void setMaxSpeed(float maxSpeed) {
			this.maxSpeed = maxSpeed;
		}
		
		public float getPadTime() {
			return padTime;
		}
		
		public void setPadTime(float padTime) {
			this.padTime = padTime;
		}

		public List<UnitMeshGroup> getUnitMeshGroupList() {
			return unitMeshGroupList;
		}

		public void setUnitMeshGroupList(List<UnitMeshGroup> unitMeshGroupList) {
			this.unitMeshGroupList = unitMeshGroupList;
		}

	}
	
	static class UnitMeshGroup {
		private int required;
		private String earlyArtDefineTag;
		private String middleArtDefineTag;
		private String lateArtDefineTag;
		
		public int getRequired() {
			return required;
		}
		
		public void setRequired(int required) {
			this.required = required;
		}

		public String getEarlyArtDefineTag() {
			return earlyArtDefineTag;
		}

		public void setEarlyArtDefineTag(String earlyArtDefineTag) {
			this.earlyArtDefineTag = earlyArtDefineTag;
		}

		public String getMiddleArtDefineTag() {
			return middleArtDefineTag;
		}

		public void setMiddleArtDefineTag(String middleArtDefineTag) {
			this.middleArtDefineTag = middleArtDefineTag;
		}

		public String getLateArtDefineTag() {
			return lateArtDefineTag;
		}

		public void setLateArtDefineTag(String lateArtDefineTag) {
			this.lateArtDefineTag = lateArtDefineTag;
		}

	}
}
