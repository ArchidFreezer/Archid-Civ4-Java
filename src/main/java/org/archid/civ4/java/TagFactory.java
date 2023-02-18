package org.archid.civ4.java;

public class TagFactory {
	
	public static IInfoProcessor getProcessor(String infoName, TagNameUtils tagNameUtils) {
		if (infoName.equalsIgnoreCase("BonusInfo")) {
			return new BonusInfoProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("BuildingClassInfo")) {
			return new BuildingClassInfoProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("BuildingInfo")) {
			return new BuildingInfoProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("CivicInfo")) {
			return new CivicInfoProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("EraInfo")) {
			return new EraInfoProcessor(tagNameUtils);
		} else if (infoName.equalsIgnoreCase("UnitInfo")) {
			return new UnitInfoProcessor(tagNameUtils);
		} else {
			return null;
		}
	}

}
