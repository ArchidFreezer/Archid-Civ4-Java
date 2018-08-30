package org.archid.civ4.info;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.utils.FileUtils;
import org.archid.civ4.utils.IKeyValuePair;
import org.archid.civ4.utils.IPropertyHandler;
import org.archid.civ4.utils.PropertyHandler;
import org.archid.civ4.utils.PropertyKeys;

public abstract class AbstractExporter<T extends IInfos<S>, S extends IInfo> implements IExporter {

	/** Logging facility */
	static Logger log = Logger.getLogger(AbstractExporter.class.getName());

	protected static IPropertyHandler props = PropertyHandler.getInstance();
	protected T infos;
	protected EInfos infoEnum;
	
	protected Workbook wb = null;
	protected CellStyle csWrap = null;
	protected CellStyle csHeader = null;
	
	
	public AbstractExporter(EInfos infoEnum) {
		this.infoEnum= infoEnum;
		this.infos = InfosFactory.readInfos(infoEnum, props.getAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE));
		wb = new XSSFWorkbook();
		preCreateCellStyles();
	}

	/* (non-Javadoc)
	 * @see org.archid.civ4.info.techinfo.IExporter#createXLSX()
	 */
	@Override
	public void createXLSX() {
		try {
			
			createSheets();
			
			OutputStream output = getOutputStream("xlsx");
			wb.write(output);
			output.close();
			wb.close();
		} catch (IOException e) {
			log.error("Error creating XLSX", e);
		}
		
	}
	
	
	protected void createSheets() {
		createInfoListSheet();
	}
	
	protected abstract Sheet createInfoListSheet();

	protected void preCreateCellStyles() {
		
		// Create the list header style
		Font headerFont = wb.createFont();
		headerFont.setFontHeightInPoints((short) 11);
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.DARK_BLUE.getIndex());
		csHeader = wb.createCellStyle();
		csHeader.setFont(headerFont);
		csHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		csHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		
		// Create word wrap style for multi line cells
		csWrap = wb.createCellStyle();
		csWrap.setWrapText(true);
		csWrap.setVerticalAlignment(VerticalAlignment.CENTER);

	}

	protected <U> void addSingleCell(Cell cell, U value) {
		cell.setCellValue(value.toString());
		cell.setCellStyle(csWrap);
	}

	protected <U> int addRepeatingCell(Cell cell, Collection<U> set, int maxHeight) {
		
		int currHeight = 0;
		
		cell.setCellStyle(csWrap);
		StringBuffer cellvalue = new StringBuffer();
		for (U value: set) {
			if (currHeight++ > 0) cellvalue.append("\n");
			cellvalue.append(value);
		}
		cell.setCellValue(cellvalue.toString());
		if (currHeight > maxHeight) maxHeight = currHeight;
		
		return maxHeight;
		
	}

	protected <U, V> int addRepeatingPairCell(Cell cell, Collection<IKeyValuePair<U, V>> list, int maxHeight) {
		
		int currHeight = 0;
		
		cell.setCellStyle(csWrap);
		StringBuffer cellvalue = new StringBuffer();
		for (IKeyValuePair<U, V> pair: list) {
			if (currHeight > 0) cellvalue.append("\n");
			cellvalue.append(pair.getKey() + "\n");
			cellvalue.append(pair.getValue());
			currHeight += 2;
		}
		cell.setCellValue(cellvalue.toString());
		if (currHeight > maxHeight) maxHeight = currHeight;
		
		return maxHeight;
		
	}

	protected void createSheetHeaders(Row row) {
		int colNum = 0;
		for (String header: getHeaders()) {
			addHeaderCell(row.createCell(colNum++), header);
		}
	}

	protected void setCellComment(Cell cell, S info) {
    Drawing<?> drawing = cell.getSheet().createDrawingPatriarch();
    CreationHelper factory = cell.getSheet().getWorkbook().getCreationHelper();

    ClientAnchor anchor = factory.createClientAnchor();
    String message = getCellMessage(info);
    int height = message.split("\n").length;
    int width = 2;
    anchor.setCol1(cell.getColumnIndex());
    anchor.setCol2(cell.getColumnIndex() + width);
    anchor.setRow1(cell.getRowIndex());
    anchor.setRow2(cell.getRowIndex() + height);
    anchor.setDx1(100);
    anchor.setDx2(100);
    anchor.setDy1(100);
    anchor.setDy2(100);


    try {
			Comment comment = drawing.createCellComment(anchor);
	    RichTextString str = factory.createRichTextString(message.toString());
	    comment.setString(str);
	    cell.setCellComment(comment);		
    }
    catch (Exception e) {
    	log.error("Error creating cell comment for info: " + info.getType() + " - comment likely to be incorrect", e);
    }
	}
	
	protected abstract String getCellMessage(S info);
	
	private void addHeaderCell(Cell cell, String value) {
		addSingleCell(cell, value);
		cell.setCellStyle(csHeader);
	}

	private OutputStream getOutputStream(String ext) throws FileNotFoundException {
		String outputFile = FileUtils.getNewExtension(props.getAppProperty(PropertyKeys.PROPERTY_KEY_INFOS_FILE), ext);
		log.info("Writing output to: " + outputFile);
		FileOutputStream output = new FileOutputStream(outputFile);
		return output;
	}
	
}
