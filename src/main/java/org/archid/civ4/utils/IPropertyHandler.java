package org.archid.civ4.utils;

public interface IPropertyHandler {

	String getAppProperty(String property);

	String getProperty(String file, String property);

	String getAppProperty(String property, String defaultVal);

	String getProperty(String file, String property, String defaultVal);

	void setAppProperty(String property, String value);

	void setProperty(String file, String property, String value);

	boolean hasProperty(String file, String property);

	void save();

	void init();

}