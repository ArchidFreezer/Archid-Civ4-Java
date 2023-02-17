package org.archid.civ4.java;

public class BuildingInfoTagProcessor extends DefaultInfoTagProcessor {

	public BuildingInfoTagProcessor(TagNameUtils tagNameUtils) {
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
		addTagProcessor(getSpecialistYieldChangesProcessor());
		addTagProcessor(getBonusYieldModifiersProcessor());
		addTagProcessor(getBonusYieldChangesProcessor());
		addTagProcessor(getVicinityBonusYieldChangesProcessor());
		addTagProcessor(getTechCommerceChangesProcessor());
	}
	
	private DefaultResourceArrayTagProcessor getSpecialistYieldChangesProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("SpecialistYieldChanges", "SpecialistYieldChange", "SpecialistType", "YieldChanges", "iYield"), tagNameUtils);
	}
	
	private DefaultResourceArrayTagProcessor getBonusYieldModifiersProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("BonusYieldModifiers", "BonusYieldModifier", "BonusType", "YieldModifiers", "iYield"), tagNameUtils);
	}
	
	private DefaultResourceArrayTagProcessor getBonusYieldChangesProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("BonusYieldChanges", "BonusYieldChange", "BonusType", "YieldChanges", "iYield"), tagNameUtils);
	}
	
	private DefaultResourceArrayTagProcessor getVicinityBonusYieldChangesProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("VicinityBonusYieldChanges", "VicinityBonusYieldChange", "BonusType", "YieldChanges", "iYield"), tagNameUtils);
	}
		
	private DefaultResourceArrayTagProcessor getTechCommerceChangesProcessor() {
		return new DefaultResourceArrayTagProcessor(getTagData("TechCommerceChanges", "TechCommerceChange", "TechType", "CommerceChanges", "iCommerce"), tagNameUtils);
	}
	

	@Override
	public String getXmlFormatter() {
		return "BuildingInfoXmlFormatter()";
	}

	@Override
	public Integer getTypeTagIndex() {
		return 1;
	}
	
	@Override
	protected DefaultResourceArrayTagProcessorData getTagData(String outer, String wrapper, String resource, String list, String element) {
		DefaultResourceArrayTagProcessorData tagData = super.getTagData(outer, wrapper, resource, list, element);
		tagData.infoInterface = "IBuildingInfo";
		tagData.folder = "building";
		return tagData;
	}
	
}
