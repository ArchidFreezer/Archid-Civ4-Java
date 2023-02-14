package org.archid.civ4.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultInfoTagProcessor implements IInfoTagProcessor {
	
	private Map<String, ITagProcessor> tags = new HashMap<String, ITagProcessor>();
	protected String packageName;
	protected List<String> exportImports = new ArrayList<String>();
	protected List<String> importImports = new ArrayList<String>();
	

	@Override
	public boolean hasTagProcessor(String tag) {
		return tags.containsKey(tag);
	}

	@Override
	public ITagProcessor getTagProcessor(String tag) {
		return tags.get(tag);
	}
	
	public void addTagProcessor(ITagProcessor tag) {
		tags.put(tag.getTagName(), tag);
	}

	@Override
	public void init(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String getXmlFormatter() {
		return "DefaultXmlFormatter(\"" + packageName + "\")";
	}

	@Override
	public Integer getTypeTagIndex() {
		return 0;
	}
	
	@Override
	public List<String> getExportImports() {
		return exportImports;
	}
	
	@Override
	public List<String> getImportImports() {
		return importImports;
	}
	
}
