package org.archid.civ4.java;

public class BuildingClassInfoProcessor extends DefaultInfoProcessor {

	public BuildingClassInfoProcessor(TagNameUtils tagNameUtils) {
		super(tagNameUtils);
	}

	@Override
	public String getXmlFormatter() {
		return "BuildingClassInfoXmlFormatter()";
	}
	
}
