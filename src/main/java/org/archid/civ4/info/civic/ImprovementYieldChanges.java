package org.archid.civ4.info.civic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="ImprovementYieldChange", namespace="x-schema:CIV4GameInfoSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class ImprovementYieldChanges {

	private List<IImprovementYieldChange> improvementChanges = new ArrayList<IImprovementYieldChange>();
	
	@XmlJavaTypeAdapter(ImprovementYieldChangeAdapter.class)
	@XmlElement(name="ImprovementYieldChanges")
	public List<IImprovementYieldChange> getImprovementYieldChanges() {
		return improvementChanges;
	}
	
	public static IImprovementYieldChange createImprovementYieldChange() {
		return new ImprovementYieldChange();
	}
	
	private static class ImprovementYieldChange implements IImprovementYieldChange {

		private String improvement;
		private List<Integer> yields = new ArrayList<Integer>();
		
		private ImprovementYieldChange() {}
		
		public void setImprovement (String improvement) {
			this.improvement = improvement;
		}
		
		public String getImprovement() {
			return improvement;
		}
		
		public void addYield(Integer yield) {
			yields.add(yield);
		}
		
		public List<Integer> getYields() {
			return yields;
		}
	}
	
}
