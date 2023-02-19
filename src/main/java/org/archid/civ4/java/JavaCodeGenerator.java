package org.archid.civ4.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.archid.civ4.java.infoprocessor.IInfoProcessor;
import org.archid.civ4.java.infoprocessor.IInfoProcessor.FileCreators;
import org.archid.civ4.java.infoprocessor.IInfoProcessor.InfoOverrides;
import org.archid.civ4.schema.SchemaParser;
import org.archid.civ4.schema.XmlTagInstance;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;

public class JavaCodeGenerator implements IJavaFileContent{

	/** Logging facility */
	static Logger log = Logger.getLogger(JavaCodeGenerator.class.getName());
	
	static final String MANUAL_INTERVENTION = "ManualInterventionRequired";
	
	private IPropertyHandler props = PropertyHandler.getInstance();
	
	public JavaCodeGenerator(SchemaParser parser, String infoTopLevelTag) {
		JavaCodeGeneratorData.getInstance().init(parser, infoTopLevelTag);
	}

	public void createJavaCode() {
		createInfoProcessorCustomFiles();
		createPackageInfo();
		createInfoInterface();
		createInfoClass();
		createInfoWorkbookInterface();
		createInfoMapAdapter();
		createInfoExporter();
		createInfoImporter();
	}
	
	private void createInfoProcessorCustomFiles() {
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		if (infoProcessor != null) {
			for (String filename: infoProcessor.getFilesToWrite().keySet()) {
				writeFile(filename, infoProcessor.getFilesToWrite().get(filename));
			}
		}
	}
	
