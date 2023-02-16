package org.archid.civ4.info.bonus;

import java.util.List;

import org.archid.civ4.info.IInfo;

public interface IBonusInfo extends IInfo {

	String getArtDefineTag();

	void setArtDefineTag(String artDefineTag);

	String getBonusClassType();

	void setBonusClassType(String bonusClassType);

	String getCivilopedia();

	void setCivilopedia(String civilopedia);

	String getDescription();

	void setDescription(String description);

	String getHelp();

	void setHelp(String help);

	String getTechCityTrade();

	void setTechCityTrade(String techCityTrade);

	String getTechObsolete();

	void setTechObsolete(String techObsolete);

	String getTechReveal();

	void setTechReveal(String techReveal);

	int getAiTradeModifier();

	void setAiTradeModifier(int aiTradeModifier);

	int getAiObjective();

	void setAiObjective(int aiObjective);

	int getConstAppearance();

	void setConstAppearance(int constAppearance);

	int getGroupRand();

	void setGroupRand(int groupRand);

	int getGroupRange();

	void setGroupRange(int groupRange);

	int getHappiness();

	void setHappiness(int happiness);

	int getHealth();

	void setHealth(int health);

	int getMaxLatitude();

	void setMaxLatitude(int maxLatitude);

	int getMinAreaSize();

	void setMinAreaSize(int minAreaSize);

	int getMinLandPercent();

	void setMinLandPercent(int minLandPercent);

	int getMinLatitude();

	void setMinLatitude(int minLatitude);

	int getPlacementOrder();

	void setPlacementOrder(int placementOrder);

	int getPlayer();

	void setPlayer(int player);

	int getTilesPer();

	void setTilesPer(int tilesPer);

	int getUnique();

	void setUnique(int unique);

	boolean isArea();

	void setArea(boolean area);

	boolean isFlatlands();

	void setFlatlands(boolean flatlands);

	boolean isHills();

	void setHills(boolean hills);

	boolean isNoRiverSide();

	void setNoRiverSide(boolean noRiverSide);

	boolean isNormalize();

	void setNormalize(boolean normalize);

	boolean isPeaks();

	void setPeaks(boolean peaks);

	boolean isUseLSystem();

	void setUseLSystem(boolean useLSystem);

	List<String> getFeatureBooleans();

	void addFeatureBoolean(String featureBoolean);

	List<String> getFeatureTerrainBooleans();

	void addFeatureTerrainBoolean(String featureTerrainBoolean);

	List<String> getTerrainBooleans();

	void addTerrainBoolean(String terrainBoolean);

	Rands getRands();

	void setRands(Rands rands);

	List<Integer> getYieldChanges();

	void addYieldChange(Integer yieldChange);

}