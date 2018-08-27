package org.archid.civ4.xml.techinfo;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import org.archid.civ4.utils.KeyValuePair;

public class Tester {
	
	private JAXBContext jaxbContext;
	
	public Tester() {
		try {
			jaxbContext = JAXBContext.newInstance(TechInfos.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Tester tester = new Tester();
		try {
			tester.buildTechs();
			tester.readTechs();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buildTechs() throws JAXBException, XMLStreamException, FactoryConfigurationError {
		
		TechInfos infos = new TechInfos();
		
		ITechInfo info = TechInfos.createTech("TECH_TYPE_1");
		info.setDescription("Description 1");
		info.setHelp("Help 1");
		info.setCivilopedia("Civilopedia 1");
		info.setType("Type 1");
		info.setAiWeight(5);
		info.setAdvancedStartCost(0);
		info.setCanPassPeaks(true);
		info.setRiverTrade(true);
		info.addCommerceFlexible(false);
		info.addCommerceFlexible(true);
		info.addTerrainTrade("Terrain 1");
		infos.addTech(info);
		
		info = TechInfos.createTech("TECH_TYPE_2");
		info.setDescription("Description 2");
		info.setCivilopedia("Civilopedia 2");
		info.setType("Type 2");
		info.addDomainExtraMove(new KeyValuePair<String, Integer>("Domain 1", 5));
		info.addDomainExtraMove(new KeyValuePair<String, Integer>("Domain 2", 7));
		infos.addTech(info);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\"?>");
		jaxbMarshaller.marshal(infos, System.out);
	}

	private void readTechs() throws JAXBException {
		File file = new File("E:/Projects/Civ4/tools/Java/Civ4TechInfos.xml");
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		TechInfos infos = (TechInfos) jaxbUnmarshaller.unmarshal(file);
		ITechInfo info = infos.getTech("TECH_WOODWORKING");
		System.out.println(info);
	}
}
