package org.archid.civ4.info.buildingclass;

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

@XmlRootElement(name="Civ4BuildingClassInfos", namespace="x-schema:CIV4BuildingsSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class BuildingClassInfos extends AbstractInfos<IBuildingClassInfo>{
	
	public BuildingClassInfos() {
		super(new LinkedHashMap<String, IBuildingClassInfo>());
	}
	
	@XmlJavaTypeAdapter(BuildingClassMapAdapter.class)
	@XmlElement(name="BuildingClassInfos")
	@Override
	public Map<String, IBuildingClassInfo> getInfoMap() {
		return infos;
	}

	public static IBuildingClassInfo createInfo(String type) {
		return new BuildingClassInfo(type);
	}
	
	@Override
	public void setInfoMap(Map<String, IBuildingClassInfo> infos) {
		this.infos = infos;
	}
	
	private static class BuildingClassInfo implements IBuildingClassInfo {
		private String description;
		private String defaultBuilding;
		private String type;
		private int category;
		private int extraPlayerInstances;
		private int maxGlobalInstances;
		private int maxPlayerInstances;
		private int maxTeamInstances;
		private boolean monument;
		private boolean noLimit;
		private List<IPair<String, Integer>> victoryThresholds = new ArrayList<IPair<String, Integer>>();
		
		private BuildingClassInfo(String type) {
			this.type = type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}
		
		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getDefaultBuilding()
		 */
		@Override
		public String getDefaultBuilding() {
			return defaultBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setDefaultBuilding(java.lang.String)
		 */
		@Override
		public void setDefaultBuilding(String defaultBuilding) {
			this.defaultBuilding = defaultBuilding;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getExtraPlayerInstances()
		 */
		@Override
		public int getExtraPlayerInstances() {
			return extraPlayerInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setExtraPlayerInstances(int)
		 */
		@Override
		public void setExtraPlayerInstances(int extraPlayerInstances) {
			this.extraPlayerInstances = extraPlayerInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getMaxGlobalInstances()
		 */
		@Override
		public int getMaxGlobalInstances() {
			return maxGlobalInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setMaxGlobalInstances(int)
		 */
		@Override
		public void setMaxGlobalInstances(int maxGlobalInstances) {
			this.maxGlobalInstances = maxGlobalInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getMaxPlayerInstances()
		 */
		@Override
		public int getMaxPlayerInstances() {
			return maxPlayerInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setMaxPlayerInstances(int)
		 */
		@Override
		public void setMaxPlayerInstances(int maxPlayerInstances) {
			this.maxPlayerInstances = maxPlayerInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getMaxTeamInstances()
		 */
		@Override
		public int getMaxTeamInstances() {
			return maxTeamInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setMaxTeamInstances(int)
		 */
		@Override
		public void setMaxTeamInstances(int maxTeamInstances) {
			this.maxTeamInstances = maxTeamInstances;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#isMonument()
		 */
		@Override
		public boolean isMonument() {
			return monument;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setMonument(boolean)
		 */
		@Override
		public void setMonument(boolean monument) {
			this.monument = monument;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#isNoLimit()
		 */
		@Override
		public boolean isNoLimit() {
			return noLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#setNoLimit(boolean)
		 */
		@Override
		public void setNoLimit(boolean noLimit) {
			this.noLimit = noLimit;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#getVictoryThresholds()
		 */
		@Override
		public List<IPair<String, Integer>> getVictoryThresholds() {
			return victoryThresholds;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.buildingclass.IBuildingClassInfo#addVictoryThreshold(org.archid.utils.IPair)
		 */
		@Override
		public void addVictoryThreshold(IPair<String, Integer> victoryThreshold) {
			this.victoryThresholds.add(victoryThreshold);
		}

		@Override
		public void setCategory(Integer category) {
			this.category = category;
		}

		@Override
		public Integer getCategory() {
			return category;
		}
		
		
	}

}
