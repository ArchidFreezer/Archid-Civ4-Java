package org.archid.civ4.info;

import org.archid.utils.StringUtils;

public abstract class AbstractXmlFormatter implements IXmlFormatter {
	
	protected static final String newline = System.getProperty("line.separator");

	protected String getCommentText(String value) {
		return StringUtils.startCaseSpace(value.substring(value.indexOf('_') + 1), '_');
	}	

}
