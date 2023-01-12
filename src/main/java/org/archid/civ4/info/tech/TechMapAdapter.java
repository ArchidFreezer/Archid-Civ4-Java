/**
 * 
 */
package org.archid.civ4.info.tech;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.utils.CollectionUtils;
import org.archid.utils.IPair;
import org.archid.utils.JaxbUtils;
import org.archid.utils.Pair;
import org.archid.utils.StringUtils;

/**
 * @author Jim
 *
 */
public class TechMapAdapter extends XmlAdapter<TechMapAdapter.TechMap, Map<String, ITechInfo>> {
	
	public static class TechMap {
		 @XmlElement(name = "TechInfo")
		 List<AdaptedTech> entries = new ArrayList<AdaptedTech>();		
	}
	
	private static class AdaptedTech {
		@XmlElement(name="Type")
		private String type;
		@XmlElement(name="Description")
		private String description;
		@XmlElement(name="Civilopedia")
		private String civilopedia;
		@XmlElement(name="Help")
		private String help;
		@XmlElement(name="Strategy")
		private String strategy;
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
		@XmlElement(name="FreeCapitalBuildingClass")
		private String freeCapitalBuildingClass;
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
		@XmlElementWrapper(name="CommerceModifiers")
		@XmlElement(name="iCommerce")
		private List<Integer> commerceModifiers;
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
		private List<String> orPrereqs;
		@XmlElementWrapper(name="AndPreReqs")
		@XmlElement(name="PrereqTech")
		private List<String> andPrereqs;
		@XmlElementWrapper(name="EnabledWorldViews")
		@XmlElement(name="WorldViewType")
		private List<String> enabledWorldViews;
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
		private String domain;
		@XmlElement(name="iExtraMoves")
		private Integer moves;
	}
	
	private static class AdaptedWorldViewRevoltTurnChanges {
		@XmlElement(name="WorldViewType")
		private String worldView;
		@XmlElement(name="iChange")
		private Integer change;
	}

	private static class AdaptedFlavors {
		@XmlElement(name="FlavorType")
		private String flavor;
		@XmlElement(name="iFlavor")
		private Integer value;
	}

