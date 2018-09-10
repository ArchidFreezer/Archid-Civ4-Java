package org.archid.civ4.info;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.archid.civ4.info.era.EraInfos;
import org.archid.civ4.info.tech.TechInfos;
import org.archid.civ4.info.unit.UnitInfos;

public class InfosFactory {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(InfosFactory.class.getName());
	
	public static enum EInfos { ERA_INFOS, TECH_INFOS, UNIT_INFOS	}

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
		case UNIT_INFOS:
			infos = (T) new UnitInfos();
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
		case UNIT_INFOS:
			jaxbContext = JAXBContext.newInstance(UnitInfos.class);
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
			}
					
		} catch (JAXBException e) {
			log.error("Error marshalling the xml file", e);
		}
	}
}
