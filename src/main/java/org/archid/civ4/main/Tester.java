package org.archid.civ4.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.info.techinfo.ITechInfo;
import org.archid.civ4.info.techinfo.TechInfos;
import org.archid.civ4.utils.KeyValuePair;
import org.archid.civ4.utils.XmlPostProcessor;

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
//			tester.buildTechs();
//			tester.readTechs();
//			tester.test2();
//			tester.test3();
			tester.test4();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buildTechs() throws JAXBException, XMLStreamException, FactoryConfigurationError {
		
		IInfos<ITechInfo> infos = new TechInfos();
		
		ITechInfo info = TechInfos.createInfo("TECH_TYPE_1");
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
		info.addFlavor(new KeyValuePair<String, Integer>("FLAVOR_MILITARY", 7));
		info.addFlavor(new KeyValuePair<String, Integer>("FLAVOR_SCIENCE", 1));
		info.addFlavor(new KeyValuePair<String, Integer>("FLAVOR_GOLD", 2));
		infos.addInfo(info);
		
		info = TechInfos.createInfo("TECH_TYPE_2");
		info.setDescription("Description 2");
		info.setCivilopedia("Civilopedia 2");
		info.setType("Type 2");
		info.addDomainExtraMove(new KeyValuePair<String, Integer>("Domain 1", 5));
		info.addDomainExtraMove(new KeyValuePair<String, Integer>("Domain 2", 7));
		infos.addInfo(info);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\"?>");
		jaxbMarshaller.marshal(infos, System.out);
	}

	@SuppressWarnings("unchecked")
	private void readTechs() throws Exception {
		File input = new File("E:/Projects/Civ4/tools/Java/Civ4TechInfos.xml");
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		IInfos<ITechInfo> infos = (IInfos<ITechInfo>) jaxbUnmarshaller.unmarshal(input);
		ITechInfo info = infos.getInfo("TECH_WOODWORKING");
		info.setCanPassPeaks(true);
		infos.addInfo(info);
		
		File output = new File("E:/Projects/Civ4/tools/Java/Out-Civ4TechInfos.xml");
		DOMResult domResult = new DOMResult();
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.marshal(infos, domResult);
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.transform(new DOMSource(domResult.getNode()), new StreamResult(output));		
	}
	
	@SuppressWarnings("unchecked")
	private void test2() throws Exception {
		File input = new File("E:/Projects/Civ4/tools/Java/Civ4TechInfos.xml");
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		IInfos<ITechInfo> infos = (IInfos<ITechInfo>) jaxbUnmarshaller.unmarshal(input);
		ITechInfo info = infos.getInfo("TECH_WOODWORKING");
		info.setCanPassPeaks(true);
		infos.addInfo(info);
		
		File output = new File("E:/Projects/Civ4/tools/Java/Out-Civ4TechInfos.xml");
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\"?>");
		jaxbMarshaller.marshal(infos, output);
	}
	
	private void test3() {
		XmlPostProcessor.tabifyAndComment("E:/Projects/Civ4/tools/Java/Out-Civ4TechInfos.xml", 4);
	}
	
	private void test4() {
		TechInfos infos = InfosFactory.getInfos(EInfos.TECH_INFOS, "E:/Projects/Civ4/tools/Java/Civ4TechInfos.xml");
		ITechInfo info = infos.getInfo("TECH_WOODWORKING");
		info.setCanPassPeaks(true);
		infos.addInfo(info);		
	}
}