	private void createInfoImporter() {
		String infoNameRoot = JavaCodeGeneratorData.getInstance().getInfoNameRoot();
		String infoName = JavaCodeGeneratorData.getInstance().getInfoName();
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		// Imports
		Set<String> imports = new HashSet<String>();
		imports.add("import org.apache.log4j.Logger;");
		imports.add("import org.apache.poi.ss.usermodel.Row;");
		imports.add("import org.archid.civ4.info.AbstractImporter;");
		imports.add("import org.archid.civ4.info.EInfo;");
		imports.add("import org.archid.civ4.info.IInfos;");

		// Main content
		StringBuilder mainClass = new StringBuilder();
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINE + "public class " + infoNameRoot + "Importer extends AbstractImporter<IInfos<I" + infoName + ">, I" + infoName + "> {");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "/** Logging facility */");
		mainClass.append(NEWLINET + "static Logger log = Logger.getLogger(" + infoNameRoot + "Importer.class.getName());");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "public " + infoNameRoot + "Importer(EInfo infoEnum) {");
		mainClass.append(NEWLINETT + "super(infoEnum, new " + infoProcessor.getXmlFormatter() + ");");
		mainClass.append(NEWLINET + "}");
		mainClass.append(NEWLINE);
		mainClass.append(NEWLINET + "@Override");
		mainClass.append(NEWLINET + "public String getListSheetName() {");
		mainClass.append(NEWLINETT + "return I" + infoNameRoot + "Workbook.SHEETNAME_LIST;");
		mainClass.append(NEWLINET + "}");
		mainClass.append(getInfoImporterOverrides());
		mainClass.append(NEWLINE + "}");

		// Sort the imports
		imports.addAll(infoProcessor.getImportImports());
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		
		// Build the file
		StringBuilder file = new StringBuilder();
		file.append(JavaCodeGeneratorData.getInstance().getPackageDef());
		file.append(NEWLINE);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(mainClass);
		writeFile(infoNameRoot + "Importer.java", file.toString());
		
	}
	
	private String getInfoImporterOverrides() {
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		if (infoProcessor.hasOverride(InfoOverrides.IMPORTER)) {
			return infoProcessor.getOverride(InfoOverrides.IMPORTER);
		} else {
			return getDefaultInfoImporterOverrides();
		}
	}

	private String getDefaultInfoImporterOverrides() {
		String infoName = JavaCodeGeneratorData.getInstance().getInfoName();
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		
		StringBuilder customCellReaders = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINE);
		sb.append(NEWLINET + "@Override");
		sb.append(NEWLINET + "protected I" + infoName + " parseRow(Row row) {");
		sb.append(NEWLINETT + "int colNum = 0;");
		sb.append(NEWLINETT + "String type = row.getCell(" + infoProcessor.getTypeTagIndex().toString() + ").getStringCellValue();");
		sb.append(NEWLINETT + "// Handle cells that have been moved");
		sb.append(NEWLINETT + "if (type.isEmpty())");
		sb.append(NEWLINETTT + "return null;");
		sb.append(NEWLINE + "");
		sb.append(NEWLINETT + "I" + infoName + " info = " + infoName + "s.createInfo(type);");

		for (XmlTagInstance mainChild : JavaCodeGeneratorData.getInstance().getInfoChildTags()) {
			TagInstance tag = JavaCodeGeneratorData.getInstance().getTagInstance(mainChild.getTagName());
			ITagProcessor tagProcessor = null;
			if (infoProcessor.hasTagProcessor(mainChild.getTagName())) {
				tagProcessor = infoProcessor.getTagProcessor(mainChild.getTagName());
				tag.setDataType(infoProcessor.getTagProcessor(mainChild.getTagName()).getDataType());
			}
			if (tagProcessor != null) {
				sb.append(tagProcessor.getImporterRow());
				customCellReaders.append(tagProcessor.getImporterCellReader());
			} else if (tag.requiresArray()) {
				if (tag.getNumLeaves() == 1) {
					if (tag.requiresArray()) {
						sb.append(NEWLINETT + "parseListCell(row.getCell(colNum++), " + tag.getDataType() + ".class, info::" + tag.getSetterName() + ");");
					} else {
						sb.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.getDataType() + ".class, info::" + tag.getSetterName() + ");");
					}
				} else if (tag.getNumLeaves() == 2) { 
					sb.append(NEWLINETT + "parsePairsCell(row.getCell(colNum++), " + tag.getLeaf(0).getType() + ".class, " + tag.getLeaf(1).getType() + ".class, info::" + tag.getSetterName() + ");");
				} else if (tag.getNumLeaves() == 3) {
					sb.append(NEWLINETT + "parseTriplesCell(row.getCell(colNum++), " + tag.getLeaf(0).getType() + ".class, " + tag.getLeaf(1).getType() + ".class, " + tag.getLeaf(2).getType() + ".class, info::" + tag.getSetterName() + ");");
				}
			} else {
				sb.append(NEWLINETT + "parseCell(row.getCell(colNum++), " + tag.getDataType() + ".class, info::" + tag.getSetterName() + ");");					
			}
		}
		
		sb.append(NEWLINE);
		sb.append(NEWLINETT + "return info;");
		sb.append(NEWLINET + "}");
		sb.append(customCellReaders);
		
		return sb.toString();
	}

	private void createInfoExporter() {
		String infoNameRoot = JavaCodeGeneratorData.getInstance().getInfoNameRoot();
		String infoName = JavaCodeGeneratorData.getInstance().getInfoName();
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();

		// Imports
		Set<String> imports = new HashSet<String>();
		imports.add("import java.util.ArrayList;");
		imports.add("import java.util.List;");
		imports.add("import org.apache.log4j.Logger;");
		imports.add("import org.apache.poi.ss.usermodel.Row;");
		imports.add("import org.archid.civ4.info.AbstractExporter;");
		imports.add("import org.archid.civ4.info.EInfo;");
		imports.add("import org.archid.civ4.info.IInfos;");
		imports.add("import org.archid.civ4.info." + JavaCodeGeneratorData.getInstance().getNamespaceFolder() + ".I" + infoNameRoot + "Workbook.SheetHeaders;");

		// Main content
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
		mainClass.append(getInfoExporterOverrides());
		mainClass.append(NEWLINE + "}");

		// Sort the imports
		imports.addAll(infoProcessor.getExportImports());
		List<String> sortedImports = new ArrayList<String>(imports);
		Collections.sort(sortedImports);
		
		// Build the file
		StringBuilder file = new StringBuilder();
		file.append(JavaCodeGeneratorData.getInstance().getPackageDef());
		file.append(NEWLINE);
		for (String imp: sortedImports) {
			file.append(NEWLINE + imp);
		}
		file.append(mainClass);

		writeFile(infoNameRoot + "Exporter.java", file.toString());
		
	}
	
	private String getInfoExporterOverrides() {
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		if (infoProcessor.hasOverride(InfoOverrides.EXPORTER)) {
			return infoProcessor.getOverride(InfoOverrides.EXPORTER);
		} else {
			return getDefaultInfoExporterOverrides();
		}
	}

	private String getDefaultInfoExporterOverrides() {
		IInfoProcessor infoProcessor = JavaCodeGeneratorData.getInstance().getInfoProcessor();
		StringBuilder customCellWriters = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINE);
		sb.append(NEWLINET + "@Override");
		sb.append(NEWLINET + "protected void populateRow(Row row, I" + JavaCodeGeneratorData.getInstance().getInfoName() + " info) {");
		sb.append(NEWLINETT + "int maxHeight = 1;");
		sb.append(NEWLINETT + "int colNum = 0;");
		for (XmlTagInstance mainChild : JavaCodeGeneratorData.getInstance().getInfoChildTags()) {
			TagInstance tag = JavaCodeGeneratorData.getInstance().getTagInstance(mainChild.getTagName());
			ITagProcessor tagProcessor = null;
			if (infoProcessor.hasTagProcessor(mainChild.getTagName())) {
				tagProcessor = infoProcessor.getTagProcessor(mainChild.getTagName());
				tag.setDataType(tagProcessor.getDataType());
			}
			if (tagProcessor != null) {
				sb.append(tagProcessor.getExporterRow());
				customCellWriters.append(tagProcessor.getExporterCellWriter());
			} else if (tag.requiresArray()) {
				if (tag.getNumLeaves() == 1) {
					sb.append(NEWLINETT + "maxHeight = addRepeatingCell(row.createCell(colNum++), info." + tag.getGetterName() + "(), maxHeight);");					
				} else if (tag.getNumLeaves() == 2) { 
					sb.append(NEWLINETT + "maxHeight = addRepeatingPairCell(row.createCell(colNum++), info." + tag.getGetterName() + "(), maxHeight);");					
				} else if (tag.getNumLeaves() == 3) {
					sb.append(NEWLINETT + "maxHeight = addRepeatingTripleCell(row.createCell(colNum++), info." + tag.getGetterName() + "(), maxHeight);");					
				}
			} else {
				sb.append(NEWLINETT + "addSingleCell(row.createCell(colNum++), info." + tag.getGetterName() + "());");					
			}
		}
		
		sb.append(NEWLINE);
		sb.append(NEWLINETT + "row.setHeightInPoints(maxHeight * row.getSheet().getDefaultRowHeightInPoints());");
		sb.append(NEWLINET + "}");
		sb.append(customCellWriters);
		
		return sb.toString();
	}


	private void createInfoMapAdapter() {
		writeFile(JavaCodeGeneratorData.getInstance().getInfoNameRoot() + "MapAdapter.java", JavaCodeGeneratorData.getInstance().getInfoProcessor().getFileCreator(FileCreators.INFO_MAP_ADAPTER).getFileContent());
	}

	private void createInfoWorkbookInterface() {
		writeFile("I" + JavaCodeGeneratorData.getInstance().getInfoNameRoot() + "Workbook.java", JavaCodeGeneratorData.getInstance().getInfoProcessor().getFileCreator(FileCreators.INFO_WORKBOOK).getFileContent());
	}

	private void createInfoClass() {
		writeFile(JavaCodeGeneratorData.getInstance().getInfoNamePlural() + ".java", JavaCodeGeneratorData.getInstance().getInfoProcessor().getFileCreator(FileCreators.INFO_CODE).getFileContent());
	}

	private void createInfoInterface() {
		writeFile("I" + JavaCodeGeneratorData.getInstance().getInfoName() + ".java", JavaCodeGeneratorData.getInstance().getInfoProcessor().getFileCreator(FileCreators.INFO_INTERFACE).getFileContent());
	}

	private void createPackageInfo() {
		writeFile("package-info.java", JavaCodeGeneratorData.getInstance().getInfoProcessor().getFileCreator(FileCreators.PACKAGE).getFileContent());
	}

	private void writeFile(String fileName, String content) {
		BufferedWriter out = null;
		String filePath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_JAVA_OUTPUT_DIR, ".") + "\\" + JavaCodeGeneratorData.getInstance().getNamespaceFolder() + "\\" + fileName;
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
	
}
