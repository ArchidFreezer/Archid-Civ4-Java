package org.archid.civ4.java;

public class BuildingClassInfoTagProcessor extends DefaultInfoTagProcessor {

	public BuildingClassInfoTagProcessor(TagNameUtils tagNameUtils) {
		super(tagNameUtils);
	}

	@Override
	public String getXmlFormatter() {
		return "BuildingClassInfoXmlFormatter()";
	}
	
}
