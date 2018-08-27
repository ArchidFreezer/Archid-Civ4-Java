/**
 * 
 */
package org.archid.civ4.xml.techinfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.civ4.utils.CollectionUtils;
import org.archid.civ4.utils.IKeyValuePair;
import org.archid.civ4.utils.KeyValuePair;
import org.archid.civ4.utils.JaxbUtils;

/**
 * @author Jim
 *
 */
public class TechMapAdapter extends XmlAdapter<TechMapAdapter.TechMap, Map<String, ITechInfo>> {
	
	public static class TechMap {
		 @XmlElement(name = "TechInfo")
		 List<AdaptedTech> entries = new ArrayList<AdaptedTech>();		
	}
	
	public static class AdaptedTech {
		@XmlElement(name="Type")
		private String type;
		@XmlElement(name="Description")
		private String description;
		@XmlElement(name="Civilopedia")
		private String civilopedia;
		@XmlElement(name="Help")
		private String help;
		@XmlElement(name="Advisor")
		private String advisor;
		@XmlElement(name="iAIWeight")
		private Integer aiWeight;
		@XmlElement(name="iAITradeModifier")
		private Integer aiTradeModifier;
		@XmlElement(name="iCost")
		private Integer cost;
		@XmlElement(name="iAdvancedStartCost")
		private Integer advancedStartCost;
		@XmlElement(name="iAdvancedStartCostIncrease")
		private Integer advancedStartCostIncrease;
		@XmlElement(name="Era")
		private String era = "NO_ERA";
		@XmlElement(name="FirstFreeUnitClass")
		private String firstFreeUnitClass;
		@XmlElement(name="FreeUnitClass")
		private String freeUnitClass;
		@XmlElement(name="iFeatureProductionModifier")
		private Integer featureProductionModifier;
		@XmlElement(name="iWorkerSpeedModifier")
		private Integer workerSpeedModifier;
		@XmlElement(name="iTradeRoutes")
		private Integer tradeRoutes;
		@XmlElement(name="iHealth")
		private Integer health;
		@XmlElement(name="iHappiness")
		private Integer happiness;
		@XmlElement(name="iFirstFreeTechs")
		private Integer firstFreeTechs;
		@XmlElement(name="iAsset")
		private Integer asset;
		@XmlElement(name="iPower")
		private Integer power;
		@XmlElement(name="bRepeat")
		private Integer repeat;
		@XmlElement(name="bTrade")
		private Integer trade;
		@XmlElement(name="bEmbassyTrading")
		private Integer embassyTrading;
		@XmlElement(name="bFreeTradeAgreementTrading")
		private Integer freeTradeAgreementTrading;
		@XmlElement(name="bNonAggressionTrading")
		private Integer nonAggressionTrading;
		@XmlElement(name="bDisable")
		private Integer disable;
		@XmlElement(name="bGoodyTech")
		private Integer goodyTech;
		@XmlElement(name="bExtraWaterSeeFrom")
		private Integer extraWaterSeeFrom;
		@XmlElement(name="bMapCentering")
		private Integer mapCentering;
		@XmlElement(name="bMapVisible")
		private Integer mapVisible;
		@XmlElement(name="bMapTrading")
		private Integer mapTrading;
		@XmlElement(name="bTechTrading")
		private Integer techTrading;
		@XmlElement(name="bGoldTrading")
		private Integer goldTrading;
		@XmlElement(name="bOpenBordersTrading")
		private Integer openBordersTrading;
		@XmlElement(name="bLimitedBordersTrading")
		private Integer limitedBordersTrading;
		@XmlElement(name="bDefensivePactTrading")
		private Integer defensivePactTrading;
		@XmlElement(name="bPermanentAllianceTrading")
		private Integer permanentAllianceTrading;
		@XmlElement(name="bVassalTrading")
		private Integer vassalTrading;
		@XmlElement(name="bBridgeBuilding")
		private Integer bridgeBuilding;
		@XmlElement(name="bIrrigation")
		private Integer irrigation;
		@XmlElement(name="bIgnoreIrrigation")
		private Integer ignoreIrrigation;
		@XmlElement(name="bWaterWork")
		private Integer waterWork;
		@XmlElement(name="bCanPassPeaks")
		private Integer canPassPeaks;
		@XmlElement(name="bMoveFastPeaks")
		private Integer moveFastPeaks;
		@XmlElement(name="bCanFoundOnPeaks")
		private Integer canFoundOnPeaks;
		@XmlElement(name="iGridX")
		private Integer gridX;
		@XmlElement(name="iGridY")
		private Integer gridY;
		@XmlElementWrapper(name="DomainExtraMoves")
		@XmlElement(name="DomainExtraMove")
		private List<AdaptedDomainExtraMoves> domainExtraMoves;
		@XmlElementWrapper(name="CommerceFlexible")
		@XmlElement(name="bFlexible")
		private List<Integer> commerceFlexible;
		@XmlElementWrapper(name="TerrainTrades")
		@XmlElement(name="TerrainType")
		private Set<String> terrainTrades;
		@XmlElement(name="bRiverTrade")
		private Integer riverTrade;
		@XmlElement(name="bCaptureCities")
		private Integer captureCities;
		@XmlElement(name="bUnitRangeUnbound")
		private Integer unitRangeUnbound;
		@XmlElement(name="bUnitTerritoryUnbound")
		private Integer unitTerritoryUnbound;
		@XmlElement(name="iUnitRangeChange")
		private Integer unitRangeChange;
		@XmlElement(name="iUnitRangeModifier")
		private Integer unitRangeModifier;
		@XmlElement(name="iCultureDefenceModifier")
		private Integer cultureDefenceModifier;
		@XmlElementWrapper(name="ForestPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> forestPlotYieldChanges;
		@XmlElementWrapper(name="RiverPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> riverPlotYieldChanges;
		@XmlElementWrapper(name="SeaPlotYieldChanges")
		@XmlElement(name="iYield")
		private List<Integer> seaPlotYieldChanges;
		@XmlElementWrapper(name="DomainExtraMoves")
		@XmlElement(name="DomainExtraMove")
		private List<AdaptedWorldViewRevoltTurnChanges> worldViewRevoltTurnChanges;
		@XmlElementWrapper(name="Flavors")
		@XmlElement(name="Flavor")
		private List<AdaptedFlavors> flavors;
		@XmlElementWrapper(name="OrPreReqs")
		@XmlElement(name="PrereqTech")
		private Set<String> orPrereqs;
		@XmlElementWrapper(name="AndPreReqs")
		@XmlElement(name="PrereqTech")
		private Set<String> andPrereqs;
		@XmlElementWrapper(name="EnabledWorldViews")
		@XmlElement(name="WorldViewType")
		private Set<String> enabledWorldViews;
		@XmlElement(name="Quote")
		private String quote;
		@XmlElement(name="Sound")
		private String sound;
		@XmlElement(name="SoundMP")
		private String soundMP;
		@XmlElement(name="Button")
		private String button;
	}
	
	private static class AdaptedDomainExtraMoves {
		@XmlElement(name="DomainType")
		public String domain;
		@XmlElement(name="iExtraMoves")
		public Integer moves;
	}
	
	private static class AdaptedWorldViewRevoltTurnChanges {
		@XmlElement(name="WorldViewType")
		public String worldView;
		@XmlElement(name="iChange")
		public Integer change;
	}

	private static class AdaptedFlavors {
		@XmlElement(name="FlavorType")
		public String flavor;
		@XmlElement(name="iFlavor")
		public Integer value;
	}

	@Override
	public TechMap marshal(Map<String, ITechInfo> v) throws Exception {
		TechMap techMap = new TechMap();
		for (ITechInfo tech: v.values()) {
			AdaptedTech aTech = new AdaptedTech();
			aTech.type = tech.getType();
			aTech.description = tech.getDescription();
			aTech.civilopedia = JaxbUtils.marshallString(tech.getCivilopedia());
			aTech.help = JaxbUtils.marshallString(tech.getHelp());
			aTech.advisor = tech.getAdvisor();
			aTech.aiWeight = JaxbUtils.marshallInteger(tech.getAiWeight());
			aTech.aiTradeModifier = JaxbUtils.marshallInteger(tech.getAiTradeModifier());
			aTech.cost = tech.getCost();
			aTech.advancedStartCost = tech.getAdvancedStartCost();
			aTech.advancedStartCostIncrease = JaxbUtils.marshallInteger(tech.getAdvancedStartCostIncrease());
			aTech.era = tech.getEra();
			aTech.firstFreeUnitClass = JaxbUtils.marshallString(tech.getFirstFreeUnitClass());
			aTech.freeUnitClass = JaxbUtils.marshallString(tech.getFreeUnitClass());
			aTech.featureProductionModifier = JaxbUtils.marshallInteger(tech.getFeatureProductionModifier());
			aTech.workerSpeedModifier = JaxbUtils.marshallInteger(tech.getWorkerSpeedModifier());
			aTech.tradeRoutes = JaxbUtils.marshallInteger(tech.getTradeRoutes());
			aTech.health = JaxbUtils.marshallInteger(tech.getHealth());
			aTech.happiness = JaxbUtils.marshallInteger(tech.getHappiness());
			aTech.firstFreeTechs = JaxbUtils.marshallInteger(tech.getFirstFreeTechs());
			aTech.asset = tech.getAsset();
			aTech.power = JaxbUtils.marshallInteger(tech.getPower());
			aTech.repeat = JaxbUtils.marshallBoolean(tech.isRepeat());
			aTech.trade = JaxbUtils.marshallBoolean(tech.isTrade());
			aTech.embassyTrading = JaxbUtils.marshallBoolean(tech.isEmbassyTrading());
			aTech.freeTradeAgreementTrading = JaxbUtils.marshallBoolean(tech.isFreeTradeAgreementTrading());
			aTech.nonAggressionTrading = JaxbUtils.marshallBoolean(tech.isNonAggressionTrading());
			aTech.disable = JaxbUtils.marshallBoolean(tech.isDisable());
			aTech.goodyTech = JaxbUtils.marshallBoolean(tech.isGoodyTech());
			aTech.extraWaterSeeFrom = JaxbUtils.marshallBoolean(tech.isExtraWaterSeeFrom());
			aTech.mapCentering = JaxbUtils.marshallBoolean(tech.isMapCentering());
			aTech.mapVisible = JaxbUtils.marshallBoolean(tech.isMapVisible());
			aTech.mapTrading = JaxbUtils.marshallBoolean(tech.isMapTrading());
			aTech.techTrading = JaxbUtils.marshallBoolean(tech.isTechTrading());
			aTech.goldTrading = JaxbUtils.marshallBoolean(tech.isGoldTrading());
			aTech.openBordersTrading = JaxbUtils.marshallBoolean(tech.isOpenBordersTrading());
			aTech.limitedBordersTrading = JaxbUtils.marshallBoolean(tech.isLimitedBordersTrading());
			aTech.defensivePactTrading = JaxbUtils.marshallBoolean(tech.isDefensivePactTrading());
			aTech.permanentAllianceTrading = JaxbUtils.marshallBoolean(tech.isPermanentAllianceTrading());
			aTech.vassalTrading = JaxbUtils.marshallBoolean(tech.isVassalTrading());
			aTech.bridgeBuilding = JaxbUtils.marshallBoolean(tech.isBridgeBuilding());
			aTech.irrigation = JaxbUtils.marshallBoolean(tech.isIrrigation());
			aTech.ignoreIrrigation = JaxbUtils.marshallBoolean(tech.isIgnoreIrrigation());
			aTech.waterWork = JaxbUtils.marshallBoolean(tech.isWaterWork());
			aTech.canPassPeaks = JaxbUtils.marshallBoolean(tech.isCanPassPeaks());
			aTech.moveFastPeaks = JaxbUtils.marshallBoolean(tech.isMoveFastPeaks());
			aTech.canFoundOnPeaks = JaxbUtils.marshallBoolean(tech.isCanFoundOnPeaks());
			aTech.gridX = tech.getGridX();
			aTech.gridY = tech.getGridY();
			aTech.riverTrade = JaxbUtils.marshallBoolean(tech.isRiverTrade());
			aTech.captureCities = JaxbUtils.marshallBoolean(tech.isCaptureCites());
			aTech.unitRangeUnbound = JaxbUtils.marshallBoolean(tech.isUnitRangeUnbound());
			aTech.unitTerritoryUnbound = JaxbUtils.marshallBoolean(tech.isUnitTerritoryUnbound());
			aTech.unitRangeChange = JaxbUtils.marshallInteger(tech.getUnitRangeChange());
			aTech.unitRangeModifier = JaxbUtils.marshallInteger(tech.getUnitRangeModifier());
			aTech.cultureDefenceModifier = JaxbUtils.marshallInteger(tech.getCultureDefenceModifier());
			aTech.quote = JaxbUtils.marshallString(tech.getQuote());
			aTech.sound = JaxbUtils.marshallString(tech.getSound());
			aTech.soundMP = JaxbUtils.marshallString(tech.getSoundMP());
			aTech.button = tech.getButton();

			if (CollectionUtils.hasElements(tech.getDomainExtraMoves())) {
				aTech.domainExtraMoves = new ArrayList<AdaptedDomainExtraMoves>();
				for (IKeyValuePair<String, Integer> pair: tech.getDomainExtraMoves()) {
					AdaptedDomainExtraMoves adaptor = new AdaptedDomainExtraMoves();
					adaptor.domain = pair.getKey();
					adaptor.moves = pair.getValue();
					aTech.domainExtraMoves.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getWorldViewRevoltTurnChanges())) {
				aTech.worldViewRevoltTurnChanges = new ArrayList<AdaptedWorldViewRevoltTurnChanges>();
				for (IKeyValuePair<String, Integer> pair: tech.getWorldViewRevoltTurnChanges()) {
					AdaptedWorldViewRevoltTurnChanges adaptor = new AdaptedWorldViewRevoltTurnChanges();
					adaptor.worldView = pair.getKey();
					adaptor.change = pair.getValue();
					aTech.worldViewRevoltTurnChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getFlavors())) {
				aTech.flavors = new ArrayList<AdaptedFlavors>();
				for (IKeyValuePair<String, Integer> pair: tech.getFlavors()) {
					AdaptedFlavors adaptor = new AdaptedFlavors();
					adaptor.flavor = pair.getKey();
					adaptor.value = pair.getValue();
					aTech.flavors.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getCommerceFlexibles())) {
				aTech.commerceFlexible = new ArrayList<Integer>();
				for (Boolean flex: tech.getCommerceFlexibles()) {
					aTech.commerceFlexible.add(flex ? 1 : 0);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getTerrainTrades())) {
				aTech.terrainTrades = new HashSet<String>();
				for (String terrain: tech.getTerrainTrades()) {
					aTech.terrainTrades.add(terrain);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getForestPlotYieldChanges())) {
				aTech.forestPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: tech.getForestPlotYieldChanges()) {
					aTech.forestPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getRiverPlotYieldChanges())) {
				aTech.riverPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: tech.getRiverPlotYieldChanges()) {
					aTech.riverPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getSeaPlotYieldChanges())) {
				aTech.seaPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: tech.getSeaPlotYieldChanges()) {
					aTech.seaPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getOrPrereqs())) {
				aTech.orPrereqs = new HashSet<String>();
				for (String prereq: tech.getOrPrereqs()) {
					aTech.orPrereqs.add(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getAndPrereqs())) {
				aTech.andPrereqs = new HashSet<String>();
				for (String prereq: tech.getAndPrereqs()) {
					aTech.andPrereqs.add(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(tech.getEnabledWorldViews())) {
				aTech.enabledWorldViews = new HashSet<String>();
				for (String worldView: tech.getEnabledWorldViews()) {
					aTech.enabledWorldViews.add(worldView);
				}
			}
			
			techMap.entries.add(aTech);
		}
		return techMap;
	}

	@Override
	public Map<String, ITechInfo> unmarshal(TechMap v) throws Exception {
		Map<String, ITechInfo> map = new TreeMap<String, ITechInfo>();
		for (AdaptedTech aTech: v.entries) {
			ITechInfo tech = TechInfos.createTech(aTech.type);
			tech.setDescription(JaxbUtils.unmarshallString(aTech.description));
			tech.setCivilopedia(JaxbUtils.unmarshallString(aTech.civilopedia));
			tech.setHelp(JaxbUtils.unmarshallString(aTech.help));
			tech.setAdvisor(JaxbUtils.unmarshallString(aTech.advisor));
			tech.setAiWeight(JaxbUtils.unmarshallInteger(aTech.aiWeight));
			tech.setAiTradeModifier(JaxbUtils.unmarshallInteger(aTech.aiTradeModifier));
			tech.setCost(JaxbUtils.unmarshallInteger(aTech.cost));
			tech.setAdvancedStartCost(aTech.advancedStartCost);
			tech.setAdvancedStartCostIncrease(JaxbUtils.unmarshallInteger(aTech.advancedStartCostIncrease));
			tech.setEra(JaxbUtils.unmarshallString(aTech.era));
			tech.setFirstFreeUnitClass(JaxbUtils.unmarshallString(aTech.firstFreeUnitClass));
			tech.setFreeUnitClass(JaxbUtils.unmarshallString(aTech.freeUnitClass));
			tech.setFeatureProductionModifier(JaxbUtils.unmarshallInteger(aTech.featureProductionModifier));
			tech.setWorkerSpeedModifier(JaxbUtils.unmarshallInteger(aTech.workerSpeedModifier));
			tech.setTradeRoutes(JaxbUtils.unmarshallInteger(aTech.tradeRoutes));
			tech.setHealth(JaxbUtils.unmarshallInteger(aTech.health));
			tech.setHappiness(JaxbUtils.unmarshallInteger(aTech.happiness));
			tech.setFirstFreeTechs(JaxbUtils.unmarshallInteger(aTech.firstFreeTechs));
			tech.setAsset(JaxbUtils.unmarshallInteger(aTech.asset));
			tech.setPower(JaxbUtils.unmarshallInteger(aTech.power));
			tech.setRepeat(JaxbUtils.unmarshallBoolean(aTech.repeat));
			tech.setTrade(JaxbUtils.unmarshallBoolean(aTech.trade));
			tech.setEmbassyTrading(JaxbUtils.unmarshallBoolean(aTech.embassyTrading));
			tech.setFreeTradeAgreementTrading(JaxbUtils.unmarshallBoolean(aTech.freeTradeAgreementTrading));
			tech.setNonAggressionTrading(JaxbUtils.unmarshallBoolean(aTech.nonAggressionTrading));
			tech.setDisable(JaxbUtils.unmarshallBoolean(aTech.disable));
			tech.setGoodyTech(JaxbUtils.unmarshallBoolean(aTech.goodyTech));
			tech.setExtraWaterSeeFrom(JaxbUtils.unmarshallBoolean(aTech.extraWaterSeeFrom));
			tech.setMapCentering(JaxbUtils.unmarshallBoolean(aTech.mapCentering));
			tech.setMapVisible(JaxbUtils.unmarshallBoolean(aTech.mapVisible));
			tech.setMapTrading(JaxbUtils.unmarshallBoolean(aTech.mapTrading));
			tech.setTechTrading(JaxbUtils.unmarshallBoolean(aTech.techTrading));
			tech.setGoldTrading(JaxbUtils.unmarshallBoolean(aTech.goldTrading));
			tech.setOpenBordersTrading(JaxbUtils.unmarshallBoolean(aTech.openBordersTrading));
			tech.setLimitedBordersTrading(JaxbUtils.unmarshallBoolean(aTech.limitedBordersTrading));
			tech.setDefensivePactTrading(JaxbUtils.unmarshallBoolean(aTech.defensivePactTrading));
			tech.setPermanentAllianceTrading(JaxbUtils.unmarshallBoolean(aTech.permanentAllianceTrading));
			tech.setVassalTrading(JaxbUtils.unmarshallBoolean(aTech.vassalTrading));
			tech.setBridgeBuilding(JaxbUtils.unmarshallBoolean(aTech.bridgeBuilding));
			tech.setIrrigation(JaxbUtils.unmarshallBoolean(aTech.irrigation));
			tech.setIgnoreIrrigation(JaxbUtils.unmarshallBoolean(aTech.ignoreIrrigation));
			tech.setWaterWork(JaxbUtils.unmarshallBoolean(aTech.waterWork));
			tech.setCanPassPeaks(JaxbUtils.unmarshallBoolean(aTech.canPassPeaks));
			tech.setMoveFastPeaks(JaxbUtils.unmarshallBoolean(aTech.moveFastPeaks));
			tech.setCanFoundOnPeaks(JaxbUtils.unmarshallBoolean(aTech.canFoundOnPeaks));
			tech.setGridX(JaxbUtils.unmarshallInteger(aTech.gridX));
			tech.setGridY(JaxbUtils.unmarshallInteger(aTech.gridY));
			tech.setRiverTrade(JaxbUtils.unmarshallBoolean(aTech.riverTrade));
			tech.setCaptureCities(JaxbUtils.unmarshallBoolean(aTech.captureCities));
			tech.setUnitRangeUnbound(JaxbUtils.unmarshallBoolean(aTech.unitRangeUnbound));
			tech.setUnitTerritoryUnbound(JaxbUtils.unmarshallBoolean(aTech.unitTerritoryUnbound));
			tech.setUnitRangeChange(JaxbUtils.unmarshallInteger(aTech.unitRangeChange));
			tech.setUnitRangeModifier(JaxbUtils.unmarshallInteger(aTech.unitRangeModifier));
			tech.setCultureDefenceModifier(JaxbUtils.unmarshallInteger(aTech.cultureDefenceModifier));
			tech.setQuote(JaxbUtils.unmarshallString(aTech.quote));
			tech.setSound(JaxbUtils.unmarshallString(aTech.sound));
			tech.setSoundMP(JaxbUtils.unmarshallString(aTech.soundMP));
			tech.setButton(JaxbUtils.unmarshallString(aTech.button));

			if (CollectionUtils.hasElements(aTech.domainExtraMoves)) {
				for (AdaptedDomainExtraMoves adaptor: aTech.domainExtraMoves) {
					tech.addDomainExtraMove(new KeyValuePair<String, Integer>(adaptor.domain, adaptor.moves));
				}
			}
			
			if (CollectionUtils.hasElements(aTech.worldViewRevoltTurnChanges)) {
				for (AdaptedWorldViewRevoltTurnChanges adaptor: aTech.worldViewRevoltTurnChanges) {
					tech.addWorldViewRevoltTurnChange(new KeyValuePair<String, Integer>(adaptor.worldView, adaptor.change));
				}
			}
			
			if (CollectionUtils.hasElements(aTech.flavors)) {
				for (AdaptedFlavors adaptor: aTech.flavors) {
					tech.addFlavor(new KeyValuePair<String, Integer>(adaptor.flavor, adaptor.value));
				}
			}
			
			if (CollectionUtils.hasElements(aTech.commerceFlexible)) {
				for (Integer flexible: aTech.commerceFlexible) {
					tech.addCommerceFlexible(JaxbUtils.unmarshallBoolean(flexible));
				}
			}
			
			if (CollectionUtils.hasElements(aTech.terrainTrades)) {
				for (String terrain: aTech.terrainTrades) {
					tech.addTerrainTrade(terrain);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.forestPlotYieldChanges)) {
				for (Integer change: aTech.forestPlotYieldChanges) {
					tech.addForestPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.riverPlotYieldChanges)) {
				for (Integer change: aTech.riverPlotYieldChanges) {
					tech.addRiverPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.seaPlotYieldChanges)) {
				for (Integer change: aTech.seaPlotYieldChanges) {
					tech.addSeaPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.orPrereqs)) {
				for (String prereq: aTech.orPrereqs) {
					tech.addOrPrereq(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.andPrereqs)) {
				for (String prereq: aTech.andPrereqs) {
					tech.addAndPrereq(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(aTech.enabledWorldViews)) {
				for (String worldView: aTech.enabledWorldViews) {
					tech.addEnabledWorldViews(worldView);
				}
			}
			
			map.put(aTech.type, tech);
		}
		return map;
	}

}
