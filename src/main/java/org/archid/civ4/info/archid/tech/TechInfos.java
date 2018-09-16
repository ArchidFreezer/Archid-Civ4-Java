package org.archid.civ4.info.archid.tech;

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
import org.archid.utils.StringUtils;

@XmlRootElement(name="Civ4TechInfos", namespace="x-schema:CIV4TechnologiesSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class TechInfos extends AbstractInfos<ITechInfo> {
	
	public TechInfos() {
		super(new TreeMap<String, ITechInfo>());
	}
	
	/** All know techs */
	@XmlJavaTypeAdapter(TechMapAdapter.class)
	@XmlElement(name="TechInfos")
	public Map<String, ITechInfo> getInfoMap() {
		return infos;
	}

	@Override
	public void setInfoMap(Map<String, ITechInfo> infos) {
		this.infos = infos;
	}
	
	public static ITechInfo createInfo(String type) {
		return new TechInfo(type);
	}

	private static class TechInfo implements ITechInfo {
		private String type = "";
		private String description = "";
		private String civilopedia;
		private String help;
		private String strategy;
		private String advisor = "NO_ADVISOR";
		private String era = "NO_ERA";
		private String firstFreeUnitClass;
		private String freeUnitClass;
		private String quote;
		private String sound;
		private String soundMp;
		private String button;
		private int aiWeight;
		private int aiTradeModifier;
		private int cost = 0;
		private int advancedStartCost = 100;
		private int advancedStartCostIncrease;
		private int featureProductionModifier;
		private int workerSpeedModifier;
		private int tradeRoutes;
		private int health;
		private int happiness;
		private int firstFreeTechs;
		private int asset = 0;
		private int power;
		private int gridX = 1;
		private int gridY = 1;
		private int unitRangeChange;
		private int unitRangePercentChange;
		private int cultureDefenceModifier;
		private boolean repeat;
		private boolean trade;
		private boolean embassyTrading;
		private boolean freeTradeAgreementTrading;
		private boolean nonAggressionTrading;
		private boolean disable;
		private boolean goodyTech;
		private boolean extraWaterSeeFrom;
		private boolean mapCentering;
		private boolean mapVisible;
		private boolean mapTrading;
		private boolean techTrading;
		private boolean goldTrading;
		private boolean openBordersTrading;
		private boolean limitedBordersTrading;
		private boolean defensivePactTrading;
		private boolean permanentAllianceTrading;
		private boolean vassalTrading;
		private boolean bridgeBuilding;
		private boolean irrigation;
		private boolean ignoreIrrigation;
		private boolean waterWork;
		private boolean canPassPeaks;
		private boolean moveFastPeaks;
		private boolean canFoundOnPeaks;
		private boolean riverTrade;
		private boolean captureCities;
		private boolean unitRangeUnbound;
		private boolean unitTerritoryUnbound;
		private List<IPair<String, Integer>> domainExtraMoves = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> worldViewRevoltTurnChanges = new ArrayList<IPair<String, Integer>>();
		private List<IPair<String, Integer>> flavors = new ArrayList<IPair<String, Integer>>();
		private List<Boolean> commerceFlexibles = new ArrayList<Boolean>();
		private List<Integer> forestPlotYieldChanges = new ArrayList<Integer>();
		private List<Integer> riverPlotYieldChanges = new ArrayList<Integer>();
		private List<Integer> seaPlotYieldChanges = new ArrayList<Integer>();
		private List<String> terrainTrades = new ArrayList<String>();
		private List<String> orPrereqs = new ArrayList<String>();
		private List<String> andPrereqs = new ArrayList<String>();
		private List<String> enabledWorldViews = new ArrayList<String>();
		
		private TechInfo(String type) {
			this.type = type;
			description = "TXT_KEY_" + type;
			civilopedia = "TXT_KEY_" + type + "_PEDIA";
			help = "TXT_KEY_" + type + "_HELP";
			strategy = "TXT_KEY_" + type + "_STRATEGY";
			quote = "TXT_KEY_" + type + "_QUOTE";
			sound = "AS2D_TECH_" + StringUtils.startCaseCompress(type.substring(type.indexOf('_') + 1), '_');
			soundMp = sound;
			button = "Art/Interface/Buttons/TechTree/" + type.substring(type.indexOf('_') + 1).toLowerCase() + ".dds";
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getCivilopedia()
		 */
		@Override
		public String getCivilopedia() {
			return civilopedia;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setCivilopedia(java.lang.String)
		 */
		@Override
		public void setCivilopedia(String civilopedia) {
			this.civilopedia = civilopedia;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getHelp()
		 */
		@Override
		public String getHelp() {
			return help;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setHelp(java.lang.String)
		 */
		@Override
		public void setHelp(String help) {
			this.help = help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAdvisor()
		 */
		@Override
		public String getAdvisor() {
			return advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAdvisor(java.lang.String)
		 */
		@Override
		public void setAdvisor(String advisor) {
			this.advisor = advisor;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAiWeight()
		 */
		@Override
		public int getAiWeight() {
			return aiWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAiWeight(java.lang.Integer)
		 */
		@Override
		public void setAiWeight(int aiWeight) {
			this.aiWeight = aiWeight;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAiTradeModifier()
		 */
		@Override
		public int getAiTradeModifier() {
			return aiTradeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAiTradeModifier(java.lang.Integer)
		 */
		@Override
		public void setAiTradeModifier(int aiTradeModifier) {
			this.aiTradeModifier = aiTradeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getCost()
		 */
		@Override
		public int getCost() {
			return cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setCost(java.lang.Integer)
		 */
		@Override
		public void setCost(int cost) {
			this.cost = cost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAdvancedStartCost()
		 */
		@Override
		public int getAdvancedStartCost() {
			return advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAdvancedStartCost(java.lang.Integer)
		 */
		@Override
		public void setAdvancedStartCost(int advancedStartCost) {
			this.advancedStartCost = advancedStartCost;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAdvancedStartCostIncrease()
		 */
		@Override
		public int getAdvancedStartCostIncrease() {
			return advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAdvancedStartCostIncrease(java.lang.Integer)
		 */
		@Override
		public void setAdvancedStartCostIncrease(int advancedStartCostIncrease) {
			this.advancedStartCostIncrease = advancedStartCostIncrease;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getEra()
		 */
		@Override
		public String getEra() {
			return era;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setEra(java.lang.String)
		 */
		@Override
		public void setEra(String era) {
			this.era = era;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getFirstFreeUnitClass()
		 */
		@Override
		public String getFirstFreeUnitClass() {
			return firstFreeUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setFirstFreeUnitClass(java.lang.String)
		 */
		@Override
		public void setFirstFreeUnitClass(String firstFreeUnitClass) {
			this.firstFreeUnitClass = firstFreeUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getFreeUnitClass()
		 */
		@Override
		public String getFreeUnitClass() {
			return freeUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setFreeUnitClass(java.lang.String)
		 */
		@Override
		public void setFreeUnitClass(String freeUnitClass) {
			this.freeUnitClass = freeUnitClass;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getFeatureProductionModifier()
		 */
		@Override
		public int getFeatureProductionModifier() {
			return featureProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setFeatureProductionModifier(java.lang.Integer)
		 */
		@Override
		public void setFeatureProductionModifier(int featureProductionModifier) {
			this.featureProductionModifier = featureProductionModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getWorkerSpeedModifier()
		 */
		@Override
		public int getWorkerSpeedModifier() {
			return workerSpeedModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setWorkerSpeedModifier(java.lang.Integer)
		 */
		@Override
		public void setWorkerSpeedModifier(int workerSpeedModifier) {
			this.workerSpeedModifier = workerSpeedModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getTradeRoutes()
		 */
		@Override
		public int getTradeRoutes() {
			return tradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setTradeRoutes(java.lang.Integer)
		 */
		@Override
		public void setTradeRoutes(int tradeRoutes) {
			this.tradeRoutes = tradeRoutes;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getHealth()
		 */
		@Override
		public int getHealth() {
			return health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setHealth(java.lang.Integer)
		 */
		@Override
		public void setHealth(int health) {
			this.health = health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getHappiness()
		 */
		@Override
		public int getHappiness() {
			return happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setHappiness(java.lang.Integer)
		 */
		@Override
		public void setHappiness(int happiness) {
			this.happiness = happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getFirstFreeTechs()
		 */
		@Override
		public int getFirstFreeTechs() {
			return firstFreeTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setFirstFreeTechs(java.lang.Integer)
		 */
		@Override
		public void setFirstFreeTechs(int firstFreeTechs) {
			this.firstFreeTechs = firstFreeTechs;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getAsset()
		 */
		@Override
		public int getAsset() {
			return asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setAsset(java.lang.Integer)
		 */
		@Override
		public void setAsset(int asset) {
			this.asset = asset;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getPower()
		 */
		@Override
		public int getPower() {
			return power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setPower(java.lang.Integer)
		 */
		@Override
		public void setPower(int power) {
			this.power = power;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getRepeat()
		 */
		@Override
		public boolean isRepeat() {
			return repeat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setRepeat(java.lang.Boolean)
		 */
		@Override
		public void setRepeat(boolean repeat) {
			this.repeat = repeat;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getTrade()
		 */
		@Override
		public boolean isTrade() {
			return trade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setTrade(java.lang.Boolean)
		 */
		@Override
		public void setTrade(boolean trade) {
			this.trade = trade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getEmbassyTrading()
		 */
		@Override
		public boolean isEmbassyTrading() {
			return embassyTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setEmbassyTrading(java.lang.Boolean)
		 */
		@Override
		public void setEmbassyTrading(boolean embassyTrading) {
			this.embassyTrading = embassyTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getFreeTradeAgreementTrading()
		 */
		@Override
		public boolean isFreeTradeAgreementTrading() {
			return freeTradeAgreementTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setFreeTradeAgreementTrading(java.lang.Boolean)
		 */
		@Override
		public void setFreeTradeAgreementTrading(boolean freeTradeAgreementTrading) {
			this.freeTradeAgreementTrading = freeTradeAgreementTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getNonAggressionTrading()
		 */
		@Override
		public boolean isNonAggressionTrading() {
			return nonAggressionTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setNonAggressionTrading(java.lang.Boolean)
		 */
		@Override
		public void setNonAggressionTrading(boolean nonAggressionTrading) {
			this.nonAggressionTrading = nonAggressionTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getDisable()
		 */
		@Override
		public boolean isDisable() {
			return disable;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setDisable(java.lang.Boolean)
		 */
		@Override
		public void setDisable(boolean disable) {
			this.disable = disable;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getGoodyTech()
		 */
		@Override
		public boolean isGoodyTech() {
			return goodyTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setGoodyTech(java.lang.Boolean)
		 */
		@Override
		public void setGoodyTech(boolean goodyTech) {
			this.goodyTech = goodyTech;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getExtraWaterSeeFrom()
		 */
		@Override
		public boolean isExtraWaterSeeFrom() {
			return extraWaterSeeFrom;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setExtraWaterSeeFrom(java.lang.Boolean)
		 */
		@Override
		public void setExtraWaterSeeFrom(boolean extraWaterSeeFrom) {
			this.extraWaterSeeFrom = extraWaterSeeFrom;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getMapCentering()
		 */
		@Override
		public boolean isMapCentering() {
			return mapCentering;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setMapCentering(java.lang.Boolean)
		 */
		@Override
		public void setMapCentering(boolean mapCentering) {
			this.mapCentering = mapCentering;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getMapVisible()
		 */
		@Override
		public boolean isMapVisible() {
			return mapVisible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setMapVisible(java.lang.Boolean)
		 */
		@Override
		public void setMapVisible(boolean mapVisible) {
			this.mapVisible = mapVisible;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getMapTrading()
		 */
		@Override
		public boolean isMapTrading() {
			return mapTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setMapTrading(java.lang.Boolean)
		 */
		@Override
		public void setMapTrading(boolean mapTrading) {
			this.mapTrading = mapTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getTechTrading()
		 */
		@Override
		public boolean isTechTrading() {
			return techTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setTechTrading(java.lang.Boolean)
		 */
		@Override
		public void setTechTrading(boolean techTrading) {
			this.techTrading = techTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getGoldTrading()
		 */
		@Override
		public boolean isGoldTrading() {
			return goldTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setGoldTrading(java.lang.Boolean)
		 */
		@Override
		public void setGoldTrading(boolean goldTrading) {
			this.goldTrading = goldTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getOpenBordersTrading()
		 */
		@Override
		public boolean isOpenBordersTrading() {
			return openBordersTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setOpenBordersTrading(java.lang.Boolean)
		 */
		@Override
		public void setOpenBordersTrading(boolean openBordersTrading) {
			this.openBordersTrading = openBordersTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getLimitedBordersTrading()
		 */
		@Override
		public boolean isLimitedBordersTrading() {
			return limitedBordersTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setLimitedBordersTrading(java.lang.Boolean)
		 */
		@Override
		public void setLimitedBordersTrading(boolean limitedBordersTrading) {
			this.limitedBordersTrading = limitedBordersTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getDefensivePactTrading()
		 */
		@Override
		public boolean isDefensivePactTrading() {
			return defensivePactTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setDefensivePactTrading(java.lang.Boolean)
		 */
		@Override
		public void setDefensivePactTrading(boolean defensivePactTrading) {
			this.defensivePactTrading = defensivePactTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getPermanentAllianceTrading()
		 */
		@Override
		public boolean isPermanentAllianceTrading() {
			return permanentAllianceTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setPermanentAllianceTrading(java.lang.Boolean)
		 */
		@Override
		public void setPermanentAllianceTrading(boolean permanentAllianceTrading) {
			this.permanentAllianceTrading = permanentAllianceTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getVassalTrading()
		 */
		@Override
		public boolean isVassalTrading() {
			return vassalTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setVassalTrading(java.lang.Boolean)
		 */
		@Override
		public void setVassalTrading(boolean vassalTrading) {
			this.vassalTrading = vassalTrading;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getBridgeBuilding()
		 */
		@Override
		public boolean isBridgeBuilding() {
			return bridgeBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setBridgeBuilding(java.lang.Boolean)
		 */
		@Override
		public void setBridgeBuilding(boolean bridgeBuilding) {
			this.bridgeBuilding = bridgeBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getIrrigation()
		 */
		@Override
		public boolean isIrrigation() {
			return irrigation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setIrrigation(java.lang.Boolean)
		 */
		@Override
		public void setIrrigation(boolean irrigation) {
			this.irrigation = irrigation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getIgnoreIrrigation()
		 */
		@Override
		public boolean isIgnoreIrrigation() {
			return ignoreIrrigation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setIgnoreIrrigation(java.lang.Boolean)
		 */
		@Override
		public void setIgnoreIrrigation(boolean ignoreIrrigation) {
			this.ignoreIrrigation = ignoreIrrigation;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getWaterWork()
		 */
		@Override
		public boolean isWaterWork() {
			return waterWork;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setWaterWork(java.lang.Boolean)
		 */
		@Override
		public void setWaterWork(boolean waterWork) {
			this.waterWork = waterWork;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getCanPassPeaks()
		 */
		@Override
		public boolean isCanPassPeaks() {
			return canPassPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setCanPassPeaks(java.lang.Boolean)
		 */
		@Override
		public void setCanPassPeaks(boolean canPassPeaks) {
			this.canPassPeaks = canPassPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getMoveFastPeaks()
		 */
		@Override
		public boolean isMoveFastPeaks() {
			return moveFastPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setMoveFastPeaks(java.lang.Boolean)
		 */
		@Override
		public void setMoveFastPeaks(boolean moveFastPeaks) {
			this.moveFastPeaks = moveFastPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getCanFoundOnPeaks()
		 */
		@Override
		public boolean isCanFoundOnPeaks() {
			return canFoundOnPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setCanFoundOnPeaks(java.lang.Boolean)
		 */
		@Override
		public void setCanFoundOnPeaks(boolean canFoundOnPeaks) {
			this.canFoundOnPeaks = canFoundOnPeaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getGridX()
		 */
		@Override
		public int getGridX() {
			return gridX;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setGridX(java.lang.Integer)
		 */
		@Override
		public void setGridX(int gridX) {
			this.gridX = gridX;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getGridY()
		 */
		@Override
		public int getGridY() {
			return gridY;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setGridY(java.lang.Integer)
		 */
		@Override
		public void setGridY(int gridY) {
			this.gridY = gridY;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getDomainExtraMoves()
		 */
		@Override
		public List<IPair<String, Integer>> getDomainExtraMoves() {
			return new ArrayList<IPair<String, Integer>>(domainExtraMoves);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#setDomainExtraMoves(java.util.List)
		 */
		@Override
		public void addDomainExtraMove(IPair<String, Integer> domainExtraMove) {
			this.domainExtraMoves.add(domainExtraMove);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getCommerceFlexibles()
		 */
		@Override
		public List<Boolean> getCommerceFlexibles() {
			return new ArrayList<Boolean>(commerceFlexibles);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#addCommerceFlexible(boolean)
		 */
		@Override
		public void addCommerceFlexible(boolean flexible) {
			this.commerceFlexibles.add(flexible);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#getTerrainTrades()
		 */
		@Override
		public List<String> getTerrainTrades() {
			return new ArrayList<String>(terrainTrades);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.xml.techinfo.ITechInfo#addTerrainTrade(java.lang.String)
		 */
		@Override
		public void addTerrainTrade(String terrain) {
			terrainTrades.add(terrain);
		}

		@Override
		public boolean isRiverTrade() {
			return riverTrade;
		}

		@Override
		public void setRiverTrade(boolean riverTrade) {
			this.riverTrade = riverTrade;
		}

		@Override
		public boolean isCaptureCites() {
			return captureCities;
		}

		@Override
		public void setCaptureCities(boolean captureCities) {
			this.captureCities = captureCities;
		}

		@Override
		public boolean isUnitRangeUnbound() {
			return unitRangeUnbound;
		}

		@Override
		public void setUnitRangeUnbound(boolean unbound) {
			unitRangeUnbound = unbound;
		}

		@Override
		public boolean isUnitTerritoryUnbound() {
			return unitTerritoryUnbound;
		}

		@Override
		public void setUnitTerritoryUnbound(boolean unbound) {
			unitTerritoryUnbound = unbound;
		}

		@Override
		public int getUnitRangeChange() {
			return unitRangeChange;
		}

		@Override
		public void setUnitRangeChange(int change) {
			unitRangeChange = change;
		}

		@Override
		public int getUnitRangeModifier() {
			return unitRangePercentChange;
		}

		@Override
		public void setUnitRangeModifier(int modifier) {
			unitRangePercentChange = modifier;
		}

		@Override
		public int getCultureDefenceModifier() {
			return cultureDefenceModifier;
		}

		@Override
		public void setCultureDefenceModifier(int modifier) {
			cultureDefenceModifier = modifier;
		}

		@Override
		public List<Integer> getForestPlotYieldChanges() {
			return new ArrayList<Integer>(forestPlotYieldChanges);
		}

		@Override
		public void addForestPlotYieldChange(int change) {
			forestPlotYieldChanges.add(change);
		}
		
		@Override
		public List<Integer> getRiverPlotYieldChanges() {
			return new ArrayList<Integer>(riverPlotYieldChanges);
		}

		@Override
		public void addRiverPlotYieldChange(int change) {
			riverPlotYieldChanges.add(change);
		}
		
		@Override
		public List<Integer> getSeaPlotYieldChanges() {
			return new ArrayList<Integer>(seaPlotYieldChanges);
		}

		@Override
		public void addSeaPlotYieldChange(int change) {
			seaPlotYieldChanges.add(change);
		}

		@Override
		public List<IPair<String, Integer>> getWorldViewRevoltTurnChanges() {
			return new ArrayList<IPair<String, Integer>>(worldViewRevoltTurnChanges);
		}

		@Override
		public void addWorldViewRevoltTurnChange(IPair<String, Integer> worldViewRevoltTurnChange) {
			worldViewRevoltTurnChanges.add(worldViewRevoltTurnChange);
		}
		
		@Override
		public List<IPair<String, Integer>> getFlavors() {
			return new ArrayList<IPair<String, Integer>>(flavors);
		}

		@Override
		public void addFlavor(IPair<String, Integer> flavor) {
			flavors.add(flavor);
		}

		@Override
		public List<String> getOrPrereqs() {
			return new ArrayList<String>(orPrereqs);
		}

		@Override
		public void addOrPrereq(String tech) {
			orPrereqs.add(tech);
		}

		@Override
		public List<String> getAndPrereqs() {
			return new ArrayList<String>(andPrereqs);
		}

		@Override
		public void addAndPrereq(String tech) {
			andPrereqs.add(tech);
		}

		@Override
		public List<String> getEnabledWorldViews() {
			return new ArrayList<String>(enabledWorldViews);
		}

		@Override
		public void addEnabledWorldViews(String worldView) {
			enabledWorldViews.add(worldView);
		}

		@Override
		public String getQuote() {
			return quote;
		}

		@Override
		public void setQuote(String quote) {
			this.quote = quote;
		}

		@Override
		public String getSound() {
			return sound;
		}

		@Override
		public void setSound(String sound) {
			this.sound = sound;
		}

		@Override
		public String getSoundMP() {
			return soundMp;
		}

		@Override
		public void setSoundMP(String sound) {
			soundMp = sound;
		}

		@Override
		public String getButton() {
			return button;
		}

		@Override
		public void setButton(String button) {
			this.button = button;
		}

		@Override
		public String getStrategy() {
			return strategy;
		}

		@Override
		public void setStrategy(String strategy) {
			this.strategy = strategy;
		}

	}
}
