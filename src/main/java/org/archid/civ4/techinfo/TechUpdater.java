package org.archid.civ4.techinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;

public class TechUpdater {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(TechUpdater.class.getName());
	
	private static String newline = System.getProperty("line.separator");
	
	private IPropertyHandler props = PropertyHandler.getInstance();
	
	
	public void processInfoFile() {
		Pattern pattern = Pattern.compile(ITechInfoConstants.STYLE_REGEX_TECH_TAG_START);
		try {
			BufferedReader reader = getInputFile();
			BufferedWriter writer = getOutputFile();
			String line = "";
			while((line = reader.readLine()) != null)
			{
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches())
				{
					// Do stuff
				}
				writer.write(line + newline);
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			log.error("Cannot find file to update", e);
		} catch (IOException e) {
			log.error("Cannot update XML file", e);
		}
	}
	
	
	private BufferedReader  getInputFile() throws IOException {
		String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String copyFile = filepath + "." + sdf.format(cal.getTime());

		File source = new File(copyFile);
		FileUtils.moveFile(new File(filepath), source);
		FileReader reader = new FileReader(source);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}
	
	private BufferedWriter getOutputFile() throws IOException {
		String filepath = props.getAppProperty(TechUtilsPropertyKeys.PROPERTY_KEY_TECHINFO_FILE);
		File file = new File(filepath);
		FileUtils.touch(file);
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		return bufferedWriter;
		
	}
	
}
