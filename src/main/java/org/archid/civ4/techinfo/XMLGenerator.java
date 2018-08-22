package org.archid.civ4.techinfo;

import org.apache.log4j.Logger;
import org.archid.civ4.schema.SchemaParser;

public class XMLGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(XMLGenerator.class.getName());
	
	private final String NEWLINE = System.getProperty("line.separator");
	private final String TAB = "\t";
	
	private SchemaParser parser = null;
	
	public XMLGenerator(SchemaParser parser) {
		this.parser = parser;
	}
	
	public String getTag(String tagName, TechInfo info) {
		StringBuffer tag = new StringBuffer();
		
		
		
		return tag.toString();
	}
}
