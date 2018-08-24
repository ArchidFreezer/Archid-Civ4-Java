package org.archid.civ4.techinfo;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.archid.civ4.schema.SchemaParser;
import org.archid.civ4.schema.XmlTagDefinition;
import org.archid.civ4.schema.XmlTagInstance;
import org.archid.civ4.utils.StringUtils;

public class XMLGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(XMLGenerator.class.getName());
	
	private final String NEWLINE = System.getProperty("line.separator");
	private final String TAB = "\t";
	
	private final String TECH_TXT_BUTTON = "Art/Interface/Buttons/TechTree/xxTECHxx.dds";
	private final String TECH_TXT_DESC = "TXT_KEY_xxTECHxx";
	private final String TECH_TXT_HELP = "TXT_KEY_xxTECHxx_HELP";
	private final String TECH_TXT_PEDIA = "TXT_KEY_xxTECHxx_PEDIA";
	private final String TECH_TXT_QUOTE = "TXT_KEY_xxTECHxx_QUOTE";
	private final String TECH_TXT_SOUND = "AS2D_TECH_xxTECHxx";
	private final String TECH_TXT_STRATEGY = "TXT_KEY_xxTECHxx_STRATEGY";
	
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
		
		String techName = StringUtils.camelCaseSpace(info.getType().substring(5).toLowerCase(Locale.ROOT), '_');
		xml.append(indent + "<" + tag.getTagName() + ">" + " <!-- ** " + techName + " -->");
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
				else if (child.getTagName().equals("Description"))
					xml.append(TECH_TXT_DESC.replaceAll("xxTECHxx", info.getType()));
				else if (child.getTagName().equals("Civilopedia"))
					xml.append(TECH_TXT_PEDIA.replaceAll("xxTECHxx", info.getType()));
				else if (child.getTagName().equals("Help"))
					xml.append(TECH_TXT_HELP.replaceAll("xxTECHxx", info.getType()));
				else if (child.getTagName().equals("Strategy"))
					xml.append(TECH_TXT_STRATEGY.replaceAll("xxTECHxx", info.getType()));
				else if (child.getTagName().equals("iCost"))
					xml.append(info.getCost());
				else if (child.getTagName().equals("iAdvancedStartCost"))
					xml.append(info.getAdvancedStartCost());
				else if (child.getTagName().equals("Era"))
					xml.append(info.getEra());
				else if (child.getTagName().equals("iAsset"))
					xml.append(info.getAsset());
				else if (child.getTagName().equals("iGridX"))
					xml.append(info.getGridX());
				else if (child.getTagName().equals("iGridY"))
					xml.append(info.getGridY());
				else if (child.getTagName().equals("Quote"))
					xml.append(TECH_TXT_QUOTE.replaceAll("xxTECHxx", info.getType()));
				else if (child.getTagName().equals("Sound"))
					xml.append(TECH_TXT_SOUND.replaceAll("xxTECHxx", StringUtils.camelCaseCompress(info.getType().substring(5).toLowerCase(Locale.ROOT), '_')));
				else if (child.getTagName().equals("SoundMP"))
					xml.append(TECH_TXT_SOUND.replaceAll("xxTECHxx", StringUtils.camelCaseCompress(info.getType().substring(5).toLowerCase(Locale.ROOT), '_')));
				else if (child.getTagName().equals("Button"))
					xml.append(TECH_TXT_BUTTON.replaceAll("xxTECHxx", info.getType().substring(5).toLowerCase(Locale.ROOT)));
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
