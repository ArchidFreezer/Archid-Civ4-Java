package org.archid.civ4.info.archid.era;

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

@XmlRootElement(name="Civ4EraInfos", namespace="x-schema:CIV4GameInfoSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class EraInfos extends AbstractInfos<IEraInfo > {
	
	public EraInfos() {
		super(new LinkedHashMap<String, IEraInfo>());
	}
	
	@XmlJavaTypeAdapter(EraMapAdapter.class)
	@XmlElement(name="EraInfos")
	public Map<String, IEraInfo> getInfoMap() {
		return infos;
	}
	
	@Override
	public void setInfoMap(Map<String, IEraInfo> infos) {
		this.infos = infos;
	}
	
	public static IEraInfo createInfo(String type) {
		return new EraInfo(type);
	}
	
	private static class EraInfo implements IEraInfo {
		private String type;
		private String description;
		private String strategy;
		private String audioUnitVictoryScript;
		private String audioUnitDefeatScript;
		private int advancedStartPoints;
		private int startingUnitMUltiplier;
		private int startingDefenseUnits;
		private int startingWorkerUnits;
		private int startingExplorerUnits;
		private int startingGold;
		private int maxCities;
		private int freePopulation;
		private int startPercent;
		private int growthPercent;
		private int trainPercent;
		private int constructPercent;
		private int createPercent;
		private int researchPercent;
		private int techCostModifier;
		private int buildModifier;
		private int improvementPercent;
		private int greatPeoplePercent;
		private int culturePercent;
		private int anarchyPercent;
		private int eventChancePerTurn;
		private int unitRangeChange;
		private int unitRangePercentChange;
		private int soundtrackSpace;
		private boolean noGoodies;
		private boolean noAnimals;
		private boolean noBarbUnits;
		private boolean noBarbCities;
		private boolean unitRangeUnbound;
		private boolean unitTerritoryUnbound;
		private boolean firstSoundtrackFirst;
		List<String> eraInfoSoundtracks = new ArrayList<String>();
		List<IPair<String, String>> citySoundscapes = new ArrayList<IPair<String, String>>();
		
		private EraInfo(String type) {
			this.type = type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStrategy()
		 */
		@Override
		public String getStrategy() {
			return strategy;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStrategy(java.lang.String)
		 */
		@Override
		public void setStrategy(String strategy) {
			this.strategy = strategy;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getAudioUnitVictoryScript()
		 */
		@Override
		public String getAudioUnitVictoryScript() {
			return audioUnitVictoryScript;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setAudioUnitVictoryScript(java.lang.String)
		 */
		@Override
		public void setAudioUnitVictoryScript(String audioUnitVictoryScript) {
			this.audioUnitVictoryScript = audioUnitVictoryScript;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getAudioUnitDefeatScript()
		 */
		@Override
		public String getAudioUnitDefeatScript() {
			return audioUnitDefeatScript;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setAudioUnitDefeatScript(java.lang.String)
		 */
		@Override
		public void setAudioUnitDefeatScript(String audioUnitDefeatScript) {
			this.audioUnitDefeatScript = audioUnitDefeatScript;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getAdvancedStartPoints()
		 */
		@Override
		public int getAdvancedStartPoints() {
			return advancedStartPoints;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setAdvancedStartPoints(int)
		 */
		@Override
		public void setAdvancedStartPoints(int advancedStartPoints) {
			this.advancedStartPoints = advancedStartPoints;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartingUnitMUltiplier()
		 */
		@Override
		public int getStartingUnitMultiplier() {
			return startingUnitMUltiplier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartingUnitMUltiplier(int)
		 */
		@Override
		public void setStartingUnitMultiplier(int startingUnitMUltiplier) {
			this.startingUnitMUltiplier = startingUnitMUltiplier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartingDefenseUnits()
		 */
		@Override
		public int getStartingDefenseUnits() {
			return startingDefenseUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartingDefenseUnits(int)
		 */
		@Override
		public void setStartingDefenseUnits(int startingDefenseUnits) {
			this.startingDefenseUnits = startingDefenseUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartingWorkerUnits()
		 */
		@Override
		public int getStartingWorkerUnits() {
			return startingWorkerUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartingWorkerUnits(int)
		 */
		@Override
		public void setStartingWorkerUnits(int startingWorkerUnits) {
			this.startingWorkerUnits = startingWorkerUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartingExplorerUnits()
		 */
		@Override
		public int getStartingExploreUnits() {
			return startingExplorerUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartingExplorerUnits(int)
		 */
		@Override
		public void setStartingExploreUnits(int startingExplorerUnits) {
			this.startingExplorerUnits = startingExplorerUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartingGold()
		 */
		@Override
		public int getStartingGold() {
			return startingGold;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartingGold(int)
		 */
		@Override
		public void setStartingGold(int startingGold) {
			this.startingGold = startingGold;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getMaxCities()
		 */
		@Override
		public int getMaxCities() {
			return maxCities;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setMaxCities(int)
		 */
		@Override
		public void setMaxCities(int maxCities) {
			this.maxCities = maxCities;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getFreePopulation()
		 */
		@Override
		public int getFreePopulation() {
			return freePopulation;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setFreePopulation(int)
		 */
		@Override
		public void setFreePopulation(int freePopulation) {
			this.freePopulation = freePopulation;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getStartPercent()
		 */
		@Override
		public int getStartPercent() {
			return startPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setStartPercent(int)
		 */
		@Override
		public void setStartPercent(int startPercent) {
			this.startPercent = startPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getGrowthPercent()
		 */
		@Override
		public int getGrowthPercent() {
			return growthPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setGrowthPercent(int)
		 */
		@Override
		public void setGrowthPercent(int growthPercent) {
			this.growthPercent = growthPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getTrainPercent()
		 */
		@Override
		public int getTrainPercent() {
			return trainPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setTrainPercent(int)
		 */
		@Override
		public void setTrainPercent(int trainPercent) {
			this.trainPercent = trainPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getConstructPercent()
		 */
		@Override
		public int getConstructPercent() {
			return constructPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setConstructPercent(int)
		 */
		@Override
		public void setConstructPercent(int constructPercent) {
			this.constructPercent = constructPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getCreatePercent()
		 */
		@Override
		public int getCreatePercent() {
			return createPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setCreatePercent(int)
		 */
		@Override
		public void setCreatePercent(int createPercent) {
			this.createPercent = createPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getResearchPercent()
		 */
		@Override
		public int getResearchPercent() {
			return researchPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setResearchPercent(int)
		 */
		@Override
		public void setResearchPercent(int researchPercent) {
			this.researchPercent = researchPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getTechCostModifier()
		 */
		@Override
		public int getTechCostModifier() {
			return techCostModifier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setTechCostModifier(int)
		 */
		@Override
		public void setTechCostModifier(int techCostModifier) {
			this.techCostModifier = techCostModifier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getBuildModifier()
		 */
		@Override
		public int getBuildPercent() {
			return buildModifier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setBuildModifier(int)
		 */
		@Override
		public void setBuildPercent(int buildModifier) {
			this.buildModifier = buildModifier;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getImprovementPercent()
		 */
		@Override
		public int getImprovementPercent() {
			return improvementPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setImprovementPercent(int)
		 */
		@Override
		public void setImprovementPercent(int improvementPercent) {
			this.improvementPercent = improvementPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getGreatPeoplePercent()
		 */
		@Override
		public int getGreatPeoplePercent() {
			return greatPeoplePercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setGreatPeoplePercent(int)
		 */
		@Override
		public void setGreatPeoplePercent(int greatPeoplePercent) {
			this.greatPeoplePercent = greatPeoplePercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getCulturePercent()
		 */
		@Override
		public int getCulturePercent() {
			return culturePercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setCulturePercent(int)
		 */
		@Override
		public void setCulturePercent(int culturePercent) {
			this.culturePercent = culturePercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getAnarchyPercent()
		 */
		@Override
		public int getAnarchyPercent() {
			return anarchyPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setAnarchyPercent(int)
		 */
		@Override
		public void setAnarchyPercent(int anarchyPercent) {
			this.anarchyPercent = anarchyPercent;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getEventChancePerTurn()
		 */
		@Override
		public int getEventChancePerTurn() {
			return eventChancePerTurn;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setEventChancePerTurn(int)
		 */
		@Override
		public void setEventChancePerTurn(int eventChancePerTurn) {
			this.eventChancePerTurn = eventChancePerTurn;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getUnitRangeChange()
		 */
		@Override
		public int getUnitRangeChange() {
			return unitRangeChange;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setUnitRangeChange(int)
		 */
		@Override
		public void setUnitRangeChange(int unitRangeChange) {
			this.unitRangeChange = unitRangeChange;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getUnitRangePercentChange()
		 */
		@Override
		public int getUnitRangeModifier() {
			return unitRangePercentChange;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setUnitRangePercentChange(int)
		 */
		@Override
		public void setUnitRangeModifier(int unitRangePercentChange) {
			this.unitRangePercentChange = unitRangePercentChange;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getSoundtrackSpace()
		 */
		@Override
		public int getSoundtrackSpace() {
			return soundtrackSpace;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setSoundtrackSpace(int)
		 */
		@Override
		public void setSoundtrackSpace(int soundtrackSpace) {
			this.soundtrackSpace = soundtrackSpace;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isNoGoodies()
		 */
		@Override
		public boolean isNoGoodies() {
			return noGoodies;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setNoGoodies(boolean)
		 */
		@Override
		public void setNoGoodies(boolean noGoodies) {
			this.noGoodies = noGoodies;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isNoAnimals()
		 */
		@Override
		public boolean isNoAnimals() {
			return noAnimals;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setNoAnimals(boolean)
		 */
		@Override
		public void setNoAnimals(boolean noAnimals) {
			this.noAnimals = noAnimals;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isNoBarbUnits()
		 */
		@Override
		public boolean isNoBarbUnits() {
			return noBarbUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setNoBarbUnits(boolean)
		 */
		@Override
		public void setNoBarbUnits(boolean noBarbUnits) {
			this.noBarbUnits = noBarbUnits;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isNoBarbCities()
		 */
		@Override
		public boolean isNoBarbCities() {
			return noBarbCities;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setNoBarbCities(boolean)
		 */
		@Override
		public void setNoBarbCities(boolean noBarbCities) {
			this.noBarbCities = noBarbCities;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isUnitRangeUnbound()
		 */
		@Override
		public boolean isUnitRangeUnbound() {
			return unitRangeUnbound;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setUnitRangeUnbound(boolean)
		 */
		@Override
		public void setUnitRangeUnbound(boolean unitRangeUnbound) {
			this.unitRangeUnbound = unitRangeUnbound;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isUnitTerritoryUnbound()
		 */
		@Override
		public boolean isUnitTerritoryUnbound() {
			return unitTerritoryUnbound;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setUnitTerritoryUnbound(boolean)
		 */
		@Override
		public void setUnitTerritoryUnbound(boolean unitTerritoryUnbound) {
			this.unitTerritoryUnbound = unitTerritoryUnbound;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#isFirstSoundtrackFirst()
		 */
		@Override
		public boolean isFirstSoundtrackFirst() {
			return firstSoundtrackFirst;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setFirstSoundtrackFirst(boolean)
		 */
		@Override
		public void setFirstSoundtrackFirst(boolean firstSoundtrackFirst) {
			this.firstSoundtrackFirst = firstSoundtrackFirst;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getEraInfoSoundtracks()
		 */
		@Override
		public List<String> getEraInfoSoundtracks() {
			return eraInfoSoundtracks;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#addEraInfoSoundtrack(java.lang.String)
		 */
		@Override
		public void addEraInfoSoundtrack(String eraInfoSoundtrack) {
			this.eraInfoSoundtracks.add(eraInfoSoundtrack);
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getCitySoundscapes()
		 */
		@Override
		public List<IPair<String, String>> getCitySoundscapes() {
			return citySoundscapes;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#addCitySoundscape(org.archid.civ4.utils.IKeyValuePair)
		 */
		@Override
		public void addCitySoundscape(IPair<String, String> citySoundscape) {
			this.citySoundscapes.add(citySoundscape);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.era.IEraInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}
	}

}
