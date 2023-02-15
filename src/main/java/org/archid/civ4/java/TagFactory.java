package org.archid.civ4.java;

public class TagFactory {
	
	public static IInfoTagProcessor getProcessor(String infoName) {
		if (infoName.equalsIgnoreCase("CivicInfo")) {
			return new CivicInfoTagProcessor();
		} else if (infoName.equalsIgnoreCase("UnitInfo")) {
			return new UnitInfoTagProcessor();
		} else {
			return null;
		}
	}

}
