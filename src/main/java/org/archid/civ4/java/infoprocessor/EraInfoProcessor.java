package org.archid.civ4.java.infoprocessor;

import org.archid.civ4.java.TagNameData;

public class EraInfoProcessor extends DefaultInfoProcessor {
	
	public EraInfoProcessor(TagNameData tagNameData) {
		super(tagNameData);
	}

	@Override
	public String getXmlFormatter() {
		return "EraInfoXmlFormatter()";
	}
	
}
