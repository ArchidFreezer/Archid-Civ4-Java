package org.archid.civ4.info;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.archid.civ4.info.techinfo.TechInfos;
import org.archid.civ4.utils.XmlPostProcessor;

public class InfosFactory {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(InfosFactory.class.getName());
	
	public enum EInfos { TECH_INFOS	}


	@SuppressWarnings("unchecked")
	public static <T extends IInfos<S>, S extends IInfo> T getInfos(EInfos infoType, String xmlPath) {
		
		T infos = null;
		
		try {
			switch (infoType) {
			case TECH_INFOS:
				JAXBContext jaxbContext = JAXBContext.newInstance(TechInfos.class);
				File input = new File(xmlPath);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				infos = (T) jaxbUnmarshaller.unmarshal(input);
			default:
				break;
			}
					
		} catch (JAXBException e) {
			log.error("Error unmarshalling the xml file", e);
		}
		return infos;
	}
	
	public static <T extends IInfos<S>, S extends IInfo> void writeInfos(EInfos infoType, String xmlPath, T infos) {
		try {
			switch (infoType) {
			case TECH_INFOS:
				JAXBContext jaxbContext = JAXBContext.newInstance(TechInfos.class);
				File output = new File(xmlPath);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
				jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\"?>");
				jaxbMarshaller.marshal(infos, output);
				XmlPostProcessor.tabifyAndComment(xmlPath, 4);
			default:
				break;
			}
					
		} catch (JAXBException e) {
			log.error("Error marshalling the xml file", e);
		}
	}
	
}
