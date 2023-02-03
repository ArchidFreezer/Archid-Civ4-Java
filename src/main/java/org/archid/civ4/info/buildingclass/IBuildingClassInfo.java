package org.archid.civ4.info.buildingclass;

import java.util.List;

import org.archid.civ4.info.IInfo;
import org.archid.utils.IPair;

public interface IBuildingClassInfo extends IInfo {

	String getType();

	void setType(String type);

	String getDescription();
	
	void setCategory(Integer category);
	Integer getCategory();

	void setDescription(String description);

	String getDefaultBuilding();

	void setDefaultBuilding(String defaultBuilding);

	int getExtraPlayerInstances();

	void setExtraPlayerInstances(int extraPlayerInstances);

	int getMaxGlobalInstances();

	void setMaxGlobalInstances(int maxGlobalInstances);

	int getMaxPlayerInstances();

	void setMaxPlayerInstances(int maxPlayerInstances);

	int getMaxTeamInstances();

	void setMaxTeamInstances(int maxTeamInstances);

	boolean isMonument();

	void setMonument(boolean monument);

	boolean isNoLimit();

	void setNoLimit(boolean noLimit);

	List<IPair<String, Integer>> getVictoryThresholds();

	void addVictoryThreshold(IPair<String, Integer> victoryThreshold);

}