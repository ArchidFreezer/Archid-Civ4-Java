package org.archid.civ4.info.eventtrigger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.archid.civ4.info.AbstractInfos;
import org.archid.utils.IPair;

@XmlRootElement(name="Civ4EventTriggerInfos", namespace="x-schema:CIV4EventSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class EventTriggerInfos extends AbstractInfos<IEventTriggerInfo> {

	public EventTriggerInfos() {
		super(new LinkedHashMap<String, IEventTriggerInfo>());
	}

	@XmlJavaTypeAdapter(EventTriggerMapAdapter.class)
	@XmlElement(name="EventTriggerInfos")
	public Map<String, IEventTriggerInfo> getInfoMap() {
		return infos;
	}

	public static IEventTriggerInfo createInfo(String type) {
		return new EventTriggerInfo(type);
	}
	
	@Override
	public void setInfoMap(Map<String, IEventTriggerInfo> infos) {
		this.infos = infos;
	}
	
	private static class EventTriggerInfo implements IEventTriggerInfo {

		private String civic;
		private String minDifficulty;
		private String otherPlayerHasTech;
		private String pythonCallback;
		private String pythonCanDo;
		private String pythonCanDoCity;
		private String pythonCanDoUnit;
		private String type;
		private boolean global;
		private boolean headquarters;
		private boolean holyCity;
		private boolean otherPlayerAI;
		private boolean otherPlayerHasOtherReligion;
		private boolean otherPlayerHasReligion;
		private boolean otherPlayerWar;
		private boolean ownPlot;
		private boolean pickCity;
		private boolean pickCorporation;
		private boolean pickOtherPlayerCity;
		private boolean pickPlayer;
		private boolean pickReligion;
		private boolean prereqEventPlot;
		private boolean probabilityBuildingMultiply;
		private boolean probabilityUnitMultiply;
		private boolean recurring;
		private boolean showPlot;
		private boolean singlePlayer;
		private boolean stateReligion;
		private boolean team;
		private boolean unitsOnPlot;
		private int angry;
		private int cityFoodWeight;
		private int maxOurLandmass;
		private int maxPopulation;
		private int minMapLandmass;
		private int minOurLandmass;
		private int minPopulation;
		private int minTreasury;
		private int numBuildings;
		private int numBuildingsGlobal;
		private int numCorporations;
		private int numPlotsRequired;
		private int numReligions;
		private int numUnits;
		private int numUnitsGlobal;
		private int otherPlayerShareBorders;
		private int percentGamesActive;
		private int plotType;
		private int unhealthy;
		private int unitDamagedWeight;
		private int unitDistanceWeight;
		private int unitExperienceWeight;
		private int weight;
		private List<String> andPrereqs = new ArrayList<String>();
		private List<String> bonusesRequired = new ArrayList<String>();
		private List<String> buildingsRequired = new ArrayList<String>();
		private List<String> corporationsRequired	 = new ArrayList<String>();
		private List<String> events = new ArrayList<String>();
		private List<String> featuresRequired = new ArrayList<String>();
		private List<String> improvementsRequired = new ArrayList<String>();
		private List<String> obsoleteTechs = new ArrayList<String>();
		private List<String> orPreReqs = new ArrayList<String>();
		private List<String> prereqEvents = new ArrayList<String>();
		private List<String> religionsRequired = new ArrayList<String>();
		private List<String> routesRequired = new ArrayList<String>();
		private List<String> terrainsRequired = new ArrayList<String>();
		private List<String> unitsRequired = new ArrayList<String>();
		private List<String> worldNewsTexts = new ArrayList<String>();
		private List<IPair<String, String>> triggerTexts = new ArrayList<IPair<String, String>>();

		private EventTriggerInfo(String type) {
			this.type = type;
		}

		@Override
		public String getCivic() {
			return civic;
		}

		@Override
		public void setCivic(String civic) {
			this.civic = civic;
		}

		@Override
		public String getMinDifficulty() {
			return minDifficulty;
		}

		@Override
		public void setMinDifficulty(String minDifficulty) {
			this.minDifficulty = minDifficulty;
		}

		@Override
		public String getOtherPlayerHasTech() {
			return otherPlayerHasTech;
		}

		@Override
		public void setOtherPlayerHasTech(String otherPlayerHasTech) {
			this.otherPlayerHasTech = otherPlayerHasTech;
		}

		@Override
		public String getPythonCallback() {
			return pythonCallback;
		}

		@Override
		public void setPythonCallback(String pythonCallback) {
			this.pythonCallback = pythonCallback;
		}

		@Override
		public String getPythonCanDo() {
			return pythonCanDo;
		}

		@Override
		public void setPythonCanDo(String pythonCanDo) {
			this.pythonCanDo = pythonCanDo;
		}

		@Override
		public String getPythonCanDoCity() {
			return pythonCanDoCity;
		}

		@Override
		public void setPythonCanDoCity(String pythonCanDoCity) {
			this.pythonCanDoCity = pythonCanDoCity;
		}

		@Override
		public String getPythonCanDoUnit() {
			return pythonCanDoUnit;
		}

		@Override
		public void setPythonCanDoUnit(String pythonCanDoUnit) {
			this.pythonCanDoUnit = pythonCanDoUnit;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) {
			this.type = type;
		}

		@Override
		public boolean isGlobal() {
			return global;
		}

		@Override
		public void setGlobal(boolean global) {
			this.global = global;
		}

		@Override
		public boolean isHeadquarters() {
			return headquarters;
		}

		@Override
		public void setHeadquarters(boolean headquarters) {
			this.headquarters = headquarters;
		}

		@Override
		public boolean isHolyCity() {
			return holyCity;
		}

		@Override
		public void setHolyCity(boolean holyCity) {
			this.holyCity = holyCity;
		}

		@Override
		public boolean isOtherPlayerAI() {
			return otherPlayerAI;
		}

		@Override
		public void setOtherPlayerAI(boolean otherPlayerAI) {
			this.otherPlayerAI = otherPlayerAI;
		}

		@Override
		public boolean isOtherPlayerHasOtherReligion() {
			return otherPlayerHasOtherReligion;
		}

		@Override
		public void setOtherPlayerHasOtherReligion(boolean otherPlayerHasOtherReligion) {
			this.otherPlayerHasOtherReligion = otherPlayerHasOtherReligion;
		}

		@Override
		public boolean isOtherPlayerHasReligion() {
			return otherPlayerHasReligion;
		}

		@Override
		public void setOtherPlayerHasReligion(boolean otherPlayerHasReligion) {
			this.otherPlayerHasReligion = otherPlayerHasReligion;
		}

		@Override
		public boolean isOtherPlayerWar() {
			return otherPlayerWar;
		}

		@Override
		public void setOtherPlayerWar(boolean otherPlayerWar) {
			this.otherPlayerWar = otherPlayerWar;
		}

		@Override
		public boolean isOwnPlot() {
			return ownPlot;
		}

		@Override
		public void setOwnPlot(boolean ownPlot) {
			this.ownPlot = ownPlot;
		}

		@Override
		public boolean isPickCity() {
			return pickCity;
		}

		@Override
		public void setPickCity(boolean pickCity) {
			this.pickCity = pickCity;
		}

		@Override
		public boolean isPickCorporation() {
			return pickCorporation;
		}

		@Override
		public void setPickCorporation(boolean pickCorporation) {
			this.pickCorporation = pickCorporation;
		}

		@Override
		public boolean isPickOtherPlayerCity() {
			return pickOtherPlayerCity;
		}

		@Override
		public void setPickOtherPlayerCity(boolean pickOtherPlayerCity) {
			this.pickOtherPlayerCity = pickOtherPlayerCity;
		}

		@Override
		public boolean isPickPlayer() {
			return pickPlayer;
		}

		@Override
		public void setPickPlayer(boolean pickPlayer) {
			this.pickPlayer = pickPlayer;
		}

		@Override
		public boolean isPickReligion() {
			return pickReligion;
		}

		@Override
		public void setPickReligion(boolean pickReligion) {
			this.pickReligion = pickReligion;
		}

		@Override
		public boolean isPrereqEventPlot() {
			return prereqEventPlot;
		}

		@Override
		public void setPrereqEventPlot(boolean prereqEventPlot) {
			this.prereqEventPlot = prereqEventPlot;
		}

		@Override
		public boolean isProbabilityBuildingMultiply() {
			return probabilityBuildingMultiply;
		}

		@Override
		public void setProbabilityBuildingMultiply(boolean probabilityBuildingMultiply) {
			this.probabilityBuildingMultiply = probabilityBuildingMultiply;
		}

		@Override
		public boolean isProbabilityUnitMultiply() {
			return probabilityUnitMultiply;
		}

		@Override
		public void setProbabilityUnitMultiply(boolean probabilityUnitMultiply) {
			this.probabilityUnitMultiply = probabilityUnitMultiply;
		}

		@Override
		public boolean isRecurring() {
			return recurring;
		}

		@Override
		public void setRecurring(boolean recurring) {
			this.recurring = recurring;
		}

		@Override
		public boolean isShowPlot() {
			return showPlot;
		}

		@Override
		public void setShowPlot(boolean showPlot) {
			this.showPlot = showPlot;
		}

		@Override
		public boolean isSinglePlayer() {
			return singlePlayer;
		}

		@Override
		public void setSinglePlayer(boolean singlePlayer) {
			this.singlePlayer = singlePlayer;
		}

		@Override
		public boolean isStateReligion() {
			return stateReligion;
		}

		@Override
		public void setStateReligion(boolean stateReligion) {
			this.stateReligion = stateReligion;
		}

		@Override
		public boolean isTeam() {
			return team;
		}

		@Override
		public void setTeam(boolean team) {
			this.team = team;
		}

		@Override
		public boolean isUnitsOnPlot() {
			return unitsOnPlot;
		}

		@Override
		public void setUnitsOnPlot(boolean unitsOnPlot) {
			this.unitsOnPlot = unitsOnPlot;
		}

		@Override
		public int getAngry() {
			return angry;
		}

		@Override
		public void setAngry(int angry) {
			this.angry = angry;
		}

		@Override
		public int getCityFoodWeight() {
			return cityFoodWeight;
		}

		@Override
		public void setCityFoodWeight(int cityFoodWeight) {
			this.cityFoodWeight = cityFoodWeight;
		}

		@Override
		public int getMaxOurLandmass() {
			return maxOurLandmass;
		}

		@Override
		public void setMaxOurLandmass(int maxOurLandmass) {
			this.maxOurLandmass = maxOurLandmass;
		}

		@Override
		public int getMaxPopulation() {
			return maxPopulation;
		}

		@Override
		public void setMaxPopulation(int maxPopulation) {
			this.maxPopulation = maxPopulation;
		}

		@Override
		public int getMinMapLandmass() {
			return minMapLandmass;
		}

		@Override
		public void setMinMapLandmass(int minMapLandmass) {
			this.minMapLandmass = minMapLandmass;
		}

		@Override
		public int getMinOurLandmass() {
			return minOurLandmass;
		}

		@Override
		public void setMinOurLandmass(int minOurLandmass) {
			this.minOurLandmass = minOurLandmass;
		}

		@Override
		public int getMinPopulation() {
			return minPopulation;
		}

		@Override
		public void setMinPopulation(int minPopulation) {
			this.minPopulation = minPopulation;
		}

		@Override
		public int getMinTreasury() {
			return minTreasury;
		}

		@Override
		public void setMinTreasury(int minTreasury) {
			this.minTreasury = minTreasury;
		}

		@Override
		public int getNumBuildings() {
			return numBuildings;
		}

		@Override
		public void setNumBuildings(int numBuildings) {
			this.numBuildings = numBuildings;
		}

		@Override
		public int getNumBuildingsGlobal() {
			return numBuildingsGlobal;
		}

		@Override
		public void setNumBuildingsGlobal(int numBuildingsGlobal) {
			this.numBuildingsGlobal = numBuildingsGlobal;
		}

		@Override
		public int getNumCorporations() {
			return numCorporations;
		}

		@Override
		public void setNumCorporations(int numCorporations) {
			this.numCorporations = numCorporations;
		}

		@Override
		public int getNumPlotsRequired() {
			return numPlotsRequired;
		}

		@Override
		public void setNumPlotsRequired(int numPlotsRequired) {
			this.numPlotsRequired = numPlotsRequired;
		}

		@Override
		public int getNumReligions() {
			return numReligions;
		}

		@Override
		public void setNumReligions(int numReligions) {
			this.numReligions = numReligions;
		}

		@Override
		public int getNumUnits() {
			return numUnits;
		}

		@Override
		public void setNumUnits(int numUnits) {
			this.numUnits = numUnits;
		}

		@Override
		public int getNumUnitsGlobal() {
			return numUnitsGlobal;
		}

		@Override
		public void setNumUnitsGlobal(int numUnitsGlobal) {
			this.numUnitsGlobal = numUnitsGlobal;
		}

		@Override
		public int getOtherPlayerShareBorders() {
			return otherPlayerShareBorders;
		}

		@Override
		public void setOtherPlayerShareBorders(int otherPlayerShareBorders) {
			this.otherPlayerShareBorders = otherPlayerShareBorders;
		}

		@Override
		public int getPercentGamesActive() {
			return percentGamesActive;
		}

		@Override
		public void setPercentGamesActive(int percentGamesActive) {
			this.percentGamesActive = percentGamesActive;
		}

		@Override
		public int getPlotType() {
			return plotType;
		}

		@Override
		public void setPlotType(int plotType) {
			this.plotType = plotType;
		}

		@Override
		public int getUnhealthy() {
			return unhealthy;
		}

		@Override
		public void setUnhealthy(int unhealthy) {
			this.unhealthy = unhealthy;
		}

		@Override
		public int getUnitDamagedWeight() {
			return unitDamagedWeight;
		}

		@Override
		public void setUnitDamagedWeight(int unitDamagedWeight) {
			this.unitDamagedWeight = unitDamagedWeight;
		}

		@Override
		public int getUnitDistanceWeight() {
			return unitDistanceWeight;
		}

		@Override
		public void setUnitDistanceWeight(int unitDistanceWeight) {
			this.unitDistanceWeight = unitDistanceWeight;
		}

		@Override
		public int getUnitExperienceWeight() {
			return unitExperienceWeight;
		}

		@Override
		public void setUnitExperienceWeight(int unitExperienceWeight) {
			this.unitExperienceWeight = unitExperienceWeight;
		}

		@Override
		public int getWeight() {
			return weight;
		}

		@Override
		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public List<String> getAndPrereqs() {
			return andPrereqs;
		}

		@Override
		public void addAndPrereq(String andPrereq) {
			andPrereqs.add(andPrereq);
		}

		@Override
		public List<String> getBonusesRequired() {
			return bonusesRequired;
		}

		@Override
		public void addBonusRequired(String bonusRequired) {
			bonusesRequired.add(bonusRequired);
		}

		@Override
		public List<String> getBuildingsRequired() {
			return buildingsRequired;
		}

		@Override
		public void addBuildingRequired(String buildingRequired) {
			buildingsRequired.add(buildingRequired);
		}

		@Override
		public List<String> getCorporationsRequired() {
			return corporationsRequired;
		}

		@Override
		public void addCorporationRequired(String corporationRequired) {
			corporationsRequired.add(corporationRequired);
		}

		@Override
		public List<String> getEvents() {
			return events;
		}

		@Override
		public void addEvent(String event) {
			events.add(event);
		}

		@Override
		public List<String> getFeaturesRequired() {
			return featuresRequired;
		}

		@Override
		public void addFeatureRequired(String featureRequired) {
			featuresRequired.add(featureRequired);
		}

		@Override
		public List<String> getImprovementsRequired() {
			return improvementsRequired;
		}

		@Override
		public void addImprovementRequired(String improvementRequired) {
			improvementsRequired.add(improvementRequired);
		}

		@Override
		public List<String> getObsoleteTechs() {
			return obsoleteTechs;
		}

		@Override
		public void addObsoleteTech(String obsoleteTech) {
			obsoleteTechs.add(obsoleteTech);
		}

		@Override
		public List<String> getOrPreReqs() {
			return orPreReqs;
		}

		@Override
		public void addOrPreReq(String orPreReq) {
			orPreReqs.add(orPreReq);
		}

		@Override
		public List<String> getPrereqEvents() {
			return prereqEvents;
		}

		@Override
		public void addPrereqEvent(String prereqEvent) {
			prereqEvents.add(prereqEvent);
		}

		@Override
		public List<String> getReligionsRequired() {
			return religionsRequired;
		}

		@Override
		public void addReligionRequired(String religionRequired) {
			religionsRequired.add(religionRequired);
		}

		@Override
		public List<String> getRoutesRequired() {
			return routesRequired;
		}

		@Override
		public void addRouteRequired(String routeRequired) {
			routesRequired.add(routeRequired);
		}

		@Override
		public List<String> getTerrainsRequired() {
			return terrainsRequired;
		}

		@Override
		public void addTerrainRequired(String terrainRequired) {
			terrainsRequired.add(terrainRequired);
		}

		@Override
		public List<String> getUnitsRequired() {
			return unitsRequired;
		}

		@Override
		public void addUnitRequired(String unitRequired) {
			unitsRequired.add(unitRequired);
		}

		@Override
		public List<String> getWorldNewsTexts() {
			return worldNewsTexts;
		}

		@Override
		public void addWorldNewsText(String worldNewsText) {
			worldNewsTexts.add(worldNewsText);
		}

		@Override
		public List<IPair<String, String>> getTriggerTexts() {
			return triggerTexts;
		}

		@Override
		public void addTriggerText(IPair<String, String> triggerText) {
			triggerTexts.add(triggerText);
		}
	}
}
