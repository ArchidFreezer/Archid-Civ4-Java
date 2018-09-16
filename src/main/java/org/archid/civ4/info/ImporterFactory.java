package org.archid.civ4.info;

import org.apache.log4j.Logger;
import org.archid.civ4.info.archid.building.BuildingImporter;
import org.archid.civ4.info.archid.buildingclass.BuildingClassImporter;
import org.archid.civ4.info.archid.era.EraImporter;
import org.archid.civ4.info.archid.tech.TechImporter;
import org.archid.civ4.info.archid.unit.UnitImporter;

public class ImporterFactory {

	/** Logging facility */
	static Logger log = Logger.getLogger(ImporterFactory.class.getName());
	
	public static IImporter getImporter(EInfo infoType) {
		IImporter importer = null;
		switch (infoType) {
		case BUILDING:
			importer = new BuildingImporter(infoType);
			break;
		case BUILDING_CLASS:
			importer = new BuildingClassImporter(infoType);
			break;
		case ERA:
			importer = new EraImporter(infoType);
			break;
		case TECH:
			importer = new TechImporter(infoType);
			break;
		case UNIT:
			importer = new UnitImporter(infoType);
			break;
		default:
			log.error("Unknown importer requested");
			break;
		}
		return importer;
	}

}
