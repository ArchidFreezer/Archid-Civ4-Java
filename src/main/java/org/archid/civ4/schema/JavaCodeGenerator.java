package org.archid.civ4.schema;

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
import org.archid.civ4.schema.XmlTagDefinition.DataType;
import org.archid.utils.FileUtils;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;
import org.archid.utils.StringUtils;

public class JavaCodeGenerator {

	/** Logging facility */
	static Logger log = Logger.getLogger(JavaCodeGenerator.class.getName());
	
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

	public JavaCodeGenerator(SchemaParser parser) {
		this.parser = parser;
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
		imports.add("import org.archid.civ4.info.DefaultXmlFormatter;");
		imports.add("import org.archid.civ4.info.EInfo;");
		imports.add("import org.archid.civ4.info.IInfos;");

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
		file.append(NEWLINE + "public class " + infoNameRoot + "Importer extends AbstractImporter<IInfos<I" + infoName + ">, I" + infoName + "> {");
		file.append(NEWLINE);
		file.append(NEWLINET + "/** Logging facility */");
		file.append(NEWLINET + "static Logger log = Logger.getLogger(" + infoNameRoot + "Importer.class.getName());");
		file.append(NEWLINE);
		file.append(NEWLINET + "public " + infoNameRoot + "Importer(EInfo infoEnum) {");
		file.append(NEWLINETT + "super(infoEnum, new DefaultXmlFormatter(\"" + infoNameRoot + "\"));");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "public String getListSheetName() {");
		file.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SHEETNAME_LIST;");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "protected I" + infoName + " parseRow(Row row) {");
		file.append(NEWLINETT + "int colNum = 0;");
		file.append(NEWLINETT + "String type = row.getCell(colNum++).getStringCellValue();");
		file.append(NEWLINETT + "// Handle cells that have been moved");
		file.append(NEWLINETT + "if (type.isEmpty())");
		file.append(NEWLINETTT + "return null;");
		file.append(NEWLINE + "");
		file.append(NEWLINETT + "I" + infoName + " info = " + infoName + "s.createInfo(type);");

		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			if (mainChild.getTagName().equals("Type"))
					continue;
			
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (tag.requiresArray()) {
				if (tag.leaves.size() == 1) {
					if (tag.requiresArray()) {
						file.append(NEWLINETT + "parseListCell(row.getCell(colNum++), " + tag.singularDataType + ".class, info::" + tag.setterName + ");");
					} else {
						file.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.dataType + ".class, info::" + tag.setterName + ");");
					}
				} else if (tag.leaves.size() == 2) { 
					file.append(NEWLINETT + "parsePairsCell(row.getCell(colNum++), " + tag.leaves.get(0).type + ".class, " + tag.leaves.get(1).type + ".class, info::" + tag.setterName + ");");
				} else if (tag.leaves.size() == 3) {
					file.append(NEWLINETT + "parseTriplesCell(row.getCell(colNum++), " + tag.leaves.get(0).type + ".class, " + tag.leaves.get(1).type + ".class, " + tag.leaves.get(2).type + ".class, info::" + tag.setterName + ");");
				}
			} else {
				file.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.dataType + ".class, info::" + tag.setterName + ");");					
			}
		}
		
		file.append(NEWLINE);
		file.append(NEWLINETT + "return info;");
		file.append(NEWLINET + "}");
		file.append(NEWLINE + "}");

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
		file.append(packageDef);
		file.append(NEWLINE);
		// Sort the imports
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(NEWLINE);
		file.append(NEWLINE + "public class " + infoNameRoot + "Exporter extends AbstractExporter<IInfos<I" + infoName + ">, I" + infoName + "> {");
		file.append(NEWLINE);
		file.append(NEWLINET + "/** Logging facility */");
		file.append(NEWLINET + "static Logger log = Logger.getLogger(" + infoNameRoot + "Exporter.class.getName());");
		file.append(NEWLINE);
		file.append(NEWLINET + "public " + infoNameRoot + "Exporter(EInfo infoEnum) {");
		file.append(NEWLINETT + "super(infoEnum);");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "public List<String> getHeaders() {");
		file.append(NEWLINETT + "List<String> headers = new ArrayList<String>();");
		file.append(NEWLINETT + "for (SheetHeaders header: SheetHeaders.values()) {");
		file.append(NEWLINETTT + "headers.add(header.toString());");
		file.append(NEWLINETT + "}");
		file.append(NEWLINETT + "return headers;");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "protected int getNumCols() {");
		file.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SheetHeaders.values().length;");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "protected String getInfoListSheetName() {");
		file.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SHEETNAME_LIST;");
		file.append(NEWLINET + "}");
		file.append(NEWLINE);
		file.append(NEWLINET + "@Override");
		file.append(NEWLINET + "protected void populateRow(Row row, I" + infoName + " info) {");
		file.append(NEWLINETT + "int maxHeight = 1;");
		file.append(NEWLINETT + "int colNum = 0;");
		for (XmlTagInstance mainChild : topLevelTagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			if (tag.requiresArray()) {
				if (tag.leaves.size() == 1) {
					file.append(NEWLINETT + "maxHeight = addRepeatingCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				} else if (tag.leaves.size() == 2) { 
					file.append(NEWLINETT + "maxHeight = addRepeatingPairCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				} else if (tag.leaves.size() == 3) {
					file.append(NEWLINETT + "maxHeight = addRepeatingTripleCell(row.createCell(colNum++), info." + tag.getterName + "(), maxHeight);");					
				}
			} else {
				file.append(NEWLINETT + "addSingleCell(row.createCell(colNum++), info." + tag.getterName + "());");					
			}
		}
		
		file.append(NEWLINE);
		file.append(NEWLINETT + "row.setHeightInPoints(maxHeight * row.getSheet().getDefaultRowHeightInPoints());");
		file.append(NEWLINET + "}");
		file.append(NEWLINE + "}");

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
			Tag tag = infoTagData.get(mainChild.getTagName());
			// Process the adapted class
			if (tag.requiresAdapter()) {
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
			if (tag.requiresAdapter()) {
				customAdapters.append(NEWLINE);
				customAdapters.append(NEWLINET + "private static class Adapted" + mainChild.getTagName() + " {");
				for (LeafData leaf: tag.leaves) {
					customAdapters.append(NEWLINETT + "@XmlElement(name=\"" + leaf.name + "\")");
					customAdapters.append(NEWLINETT + "private " + getXmlDataType(leaf.type) + " " + leaf.varName + ";");
				}
				customAdapters.append(NEWLINET + "}");
			}
			
			// Process the unmarshall class
			// The type is set when we instantiated the info class above and has no mutator
			if (!tag.rootName.equals("Type")) {
				if (tag.requiresAdapter()) {
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
					unmarshalClass.append(NEWLINETTTTT + "if (StringUtils.hasCharacters(val)) {");
					unmarshalClass.append(NEWLINETTTTTT + "info." + tag.setterName + "(val);");
					unmarshalClass.append(NEWLINETTTTT + "}");
					unmarshalClass.append(NEWLINETTTT + "}");
					unmarshalClass.append(NEWLINETTT + "}");
				} else {
					unmarshalClass.append(NEWLINETTT + "info." + tag.setterName + "(JaxbUtils.unmarshall" + tag.dataType + "(aInfo." + tag.varName + "));");
				}
			}
			
			// Process the marshall class
			if (!tag.rootName.equals("Type")) {
				if (tag.requiresAdapter()) {
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
			row.append(StringUtils.uCaseSplit(tag.rootName, '_'));
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
			vars.append(NEWLINETT + "private " + tag.dataType + " " + tag.varName + ";");
			methods.append(NEWLINE);
			methods.append(NEWLINETT + "@Override");
			methods.append(NEWLINETT + "public " + tag.dataType + " " + tag.getterName + "() {");
			methods.append(NEWLINETTT + "return " + tag.varName + ";");
			methods.append(NEWLINETT + "}");
			methods.append(NEWLINE);
			methods.append(NEWLINETT + "@Override");
			methods.append(NEWLINETT + "public " + tag.setterSignature() + " {");
			if (tag.requiresArray())
				methods.append(NEWLINETTT + tag.varName + ".add(" + tag.setterVarName() + ");");
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
			Tag tag = infoTagData.get(mainChild.getTagName());
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

	private void init(String infoTopLevelTag) {
		// The tag will be in the form: Civ4SomeValueInfos
		this.infoTopLevelTag = infoTopLevelTag;
		infoNamePlural = infoTopLevelTag.substring(4); // SomeValueInfos
		infoName = infoNamePlural.substring(0,infoNamePlural.length() - 1); // SomeValueInfo
		infoNameRoot = infoName.substring(0,infoName.length() - 4); // SomeValue
		namespaceFolder = infoNameRoot.toLowerCase(); // somevalue
		packageDef = "package org.archid.civ4.info." + namespaceFolder + ";";
		topLevelTagDefinition = parser.getTagDefinition(infoName);
		parseInfo(topLevelTagDefinition);
	}

	private void parseInfo(XmlTagDefinition info) {
		for (XmlTagInstance tag: info.getChildren()) {
			Tag tagData = new Tag(parser.getTagDefinition(tag.getTagName()));
			if (tagData.requiresArray()) dynamicImports.add("import java.util.List;");
			if (tagData.leaves.size() == 2) dynamicImports.add("import org.archid.utils.IPair;");
			if (tagData.leaves.size() == 3) dynamicImports.add("import org.archid.utils.ITriple;");
			infoTagData.put(tag.getTagName(), tagData);
		}
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
		private String rootName = null;      // SomeTag
		private String varName = null;       // someTag
		private String getterName = null;
		private String setterName = null;
		private String dataType = null;
		private String singularDataType = null;
		private Integer numLevels = null;
		private List<LeafData> leaves = new ArrayList<LeafData>(); 
		private Map<String, String> singularMap = new HashMap<String, String>();
		
		
		private Tag(XmlTagDefinition tag) {
			this.tagDefinition = tag;
			populateSingularMap();
			numLevels = getNumLevels(tag, 0);
			rootName = getTagRootName(tagDefinition.getTagName());
			varName = buildJavaVariableName(tagDefinition.getTagName());
			populateLeafData();
			getterName = buildGetterName();
			setterName = buildSetterName();
		}
		
		private void populateSingularMap() {
			singularMap.put("Bonuses", "Bonus");
			singularMap.put("Buildings", "Building");
			singularMap.put("Classes", "Class");
			singularMap.put("Corporations", "Corporation");
			singularMap.put("Events", "Event");
			singularMap.put("Features", "Feature");
			singularMap.put("Improvements", "Improvement");
			singularMap.put("Prereqs", "Prereq");
			singularMap.put("Religions", "Religion");
			singularMap.put("Routes", "Route");
			singularMap.put("Techs", "Tech");
			singularMap.put("Terrains", "Terrain");
			singularMap.put("Types", "Type");
			singularMap.put("Units", "Unit");
		}

		private void populateLeafData() {
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
					leafData.varName = buildJavaVariableName(leaf.getTagName());
					leafData.type = parser.getTagDefinition(leaf.getTagName()).getDataType().getJavaType();
					leafData.singularType = leafData.type;
					leaves.add(leafData);
				}
				if (leaves.size() == 2) {
					sbInner.append("IPair<");
				} else if (leaves.size() == 3) {
					sbInner.append("ITriple<");
				}
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
				
			} else {
				dataType = "*** Unable to determine DataType ***";
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

		private String buildJavaVariableName(String var) {
			
			return StringUtils.lcaseFirstChar(getTagRootName(var));
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

		private String getTagRootName(String tagName) {
			// Check if we need to truncate the fist character
			switch (tagDefinition.getDataType()) {
			case BOOLEAN:
			case INTEGER:
				tagName = tagName.substring(1);
				break;
			default:
				break;
			}
			return tagName;
		}
		
		private String buildSetterName() {
			String setter = null;
			if (numLevels > 0)
				setter = "add" + singularForm(rootName);
			else
				setter = "set" + rootName;
			return setter;
		}

		/**
		 * Attempt to derive a singular form of plural tags
		 * e.g. UnitsRequired -> UnitRequired
		 *      PrereqTechs   -> PrereqTech
		 *      
		 * @param plural TitleCase tag name to derive the plural from
		 * @return String containing derived singular value
		 */
		private String singularForm(String plural) {
			StringBuilder singular = new StringBuilder();
			// First try and split the value assuming TitleCase
			List<String> words = StringUtils.findWordsInMixedCase(plural);
			
			Integer numWordsLeft = words.size();
			for (String word: words) {
				numWordsLeft--;
				if (singularMap.containsKey(word)) {
					singular.append(singularMap.get(word));
				} else if (numWordsLeft == 0 && word.endsWith("s")) {
					singular.append(word.substring(0,word.length() -1));
				} else {
					singular.append(word);
				}
			}
			return singular.toString(); 
		}

		public String getterSignature() {
			return dataType + " " + getterName + "()";
		}
		
		public String setterSignature() {
			 return "void " + setterName + "(" + singularDataType + " " + setterVarName() + ")";
		}
		
		public String setterVarName() {
			if (numLevels > 0)
				return StringUtils.lcaseFirstChar(singularForm(rootName));
			else
				return StringUtils.lcaseFirstChar(rootName);
		}
		
		public Boolean requiresArray() {
			return numLevels > 0;
		}
		
		public Boolean requiresAdapter() {
			return numLevels > 1;
		}
		
	}
	
	private class LeafData {
		
		private String name;
		private String varName;
		private String singularType;
		private String type;

	}

	
}
