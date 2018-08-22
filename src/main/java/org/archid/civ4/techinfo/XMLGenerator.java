package org.archid.civ4.techinfo;

import org.apache.log4j.Logger;
import org.archid.civ4.schema.SchemaParser;
import org.archid.civ4.schema.XmlTagDefinition;
import org.archid.civ4.schema.XmlTagInstance;

public class XMLGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(XMLGenerator.class.getName());
	
	private final String NEWLINE = System.getProperty("line.separator");
	private final String TAB = "\t";
	
	private SchemaParser parser = null;
	
	public XMLGenerator(SchemaParser parser) {
		this.parser = parser;
	}
	
	protected String printTag(TechInfo info, XmlTagDefinition tag, int indentCount, boolean mandatoryOnly) {
		StringBuilder xml = new StringBuilder();
		StringBuilder indent = new StringBuilder();
		
		for (int i = 0; i < indentCount; i++)
		{
			indent.append(TAB);
		}
		
		xml.append(indent + "<" + tag.getTagName() + ">");
		xml.append(printTagInner(info, tag, indentCount + 1, mandatoryOnly));
		xml.append(NEWLINE + indent + "</" + tag.getTagName() + ">" + NEWLINE);
		
		return xml.toString();
	}

	protected String printTagInner(TechInfo info, XmlTagDefinition tag, int indentCount, boolean mandatoryOnly) {
		StringBuilder xml = new StringBuilder();
		StringBuilder indent = new StringBuilder();
		
		for (int i = 0; i < indentCount; i++)
		{
			indent.append(TAB);
		}
		int iChildIndentCount = indentCount + 1;
		
		for (XmlTagInstance child: tag.getChildren()) {
			if (!mandatoryOnly || child.isMandatory()) {
				XmlTagDefinition childTag = parser.getTagDefinition(child.getTagName());
				xml.append(NEWLINE + indent + "<" + child.getTagName() + ">");
				if (child.getTagName().equals("Type"))
					xml.append(info.getType());
				else if (child.getTagName().equals("Era"))
					xml.append(info.getEra());
				else if (child.getTagName().equals("iGridX"))
					xml.append(info.getGridX());
				else if (child.getTagName().equals("iGridY"))
					xml.append(info.getGridY());
				else if (child.getDefaultVal() != null)
					xml.append(child.getDefaultVal());
				else
					xml.append(childTag.getDataType().getDefaultVal());
				if (!childTag.getChildren().isEmpty())
					xml.append(printTagInner(info, childTag, iChildIndentCount, false) + NEWLINE + indent);
				xml.append("</" + child.getTagName() + ">");
			}
		}
		
		return xml.toString();
	}

}
