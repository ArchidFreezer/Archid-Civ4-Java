package org.archid.civ4.info.era;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IEraWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "EraList";
	
	public enum SheetHeaders {
		TYPE, DESCRIPTION, STRATEGY, NO_GOODIES, NO_ANIMALS, NO_BARB_UNITS, NO_BARB_CITIES, ADVANCED_START_POINTS, STARTING_UNIT_MULTIPLIER, STARTING_DEFENCE_UNITS,
		STARTING_WORKER_UNITS, STARTING_EXPLORE_UNITS, STARTING_GOLD, MAX_CITIES, FREE_POPULATION, START_PERCENT, GROWTH_PERCENT, TRAIN_PERCENT, CONSTRUCT_PERCENT,
		CREATE_PERCENT, RESEARCH_PERCENT, TECH_COST_MODIFIER, BUILD_PERCENT, IMPROVEMENT_PERCENT, GREAT_PEOPLE_PERCENT, CULTURE_PERCENT, ANARCHY_PERCENT, 
		EVENT_CHANCE_PER_TURN, UNIT_RANGE_UNBOUND, UNIT_TERRITORY_UNBOUND, UNIT_RANGE_CHANGE, UNIT_RANGE_MODIFIER, SOUNDTRACK_SPACE, FIRST_SOUNDTRACK_FIRST,
		NATURAL_YIELD_LIMITS, ERA_INFO_SOUNDTRACKS, CITY_SOUNDSCAPES, AUDIO_UNIT_VICTORY_SCRIPT, AUDIO_UNIT_DEFEAT_SCRIPT;
		
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
