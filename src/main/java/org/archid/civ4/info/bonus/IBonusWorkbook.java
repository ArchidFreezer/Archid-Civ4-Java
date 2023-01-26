package org.archid.civ4.info.bonus;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IBonusWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "BonusList";
	
	public enum SheetHeaders {
		TYPE, DESCRIPTION, CIVILOPEDIA, HELP, BONUS_CLASS_TYPE, ART_DEFINE_TAG, TECH_REVEAL, TECH_CITY_TRADE, TECH_OBSOLETE, YIELD_CHANGES, AITRADE_MODIFIER,
		AIOBJECTIVE, HEALTH, HAPPINESS, PLACEMENT_ORDER, CONST_APPEARANCE, MIN_AREA_SIZE, MIN_LATITUDE, MAX_LATITUDE, RANDS, PLAYER, TILES_PER, MIN_LAND_PERCENT,
		UNIQUE, GROUP_RANGE, GROUP_RAND, AREA, HILLS, PEAKS, FLATLANDS, NO_RIVER_SIDE, NORMALIZE, TERRAIN_BOOLEANS, FEATURE_BOOLEANS, FEATURE_TERRAIN_BOOLEANS,
		USE_LSYSTEM;
		
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
