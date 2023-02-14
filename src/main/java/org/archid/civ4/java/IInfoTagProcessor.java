package org.archid.civ4.java;

public interface IInfoTagProcessor {

	public void init(String packageName);
	public boolean hasTagProcessor(String tag);
	public ITagProcessor getTagProcessor(String tag);
	public String getXmlFormatter();
	public Integer getTypeTagIndex();

}