	@Override
	public TechMap marshal(Map<String, ITechInfo> v) throws Exception {
		TechMap map = new TechMap();
		for (ITechInfo info: v.values()) {
			AdaptedTech aInfo = new AdaptedTech();
			aInfo.type = info.getType();
			aInfo.description = info.getDescription();
			aInfo.civilopedia = JaxbUtils.marshallString(info.getCivilopedia());
			aInfo.help = JaxbUtils.marshallString(info.getHelp());
			aInfo.strategy = JaxbUtils.marshallString(info.getStrategy());
			aInfo.advisor = info.getAdvisor();
			aInfo.aiWeight = JaxbUtils.marshallInteger(info.getAiWeight());
			aInfo.aiTradeModifier = JaxbUtils.marshallInteger(info.getAiTradeModifier());
			aInfo.cost = info.getCost();
			aInfo.advancedStartCost = info.getAdvancedStartCost();
			aInfo.advancedStartCostIncrease = JaxbUtils.marshallInteger(info.getAdvancedStartCostIncrease());
			aInfo.era = info.getEra();
			aInfo.freeCapitalBuildingClass = JaxbUtils.marshallString(info.getFreeCapitalBuildingClass());
			aInfo.firstFreeUnitClass = JaxbUtils.marshallString(info.getFirstFreeUnitClass());
			aInfo.freeUnitClass = JaxbUtils.marshallString(info.getFreeUnitClass());
			aInfo.featureProductionModifier = JaxbUtils.marshallInteger(info.getFeatureProductionModifier());
			aInfo.workerSpeedModifier = JaxbUtils.marshallInteger(info.getWorkerSpeedModifier());
			aInfo.tradeRoutes = JaxbUtils.marshallInteger(info.getTradeRoutes());
			aInfo.health = JaxbUtils.marshallInteger(info.getHealth());
			aInfo.happiness = JaxbUtils.marshallInteger(info.getHappiness());
			aInfo.firstFreeTechs = JaxbUtils.marshallInteger(info.getFirstFreeTechs());
			aInfo.asset = info.getAsset();
			aInfo.power = JaxbUtils.marshallInteger(info.getPower());
			aInfo.repeat = JaxbUtils.marshallBoolean(info.isRepeat());
			aInfo.trade = JaxbUtils.marshallBoolean(info.isTrade());
			aInfo.embassyTrading = JaxbUtils.marshallBoolean(info.isEmbassyTrading());
			aInfo.freeTradeAgreementTrading = JaxbUtils.marshallBoolean(info.isFreeTradeAgreementTrading());
			aInfo.nonAggressionTrading = JaxbUtils.marshallBoolean(info.isNonAggressionTrading());
			aInfo.disable = JaxbUtils.marshallBoolean(info.isDisable());
			aInfo.goodyTech = JaxbUtils.marshallBoolean(info.isGoodyTech());
			aInfo.extraWaterSeeFrom = JaxbUtils.marshallBoolean(info.isExtraWaterSeeFrom());
			aInfo.mapCentering = JaxbUtils.marshallBoolean(info.isMapCentering());
			aInfo.mapVisible = JaxbUtils.marshallBoolean(info.isMapVisible());
			aInfo.mapTrading = JaxbUtils.marshallBoolean(info.isMapTrading());
			aInfo.techTrading = JaxbUtils.marshallBoolean(info.isTechTrading());
			aInfo.goldTrading = JaxbUtils.marshallBoolean(info.isGoldTrading());
			aInfo.openBordersTrading = JaxbUtils.marshallBoolean(info.isOpenBordersTrading());
			aInfo.limitedBordersTrading = JaxbUtils.marshallBoolean(info.isLimitedBordersTrading());
			aInfo.defensivePactTrading = JaxbUtils.marshallBoolean(info.isDefensivePactTrading());
			aInfo.permanentAllianceTrading = JaxbUtils.marshallBoolean(info.isPermanentAllianceTrading());
			aInfo.vassalTrading = JaxbUtils.marshallBoolean(info.isVassalTrading());
			aInfo.bridgeBuilding = JaxbUtils.marshallBoolean(info.isBridgeBuilding());
			aInfo.irrigation = JaxbUtils.marshallBoolean(info.isIrrigation());
			aInfo.ignoreIrrigation = JaxbUtils.marshallBoolean(info.isIgnoreIrrigation());
			aInfo.waterWork = JaxbUtils.marshallBoolean(info.isWaterWork());
			aInfo.canPassPeaks = JaxbUtils.marshallBoolean(info.isCanPassPeaks());
			aInfo.moveFastPeaks = JaxbUtils.marshallBoolean(info.isMoveFastPeaks());
			aInfo.canFoundOnPeaks = JaxbUtils.marshallBoolean(info.isCanFoundOnPeaks());
			aInfo.gridX = info.getGridX();
			aInfo.gridY = info.getGridY();
			aInfo.riverTrade = JaxbUtils.marshallBoolean(info.isRiverTrade());
			aInfo.captureCities = JaxbUtils.marshallBoolean(info.isCaptureCites());
			aInfo.unitRangeUnbound = JaxbUtils.marshallBoolean(info.isUnitRangeUnbound());
			aInfo.unitTerritoryUnbound = JaxbUtils.marshallBoolean(info.isUnitTerritoryUnbound());
			aInfo.unitRangeChange = JaxbUtils.marshallInteger(info.getUnitRangeChange());
			aInfo.unitRangeModifier = JaxbUtils.marshallInteger(info.getUnitRangeModifier());
			aInfo.cultureDefenceModifier = JaxbUtils.marshallInteger(info.getCultureDefenceModifier());
			aInfo.quote = JaxbUtils.marshallString(info.getQuote());
			aInfo.sound = JaxbUtils.marshallString(info.getSound());
			aInfo.soundMP = JaxbUtils.marshallString(info.getSoundMP());
			aInfo.button = info.getButton();

			if (CollectionUtils.hasElements(info.getCommerceModifiers())) {
				aInfo.commerceModifiers = new ArrayList<Integer>();
				for (Integer change: info.getCommerceModifiers()) {
					aInfo.commerceModifiers.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(info.getDomainExtraMoves())) {
				aInfo.domainExtraMoves = new ArrayList<AdaptedDomainExtraMoves>();
				for (IPair<String, Integer> pair: info.getDomainExtraMoves()) {
					AdaptedDomainExtraMoves adaptor = new AdaptedDomainExtraMoves();
					adaptor.domain = pair.getKey();
					adaptor.moves = pair.getValue();
					aInfo.domainExtraMoves.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getWorldViewRevoltTurnChanges())) {
				aInfo.worldViewRevoltTurnChanges = new ArrayList<AdaptedWorldViewRevoltTurnChanges>();
				for (IPair<String, Integer> pair: info.getWorldViewRevoltTurnChanges()) {
					AdaptedWorldViewRevoltTurnChanges adaptor = new AdaptedWorldViewRevoltTurnChanges();
					adaptor.worldView = pair.getKey();
					adaptor.change = pair.getValue();
					aInfo.worldViewRevoltTurnChanges.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getFlavors())) {
				aInfo.flavors = new ArrayList<AdaptedFlavors>();
				for (IPair<String, Integer> pair: info.getFlavors()) {
					AdaptedFlavors adaptor = new AdaptedFlavors();
					adaptor.flavor = pair.getKey();
					adaptor.value = pair.getValue();
					aInfo.flavors.add(adaptor);
				}
			}
			
			if (CollectionUtils.hasElements(info.getCommerceFlexibles())) {
				aInfo.commerceFlexible = new ArrayList<Integer>();
				for (Boolean flex: info.getCommerceFlexibles()) {
					aInfo.commerceFlexible.add(flex ? 1 : 0);
				}
			}
			
			if (CollectionUtils.hasElements(info.getTerrainTrades())) {
				aInfo.terrainTrades = new HashSet<String>();
				for (String terrain: info.getTerrainTrades()) {
					aInfo.terrainTrades.add(terrain);
				}
			}
			
			if (CollectionUtils.hasElements(info.getForestPlotYieldChanges())) {
				aInfo.forestPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: info.getForestPlotYieldChanges()) {
					aInfo.forestPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(info.getRiverPlotYieldChanges())) {
				aInfo.riverPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: info.getRiverPlotYieldChanges()) {
					aInfo.riverPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(info.getSeaPlotYieldChanges())) {
				aInfo.seaPlotYieldChanges = new ArrayList<Integer>();
				for (Integer change: info.getSeaPlotYieldChanges()) {
					aInfo.seaPlotYieldChanges.add(change);
				}
			}
			
			if (CollectionUtils.hasElements(info.getOrPrereqs())) {
				aInfo.orPrereqs = new ArrayList<String>();
				for (String prereq: info.getOrPrereqs()) {
					aInfo.orPrereqs.add(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(info.getAndPrereqs())) {
				aInfo.andPrereqs = new ArrayList<String>();
				for (String prereq: info.getAndPrereqs()) {
					aInfo.andPrereqs.add(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(info.getEnabledWorldViews())) {
				aInfo.enabledWorldViews = new ArrayList<String>();
				for (String worldView: info.getEnabledWorldViews()) {
					aInfo.enabledWorldViews.add(worldView);
				}
			}
			
			map.entries.add(aInfo);
		}
		return map;
	}

	@Override
	public Map<String, ITechInfo> unmarshal(TechMap v) throws Exception {
		Map<String, ITechInfo> map = new TreeMap<String, ITechInfo>();
		for (AdaptedTech aInfo: v.entries) {
			ITechInfo info = TechInfos.createInfo(aInfo.type);
			info.setDescription(JaxbUtils.unmarshallString(aInfo.description));
			info.setCivilopedia(JaxbUtils.unmarshallString(aInfo.civilopedia));
			info.setHelp(JaxbUtils.unmarshallString(aInfo.help));
			info.setStrategy(JaxbUtils.unmarshallString(aInfo.strategy));
			info.setAdvisor(JaxbUtils.unmarshallString(aInfo.advisor));
			info.setAiWeight(JaxbUtils.unmarshallInteger(aInfo.aiWeight));
			info.setAiTradeModifier(JaxbUtils.unmarshallInteger(aInfo.aiTradeModifier));
			info.setCost(JaxbUtils.unmarshallInteger(aInfo.cost));
			info.setAdvancedStartCost(JaxbUtils.unmarshallInteger(aInfo.advancedStartCost));
			info.setAdvancedStartCostIncrease(JaxbUtils.unmarshallInteger(aInfo.advancedStartCostIncrease));
			info.setEra(JaxbUtils.unmarshallString(aInfo.era));
			info.setFreeCapitalBuildingClass(JaxbUtils.unmarshallString(aInfo.freeCapitalBuildingClass));
			info.setFirstFreeUnitClass(JaxbUtils.unmarshallString(aInfo.firstFreeUnitClass));
			info.setFreeUnitClass(JaxbUtils.unmarshallString(aInfo.freeUnitClass));
			info.setFeatureProductionModifier(JaxbUtils.unmarshallInteger(aInfo.featureProductionModifier));
			info.setWorkerSpeedModifier(JaxbUtils.unmarshallInteger(aInfo.workerSpeedModifier));
			info.setTradeRoutes(JaxbUtils.unmarshallInteger(aInfo.tradeRoutes));
			info.setHealth(JaxbUtils.unmarshallInteger(aInfo.health));
			info.setHappiness(JaxbUtils.unmarshallInteger(aInfo.happiness));
			info.setFirstFreeTechs(JaxbUtils.unmarshallInteger(aInfo.firstFreeTechs));
			info.setAsset(JaxbUtils.unmarshallInteger(aInfo.asset));
			info.setPower(JaxbUtils.unmarshallInteger(aInfo.power));
			info.setRepeat(JaxbUtils.unmarshallBoolean(aInfo.repeat));
			info.setTrade(JaxbUtils.unmarshallBoolean(aInfo.trade));
			info.setEmbassyTrading(JaxbUtils.unmarshallBoolean(aInfo.embassyTrading));
			info.setFreeTradeAgreementTrading(JaxbUtils.unmarshallBoolean(aInfo.freeTradeAgreementTrading));
			info.setNonAggressionTrading(JaxbUtils.unmarshallBoolean(aInfo.nonAggressionTrading));
			info.setDisable(JaxbUtils.unmarshallBoolean(aInfo.disable));
			info.setGoodyTech(JaxbUtils.unmarshallBoolean(aInfo.goodyTech));
			info.setExtraWaterSeeFrom(JaxbUtils.unmarshallBoolean(aInfo.extraWaterSeeFrom));
			info.setMapCentering(JaxbUtils.unmarshallBoolean(aInfo.mapCentering));
			info.setMapVisible(JaxbUtils.unmarshallBoolean(aInfo.mapVisible));
			info.setMapTrading(JaxbUtils.unmarshallBoolean(aInfo.mapTrading));
			info.setTechTrading(JaxbUtils.unmarshallBoolean(aInfo.techTrading));
			info.setGoldTrading(JaxbUtils.unmarshallBoolean(aInfo.goldTrading));
			info.setOpenBordersTrading(JaxbUtils.unmarshallBoolean(aInfo.openBordersTrading));
			info.setLimitedBordersTrading(JaxbUtils.unmarshallBoolean(aInfo.limitedBordersTrading));
			info.setDefensivePactTrading(JaxbUtils.unmarshallBoolean(aInfo.defensivePactTrading));
			info.setPermanentAllianceTrading(JaxbUtils.unmarshallBoolean(aInfo.permanentAllianceTrading));
			info.setVassalTrading(JaxbUtils.unmarshallBoolean(aInfo.vassalTrading));
			info.setBridgeBuilding(JaxbUtils.unmarshallBoolean(aInfo.bridgeBuilding));
			info.setIrrigation(JaxbUtils.unmarshallBoolean(aInfo.irrigation));
			info.setIgnoreIrrigation(JaxbUtils.unmarshallBoolean(aInfo.ignoreIrrigation));
			info.setWaterWork(JaxbUtils.unmarshallBoolean(aInfo.waterWork));
			info.setCanPassPeaks(JaxbUtils.unmarshallBoolean(aInfo.canPassPeaks));
			info.setMoveFastPeaks(JaxbUtils.unmarshallBoolean(aInfo.moveFastPeaks));
			info.setCanFoundOnPeaks(JaxbUtils.unmarshallBoolean(aInfo.canFoundOnPeaks));
			info.setGridX(JaxbUtils.unmarshallInteger(aInfo.gridX));
			info.setGridY(JaxbUtils.unmarshallInteger(aInfo.gridY));
			info.setRiverTrade(JaxbUtils.unmarshallBoolean(aInfo.riverTrade));
			info.setCaptureCities(JaxbUtils.unmarshallBoolean(aInfo.captureCities));
			info.setUnitRangeUnbound(JaxbUtils.unmarshallBoolean(aInfo.unitRangeUnbound));
			info.setUnitTerritoryUnbound(JaxbUtils.unmarshallBoolean(aInfo.unitTerritoryUnbound));
			info.setUnitRangeChange(JaxbUtils.unmarshallInteger(aInfo.unitRangeChange));
			info.setUnitRangeModifier(JaxbUtils.unmarshallInteger(aInfo.unitRangeModifier));
			info.setCultureDefenceModifier(JaxbUtils.unmarshallInteger(aInfo.cultureDefenceModifier));
			info.setQuote(JaxbUtils.unmarshallString(aInfo.quote));
			info.setSound(JaxbUtils.unmarshallString(aInfo.sound));
			info.setSoundMP(JaxbUtils.unmarshallString(aInfo.soundMP));
			info.setButton(JaxbUtils.unmarshallString(aInfo.button));

			if (CollectionUtils.hasNonZeroElements(aInfo.commerceModifiers)) {
				for (Integer change: aInfo.commerceModifiers) {
					info.addCommerceModifier(change);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.domainExtraMoves)) {
				for (AdaptedDomainExtraMoves adaptor: aInfo.domainExtraMoves) {
					if (adaptor.moves != 0)
						info.addDomainExtraMove(new Pair<String, Integer>(adaptor.domain, adaptor.moves));
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.worldViewRevoltTurnChanges)) {
				for (AdaptedWorldViewRevoltTurnChanges adaptor: aInfo.worldViewRevoltTurnChanges) {
					if (StringUtils.hasCharacters(adaptor.worldView) && adaptor.change != 0)
						info.addWorldViewRevoltTurnChange(new Pair<String, Integer>(adaptor.worldView, adaptor.change));
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.flavors)) {
				for (AdaptedFlavors adaptor: aInfo.flavors) {
					if (StringUtils.hasCharacters(adaptor.flavor) && adaptor.value != 0)
						info.addFlavor(new Pair<String, Integer>(adaptor.flavor, adaptor.value));
				}
			}
			
			if (CollectionUtils.hasNonZeroElements(aInfo.commerceFlexible)) {
				for (Integer flexible: aInfo.commerceFlexible) {
					info.addCommerceFlexible(JaxbUtils.unmarshallBoolean(flexible));					
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.terrainTrades)) {
				for (String terrain: aInfo.terrainTrades) {
					if (StringUtils.hasCharacters(terrain))
						info.addTerrainTrade(terrain);
				}
			}
			
			if (CollectionUtils.hasNonZeroElements(aInfo.forestPlotYieldChanges)) {
				// Only add this tag if there are non-zero changes
				for (Integer change: aInfo.forestPlotYieldChanges) {
					info.addForestPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasNonZeroElements(aInfo.riverPlotYieldChanges)) {
				for (Integer change: aInfo.riverPlotYieldChanges) {
					info.addRiverPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasNonZeroElements(aInfo.seaPlotYieldChanges)) {
				for (Integer change: aInfo.seaPlotYieldChanges) {
					info.addSeaPlotYieldChange(change);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.orPrereqs)) {
				for (String prereq: aInfo.orPrereqs) {
					if (StringUtils.hasCharacters(prereq))
						info.addOrPrereq(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.andPrereqs)) {
				for (String prereq: aInfo.andPrereqs) {
					if (StringUtils.hasCharacters(prereq))
						info.addAndPrereq(prereq);
				}
			}
			
			if (CollectionUtils.hasElements(aInfo.enabledWorldViews)) {
				for (String worldView: aInfo.enabledWorldViews) {
					if (StringUtils.hasCharacters(worldView))
						info.addEnabledWorldViews(worldView);
				}
			}
			
			map.put(aInfo.type, info);
		}
		return map;
	}

}
