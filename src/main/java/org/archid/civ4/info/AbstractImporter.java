/**
 * 
 */
package org.archid.civ4.info;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.FileUtils;
import org.archid.civ4.utils.IPair;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.Pair;
import org.archid.civ4.utils.PropertyHandler;
import org.archid.civ4.utils.PropertyKeys;
import org.archid.civ4.utils.StringUtils;

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
		parseXlsx();
		try {
			backupInfosFile();
			InfosFactory.writeInfos(infoEnum, props.getAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE), infos);
		} catch (IOException e) {
			log.error("Error backing up infos file ... aborting", e);
		}
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
	
	protected void backupInfosFile() throws IOException {
		String srcpath = props.getAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE);
		File src = new File(srcpath);
		if (!src.exists()) return;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String destpath = srcpath + "." + sdf.format(cal.getTime());
		log.info("Backing up original file to: " + destpath);

		File dest = new File(destpath);
		FileUtils.copyFile(src, dest);
	}
	
	protected abstract void parseXlsx();
}
