package org.archid.civ4.java;

public class BuildingClassInfoProcessor extends DefaultInfoProcessor {

	public BuildingClassInfoProcessor(TagNameData tagNameData) {
		super(tagNameData);
	}

	@Override
	public String getXmlFormatter() {
		return "BuildingClassInfoXmlFormatter()";
	}
	
}
