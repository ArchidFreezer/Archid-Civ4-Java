package org.archid.civ4.info.eventtrigger;

import java.util.List;

import org.archid.civ4.info.IInfo;
import org.archid.utils.IPair;

public interface IEventTriggerInfo extends IInfo {

	String getCivic();

	void setCivic(String civic);

	String getMinDifficulty();

	void setMinDifficulty(String minDifficulty);

	String getOtherPlayerHasTech();

	void setOtherPlayerHasTech(String otherPlayerHasTech);

	String getPythonCallback();

	void setPythonCallback(String pythonCallback);

	String getPythonCanDo();

	void setPythonCanDo(String pythonCanDo);

	String getPythonCanDoCity();

	void setPythonCanDoCity(String pythonCanDoCity);

	String getPythonCanDoUnit();

	void setPythonCanDoUnit(String pythonCanDoUnit);

	boolean isGlobal();

	void setGlobal(boolean global);

	boolean isHeadquarters();

	void setHeadquarters(boolean headquarters);

	boolean isHolyCity();

	void setHolyCity(boolean holyCity);

	boolean isOtherPlayerAI();

	void setOtherPlayerAI(boolean otherPlayerAI);

	boolean isOtherPlayerHasOtherReligion();

	void setOtherPlayerHasOtherReligion(boolean otherPlayerHasOtherReligion);

	boolean isOtherPlayerHasReligion();

	void setOtherPlayerHasReligion(boolean otherPlayerHasReligion);

	boolean isOtherPlayerWar();

	void setOtherPlayerWar(boolean otherPlayerWar);

	boolean isOwnPlot();

	void setOwnPlot(boolean ownPlot);

	boolean isPickCity();

	void setPickCity(boolean pickCity);

	boolean isPickCorporation();

	void setPickCorporation(boolean pickCorporation);

	boolean isPickOtherPlayerCity();

	void setPickOtherPlayerCity(boolean pickOtherPlayerCity);

	boolean isPickPlayer();

	void setPickPlayer(boolean pickPlayer);

	boolean isPickReligion();

	void setPickReligion(boolean pickReligion);

	boolean isPrereqEventPlot();

	void setPrereqEventPlot(boolean prereqEventPlot);

	boolean isProbabilityBuildingMultiply();

	void setProbabilityBuildingMultiply(boolean probabilityBuildingMultiply);

	boolean isProbabilityUnitMultiply();

	void setProbabilityUnitMultiply(boolean probabilityUnitMultiply);

	boolean isRecurring();

	void setRecurring(boolean recurring);

	boolean isShowPlot();

	void setShowPlot(boolean showPlot);

	boolean isSinglePlayer();

	void setSinglePlayer(boolean singlePlayer);

	boolean isStateReligion();

	void setStateReligion(boolean stateReligion);

	boolean isTeam();

	void setTeam(boolean team);

	boolean isUnitsOnPlot();

	void setUnitsOnPlot(boolean unitsOnPlot);

	int getAngry();

	void setAngry(int angry);

	int getCityFoodWeight();

	void setCityFoodWeight(int cityFoodWeight);

	int getMaxOurLandmass();

	void setMaxOurLandmass(int maxOurLandmass);

	int getMaxPopulation();

	void setMaxPopulation(int maxPopulation);

	int getMinMapLandmass();

	void setMinMapLandmass(int minMapLandmass);

	int getMinOurLandmass();

	void setMinOurLandmass(int minOurLandmass);

	int getMinPopulation();

	void setMinPopulation(int minPopulation);

	int getMinTreasury();

	void setMinTreasury(int minTreasury);

	int getNumBuildings();

	void setNumBuildings(int numBuildings);

	int getNumBuildingsGlobal();

	void setNumBuildingsGlobal(int numBuildingsGlobal);

	int getNumCorporations();

	void setNumCorporations(int numCorporations);

	int getNumPlotsRequired();

	void setNumPlotsRequired(int numPlotsRequired);

	int getNumReligions();

	void setNumReligions(int numReligions);

	int getNumUnits();

	void setNumUnits(int numUnits);

	int getNumUnitsGlobal();

	void setNumUnitsGlobal(int numUnitsGlobal);

	int getOtherPlayerShareBorders();

	void setOtherPlayerShareBorders(int otherPlayerShareBorders);

	int getPercentGamesActive();

	void setPercentGamesActive(int percentGamesActive);

	int getPlotType();

	void setPlotType(int plotType);

	int getUnhealthy();

	void setUnhealthy(int unhealthy);

	int getUnitDamagedWeight();

	void setUnitDamagedWeight(int unitDamagedWeight);

	int getUnitDistanceWeight();

	void setUnitDistanceWeight(int unitDistanceWeight);

	int getUnitExperienceWeight();

	void setUnitExperienceWeight(int unitExperienceWeight);

	int getWeight();

	void setWeight(int weight);

	List<String> getAndPrereqs();

	void addAndPrereq(String andPrereq);

	List<String> getBonusesRequired();

	void addBonusRequired(String bonusRequired);

	List<String> getBuildingsRequired();

	void addBuildingRequired(String buildingRequired);

	List<String> getCorporationsRequired();

	void addCorporationRequired(String corporationRequired);

	List<String> getEvents();

	void addEvent(String event);

	List<String> getFeaturesRequired();

	void addFeatureRequired(String featureRequired);

	List<String> getImprovementsRequired();

	void addImprovementRequired(String improvementRequired);

	List<String> getObsoleteTechs();

	void addObsoleteTech(String obsoleteTech);

	List<String> getOrPreReqs();

	void addOrPreReq(String orPreReq);

	List<String> getPrereqEvents();

	void addPrereqEvent(String prereqEvent);

	List<String> getReligionsRequired();

	void addReligionRequired(String religionRequired);

	List<String> getRoutesRequired();

	void addRouteRequired(String routeRequired);

	List<String> getTerrainsRequired();

	void addTerrainRequired(String terrainRequired);

	List<String> getUnitsRequired();

	void addUnitRequired(String unitRequired);

	List<String> getWorldNewsTexts();

	void addWorldNewsText(String worldNewsText);

	List<IPair<String, String>> getTriggerTexts();

	void addTriggerText(IPair<String, String> triggerText);

}
