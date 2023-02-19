package org.archid.civ4.java;

import java.util.ArrayList;
import java.util.List;

import org.archid.civ4.schema.XmlTagDefinition;
import org.archid.civ4.schema.XmlTagInstance;
import org.archid.civ4.schema.XmlTagDefinition.DataType;

public class TagInstance {
	
	private XmlTagInstance tagInstance = null;
	XmlTagDefinition tagDefinition = null; // iSomeTag
	private String rootName = "";      // SomeTag
	String varName = "";       // someTag
	private String getterName = null;
	private String setterName = null;
	private String dataType = null;
	private Integer numLevels = null;
	private boolean custom = false;
	private List<LeafData> leaves = new ArrayList<LeafData>(); 
	
	TagInstance(XmlTagDefinition tagDef, XmlTagInstance tagInst, boolean custom) {
		this.tagDefinition = tagDef;
		this.tagInstance = tagInst;
		this.custom = custom;
		numLevels = getNumLevels(tagDefinition, 0);
		populateLeafData();
	}
	
	public void init() {
		getterName = buildGetterName();
		setterName = buildSetterName();
	}
	
	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	
	private void populateLeafData() {
		JavaCodeGeneratorData jcgd = JavaCodeGeneratorData.getInstance();
		if (custom) return;
		if (numLevels == 0) {
			LeafData leafData = new LeafData();
			leafData.setName(rootName);
			leafData.setVarName(varName);
			leafData.setType(tagDefinition.getDataType().getJavaType());
			leaves.add(leafData);
			dataType = leafData.getType();
		} else if (numLevels == 1) {
			LeafData leafData = new LeafData();
			leafData.setName(rootName);
			leafData.setVarName(varName);
			leafData.setType(jcgd.getTagDefinition(tagDefinition.getChildren().get(0).getTagName()).getDataType().getJavaType());
			leaves.add(leafData);
			dataType = leafData.getType();
		} else if (numLevels == 2) {
			StringBuilder sbInner = new StringBuilder();
			// We need to drop down to the bottom level to determine how many leaf tags there are
			XmlTagDefinition wrapper = jcgd.getTagDefinition(tagDefinition.getChildren().get(0).getTagName());
			for (XmlTagInstance leaf: wrapper.getChildren()) {
				LeafData leafData = new LeafData();
				leafData.setName(leaf.getTagName());
				leafData.setVarName(JavaCodeGeneratorData.getInstance().getTagNameData().getVarName(leaf.getTagName()));
				leafData.setType(jcgd.getTagDefinition(leaf.getTagName()).getDataType().getJavaType());
				leaves.add(leafData);
			}
			if (leaves.size() == 2) {
				sbInner.append("IPair<");
			} else if (leaves.size() == 3) {
				sbInner.append("ITriple<");
			} else {
				// give up at this point
				leaves.clear();
				custom = true;
				dataType = rootName;
			}
			if (!custom) {
				Boolean first = true;
				for (LeafData leaf: leaves) {
					if (first) {
						first = false;
					} else {
						sbInner.append(", ");
					}
					sbInner.append(leaf.getType());
				}
				sbInner.append(">");
				dataType = sbInner.toString();
			}
		} else {
			custom = true;
			dataType = rootName;
		}
	}

	private Integer getNumLevels(XmlTagDefinition tag, Integer level) {
		if (tag.getChildren().size() == 0) {
			return level;
		}
		
		level++;
		for (XmlTagInstance child: tag.getChildren()) {
			Integer newLevel = getNumLevels(JavaCodeGeneratorData.getInstance().getTagDefinition(child.getTagName()), level);
			if (newLevel > level) level = newLevel;
		}
		return level;
	}

	private String buildGetterName() {
		StringBuilder sb = new StringBuilder();
		if (tagDefinition.getDataType() == DataType.BOOLEAN)
			sb.append("is");
		else
			sb.append("get");
		sb.append(rootName);
		return sb.toString();
	}

	private String buildSetterName() {
		String setter = null;
		if (numLevels > 0 && !custom)
			setter = "add" + JavaCodeGeneratorData.getInstance().getTagNameData().singularForm(rootName);
		else
			setter = "set" + rootName;
		return setter;
	}

	public String getterSignature() {
		StringBuilder sb = new StringBuilder();
		if (requiresArray()) sb.append("List<");
		sb.append(dataType);
		if (requiresArray()) sb.append(">");
		sb.append(" " + getterName + "()");
		return sb.toString();
	}
	
	public String setterSignature() {
		 return "void " + setterName + "(" + dataType + " " + setterVarName() + ")";
	}
	
	public String setterVarName() {
		if (numLevels > 0 && !custom)
			return JavaCodeGeneratorData.getInstance().getTagNameData().singularForm(varName);
		else
			return varName;
	}
	
	public Boolean requiresArray() {
		return numLevels > 0;
	}
	
	public Boolean requiresAdapter() {
		return numLevels > 1;
	}
	
	public Boolean isMandatory() {
		return tagInstance.isMandatory();
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getDataType() {
		return dataType;
	}
	
	public void resetLevels() {
		// Reset the computed data
		numLevels = 0;
	}
	
	public List<LeafData> getLeaves() {
		return leaves;
	}
	
	public LeafData getLeaf(int index) {
		return  leaves.get(index);
	}
	
	public int getNumLeaves() {
		return leaves.size();
	}

	public String getGetterName() {
		return getterName;
	}

	public String getSetterName() {
		return setterName;
	}

	public String getRootName() {
		return rootName;
	}

	public boolean isCustom() {
		return custom;
	}

	public String getVarName() {
		return varName;
	}
	
}

class LeafData {
	
	private String name;
	private String varName;
	private String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}