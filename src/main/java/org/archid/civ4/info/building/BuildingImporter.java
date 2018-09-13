package org.archid.civ4.info.building;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;

public class BuildingImporter extends AbstractImporter<IInfos<IBuildingInfo>, IBuildingInfo> {

	/** Logging facility */
	static Logger log = Logger.getLogger(BuildingImporter.class.getName());
	
	public BuildingImporter(EInfos infoEnum) {
		super(infoEnum, new BuildingInfoXmlFormatter());
	}

	@Override
	protected IBuildingInfo parseRow(Row row) {
		int colNum = 0;
		String clazz = row.getCell(colNum++).getStringCellValue();
		String type = row.getCell(colNum++).getStringCellValue();
		
		// Handle buildings that have been deleted or are incomplete
		if (clazz.isEmpty() || type.isEmpty())
			return null;
		
		IBuildingInfo info = BuildingInfos.createInfo(type);
		info.setBuildingClass(clazz);
		
		return info;
	}

	@Override
	public String getListSheetName() {
		return IBuildingWorkbook.SHEETNAME_LIST;
	}

}
