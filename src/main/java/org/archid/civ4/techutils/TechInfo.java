package org.archid.civ4.techutils;

import java.util.List;
import java.util.Vector;

public class TechInfo {
	
	private String era;
	private String type;
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

}
