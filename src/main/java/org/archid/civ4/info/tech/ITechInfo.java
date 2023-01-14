package org.archid.civ4.info.tech;

import java.util.List;
import org.archid.civ4.info.IInfo;
import org.archid.utils.IPair;

public interface ITechInfo extends IInfo {
	
	public String getDescription();

	public void setDescription(String description);

	public String getCivilopedia();

	public void setCivilopedia(String civilopedia);

	public String getHelp();

	public void setHelp(String help);

	public String getStrategy();

	public void setStrategy(String strategy);

	public String getAdvisor();

	public void setAdvisor(String advisor);

	public int getAiWeight();

	public void setAiWeight(int aiWeight);

	public int getAiTradeModifier();

	public void setAiTradeModifier(int aiTradeModifier);

	public int getCost();

	public void setCost(int cost);

	public int getAdvancedStartCost();

	public void setAdvancedStartCost(int advancedStartCost);

	public int getAdvancedStartCostIncrease();

	public void setAdvancedStartCostIncrease(int advancedStartCostIncrease);

	public String getEra();

	public void setEra(String era);

	public String getFreeCapitalBuildingClass();

	public void setFreeCapitalBuildingClass(String freeCapitalBuildingClass);

	public String getFirstFreeUnitClass();

	public void setFirstFreeUnitClass(String firstFreeUnitClass);

	public String getFreeUnitClass();

	public void setFreeUnitClass(String freeUnitClass);

	public int getFeatureProductionModifier();

	public void setFeatureProductionModifier(int featureProductionModifier);

	public int getWorkerSpeedModifier();

	public void setWorkerSpeedModifier(int workerSpeedModifier);

	public int getTradeRoutes();

	public void setTradeRoutes(int tradeRoutes);

	public int getHealth();

	public void setHealth(int health);

	public int getHappiness();

	public void setHappiness(int happiness);

	public int getFirstFreeTechs();

	public void setFirstFreeTechs(int firstFreeTechs);

	public int getAsset();

	public void setAsset(int asset);

	public int getPower();

	public void setPower(int power);

	public boolean isRepeat();

	public void setRepeat(boolean repeat);

	public boolean isTrade();

	public void setTrade(boolean trade);

	public boolean isEmbassyTrading();

	public void setEmbassyTrading(boolean embassyTrading);

	public boolean isFreeTradeAgreementTrading();

	public void setFreeTradeAgreementTrading(boolean freeTradeAgreementTrading);

	public boolean isNonAggressionTrading();

	public void setNonAggressionTrading(boolean nonAggressionTrading);

	public boolean isDisable();

	public void setDisable(boolean disable);

	public boolean isGoodyTech();

	public void setGoodyTech(boolean goodyTech);

	public boolean isExtraWaterSeeFrom();

	public void setExtraWaterSeeFrom(boolean extraWaterSeeFrom);

	public boolean isMapCentering();

	public void setMapCentering(boolean mapCentering);

	public boolean isMapVisible();

	public void setMapVisible(boolean mapVisible);

	public boolean isMapTrading();

	public void setMapTrading(boolean mapTrading);

	public boolean isTechTrading();

	public void setTechTrading(boolean techTrading);

	public boolean isGoldTrading();

	public void setGoldTrading(boolean goldTrading);

	public boolean isOpenBordersTrading();

	public void setOpenBordersTrading(boolean openBordersTrading);

	public boolean isLimitedBordersTrading();

	public void setLimitedBordersTrading(boolean limitedBordersTrading);

	public boolean isDefensivePactTrading();

	public void setDefensivePactTrading(boolean defensivePactTrading);

	public boolean isPermanentAllianceTrading();

	public void setPermanentAllianceTrading(boolean permanentAllianceTrading);

	public boolean isVassalTrading();

	public void setVassalTrading(boolean vassalTrading);

	public boolean isBridgeBuilding();

	public void setBridgeBuilding(boolean bridgeBuilding);

	public boolean isIrrigation();

	public void setIrrigation(boolean irrigation);

	public boolean isIgnoreIrrigation();

	public void setIgnoreIrrigation(boolean ignoreIrrigation);

	public boolean isWaterWork();

	public void setWaterWork(boolean waterWork);

	public boolean isCanPassPeaks();

	public void setCanPassPeaks(boolean canPassPeaks);

	public boolean isMoveFastPeaks();

	public void setMoveFastPeaks(boolean moveFastPeaks);

	public boolean isCanFoundOnPeaks();

	public void setCanFoundOnPeaks(boolean canFoundOnPeaks);

	public int getGridX();

	public void setGridX(int gridX);

	public int getGridY();

	public void setGridY(int gridY);

	public List<IPair<String, Integer>> getDomainExtraMoves();
	
	public void addDomainExtraMove(IPair<String, Integer> domainExtraMove);
	
	public List<Integer> getCommerceModifiers();
	
	public void addCommerceModifier(int change);
	
	public List<Integer> getSpecialistExtraCommerces();
	
	public void addSpecialistExtraCommerce(int change);
	
	public List<Boolean> getCommerceFlexibles();
	
	public void addCommerceFlexible(boolean flexible);
	
	public List<String> getTerrainTrades();
	
	public void addTerrainTrade(String terrain);
	
	public boolean isRiverTrade();
	
	public void setRiverTrade(boolean riverTrade);
	
	public boolean isCaptureCites();
	
	public void setCaptureCities(boolean captureCities);
	
	public boolean isUnitRangeUnbound();
	
	public void setUnitRangeUnbound(boolean unbound);
	
	public boolean isUnitTerritoryUnbound();
	
	public void setUnitTerritoryUnbound(boolean unbound);
	
	public int getUnitRangeChange();
	
	public void setUnitRangeChange(int change);
	
	public int getUnitRangeModifier();
	
	public void setUnitRangeModifier(int modifier);
	
	public int getCultureDefenceModifier();
	
	public void setCultureDefenceModifier(int modifier);
	
	public List<Integer> getForestPlotYieldChanges();
	
	public void addForestPlotYieldChange(int change);
	
	public List<Integer> getRiverPlotYieldChanges();
	
	public void addRiverPlotYieldChange(int change);

	public List<Integer> getSeaPlotYieldChanges();
	
	public void addSeaPlotYieldChange(int change);
	
	public List<IPair<String, Integer>> getWorldViewRevoltTurnChanges();
	
	public void addWorldViewRevoltTurnChange(IPair<String, Integer> worldViewRevoltTurnChange);
	
	public List<IPair<String, Integer>> getFlavors();
	
	public void addFlavor(IPair<String, Integer> flavor);
	
	public List<String> getOrPrereqs();
	
	public void addOrPrereq(String tech);
	
	public List<String> getAndPrereqs();
	
	public void addAndPrereq(String tech);
	
	public List<String> getEnabledWorldViews();
	
	public void addEnabledWorldViews(String worldView);
	
	public String getQuote();
	
	public void setQuote(String quote);
	
	public String getSound();
	
	public void setSound(String sound);
	
	public String getSoundMP();
	
	public void setSoundMP(String sound);
	
	public String getButton();
	
	public void setButton(String button);
	
	public boolean isApplyLeaderheadTraits();
	
	public void setApplyLeaderheadTraits(boolean applyTraits);
	
}