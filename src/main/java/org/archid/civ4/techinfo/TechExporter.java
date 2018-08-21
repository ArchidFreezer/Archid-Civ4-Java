package org.archid.civ4.techinfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TechExporter {
	
	/** Logging facility */
	static Logger log = Logger.getLogger(TechExporter.class.getName());

	private List<TechInfo> techinfos;
	private Map<Integer, CellStyle> backgrounds;
	
	public TechExporter(List<TechInfo> techinfos) {
		this.techinfos = techinfos;
	}

	public void createXLSX() {
		try {
			
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("TechTree");
			
			// Create some background colours for the different eras
			preCreateCellStyles(wb);
			
			// Add the tech data
			Row row;
			Cell cell;
			int maxGridX = 0; // Used to autosize all the cols
			int maxGridY = 0; // Used to create all the rows at one go
			List<String> eras = new ArrayList<String>(); // Used to add background colour to cells based on era
			for (TechInfo techInfo: techinfos) {
				// Get the row (iGridY value from tech)
				int gridY = techInfo.getGridY();
				if (gridY <= 0) {
					log.info("Ignoring tech " + techInfo.getType() + " invalid gridY value: " + gridY);
					continue;
				}
				if (gridY > maxGridY) maxGridY = gridY;
				row = sheet.getRow(gridY - 1);
				if (row == null)
					row = sheet.createRow(gridY - 1);
				
				// Get the col (iGridX from tech)
				int gridX = techInfo.getGridX();
				if (gridX <= 0) {
					log.info("Ignoring tech " + techInfo.getType() + " invalid gridX value: " + gridX);
					continue;
				}
				if (gridX > maxGridX) maxGridX = gridX;
				cell = row.createCell(getCellCol(gridX), CellType.STRING);
				cell.setCellValue(techInfo.getType());
				
				String era = techInfo.getEra();
				if (!eras.contains(era))
					eras.add(era);
				cell.setCellStyle(getStyle(eras.lastIndexOf(era)));
				
				setCellComment(cell, techInfo);
			}
			
			// Autosize the columns
			int iNumCols = getCellCol(maxGridX) + 1;
			for (int i = 0; i < iNumCols; i++) {
				sheet.autoSizeColumn(i);
			}
			
			OutputStream output = getOutputStream();
			wb.write(output);
			output.close();
			wb.close();
		} catch (IOException e) {
			log.error("Error creating XLSX", e);
		}
		
	}
	
	private int getCellCol(int gridX) {
		return (--gridX * 2);
	}
	
	private OutputStream getOutputStream() throws FileNotFoundException {
		String outputFile = TechReader.getFileWithNewExtension("xlsx");
		log.info("Writing output to: " + outputFile);
		FileOutputStream output = new FileOutputStream(outputFile);
		return output;
	}
	
	private void preCreateCellStyles(Workbook wb) {
		backgrounds = new HashMap<Integer, CellStyle>();
		CellStyle style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		backgrounds.put(0, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		backgrounds.put(1, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		backgrounds.put(2, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		backgrounds.put(3, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		backgrounds.put(4, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
		backgrounds.put(5, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		backgrounds.put(6, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
		backgrounds.put(7, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		backgrounds.put(8, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
		backgrounds.put(9, style);
		style = wb.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(IndexedColors.TEAL.getIndex());
		backgrounds.put(10, style);
		
	}
	
	private CellStyle getStyle(int index) {
		if (index == -1)
			index = 0;
		
		if (!backgrounds.containsKey(index))
			index = index % backgrounds.size();
		
		return backgrounds.get(index);
	}
	
	private void setCellComment(Cell cell, TechInfo info) {
    Drawing<?> drawing = cell.getSheet().createDrawingPatriarch();
    CreationHelper factory = cell.getSheet().getWorkbook().getCreationHelper();

    ClientAnchor anchor = factory.createClientAnchor();
    
    int height = 2;
    StringBuilder message = new StringBuilder("iGridX: " + info.getGridX());
    message.append("\niGridY: " + info.getGridY());
    if (!info.getOrTechPrereqs().isEmpty()) {
    	height++;
    	message.append("\nOrTechPrereqs:");
	    for (String prereq: info.getOrTechPrereqs()) {
	    	height++;
	    	message.append("\n  " + prereq);
	    }
    }
    if (!info.getAndTechPrereqs().isEmpty()) {
    	height++;
    	message.append("\nAndTechPrereqs:");
	    for (String prereq: info.getAndTechPrereqs()) {
	    	height++;
	    	message.append("\n  " + prereq);
	    }
    }

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
    	log.error("Error creating cell comment for tech: " + info.getType() + "(" + info.getGridX() + "," + info.getGridY() + ") - comment likely to be incorrect", e);
    }

	}
	
}
