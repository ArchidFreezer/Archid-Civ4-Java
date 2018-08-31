package org.archid.civ4.info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.archid.civ4.info.era.EraInfos;
import org.archid.civ4.info.techinfo.TechInfos;
import org.archid.civ4.utils.StringUtils;

public class InfosFactory {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(InfosFactory.class.getName());
	
	public static enum EInfos { TECH_INFOS, ERA_INFOS	}

	private static String newline = System.getProperty("line.separator");
	
	@SuppressWarnings("unchecked")
	public static <T extends IInfos<S>, S extends IInfo> T getInfos(EInfos infoType) {
		T infos = null;
		switch(infoType) {
		case TECH_INFOS:
			infos = (T) new TechInfos();
			break;
		case ERA_INFOS:
			infos = (T) new EraInfos();
			break;
		default:
			log.error("Error getting infos file: unknown info type");
			break;
		}
		return infos;
	}

	private static JAXBContext getContext(EInfos infoType) throws JAXBException {
		JAXBContext jaxbContext = null;
		switch (infoType) {
		case TECH_INFOS:
			jaxbContext = JAXBContext.newInstance(TechInfos.class);
			break;
		case ERA_INFOS:
			jaxbContext = JAXBContext.newInstance(EraInfos.class);
			break;
		default:
			log.error("Error reading infos file: unknown info type");
			break;
		}
		return jaxbContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends IInfos<S>, S extends IInfo> T readInfos(EInfos infoType, String xmlPath) {

		T infos = null;

		try {
			// Initialise the context
			JAXBContext jaxbContext = getContext(infoType);
			
			// Read the infos
			if (jaxbContext != null) {
				File input = new File(xmlPath);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				infos = (T) jaxbUnmarshaller.unmarshal(input);
			}
		} catch (JAXBException e) {
			log.error("Error unmarshalling the xml file", e);
		}
		return infos;
	}
	
	public static <T extends IInfos<S>, S extends IInfo> void writeInfos(EInfos infoType, String xmlPath, T infos) {
		try {
			// Initialise the context
			JAXBContext jaxbContext = getContext(infoType);
			
			// write the infos
			if (jaxbContext != null) {
				File output = new File(xmlPath);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
				jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\"?>");
				jaxbMarshaller.marshal(infos, output);
				tabifyAndComment(xmlPath, 4);
			}
					
		} catch (JAXBException e) {
			log.error("Error marshalling the xml file", e);
		}
	}
	
	private static void tabifyAndComment(String filePath, int count) {
		
		Pattern patternInfoStart = Pattern.compile(".*<[a-zA-Z]+Info>\\s*");
		Pattern patternType = Pattern.compile(".*<Type>([a-zA-Z0-9_]+).*");
		
		
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
