/**
 * 
 */
package org.archid.civ4.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.utils.IPair;
import org.archid.utils.IPropertyHandler;
import org.archid.utils.Pair;
import org.archid.utils.PropertyHandler;
import org.archid.utils.PropertyKeys;
import org.archid.utils.StringUtils;
import org.archid.utils.civ4.Civ4FileUtils;

/**
 * @author Jim
 * @param <V>
 *
 */
public abstract class AbstractImporter<T extends IInfos<S>, S extends IInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(AbstractImporter.class.getName());

	protected static IPropertyHandler props = PropertyHandler.getInstance();
	protected T infos;
	protected EInfos infoEnum;
	
	public AbstractImporter(EInfos infoEnum) {
		this.infoEnum= infoEnum;
		this.infos = InfosFactory.getInfos(infoEnum);
	}

	/* (non-Javadoc)
	 * @see org.archid.civ4.info.techinfo.IImporter#importXLSX()
	 */
	@Override
	public void importXLSX() {
		
		// Read the xlsx file to create the list of tech infos to update
		parseXlsx(getWorkbook());
		try {
			String outputFile = Civ4FileUtils.prepareOutputFile(props.getAppProperty(PropertyKeys.PROPERTY_KEY_FILE_INFOS));
			log.info("Importing to " + outputFile);
			InfosFactory.writeInfos(infoEnum, outputFile, infos);
		} catch (IOException e) {
			log.error("Error backing up infos file ... aborting", e);
		}
	}
	
	private Workbook getWorkbook() {
		String filepath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_FILE_XSLX);
		log.info("Reading workbook: " + filepath);
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(filepath);
		} catch (IOException e) {
			log.error("Error opening workboook from file: " + filepath, e);
		}
		return wb;
	}

	protected <U, V> List<IPair<U, V>> parsePairs(Cell cell, Class<U> keyClass, Class<V> valClass) {
		List<IPair<U, V>> list = new ArrayList<IPair<U, V>>();
		String[] arr = cell.getStringCellValue().split("\n");
		if (arr.length > 1) {
			boolean first = true;
			U key = null;
			V val = null;
			for (String str: arr) {
				if (StringUtils.hasCharacters(str)) {
					if (first) {
						key = getVal(str, keyClass);
					} else {
						val = getVal(str, valClass);
						list.add(new Pair<U, V>(key, val));
					}
					first = !first;
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked" })
	private <U> U getVal(String str, Class<U> valClass) {
		U val = null;
		if (valClass == String.class)
			val = (U) str;
		if (valClass == Integer.class)
			val = (U) Integer.valueOf(str);
		if (valClass == Boolean.class)
			val = (U) Boolean.valueOf(str);
		
		return val;
		
	}
	
	protected abstract void parseXlsx(Workbook wb);
}
