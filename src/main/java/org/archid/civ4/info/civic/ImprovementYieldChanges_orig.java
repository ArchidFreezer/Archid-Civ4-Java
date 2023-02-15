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
public class ImprovementYieldChanges_orig {

	private List<IImprovementYieldChange_orig> improvementChanges = new ArrayList<IImprovementYieldChange_orig>();
	
	@XmlJavaTypeAdapter(ImprovementYieldChangeAdapter_orig.class)
	@XmlElement(name="ImprovementYieldChanges")
	public List<IImprovementYieldChange_orig> getImprovementYieldChanges() {
		return improvementChanges;
	}
	
	public static IImprovementYieldChange_orig createImprovementYieldChange() {
		return new ImprovementYieldChange_orig();
	}
	
	private static class ImprovementYieldChange_orig implements IImprovementYieldChange_orig {

		private String improvement;
		private List<Integer> yields = new ArrayList<Integer>();
		
		private ImprovementYieldChange_orig() {}
		
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
