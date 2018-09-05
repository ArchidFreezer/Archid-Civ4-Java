package org.archid.civ4.info;

import org.apache.log4j.Logger;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.info.era.EraImporter;
import org.archid.civ4.info.tech.TechImporter;
import org.archid.civ4.info.unit.UnitImporter;

public class ImporterFactory {

	/** Logging facility */
	static Logger log = Logger.getLogger(ImporterFactory.class.getName());
	
	public static IImporter getImporter(EInfos infoType) {
		IImporter importer = null;
		switch (infoType) {
		case ERA_INFOS:
			importer = new EraImporter(infoType);
			break;
		case TECH_INFOS:
			importer = new TechImporter(infoType);
			break;
		case UNIT_INFOS:
			importer = new UnitImporter(infoType);
			break;
		default:
			log.error("Unknown importer requested");
			break;
		}
		return importer;
	}

}
