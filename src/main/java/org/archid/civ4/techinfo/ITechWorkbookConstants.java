package org.archid.civ4.techinfo;

public interface ITechWorkbookConstants {

	public static String SHEETNAME_TREE = "TechTree";
	public static String SHEETNAME_LIST = "TechList";

	public static String LISTSHEET_TYPE = "Type";
	public static String LISTSHEET_ERA = "Era";
	public static String LISTSHEET_GRIDX = "GridX";
	public static String LISTSHEET_GRIDY = "GridY";
	public static String LISTSHEET_OR_TECH_PREREQ = "OrTechPrereq";
	public static String LISTSHEET_AND_TECH_PREREQ = "AndTechPrereq";
	
	public static String STYLE_REGEX_TECH_PREREQ_NOT_VALUE = "(\\s*?<PrereqTech>)[a-zA-Z_]+(.*)";

	public static String STYLE_REGEX_IGRIDX_VALUE = "\\s*?<iGridX>(\\d+).*";
	public static String STYLE_REGEX_IGRIDY_VALUE = "\\s*?<iGridY>(\\d+).*";
	public static String STYLE_REGEX_TYPE_VALUE = "\\s*?<Type>([a-zA-Z_]+).*";
	
	public static String STYLE_REGEX_AND_TECH_PREREQ_TAG_END = "\\s*?</AndPreReqs>.*";
	public static String STYLE_REGEX_AND_TECH_PREREQ_TAG_START = "\\s*?<AndPreReqs>.*";
	public static String STYLE_REGEX_OR_TECH_PREREQ_TAG_END = "\\s*?</OrPreReqs>.*";
	public static String STYLE_REGEX_OR_TECH_PREREQ_TAG_START = "\\s*?<OrPreReqs>.*";
	public static String STYLE_REGEX_TECH_TAG_END = "\\s*?</TechInfo>.*";
	public static String STYLE_REGEX_TECH_TAG_START = "\\s*?<TechInfo>.*";
}
