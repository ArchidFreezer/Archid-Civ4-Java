package org.archid.civ4.info.era;

import java.util.List;

import org.archid.civ4.info.IInfo;
import org.archid.utils.IPair;

public interface IEraInfo extends IInfo {

	String getType();

	void setType(String type);

	String getDescription();

	void setDescription(String description);

	String getStrategy();

	void setStrategy(String strategy);

	String getAudioUnitVictoryScript();

	void setAudioUnitVictoryScript(String audioUnitVictoryScript);

	String getAudioUnitDefeatScript();

	void setAudioUnitDefeatScript(String audioUnitDefeatScript);

	int getAdvancedStartPoints();

	void setAdvancedStartPoints(int advancedStartPoints);

	int getStartingUnitMultiplier();

	void setStartingUnitMultiplier(int startingUnitMultiplier);

	int getStartingDefenseUnits();

	void setStartingDefenseUnits(int startingDefenseUnits);

	int getStartingWorkerUnits();

	void setStartingWorkerUnits(int startingWorkerUnits);

	int getStartingExploreUnits();

	void setStartingExploreUnits(int startingExploreUnits);

	int getStartingGold();

	void setStartingGold(int startingGold);

	int getMaxCities();

	void setMaxCities(int maxCities);

	int getFreePopulation();

	void setFreePopulation(int freePopulation);

	int getStartPercent();

	void setStartPercent(int startPercent);

	int getGrowthPercent();

	void setGrowthPercent(int growthPercent);

	int getTrainPercent();

	void setTrainPercent(int trainPercent);

	int getConstructPercent();

	void setConstructPercent(int constructPercent);

	int getCreatePercent();

	void setCreatePercent(int createPercent);

	int getResearchPercent();

	void setResearchPercent(int researchPercent);

	int getTechCostModifier();

	void setTechCostModifier(int techCostModifier);

	int getBuildPercent();

	void setBuildPercent(int buildPercent);

	int getImprovementPercent();

	void setImprovementPercent(int improvementPercent);

	int getGreatPeoplePercent();

	void setGreatPeoplePercent(int greatPeoplePercent);

	int getCulturePercent();

	void setCulturePercent(int culturePercent);

	int getAnarchyPercent();

	void setAnarchyPercent(int anarchyPercent);

	int getEventChancePerTurn();

	void setEventChancePerTurn(int eventChancePerTurn);

	int getUnitRangeChange();

	void setUnitRangeChange(int unitRangeChange);

	int getUnitRangeModifier();

	void setUnitRangeModifier(int unitRangeModifier);

	int getSoundtrackSpace();

	void setSoundtrackSpace(int soundtrackSpace);

	boolean isNoGoodies();

	void setNoGoodies(boolean noGoodies);

	boolean isNoAnimals();

	void setNoAnimals(boolean noAnimals);

	boolean isNoBarbUnits();

	void setNoBarbUnits(boolean noBarbUnits);

	boolean isNoBarbCities();

	void setNoBarbCities(boolean noBarbCities);

	boolean isUnitRangeUnbound();

	void setUnitRangeUnbound(boolean unitRangeUnbound);

	boolean isUnitTerritoryUnbound();

	void setUnitTerritoryUnbound(boolean unitTerritoryUnbound);

	boolean isFirstSoundtrackFirst();

	void setFirstSoundtrackFirst(boolean firstSoundtrackFirst);

	List<String> getEraInfoSoundtracks();
	
	void addEraInfoSoundtrack(String soundtrack);

	List<IPair<String, String>> getCitySoundscapes();

	void addCitySoundscape(IPair<String, String> citySoundscape);

}