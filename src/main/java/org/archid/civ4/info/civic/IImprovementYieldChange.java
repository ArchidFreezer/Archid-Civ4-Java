package org.archid.civ4.info.civic;

import java.util.List;

public interface IImprovementYieldChange {
	
	void setImprovement (String improvement);
	String getImprovement();

	void addYield(Integer yield);
	List<Integer> getYields();

}
