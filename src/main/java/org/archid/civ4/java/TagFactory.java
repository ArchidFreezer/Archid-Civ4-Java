package org.archid.civ4.java;

public class TagFactory {
	
	public static IInfoProcessor getProcessor(String infoName, TagNameData tagNameData) {
		if (infoName.equalsIgnoreCase("BonusInfo")) {
			return new BonusInfoProcessor(tagNameData);
		} else if (infoName.equalsIgnoreCase("BuildingClassInfo")) {
			return new BuildingClassInfoProcessor(tagNameData);
		} else if (infoName.equalsIgnoreCase("BuildingInfo")) {
			return new BuildingInfoProcessor(tagNameData);
		} else if (infoName.equalsIgnoreCase("CivicInfo")) {
			return new CivicInfoProcessor(tagNameData);
		} else if (infoName.equalsIgnoreCase("EraInfo")) {
			return new EraInfoProcessor(tagNameData);
		} else if (infoName.equalsIgnoreCase("UnitInfo")) {
			return new UnitInfoProcessor(tagNameData);
		} else {
			return null;
		}
	}

}
