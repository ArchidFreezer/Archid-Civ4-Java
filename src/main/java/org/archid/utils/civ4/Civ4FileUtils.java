package org.archid.utils.civ4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.archid.utils.FileUtils;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;

public class Civ4FileUtils {

	/** Logging facility */
	static Logger log = Logger.getLogger(Civ4FileUtils.class.getName());
	
	private static IPropertyHandler props = PropertyHandler.getInstance();

	private static String getOutputFile(String srcName, String ext) {
		String prefix = props.hasProperty(PropertyKeys.PROPERTY_KEY_FILE_PREFIX) ? props.getAppProperty(PropertyKeys.PROPERTY_KEY_FILE_PREFIX) : "";
		String fileName = FilenameUtils.getBaseName(srcName);
		return getOutputDir() + prefix + fileName + "." + ext;
	}
	
	public static String getOutputDir() {
		String outputDir = "";
		if (props.hasProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR)) {
			outputDir = FilenameUtils.normalizeNoEndSeparator(props.getAppProperty(PropertyKeys.PROPERTY_KEY_OUTPUT_DIR)) + File.separator;
		} else {
			outputDir = FilenameUtils.getFullPath(props.getAppProperty(PropertyKeys.PROPERTY_KEY_FILE_INFOS));
		}
		return outputDir;
	}
	
	public static String prepareOutputFile(String srcName) throws IOException {
		return prepareOutputFile(srcName, FilenameUtils.getExtension(srcName));
	}
	
	public static String prepareOutputFile(String srcName, String ext) throws IOException {
		String outputFile = Civ4FileUtils.getOutputFile(srcName, ext);
		if (!FileUtils.ensureDirExists(Civ4FileUtils.getOutputDir()))	throw new IOException("Output directory " + Civ4FileUtils.getOutputDir() + " does not exist and cannot be created");
		FileUtils.backupFile(outputFile);
		return outputFile;
	}
	
}
