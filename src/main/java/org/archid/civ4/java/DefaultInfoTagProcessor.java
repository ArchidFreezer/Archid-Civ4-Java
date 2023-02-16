package org.archid.civ4.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DefaultInfoTagProcessor implements IInfoTagProcessor {
	
	private Map<String, ITagProcessor> tags = new HashMap<String, ITagProcessor>();
	protected String packageName;
	protected Set<String> exportImports = new HashSet<String>();
	protected Set<String> importImports = new HashSet<String>();
	protected Map<String, String> filesToWrite = new HashMap<String, String>();
	protected TagNameUtils tagNameUtils;
	
	public DefaultInfoTagProcessor(TagNameUtils tagNameUtils) {
		this.tagNameUtils = tagNameUtils;
	}
	

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
		exportImports.addAll(tag.getExporterImports());
		importImports.addAll(tag.getImporterImports());
		filesToWrite.putAll(tag.getFilesToWrite());
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
	public Set<String> getExportImports() {
		return exportImports;
	}
	
	@Override
	public Set<String> getImportImports() {
		return importImports;
	}


	@Override
	public Map<String, String> getFilesToWrite() {
		return filesToWrite;
	}
	
}
