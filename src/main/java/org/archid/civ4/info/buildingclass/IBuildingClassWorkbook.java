package org.archid.civ4.info.buildingclass;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IBuildingClassWorkbook extends IInfoWorkbook {
	
	public static final String SHEETNAME_LIST = "BuildingClassList";

	public enum SheetHeaders {
		TYPE, DESCRIPTION, CATEGORY, MAX_GLOBAL_INSTANCES, MAX_TEAM_INSTANCES, MAX_PLAYER_INSTANCES, EXTRA_PLAYER_INSTANCES, NO_LIMIT, MONUMENT, DEFAULT_BUILDING, VICTORY_THRESHOLDS;
		
		/**
		 * The value returned is in mixed case and better suited for the display of the value.
		 * 
		 * @return Mixed case representation of the value
		 */
		@Override
		public String toString() {
			return StringUtils.titleCaseSpace(this.name(), '_');
		}
	}
	
}
