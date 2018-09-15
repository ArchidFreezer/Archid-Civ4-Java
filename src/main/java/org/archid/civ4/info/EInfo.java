package org.archid.civ4.info;

public enum EInfo {
	BUILDING("CIV4BuildingInfos.xml"), 
	BUILDING_CLASS("CIV4BuildingClassInfos.xml"),
	ERA("CIV4EraInfos.xml"),
	TECH("CIV4TechInfos.xml"),
	UNIT("CIV4UnitInfos.xml"),
	UNKNOWN("UnknownInfo");
	
	private final String file;
	
	EInfo(String file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return file;
	}
	
	public static boolean containsFile(String v) {
		for (EInfo c: EInfo.values()) {
			if (c.file.equals(v)) {
				return true;
			}
		}
		return false;
	}
	
	public static EInfo fromFile(String v) {
		for (EInfo c: EInfo.values()) {
			if (c.file.equals(v)) {
				return c;
			}
		}
		return UNKNOWN;
	}
}