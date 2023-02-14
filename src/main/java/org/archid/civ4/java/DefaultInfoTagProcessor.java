package org.archid.civ4.java;

import java.util.HashMap;
import java.util.Map;

public class DefaultInfoTagProcessor implements IInfoTagProcessor {
	
	private Map<String, ITagProcessor> tags = new HashMap<String, ITagProcessor>();
	protected String packageName;

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
	
}
