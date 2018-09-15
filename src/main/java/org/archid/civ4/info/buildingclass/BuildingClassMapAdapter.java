package org.archid.civ4.info.buildingclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.utils.CollectionUtils;
import org.archid.utils.IPair;
import org.archid.utils.JaxbUtils;
import org.archid.utils.Pair;
import org.archid.utils.StringUtils;

public class BuildingClassMapAdapter extends XmlAdapter<BuildingClassMapAdapter.BuildingClassMap, Map<String, IBuildingClassInfo>>{
	
	public static class BuildingClassMap {
		 @XmlElement(name = "BuildingClassInfo")
		 List<AdaptedBuildingClass> entries = new ArrayList<AdaptedBuildingClass>();		
	}
	
	private static class AdaptedBuildingClass {
		@XmlElement(name="Type")
		private String type;
		@XmlElement(name="Description")
		private String description;
		@XmlElement(name="iMaxGlobalInstances")
		private Integer maxGlobalInstances;
		@XmlElement(name="iMaxTeamInstances")
		private Integer maxTeamInstances;
		@XmlElement(name="iMaxPlayerInstances")
		private Integer maxPlayerInstances;
		@XmlElement(name="iExtraPlayerInstances")
		private Integer extraPlayerInstances;
		@XmlElement(name="bNoLimit")
		private Integer noLimit;
		@XmlElement(name="bMonument")
		private Integer monument;
		@XmlElement(name="DefaultBuilding")
		private String defaultBuilding;
		@XmlElementWrapper(name="VictoryThresholds")
		@XmlElement(name="VictoryThreshold")
		private List<AdaptedVictoryThreshold> victoryThresholds;
	
	}

	private static class AdaptedVictoryThreshold {
		@XmlElement(name="VictoryType")
		private String victory;
		@XmlElement(name="iThreshold")
		private Integer threshold;
	}

	@Override
	public Map<String, IBuildingClassInfo> unmarshal(BuildingClassMap v) throws Exception {
		Map<String, IBuildingClassInfo> map = new TreeMap<String, IBuildingClassInfo>();
		for (AdaptedBuildingClass aInfo: v.entries) {
			IBuildingClassInfo info = BuildingClassInfos.createInfo(aInfo.type);
			info.setDescription(JaxbUtils.unmarshallString(aInfo.description));
			info.setMaxGlobalInstances(JaxbUtils.unmarshallInteger(aInfo.maxGlobalInstances));
			info.setMaxTeamInstances(JaxbUtils.unmarshallInteger(aInfo.maxTeamInstances));
			info.setMaxPlayerInstances(JaxbUtils.unmarshallInteger(aInfo.maxPlayerInstances));
			info.setExtraPlayerInstances(JaxbUtils.unmarshallInteger(aInfo.extraPlayerInstances));
			info.setNoLimit(JaxbUtils.unmarshallBoolean(aInfo.noLimit));
			info.setMonument(JaxbUtils.unmarshallBoolean(aInfo.monument));
			info.setDefaultBuilding(JaxbUtils.unmarshallString(aInfo.defaultBuilding));

			if (CollectionUtils.hasElements(aInfo.victoryThresholds)) {
				for (AdaptedVictoryThreshold adaptor: aInfo.victoryThresholds) {
					if (StringUtils.hasCharacters(adaptor.victory)) {
						info.addVictoryThreshold(new Pair<String, Integer>(adaptor.victory, adaptor.threshold));
					}
				}
			}
			
			map.put(aInfo.type, info);
		}
		
		return map;
	}

	@Override
	public BuildingClassMap marshal(Map<String, IBuildingClassInfo> v) throws Exception {
		BuildingClassMap map = new BuildingClassMap();
		for (IBuildingClassInfo info: v.values()) {
			AdaptedBuildingClass aInfo = new AdaptedBuildingClass();
			aInfo.type = info.getType();
			aInfo.description = JaxbUtils.marshallString(info.getDescription());
			aInfo.maxGlobalInstances = JaxbUtils.marshallInteger(info.getMaxGlobalInstances());
			aInfo.maxTeamInstances = JaxbUtils.marshallInteger(info.getMaxTeamInstances());
			aInfo.maxPlayerInstances = JaxbUtils.marshallInteger(info.getMaxPlayerInstances());
			aInfo.extraPlayerInstances = JaxbUtils.marshallInteger(info.getExtraPlayerInstances());
			aInfo.noLimit = JaxbUtils.marshallBoolean(info.isNoLimit());
			aInfo.monument = JaxbUtils.marshallBoolean(info.isMonument());
			aInfo.defaultBuilding = JaxbUtils.marshallString(info.getDefaultBuilding());
			
			if (CollectionUtils.hasElements(info.getVictoryThresholds())) {
				aInfo.victoryThresholds = new ArrayList<AdaptedVictoryThreshold>();
				for (IPair<String, Integer> pair: info.getVictoryThresholds()) {
					AdaptedVictoryThreshold adapter = new AdaptedVictoryThreshold();
					adapter.victory = pair.getKey();
					adapter.threshold = pair.getValue();
					aInfo.victoryThresholds.add(adapter);
				}
			}
			
			map.entries.add(aInfo);
		}
		return map;
	}

}
