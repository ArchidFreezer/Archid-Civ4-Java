package org.archid.civ4.info.civic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.utils.CollectionUtils;
import org.archid.utils.JaxbUtils;

public class ImprovementYieldChangeAdapter_orig extends XmlAdapter<ImprovementYieldChangeAdapter_orig.ImprovementYieldChangeList_orig, List<IImprovementYieldChange_orig>> {
	
	public static class ImprovementYieldChangeList_orig {
		@XmlElement(name = "ImprovementYieldChange")
		List<AdaptedImprovementYieldChange_orig> entries = new ArrayList<AdaptedImprovementYieldChange_orig>();
	}
	
	static class AdaptedImprovementYieldChange_orig {
		@XmlElement(name="ImprovementType")
		String improvementType;
		@XmlElementWrapper(name="ImprovementYields")
		@XmlElement(name="iYield")
		List<Integer> improvementYields;
	}

	@Override
	public List<IImprovementYieldChange_orig> unmarshal(ImprovementYieldChangeList_orig v) throws Exception {
		List<IImprovementYieldChange_orig> list = new ArrayList<IImprovementYieldChange_orig>();
		for (AdaptedImprovementYieldChange_orig adapter: v.entries) {
			IImprovementYieldChange_orig improvementYieldChange = ImprovementYieldChanges_orig.createImprovementYieldChange();
			improvementYieldChange.setImprovement(JaxbUtils.unmarshallString(adapter.improvementType));
			if (CollectionUtils.hasElements(adapter.improvementYields)) {
				for (Integer val: adapter.improvementYields) {
					improvementYieldChange.addYield(val);
				}
			}
			list.add(improvementYieldChange);
		}
		return list;
	}

	@Override
	public ImprovementYieldChangeList_orig marshal(List<IImprovementYieldChange_orig> v) throws Exception {
		ImprovementYieldChangeList_orig list = new ImprovementYieldChangeList_orig();
		for(IImprovementYieldChange_orig improvementYieldChange: v) {
			AdaptedImprovementYieldChange_orig adapter = new AdaptedImprovementYieldChange_orig();
			adapter.improvementType = improvementYieldChange.getImprovement();
			adapter.improvementYields = new ArrayList<Integer>();
			if (CollectionUtils.hasElements(improvementYieldChange.getYields())) {
				adapter.improvementYields = improvementYieldChange.getYields();
			}
			list.entries.add(adapter);
		}
		return list;
	}

}
