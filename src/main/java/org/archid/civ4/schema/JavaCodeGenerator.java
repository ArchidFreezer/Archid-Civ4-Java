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
	
	private String namespaceFolder = null; // somevalue
	private String infoName = null;        // SomeValueInfo
	private String infoNameRoot = null;    // SomeValue
	private String infoNamePlural = null;  // SomeValueInfos
	private String infoTopLevelTag = null; // Civ4SomeValueInfos
	private String packageDef = null;
	private XmlTagDefinition tagDefinition = null;
	private SchemaParser parser = null;
	private IPropertyHandler props = PropertyHandler.getInstance();
	Set<String> commonImports = new HashSet<String>();
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
		
	}
	
	private void createInfoInterface() {
		
		StringBuilder file = new StringBuilder();
		file.append(packageDef + NEWLINE);
		
		// Sort the imports, this is cosmetic, but easy enough
		List<String> imports = new ArrayList<String>(commonImports);
		imports.add("import org.archid.civ4.info.IInfo;");
		Collections.sort(imports);
		for (String imp: imports) {
			file.append(NEWLINE + imp);
		}
		file.append(NEWLINE + NEWLINE + "public interface I" + infoName + " extends IInfo {");
		for (XmlTagInstance mainChild : tagDefinition.getChildren()) {
			Tag tag = infoTagData.get(mainChild.getTagName());
			file.append(NEWLINE + "\t" + tag.getterSignature() + ";");
			file.append(NEWLINE + "\t" + tag.setterSignature() + ";");
			file.append(NEWLINE);
		}
		file.append(NEWLINE + "}");
		
		writeFile("I" + infoName + ".java", file.toString());
	}

	private void createPackageInfoFile() {
		StringBuilder sb = new StringBuilder();
		sb.append("@javax.xml.bind.annotation.XmlSchema(namespace=\"x-schema:" + props.getAppProperty(PropertyKeys.PROPERTY_KEY_MOD_SCHEMA) + "\", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)"
				+ NEWLINE + packageDef);
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
		tagDefinition = parser.getTagDefinition(infoName);
		parseInfo(tagDefinition);
	}

	private void parseInfo(XmlTagDefinition info) {
		for (XmlTagInstance tag: info.getChildren()) {
			Tag tagData = new Tag(parser.getTagDefinition(tag.getTagName()));
			if (tagData.requiresArray()) commonImports.add("import java.util.List;");
			if (tagData.numLeaves == 2) commonImports.add("import org.archid.utils.IPair;");
			if (tagData.numLeaves == 3) commonImports.add("import org.archid.utils.ITriple;");
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
	
	private class Tag {
		
		private XmlTagDefinition tag = null;
		private String varName = null;
		private String getterName = null;
		private String setterName = null;
		private String dataType = null;
		private String singularDataType = null;
		private Integer numLeaves = null;
		private Integer numLevels = null;
		private Map<String, String> singularMap = new HashMap<String, String>();
		
		
		private Tag(XmlTagDefinition tag) {
			this.tag = tag;
			populateSingularMap();
			numLevels = getNumLevels(tag, 0);
			populateDataTypes();
			varName = buildJavaVariableName();
			getterName = buildGetterName();
			setterName = buildSetterName();
		}
		
		private void populateSingularMap() {
			singularMap.put("Bonuses", "Bonus");
			singularMap.put("Buildgings", "Building");
			singularMap.put("Classes", "Class");
			singularMap.put("Corporations", "Corporation");
			singularMap.put("Events", "Ecent");
			singularMap.put("Improvements", "Improvement");
			singularMap.put("Prereqs", "Prereq");
			singularMap.put("Religions", "Religion");
			singularMap.put("Routes", "Route");
			singularMap.put("Techs", "Tech");
			singularMap.put("Terrains", "Terrain");
			singularMap.put("Types", "Type");
			singularMap.put("Units", "Unit");
		}

		private void populateDataTypes() {
			if (numLevels == 0) {
				dataType = tag.getDataType().getJavaType();
				singularDataType = dataType;
				numLeaves = 1;
			} else if (numLevels == 1) {
				singularDataType = parser.getTagDefinition(tag.getChildren().get(0).getTagName()).getDataType().getJavaType();
				dataType = "List<" + singularDataType + ">";
				numLeaves = 1;
			} else if (numLevels == 2) {
				StringBuilder sbInner = new StringBuilder();
				// We need to drop down to the bottom level to determine how many leaf tags there are
				XmlTagDefinition wrapper = parser.getTagDefinition(tag.getChildren().get(0).getTagName());
				List<String> leafTypes = new ArrayList<String>();
				for (XmlTagInstance leaf: wrapper.getChildren()) {
					leafTypes.add(parser.getTagDefinition(leaf.getTagName()).getDataType().getJavaType());
				}
				if (leafTypes.size() == 2) {
					numLeaves = 2;
					sbInner.append("IPair<");
				} else if (leafTypes.size() == 3) {
					numLeaves = 3;
					sbInner.append("ITriple<");
				}
				Boolean first = true;
				for (String type: leafTypes) {
					if (first) {
						first = false;
					} else {
						sbInner.append(", ");
					}
					sbInner.append(type);
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
			if (tag.getChildren().size() == 0)
				return level;
			
			level++;
			for (XmlTagInstance child: tag.getChildren()) {
				Integer newLevel = getNumLevels(parser.getTagDefinition(child.getTagName()), level);
				if (newLevel > level) level = newLevel;
			}
			return level;
		}

		private String buildJavaVariableName() {
			return StringUtils.lcaseFirstChar(getTagRootName());
		}

		private String buildGetterName() {
			StringBuilder sb = new StringBuilder();
			if (tag.getDataType() == DataType.BOOLEAN)
				sb.append("is");
			else
				sb.append("get");
			sb.append(getTagRootName());
			return sb.toString();
		}

		private String getTagRootName() {
			String tagName = tag.getTagName();
			// Check if we need to truncate the fist character
			switch (tag.getDataType()) {
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
				setter = "add" + singularForm(getTagRootName());
			else
				setter = "add" + getTagRootName();
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

		public String dataType() {
			return dataType;
		}
		
		public String javaVariableName() {
			return varName;
		}
		
		public String getterSignature() {
			return dataType + " " + getterName + "()";
		}
		
		public String setterSignature() {
			StringBuilder sb = new StringBuilder();
			sb.append("void " + setterName + "(" + singularDataType + " ");
			if (numLevels > 0)
				sb.append(StringUtils.lcaseFirstChar(singularForm(getTagRootName())));
			else
				sb.append(StringUtils.lcaseFirstChar(getTagRootName()));
			sb.append(")");
			return sb.toString();
		}
		
		public Integer numLeaves() {
			return numLeaves;
		}
		
		public String getterName() {
			return getterName;
		}
		
		public String setterName() {
			return setterName;
		}
		
		public Boolean requiresArray() {
			return numLevels == 1;
		}
		
		public Boolean requiresAdapter() {
			return numLevels > 1;
		}
		
	}
	
	
}
