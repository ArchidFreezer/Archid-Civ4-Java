package org.archid.civ4.java;

import java.util.List;

public interface IInfoTagProcessor {

	public void init(String packageName);
	public boolean hasTagProcessor(String tag);
	public ITagProcessor getTagProcessor(String tag);
	public String getXmlFormatter();
	public Integer getTypeTagIndex();
	public List<String> getExportImports();
	public List<String> getImportImports();
}
