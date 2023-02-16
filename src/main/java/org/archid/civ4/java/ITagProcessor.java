package org.archid.civ4.java;

import java.util.Map;
import java.util.Set;

public interface ITagProcessor {

	final String NEWLINE = System.getProperty("line.separator");
	final String NEWLINET = NEWLINE + "\t";
	final String NEWLINETT = NEWLINE + "\t\t";
	final String NEWLINETTT = NEWLINE + "\t\t\t";
	final String NEWLINETTTT = NEWLINE + "\t\t\t\t";
	final String NEWLINETTTTT = NEWLINE + "\t\t\t\t\t";
	final String NEWLINETTTTTT = NEWLINE + "\t\t\t\t\t\t";
	final String NEWLINETTTTTTT = NEWLINE + "\t\t\t\t\t\t\t";

	String getTagName();
	String getDataType();

	Set<String> getAdapterImports();
	Set<String> getExporterImports();
	Set<String> getImporterImports();
	Map<String, String> getFilesToWrite();

	String getAdapterElement();

	String getUnmarshallString();

	String getMarshallString();
	
	String getImporterRow();
	String getImporterCellReader();

	String getExporterRow();
	String getExporterCellWriter();
}