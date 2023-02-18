package org.archid.civ4.java;

public class EraInfoProcessor extends DefaultInfoProcessor {
	
	public EraInfoProcessor(TagNameData tagNameData) {
		super(tagNameData);
	}

	@Override
	public String getXmlFormatter() {
		return "EraInfoXmlFormatter()";
	}
	
}
