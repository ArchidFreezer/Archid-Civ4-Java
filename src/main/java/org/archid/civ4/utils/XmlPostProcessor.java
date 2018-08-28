/**
 * 
 */
package org.archid.civ4.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author Jim
 *
 */
public class XmlPostProcessor {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(XmlPostProcessor.class.getName());

	private static String newline = System.getProperty("line.separator");

	public static String tabify(BufferedReader input, int count) {
		StringBuffer replace = new StringBuffer();
		for (int i = 0; i < count; i++) {
			replace.append("\\s");
		}
		
		StringBuffer output = new StringBuffer();
		
		String line = "";
		try {
			while ((line = input.readLine()) != null) {
				output.append(line.replaceAll(replace.toString(), "\t") + newline);
			}
		} catch (IOException e) {
			log.error("Could not access the file", e);
		}
		
		return output.toString();
	}

	public static void tabifyAndComment(String filePath, int count) {
		
		Pattern patternInfoStart = Pattern.compile(".*<[a-zA-Z]+Info>\\s*");
		Pattern patternType = Pattern.compile(".*<Type>([a-zA-Z_]+).*");
		
		
		StringBuffer replace = new StringBuffer();
		for (int i = 0; i < count; i++) {
			replace.append("\\s");
		}
		
		StringBuffer outputString = new StringBuffer();
		
		File xmlFile = new File(filePath);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(xmlFile));
			String infoLine = "";
			String line = "";
			while ((line = reader.readLine()) != null) {
				line = line.replaceAll(replace.toString(), "\t");
				Matcher matcher = patternInfoStart.matcher(line);
				if (matcher.matches()) {
					infoLine = line;
					continue;
				}
				
				matcher = patternType.matcher(line);
				if (matcher.matches()) {
					String type = StringUtils.startCaseSpace(matcher.group(1).substring(matcher.group(1).indexOf('_') + 1), '_');
					outputString.append(infoLine + " <!-- " + type + " -->" + newline);
					outputString.append(line + newline);
					continue;
				}
				
				outputString.append(line + newline);
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(xmlFile));
			writer.write(outputString.toString());
			writer.close();
			
		} catch (IOException e) {
			log.error("Could not access the file", e);
		}
	}

}
