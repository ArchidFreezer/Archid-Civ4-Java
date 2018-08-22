package org.archid.civ4.techinfo;

import java.util.List;
import java.util.Vector;

public class TechInfo {
	
	private String era;
	private String type;
	private int cost;
	private int advancedStartCost;
	private int asset;
	private int gridX;
	private int gridY;
	private List<String> orTechPrereqs = new Vector<String>();
	private List<String> andTechPrereqs = new Vector<String>();
	
	public void addOrTechPrereq(String prereq) {
		if (!orTechPrereqs.contains(prereq))
			orTechPrereqs.add(prereq);
	}

	public List<String> getOrTechPrereqs() {
		return orTechPrereqs;
	}

	public void addAndTechPrereq(String prereq) {
		if (!andTechPrereqs.contains(prereq))
			andTechPrereqs.add(prereq);
	}

	public List<String> getAndTechPrereqs() {
		return andTechPrereqs;
	}

	public String getEra() {
		return era;
	}

	public void setEra(String era) {
		this.era = era;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAdvancedStartCost() {
		return advancedStartCost;
	}

	public void setAdvancedStartCost(int advancedStartCost) {
		this.advancedStartCost = advancedStartCost;
	}

	public int getAsset() {
		return asset;
	}

	public void setAsset(int asset) {
		this.asset = asset;
	}

}
