package org.archid.civ4.java;

import java.util.ArrayList;
import java.util.List;

import org.archid.utils.StringUtils;

public abstract class AbstractTagProcessor implements ITagProcessor {
	
	private final String packagePath;
	protected final String tagName;
	private Boolean list;
	protected List<String> adapterImports = new ArrayList<String>();
	protected List<String> exportImports = new ArrayList<String>();
	protected List<String> importImports = new ArrayList<String>();
	
	public AbstractTagProcessor (String tagName, String packageName) {
		this(tagName, packageName, true);
	}

	public AbstractTagProcessor (String tagName, String packageName, Boolean isList) {
		this.tagName = tagName;
		list = isList;
		this.packagePath = "org.archid.civ4.info" + "." + packageName;
		addAdapterImports();
	}

	@Override
	public String getTagName() {
		return tagName;
	}
	
	@Override
	public void setList(Boolean isList) {
		list = isList;
	}
	
	private void addAdapterImports() {
		adapterImports.add("import " + packagePath + "." + getSingularTagName() + "Adapter.Adapted" + getSingularTagName() + ";");
		if (list)
			adapterImports.add("import " + packagePath + "." + getSingularTagName() + "Adapter." + getSingularTagName() + "List;");
	}
	
	protected String getSingularTagName() {
		StringBuilder sb = new StringBuilder();
		if (list)
			sb.append(tagName.substring(0, tagName.length() - 1));
		else
			sb.append(tagName);
		return sb.toString();
	}
	
	@Override
	public String getDataType() {
		StringBuilder sb = new StringBuilder();
		if (list) sb.append("List<");
		sb.append(getInterfaceName());
		if (list) sb.append(">");
		return sb.toString();
	}
	
	@Override
	public String getInterfaceName() {
		return "I" + getSingularTagName();
	}
	
	@Override
	public List<String> getAdapterImports() {
		return adapterImports;
	}
	
	@Override
	public String getAdapterElement() {
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINETT + "@XmlElement(name=\"" + tagName + "\")");
		sb.append(NEWLINETT + "private " + getSingularTagName() + "List " + getVarName() + ";");
		return sb.toString();
	}
	
	@Override
	public List<String> getExportImports() {
		return exportImports;
	}
	
	@Override
	public List<String> getImportImports() {
		return importImports;
	}
	
	protected String getVarName() {
		return StringUtils.lcaseFirstChar(tagName);
	}
	
}
