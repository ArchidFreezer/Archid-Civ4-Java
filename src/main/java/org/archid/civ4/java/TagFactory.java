package org.archid.civ4.java;

public class TagFactory {
	
	public static IInfoTagProcessor getProcessor(String infoName, TagNameUtils tagNameUtils) {
		if (infoName.equalsIgnoreCase("CivicInfo")) {
			return new CivicInfoTagProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("UnitInfo")) {
			return new UnitInfoTagProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("BonusInfo")) {
			return new BonusInfoTagProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("EraInfo")) {
			return new EraInfoTagProcessor(tagNameUtils);
		} else {
			return null;
		}
	}

}
