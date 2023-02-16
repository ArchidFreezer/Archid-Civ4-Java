package org.archid.civ4.java;

public class EraInfoTagProcessor extends DefaultInfoTagProcessor {
	
	public EraInfoTagProcessor(TagNameUtils tagNameUtils) {
		super(tagNameUtils);
	}

	@Override
	public String getXmlFormatter() {
		return "EraInfoXmlFormatter()";
	}
	
}
