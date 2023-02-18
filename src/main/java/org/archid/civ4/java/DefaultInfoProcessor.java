package org.archid.civ4.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DefaultInfoProcessor implements IInfoProcessor {
	
	private Map<String, ITagProcessor> tags = new HashMap<String, ITagProcessor>();
	protected String packageName;
	protected Set<String> exportImports = new HashSet<String>();
	protected Set<String> importImports = new HashSet<String>();
	protected Map<String, String> filesToWrite = new HashMap<String, String>();
	protected Map<InfoOverrides, String> overrides = new HashMap<InfoOverrides, String>();
	protected TagNameData tagNameData;
	
	public DefaultInfoProcessor(TagNameData tagNameData) {
		this.tagNameData = tagNameData;
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
	
	protected DefaultResourceArrayTagProcessorData getTagData(String outer, String wrapper, String resource, String list, String element) {
		DefaultResourceArrayTagProcessorData tagData = new DefaultResourceArrayTagProcessorData();
		tagData.outer = outer;
		tagData.wrapper = wrapper;
		tagData.resource = resource;
		tagData.list = list;
		tagData.element = element;
		return tagData;
	}


	@Override
	public boolean hasOverride(InfoOverrides override) {
		return overrides.containsKey(override);
	}


	@Override
	public String getOverride(InfoOverrides override) {
		return hasOverride(override) ? overrides.get(override) : "";
	}


}
