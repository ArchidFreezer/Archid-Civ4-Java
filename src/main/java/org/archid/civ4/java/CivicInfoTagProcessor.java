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
	
	private DefaultResourceArrayTagProcessor getImprovementYieldChangesProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("ImprovementYieldChanges", "ImprovementYieldChange", "ImprovementType", "ImprovementYields", "iYield"), tagNameUtils);
	}
	
	@Override
	public String getXmlFormatter() {
		return "CivicInfoXmlFormatter()";
	}

	@Override
	public Integer getTypeTagIndex() {
		return 1;
	}
	
	@Override
	protected DefaultResourceArrayTagProcessorData getTagData(String outer, String wrapper, String resource, String list, String element) {
		DefaultResourceArrayTagProcessorData tagData = super.getTagData(outer, wrapper, resource, list, element);
		tagData.infoInterface = "ICivicInfo";
		tagData.folder = "civic";
		return tagData;
	}
	
}
