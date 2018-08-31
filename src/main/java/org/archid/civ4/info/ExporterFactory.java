package org.archid.civ4.info;

import org.apache.log4j.Logger;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.info.era.EraExporter;
import org.archid.civ4.info.techinfo.TechExporter;

public class ExporterFactory {

	/** Logging facility */
	static Logger log = Logger.getLogger(ExporterFactory.class.getName());
	
	public static IExporter getExporter(EInfos infoType) {
		IExporter exporter = null;
		switch (infoType) {
		case TECH_INFOS:
			exporter = new TechExporter(infoType);
			break;
		case ERA_INFOS:
			exporter = new EraExporter(infoType);
			break;
		default:
			log.error("Unknown exporter requested");
			break;
		}
		return exporter;
	}

}
