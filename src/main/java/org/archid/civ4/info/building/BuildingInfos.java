package org.archid.civ4.info.building;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

@XmlRootElement(name="Civ4BuildingInfos", namespace="x-schema:CIV4BuildingsSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class BuildingInfos extends AbstractInfos<IBuildingInfo>{
	
	public BuildingInfos() {
		super(new LinkedHashMap<String, IBuildingInfo>());
	}
	
	@XmlJavaTypeAdapter(BuildingMapAdapter.class)
	@XmlElement(name="BuildingInfos")
	public Map<String, IBuildingInfo> getInfoMap() {
		return infos;
	}

	public static IBuildingInfo createInfo(String type) {
		return new BuildingInfo(type);
	}
	
	@Override
	public void setInfoMap(Map<String, IBuildingInfo> infos) {
		this.infos = infos;
	}
	
	private static class BuildingInfo implements IBuildingInfo {
		private String advisor;
		private String artDefineTag;
		private String buildingClass;
		private String civicOption;
		private String civilopedia;
		private String constructSound;
		private String description;
		private String diploVoteType;
		private String foundsCorporation;
		private String freeBonus;
		private String freeBuilding;
		private String freePromotion;
		private String freeStartEra;
		private String globalCorporationCommerce;
		private String globalReligionCommerce;
		private String greatPeopleUnitClass;
		private String help;
		private String holyCity;
		private String hotKey;
		private String maxStartEra;
		private String minCultureLevel;
		private String movieDefineTag;
		private String noBonus;
		private String obsoleteTech;
		private String powerBonus;
		private String prereqBonus;
		private String prereqCorporation;
		private String prereqReligion;
		private String religionType;
		private String specialBuildingType;
		private String stateReligion;
		private String strategy;
		private String type;
		private String victoryPrereq;
		private boolean isAllowsNukes;
		private boolean isAltDown;
		private boolean isAreaCleanPower;
		private boolean isAutoBuild;
		private boolean isBorderObstacle;
		private boolean isBuildingOnlyHealthy;
		private boolean isCapital;
		private boolean isCenterInCity;
		private boolean isCtrlDown;
		private boolean isDirtyPower;
		private boolean isForceDisableStarSigns;
		private boolean isForceTeamVoteEligible;
		private boolean isGoldenAge;
		private boolean isGovernmentCenter;
		private boolean isGraphicalOnly;
		private boolean isMapCentering;
		private boolean isNeverCapture;
		private boolean isNoUnhappiness;
		private boolean isNukeImmune;
		private boolean isPower;
		private boolean isPrereqPower;
		private boolean isPrereqReligion;
		private boolean isRiver;
		private boolean isShiftDown;
		private boolean isSlaveMarket;
		private boolean isStarSignGoodOnly;
		private boolean isStateReligion;
		private boolean isTeamShare;
		private boolean isWater;
		private float visibilityPriority;
		private int aIWeight;
		private int advancedStartCost;
		private int advancedStartCostIncrease;
		private int airModifier;
		private int airUnitCapacity;
		private int airlift;
		private int allCityDefense;
		private int anarchyModifier;
		private int areaFreeSpecialist;
		private int areaHappiness;
		private int areaHealth;
		private int asset;
		private int barbarianConversionCostModifier;
		private int bombardDefense;
		private int citiesPrereq;
		private int coastalTradeRoutes;
		private int conquestProb;
		private int cost;
		private int defense;
		private int domesticGreatGeneralRateModifier;
		private int enemyWarWearinessModifier;
		private int espionageDefense;
		private int experience;
		private int extraBarbarianCostChange;
		private int foodKept;
		private int foreignTradeRouteModifier;
		private int freeSpecialist;
		private int freeTechs;
		private int globalExperience;
		private int globalFreeSpecialist;
		private int globalGreatPeopleRateModifier;
		private int globalHappiness;
		private int globalHealth;
		private int globalHurryModifier;
		private int globalPopulationChange;
		private int globalSpaceProductionModifier;
		private int globalStarSignMitigateChangePercent;
		private int globalStarSignScaleChangePercent;
		private int globalTradeRoutes;
		private int globalWarWearinessModifier;
		private int goldenAgeModifier;
		private int greatGeneralRateModifier;
		private int greatPeopleRateChange;
		private int greatPeopleRateModifier;
		private int happiness;
		private int healRateChange;
		private int health;
		private int hotKeyPriority;
		private int hurryAngerModifier;
		private int hurryCostModifier;
		private int levelPrereq;
		private int maintenanceModifier;
		private int maxLatitude;
		private int militaryProductionModifier;
		private int minAreaSize;
		private int minLatitude;
		private int minPopulation;
		private int nukeExplosionRand;
		private int nukeModifier;
		private int numFreeBonuses;
		private int obsoleteDefence;
		private int orderPriority;
		private int power;
		private int spaceProductionModifier;
		private int starSignMitigateChangePercent;
		private int starSignScaleChangePercent;
		private int stateReligionHappiness;
		private int teamsPrereq;
		private int tradeRouteModifier;
		private int tradeRoutes;
		private int unhealthyPopulationModifier;
		private int warWearinessModifier;
		private int workableRadius;
		private int workerSpeedModifier;		
		private List<String> prereqAndBuildingClasses = new ArrayList<String>();
		private List<String> prereqAndCivics = new ArrayList<String>();
		private List<String> prereqAndTechs = new ArrayList<String>();
		private List<String> prereqAndTerrains = new ArrayList<String>();
		private List<String> prereqNotBuildingClasses = new ArrayList<String>();
		private List<String> prereqOrBonuses = new ArrayList<String>();
		private List<String> prereqOrBuildingClasses = new ArrayList<String>();
		private List<String> prereqOrCivics = new ArrayList<String>();
		private List<String> prereqOrTerrains = new ArrayList<String>();
		private List<String> prereqVicinityAndBonuses = new ArrayList<String>();
		private List<String> prereqVicinityFeatures = new ArrayList<String>();
		private List<String> prereqVicinityImprovements = new ArrayList<String>();
		private List<String> prereqVicinityOrBonuses = new ArrayList<String>();
		private List<String> prereqWorldViews = new ArrayList<String>();
		private List<String> replacedByBuildingClasses = new ArrayList<String>();
		private List<Integer> areaYieldModifiers = new ArrayList<Integer>();
		private List<Integer> commerceChangeDoubleTimes = new ArrayList<Integer>();
		private List<Integer> commerceChangeOriginalOwners = new ArrayList<Integer>();
		private List<Integer> commerceChanges = new ArrayList<Integer>();
		private List<Integer> commerceFlexibles = new ArrayList<Integer>();
		private List<Integer> commerceHappinesses = new ArrayList<Integer>();
		private List<Integer> commerceModifiers = new ArrayList<Integer>();
		private List<Integer> globalCommerceModifiers = new ArrayList<Integer>();
		private List<Integer> globalSeaPlotYieldChanges = new ArrayList<Integer>();
		private List<Integer> globalYieldModifiers = new ArrayList<Integer>();
		private List<Integer> obsoleteSafeCommerceChanges = new ArrayList<Integer>();
		private List<Integer> powerYieldModifiers = new ArrayList<Integer>();
		private List<Integer> riverPlotYieldChanges = new ArrayList<Integer>();
		private List<Integer> seaPlotYieldChanges = new ArrayList<Integer>();
		private List<Integer> specialistExtraCommerces = new ArrayList<Integer>();
		private List<Integer> stateReligionCommerces = new ArrayList<Integer>();
		private List<Integer> yieldChanges = new ArrayList<Integer>();
		private List<Integer> yieldModifiers = new ArrayList<Integer>();
		private List<IPair<String, Integer>> bonusHappinessChanges = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> bonusHealthChanges = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> bonusProductionModifiers = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> buildingHappinessChanges = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> domainFreeExperiences = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> domainProductionModifiers = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> flavors = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> freeSpecialistCounts = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> happinessTraits = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> improvementFreeSpecialists = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> prereqNumOfBuildingClasses = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> productionTraits = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> religionChanges = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> specialistCounts = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> unitCombatFreeExperiences = new ArrayList<IPair<String, Integer>>();
		private Map<String, List<Integer>> bonusYieldModifiers = new TreeMap<String, List<Integer>>();
		private Map<String, List<Integer>> specialistYieldChanges = new TreeMap<String, List<Integer>>();
		private Map<String, List<Integer>> vicinityBonusYieldChanges = new TreeMap<String, List<Integer>>();
		
		private BuildingInfo(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAdvisor()
		 */
		@Override
		public String getAdvisor() {
			return advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAdvisor(java.lang.String)
		 */
		@Override
		public void setAdvisor(String advisor) {
			this.advisor = advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getArtDefineTag()
		 */
		@Override
		public String getArtDefineTag() {
			return artDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setArtDefineTag(java.lang.String)
		 */
		@Override
		public void setArtDefineTag(String artDefineTag) {
			this.artDefineTag = artDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBuildingClass()
		 */
		@Override
		public String getBuildingClass() {
			return buildingClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setBuildingClass(java.lang.String)
		 */
		@Override
		public void setBuildingClass(String buildingClass) {
			this.buildingClass = buildingClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCivicOption()
		 */
		@Override
		public String getCivicOption() {
			return civicOption;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCivicOption(java.lang.String)
		 */
		@Override
		public void setCivicOption(String civicOption) {
			this.civicOption = civicOption;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCivilopedia()
		 */
		@Override
		public String getCivilopedia() {
			return civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCivilopedia(java.lang.String)
		 */
		@Override
		public void setCivilopedia(String civilopedia) {
			this.civilopedia = civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getConstructSound()
		 */
		@Override
		public String getConstructSound() {
			return constructSound;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setConstructSound(java.lang.String)
		 */
		@Override
		public void setConstructSound(String constructSound) {
			this.constructSound = constructSound;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDiploVoteType()
		 */
		@Override
		public String getDiploVoteType() {
			return diploVoteType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setDiploVoteType(java.lang.String)
		 */
		@Override
		public void setDiploVoteType(String diploVoteType) {
			this.diploVoteType = diploVoteType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFoundsCorporation()
		 */
		@Override
		public String getFoundsCorporation() {
			return foundsCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFoundsCorporation(java.lang.String)
		 */
		@Override
		public void setFoundsCorporation(String foundsCorporation) {
			this.foundsCorporation = foundsCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeBonus()
		 */
		@Override
		public String getFreeBonus() {
			return freeBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreeBonus(java.lang.String)
		 */
		@Override
		public void setFreeBonus(String freeBonus) {
			this.freeBonus = freeBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeBuilding()
		 */
		@Override
		public String getFreeBuilding() {
			return freeBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreeBuilding(java.lang.String)
		 */
		@Override
		public void setFreeBuilding(String freeBuilding) {
			this.freeBuilding = freeBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreePromotion()
		 */
		@Override
		public String getFreePromotion() {
			return freePromotion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreePromotion(java.lang.String)
		 */
		@Override
		public void setFreePromotion(String freePromotion) {
			this.freePromotion = freePromotion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeStartEra()
		 */
		@Override
		public String getFreeStartEra() {
			return freeStartEra;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreeStartEra(java.lang.String)
		 */
		@Override
		public void setFreeStartEra(String freeStartEra) {
			this.freeStartEra = freeStartEra;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalCorporationCommerce()
		 */
		@Override
		public String getGlobalCorporationCommerce() {
			return globalCorporationCommerce;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalCorporationCommerce(java.lang.String)
		 */
		@Override
		public void setGlobalCorporationCommerce(String globalCorporationCommerce) {
			this.globalCorporationCommerce = globalCorporationCommerce;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalReligionCommerce()
		 */
		@Override
		public String getGlobalReligionCommerce() {
			return globalReligionCommerce;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalReligionCommerce(java.lang.String)
		 */
		@Override
		public void setGlobalReligionCommerce(String globalReligionCommerce) {
			this.globalReligionCommerce = globalReligionCommerce;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGreatPeopleUnitClass()
		 */
		@Override
		public String getGreatPeopleUnitClass() {
			return greatPeopleUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGreatPeopleUnitClass(java.lang.String)
		 */
		@Override
		public void setGreatPeopleUnitClass(String greatPeopleUnitClass) {
			this.greatPeopleUnitClass = greatPeopleUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHelp()
		 */
		@Override
		public String getHelp() {
			return help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHelp(java.lang.String)
		 */
		@Override
		public void setHelp(String help) {
			this.help = help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHolyCity()
		 */
		@Override
		public String getHolyCity() {
			return holyCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHolyCity(java.lang.String)
		 */
		@Override
		public void setHolyCity(String holyCity) {
			this.holyCity = holyCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHotKey()
		 */
		@Override
		public String getHotKey() {
			return hotKey;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHotKey(java.lang.String)
		 */
		@Override
		public void setHotKey(String hotKey) {
			this.hotKey = hotKey;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMaxStartEra()
		 */
		@Override
		public String getMaxStartEra() {
			return maxStartEra;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMaxStartEra(java.lang.String)
		 */
		@Override
		public void setMaxStartEra(String maxStartEra) {
			this.maxStartEra = maxStartEra;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMinCultureLevel()
		 */
		@Override
		public String getMinCultureLevel() {
			return minCultureLevel;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMinCultureLevel(java.lang.String)
		 */
		@Override
		public void setMinCultureLevel(String minCultureLevel) {
			this.minCultureLevel = minCultureLevel;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMovieDefineTag()
		 */
		@Override
		public String getMovieDefineTag() {
			return movieDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMovieDefineTag(java.lang.String)
		 */
		@Override
		public void setMovieDefineTag(String movieDefineTag) {
			this.movieDefineTag = movieDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getNoBonus()
		 */
		@Override
		public String getNoBonus() {
			return noBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNoBonus(java.lang.String)
		 */
		@Override
		public void setNoBonus(String noBonus) {
			this.noBonus = noBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getObsoleteTech()
		 */
		@Override
		public String getObsoleteTech() {
			return obsoleteTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setObsoleteTech(java.lang.String)
		 */
		@Override
		public void setObsoleteTech(String obsoleteTech) {
			this.obsoleteTech = obsoleteTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPowerBonus()
		 */
		@Override
		public String getPowerBonus() {
			return powerBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPowerBonus(java.lang.String)
		 */
		@Override
		public void setPowerBonus(String powerBonus) {
			this.powerBonus = powerBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqCorporation()
		 */
		@Override
		public String getPrereqCorporation() {
			return prereqCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPrereqCorporation(java.lang.String)
		 */
		@Override
		public void setPrereqCorporation(String prereqCorporation) {
			this.prereqCorporation = prereqCorporation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqReligion()
		 */
		@Override
		public String getPrereqReligion() {
			return prereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPrereqReligion(java.lang.String)
		 */
		@Override
		public void setPrereqReligion(String prereqReligion) {
			this.prereqReligion = prereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getReligionType()
		 */
		@Override
		public String getReligionType() {
			return religionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setReligionType(java.lang.String)
		 */
		@Override
		public void setReligionType(String religionType) {
			this.religionType = religionType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSpecialBuildingType()
		 */
		@Override
		public String getSpecialBuildingType() {
			return specialBuildingType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setSpecialBuildingType(java.lang.String)
		 */
		@Override
		public void setSpecialBuildingType(String specialBuildingType) {
			this.specialBuildingType = specialBuildingType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStateReligion()
		 */
		@Override
		public String getStateReligion() {
			return stateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStateReligion(java.lang.String)
		 */
		@Override
		public void setStateReligion(String stateReligion) {
			this.stateReligion = stateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStrategy()
		 */
		@Override
		public String getStrategy() {
			return strategy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStrategy(java.lang.String)
		 */
		@Override
		public void setStrategy(String strategy) {
			this.strategy = strategy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getVictoryPrereq()
		 */
		@Override
		public String getVictoryPrereq() {
			return victoryPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setVictoryPrereq(java.lang.String)
		 */
		@Override
		public void setVictoryPrereq(String victoryPrereq) {
			this.victoryPrereq = victoryPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isAllowsNukes()
		 */
		@Override
		public boolean isAllowsNukes() {
			return isAllowsNukes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAllowsNukes(boolean)
		 */
		@Override
		public void setAllowsNukes(boolean isAllowsNukes) {
			this.isAllowsNukes = isAllowsNukes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isAltDown()
		 */
		@Override
		public boolean isAltDown() {
			return isAltDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAltDown(boolean)
		 */
		@Override
		public void setAltDown(boolean isAltDown) {
			this.isAltDown = isAltDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isAreaCleanPower()
		 */
		@Override
		public boolean isAreaCleanPower() {
			return isAreaCleanPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAreaCleanPower(boolean)
		 */
		@Override
		public void setAreaCleanPower(boolean isAreaCleanPower) {
			this.isAreaCleanPower = isAreaCleanPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isAutoBuild()
		 */
		@Override
		public boolean isAutoBuild() {
			return isAutoBuild;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAutoBuild(boolean)
		 */
		@Override
		public void setAutoBuild(boolean isAutoBuild) {
			this.isAutoBuild = isAutoBuild;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isBorderObstacle()
		 */
		@Override
		public boolean isBorderObstacle() {
			return isBorderObstacle;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setBorderObstacle(boolean)
		 */
		@Override
		public void setBorderObstacle(boolean isBorderObstacle) {
			this.isBorderObstacle = isBorderObstacle;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isBuildingOnlyHealthy()
		 */
		@Override
		public boolean isBuildingOnlyHealthy() {
			return isBuildingOnlyHealthy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setBuildingOnlyHealthy(boolean)
		 */
		@Override
		public void setBuildingOnlyHealthy(boolean isBuildingOnlyHealthy) {
			this.isBuildingOnlyHealthy = isBuildingOnlyHealthy;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isCapital()
		 */
		@Override
		public boolean isCapital() {
			return isCapital;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCapital(boolean)
		 */
		@Override
		public void setCapital(boolean isCapital) {
			this.isCapital = isCapital;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isCenterInCity()
		 */
		@Override
		public boolean isCenterInCity() {
			return isCenterInCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCenterInCity(boolean)
		 */
		@Override
		public void setCenterInCity(boolean isCenterInCity) {
			this.isCenterInCity = isCenterInCity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isCtrlDown()
		 */
		@Override
		public boolean isCtrlDown() {
			return isCtrlDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCtrlDown(boolean)
		 */
		@Override
		public void setCtrlDown(boolean isCtrlDown) {
			this.isCtrlDown = isCtrlDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isDirtyPower()
		 */
		@Override
		public boolean isDirtyPower() {
			return isDirtyPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setDirtyPower(boolean)
		 */
		@Override
		public void setDirtyPower(boolean isDirtyPower) {
			this.isDirtyPower = isDirtyPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isForceDisableStarSigns()
		 */
		@Override
		public boolean isForceDisableStarSigns() {
			return isForceDisableStarSigns;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setForceDisableStarSigns(boolean)
		 */
		@Override
		public void setForceDisableStarSigns(boolean isForceDisableStarSigns) {
			this.isForceDisableStarSigns = isForceDisableStarSigns;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isForceTeamVoteEligible()
		 */
		@Override
		public boolean isForceTeamVoteEligible() {
			return isForceTeamVoteEligible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setForceTeamVoteEligible(boolean)
		 */
		@Override
		public void setForceTeamVoteEligible(boolean isForceTeamVoteEligible) {
			this.isForceTeamVoteEligible = isForceTeamVoteEligible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isGoldenAge()
		 */
		@Override
		public boolean isGoldenAge() {
			return isGoldenAge;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGoldenAge(boolean)
		 */
		@Override
		public void setGoldenAge(boolean isGoldenAge) {
			this.isGoldenAge = isGoldenAge;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isGovernmentCenter()
		 */
		@Override
		public boolean isGovernmentCenter() {
			return isGovernmentCenter;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGovernmentCenter(boolean)
		 */
		@Override
		public void setGovernmentCenter(boolean isGovernmentCenter) {
			this.isGovernmentCenter = isGovernmentCenter;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isMapCentering()
		 */
		@Override
		public boolean isMapCentering() {
			return isMapCentering;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMapCentering(boolean)
		 */
		@Override
		public void setMapCentering(boolean isMapCentering) {
			this.isMapCentering = isMapCentering;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isNeverCapture()
		 */
		@Override
		public boolean isNeverCapture() {
			return isNeverCapture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNeverCapture(boolean)
		 */
		@Override
		public void setNeverCapture(boolean isNeverCapture) {
			this.isNeverCapture = isNeverCapture;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isNoUnhappiness()
		 */
		@Override
		public boolean isNoUnhappiness() {
			return isNoUnhappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNoUnhappiness(boolean)
		 */
		@Override
		public void setNoUnhappiness(boolean isNoUnhappiness) {
			this.isNoUnhappiness = isNoUnhappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isNukeImmune()
		 */
		@Override
		public boolean isNukeImmune() {
			return isNukeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNukeImmune(boolean)
		 */
		@Override
		public void setNukeImmune(boolean isNukeImmune) {
			this.isNukeImmune = isNukeImmune;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isPower()
		 */
		@Override
		public boolean isPower() {
			return isPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPower(boolean)
		 */
		@Override
		public void setPower(boolean isPower) {
			this.isPower = isPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isPrereqPower()
		 */
		@Override
		public boolean isPrereqPower() {
			return isPrereqPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPrereqPower(boolean)
		 */
		@Override
		public void setPrereqPower(boolean isPrereqPower) {
			this.isPrereqPower = isPrereqPower;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isPrereqReligion()
		 */
		@Override
		public boolean isPrereqReligion() {
			return isPrereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPrereqReligion(boolean)
		 */
		@Override
		public void setPrereqReligion(boolean isPrereqReligion) {
			this.isPrereqReligion = isPrereqReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isRiver()
		 */
		@Override
		public boolean isRiver() {
			return isRiver;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setRiver(boolean)
		 */
		@Override
		public void setRiver(boolean isRiver) {
			this.isRiver = isRiver;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isShiftDown()
		 */
		@Override
		public boolean isShiftDown() {
			return isShiftDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setShiftDown(boolean)
		 */
		@Override
		public void setShiftDown(boolean isShiftDown) {
			this.isShiftDown = isShiftDown;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isSlaveMarket()
		 */
		@Override
		public boolean isSlaveMarket() {
			return isSlaveMarket;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setSlaveMarket(boolean)
		 */
		@Override
		public void setSlaveMarket(boolean isSlaveMarket) {
			this.isSlaveMarket = isSlaveMarket;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isStarSignGoodOnly()
		 */
		@Override
		public boolean isStarSignGoodOnly() {
			return isStarSignGoodOnly;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStarSignGoodOnly(boolean)
		 */
		@Override
		public void setStarSignGoodOnly(boolean isStarSignGoodOnly) {
			this.isStarSignGoodOnly = isStarSignGoodOnly;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isStateReligion()
		 */
		@Override
		public boolean isStateReligion() {
			return isStateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStateReligion(boolean)
		 */
		@Override
		public void setStateReligion(boolean isStateReligion) {
			this.isStateReligion = isStateReligion;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isTeamShare()
		 */
		@Override
		public boolean isTeamShare() {
			return isTeamShare;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setTeamShare(boolean)
		 */
		@Override
		public void setTeamShare(boolean isTeamShare) {
			this.isTeamShare = isTeamShare;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#isWater()
		 */
		@Override
		public boolean isWater() {
			return isWater;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setWater(boolean)
		 */
		@Override
		public void setWater(boolean isWater) {
			this.isWater = isWater;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getVisibilityPriority()
		 */
		@Override
		public float getVisibilityPriority() {
			return visibilityPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setVisibilityPriority(float)
		 */
		@Override
		public void setVisibilityPriority(float visibilityPriority) {
			this.visibilityPriority = visibilityPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getaIWeight()
		 */
		@Override
		public int getAIWeight() {
			return aIWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setaIWeight(int)
		 */
		@Override
		public void setAIWeight(int aIWeight) {
			this.aIWeight = aIWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAdvancedStartCost()
		 */
		@Override
		public int getAdvancedStartCost() {
			return advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAdvancedStartCost(int)
		 */
		@Override
		public void setAdvancedStartCost(int advancedStartCost) {
			this.advancedStartCost = advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAdvancedStartCostIncrease()
		 */
		@Override
		public int getAdvancedStartCostIncrease() {
			return advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAdvancedStartCostIncrease(int)
		 */
		@Override
		public void setAdvancedStartCostIncrease(int advancedStartCostIncrease) {
			this.advancedStartCostIncrease = advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAirModifier()
		 */
		@Override
		public int getAirModifier() {
			return airModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAirModifier(int)
		 */
		@Override
		public void setAirModifier(int airModifier) {
			this.airModifier = airModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAirUnitCapacity()
		 */
		@Override
		public int getAirUnitCapacity() {
			return airUnitCapacity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAirUnitCapacity(int)
		 */
		@Override
		public void setAirUnitCapacity(int airUnitCapacity) {
			this.airUnitCapacity = airUnitCapacity;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAirlift()
		 */
		@Override
		public int getAirlift() {
			return airlift;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAirlift(int)
		 */
		@Override
		public void setAirlift(int airlift) {
			this.airlift = airlift;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAllCityDefense()
		 */
		@Override
		public int getAllCityDefense() {
			return allCityDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAllCityDefense(int)
		 */
		@Override
		public void setAllCityDefense(int allCityDefense) {
			this.allCityDefense = allCityDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAnarchyModifier()
		 */
		@Override
		public int getAnarchyModifier() {
			return anarchyModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAnarchyModifier(int)
		 */
		@Override
		public void setAnarchyModifier(int anarchyModifier) {
			this.anarchyModifier = anarchyModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAreaFreeSpecialist()
		 */
		@Override
		public int getAreaFreeSpecialist() {
			return areaFreeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAreaFreeSpecialist(int)
		 */
		@Override
		public void setAreaFreeSpecialist(int areaFreeSpecialist) {
			this.areaFreeSpecialist = areaFreeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAreaHappiness()
		 */
		@Override
		public int getAreaHappiness() {
			return areaHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAreaHappiness(int)
		 */
		@Override
		public void setAreaHappiness(int areaHappiness) {
			this.areaHappiness = areaHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAreaHealth()
		 */
		@Override
		public int getAreaHealth() {
			return areaHealth;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAreaHealth(int)
		 */
		@Override
		public void setAreaHealth(int areaHealth) {
			this.areaHealth = areaHealth;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAsset()
		 */
		@Override
		public int getAsset() {
			return asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setAsset(int)
		 */
		@Override
		public void setAsset(int asset) {
			this.asset = asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBombardDefense()
		 */
		@Override
		public int getBombardDefense() {
			return bombardDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setBombardDefense(int)
		 */
		@Override
		public void setBombardDefense(int bombardDefense) {
			this.bombardDefense = bombardDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCitiesPrereq()
		 */
		@Override
		public int getCitiesPrereq() {
			return citiesPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCitiesPrereq(int)
		 */
		@Override
		public void setCitiesPrereq(int citiesPrereq) {
			this.citiesPrereq = citiesPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCoastalTradeRoutes()
		 */
		@Override
		public int getCoastalTradeRoutes() {
			return coastalTradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCoastalTradeRoutes(int)
		 */
		@Override
		public void setCoastalTradeRoutes(int coastalTradeRoutes) {
			this.coastalTradeRoutes = coastalTradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getConquestProb()
		 */
		@Override
		public int getConquestProb() {
			return conquestProb;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setConquestProb(int)
		 */
		@Override
		public void setConquestProb(int conquestProb) {
			this.conquestProb = conquestProb;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCost()
		 */
		@Override
		public int getCost() {
			return cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setCost(int)
		 */
		@Override
		public void setCost(int cost) {
			this.cost = cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDefense()
		 */
		@Override
		public int getDefense() {
			return defense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setDefense(int)
		 */
		@Override
		public void setDefense(int defense) {
			this.defense = defense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDomesticGreatGeneralRateModifier()
		 */
		@Override
		public int getDomesticGreatGeneralRateModifier() {
			return domesticGreatGeneralRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setDomesticGreatGeneralRateModifier(int)
		 */
		@Override
		public void setDomesticGreatGeneralRateModifier(int domesticGreatGeneralRateModifier) {
			this.domesticGreatGeneralRateModifier = domesticGreatGeneralRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getEnemyWarWearinessModifier()
		 */
		@Override
		public int getEnemyWarWearinessModifier() {
			return enemyWarWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setEnemyWarWearinessModifier(int)
		 */
		@Override
		public void setEnemyWarWearinessModifier(int enemyWarWearinessModifier) {
			this.enemyWarWearinessModifier = enemyWarWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getEspionageDefense()
		 */
		@Override
		public int getEspionageDefense() {
			return espionageDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setEspionageDefense(int)
		 */
		@Override
		public void setEspionageDefense(int espionageDefense) {
			this.espionageDefense = espionageDefense;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getExperience()
		 */
		@Override
		public int getExperience() {
			return experience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setExperience(int)
		 */
		@Override
		public void setExperience(int experience) {
			this.experience = experience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFoodKept()
		 */
		@Override
		public int getFoodKept() {
			return foodKept;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFoodKept(int)
		 */
		@Override
		public void setFoodKept(int foodKept) {
			this.foodKept = foodKept;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getForeignTradeRouteModifier()
		 */
		@Override
		public int getForeignTradeRouteModifier() {
			return foreignTradeRouteModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setForeignTradeRouteModifier(int)
		 */
		@Override
		public void setForeignTradeRouteModifier(int foreignTradeRouteModifier) {
			this.foreignTradeRouteModifier = foreignTradeRouteModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeSpecialist()
		 */
		@Override
		public int getFreeSpecialist() {
			return freeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreeSpecialist(int)
		 */
		@Override
		public void setFreeSpecialist(int freeSpecialist) {
			this.freeSpecialist = freeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeTechs()
		 */
		@Override
		public int getFreeTechs() {
			return freeTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setFreeTechs(int)
		 */
		@Override
		public void setFreeTechs(int freeTechs) {
			this.freeTechs = freeTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalExperience()
		 */
		@Override
		public int getGlobalExperience() {
			return globalExperience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalExperience(int)
		 */
		@Override
		public void setGlobalExperience(int globalExperience) {
			this.globalExperience = globalExperience;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalFreeSpecialist()
		 */
		@Override
		public int getGlobalFreeSpecialist() {
			return globalFreeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalFreeSpecialist(int)
		 */
		@Override
		public void setGlobalFreeSpecialist(int globalFreeSpecialist) {
			this.globalFreeSpecialist = globalFreeSpecialist;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalGreatPeopleRateModifier()
		 */
		@Override
		public int getGlobalGreatPeopleRateModifier() {
			return globalGreatPeopleRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalGreatPeopleRateModifier(int)
		 */
		@Override
		public void setGlobalGreatPeopleRateModifier(int globalGreatPeopleRateModifier) {
			this.globalGreatPeopleRateModifier = globalGreatPeopleRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalHappiness()
		 */
		@Override
		public int getGlobalHappiness() {
			return globalHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalHappiness(int)
		 */
		@Override
		public void setGlobalHappiness(int globalHappiness) {
			this.globalHappiness = globalHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalHealth()
		 */
		@Override
		public int getGlobalHealth() {
			return globalHealth;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalHealth(int)
		 */
		@Override
		public void setGlobalHealth(int globalHealth) {
			this.globalHealth = globalHealth;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalHurryModifier()
		 */
		@Override
		public int getGlobalHurryModifier() {
			return globalHurryModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalHurryModifier(int)
		 */
		@Override
		public void setGlobalHurryModifier(int globalHurryModifier) {
			this.globalHurryModifier = globalHurryModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalPopulationChange()
		 */
		@Override
		public int getGlobalPopulationChange() {
			return globalPopulationChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalPopulationChange(int)
		 */
		@Override
		public void setGlobalPopulationChange(int globalPopulationChange) {
			this.globalPopulationChange = globalPopulationChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalSpaceProductionModifier()
		 */
		@Override
		public int getGlobalSpaceProductionModifier() {
			return globalSpaceProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalSpaceProductionModifier(int)
		 */
		@Override
		public void setGlobalSpaceProductionModifier(int globalSpaceProductionModifier) {
			this.globalSpaceProductionModifier = globalSpaceProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalStarSignMitigateChangePercent()
		 */
		@Override
		public int getGlobalStarSignMitigateChangePercent() {
			return globalStarSignMitigateChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalStarSignMitigateChangePercent(int)
		 */
		@Override
		public void setGlobalStarSignMitigateChangePercent(int globalStarSignMitigateChangePercent) {
			this.globalStarSignMitigateChangePercent = globalStarSignMitigateChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalStarSignScaleChangePercent()
		 */
		@Override
		public int getGlobalStarSignScaleChangePercent() {
			return globalStarSignScaleChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalStarSignScaleChangePercent(int)
		 */
		@Override
		public void setGlobalStarSignScaleChangePercent(int globalStarSignScaleChangePercent) {
			this.globalStarSignScaleChangePercent = globalStarSignScaleChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalTradeRoutes()
		 */
		@Override
		public int getGlobalTradeRoutes() {
			return globalTradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalTradeRoutes(int)
		 */
		@Override
		public void setGlobalTradeRoutes(int globalTradeRoutes) {
			this.globalTradeRoutes = globalTradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalWarWearinessModifier()
		 */
		@Override
		public int getGlobalWarWearinessModifier() {
			return globalWarWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGlobalWarWearinessModifier(int)
		 */
		@Override
		public void setGlobalWarWearinessModifier(int globalWarWearinessModifier) {
			this.globalWarWearinessModifier = globalWarWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGoldenAgeModifier()
		 */
		@Override
		public int getGoldenAgeModifier() {
			return goldenAgeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGoldenAgeModifier(int)
		 */
		@Override
		public void setGoldenAgeModifier(int goldenAgeModifier) {
			this.goldenAgeModifier = goldenAgeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGreatGeneralRateModifier()
		 */
		@Override
		public int getGreatGeneralRateModifier() {
			return greatGeneralRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGreatGeneralRateModifier(int)
		 */
		@Override
		public void setGreatGeneralRateModifier(int greatGeneralRateModifier) {
			this.greatGeneralRateModifier = greatGeneralRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGreatPeopleRateChange()
		 */
		@Override
		public int getGreatPeopleRateChange() {
			return greatPeopleRateChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGreatPeopleRateChange(int)
		 */
		@Override
		public void setGreatPeopleRateChange(int greatPeopleRateChange) {
			this.greatPeopleRateChange = greatPeopleRateChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGreatPeopleRateModifier()
		 */
		@Override
		public int getGreatPeopleRateModifier() {
			return greatPeopleRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setGreatPeopleRateModifier(int)
		 */
		@Override
		public void setGreatPeopleRateModifier(int greatPeopleRateModifier) {
			this.greatPeopleRateModifier = greatPeopleRateModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHappiness()
		 */
		@Override
		public int getHappiness() {
			return happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHappiness(int)
		 */
		@Override
		public void setHappiness(int happiness) {
			this.happiness = happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHealRateChange()
		 */
		@Override
		public int getHealRateChange() {
			return healRateChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHealRateChange(int)
		 */
		@Override
		public void setHealRateChange(int healRateChange) {
			this.healRateChange = healRateChange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHealth()
		 */
		@Override
		public int getHealth() {
			return health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHealth(int)
		 */
		@Override
		public void setHealth(int health) {
			this.health = health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHotKeyPriority()
		 */
		@Override
		public int getHotKeyPriority() {
			return hotKeyPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHotKeyPriority(int)
		 */
		@Override
		public void setHotKeyPriority(int hotKeyPriority) {
			this.hotKeyPriority = hotKeyPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHurryAngerModifier()
		 */
		@Override
		public int getHurryAngerModifier() {
			return hurryAngerModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHurryAngerModifier(int)
		 */
		@Override
		public void setHurryAngerModifier(int hurryAngerModifier) {
			this.hurryAngerModifier = hurryAngerModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHurryCostModifier()
		 */
		@Override
		public int getHurryCostModifier() {
			return hurryCostModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setHurryCostModifier(int)
		 */
		@Override
		public void setHurryCostModifier(int hurryCostModifier) {
			this.hurryCostModifier = hurryCostModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getLevelPrereq()
		 */
		@Override
		public int getLevelPrereq() {
			return levelPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setLevelPrereq(int)
		 */
		@Override
		public void setLevelPrereq(int levelPrereq) {
			this.levelPrereq = levelPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMaintenanceModifier()
		 */
		@Override
		public int getMaintenanceModifier() {
			return maintenanceModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMaintenanceModifier(int)
		 */
		@Override
		public void setMaintenanceModifier(int maintenanceModifier) {
			this.maintenanceModifier = maintenanceModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMaxLatitude()
		 */
		@Override
		public int getMaxLatitude() {
			return maxLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMaxLatitude(int)
		 */
		@Override
		public void setMaxLatitude(int maxLatitude) {
			this.maxLatitude = maxLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMilitaryProductionModifier()
		 */
		@Override
		public int getMilitaryProductionModifier() {
			return militaryProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMilitaryProductionModifier(int)
		 */
		@Override
		public void setMilitaryProductionModifier(int militaryProductionModifier) {
			this.militaryProductionModifier = militaryProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMinAreaSize()
		 */
		@Override
		public int getMinAreaSize() {
			return minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMinAreaSize(int)
		 */
		@Override
		public void setMinAreaSize(int minAreaSize) {
			this.minAreaSize = minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMinLatitude()
		 */
		@Override
		public int getMinLatitude() {
			return minLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMinLatitude(int)
		 */
		@Override
		public void setMinLatitude(int minLatitude) {
			this.minLatitude = minLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getMinPopulation()
		 */
		@Override
		public int getMinPopulation() {
			return minPopulation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setMinPopulation(int)
		 */
		@Override
		public void setMinPopulation(int minPopulation) {
			this.minPopulation = minPopulation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getNukeExplosionRand()
		 */
		@Override
		public int getNukeExplosionRand() {
			return nukeExplosionRand;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNukeExplosionRand(int)
		 */
		@Override
		public void setNukeExplosionRand(int nukeExplosionRand) {
			this.nukeExplosionRand = nukeExplosionRand;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getNukeModifier()
		 */
		@Override
		public int getNukeModifier() {
			return nukeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNukeModifier(int)
		 */
		@Override
		public void setNukeModifier(int nukeModifier) {
			this.nukeModifier = nukeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getNumFreeBonuses()
		 */
		@Override
		public int getNumFreeBonuses() {
			return numFreeBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setNumFreeBonuses(int)
		 */
		@Override
		public void setNumFreeBonuses(int numFreeBonuses) {
			this.numFreeBonuses = numFreeBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getOrderPriority()
		 */
		@Override
		public int getOrderPriority() {
			return orderPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setOrderPriority(int)
		 */
		@Override
		public void setOrderPriority(int orderPriority) {
			this.orderPriority = orderPriority;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPower()
		 */
		@Override
		public int getPower() {
			return power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setPower(int)
		 */
		@Override
		public void setPower(int power) {
			this.power = power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSpaceProductionModifier()
		 */
		@Override
		public int getSpaceProductionModifier() {
			return spaceProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setSpaceProductionModifier(int)
		 */
		@Override
		public void setSpaceProductionModifier(int spaceProductionModifier) {
			this.spaceProductionModifier = spaceProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStarSignMitigateChangePercent()
		 */
		@Override
		public int getStarSignMitigateChangePercent() {
			return starSignMitigateChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStarSignMitigateChangePercent(int)
		 */
		@Override
		public void setStarSignMitigateChangePercent(int starSignMitigateChangePercent) {
			this.starSignMitigateChangePercent = starSignMitigateChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStarSignScaleChangePercent()
		 */
		@Override
		public int getStarSignScaleChangePercent() {
			return starSignScaleChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStarSignScaleChangePercent(int)
		 */
		@Override
		public void setStarSignScaleChangePercent(int starSignScaleChangePercent) {
			this.starSignScaleChangePercent = starSignScaleChangePercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStateReligionHappiness()
		 */
		@Override
		public int getStateReligionHappiness() {
			return stateReligionHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setStateReligionHappiness(int)
		 */
		@Override
		public void setStateReligionHappiness(int stateReligionHappiness) {
			this.stateReligionHappiness = stateReligionHappiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getTeamsPrereq()
		 */
		@Override
		public int getTeamsPrereq() {
			return teamsPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setTeamsPrereq(int)
		 */
		@Override
		public void setTeamsPrereq(int teamsPrereq) {
			this.teamsPrereq = teamsPrereq;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getTradeRouteModifier()
		 */
		@Override
		public int getTradeRouteModifier() {
			return tradeRouteModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setTradeRouteModifier(int)
		 */
		@Override
		public void setTradeRouteModifier(int tradeRouteModifier) {
			this.tradeRouteModifier = tradeRouteModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getTradeRoutes()
		 */
		@Override
		public int getTradeRoutes() {
			return tradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setTradeRoutes(int)
		 */
		@Override
		public void setTradeRoutes(int tradeRoutes) {
			this.tradeRoutes = tradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getUnhealthyPopulationModifier()
		 */
		@Override
		public int getUnhealthyPopulationModifier() {
			return unhealthyPopulationModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setUnhealthyPopulationModifier(int)
		 */
		@Override
		public void setUnhealthyPopulationModifier(int unhealthyPopulationModifier) {
			this.unhealthyPopulationModifier = unhealthyPopulationModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getWarWearinessModifier()
		 */
		@Override
		public int getWarWearinessModifier() {
			return warWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setWarWearinessModifier(int)
		 */
		@Override
		public void setWarWearinessModifier(int warWearinessModifier) {
			this.warWearinessModifier = warWearinessModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getWorkableRadius()
		 */
		@Override
		public int getWorkableRadius() {
			return workableRadius;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setWorkableRadius(int)
		 */
		@Override
		public void setWorkableRadius(int workableRadius) {
			this.workableRadius = workableRadius;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getWorkerSpeedModifier()
		 */
		@Override
		public int getWorkerSpeedModifier() {
			return workerSpeedModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#setWorkerSpeedModifier(int)
		 */
		@Override
		public void setWorkerSpeedModifier(int workerSpeedModifier) {
			this.workerSpeedModifier = workerSpeedModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getAreaYieldModifiers()
		 */
		@Override
		public List<Integer> getAreaYieldModifiers() {
			return areaYieldModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addAreaYieldModifier(java.lang.String)
		 */
		@Override
		public void addAreaYieldModifier(Integer areaYieldModifier) {
			areaYieldModifiers.add(areaYieldModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceChangeDoubleTimes()
		 */
		@Override
		public List<Integer> getCommerceChangeDoubleTimes() {
			return commerceChangeDoubleTimes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceChangeDoubleTime(java.lang.String)
		 */
		@Override
		public void addCommerceChangeDoubleTime(Integer commerceChangeDoubleTime) {
			commerceChangeDoubleTimes.add(commerceChangeDoubleTime);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceChangeOriginalOwners()
		 */
		@Override
		public List<Integer> getCommerceChangeOriginalOwners() {
			return commerceChangeOriginalOwners;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceChangeOriginalOwner(java.lang.String)
		 */
		@Override
		public void addCommerceChangeOriginalOwner(Integer commerceChangeOriginalOwner) {
			commerceChangeOriginalOwners.add(commerceChangeOriginalOwner);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceChanges()
		 */
		@Override
		public List<Integer> getCommerceChanges() {
			return commerceChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceChange(java.lang.String)
		 */
		@Override
		public void addCommerceChange(Integer commerceChange) {
			commerceChanges.add(commerceChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceFlexibles()
		 */
		@Override
		public List<Integer> getCommerceFlexibles() {
			return commerceFlexibles;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceFlexible(java.lang.String)
		 */
		@Override
		public void addCommerceFlexible(Integer commerceFlexible) {
			commerceFlexibles.add(commerceFlexible);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceHappinesses()
		 */
		@Override
		public List<Integer> getCommerceHappinesses() {
			return commerceHappinesses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceHappiness(java.lang.String)
		 */
		@Override
		public void addCommerceHappiness(Integer commerceHappiness) {
			commerceHappinesses.add(commerceHappiness);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getCommerceModifiers()
		 */
		@Override
		public List<Integer> getCommerceModifiers() {
			return commerceModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addCommerceModifier(java.lang.String)
		 */
		@Override
		public void addCommerceModifier(Integer commerceModifier) {
			commerceModifiers.add(commerceModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalCommerceModifiers()
		 */
		@Override
		public List<Integer> getGlobalCommerceModifiers() {
			return globalCommerceModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addGlobalCommerceModifier(java.lang.String)
		 */
		@Override
		public void addGlobalCommerceModifier(Integer globalCommerceModifier) {
			globalCommerceModifiers.add(globalCommerceModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalSeaPlotYieldChanges()
		 */
		@Override
		public List<Integer> getGlobalSeaPlotYieldChanges() {
			return globalSeaPlotYieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addGlobalSeaPlotYieldChange(java.lang.String)
		 */
		@Override
		public void addGlobalSeaPlotYieldChange(Integer globalSeaPlotYieldChange) {
			globalSeaPlotYieldChanges.add(globalSeaPlotYieldChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getGlobalYieldModifiers()
		 */
		@Override
		public List<Integer> getGlobalYieldModifiers() {
			return globalYieldModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addGlobalYieldModifier(java.lang.String)
		 */
		@Override
		public void addGlobalYieldModifier(Integer globalYieldModifier) {
			globalYieldModifiers.add(globalYieldModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getObsoleteSafeCommerceChanges()
		 */
		@Override
		public List<Integer> getObsoleteSafeCommerceChanges() {
			return obsoleteSafeCommerceChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addObsoleteSafeCommerceChange(java.lang.String)
		 */
		@Override
		public void addObsoleteSafeCommerceChange(Integer obsoleteSafeCommerceChange) {
			obsoleteSafeCommerceChanges.add(obsoleteSafeCommerceChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPowerYieldModifiers()
		 */
		@Override
		public List<Integer> getPowerYieldModifiers() {
			return powerYieldModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPowerYieldModifier(java.lang.String)
		 */
		@Override
		public void addPowerYieldModifier(Integer powerYieldModifier) {
			powerYieldModifiers.add(powerYieldModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqAndBuildingClasses()
		 */
		@Override
		public List<String> getPrereqAndBuildingClasses() {
			return prereqAndBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqAndBuildingClass(java.lang.String)
		 */
		@Override
		public void addPrereqAndBuildingClass(String prereqAndBuildingClass) {
			prereqAndBuildingClasses.add(prereqAndBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqAndCivics()
		 */
		@Override
		public List<String> getPrereqAndCivics() {
			return prereqAndCivics;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqAndCivic(java.lang.String)
		 */
		@Override
		public void addPrereqAndCivic(String prereqAndCivic) {
			prereqAndCivics.add(prereqAndCivic);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqAndTechs()
		 */
		@Override
		public List<String> getPrereqAndTechs() {
			return prereqAndTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqAndTech(java.lang.String)
		 */
		@Override
		public void addPrereqAndTech(String prereqAndTech) {
			prereqAndTechs.add(prereqAndTech);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqAndTerrains()
		 */
		@Override
		public List<String> getPrereqAndTerrains() {
			return prereqAndTerrains;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqAndTerrain(java.lang.String)
		 */
		@Override
		public void addPrereqAndTerrain(String prereqAndTerrain) {
			prereqAndTerrains.add(prereqAndTerrain);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqBonus()
		 */
		@Override
		public String getPrereqBonus() {
			return prereqBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqBonu(java.lang.String)
		 */
		@Override
		public void setPrereqBonus(String prereqBonus) {
			this.prereqBonus = prereqBonus;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqNotBuildingClasses()
		 */
		@Override
		public List<String> getPrereqNotBuildingClasses() {
			return prereqNotBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqNotBuildingClass(java.lang.String)
		 */
		@Override
		public void addPrereqNotBuildingClass(String prereqNotBuildingClass) {
			prereqNotBuildingClasses.add(prereqNotBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqOrBonuses()
		 */
		@Override
		public List<String> getPrereqOrBonuses() {
			return prereqOrBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqOrBonus(java.lang.String)
		 */
		@Override
		public void addPrereqOrBonus(String prereqOrBonus) {
			prereqOrBonuses.add(prereqOrBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqOrBuildingClasses()
		 */
		@Override
		public List<String> getPrereqOrBuildingClasses() {
			return prereqOrBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqOrBuildingClass(java.lang.String)
		 */
		@Override
		public void addPrereqOrBuildingClass(String prereqOrBuildingClass) {
			prereqOrBuildingClasses.add(prereqOrBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqOrCivics()
		 */
		@Override
		public List<String> getPrereqOrCivics() {
			return prereqOrCivics;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqOrCivic(java.lang.String)
		 */
		@Override
		public void addPrereqOrCivic(String prereqOrCivic) {
			prereqOrCivics.add(prereqOrCivic);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqOrTerrains()
		 */
		@Override
		public List<String> getPrereqOrTerrains() {
			return prereqOrTerrains;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqOrTerrain(java.lang.String)
		 */
		@Override
		public void addPrereqOrTerrain(String prereqOrTerrain) {
			prereqOrTerrains.add(prereqOrTerrain);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqVicinityAndBonus()
		 */
		@Override
		public List<String> getPrereqVicinityAndBonus() {
			return prereqVicinityAndBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqVicinityAndBonu(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityAndBonus(String prereqVicinityAndBonus) {
			prereqVicinityAndBonuses.add(prereqVicinityAndBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqVicinityFeatures()
		 */
		@Override
		public List<String> getPrereqVicinityFeatures() {
			return prereqVicinityFeatures;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqVicinityFeature(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityFeature(String prereqVicinityFeature) {
			prereqVicinityFeatures.add(prereqVicinityFeature);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqVicinityImprovements()
		 */
		@Override
		public List<String> getPrereqVicinityImprovements() {
			return prereqVicinityImprovements;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqVicinityImprovement(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityImprovement(String prereqVicinityImprovement) {
			prereqVicinityImprovements.add(prereqVicinityImprovement);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqVicinityOrBonus()
		 */
		@Override
		public List<String> getPrereqVicinityOrBonus() {
			return prereqVicinityOrBonuses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqVicinityOrBonus(java.lang.String)
		 */
		@Override
		public void addPrereqVicinityOrBonus(String prereqVicinityOrBonus) {
			prereqVicinityOrBonuses.add(prereqVicinityOrBonus);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqWorldViews()
		 */
		@Override
		public List<String> getPrereqWorldViews() {
			return prereqWorldViews;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqWorldView(java.lang.String)
		 */
		@Override
		public void addPrereqWorldView(String prereqWorldView) {
			prereqWorldViews.add(prereqWorldView);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getReplacedByBuildingClasses()
		 */
		@Override
		public List<String> getReplacedByBuildingClasses() {
			return replacedByBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addReplacedByBuildingClass(java.lang.String)
		 */
		@Override
		public void addReplacedByBuildingClass(String replacedByBuildingClass) {
			replacedByBuildingClasses.add(replacedByBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getRiverPlotYieldChanges()
		 */
		@Override
		public List<Integer> getRiverPlotYieldChanges() {
			return riverPlotYieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addRiverPlotYieldChange(java.lang.String)
		 */
		@Override
		public void addRiverPlotYieldChange(Integer riverPlotYieldChange) {
			riverPlotYieldChanges.add(riverPlotYieldChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSeaPlotYieldChanges()
		 */
		@Override
		public List<Integer> getSeaPlotYieldChanges() {
			return seaPlotYieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addSeaPlotYieldChange(java.lang.String)
		 */
		@Override
		public void addSeaPlotYieldChange(Integer seaPlotYieldChange) {
			seaPlotYieldChanges.add(seaPlotYieldChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSpecialistExtraCommerces()
		 */
		@Override
		public List<Integer> getSpecialistExtraCommerces() {
			return specialistExtraCommerces;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addSpecialistExtraCommerce(java.lang.String)
		 */
		@Override
		public void addSpecialistExtraCommerce(Integer specialistExtraCommerce) {
			specialistExtraCommerces.add(specialistExtraCommerce);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getStateReligionCommerces()
		 */
		@Override
		public List<Integer> getStateReligionCommerces() {
			return stateReligionCommerces;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addStateReligionCommerce(java.lang.String)
		 */
		@Override
		public void addStateReligionCommerce(Integer stateReligionCommerce) {
			stateReligionCommerces.add(stateReligionCommerce);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getYieldChanges()
		 */
		@Override
		public List<Integer> getYieldChanges() {
			return yieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addYieldChange(java.lang.String)
		 */
		@Override
		public void addYieldChange(Integer yieldChange) {
			yieldChanges.add(yieldChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getYieldModifiers()
		 */
		@Override
		public List<Integer> getYieldModifiers() {
			return yieldModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addYieldModifier(java.lang.String)
		 */
		@Override
		public void addYieldModifier(Integer yieldModifier) {
			yieldModifiers.add(yieldModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBonusHappinessChanges()
		 */
		@Override
		public List<IPair<String, Integer>> getBonusHappinessChanges() {
			return bonusHappinessChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addBonusHappinessChange(org.archid.utils.IPair)
		 */
		@Override
		public void addBonusHappinessChange(IPair<String, Integer> bonusHappinessChange) {
			bonusHappinessChanges.add(bonusHappinessChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBonusHealthChanges()
		 */
		@Override
		public List<IPair<String, Integer>> getBonusHealthChanges() {
			return bonusHealthChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addBonusHealthChange(org.archid.utils.IPair)
		 */
		@Override
		public void addBonusHealthChange(IPair<String, Integer> bonusHealthChange) {
			bonusHealthChanges.add(bonusHealthChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBonusProductionModifiers()
		 */
		@Override
		public List<IPair<String, Integer>> getBonusProductionModifiers() {
			return bonusProductionModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addBonusProductionModifier(org.archid.utils.IPair)
		 */
		@Override
		public void addBonusProductionModifier(IPair<String, Integer> bonusProductionModifier) {
			bonusProductionModifiers.add(bonusProductionModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBuildingHappinessChanges()
		 */
		@Override
		public List<IPair<String, Integer>> getBuildingHappinessChanges() {
			return buildingHappinessChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addBuildingHappinessChange(org.archid.utils.IPair)
		 */
		@Override
		public void addBuildingHappinessChange(IPair<String, Integer> buildingHappinessChange) {
			buildingHappinessChanges.add(buildingHappinessChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDomainFreeExperiences()
		 */
		@Override
		public List<IPair<String, Integer>> getDomainFreeExperiences() {
			return domainFreeExperiences;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addDomainFreeExperience(org.archid.utils.IPair)
		 */
		@Override
		public void addDomainFreeExperience(IPair<String, Integer> domainFreeExperience) {
			domainFreeExperiences.add(domainFreeExperience);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getDomainProductionModifiers()
		 */
		@Override
		public List<IPair<String, Integer>> getDomainProductionModifiers() {
			return domainProductionModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addDomainProductionModifier(org.archid.utils.IPair)
		 */
		@Override
		public void addDomainProductionModifier(IPair<String, Integer> domainProductionModifier) {
			domainProductionModifiers.add(domainProductionModifier);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getFreeSpecialistCounts()
		 */
		@Override
		public List<IPair<String, Integer>> getFreeSpecialistCounts() {
			return freeSpecialistCounts;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addFreeSpecialistCount(org.archid.utils.IPair)
		 */
		@Override
		public void addFreeSpecialistCount(IPair<String, Integer> freeSpecialistCount) {
			freeSpecialistCounts.add(freeSpecialistCount);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getHappinessTraits()
		 */
		@Override
		public List<IPair<String, Integer>> getHappinessTraits() {
			return happinessTraits;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addHappinessTrait(org.archid.utils.IPair)
		 */
		@Override
		public void addHappinessTrait(IPair<String, Integer> happinessTrait) {
			happinessTraits.add(happinessTrait);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getImprovementFreeSpecialists()
		 */
		@Override
		public List<IPair<String, Integer>> getImprovementFreeSpecialists() {
			return improvementFreeSpecialists;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addImprovementFreeSpecialist(org.archid.utils.IPair)
		 */
		@Override
		public void addImprovementFreeSpecialist(IPair<String, Integer> improvementFreeSpecialist) {
			improvementFreeSpecialists.add(improvementFreeSpecialist);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getPrereqNumOfBuildingClasses()
		 */
		@Override
		public List<IPair<String, Integer>> getPrereqNumOfBuildingClasses() {
			return prereqNumOfBuildingClasses;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addPrereqNumOfBuildingClass(org.archid.utils.IPair)
		 */
		@Override
		public void addPrereqNumOfBuildingClass(IPair<String, Integer> prereqNumOfBuildingClass) {
			prereqNumOfBuildingClasses.add(prereqNumOfBuildingClass);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getProductionTraits()
		 */
		@Override
		public List<IPair<String, Integer>> getProductionTraits() {
			return productionTraits;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addProductionTrait(org.archid.utils.IPair)
		 */
		@Override
		public void addProductionTrait(IPair<String, Integer> productionTrait) {
			productionTraits.add(productionTrait);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getReligionChanges()
		 */
		@Override
		public List<IPair<String, Integer>> getReligionChanges() {
			return religionChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addReligionChange(org.archid.utils.IPair)
		 */
		@Override
		public void addReligionChange(IPair<String, Integer> religionChange) {
			religionChanges.add(religionChange);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSpecialistCounts()
		 */
		@Override
		public List<IPair<String, Integer>> getSpecialistCounts() {
			return specialistCounts;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addSpecialistCount(org.archid.utils.IPair)
		 */
		@Override
		public void addSpecialistCount(IPair<String, Integer> specialistCount) {
			specialistCounts.add(specialistCount);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getUnitCombatFreeExperiences()
		 */
		@Override
		public List<IPair<String, Integer>> getUnitCombatFreeExperiences() {
			return unitCombatFreeExperiences;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addUnitCombatFreeExperience(org.archid.utils.IPair)
		 */
		@Override
		public void addUnitCombatFreeExperience(IPair<String, Integer> unitCombatFreeExperience) {
			unitCombatFreeExperiences.add(unitCombatFreeExperience);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getBonusYieldModifiers()
		 */
		@Override
		public Map<String, List<Integer>> getBonusYieldModifiers() {
			return bonusYieldModifiers;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addBonusYieldModifier(java.lang.String, java.util.List)
		 */
		@Override
		public void addBonusYieldModifier(String bonus, List<Integer> yieldModifiers) {
			bonusYieldModifiers.put(bonus, yieldModifiers);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#getSpecialistYieldChanges()
		 */
		@Override
		public Map<String, List<Integer>> getSpecialistYieldChanges() {
			return specialistYieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.building.IBuildingInfo#addSpecialistYieldChange(java.lang.String, java.util.List)
		 */
		@Override
		public void addSpecialistYieldChange(String specialist, List<Integer> yieldChanges) {
			specialistYieldChanges.put(specialist, yieldChanges);
		}

		@Override
		public List<IPair<String, Integer>> getFlavors() {
			return flavors;
		}

		@Override
		public void addFlavor(IPair<String, Integer> flavor) {
			flavors.add(flavor);
		}

		@Override
		public int getObsoleteDefence() {
			return obsoleteDefence;
		}

		@Override
		public void setObsoleteDefence(int defence) {
			this.obsoleteDefence = defence;
		}

		@Override
		public boolean isGraphicalOnly() {
			return isGraphicalOnly;
		}

		@Override
		public void setGraphicalOnly(boolean isGraphicalOnly) {
			this.isGraphicalOnly = isGraphicalOnly;
		}

		@Override
		public Map<String, List<Integer>> getVicinityBonusYieldChanges() {
			return vicinityBonusYieldChanges;
		}

		@Override
		public void addVicinityBonusYieldChange(String bonus, List<Integer> yieldChanges) {
			vicinityBonusYieldChanges.put(bonus, yieldChanges);
		}

		@Override
		public Integer getExtraBarbarianCostChange() {
			return extraBarbarianCostChange;
		}

		@Override
		public void setExtraBarbarianCostChange(Integer extraBarbarianCostChange) {
			this.extraBarbarianCostChange = extraBarbarianCostChange;
		}

		@Override
		public Integer getBarbarianConversionCostModifier() {
			return barbarianConversionCostModifier;
		}

		@Override
		public void setBarbarianConversionCostModifier(Integer barbarianConversionCostModifier) {
			this.barbarianConversionCostModifier = barbarianConversionCostModifier;
		}
	}

}
