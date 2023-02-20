package org.archid.civ4.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.archid.utils.StringUtils;

public abstract class AbstractTagProcessor implements ITagProcessor {
	
	protected final String tagName;
	protected Set<String> adapterImports = new HashSet<String>();
	protected Set<String> exporterImports = new HashSet<String>();
	protected Set<String> importerImports = new HashSet<String>();
	protected Map<String, String> filesToWrite = new HashMap<String, String>();
	
	public AbstractTagProcessor (String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String getTagName() {
		return tagName;
	}
	
	@Override
	public Set<String> getAdapterImports() {
		return adapterImports;
	}
	
	@Override
	public Set<String> getExporterImports() {
		return exporterImports;
	}
	
	@Override
	public Set<String> getImporterImports() {
		return importerImports;
	}
	
	@Override
	public String getAdapterElement() {
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINETT + "@XmlElement(name=\"" + tagName + "\")");
		sb.append(NEWLINETT + "private " + JavaCodeGeneratorData.getInstance().getTagInstance(tagName).getDataType() + " " + getVarName() + ";");
		return sb.toString();
	}
	
	protected String getVarName() {
		return StringUtils.lCaseFirstChar(tagName);
	}
	
	public Map<String, String> getFilesToWrite() {
		return filesToWrite;
	}
	
}
