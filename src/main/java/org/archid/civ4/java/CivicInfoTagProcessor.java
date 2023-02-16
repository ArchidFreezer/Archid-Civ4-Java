package org.archid.civ4.java;

public class CivicInfoTagProcessor extends DefaultInfoTagProcessor {

	public CivicInfoTagProcessor(TagNameUtils tagNameUtils) {
		super(tagNameUtils);
	}

	public void init(String packageName) {
		this.packageName = packageName;
		exportImports.add("import org.apache.poi.ss.usermodel.Cell;");
		exportImports.add("import org.archid.civ4.info.IInfoWorkbook;");
		importImports.add("import java.util.ArrayList;");
		importImports.add("import java.util.List;");
		importImports.add("import org.apache.poi.ss.usermodel.Cell;");
		importImports.add("import org.archid.civ4.info.IInfoWorkbook;");
		importImports.add("import org.archid.utils.StringUtils;");
		addTagProcessor(getImprovementYieldChangesProcessor());
	}
	
	@Override
	public String getXmlFormatter() {
		return "CivicInfoXmlFormatter()";
	}

	@Override
	public Integer getTypeTagIndex() {
		return 1;
	}
	
	private DefaultResourceArrayTagProcessor getImprovementYieldChangesProcessor() {
		DefaultResourceArrayTagProcessorData tagData = new DefaultResourceArrayTagProcessorData();
		tagData.outer = "ImprovementYieldChanges";
		tagData.wrapper = "ImprovementYieldChange";
		tagData.resource = "ImprovementType";
		tagData.list = "ImprovementYields";
		tagData.element = "iYield";
		tagData.infoInterface = "ICivicInfo";
		tagData.folder = "civic";
		return new DefaultResourceArrayTagProcessor(tagData, tagNameUtils);
	}
	
}
