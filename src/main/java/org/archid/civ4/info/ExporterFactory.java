package org.archid.civ4.info;

import org.apache.log4j.Logger;
import org.archid.civ4.info.archid.building.BuildingExporter;
import org.archid.civ4.info.archid.buildingclass.BuildingClassExporter;
import org.archid.civ4.info.archid.era.EraExporter;
import org.archid.civ4.info.archid.tech.TechExporter;
import org.archid.civ4.info.archid.unit.UnitExporter;

public class ExporterFactory {

	/** Logging facility */
	static Logger log = Logger.getLogger(ExporterFactory.class.getName());
	
	public static IExporter getExporter(EInfo infoType) {
		IExporter exporter = null;
		switch (infoType) {
		case BUILDING:
			exporter = new BuildingExporter(infoType);
			break;
		case BUILDING_CLASS:
			exporter = new BuildingClassExporter(infoType);
			break;
		case ERA:
			exporter = new EraExporter(infoType);
			break;
		case TECH:
			exporter = new TechExporter(infoType);
			break;
		case UNIT:
			exporter = new UnitExporter(infoType);
			break;
		default:
			log.error("Unknown exporter requested");
			break;
		}
		return exporter;
	}

}
