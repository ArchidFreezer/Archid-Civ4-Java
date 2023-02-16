package org.archid.civ4.java;

import java.util.ArrayList;
import java.util.List;

import org.archid.utils.StringUtils;

public abstract class AbstractTagProcessor implements ITagProcessor {
	
	protected final String tagName;
	protected List<String> adapterImports = new ArrayList<String>();
	
	public AbstractTagProcessor (String tagName) {
		this.tagName = tagName;
		addAdapterImports();
	}

	@Override
	public String getTagName() {
		return tagName;
	}
	
	private void addAdapterImports() {
	}
	
	@Override
	public String getDataType() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTagName());
		return sb.toString();
	}
	
	@Override
	public List<String> getAdapterImports() {
		return adapterImports;
	}
	
	@Override
	public String getAdapterElement() {
		StringBuilder sb = new StringBuilder();
		sb.append(NEWLINETT + "@XmlElement(name=\"" + tagName + "\")");
		sb.append(NEWLINETT + "private " + getTagName() + " " + getVarName() + ";");
		return sb.toString();
	}
	
	protected String getVarName() {
		return StringUtils.lCaseFirstChar(tagName);
	}
	
}
