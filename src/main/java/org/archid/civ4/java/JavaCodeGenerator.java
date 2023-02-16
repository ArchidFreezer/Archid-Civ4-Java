package org.archid.civ4.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.archid.civ4.schema.SchemaParser;
import org.archid.civ4.schema.XmlTagDefinition;
import org.archid.civ4.schema.XmlTagInstance;
import org.archid.civ4.schema.XmlTagDefinition.DataType;
import org.archid.utils.FileUtils;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;
import org.archid.utils.StringUtils;

public class JavaCodeGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(JavaCodeGenerator.class.getName());
	
	static final String MANUAL_INTERVENTION = "ManualInterventionRequired";
	
	private final String NEWLINE = System.getProperty("line.separator");
	private final String NEWLINET = NEWLINE + "\t";
	private final String NEWLINETT = NEWLINE + "\t\t";
	private final String NEWLINETTT = NEWLINE + "\t\t\t";
	private final String NEWLINETTTT = NEWLINE + "\t\t\t\t";
	private final String NEWLINETTTTT = NEWLINE + "\t\t\t\t\t";
	private final String NEWLINETTTTTT = NEWLINE + "\t\t\t\t\t\t";
	
	private String namespaceFolder = null; // somevalue
	private String infoName = null;        // SomeValueInfo
	private String infoNameRoot = null;    // SomeValue
	private String infoNamePlural = null;  // SomeValueInfos
	private String infoTopLevelTag = null; // Civ4SomeValueInfos
	private String packageDef = null;
	private XmlTagDefinition topLevelTagDefinition = null;
	private SchemaParser parser = null;
	private IPropertyHandler props = PropertyHandler.getInstance();
	Set<String> dynamicImports = new HashSet<String>();
	private Map<String, Tag> infoTagData = new HashMap<String, Tag>();
	
	private TagNameUtils tagNameUtils = new TagNameUtils();
	
	private IInfoTagProcessor customTags = null;

	public JavaCodeGenerator(SchemaParser parser) {
		this.parser = parser;
	}
	
	private void init(String infoTopLevelTag) {
		this.infoTopLevelTag = infoTopLevelTag;                             // Civ4SomeValueInfos
		infoNamePlural = infoTopLevelTag.substring(4);                      // SomeValueInfos
		infoName = infoNamePlural.substring(0,infoNamePlural.length() - 1); // SomeValueInfo
		infoNameRoot = infoName.substring(0,infoName.length() - 4);         // SomeValue
		namespaceFolder = infoNameRoot.toLowerCase();                       // somevalue
		packageDef = "package org.archid.civ4.info." + namespaceFolder + ";";
		topLevelTagDefinition = parser.getTagDefinition(infoName);
		customTags = TagFactory.getProcessor(infoName);
		if (customTags != null) customTags.init(namespaceFolder);
		parseInfo(topLevelTagDefinition);
	}

	private void parseInfo(XmlTagDefinition info) {
		Map<String, DataType> tagNameData = new HashMap<String, XmlTagDefinition.DataType>();
		for (XmlTagInstance tag: info.getChildren()) {
			XmlTagDefinition tagDef = parser.getTagDefinition(tag.getTagName());
			boolean customTagProcessing = (customTags == null) ? false : customTags.hasTagProcessor(tag.getTagName());
			Tag tagData = new Tag(tagDef, tag.isMandatory(), customTagProcessing);
			if (tagData.requiresArray()) {
				dynamicImports.add("import java.util.List;");
				dynamicImports.add("import java.util.ArrayList;");
			}
			if (tagData.leaves.size() == 2) dynamicImports.add("import org.archid.utils.IPair;");
			if (tagData.leaves.size() == 3) dynamicImports.add("import org.archid.utils.ITriple;");
			infoTagData.put(tag.getTagName(), tagData);
			tagNameData.put(tag.getTagName(), tagDef.getDataType());
		}
		// Get the variable names to be used
		tagNameUtils.buildUniqueNames(tagNameData);
		// Set the variable names to be used
		for (String tagName: infoTagData.keySet()) {
			infoTagData.get(tagName).setRootName(tagNameUtils.getRootName(tagName));
			infoTagData.get(tagName).setVarName(tagNameUtils.getVarName(tagName));
			infoTagData.get(tagName).init();
		}
	}

	public void createJavaCode(String infoTopLevelTag) {
		init(infoTopLevelTag);
		//First we need to create the output folder (package) for the java code
		createPackageFolder();
		createPackageInfoFile();
		createInfoInterface();
		createInfoClass();
		createInfoWorkbookInterface();
		createInfoMapAdapter();
		createInfoExporter();
		createInfoImporter();
	}
	
	private void createInfoImporter() {
		Set<String> imports = new HashSet<String>();
		imports.add("import org.apache.log4j.Logger;");
		imports.add("import org.apache.poi.ss.usermodel.Row;");
		imports.add("import org.archid.civ4.info.AbstractImporter;");
		imports.add("import org.archid.civ4.info.EInfo;");
		imports.add("import org.archid.civ4.info.IInfos;");
		if (customTags == null) imports.add("import org.archid.civ4.info.DefaultXmlFormatter;");

		StringBuilder file = new StringBuilder();
		StringBuilder customCellReaders = new StringBuilder();

		file.append(packageDef);
		file.append(NEWLINE);

		
		StringBuilder mainClass = new StringBuilder();
		String xmlFormatter = (customTags == null) ? "DefaultXmlFormatter(\"" + infoNameRoot + "\")" : customTags.getXmlFormatter();
		Integer typeTagIndex = (customTags == null) ? 0 : customTags.getTypeTagIndex();
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINE + "public class " + infoNameRoot + "Importer extends AbstractImporter<IInfos<I" + infoName + ">, I" + infoName + "> {");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "/** Logging facility */");
		mainClass.append(NEWLINET + "static Logger log = Logger.getLogger(" + infoNameRoot + "Importer.class.getName());");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "public " + infoNameRoot + "Importer(EInfo infoEnum) {");
		mainClass.append(NEWLINETT + "super(infoEnum, new " + xmlFormatter + ");");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "public String getListSheetName() {");
		mainClass.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SHEETNAME_LIST;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "protected I" + infoName + " parseRow(Row row) {");
		mainClass.append(NEWLINETT + "int colNum = 0;");
		mainClass.append(NEWLINETT + "String type = row.getCell(" + typeTagIndex.toString() + ").getStringCellValue();");
		mainClass.append(NEWLINETT + "// Handle cells that have been moved");
		mainClass.append(NEWLINETT + "if (type.isEmpty())");
		mainClass.append(NEWLINETTT + "return null;");
		mainClass.append(NEWLINE + "");
		mainClass.append(NEWLINETT + "I" + infoName + " info = " + infoName + "s.createInfo(type);");

		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			ITagProcessor processor = null;
			if (customTags != null && customTags.hasTagProcessor(mainChild.getTagName())) {
				processor = customTags.getTagProcessor(mainChild.getTagName());
				tag.setDataType(processor.getDataType());
				tag.setSingularDataType(processor.getDataType());
			}
			if (processor != null) {
				mainClass.append(processor.getImporterRow());
				customCellReaders.append(processor.getImporterCellReader());
			} else if (tag.requiresArray()) {
				if (tag.leaves.size() == 1) {
					if (tag.requiresArray()) {
						mainClass.append(NEWLINETT + "parseListCell(row.getCell(colNum++), " + tag.singularDataType + ".class, info::" + tag.setterName + ");");
					} else {
						mainClass.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.dataType + ".class, info::" + tag.setterName + ");");
					}
				} else if (tag.leaves.size() == 2) { 
					mainClass.append(NEWLINETT + "parsePairsCell(row.getCell(colNum++), " + tag.leaves.get(0).type + ".class, " + tag.leaves.get(1).type + ".class, info::" + tag.setterName + ");");
				} else if (tag.leaves.size() == 3) {
					mainClass.append(NEWLINETT + "parseTriplesCell(row.getCell(colNum++), " + tag.leaves.get(0).type + ".class, " + tag.leaves.get(1).type + ".class, " + tag.leaves.get(2).type + ".class, info::" + tag.setterName + ");");
				}
			} else {
				mainClass.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.dataType + ".class, info::" + tag.setterName + ");");					
			}
		}
		
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINETT + "return info;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(customCellReaders);
		mainClass.append(NEWLINE + "}");

		// Sort the imports
		if (customTags != null) imports.addAll(customTags.getImportImports());
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(mainClass);
		writeFile(infoNameRoot + "Importer.java", file.toString());
		
}

	private void createInfoExporter() {
		Set<String> imports = new HashSet<String>();
		imports.add("import java.util.ArrayList;");
		imports.add("import java.util.List;");
		imports.add("import org.apache.log4j.Logger;");
		imports.add("import org.apache.poi.ss.usermodel.Row;");
		imports.add("import org.archid.civ4.info.AbstractExporter;");
		imports.add("import org.archid.civ4.info.EInfo;");
		imports.add("import org.archid.civ4.info.IInfos;");
		imports.add("import org.archid.civ4.info." + namespaceFolder + ".I" + infoNameRoot + "Workbook.SheetHeaders;");

		StringBuilder file = new StringBuilder();
		StringBuilder customCellWriters = new StringBuilder();
		file.append(packageDef);
		file.append(NEWLINE);

		StringBuilder mainClass = new StringBuilder();
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINE + "public class " + infoNameRoot + "Exporter extends AbstractExporter<IInfos<I" + infoName + ">, I" + infoName + "> {");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "/** Logging facility */");
		mainClass.append(NEWLINET + "static Logger log = Logger.getLogger(" + infoNameRoot + "Exporter.class.getName());");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "public " + infoNameRoot + "Exporter(EInfo infoEnum) {");
		mainClass.append(NEWLINETT + "super(infoEnum);");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "public List<String> getHeaders() {");
		mainClass.append(NEWLINETT + "List<String> headers = new ArrayList<String>();");
		mainClass.append(NEWLINETT + "for (SheetHeaders header: SheetHeaders.values()) {");
		mainClass.append(NEWLINETTT + "headers.add(header.toString());");
		mainClass.append(NEWLINETT + "}");
		mainClass.append(NEWLINETT + "return headers;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "protected int getNumCols() {");
		mainClass.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SheetHeaders.values().length;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "protected String getInfoListSheetName() {");
		mainClass.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SHEETNAME_LIST;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "protected void populateRow(Row row, I" + infoName + " info) {");
		mainClass.append(NEWLINETT + "int maxHeight = 1;");
		mainClass.append(NEWLINETT + "int colNum = 0;");
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			ITagProcessor processor = null;
			if (customTags != null && customTags.hasTagProcessor(mainChild.getTagName())) {
				processor = customTags.getTagProcessor(mainChild.getTagName());
				tag.setDataType(processor.getDataType());
				tag.setSingularDataType(processor.getDataType());
			}
			if (processor != null) {
				mainClass.append(processor.getExporterRow());
				customCellWriters.append(processor.getExporterCellWriter());
			} else if (tag.requiresArray()) {
				if (tag.leaves.size() == 1) {
					mainClass.append(NEWLINETT + "maxHeight = addRepeatingCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				} else if (tag.leaves.size() == 2) { 
					mainClass.append(NEWLINETT + "maxHeight = addRepeatingPairCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				} else if (tag.leaves.size() == 3) {
					mainClass.append(NEWLINETT + "maxHeight = addRepeatingTripleCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				}
			} else {
				mainClass.append(NEWLINETT + "addSingleCell(row.createCell(colNum++), info." + tag.getterName + "());");					
			}
		}
		
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINETT + "row.setHeightInPoints(maxHeight * row.getSheet().getDefaultRowHeightInPoints());");
		mainClass.append(NEWLINET + "}");
		mainClass.append(customCellWriters);
		mainClass.append(NEWLINE + "}");

		// Sort the imports
		if (customTags != null) imports.addAll(customTags.getExportImports());
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(mainClass);

		writeFile(infoNameRoot + "Exporter.java", file.toString());
		
	}

	private void createInfoMapAdapter() {
		Set<String> imports = new HashSet<String>(dynamicImports);
		imports.add("import java.util.ArrayList;");
		imports.add("import java.util.List;");
		imports.add("import java.util.Map;");
		imports.add("import java.util.TreeMap;");
		imports.add("import javax.xml.bind.annotation.XmlElement;");
		imports.add("import javax.xml.bind.annotation.XmlElementWrapper;");
		imports.add("import javax.xml.bind.annotation.adapters.XmlAdapter;");
		imports.add("import org.archid.utils.CollectionUtils;");
		imports.add("import org.archid.utils.JaxbUtils;");
		imports.add("import org.archid.utils.StringUtils;");
		
		
		// There are 3 core classes and the custom adapters inside the main class with each tag having entries
		// in at least the 3 core classes so to prevent multiple iterations we will use 4 StringBuilders
		StringBuilder adaptedClass = new StringBuilder();
		adaptedClass.append(NEWLINET + "private static class Adapted" + infoNameRoot + " {");

		StringBuilder customAdapters = new StringBuilder();

		StringBuilder unmarshalClass = new StringBuilder();
		unmarshalClass.append(NEWLINE);
		unmarshalClass.append(NEWLINET + "@Override");
		unmarshalClass.append(NEWLINET + "public Map<String, I" + infoName + "> unmarshal(" + infoNameRoot + "Map v) throws Exception {");
		unmarshalClass.append(NEWLINETT + "Map<String, I" + infoName + "> map = new TreeMap<String, I" + infoName + ">();");
		unmarshalClass.append(NEWLINETT + "for (Adapted" + infoNameRoot + " aInfo: v.entries) {");
		unmarshalClass.append(NEWLINETTT + "I" + infoName + " info = " + infoNamePlural + ".createInfo(aInfo.type);");

		StringBuilder marshalClass = new StringBuilder();
		marshalClass.append(NEWLINE);
		marshalClass.append(NEWLINET + "@Override");
		marshalClass.append(NEWLINET + "public " + infoNameRoot + "Map marshal(Map<String, I" + infoName + "> v) throws Exception {");
		marshalClass.append(NEWLINETT + infoNameRoot + "Map map = new " + infoNameRoot + "Map();");
		marshalClass.append(NEWLINETT + "for (I" + infoName + " info: v.values()) {");
		marshalClass.append(NEWLINETTT + "Adapted" + infoNameRoot + " aInfo = new Adapted" + infoNameRoot + "();");
		marshalClass.append(NEWLINETTT + "aInfo.type = info.getType();");
		
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			ITagProcessor processor = null;
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (customTags != null && customTags.hasTagProcessor(mainChild.getTagName())) {
				processor = customTags.getTagProcessor(mainChild.getTagName());
				tag.setDataType(processor.getDataType());
				tag.setSingularDataType(processor.getDataType());
				imports.addAll(processor.getAdapterImports());
			}
			// Process the adapted class
			if (processor != null) {
				adaptedClass.append(processor.getAdapterElement());
			} else if (tag.requiresAdapter()) {
				XmlTagDefinition innerTagXmlDef = parser.getTagDefinition(tag.tagDefinition.getChildren().get(0).getTagName());
				adaptedClass.append(NEWLINETT + "@XmlElementWrapper(name=\"" + mainChild.getTagName() + "\")");
				adaptedClass.append(NEWLINETT + "@XmlElement(name=\"" + innerTagXmlDef.getTagName() + "\")");
				adaptedClass.append(NEWLINETT + "private List<Adapted" + mainChild.getTagName() + "> " + tag.varName + ";");				
			} else if (tag.requiresArray()) {
				XmlTagDefinition innerTagXmlDef = parser.getTagDefinition(tag.tagDefinition.getChildren().get(0).getTagName());
				adaptedClass.append(NEWLINETT + "@XmlElementWrapper(name=\"" + mainChild.getTagName() + "\")");
				adaptedClass.append(NEWLINETT + "@XmlElement(name=\"" + innerTagXmlDef.getTagName() + "\")");
				adaptedClass.append(NEWLINETT + "private " + getXmlDataType(tag.leaves.get(0).type) + " " + tag.varName + ";");				
			} else {
				adaptedClass.append(NEWLINETT + "@XmlElement(name=\"" + mainChild.getTagName() + "\")");
				adaptedClass.append(NEWLINETT + "private " + getXmlDataType(tag.leaves.get(0).type) + " " + tag.varName + ";");				
			}
			
			// Process any custom adapters
			if (tag.requiresAdapter() && processor == null) {
				if (tag.custom) {
					log.warn("Unable to create adapter for " + tag.rootName + ": " + tag.dataType);
					customAdapters.append(NEWLINE);
					customAdapters.append(NEWLINET + "private static class Adapted" + mainChild.getTagName() + " {");
					customAdapters.append(NEWLINETT + "@XmlElement(name=\"" + tag.dataType + "\")");
					customAdapters.append(NEWLINETT + "private " + tag.dataType + " VAR_NAME;");
					customAdapters.append(NEWLINET + "}");
				} else {
					customAdapters.append(NEWLINE);
					customAdapters.append(NEWLINET + "private static class Adapted" + mainChild.getTagName() + " {");
					for (LeafData leaf: tag.leaves) {
						customAdapters.append(NEWLINETT + "@XmlElement(name=\"" + leaf.name + "\")");
						customAdapters.append(NEWLINETT + "private " + getXmlDataType(leaf.type) + " " + leaf.varName + ";");
					}
					customAdapters.append(NEWLINET + "}");
				}
			}
			
			// Process the unmarshall class
			// The type is set when we instantiated the info class above and has no mutator
			if (!tag.rootName.equals("Type")) {
				if (processor != null) {
					unmarshalClass.append(processor.getUnmarshallString());
				} else if (tag.custom) {
					unmarshalClass.append(NEWLINE);
					unmarshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(aInfo." + tag.varName + ")) {");
					unmarshalClass.append(NEWLINETTTT + "for (Adapted" + mainChild.getTagName() + " adaptor: aInfo." + tag.varName + ") {");
					unmarshalClass.append(NEWLINETTTTT + tag.dataType);
					unmarshalClass.append(NEWLINETTTT + "}");
					unmarshalClass.append(NEWLINETTT + "}");
				} else if (tag.requiresAdapter()) {
					unmarshalClass.append(NEWLINE);
					unmarshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(aInfo." + tag.varName + ")) {");
					unmarshalClass.append(NEWLINETTTT + "for (Adapted" + mainChild.getTagName() + " adaptor: aInfo." + tag.varName + ") {");
					unmarshalClass.append(NEWLINETTTTT + "if (StringUtils.hasCharacters(adaptor." + tag.leaves.get(0).varName + ")) {");
					if (tag.leaves.size() == 2) {
						imports.add("import org.archid.utils.Pair;");
						unmarshalClass.append(NEWLINETTTTTT + "info." + tag.setterName + "(new Pair<" + tag.leaves.get(0).type + ", " + tag.leaves.get(1).type + ">(adaptor." + tag.leaves.get(0).varName + ", adaptor." + tag.leaves.get(1).varName + "));");
					} else if (tag.leaves.size() == 3) {
						imports.add("import org.archid.utils.Triple;");
						unmarshalClass.append(NEWLINETTTTTT + "info." + tag.setterName + "(new Triple<" + tag.leaves.get(0).type + ", " + tag.leaves.get(1).type + ", " + tag.leaves.get(2).type + ">(adaptor." + tag.leaves.get(0).varName + ", adaptor." + tag.leaves.get(1).varName + ", adaptor." + tag.leaves.get(2).varName + "));");						
					}
					unmarshalClass.append(NEWLINETTTTT + "}");
					unmarshalClass.append(NEWLINETTTT + "}");
					unmarshalClass.append(NEWLINETTT + "}");
				} else if (tag.requiresArray()) {
					unmarshalClass.append(NEWLINE);
					unmarshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(aInfo." + tag.varName + ")) {");
					unmarshalClass.append(NEWLINETTTT + "for (" + tag.singularDataType + " val: aInfo." + tag.varName + ") {");
					if (tag.singularDataType.equals("String")) {
						unmarshalClass.append(NEWLINETTTTT + "if (StringUtils.hasCharacters(val)) {");
						unmarshalClass.append(NEWLINETTTTTT + "info." + tag.setterName + "(val);");
						unmarshalClass.append(NEWLINETTTTT + "}");
					} else {
						unmarshalClass.append(NEWLINETTTTT + "info." + tag.setterName + "(val);");
					}
					unmarshalClass.append(NEWLINETTTT + "}");
					unmarshalClass.append(NEWLINETTT + "}");
				} else {
					unmarshalClass.append(NEWLINETTT + "info." + tag.setterName + "(JaxbUtils.unmarshall" + tag.dataType + "(aInfo." + tag.varName + "));");
				}
			}
			
			// Process the marshall class
			if (!tag.rootName.equals("Type")) {
				if (processor != null) {
					marshalClass.append(processor.getMarshallString());
				} else if (tag.custom) {
					marshalClass.append(NEWLINE);
					marshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(info." + tag.getterName + "())) {");
					marshalClass.append(NEWLINETTTT + "aInfo." + tag.varName + " = new ArrayList<Adapted" + mainChild.getTagName() + ">();");
					marshalClass.append(NEWLINETTTTT + tag.dataType);
					marshalClass.append(NEWLINETTTT + "}");
					marshalClass.append(NEWLINETTT + "}");
				} else if (tag.requiresAdapter()) {
					marshalClass.append(NEWLINE);
					marshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(info." + tag.getterName + "())) {");
					marshalClass.append(NEWLINETTTT + "aInfo." + tag.varName + " = new ArrayList<Adapted" + mainChild.getTagName() + ">();");
					if (tag.leaves.size() == 2) {
						marshalClass.append(NEWLINETTTT + "for (IPair<" + tag.leaves.get(0).type + ", " + tag.leaves.get(1).type + "> pair: info." + tag.getterName + "()) {");
						marshalClass.append(NEWLINETTTTT + "Adapted" + mainChild.getTagName() + " adaptor = new Adapted" + mainChild.getTagName() + "();");
						marshalClass.append(NEWLINETTTTT + "adaptor." + tag.leaves.get(0).varName + " = pair.getKey();");
						marshalClass.append(NEWLINETTTTT + "adaptor." + tag.leaves.get(1).varName + " = pair.getValue();");
					} else if (tag.leaves.size() == 3) {
						marshalClass.append(NEWLINETTTT + "for (ITriple<" + tag.leaves.get(0).type + ", " + tag.leaves.get(1).type + ", " + tag.leaves.get(2).type + "> triple: info." + tag.getterName + "()) {");
						marshalClass.append(NEWLINETTTTT + "Adapted" + mainChild.getTagName() + " adaptor = new Adapted" + mainChild.getTagName() + "();");
						marshalClass.append(NEWLINETTTTT + "adaptor." + tag.leaves.get(0).varName + " = triple.getKey();");
						marshalClass.append(NEWLINETTTTT + "adaptor." + tag.leaves.get(1).varName + " = triple.getValue();");
						marshalClass.append(NEWLINETTTTT + "adaptor." + tag.leaves.get(2).varName + " = triple.getData();");
					}
					marshalClass.append(NEWLINETTTTT + "aInfo." + tag.varName + ".add(adaptor);");
					marshalClass.append(NEWLINETTTT + "}");
					marshalClass.append(NEWLINETTT + "}");
				} else if (tag.requiresArray()) {
					marshalClass.append(NEWLINE);
					marshalClass.append(NEWLINETTT + "if (CollectionUtils.hasElements(info." + tag.getterName + "())) {");
					marshalClass.append(NEWLINETTTT + "aInfo." + tag.varName + " = new ArrayList<" + tag.singularDataType + ">();");
					marshalClass.append(NEWLINETTTT + "for(" + tag.singularDataType + " val: info." + tag.getterName + "()) {");
					marshalClass.append(NEWLINETTTTT + "aInfo." + tag.varName + ".add(val);");
					marshalClass.append(NEWLINETTTT + "}");
					marshalClass.append(NEWLINETTT + "}");
				} else {
					if (tag.isMandatory())
						marshalClass.append(NEWLINETTT + "aInfo." + tag.varName + " = JaxbUtils.marshallMandatory" + tag.dataType + "(info." + tag.getterName + "());");
					else
						marshalClass.append(NEWLINETTT + "aInfo." + tag.varName + " = JaxbUtils.marshall" + tag.dataType + "(info." + tag.getterName + "());");
				}
			}
			
			
		}
		
		adaptedClass.append(NEWLINET + "}");
		
		unmarshalClass.append(NEWLINE);
		unmarshalClass.append(NEWLINETTT + "map.put(aInfo.type, info);");
		unmarshalClass.append(NEWLINETT + "}");
		unmarshalClass.append(NEWLINETT + "return map;");
		unmarshalClass.append(NEWLINET + "}");
		
		marshalClass.append(NEWLINE);
		marshalClass.append(NEWLINETTT + "map.entries.add(aInfo);");
		marshalClass.append(NEWLINETT + "}");
		marshalClass.append(NEWLINETT + "return map;");
		marshalClass.append(NEWLINET + "}");
		
		StringBuilder file = new StringBuilder();
		file.append(packageDef);
		file.append(NEWLINE);
		// Sort the imports
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(NEWLINE);
		file.append(NEWLINE + "public class " + infoNameRoot + "MapAdapter extends XmlAdapter<" + infoNameRoot + "MapAdapter." + infoNameRoot + "Map, Map<String, I" + infoName + ">> {");
		file.append(NEWLINE);
		file.append(NEWLINET + "public static class " + infoNameRoot + "Map {");
		file.append(NEWLINETT + "@XmlElement(name = \"" + infoName + "\")");
		file.append(NEWLINETT + "List<Adapted" + infoNameRoot + "> entries = new ArrayList<Adapted" + infoNameRoot + ">();");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(adaptedClass);
		file.append(customAdapters);
		file.append(unmarshalClass);
		file.append(marshalClass);
		file.append(NEWLINE + "}");

		writeFile(infoNameRoot + "MapAdapter.java", file.toString());
}

	private void createInfoWorkbookInterface() {
		StringBuilder file = new StringBuilder();
		file.append(packageDef);
		file.append(NEWLINE);
		file.append(NEWLINE + "import org.archid.civ4.info.IInfoWorkbook;");
		file.append(NEWLINE + "import org.archid.utils.StringUtils;");
		file.append(NEWLINE);
		file.append(NEWLINE + "public interface I" + infoNameRoot + "Workbook extends IInfoWorkbook {");
		file.append(NEWLINE);
		file.append(NEWLINET + "public static final String SHEETNAME_LIST = \"" + infoNameRoot + "List\";");
		file.append(NEWLINE);
		file.append(NEWLINET + "public enum SheetHeaders {");
		file.append(NEWLINETT);
		StringBuilder row = new StringBuilder();
		boolean first = true;
		boolean reset = false;
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (first) {
				first = false;
			} else if (reset) {
				row.append(", " + NEWLINETT);
				reset = false;
			} else {
				row.append(", ");
			}
			row.append(StringUtils.uCaseSplit(tag.varName, '_'));
			if (row.length() >= 170) {
				file.append(row);
				row.setLength(0);
				reset = true;
			}
		}
		file.append(row + ";");
		file.append(NEWLINE);
		file.append(NEWLINETT + "@Override");
		file.append(NEWLINETT + "public String toString() {");
		file.append(NEWLINETTT + "return StringUtils.titleCaseSpace(this.name(), '_');");
		file.append(NEWLINETT + "}");
		file.append(NEWLINET + "}");
		file.append(NEWLINE + "}");

		
		writeFile("I" + infoNameRoot + "Workbook.java", file.toString());
	}

	private void createInfoClass() {
		
		// Sort the imports, this is cosmetic, but easy enough
		Set<String> imports = new HashSet<String>(dynamicImports);
		imports.add("import java.util.LinkedHashMap;");
		imports.add("import java.util.Map;");
		imports.add("import org.archid.civ4.info.AbstractInfos;");
		imports.add("import javax.xml.bind.annotation.XmlAccessType;");
		imports.add("import javax.xml.bind.annotation.XmlAccessorType;");
		imports.add("import javax.xml.bind.annotation.XmlElement;");
		imports.add("import javax.xml.bind.annotation.XmlRootElement;");
		imports.add("import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;");

		// Create the wrapper class
		StringBuilder mainClass = new StringBuilder();
		mainClass.append(NEWLINE + "@XmlRootElement(name=\"" + infoTopLevelTag + "\", namespace=\"x-schema:" + props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA) + "\")");
		mainClass.append(NEWLINE + "@XmlAccessorType(XmlAccessType.NONE)");
		mainClass.append(NEWLINE + "public class " + infoNamePlural + " extends AbstractInfos<I" + infoName + "> {");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "public " + infoNamePlural + "() {");
		mainClass.append(NEWLINETT + "super(new LinkedHashMap<String, I" + infoName + ">());");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@XmlJavaTypeAdapter(" + infoNameRoot + "MapAdapter.class)");
		mainClass.append(NEWLINET + "@XmlElement(name=\"" + infoNamePlural + "\")");
		mainClass.append(NEWLINET + "public Map<String, I" + infoName + "> getInfoMap() {");
		mainClass.append(NEWLINETT + "return infos;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "public static I" + infoName + " createInfo(String type) {");
		mainClass.append(NEWLINETT + "return new " + infoName + "(type);");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "public void setInfoMap(Map<String, I" + infoName + "> infos) {");
		mainClass.append(NEWLINETT + "this.infos = infos;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		
		// Create the inner class
		mainClass.append(NEWLINET + "private static class " + infoName + " implements I" + infoName + "{");
		mainClass.append(NEWLINE);
		StringBuilder vars = new StringBuilder();
		StringBuilder methods = new StringBuilder();
		// We always have the constructor first
		methods.append(NEWLINE);
		methods.append(NEWLINETT + "private " + infoName + "(String type) {");
		methods.append(NEWLINETTT + "this.type = type;");
		methods.append(NEWLINETT + "}");
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (customTags != null && customTags.hasTagProcessor(mainChild.getTagName())) {
				ITagProcessor processor = customTags.getTagProcessor(mainChild.getTagName());
				tag.setDataType(processor.getDataType());
				tag.setSingularDataType(processor.getDataType());
			}
			if (tag.custom) {
				vars.append(NEWLINETT + "private " + tag.dataType + " " + tag.varName + " = new " + tag.dataType + "();");
			} else if (tag.requiresArray())
					vars.append(NEWLINETT + "private " + tag.dataType + " " + tag.varName + " = new ArrayList<" + tag.singularDataType + ">();");
			else 
				vars.append(NEWLINETT + "private " + tag.dataType + " " + tag.varName + ";");
			methods.append(NEWLINE);
			methods.append(NEWLINETT + "@Override");
			methods.append(NEWLINETT + "public " + tag.dataType + " " + tag.getterName + "() {");
			methods.append(NEWLINETTT + "return " + tag.varName + ";");
			methods.append(NEWLINETT + "}");
			methods.append(NEWLINE);
			methods.append(NEWLINETT + "@Override");
			methods.append(NEWLINETT + "public " + tag.setterSignature() + " {");
			if (tag.requiresArray() && !tag.custom)
				methods.append(NEWLINETTT + "this." + tag.varName + ".add(" + tag.setterVarName() + ");");
			else
				methods.append(NEWLINETTT + "this." + tag.varName + " = " + tag.setterVarName() + ";");
			methods.append(NEWLINETT + "}");
		}
		mainClass.append(vars);
		mainClass.append(methods);
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE + "}");

		// Construct the file
		StringBuilder file = new StringBuilder();
		file.append(packageDef);
		file.append(NEWLINE);
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(NEWLINE);
		file.append(mainClass);
		writeFile(infoNamePlural + ".java", file.toString());
		
	}

	private void createInfoInterface() {
		
		StringBuilder file = new StringBuilder();
		file.append(packageDef);
		file.append(NEWLINE);
		
		Set<String> imports = new HashSet<String>(dynamicImports);
		imports.add("import org.archid.civ4.info.IInfo;");
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		
		// Now do the interface
		file.append(NEWLINE + NEWLINE + "public interface I" + infoName + " extends IInfo {");
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			
			// The Type tag is processed in the IInfo interface 
			if (mainChild.getTagName().equals("Type"))
				continue;
				
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (customTags != null && customTags.hasTagProcessor(mainChild.getTagName())) {
				ITagProcessor processor = customTags.getTagProcessor(mainChild.getTagName());
				tag.setDataType(processor.getDataType());
				tag.setSingularDataType(processor.getDataType());
			}
			file.append(NEWLINET + tag.getterSignature() + ";");
			file.append(NEWLINET + tag.setterSignature() + ";");
			file.append(NEWLINE);
		}
		file.append(NEWLINE + "}");
		
		writeFile("I" + infoName + ".java", file.toString());
	}

	private void createPackageInfoFile() {
		StringBuilder sb = new StringBuilder();
		sb.append("@javax.xml.bind.annotation.XmlSchema(namespace=\"x-schema:" + props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA) + "\", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)");
		sb.append(NEWLINE + packageDef);
		writeFile("package-info.java", sb.toString());
	}

	private void createPackageFolder() {
		String folderPath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_JAVA_OUTPUT_DIR, ".") + "\\" + namespaceFolder;
		FileUtils.ensureDirExists(folderPath);
	}

	protected void writeFile(String fileName, String content) {
		BufferedWriter out = null;
		String filePath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_JAVA_OUTPUT_DIR, ".") + "\\" + namespaceFolder + "\\" + fileName;
		try {
			out = new BufferedWriter(new FileWriter(filePath));
			out.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out)
					out.close();
			} catch (IOException e) {
				log.error("Error closing output file!");
			}
		}

	}
	
	private String getXmlDataType(String javaType) {
		if (javaType.equals("Boolean"))
			return "Integer";
		else if (javaType.equals("Float"))
			return "String";
		else
			return javaType;
	}
	
	private class Tag {
		
		private XmlTagDefinition tagDefinition = null; // iSomeTag
		private String rootName = "";      // SomeTag
		private String varName = "";       // someTag
		private String getterName = null;
		private String setterName = null;
		private String dataType = null;
		private String singularDataType = null;
		private Integer numLevels = null;
		private boolean mandatory = false;
		private boolean custom = false;
		private List<LeafData> leaves = new ArrayList<LeafData>(); 
		
		private Tag(XmlTagDefinition tag, boolean mandatory, boolean custom) {
			this.tagDefinition = tag;
			this.mandatory = mandatory;
			this.custom = custom;
			numLevels = getNumLevels(tagDefinition, 0);
			populateLeafData();
		}
		
		public void init() {
			getterName = buildGetterName();
			setterName = buildSetterName();
		}
		
		public void setVarName(String varName) {
			this.varName = varName;
		}
		
		public void setRootName(String rootName) {
			this.rootName = rootName;
		}
		
		private void populateLeafData() {
			if (custom) return;
			if (numLevels == 0) {
				LeafData leafData = new LeafData();
				leafData.name = rootName;
				leafData.varName = varName;
				leafData.type = tagDefinition.getDataType().getJavaType();
				leafData.singularType = tagDefinition.getDataType().getJavaType();
				leaves.add(leafData);
				dataType = leafData.type;
				singularDataType = leafData.singularType;
			} else if (numLevels == 1) {
				LeafData leafData = new LeafData();
				leafData.name = rootName;
				leafData.varName = varName;
				leafData.singularType = parser.getTagDefinition(tagDefinition.getChildren().get(0).getTagName()).getDataType().getJavaType();
				leafData.type = "List<" + leafData.singularType + ">";
				leaves.add(leafData);
				dataType = leafData.type;
				singularDataType = leafData.singularType;
			} else if (numLevels == 2) {
				StringBuilder sbInner = new StringBuilder();
				// We need to drop down to the bottom level to determine how many leaf tags there are
				XmlTagDefinition wrapper = parser.getTagDefinition(tagDefinition.getChildren().get(0).getTagName());
				for (XmlTagInstance leaf: wrapper.getChildren()) {
					LeafData leafData = new LeafData();
					leafData.name = leaf.getTagName();
					leafData.varName = tagNameUtils.getVarName(leaf.getTagName());
					leafData.type = parser.getTagDefinition(leaf.getTagName()).getDataType().getJavaType();
					leafData.singularType = leafData.type;
					leaves.add(leafData);
				}
				if (leaves.size() == 2) {
					sbInner.append("IPair<");
				} else if (leaves.size() == 3) {
					sbInner.append("ITriple<");
				} else {
					// give up at this point
					leaves.clear();
					custom = true;
					dataType = rootName;
					singularDataType = dataType;
				}
				if (!custom) {
					Boolean first = true;
					for (LeafData leaf: leaves) {
						if (first) {
							first = false;
						} else {
							sbInner.append(", ");
						}
						sbInner.append(leaf.type);
					}
					sbInner.append(">");
					singularDataType = sbInner.toString();
					dataType = "List<" + singularDataType + ">";
				}
			} else {
				custom = true;
				dataType = rootName;
				singularDataType = dataType;
			}
		}

		private Integer getNumLevels(XmlTagDefinition tag, Integer level) {
			if (tag.getChildren().size() == 0) {
				return level;
			}
			
			level++;
			for (XmlTagInstance child: tag.getChildren()) {
				Integer newLevel = getNumLevels(parser.getTagDefinition(child.getTagName()), level);
				if (newLevel > level) level = newLevel;
			}
			return level;
		}

		private String buildGetterName() {
			StringBuilder sb = new StringBuilder();
			if (tagDefinition.getDataType() == DataType.BOOLEAN)
				sb.append("is");
			else
				sb.append("get");
			sb.append(rootName);
			return sb.toString();
		}

		private String buildSetterName() {
			String setter = null;
			if (numLevels > 0 && !custom)
				setter = "add" + tagNameUtils.singularForm(rootName);
			else
				setter = "set" + rootName;
			return setter;
		}

		public String getterSignature() {
			return dataType + " " + getterName + "()";
		}
		
		public String setterSignature() {
			 return "void " + setterName + "(" + singularDataType + " " + setterVarName() + ")";
		}
		
		public String setterVarName() {
			if (numLevels > 0 && !custom)
				return tagNameUtils.singularForm(varName);
			else
				return varName;
		}
		
		public Boolean requiresArray() {
			return numLevels > 0;
		}
		
		public Boolean requiresAdapter() {
			return numLevels > 1;
		}
		
		public Boolean isMandatory() {
			return mandatory;
		}
		
		public void setDataType(String dataType) {
			this.dataType = dataType;
		}
		
		public void setSingularDataType(String dataType) {
			this.singularDataType = dataType;
		}
		
	}
	
	private class LeafData {
		
		private String name;
		private String varName;
		private String singularType;
		private String type;

	}

	
}
