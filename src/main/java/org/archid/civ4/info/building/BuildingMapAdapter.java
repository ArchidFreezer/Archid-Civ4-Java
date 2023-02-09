package org.archid.civ4.info.building;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.utils.CollectionUtils;
import org.archid.utils.IPair;
import org.archid.utils.JaxbUtils;
import org.archid.utils.Pair;
import org.archid.utils.StringUtils;

public class BuildingMapAdapter extends XmlAdapter<BuildingMapAdapter.BuildingMap, Map<String, IBuildingInfo>> {
	
	public static class BuildingMap {
		 @XmlElement(name = "BuildingInfo")
		 List<AdaptedBuilding> entries = new ArrayList<AdaptedBuilding>();		
	}
	
	private static class AdaptedBuilding {
		@XmlElement(name="BuildingClass")
		private String buildingClass;
		@XmlElement(name="Type")
		private String type;
		@XmlElement(name="SpecialBuildingType")
		private String specialBuildingType;
		@XmlElement(name="Description")
		private String description;
		@XmlElement(name="Civilopedia")
		private String civilopedia;
		@XmlElement(name="Strategy")
		private String strategy;
		@XmlElement(name="Help")
		private String help;
		@XmlElement(name="Advisor")
		private String advisor;
		@XmlElement(name="ArtDefineTag")
		private String artDefineTag;
		@XmlElement(name="MovieDefineTag")
		private String movieDefineTag;
		@XmlElement(name="bAutoBuild")
		private Integer autoBuild;
		@XmlElement(name="HolyCity")
		private String holyCity;
		@XmlElement(name="ReligionType")
		private String religionType;
		@XmlElement(name="StateReligion")
		private String stateReligion;
		@XmlElement(name="bStateReligion")
		private Integer anyStateReligion;
		@XmlElement(name="PrereqReligion")
		private String prereqReligion;
		@XmlElement(name="PrereqCorporation")
		private String prereqCorporation;
		@XmlElement(name="FoundsCorporation")
		private String foundsCorporation;
		@XmlElement(name="GlobalReligionCommerce")
		private String globalReligionCommerce;
		@XmlElement(name="GlobalCorporationCommerce")
		private String globalCorporationCommerce;
		@XmlElement(name="VictoryPrereq")
		private String victoryPrereq;
		@XmlElement(name="FreeStartEra")
		private String freeStartEra;
		@XmlElement(name="MaxStartEra")
		private String maxStartEra;
		@XmlElement(name="ObsoleteTech")
		private String obsoleteTech;
		@XmlElementWrapper(name="PrereqAndTechs")
		@XmlElement(name="TechType")
		private List<String> prereqAndTechs;
		@XmlElement(name="PrereqBonus")
		private String prereqBonus;
		@XmlElementWrapper(name="PrereqOrBonuses")
		@XmlElement(name="BonusType")
		private List<String> prereqOrBonuses;
		@XmlElementWrapper(name="PrereqAndCivics")
		@XmlElement(name="CivicType")
		private List<String> prereqAndCivics;
		@XmlElementWrapper(name="PrereqOrCivics")
		@XmlElement(name="CivicType")
		private List<String> prereqOrCivics;
		@XmlElementWrapper(name="PrereqAndTerrains")
		@XmlElement(name="TerrainType")
		private List<String> prereqAndTerrains;
		@XmlElementWrapper(name="PrereqOrTerrains")
		@XmlElement(name="TerrainType")
		private List<String> prereqOrTerrains;
		@XmlElementWrapper(name="PrereqVicinityAndBonus")
		@XmlElement(name="BonusType")
		private List<String> prereqVicinityAndBonus;
		@XmlElementWrapper(name="PrereqVicinityOrBonus")
		@XmlElement(name="BonusType")
		private List<String> prereqVicinityOrBonus;
		@XmlElement(name="bRequirePrereqVicinityBonusConnected")
		private Integer requirePrereqVicinityBonusConnected;
		@XmlElementWrapper(name="PrereqVicinityImprovements")
		@XmlElement(name="ImprovementType")
		private List<String> prereqVicinityImprovements;
		@XmlElementWrapper(name="PrereqVicinityFeatures")
		@XmlElement(name="FeatureType")
		private List<String> prereqVicinityFeatures;
		@XmlElementWrapper(name="PrereqWorldViews")
		@XmlElement(name="WorldViewType")
		private List<String> prereqWorldViews;
		@XmlElement(name="iMinPopulation")
		private Integer minPopulation;
		@XmlElement(name="MinCultureLevel")
		private String minCultureLevel;
		@XmlElement(name="bPrereqPower")
		private Integer prereqPower;
		@XmlElementWrapper(name="ProductionTraits")
		@XmlElement(name="ProductionTrait")
		private List<AdaptedTraitChange> productionTraits;
		@XmlElementWrapper(name="HappinessTraits")
		@XmlElement(name="HappinessTrait")
		private List<AdaptedTraitChange> happinessTraits;
		@XmlElement(name="NoBonus")
		private String noBonus;
		@XmlElement(name="PowerBonus")
		private String powerBonus;
		@XmlElement(name="FreeBonus")
		private String freeBonus;
		@XmlElement(name="iNumFreeBonuses")
		private Integer numFreeBonuses;
		@XmlElement(name="FreeBuilding")
		private String freeBuilding;
		@XmlElement(name="FreePromotion")
		private String freePromotion;
		@XmlElement(name="CivicOption")
		private String civicOption;
		@XmlElement(name="GreatPeopleUnitClass")
		private String greatPeopleUnitClass;
		@XmlElement(name="iGreatPeopleRateChange")
		private Integer greatPeopleRateChange;
		@XmlElement(name="iHurryAngerModifier")
		private Integer hurryAngerModifier;
		@XmlElement(name="bBorderObstacle")
		private Integer borderObstacle;
		@XmlElement(name="bTeamShare")
		private Integer teamShare;
		@XmlElement(name="bWater")
		private Integer water;
		@XmlElement(name="bRiver")
		private Integer river;
		@XmlElement(name="bPower")
		private Integer providesPower;
		@XmlElement(name="bDirtyPower")
		private Integer dirtyPower;
		@XmlElement(name="bAreaCleanPower")
		private Integer areaCleanPower;
		@XmlElement(name="DiploVoteType")
		private String diploVoteType;
		@XmlElement(name="bForceTeamVoteEligible")
		private Integer forceTeamVoteEligible;
		@XmlElement(name="bCapital")
		private Integer capital;
		@XmlElement(name="bGovernmentCenter")
		private Integer governmentCenter;
		@XmlElement(name="bGoldenAge")
		private Integer goldenAge;
		@XmlElement(name="bAllowsNukes")
		private Integer allowsNukes;
		@XmlElement(name="bMapCentering")
		private Integer mapCentering;
		@XmlElement(name="bNoUnhappiness")
		private Integer noUnhappiness;
		@XmlElement(name="iUnhealthyPopulationModifier")
		private Integer unhealthyPopulationModifier;
		@XmlElement(name="bBuildingOnlyHealthy")
		private Integer buildingOnlyHealthy;
		@XmlElement(name="bNeverCapture")
		private Integer neverCapture;
		@XmlElement(name="bNukeImmune")
		private Integer nukeImmune;
		@XmlElement(name="bPrereqReligion")
		private Integer prereqAnyReligion;
		@XmlElement(name="bCenterInCity")
		private Integer centerInCity;
		@XmlElement(name="bSlaveMarket")
		private Integer slaveMarket;
		@XmlElement(name="bForceDisableStarSigns")
		private Integer forceDisableStarSigns;
		@XmlElement(name="bStarSignGoodOnly")
		private Integer starSignGoodOnly;
		@XmlElement(name="iStarSignMitigateChangePercent")
		private Integer starSignMitigateChangePercent;
		@XmlElement(name="iGlobalStarSignMitigateChangePercent")
		private Integer globalStarSignMitigateChangePercent;
		@XmlElement(name="iStarSignScaleChangePercent")
		private Integer starSignScaleChangePercent;
		@XmlElement(name="iGlobalStarSignScaleChangePercent")
		private Integer globalStarSignScaleChangePercent;
		@XmlElement(name="iAIWeight")
		private Integer aiWeight;
		@XmlElement(name="iCost")
		private Integer cost;
		@XmlElement(name="iHurryCostModifier")
		private Integer hurryCostModifier;
		@XmlElement(name="iAdvancedStartCost")
		private Integer advancedStartCost;
		@XmlElement(name="iAdvancedStartCostIncrease")
		private Integer advancedStartCostIncrease;
		@XmlElement(name="iExtraBarbarianCostChange")
		private Integer extraBarbarianCostChange;
		@XmlElement(name="iBarbarianConversionCostModifier")
		private Integer barbarianConversionCostModifier;
		@XmlElement(name="iMinAreaSize")
		private Integer minAreaSize;
		@XmlElement(name="iConquestProb")
		private Integer conquestProb;
		@XmlElement(name="iCitiesPrereq")
		private Integer citiesPrereq;
		@XmlElement(name="iTeamsPrereq")
		private Integer teamsPrereq;
		@XmlElement(name="iLevelPrereq")
		private Integer levelPrereq;
		@XmlElement(name="iMinLatitude")
		private Integer minLatitude;
		@XmlElement(name="iMaxLatitude")
		private Integer maxLatitude;
		@XmlElement(name="iWorkableRadius")
		private Integer workableRadius;
		@XmlElement(name="iGreatPeopleRateModifier")
		private Integer greatPeopleRateModifier;
		@XmlElement(name="iGreatGeneralRateModifier")
		private Integer greatGeneralRateModifier;
		@XmlElement(name="iDomesticGreatGeneralRateModifier")
		private Integer domesticGreatGeneralRateModifier;
		@XmlElement(name="iGlobalGreatPeopleRateModifier")
		private Integer globalGreatPeopleRateModifier;
		@XmlElement(name="iAnarchyModifier")
		private Integer anarchyModifier;
		@XmlElement(name="iGoldenAgeModifier")
		private Integer goldenAgeModifier;
		@XmlElement(name="iGlobalHurryModifier")
		private Integer globalHurryModifier;
		@XmlElement(name="iExperience")
		private Integer experience;
		@XmlElement(name="iGlobalExperience")
		private Integer globalExperience;
		@XmlElement(name="iFoodKept")
		private Integer foodKept;
		@XmlElement(name="iAirlift")
		private Integer airlift;
		@XmlElement(name="iAirModifier")
		private Integer airModifier;
		@XmlElement(name="iAirUnitCapacity")
		private Integer airUnitCapacity;
		@XmlElement(name="iNukeModifier")
		private Integer nukeModifier;
		@XmlElement(name="iNukeExplosionRand")
		private Integer nukeExplosionRand;
		@XmlElement(name="iFreeSpecialist")
		private Integer freeSpecialist;
		@XmlElement(name="iAreaFreeSpecialist")
		private Integer areaFreeSpecialist;
		@XmlElement(name="iGlobalFreeSpecialist")
		private Integer globalFreeSpecialist;
		@XmlElement(name="iMaintenanceModifier")
		private Integer maintenanceModifier;
		@XmlElement(name="iWarWearinessModifier")
		private Integer warWearinessModifier;
		@XmlElement(name="iGlobalWarWearinessModifier")
		private Integer globalWarWearinessModifier;
		@XmlElement(name="iEnemyWarWearinessModifier")
		private Integer enemyWarWearinessModifier;
		@XmlElement(name="iHealRateChange")
		private Integer healRateChange;
		@XmlElement(name="iHealth")
		private Integer health;
		@XmlElement(name="iAreaHealth")
		private Integer areaHealth;
		@XmlElement(name="iGlobalHealth")
		private Integer globalHealth;
		@XmlElement(name="iHappiness")
		private Integer happiness;
		@XmlElement(name="iAreaHappiness")
		private Integer areaHappiness;
		@XmlElement(name="iGlobalHappiness")
		private Integer globalHappiness;
		@XmlElement(name="iStateReligionHappiness")
		private Integer stateReligionHappiness;
		@XmlElement(name="iWorkerSpeedModifier")
		private Integer workerSpeedModifier;
		@XmlElement(name="iMilitaryProductionModifier")
		private Integer militaryProductionModifier;
		@XmlElement(name="iSpaceProductionModifier")
		private Integer spaceProductionModifier;
		@XmlElement(name="iGlobalSpaceProductionModifier")
		private Integer globalSpaceProductionModifier;
		@XmlElement(name="iTradeRoutes")
		private Integer tradeRoutes;
		@XmlElement(name="iCoastalTradeRoutes")
		private Integer coastalTradeRoutes;
		@XmlElement(name="iGlobalTradeRoutes")
		private Integer globalTradeRoutes;
		@XmlElement(name="iTradeRouteModifier")
		private Integer tradeRouteModifier;
		@XmlElement(name="iForeignTradeRouteModifier")
		private Integer foreignTradeRouteModifier;
		@XmlElement(name="iGlobalPopulationChange")
		private Integer globalPopulationChange;
		@XmlElement(name="iFreeTechs")
		private Integer freeTechs;
		@XmlElement(name="iDefense")
		private Integer defense;
		@XmlElement(name="iObsoleteDefence")
		private Integer obsoleteDefence;
		@XmlElement(name="iBombardDefense")
		private Integer bombardDefense;
		@XmlElement(name="iAllCityDefense")
		private Integer allCityDefense;
		@XmlElement(name="iEspionageDefense")
		private Integer espionageDefense;
		@XmlElement(name="iAsset")
		private Integer asset;
		@XmlElement(name="iPower")
		private Integer power;
		@XmlElement(name="fVisibilityPriority")
		private Float visibilityPriority;
		@XmlElementWrapper(name="SeaPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> seaPlotYieldChanges;
		@XmlElementWrapper(name="RiverPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> riverPlotYieldChanges;
		@XmlElementWrapper(name="GlobalSeaPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> globalSeaPlotYieldChanges;
		@XmlElementWrapper(name="YieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> yieldChanges;
		@XmlElementWrapper(name="YieldModifiers")
		@XmlElement(name="iYield")
		private List<Integer> yieldModifiers;
		@XmlElementWrapper(name="PowerYieldModifiers")
		@XmlElement(name="iYield")
		private List<Integer> powerYieldModifiers;
		@XmlElementWrapper(name="AreaYieldModifiers")
		@XmlElement(name="iYield")
		private List<Integer> areaYieldModifiers;
		@XmlElementWrapper(name="GlobalYieldModifiers")
		@XmlElement(name="iYield")
		private List<Integer> globalYieldModifiers;
		@XmlElementWrapper(name="CommerceChanges")
		@XmlElement(name="iCommerce")
		private List<Integer> commerceChanges;
		@XmlElementWrapper(name="ObsoleteSafeCommerceChanges")
		@XmlElement(name="iCommerce")
		private List<Integer> obsoleteSafeCommerceChanges;
		@XmlElementWrapper(name="CommerceChangeDoubleTimes")
		@XmlElement(name="iCommerce")
		private List<Integer> commerceChangeDoubleTimes;
		@XmlElementWrapper(name="CommerceModifiers")
		@XmlElement(name="iCommerce")
		private List<Integer> commerceModifiers;
		@XmlElementWrapper(name="GlobalCommerceModifiers")
		@XmlElement(name="iCommerce")
		private List<Integer> globalCommerceModifiers;
		@XmlElementWrapper(name="SpecialistExtraCommerces")
		@XmlElement(name="iCommerce")
		private List<Integer> specialistExtraCommerces;
		@XmlElementWrapper(name="StateReligionCommerces")
		@XmlElement(name="iCommerce")
		private List<Integer> stateReligionCommerces;
		@XmlElementWrapper(name="CommerceHappinesses")
		@XmlElement(name="iCommerce")
		private List<Integer> commerceHappinesses;
		@XmlElementWrapper(name="ReligionChanges")
		@XmlElement(name="ReligionChange")
		private List<AdaptedReligionChange> religionChanges;
		@XmlElementWrapper(name="SpecialistCounts")
		@XmlElement(name="SpecialistCount")
		private List<AdaptedSpecialistCount> specialistCounts;
		@XmlElementWrapper(name="FreeSpecialistCounts")
		@XmlElement(name="SpecialistCount")
		private List<AdaptedSpecialistCount> freeSpecialistCounts;
		@XmlElementWrapper(name="CommerceFlexibles")
		@XmlElement(name="bCommerce")
		private List<Integer> commerceFlexibles;
		@XmlElementWrapper(name="CommerceChangeOriginalOwners")
		@XmlElement(name="bCommerceChangeOriginalOwner")
		private List<Integer> commerceChangeOriginalOwners;
		@XmlElement(name="ConstructSound")
		private String constructSound;
		@XmlElementWrapper(name="BonusHealthChanges")
		@XmlElement(name="BonusHealthChange")
		private List<AdaptedBonusChange> bonusHealthChanges;
		@XmlElementWrapper(name="BonusHappinessChanges")
		@XmlElement(name="BonusHappinessChange")
		private List<AdaptedBonusChange> bonusHappinessChanges;
		@XmlElementWrapper(name="BonusProductionModifiers")
		@XmlElement(name="BonusProductionModifier")
		private List<AdaptedBonusModifier> bonusProductionModifiers;
		@XmlElementWrapper(name="UnitCombatFreeExperiences")
		@XmlElement(name="UnitCombatFreeExperience")
		private List<AdaptedUnitCombatExperience> unitCombatFreeExperiences;
		@XmlElementWrapper(name="DomainFreeExperiences")
		@XmlElement(name="DomainFreeExperience")
		private List<AdaptedDomainExperience> domainFreeExperiences;
		@XmlElementWrapper(name="DomainProductionModifiers")
		@XmlElement(name="DomainProductionModifier")
		private List<AdaptedDomainModifier> domainProductionModifiers;
		@XmlElementWrapper(name="BuildingClassProductionModifiers")
		@XmlElement(name="BuildingClassProductionModifier")
		private List<AdaptedBuildingClassProductionModifier> buildingClassProductionModifiers;
		@XmlElementWrapper(name="BuildingHappinessChanges")
		@XmlElement(name="BuildingHappinessChange")
		private List<AdaptedBuildingChange> buildingHappinessChanges;
		@XmlElementWrapper(name="PrereqNumOfBuildingClasses")
		@XmlElement(name="PrereqNumOfBuildingClass")
		private List<AdaptedBuildingClassNumber> prereqNumOfBuildingClasses;
		@XmlElementWrapper(name="PrereqAndBuildingClasses")
		@XmlElement(name="BuildingClass")
		private List<String> prereqAndBuildingClasses;
		@XmlElementWrapper(name="PrereqOrBuildingClasses")
		@XmlElement(name="BuildingClass")
		private List<String> prereqOrBuildingClasses;
		@XmlElementWrapper(name="PrereqNotBuildingClasses")
		@XmlElement(name="BuildingClass")
		private List<String> prereqNotBuildingClasses;
		@XmlElementWrapper(name="ReplacedByBuildingClasses")
		@XmlElement(name="BuildingClass")
		private List<String> replacedByBuildingClasses;
		@XmlElementWrapper(name="SpecialistYieldChanges")
		@XmlElement(name="SpecialistYieldChange")
		private List<AdaptedSpecialistYieldChange> specialistYieldChanges;
		@XmlElementWrapper(name="BonusYieldModifiers")
		@XmlElement(name="BonusYieldModifier")
		private List<AdaptedBonusYieldModifier> bonusYieldModifiers;
		@XmlElementWrapper(name="ImprovementFreeSpecialists")
		@XmlElement(name="ImprovementFreeSpecialist")
		private List<AdaptedImprovementCount> improvementFreeSpecialists;
		@XmlElementWrapper(name="VicinityBonusYieldChanges")
		@XmlElement(name="BonusYieldChange")
		private List<AdaptedBonusYieldChange> vicinityBonusYieldChanges;
		@XmlElementWrapper(name="Flavors")
		@XmlElement(name="Flavor")
		private List<AdaptedFlavor> flavors;
		@XmlElement(name="HotKey")
		private String hotKey;
		@XmlElement(name="bAltDown")
		private Integer altDown;
		@XmlElement(name="bShiftDown")
		private Integer shiftDown;
		@XmlElement(name="bCtrlDown")
		private Integer ctrlDown;
		@XmlElement(name="iHotKeyPriority")
		private Integer hotKeyPriority;
		@XmlElement(name="iOrderPriority")
		private Integer orderPriority;
		@XmlElement(name="bGraphicalOnly")
		private Integer graphicalOnly;

	}
	
	private static class AdaptedFlavor {
		@XmlElement(name="FlavorType")
		private String flavor;
		@XmlElement(name="iFlavor")
		private Integer value;
	}

	private static class AdaptedImprovementCount {
		@XmlElement(name="ImprovementType")
		private String improvement;
		@XmlElement(name="iCount")
		private Integer count;
	}

	private static class AdaptedBonusYieldModifier {
		@XmlElement(name="BonusType")
		private String bonus;
		@XmlElementWrapper(name="YieldModifiers")
		@XmlElement(name="iYield")
		private List<Integer> yields = new ArrayList<Integer>();
	}

	private static class AdaptedSpecialistYieldChange {
		@XmlElement(name="SpecialistType")
		private String specialist;
		@XmlElementWrapper(name="YieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> yields = new ArrayList<Integer>();
	}

	private static class AdaptedBonusYieldChange {
		@XmlElement(name="BonusType")
		private String bonus;
		@XmlElementWrapper(name="YieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> yields = new ArrayList<Integer>();
	}

	private static class AdaptedBuildingChange {
		@XmlElement(name="BuildingType")
		private String building;
		@XmlElement(name="iChange")
		private Integer change;
	}

	private static class AdaptedBuildingClassNumber {
		@XmlElement(name="BuildingClassType")
		private String buildingClass;
		@XmlElement(name="iNeeded")
		private Integer needed;
	}

	private static class AdaptedDomainModifier {
		@XmlElement(name="DomainType")
		private String domainType;
		@XmlElement(name="iModifier")
		private Integer modifier;
	}

	private static class AdaptedBuildingClassProductionModifier {
		@XmlElement(name="BuildingClassType")
		private String buildingClassType;
		@XmlElement(name="iModifier")
		private Integer modifier;
	}

	private static class AdaptedDomainExperience {
		@XmlElement(name="DomainType")
		private String domainType;
		@XmlElement(name="iExperience")
		private Integer experience;
	}

	private static class AdaptedUnitCombatExperience {
		@XmlElement(name="UnitCombatType")
		private String unitCombatType;
		@XmlElement(name="iExperience")
		private Integer experience;
	}

	private static class AdaptedBonusChange {
		@XmlElement(name="BonusType")
		private String bonus;
		@XmlElement(name="iChange")
		private Integer change;
	}

	private static class AdaptedBonusModifier {
		@XmlElement(name="BonusType")
		private String bonus;
		@XmlElement(name="iModifier")
		private Integer modifier;
	}

	private static class AdaptedSpecialistCount {
		@XmlElement(name="SpecialistType")
		private String specialist;
		@XmlElement(name="iCount")
		private Integer count;
	}

	private static class AdaptedReligionChange {
		@XmlElement(name="ReligionType")
		private String religion;
		@XmlElement(name="iChange")
		private Integer change;
	}

	private static class AdaptedTraitChange {
		@XmlElement(name="TraitType")
		private String trait;
		@XmlElement(name="iChange")
		private Integer change;
	}

	@Override
	public Map<String, IBuildingInfo> unmarshal(BuildingMap v) throws Exception {
		Map<String, IBuildingInfo> map = new TreeMap<String, IBuildingInfo>();
		for (AdaptedBuilding aInfo: v.entries) {
			IBuildingInfo info = BuildingInfos.createInfo(aInfo.type);
			info.setBuildingClass(JaxbUtils.unmarshallString(aInfo.buildingClass));
			info.setSpecialBuildingType(JaxbUtils.unmarshallString(aInfo.specialBuildingType));
			info.setDescription(JaxbUtils.unmarshallString(aInfo.description));
			info.setCivilopedia(JaxbUtils.unmarshallString(aInfo.civilopedia));
			info.setStrategy(JaxbUtils.unmarshallString(aInfo.strategy));
			info.setHelp(JaxbUtils.unmarshallString(aInfo.help));
			info.setAdvisor(JaxbUtils.unmarshallString(aInfo.advisor));
			info.setArtDefineTag(JaxbUtils.unmarshallString(aInfo.artDefineTag));
			info.setMovieDefineTag(JaxbUtils.unmarshallString(aInfo.movieDefineTag));
			info.setAutoBuild(JaxbUtils.unmarshallBoolean(aInfo.autoBuild));
			info.setHolyCity(JaxbUtils.unmarshallString(aInfo.holyCity));
			info.setReligionType(JaxbUtils.unmarshallString(aInfo.religionType));
			info.setStateReligion(JaxbUtils.unmarshallString(aInfo.stateReligion));
			info.setStateReligion(JaxbUtils.unmarshallBoolean(aInfo.anyStateReligion));
			info.setPrereqReligion(JaxbUtils.unmarshallString(aInfo.prereqReligion));
			info.setPrereqCorporation(JaxbUtils.unmarshallString(aInfo.prereqCorporation));
			info.setFoundsCorporation(JaxbUtils.unmarshallString(aInfo.foundsCorporation));
			info.setGlobalReligionCommerce(JaxbUtils.unmarshallString(aInfo.globalReligionCommerce));
			info.setGlobalCorporationCommerce(JaxbUtils.unmarshallString(aInfo.globalCorporationCommerce));
			info.setVictoryPrereq(JaxbUtils.unmarshallString(aInfo.victoryPrereq));
			info.setFreeStartEra(JaxbUtils.unmarshallString(aInfo.freeStartEra));
			info.setMaxStartEra(JaxbUtils.unmarshallString(aInfo.maxStartEra));
			info.setObsoleteTech(JaxbUtils.unmarshallString(aInfo.obsoleteTech));
			
			if (CollectionUtils.hasElements(aInfo.prereqAndTechs)) {
				for (String val: aInfo.prereqAndTechs) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqAndTech(val);
				}
			}
			
			info.setPrereqBonus(JaxbUtils.unmarshallString(aInfo.prereqBonus));

			if (CollectionUtils.hasElements(aInfo.prereqOrBonuses)) {
				for (String val: aInfo.prereqOrBonuses) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqOrBonus(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqAndCivics)) {
				for (String val: aInfo.prereqAndCivics) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqAndCivic(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqOrCivics)) {
				for (String val: aInfo.prereqOrCivics) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqOrCivic(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqAndTerrains)) {
				for (String val: aInfo.prereqAndTerrains) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqAndTerrain(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqOrTerrains)) {
				for (String val: aInfo.prereqOrTerrains) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqOrTerrain(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqVicinityAndBonus)) {
				for (String val: aInfo.prereqVicinityAndBonus) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqVicinityAndBonus(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqVicinityOrBonus)) {
				for (String val: aInfo.prereqVicinityOrBonus) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqVicinityOrBonus(val);
				}
			}

			info.setRequirePrereqVicinityBonusConnected(JaxbUtils.unmarshallBoolean(aInfo.requirePrereqVicinityBonusConnected, true));

			if (CollectionUtils.hasElements(aInfo.prereqVicinityImprovements)) {
				for (String val: aInfo.prereqVicinityImprovements) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqVicinityImprovement(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqVicinityFeatures)) {
				for (String val: aInfo.prereqVicinityFeatures) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqVicinityFeature(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqWorldViews)) {
				for (String val: aInfo.prereqWorldViews) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqWorldView(val);
				}
			}
			
			info.setMinPopulation(JaxbUtils.unmarshallInteger(aInfo.minPopulation));
			info.setMinCultureLevel(JaxbUtils.unmarshallString(aInfo.minCultureLevel));
			info.setPrereqPower(JaxbUtils.unmarshallBoolean(aInfo.prereqPower));

			if (CollectionUtils.hasElements(aInfo.productionTraits)) {
				for (AdaptedTraitChange adaptor: aInfo.productionTraits) {
					if (StringUtils.hasCharacters(adaptor.trait)) {
						info.addProductionTrait(new Pair<String, Integer>(adaptor.trait, adaptor.change));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.happinessTraits)) {
				for (AdaptedTraitChange adaptor: aInfo.happinessTraits) {
					if (StringUtils.hasCharacters(adaptor.trait)) {
						info.addProductionTrait(new Pair<String, Integer>(adaptor.trait, adaptor.change));
					}
				}
			}
			
			info.setNoBonus(JaxbUtils.unmarshallString(aInfo.noBonus));
			info.setPowerBonus(JaxbUtils.unmarshallString(aInfo.powerBonus));
			info.setFreeBonus(JaxbUtils.unmarshallString(aInfo.freeBonus));
			info.setNumFreeBonuses(JaxbUtils.unmarshallInteger(aInfo.numFreeBonuses));
			info.setFreeBuilding(JaxbUtils.unmarshallString(aInfo.freeBuilding));
			info.setFreePromotion(JaxbUtils.unmarshallString(aInfo.freePromotion));
			info.setCivicOption(JaxbUtils.unmarshallString(aInfo.civicOption));
			info.setGreatPeopleUnitClass(JaxbUtils.unmarshallString(aInfo.greatPeopleUnitClass));
			info.setGreatPeopleRateChange(JaxbUtils.unmarshallInteger(aInfo.greatPeopleRateChange));
			info.setHurryAngerModifier(JaxbUtils.unmarshallInteger(aInfo.hurryAngerModifier));
			info.setBorderObstacle(JaxbUtils.unmarshallBoolean(aInfo.borderObstacle));
			info.setTeamShare(JaxbUtils.unmarshallBoolean(aInfo.teamShare));
			info.setWater(JaxbUtils.unmarshallBoolean(aInfo.water));
			info.setRiver(JaxbUtils.unmarshallBoolean(aInfo.river));
			info.setPower(JaxbUtils.unmarshallBoolean(aInfo.power));
			info.setDirtyPower(JaxbUtils.unmarshallBoolean(aInfo.dirtyPower));
			info.setAreaCleanPower(JaxbUtils.unmarshallBoolean(aInfo.areaCleanPower));
			info.setDiploVoteType(JaxbUtils.unmarshallString(aInfo.diploVoteType));
			info.setForceTeamVoteEligible(JaxbUtils.unmarshallBoolean(aInfo.forceTeamVoteEligible));
			info.setCapital(JaxbUtils.unmarshallBoolean(aInfo.capital));
			info.setGovernmentCenter(JaxbUtils.unmarshallBoolean(aInfo.governmentCenter));
			info.setGoldenAge(JaxbUtils.unmarshallBoolean(aInfo.goldenAge));
			info.setAllowsNukes(JaxbUtils.unmarshallBoolean(aInfo.allowsNukes));
			info.setMapCentering(JaxbUtils.unmarshallBoolean(aInfo.mapCentering));
			info.setNoUnhappiness(JaxbUtils.unmarshallBoolean(aInfo.noUnhappiness));
			info.setUnhealthyPopulationModifier(JaxbUtils.unmarshallInteger(aInfo.unhealthyPopulationModifier));
			info.setBuildingOnlyHealthy(JaxbUtils.unmarshallBoolean(aInfo.buildingOnlyHealthy));
			info.setNeverCapture(JaxbUtils.unmarshallBoolean(aInfo.neverCapture));
			info.setNukeImmune(JaxbUtils.unmarshallBoolean(aInfo.nukeImmune));
			info.setPrereqReligion(JaxbUtils.unmarshallBoolean(aInfo.prereqAnyReligion));
			info.setCenterInCity(JaxbUtils.unmarshallBoolean(aInfo.centerInCity));
			info.setSlaveMarket(JaxbUtils.unmarshallBoolean(aInfo.slaveMarket));
			info.setForceDisableStarSigns(JaxbUtils.unmarshallBoolean(aInfo.forceDisableStarSigns));
			info.setStarSignGoodOnly(JaxbUtils.unmarshallBoolean(aInfo.starSignGoodOnly));
			info.setStarSignMitigateChangePercent(JaxbUtils.unmarshallInteger(aInfo.starSignMitigateChangePercent));
			info.setGlobalStarSignMitigateChangePercent(JaxbUtils.unmarshallInteger(aInfo.globalStarSignMitigateChangePercent));
			info.setStarSignScaleChangePercent(JaxbUtils.unmarshallInteger(aInfo.starSignScaleChangePercent));
			info.setGlobalStarSignScaleChangePercent(JaxbUtils.unmarshallInteger(aInfo.globalStarSignScaleChangePercent));
			info.setAIWeight(JaxbUtils.unmarshallInteger(aInfo.aiWeight));
			info.setCost(JaxbUtils.unmarshallInteger(aInfo.cost));
			info.setHurryCostModifier(JaxbUtils.unmarshallInteger(aInfo.hurryCostModifier));
			info.setAdvancedStartCost(JaxbUtils.unmarshallInteger(aInfo.advancedStartCost));
			info.setAdvancedStartCostIncrease(JaxbUtils.unmarshallInteger(aInfo.advancedStartCostIncrease));
			info.setExtraBarbarianCostChange(JaxbUtils.unmarshallInteger(aInfo.extraBarbarianCostChange));
			info.setBarbarianConversionCostModifier(JaxbUtils.unmarshallInteger(aInfo.barbarianConversionCostModifier));
			info.setMinAreaSize(JaxbUtils.unmarshallInteger(aInfo.minAreaSize));
			info.setConquestProb(JaxbUtils.unmarshallInteger(aInfo.conquestProb));
			info.setCitiesPrereq(JaxbUtils.unmarshallInteger(aInfo.citiesPrereq));
			info.setTeamsPrereq(JaxbUtils.unmarshallInteger(aInfo.teamsPrereq));
			info.setLevelPrereq(JaxbUtils.unmarshallInteger(aInfo.levelPrereq));
			info.setMinLatitude(JaxbUtils.unmarshallInteger(aInfo.minLatitude));
			info.setMaxLatitude(JaxbUtils.unmarshallInteger(aInfo.maxLatitude));
			info.setWorkableRadius(JaxbUtils.unmarshallInteger(aInfo.workableRadius));
			info.setGreatPeopleRateModifier(JaxbUtils.unmarshallInteger(aInfo.greatPeopleRateModifier));
			info.setGreatGeneralRateModifier(JaxbUtils.unmarshallInteger(aInfo.greatGeneralRateModifier));
			info.setDomesticGreatGeneralRateModifier(JaxbUtils.unmarshallInteger(aInfo.domesticGreatGeneralRateModifier));
			info.setGlobalGreatPeopleRateModifier(JaxbUtils.unmarshallInteger(aInfo.globalGreatPeopleRateModifier));
			info.setAnarchyModifier(JaxbUtils.unmarshallInteger(aInfo.anarchyModifier));
			info.setGoldenAgeModifier(JaxbUtils.unmarshallInteger(aInfo.goldenAgeModifier));
			info.setGlobalHurryModifier(JaxbUtils.unmarshallInteger(aInfo.globalHurryModifier));
			info.setExperience(JaxbUtils.unmarshallInteger(aInfo.experience));
			info.setGlobalExperience(JaxbUtils.unmarshallInteger(aInfo.globalExperience));
			info.setFoodKept(JaxbUtils.unmarshallInteger(aInfo.foodKept));
			info.setAirlift(JaxbUtils.unmarshallInteger(aInfo.airlift));
			info.setAirModifier(JaxbUtils.unmarshallInteger(aInfo.airModifier));
			info.setAirUnitCapacity(JaxbUtils.unmarshallInteger(aInfo.airUnitCapacity));
			info.setNukeModifier(JaxbUtils.unmarshallInteger(aInfo.nukeModifier));
			info.setNukeExplosionRand(JaxbUtils.unmarshallInteger(aInfo.nukeExplosionRand));
			info.setFreeSpecialist(JaxbUtils.unmarshallInteger(aInfo.freeSpecialist));
			info.setAreaFreeSpecialist(JaxbUtils.unmarshallInteger(aInfo.areaFreeSpecialist));
			info.setGlobalFreeSpecialist(JaxbUtils.unmarshallInteger(aInfo.globalFreeSpecialist));
			info.setMaintenanceModifier(JaxbUtils.unmarshallInteger(aInfo.maintenanceModifier));
			info.setWarWearinessModifier(JaxbUtils.unmarshallInteger(aInfo.warWearinessModifier));
			info.setGlobalWarWearinessModifier(JaxbUtils.unmarshallInteger(aInfo.globalWarWearinessModifier));
			info.setEnemyWarWearinessModifier(JaxbUtils.unmarshallInteger(aInfo.enemyWarWearinessModifier));
			info.setHealRateChange(JaxbUtils.unmarshallInteger(aInfo.healRateChange));
			info.setHealth(JaxbUtils.unmarshallInteger(aInfo.health));
			info.setAreaHealth(JaxbUtils.unmarshallInteger(aInfo.areaHealth));
			info.setGlobalHealth(JaxbUtils.unmarshallInteger(aInfo.globalHealth));
			info.setHappiness(JaxbUtils.unmarshallInteger(aInfo.happiness));
			info.setAreaHappiness(JaxbUtils.unmarshallInteger(aInfo.areaHappiness));
			info.setGlobalHappiness(JaxbUtils.unmarshallInteger(aInfo.globalHappiness));
			info.setStateReligionHappiness(JaxbUtils.unmarshallInteger(aInfo.stateReligionHappiness));
			info.setWorkerSpeedModifier(JaxbUtils.unmarshallInteger(aInfo.workerSpeedModifier));
			info.setMilitaryProductionModifier(JaxbUtils.unmarshallInteger(aInfo.militaryProductionModifier));
			info.setSpaceProductionModifier(JaxbUtils.unmarshallInteger(aInfo.spaceProductionModifier));
			info.setGlobalSpaceProductionModifier(JaxbUtils.unmarshallInteger(aInfo.globalSpaceProductionModifier));
			info.setTradeRoutes(JaxbUtils.unmarshallInteger(aInfo.tradeRoutes));
			info.setCoastalTradeRoutes(JaxbUtils.unmarshallInteger(aInfo.coastalTradeRoutes));
			info.setGlobalTradeRoutes(JaxbUtils.unmarshallInteger(aInfo.globalTradeRoutes));
			info.setTradeRouteModifier(JaxbUtils.unmarshallInteger(aInfo.tradeRouteModifier));
			info.setForeignTradeRouteModifier(JaxbUtils.unmarshallInteger(aInfo.foreignTradeRouteModifier));
			info.setGlobalPopulationChange(JaxbUtils.unmarshallInteger(aInfo.globalPopulationChange));
			info.setFreeTechs(JaxbUtils.unmarshallInteger(aInfo.freeTechs));
			info.setDefense(JaxbUtils.unmarshallInteger(aInfo.defense));
			info.setObsoleteDefence(JaxbUtils.unmarshallInteger(aInfo.obsoleteDefence));
			info.setBombardDefense(JaxbUtils.unmarshallInteger(aInfo.bombardDefense));
			info.setAllCityDefense(JaxbUtils.unmarshallInteger(aInfo.allCityDefense));
			info.setEspionageDefense(JaxbUtils.unmarshallInteger(aInfo.espionageDefense));
			info.setAsset(JaxbUtils.unmarshallInteger(aInfo.asset));
			info.setPower(JaxbUtils.unmarshallInteger(aInfo.power));
			info.setVisibilityPriority(JaxbUtils.unmarshallFloat(aInfo.visibilityPriority));

			if (CollectionUtils.hasElements(aInfo.seaPlotYieldChanges)) {
				for (Integer val: aInfo.seaPlotYieldChanges) {
						info.addSeaPlotYieldChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.riverPlotYieldChanges)) {
				for (Integer val: aInfo.riverPlotYieldChanges) {
					info.addRiverPlotYieldChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.globalSeaPlotYieldChanges)) {
				for (Integer val: aInfo.globalSeaPlotYieldChanges) {
					info.addGlobalSeaPlotYieldChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.yieldChanges)) {
				for (Integer val: aInfo.yieldChanges) {
					info.addYieldChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.yieldModifiers)) {
				for (Integer val: aInfo.yieldModifiers) {
					info.addYieldModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.powerYieldModifiers)) {
				for (Integer val: aInfo.powerYieldModifiers) {
					info.addPowerYieldModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.areaYieldModifiers)) {
				for (Integer val: aInfo.areaYieldModifiers) {
					info.addAreaYieldModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.globalYieldModifiers)) {
				for (Integer val: aInfo.globalYieldModifiers) {
					info.addGlobalYieldModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.commerceChanges)) {
				for (Integer val: aInfo.commerceChanges) {
					info.addCommerceChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.obsoleteSafeCommerceChanges)) {
				for (Integer val: aInfo.obsoleteSafeCommerceChanges) {
					info.addObsoleteSafeCommerceChange(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.commerceChangeDoubleTimes)) {
				for (Integer val: aInfo.commerceChangeDoubleTimes) {
					info.addCommerceChangeDoubleTime(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.commerceModifiers)) {
				for (Integer val: aInfo.commerceModifiers) {
					info.addCommerceModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.globalCommerceModifiers)) {
				for (Integer val: aInfo.globalCommerceModifiers) {
					info.addGlobalCommerceModifier(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.specialistExtraCommerces)) {
				for (Integer val: aInfo.specialistExtraCommerces) {
					info.addSpecialistExtraCommerce(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.stateReligionCommerces)) {
				for (Integer val: aInfo.stateReligionCommerces) {
					info.addStateReligionCommerce(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.commerceHappinesses)) {
				for (Integer val: aInfo.commerceHappinesses) {
					info.addCommerceHappiness(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.religionChanges)) {
				for (AdaptedReligionChange adaptor: aInfo.religionChanges) {
					if (StringUtils.hasCharacters(adaptor.religion)) {
						info.addReligionChange(new Pair<String, Integer>(adaptor.religion, adaptor.change));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.specialistCounts)) {
				for (AdaptedSpecialistCount adaptor: aInfo.specialistCounts) {
					if (StringUtils.hasCharacters(adaptor.specialist)) {
						info.addSpecialistCount(new Pair<String, Integer>(adaptor.specialist, adaptor.count));
					}
				}
			}

			if (CollectionUtils.hasElements(aInfo.freeSpecialistCounts)) {
				for (AdaptedSpecialistCount adaptor: aInfo.freeSpecialistCounts) {
					if (StringUtils.hasCharacters(adaptor.specialist)) {
						info.addFreeSpecialistCount(new Pair<String, Integer>(adaptor.specialist, adaptor.count));
					}
				}
			}

			if (CollectionUtils.hasElements(aInfo.commerceFlexibles)) {
				for (Integer val: aInfo.commerceFlexibles) {
					info.addCommerceFlexible(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.commerceChangeOriginalOwners)) {
				for (Integer val: aInfo.commerceChangeOriginalOwners) {
					info.addCommerceChangeOriginalOwner(val);
				}
			}
			
			info.setConstructSound(JaxbUtils.unmarshallString(aInfo.constructSound));
						
			if (CollectionUtils.hasElements(aInfo.bonusHealthChanges)) {
				for (AdaptedBonusChange adaptor: aInfo.bonusHealthChanges) {
					if (StringUtils.hasCharacters(adaptor.bonus)) {
						info.addBonusHealthChange(new Pair<String, Integer>(adaptor.bonus, adaptor.change));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.bonusHappinessChanges)) {
				for (AdaptedBonusChange adaptor: aInfo.bonusHappinessChanges) {
					if (StringUtils.hasCharacters(adaptor.bonus)) {
						info.addBonusHappinessChange(new Pair<String, Integer>(adaptor.bonus, adaptor.change));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.bonusProductionModifiers)) {
				for (AdaptedBonusModifier adaptor: aInfo.bonusProductionModifiers) {
					if (StringUtils.hasCharacters(adaptor.bonus)) {
						info.addBonusProductionModifier(new Pair<String, Integer>(adaptor.bonus, adaptor.modifier));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.unitCombatFreeExperiences)) {
				for (AdaptedUnitCombatExperience adaptor: aInfo.unitCombatFreeExperiences) {
					if (StringUtils.hasCharacters(adaptor.unitCombatType)) {
						info.addUnitCombatFreeExperience(new Pair<String, Integer>(adaptor.unitCombatType, adaptor.experience));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.domainFreeExperiences)) {
				for (AdaptedDomainExperience adaptor: aInfo.domainFreeExperiences) {
					if (StringUtils.hasCharacters(adaptor.domainType)) {
						info.addDomainFreeExperience(new Pair<String, Integer>(adaptor.domainType, adaptor.experience));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.domainProductionModifiers)) {
				for (AdaptedDomainModifier adaptor: aInfo.domainProductionModifiers) {
					if (StringUtils.hasCharacters(adaptor.domainType)) {
						info.addDomainProductionModifier(new Pair<String, Integer>(adaptor.domainType, adaptor.modifier));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.buildingClassProductionModifiers)) {
				for (AdaptedBuildingClassProductionModifier adaptor: aInfo.buildingClassProductionModifiers) {
					if (StringUtils.hasCharacters(adaptor.buildingClassType)) {
						info.addBuildingClassProductionModifier(new Pair<String, Integer>(adaptor.buildingClassType, adaptor.modifier));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.buildingHappinessChanges)) {
				for (AdaptedBuildingChange adaptor: aInfo.buildingHappinessChanges) {
					if (StringUtils.hasCharacters(adaptor.building)) {
						info.addBuildingHappinessChange(new Pair<String, Integer>(adaptor.building, adaptor.change));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqNumOfBuildingClasses)) {
				for (AdaptedBuildingClassNumber adaptor: aInfo.prereqNumOfBuildingClasses) {
					if (StringUtils.hasCharacters(adaptor.buildingClass)) {
						info.addPrereqNumOfBuildingClass(new Pair<String, Integer>(adaptor.buildingClass, adaptor.needed));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqAndBuildingClasses)) {
				for (String val: aInfo.prereqAndBuildingClasses) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqAndBuildingClass(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqOrBuildingClasses)) {
				for (String val: aInfo.prereqOrBuildingClasses) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqOrBuildingClass(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.prereqNotBuildingClasses)) {
				for (String val: aInfo.prereqNotBuildingClasses) {
					if (StringUtils.hasCharacters(val))
						info.addPrereqNotBuildingClass(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.replacedByBuildingClasses)) {
				for (String val: aInfo.replacedByBuildingClasses) {
					if (StringUtils.hasCharacters(val))
						info.addReplacedByBuildingClass(val);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.specialistYieldChanges)) {
				for (AdaptedSpecialistYieldChange adaptor: aInfo.specialistYieldChanges) {
					if (StringUtils.hasCharacters(adaptor.specialist)) {
						info.addSpecialistYieldChange(adaptor.specialist, new ArrayList<Integer>(adaptor.yields));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.bonusYieldModifiers)) {
				for (AdaptedBonusYieldModifier adaptor: aInfo.bonusYieldModifiers) {
					if (StringUtils.hasCharacters(adaptor.bonus)) {
						info.addBonusYieldModifier(adaptor.bonus, new ArrayList<Integer>(adaptor.yields));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.vicinityBonusYieldChanges)) {
				for (AdaptedBonusYieldChange adaptor: aInfo.vicinityBonusYieldChanges) {
					if (StringUtils.hasCharacters(adaptor.bonus)) {
						info.addVicinityBonusYieldChange(adaptor.bonus, new ArrayList<Integer>(adaptor.yields));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.improvementFreeSpecialists)) {
				for (AdaptedImprovementCount adaptor: aInfo.improvementFreeSpecialists) {
					if (StringUtils.hasCharacters(adaptor.improvement)) {
						info.addImprovementFreeSpecialist(new Pair<String, Integer>(adaptor.improvement, adaptor.count));
					}
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.flavors)) {
				for (AdaptedFlavor adaptor: aInfo.flavors) {
					if (StringUtils.hasCharacters(adaptor.flavor)) {
						info.addFlavor(new Pair<String, Integer>(adaptor.flavor, adaptor.value));
					}
				}
			}
			
			info.setHotKey(JaxbUtils.unmarshallString(aInfo.hotKey));
			info.setAltDown(JaxbUtils.unmarshallBoolean(aInfo.altDown));
			info.setShiftDown(JaxbUtils.unmarshallBoolean(aInfo.shiftDown));
			info.setCtrlDown(JaxbUtils.unmarshallBoolean(aInfo.ctrlDown));
			info.setHotKeyPriority(JaxbUtils.unmarshallInteger(aInfo.hotKeyPriority));
			info.setOrderPriority(JaxbUtils.unmarshallInteger(aInfo.orderPriority));
			info.setGraphicalOnly(JaxbUtils.unmarshallBoolean(aInfo.graphicalOnly));

			map.put(aInfo.type, info);
		}
		return map;
	}

	@Override
	public BuildingMap marshal(Map<String, IBuildingInfo> v) throws Exception {
		BuildingMap map = new BuildingMap();
		for (IBuildingInfo info: v.values()) {
			AdaptedBuilding aInfo = new AdaptedBuilding();
			aInfo.buildingClass = JaxbUtils.marshallString(info.getBuildingClass());
			aInfo.type = info.getType();
			aInfo.specialBuildingType = JaxbUtils.marshallString(info.getSpecialBuildingType());
			aInfo.description = JaxbUtils.marshallString(info.getDescription());
			aInfo.civilopedia = JaxbUtils.marshallString(info.getCivilopedia());
			aInfo.strategy = JaxbUtils.marshallString(info.getStrategy());
			aInfo.help = JaxbUtils.marshallString(info.getHelp());
			aInfo.advisor = JaxbUtils.marshallString(info.getAdvisor());
			aInfo.artDefineTag = JaxbUtils.marshallString(info.getArtDefineTag());
			aInfo.movieDefineTag = JaxbUtils.marshallString(info.getMovieDefineTag());
			aInfo.autoBuild = JaxbUtils.marshallBoolean(info.isAutoBuild());
			aInfo.holyCity = JaxbUtils.marshallString(info.getHolyCity());
			aInfo.religionType = JaxbUtils.marshallString(info.getReligionType());
			aInfo.stateReligion = JaxbUtils.marshallString(info.getStateReligion());
			aInfo.anyStateReligion = JaxbUtils.marshallBoolean(info.isStateReligion());
			aInfo.prereqReligion = JaxbUtils.marshallString(info.getPrereqReligion());
			aInfo.prereqCorporation = JaxbUtils.marshallString(info.getPrereqCorporation());
			aInfo.foundsCorporation = JaxbUtils.marshallString(info.getFoundsCorporation());
			aInfo.globalReligionCommerce = JaxbUtils.marshallString(info.getGlobalReligionCommerce());
			aInfo.globalCorporationCommerce = JaxbUtils.marshallString(info.getGlobalCorporationCommerce());
			aInfo.victoryPrereq = JaxbUtils.marshallString(info.getVictoryPrereq());
			aInfo.freeStartEra = JaxbUtils.marshallString(info.getFreeStartEra());
			aInfo.maxStartEra = JaxbUtils.marshallString(info.getMaxStartEra());
			aInfo.obsoleteTech = JaxbUtils.marshallString(info.getObsoleteTech());

			if (CollectionUtils.hasElements(info.getPrereqAndTechs())) {
				aInfo.prereqAndTechs = new ArrayList<String>();
				for (String val: info.getPrereqAndTechs()) {
					aInfo.prereqAndTechs.add(val);
				}
			}
		
			aInfo.prereqBonus = JaxbUtils.marshallString(info.getPrereqBonus());

			if (CollectionUtils.hasElements(info.getPrereqOrBonuses())) {
				aInfo.prereqOrBonuses = new ArrayList<String>();
				for (String val: info.getPrereqOrBonuses()) {
					aInfo.prereqOrBonuses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqAndCivics())) {
				aInfo.prereqAndCivics = new ArrayList<String>();
				for (String val: info.getPrereqAndCivics()) {
					aInfo.prereqAndCivics.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqOrCivics())) {
				aInfo.prereqOrCivics = new ArrayList<String>();
				for (String val: info.getPrereqOrCivics()) {
					aInfo.prereqOrCivics.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqAndTerrains())) {
				aInfo.prereqAndTerrains = new ArrayList<String>();
				for (String val: info.getPrereqAndTerrains()) {
					aInfo.prereqAndTerrains.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqOrTerrains())) {
				aInfo.prereqOrTerrains = new ArrayList<String>();
				for (String val: info.getPrereqOrTerrains()) {
					aInfo.prereqOrTerrains.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqVicinityAndBonus())) {
				aInfo.prereqVicinityAndBonus = new ArrayList<String>();
				for (String val: info.getPrereqVicinityAndBonus()) {
					aInfo.prereqVicinityAndBonus.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqVicinityOrBonus())) {
				aInfo.prereqVicinityOrBonus = new ArrayList<String>();
				for (String val: info.getPrereqVicinityOrBonus()) {
					aInfo.prereqVicinityOrBonus.add(val);
				}
			}
		
			aInfo.requirePrereqVicinityBonusConnected = JaxbUtils.marshallBoolean(info.isRequirePrereqVicinityBonusConnected(), true);

			if (CollectionUtils.hasElements(info.getPrereqVicinityImprovements())) {
				aInfo.prereqVicinityImprovements = new ArrayList<String>();
				for (String val: info.getPrereqVicinityImprovements()) {
					aInfo.prereqVicinityImprovements.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqVicinityFeatures())) {
				aInfo.prereqVicinityFeatures = new ArrayList<String>();
				for (String val: info.getPrereqVicinityFeatures()) {
					aInfo.prereqVicinityFeatures.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqWorldViews())) {
				aInfo.prereqWorldViews = new ArrayList<String>();
				for (String val: info.getPrereqWorldViews()) {
					aInfo.prereqWorldViews.add(val);
				}
			}
		
			aInfo.minPopulation = JaxbUtils.marshallInteger(info.getMinPopulation());
			aInfo.minCultureLevel = JaxbUtils.marshallString(info.getMinCultureLevel());
			aInfo.prereqPower = JaxbUtils.marshallBoolean(info.isPrereqPower());
			
			if (CollectionUtils.hasElements(info.getProductionTraits())) {
				aInfo.productionTraits = new ArrayList<AdaptedTraitChange>();
				for (IPair<String, Integer> pair: info.getProductionTraits()) {
					AdaptedTraitChange adaptor = new AdaptedTraitChange();
					adaptor.trait = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.productionTraits.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getHappinessTraits())) {
				aInfo.happinessTraits = new ArrayList<AdaptedTraitChange>();
				for (IPair<String, Integer> pair: info.getHappinessTraits()) {
					AdaptedTraitChange adaptor = new AdaptedTraitChange();
					adaptor.trait = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.happinessTraits.add(adaptor);
				}
			}
			
			aInfo.noBonus = JaxbUtils.marshallString(info.getNoBonus());
			aInfo.powerBonus = JaxbUtils.marshallString(info.getPowerBonus());
			aInfo.freeBonus = JaxbUtils.marshallString(info.getFreeBonus());
			aInfo.numFreeBonuses = JaxbUtils.marshallInteger(info.getNumFreeBonuses());
			aInfo.freeBuilding = JaxbUtils.marshallString(info.getFreeBuilding());
			aInfo.freePromotion = JaxbUtils.marshallString(info.getFreePromotion());
			aInfo.civicOption = JaxbUtils.marshallString(info.getCivicOption());
			aInfo.greatPeopleUnitClass = JaxbUtils.marshallString(info.getGreatPeopleUnitClass());
			aInfo.greatPeopleRateChange = JaxbUtils.marshallInteger(info.getGreatPeopleRateChange());
			aInfo.hurryAngerModifier = JaxbUtils.marshallInteger(info.getHurryAngerModifier());
			aInfo.borderObstacle = JaxbUtils.marshallBoolean(info.isBorderObstacle());
			aInfo.teamShare = JaxbUtils.marshallBoolean(info.isTeamShare());
			aInfo.water = JaxbUtils.marshallBoolean(info.isWater());
			aInfo.river = JaxbUtils.marshallBoolean(info.isRiver());
			aInfo.power = JaxbUtils.marshallBoolean(info.isPower());
			aInfo.dirtyPower = JaxbUtils.marshallBoolean(info.isDirtyPower());
			aInfo.areaCleanPower = JaxbUtils.marshallBoolean(info.isAreaCleanPower());
			aInfo.diploVoteType = JaxbUtils.marshallString(info.getDiploVoteType());
			aInfo.forceTeamVoteEligible = JaxbUtils.marshallBoolean(info.isForceTeamVoteEligible());
			aInfo.capital = JaxbUtils.marshallBoolean(info.isCapital());
			aInfo.governmentCenter = JaxbUtils.marshallBoolean(info.isGovernmentCenter());
			aInfo.goldenAge = JaxbUtils.marshallBoolean(info.isGoldenAge());
			aInfo.allowsNukes = JaxbUtils.marshallBoolean(info.isAllowsNukes());
			aInfo.mapCentering = JaxbUtils.marshallBoolean(info.isMapCentering());
			aInfo.noUnhappiness = JaxbUtils.marshallBoolean(info.isNoUnhappiness());
			aInfo.unhealthyPopulationModifier = JaxbUtils.marshallInteger(info.getUnhealthyPopulationModifier());
			aInfo.buildingOnlyHealthy = JaxbUtils.marshallBoolean(info.isBuildingOnlyHealthy());
			aInfo.neverCapture = JaxbUtils.marshallBoolean(info.isNeverCapture());
			aInfo.nukeImmune = JaxbUtils.marshallBoolean(info.isNukeImmune());
			aInfo.prereqAnyReligion = JaxbUtils.marshallBoolean(info.isPrereqReligion());
			aInfo.centerInCity = JaxbUtils.marshallBoolean(info.isCenterInCity());
			aInfo.slaveMarket = JaxbUtils.marshallBoolean(info.isSlaveMarket());
			aInfo.forceDisableStarSigns = JaxbUtils.marshallBoolean(info.isForceDisableStarSigns());
			aInfo.starSignGoodOnly = JaxbUtils.marshallBoolean(info.isStarSignGoodOnly());
			aInfo.starSignMitigateChangePercent = JaxbUtils.marshallInteger(info.getStarSignMitigateChangePercent());
			aInfo.globalStarSignMitigateChangePercent = JaxbUtils.marshallInteger(info.getGlobalStarSignMitigateChangePercent());
			aInfo.starSignScaleChangePercent = JaxbUtils.marshallInteger(info.getStarSignScaleChangePercent());
			aInfo.globalStarSignScaleChangePercent = JaxbUtils.marshallInteger(info.getGlobalStarSignScaleChangePercent());
			aInfo.aiWeight = JaxbUtils.marshallInteger(info.getAIWeight());
			aInfo.cost = JaxbUtils.marshallInteger(info.getCost());
			aInfo.hurryCostModifier = JaxbUtils.marshallInteger(info.getHurryCostModifier());
			aInfo.advancedStartCost = JaxbUtils.marshallInteger(info.getAdvancedStartCost());
			aInfo.advancedStartCostIncrease = JaxbUtils.marshallInteger(info.getAdvancedStartCostIncrease());
			aInfo.extraBarbarianCostChange = JaxbUtils.marshallInteger(info.getExtraBarbarianCostChange());
			aInfo.barbarianConversionCostModifier = JaxbUtils.marshallInteger(info.getBarbarianConversionCostModifier());
			aInfo.minAreaSize = JaxbUtils.marshallInteger(info.getMinAreaSize());
			aInfo.conquestProb = JaxbUtils.marshallInteger(info.getConquestProb());
			aInfo.citiesPrereq = JaxbUtils.marshallInteger(info.getCitiesPrereq());
			aInfo.teamsPrereq = JaxbUtils.marshallInteger(info.getTeamsPrereq());
			aInfo.levelPrereq = JaxbUtils.marshallInteger(info.getLevelPrereq());
			aInfo.minLatitude = JaxbUtils.marshallInteger(info.getMinLatitude());
			aInfo.maxLatitude = JaxbUtils.marshallInteger(info.getMaxLatitude());
			aInfo.workableRadius = JaxbUtils.marshallInteger(info.getWorkableRadius());
			aInfo.greatPeopleRateModifier = JaxbUtils.marshallInteger(info.getGreatPeopleRateModifier());
			aInfo.greatGeneralRateModifier = JaxbUtils.marshallInteger(info.getGreatGeneralRateModifier());
			aInfo.domesticGreatGeneralRateModifier = JaxbUtils.marshallInteger(info.getDomesticGreatGeneralRateModifier());
			aInfo.globalGreatPeopleRateModifier = JaxbUtils.marshallInteger(info.getGlobalGreatPeopleRateModifier());
			aInfo.anarchyModifier = JaxbUtils.marshallInteger(info.getAnarchyModifier());
			aInfo.goldenAgeModifier = JaxbUtils.marshallInteger(info.getGoldenAgeModifier());
			aInfo.globalHurryModifier = JaxbUtils.marshallInteger(info.getGlobalHurryModifier());
			aInfo.experience = JaxbUtils.marshallInteger(info.getExperience());
			aInfo.globalExperience = JaxbUtils.marshallInteger(info.getGlobalExperience());
			aInfo.foodKept = JaxbUtils.marshallInteger(info.getFoodKept());
			aInfo.airlift = JaxbUtils.marshallInteger(info.getAirlift());
			aInfo.airModifier = JaxbUtils.marshallInteger(info.getAirModifier());
			aInfo.airUnitCapacity = JaxbUtils.marshallInteger(info.getAirUnitCapacity());
			aInfo.nukeModifier = JaxbUtils.marshallInteger(info.getNukeModifier());
			aInfo.nukeExplosionRand = JaxbUtils.marshallInteger(info.getNukeExplosionRand());
			aInfo.freeSpecialist = JaxbUtils.marshallInteger(info.getFreeSpecialist());
			aInfo.areaFreeSpecialist = JaxbUtils.marshallInteger(info.getAreaFreeSpecialist());
			aInfo.globalFreeSpecialist = JaxbUtils.marshallInteger(info.getGlobalFreeSpecialist());
			aInfo.maintenanceModifier = JaxbUtils.marshallInteger(info.getMaintenanceModifier());
			aInfo.warWearinessModifier = JaxbUtils.marshallInteger(info.getWarWearinessModifier());
			aInfo.globalWarWearinessModifier = JaxbUtils.marshallInteger(info.getGlobalWarWearinessModifier());
			aInfo.enemyWarWearinessModifier = JaxbUtils.marshallInteger(info.getEnemyWarWearinessModifier());
			aInfo.healRateChange = JaxbUtils.marshallInteger(info.getHealRateChange());
			aInfo.health = JaxbUtils.marshallInteger(info.getHealth());
			aInfo.areaHealth = JaxbUtils.marshallInteger(info.getAreaHealth());
			aInfo.globalHealth = JaxbUtils.marshallInteger(info.getGlobalHealth());
			aInfo.happiness = JaxbUtils.marshallInteger(info.getHappiness());
			aInfo.areaHappiness = JaxbUtils.marshallInteger(info.getAreaHappiness());
			aInfo.globalHappiness = JaxbUtils.marshallInteger(info.getGlobalHappiness());
			aInfo.stateReligionHappiness = JaxbUtils.marshallInteger(info.getStateReligionHappiness());
			aInfo.workerSpeedModifier = JaxbUtils.marshallInteger(info.getWorkerSpeedModifier());
			aInfo.militaryProductionModifier = JaxbUtils.marshallInteger(info.getMilitaryProductionModifier());
			aInfo.spaceProductionModifier = JaxbUtils.marshallInteger(info.getSpaceProductionModifier());
			aInfo.globalSpaceProductionModifier = JaxbUtils.marshallInteger(info.getGlobalSpaceProductionModifier());
			aInfo.tradeRoutes = JaxbUtils.marshallInteger(info.getTradeRoutes());
			aInfo.coastalTradeRoutes = JaxbUtils.marshallInteger(info.getCoastalTradeRoutes());
			aInfo.globalTradeRoutes = JaxbUtils.marshallInteger(info.getGlobalTradeRoutes());
			aInfo.tradeRouteModifier = JaxbUtils.marshallInteger(info.getTradeRouteModifier());
			aInfo.foreignTradeRouteModifier = JaxbUtils.marshallInteger(info.getForeignTradeRouteModifier());
			aInfo.globalPopulationChange = JaxbUtils.marshallInteger(info.getGlobalPopulationChange());
			aInfo.freeTechs = JaxbUtils.marshallInteger(info.getFreeTechs());
			aInfo.defense = JaxbUtils.marshallInteger(info.getDefense());
			aInfo.obsoleteDefence = JaxbUtils.marshallInteger(info.getObsoleteDefence());
			aInfo.bombardDefense = JaxbUtils.marshallInteger(info.getBombardDefense());
			aInfo.allCityDefense = JaxbUtils.marshallInteger(info.getAllCityDefense());
			aInfo.espionageDefense = JaxbUtils.marshallInteger(info.getEspionageDefense());
			aInfo.asset = JaxbUtils.marshallInteger(info.getAsset());
			aInfo.power = JaxbUtils.marshallInteger(info.getPower());
			aInfo.visibilityPriority = JaxbUtils.marshallFloat(info.getVisibilityPriority());

			if (CollectionUtils.hasElements(info.getSeaPlotYieldChanges())) {
				aInfo.seaPlotYieldChanges = new ArrayList<Integer>();
				for (Integer val: info.getSeaPlotYieldChanges()) {
					aInfo.seaPlotYieldChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getRiverPlotYieldChanges())) {
				aInfo.riverPlotYieldChanges = new ArrayList<Integer>();
				for (Integer val: info.getRiverPlotYieldChanges()) {
					aInfo.riverPlotYieldChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getGlobalSeaPlotYieldChanges())) {
				aInfo.globalSeaPlotYieldChanges = new ArrayList<Integer>();
				for (Integer val: info.getGlobalSeaPlotYieldChanges()) {
					aInfo.globalSeaPlotYieldChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getYieldChanges())) {
				aInfo.yieldChanges = new ArrayList<Integer>();
				for (Integer val: info.getYieldChanges()) {
					aInfo.yieldChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getYieldModifiers())) {
				aInfo.yieldModifiers = new ArrayList<Integer>();
				for (Integer val: info.getYieldModifiers()) {
					aInfo.yieldModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPowerYieldModifiers())) {
				aInfo.powerYieldModifiers = new ArrayList<Integer>();
				for (Integer val: info.getPowerYieldModifiers()) {
					aInfo.powerYieldModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getAreaYieldModifiers())) {
				aInfo.areaYieldModifiers = new ArrayList<Integer>();
				for (Integer val: info.getAreaYieldModifiers()) {
					aInfo.areaYieldModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getGlobalYieldModifiers())) {
				aInfo.globalYieldModifiers = new ArrayList<Integer>();
				for (Integer val: info.getGlobalYieldModifiers()) {
					aInfo.globalYieldModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getCommerceChanges())) {
				aInfo.commerceChanges = new ArrayList<Integer>();
				for (Integer val: info.getCommerceChanges()) {
					aInfo.commerceChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getObsoleteSafeCommerceChanges())) {
				aInfo.obsoleteSafeCommerceChanges = new ArrayList<Integer>();
				for (Integer val: info.getObsoleteSafeCommerceChanges()) {
					aInfo.obsoleteSafeCommerceChanges.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getCommerceChangeDoubleTimes())) {
				aInfo.commerceChangeDoubleTimes = new ArrayList<Integer>();
				for (Integer val: info.getCommerceChangeDoubleTimes()) {
					aInfo.commerceChangeDoubleTimes.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getCommerceModifiers())) {
				aInfo.commerceModifiers = new ArrayList<Integer>();
				for (Integer val: info.getCommerceModifiers()) {
					aInfo.commerceModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getGlobalCommerceModifiers())) {
				aInfo.globalCommerceModifiers = new ArrayList<Integer>();
				for (Integer val: info.getGlobalCommerceModifiers()) {
					aInfo.globalCommerceModifiers.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getSpecialistExtraCommerces())) {
				aInfo.specialistExtraCommerces = new ArrayList<Integer>();
				for (Integer val: info.getSpecialistExtraCommerces()) {
					aInfo.specialistExtraCommerces.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getStateReligionCommerces())) {
				aInfo.stateReligionCommerces = new ArrayList<Integer>();
				for (Integer val: info.getStateReligionCommerces()) {
					aInfo.stateReligionCommerces.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getCommerceHappinesses())) {
				aInfo.commerceHappinesses = new ArrayList<Integer>();
				for (Integer val: info.getCommerceHappinesses()) {
					aInfo.commerceHappinesses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getReligionChanges())) {
				aInfo.religionChanges = new ArrayList<AdaptedReligionChange>();
				for (IPair<String, Integer> pair: info.getReligionChanges()) {
					AdaptedReligionChange adaptor = new AdaptedReligionChange();
					adaptor.religion = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.religionChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getSpecialistCounts())) {
				aInfo.specialistCounts = new ArrayList<AdaptedSpecialistCount>();
				for (IPair<String, Integer> pair: info.getSpecialistCounts()) {
					AdaptedSpecialistCount adaptor = new AdaptedSpecialistCount();
					adaptor.specialist = pair.getKey();
					adaptor.count = pair.getValue();
					aInfo.specialistCounts.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getFreeSpecialistCounts())) {
				aInfo.freeSpecialistCounts = new ArrayList<AdaptedSpecialistCount>();
				for (IPair<String, Integer> pair: info.getFreeSpecialistCounts()) {
					AdaptedSpecialistCount adaptor = new AdaptedSpecialistCount();
					adaptor.specialist = pair.getKey();
					adaptor.count = pair.getValue();
					aInfo.freeSpecialistCounts.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getCommerceFlexibles())) {
				aInfo.commerceFlexibles = new ArrayList<Integer>();
				for (Integer val: info.getCommerceFlexibles()) {
					aInfo.commerceFlexibles.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getCommerceChangeOriginalOwners())) {
				aInfo.commerceChangeOriginalOwners = new ArrayList<Integer>();
				for (Integer val: info.getCommerceChangeOriginalOwners()) {
					aInfo.commerceChangeOriginalOwners.add(val);
				}
			}
		
			aInfo.constructSound = JaxbUtils.marshallString(info.getConstructSound());

			if (CollectionUtils.hasElements(info.getBonusHealthChanges())) {
				aInfo.bonusHealthChanges = new ArrayList<AdaptedBonusChange>();
				for (IPair<String, Integer> pair: info.getBonusHealthChanges()) {
					AdaptedBonusChange adaptor = new AdaptedBonusChange();
					adaptor.bonus = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.bonusHealthChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getBonusHappinessChanges())) {
				aInfo.bonusHappinessChanges = new ArrayList<AdaptedBonusChange>();
				for (IPair<String, Integer> pair: info.getBonusHappinessChanges()) {
					AdaptedBonusChange adaptor = new AdaptedBonusChange();
					adaptor.bonus = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.bonusHappinessChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getBonusProductionModifiers())) {
				aInfo.bonusProductionModifiers = new ArrayList<AdaptedBonusModifier>();
				for (IPair<String, Integer> pair: info.getBonusProductionModifiers()) {
					AdaptedBonusModifier adaptor = new AdaptedBonusModifier();
					adaptor.bonus = pair.getKey();
					adaptor.modifier = pair.getValue();
					aInfo.bonusProductionModifiers.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getUnitCombatFreeExperiences())) {
				aInfo.unitCombatFreeExperiences = new ArrayList<AdaptedUnitCombatExperience>();
				for (IPair<String, Integer> pair: info.getUnitCombatFreeExperiences()) {
					AdaptedUnitCombatExperience adaptor = new AdaptedUnitCombatExperience();
					adaptor.unitCombatType = pair.getKey();
					adaptor.experience = pair.getValue();
					aInfo.unitCombatFreeExperiences.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getDomainFreeExperiences())) {
				aInfo.domainFreeExperiences = new ArrayList<AdaptedDomainExperience>();
				for (IPair<String, Integer> pair: info.getDomainFreeExperiences()) {
					AdaptedDomainExperience adaptor = new AdaptedDomainExperience();
					adaptor.domainType = pair.getKey();
					adaptor.experience = pair.getValue();
					aInfo.domainFreeExperiences.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getDomainProductionModifiers())) {
				aInfo.domainProductionModifiers = new ArrayList<AdaptedDomainModifier>();
				for (IPair<String, Integer> pair: info.getDomainProductionModifiers()) {
					AdaptedDomainModifier adaptor = new AdaptedDomainModifier();
					adaptor.domainType = pair.getKey();
					adaptor.modifier = pair.getValue();
					aInfo.domainProductionModifiers.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getBuildingClassProductionModifiers())) {
				aInfo.buildingClassProductionModifiers = new ArrayList<AdaptedBuildingClassProductionModifier>();
				for (IPair<String, Integer> pair: info.getBuildingClassProductionModifiers()) {
					AdaptedBuildingClassProductionModifier adaptor = new AdaptedBuildingClassProductionModifier();
					adaptor.buildingClassType = pair.getKey();
					adaptor.modifier = pair.getValue();
					aInfo.buildingClassProductionModifiers.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getBuildingHappinessChanges())) {
				aInfo.buildingHappinessChanges = new ArrayList<AdaptedBuildingChange>();
				for (IPair<String, Integer> pair: info.getBuildingHappinessChanges()) {
					AdaptedBuildingChange adaptor = new AdaptedBuildingChange();
					adaptor.building = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.buildingHappinessChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getPrereqNumOfBuildingClasses())) {
				aInfo.prereqNumOfBuildingClasses = new ArrayList<AdaptedBuildingClassNumber>();
				for (IPair<String, Integer> pair: info.getPrereqNumOfBuildingClasses()) {
					AdaptedBuildingClassNumber adaptor = new AdaptedBuildingClassNumber();
					adaptor.buildingClass = pair.getKey();
					adaptor.needed = pair.getValue();
					aInfo.prereqNumOfBuildingClasses.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getPrereqAndBuildingClasses())) {
				aInfo.prereqAndBuildingClasses = new ArrayList<String>();
				for (String val: info.getPrereqAndBuildingClasses()) {
					aInfo.prereqAndBuildingClasses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqOrBuildingClasses())) {
				aInfo.prereqOrBuildingClasses = new ArrayList<String>();
				for (String val: info.getPrereqOrBuildingClasses()) {
					aInfo.prereqOrBuildingClasses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getPrereqNotBuildingClasses())) {
				aInfo.prereqNotBuildingClasses = new ArrayList<String>();
				for (String val: info.getPrereqNotBuildingClasses()) {
					aInfo.prereqNotBuildingClasses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getReplacedByBuildingClasses())) {
				aInfo.replacedByBuildingClasses = new ArrayList<String>();
				for (String val: info.getReplacedByBuildingClasses()) {
					aInfo.replacedByBuildingClasses.add(val);
				}
			}
		
			if (CollectionUtils.hasElements(info.getSpecialistYieldChanges().keySet())) {
				aInfo.specialistYieldChanges = new ArrayList<AdaptedSpecialistYieldChange>();
				for (String specialist: info.getSpecialistYieldChanges().keySet()) {
					AdaptedSpecialistYieldChange adaptor = new AdaptedSpecialistYieldChange();
					adaptor.specialist = specialist;
					for (Integer yield: info.getSpecialistYieldChanges().get(specialist)) {
						adaptor.yields.add(yield);
					}
					aInfo.specialistYieldChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getBonusYieldModifiers().keySet())) {
				aInfo.bonusYieldModifiers = new ArrayList<AdaptedBonusYieldModifier>();
				for (String bonus: info.getBonusYieldModifiers().keySet()) {
					AdaptedBonusYieldModifier adaptor = new AdaptedBonusYieldModifier();
					adaptor.bonus = bonus;
					for (Integer yield: info.getBonusYieldModifiers().get(bonus)) {
						adaptor.yields.add(yield);
					}
					aInfo.bonusYieldModifiers.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getVicinityBonusYieldChanges().keySet())) {
				aInfo.vicinityBonusYieldChanges = new ArrayList<AdaptedBonusYieldChange>();
				for (String bonus: info.getVicinityBonusYieldChanges().keySet()) {
					AdaptedBonusYieldChange adaptor = new AdaptedBonusYieldChange();
					adaptor.bonus = bonus;
					for (Integer yield: info.getVicinityBonusYieldChanges().get(bonus)) {
						adaptor.yields.add(yield);
					}
					aInfo.vicinityBonusYieldChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getImprovementFreeSpecialists())) {
				aInfo.improvementFreeSpecialists = new ArrayList<AdaptedImprovementCount>();
				for (IPair<String, Integer> pair: info.getImprovementFreeSpecialists()) {
					AdaptedImprovementCount adaptor = new AdaptedImprovementCount();
					adaptor.improvement = pair.getKey();
					adaptor.count = pair.getValue();
					aInfo.improvementFreeSpecialists.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getFlavors())) {
				aInfo.flavors = new ArrayList<AdaptedFlavor>();
				for (IPair<String, Integer> pair: info.getFlavors()) {
					AdaptedFlavor adaptor = new AdaptedFlavor();
					adaptor.flavor = pair.getKey();
					adaptor.value = pair.getValue();
					aInfo.flavors.add(adaptor);
				}
			}
			
			aInfo.hotKey = JaxbUtils.marshallString(info.getHotKey());
			aInfo.altDown = JaxbUtils.marshallBoolean(info.isAltDown());
			aInfo.shiftDown = JaxbUtils.marshallBoolean(info.isShiftDown());
			aInfo.ctrlDown = JaxbUtils.marshallBoolean(info.isCtrlDown());
			aInfo.hotKeyPriority = JaxbUtils.marshallInteger(info.getHotKeyPriority());
			aInfo.orderPriority = JaxbUtils.marshallInteger(info.getOrderPriority());
			aInfo.graphicalOnly = JaxbUtils.marshallBoolean(info.isGraphicalOnly());
			
			map.entries.add(aInfo);
		}
		
		return map;
	}

}
