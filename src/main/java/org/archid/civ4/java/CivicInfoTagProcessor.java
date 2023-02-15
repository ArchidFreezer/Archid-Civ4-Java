package org.archid.civ4.java;

public class CivicInfoTagProcessor extends DefaultInfoTagProcessor {

	public void init(String packageName) {
		this.packageName = packageName;
		exportImports.add("import org.apache.poi.ss.usermodel.Cell;");
		exportImports.add("import org.archid.civ4.info.IInfoWorkbook;");
		importImports.add("import java.util.ArrayList;");
		importImports.add("import java.util.List;");
		importImports.add("import org.apache.poi.ss.usermodel.Cell;");
		importImports.add("import org.archid.civ4.info.IInfoWorkbook;");
		importImports.add("import org.archid.utils.StringUtils;");
		addTagProcessor(new ImprovementYieldChangesProcesser("ImprovementYieldChanges"));
	}
	
	@Override
	public String getXmlFormatter() {
		return "CivicInfoXmlFormatter()";
	}

	@Override
	public Integer getTypeTagIndex() {
		return 1;
	}
	
	private class ImprovementYieldChangesProcesser extends AbstractTagProcessor {

		public ImprovementYieldChangesProcesser(String tagName) {
			super(tagName);
			exportImports.add("import org.archid.civ4.info.civic.ImprovementYieldChanges.ImprovementYieldChange;");
			importImports.add("import org.archid.civ4.info.civic.ImprovementYieldChanges.ImprovementYieldChange;");
		}

		@Override
		public String getUnmarshallString() {
			 return NEWLINETTT + "info.setImprovementYieldChanges(aInfo.improvementYieldChanges);";
		}

		@Override
		public String getMarshallString() {
			 return NEWLINETTT + "aInfo.improvementYieldChanges = info.getImprovementYieldChanges();";
		}

		@Override
		public String getExporterRow() {
			return NEWLINETT + "maxHeight = addImprovementYieldChangeCell(row.createCell(colNum++), info.getImprovementYieldChanges(), maxHeight);";
		}
			
		@Override
		public String getExporterCellWriter() {
			StringBuilder sb = new StringBuilder();
			sb.append(NEWLINE);
			sb.append(NEWLINET + "private int addImprovementYieldChangeCell(Cell cell, ImprovementYieldChanges list, int maxHeight) {");
			sb.append(NEWLINETT + "if (list == null) return maxHeight;");
			sb.append(NEWLINE);
			sb.append(NEWLINETT + "int currHeight = 0;");
			sb.append(NEWLINETT + "cell.setCellStyle(csWrap);");
			sb.append(NEWLINETT + "StringBuilder cellvalue = new StringBuilder();");
			sb.append(NEWLINETT + "for (ImprovementYieldChange change: list.getImprovementYieldChangeList()) {");
			sb.append(NEWLINETTT + "if (currHeight > 0) cellvalue.append(IInfoWorkbook.CELL_NEWLINE);");
			sb.append(NEWLINETTT + "cellvalue.append(change.getImprovement() + IInfoWorkbook.CELL_NEWLINE);");
			sb.append(NEWLINETTT + "for (Integer yield: change.getYields()) {");
			sb.append(NEWLINETTTT + "cellvalue.append(yield + IInfoWorkbook.CELL_NEWLINE);");
			sb.append(NEWLINETTTT + "currHeight ++;");
			sb.append(NEWLINETTT + "}");
			sb.append(NEWLINETTT + "cellvalue.append(\"-\");");
			sb.append(NEWLINETTT + "currHeight += 2;");
			sb.append(NEWLINETT + "}");
			sb.append(NEWLINETT + "cell.setCellValue(cellvalue.toString());");
			sb.append(NEWLINETT + "if (currHeight > maxHeight) maxHeight = currHeight;");
			sb.append(NEWLINETT + "return maxHeight;");
			sb.append(NEWLINET + "}");
			sb.append(NEWLINE);
			return sb.toString();
		}

		@Override
		public String getImporterRow() {
			return NEWLINETT + "parseImprovementYieldChangeCell(row.getCell(colNum++), info);";
		}

		@Override
		public String getImporterCellReader() {
			StringBuilder sb = new StringBuilder();
			sb.append(NEWLINE + "");
			sb.append(NEWLINET + "private void parseImprovementYieldChangeCell(Cell cell, ICivicInfo info) {");
			sb.append(NEWLINETT + "String[] arr = cell.getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE);");
			sb.append(NEWLINETT + "if (arr.length > 1) {");
			sb.append(NEWLINETTT + "boolean first = true;");
			sb.append(NEWLINETTT + "String improvement = null;");
			sb.append(NEWLINETTT + "List<Integer> yields = null;");
			sb.append(NEWLINETTT + "for (String str: arr) {");
			sb.append(NEWLINETTTT + "if (StringUtils.hasCharacters(str)) {");
			sb.append(NEWLINETTTTT + "if (first) {");
			sb.append(NEWLINETTTTTT + "yields = new ArrayList<Integer>();");
			sb.append(NEWLINETTTTTT + "improvement = getVal(str, String.class);");
			sb.append(NEWLINETTTTTT + "first = false;");
			sb.append(NEWLINETTTTT + "} else if (str.equals(\"-\")) {");
			sb.append(NEWLINETTTTTT + "ImprovementYieldChange improvementYieldChange = new ImprovementYieldChange();");
			sb.append(NEWLINETTTTTT + "improvementYieldChange.setImprovement(improvement);");
			sb.append(NEWLINETTTTTT + "for (Integer yield: yields) {");
			sb.append(NEWLINETTTTTTT + "improvementYieldChange.addYield(yield);");
			sb.append(NEWLINETTTTTT + "}");
			sb.append(NEWLINETTTTTT + "info.getImprovementYieldChanges().getImprovementYieldChangeList().add(improvementYieldChange);");
			sb.append(NEWLINETTTTTT + "first = !first;");
			sb.append(NEWLINETTTTT + "} else {");
			sb.append(NEWLINETTTTTT + "yields.add(Integer.valueOf(str));");
			sb.append(NEWLINETTTTT + "}");
			sb.append(NEWLINETTTT + "}");
			sb.append(NEWLINETTT + "}");
			sb.append(NEWLINETT + "}");
			sb.append(NEWLINET + "}");
			return sb.toString();
		}
	}
}
