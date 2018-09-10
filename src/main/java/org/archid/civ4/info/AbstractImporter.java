/**
 * 
 */
package org.archid.civ4.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
 *
 * @param <T> Type that represents the collection of {@code <S>} infos being imported, subclass of {@link IInfos}
 * @param <S> Type of info being imported, must be a subclass of {@link IInfo}
 */
public abstract class AbstractImporter<T extends IInfos<S>, S extends IInfo> implements IImporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(AbstractImporter.class.getName());

	protected static final String newline = System.getProperty("line.separator");
	
	protected static IPropertyHandler props = PropertyHandler.getInstance();
	protected T infos;
	protected EInfos infoEnum;
	protected IXmlFormatter formatter;
	
	/**
	 * Constructor
	 * 
	 * Takes a parameter that defined the type of info being processed and loads the associated list of infos
	 * 
	 * @param infoEnum {@link EInfos} enumeration value defining the type of info being imported
	 */
	public AbstractImporter(EInfos infoEnum, IXmlFormatter formatter) {
		this.infoEnum= infoEnum;
		this.infos = InfosFactory.getInfos(infoEnum);
		this.formatter = formatter;
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
			if (formatter != null) formatter.format(outputFile);
		} catch (IOException e) {
			log.error("Error backing up infos file ... aborting", e);
		}
	}
	
	/**
	 * Gets the workbook that the info data will be imported from
	 *  
	 * @return {@link Workbook} to process
	 */
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

	/**
	 * Reads the contents of a workbook cell containing key value pairs of data delimited by the newline character and
	 * returns a {@link List} of {@link IPair} objects whose key and value types are as defined by the parameters.
	 * 
	 * The following classes may be used as either the key or the value of the pair
	 * <ul><li>{@link String}</li><li>Integer</li><li>Boolean</li><li>Float</li></ul>
	 * 
	 * @param cell {@link Cell} the sheet cell containing the data to parse
	 * @param keyClass class of the key used in the pair
	 * @param valClass class of the value used in the pair
	 * @return {@link List}<{@link IPair}> containing the parsed contents of the cell 
	 */
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
	
	/**
	 * Takes a string and parses it into another class type. If the string cannot be parsed then {@code null} will be returned.
	 * 
	 * @param str {@link String} to parse
	 * @param valClass {@link Class} to convert the String into
	 *   
	 * @return {@code str} cast to the class defined by {@code valClass}
	 */
	@SuppressWarnings({ "unchecked" })
	private <U> U getVal(String str, Class<U> valClass) {
		U val = null;
		if (valClass == String.class)
			val = (U) str;
		else if (valClass == Integer.class)
			val = (U) Integer.valueOf(str);
		else if (valClass == Boolean.class)
			val = (U) Boolean.valueOf(str);
		else if (valClass == Float.class)
			val = (U) Float.valueOf(str);
		
		return val;
		
	}
	
	/**
	 * Main function to read the {@link Workbook} and extract the info data from the tab containing the list of infos.
	 * 
	 * @param wb {@link Workbook} containing the info data
	 */
	protected void parseXlsx(Workbook wb) {

		// Open the spreadsheet and get the list of infos
		Sheet sheet = wb.getSheet(getListSheetName());
		Iterator<Row> itRow = sheet.rowIterator();
		while (itRow.hasNext()) {
			Row row = itRow.next();
			
			// Ignore the header row
			if (row.getRowNum() == 0)
				continue;
			
			S info = parseRow(row);
			if (info != null) {
				infos.addInfo(info);
			}
		}
	}
	
	/**
	 * Takes a row from the spreadsheet and parses it into an info of the appropriate type. This method
	 * needs to be implemented by the concrete classes for each specific info type
	 *  
	 * @param row {@link Row} containing the data on a single info object
	 * @return instance of a subclass of {@link IInfo}
	 */
	protected abstract S parseRow(Row row);

	/**
	 * @return the formatter
	 */
	public IXmlFormatter getFormatter() {
		return formatter;
	}

	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(IXmlFormatter formatter) {
		this.formatter = formatter;
	}
}
