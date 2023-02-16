package org.archid.civ4.java;

import java.util.Map;
import java.util.Set;

public interface IInfoTagProcessor {

	public void init(String packageName);
	public boolean hasTagProcessor(String tag);
	public ITagProcessor getTagProcessor(String tag);
	public String getXmlFormatter();
	public Integer getTypeTagIndex();
	public Set<String> getExportImports();
	public Set<String> getImportImports();
	public Map<String, String> getFilesToWrite();
}
