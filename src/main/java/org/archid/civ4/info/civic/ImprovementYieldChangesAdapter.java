package org.archid.civ4.info.civic;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.civ4.info.civic.ImprovementYieldChanges.ImprovementYieldChange;
import org.archid.utils.CollectionUtils;
import org.archid.utils.JaxbUtils;

public class ImprovementYieldChangesAdapter extends XmlAdapter<ImprovementYieldChangesAdapter.AdaptedImprovementYieldChanges, ImprovementYieldChanges> {
	
	public static class AdaptedImprovementYieldChanges {
		@XmlElement(name = "ImprovementYieldChange")
		private List<AdaptedImprovementYieldChange> entries = new ArrayList<AdaptedImprovementYieldChange>();
	}
	
	static class AdaptedImprovementYieldChange {
		@XmlElement(name="ImprovementType")
		String improvementType;
		@XmlElementWrapper(name="ImprovementYields")
		@XmlElement(name="iYield")
		List<Integer> improvementYields;
	}

	@Override
	public ImprovementYieldChanges unmarshal(AdaptedImprovementYieldChanges v) throws Exception {
		ImprovementYieldChanges changes = new ImprovementYieldChanges();
		for (AdaptedImprovementYieldChange adapter: v.entries) {
			ImprovementYieldChange improvementYieldChange = new ImprovementYieldChange();
			improvementYieldChange.setImprovement(JaxbUtils.unmarshallString(adapter.improvementType));
			if (CollectionUtils.hasElements(adapter.improvementYields)) {
				for (Integer val: adapter.improvementYields) {
					improvementYieldChange.addYield(val);
				}
			}
			changes.getImprovementYieldChangeList().add(improvementYieldChange);
		}
		return changes;
	}

	@Override
	public AdaptedImprovementYieldChanges marshal(ImprovementYieldChanges v) throws Exception {
		if (!CollectionUtils.hasElements(v.getImprovementYieldChangeList())) return null;
		
		AdaptedImprovementYieldChanges changes = new AdaptedImprovementYieldChanges();
		for(ImprovementYieldChange improvementYieldChange: v.getImprovementYieldChangeList()) {
			AdaptedImprovementYieldChange adapter = new AdaptedImprovementYieldChange();
			adapter.improvementType = improvementYieldChange.getImprovement();
			adapter.improvementYields = new ArrayList<Integer>();
			if (CollectionUtils.hasElements(improvementYieldChange.getYields())) {
				adapter.improvementYields = improvementYieldChange.getYields();
			}
			changes.entries.add(adapter);
		}
		return changes;
	}

}
