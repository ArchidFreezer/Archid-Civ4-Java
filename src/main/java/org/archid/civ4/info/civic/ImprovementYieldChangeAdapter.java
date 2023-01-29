package org.archid.civ4.info.civic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.utils.CollectionUtils;
import org.archid.utils.JaxbUtils;

public class ImprovementYieldChangeAdapter extends XmlAdapter<ImprovementYieldChangeAdapter.ImprovementYieldChangeList, List<IImprovementYieldChange>> {
	
	public static class ImprovementYieldChangeList {
		@XmlElement(name = "ImprovementYieldChange")
		List<AdaptedImprovementYieldChange> entries = new ArrayList<AdaptedImprovementYieldChange>();
	}
	
	static class AdaptedImprovementYieldChange {
		@XmlElement(name="ImprovementType")
		String improvementType;
		@XmlElementWrapper(name="ImprovementYields")
		@XmlElement(name="iYield")
		List<Integer> improvementYields;
	}

	@Override
	public List<IImprovementYieldChange> unmarshal(ImprovementYieldChangeList v) throws Exception {
		List<IImprovementYieldChange> list = new ArrayList<IImprovementYieldChange>();
		for (AdaptedImprovementYieldChange adapter: v.entries) {
			IImprovementYieldChange improvementYieldChange = ImprovementYieldChanges.createImprovementYieldChange();
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
	public ImprovementYieldChangeList marshal(List<IImprovementYieldChange> v) throws Exception {
		ImprovementYieldChangeList list = new ImprovementYieldChangeList();
		for(IImprovementYieldChange improvementYieldChange: v) {
			AdaptedImprovementYieldChange adapter = new AdaptedImprovementYieldChange();
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
