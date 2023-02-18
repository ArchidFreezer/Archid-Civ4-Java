package org.archid.civ4.java;

public class EraInfoProcessor extends DefaultInfoProcessor {
	
	public EraInfoProcessor(TagNameUtils tagNameUtils) {
		super(tagNameUtils);
	}

	@Override
	public String getXmlFormatter() {
		return "EraInfoXmlFormatter()";
	}
	
}
