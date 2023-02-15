package org.archid.civ4.info.civic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(ImprovementYieldChangesAdapter.class)
class ImprovementYieldChanges {
	private List<ImprovementYieldChange> improvementYieldChangeList = new ArrayList<ImprovementYieldChange>();
	
	public List<ImprovementYieldChange> getImprovementYieldChangeList() {
		return improvementYieldChangeList;
	}
	
	public void setImprovementYieldChangeList(List<ImprovementYieldChange> unitYieldChangeList) {
		this.improvementYieldChangeList = unitYieldChangeList;
	}

	static class ImprovementYieldChange {
		
		private String improvement;
		private List<Integer> yields = new ArrayList<Integer>();
		
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