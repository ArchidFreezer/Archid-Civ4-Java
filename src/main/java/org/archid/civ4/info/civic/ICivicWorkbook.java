package org.archid.civ4.info.civic;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface ICivicWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "CivicList";

	public enum SheetHeaders {
		CIVIC_OPTION_TYPE, TYPE, DESCRIPTION, CIVILOPEDIA, STRATEGY, HELP, BUTTON, TECH_PREREQ, CREATE_BARBARIANS, ENABLE_STAR_SIGNS, STAR_SIGN_MITIGATE_CHANGE_PERCENT, STAR_SIGN_SCALE_CHANGE_PERCENT, 
		ANARCHY_LENGTH, UPKEEP, A_I_WEIGHT, GREAT_PEOPLE_RATE_MODIFIER, GREAT_GENERAL_RATE_MODIFIER, DOMESTIC_GREAT_GENERAL_RATE_MODIFIER, STATE_RELIGION_GREAT_PEOPLE_RATE_MODIFIER, 
		DISTANCE_MAINTENANCE_MODIFIER, NUM_CITIES_MAINTENANCE_MODIFIER, CORPORATION_MAINTENANCE_MODIFIER, EXTRA_HEALTH, EXTRA_HAPPINESS, FREE_EXPERIENCE, WORKER_SPEED_MODIFIER, 
		IMPROVEMENT_UPGRADE_RATE_MODIFIER, MILITARY_PRODUCTION_MODIFIER, BASE_FREE_UNITS, BASE_FREE_MILITARY_UNITS, FREE_UNITS_POPULATION_PERCENT, FREE_MILITARY_UNITS_POPULATION_PERCENT, 
		GOLD_PER_UNIT, GOLD_PER_MILITARY_UNIT, HAPPY_PER_MILITARY_UNIT, MILITARY_FOOD_PRODUCTION, TRIBAL_CONSCRIPTION, MAX_CONSCRIPT, UNHEALTHY_POPULATION_MODIFIER, EXP_IN_BORDER_MODIFIER, 
		BUILDING_ONLY_HEALTHY, LARGEST_CITY_HAPPINESS, WAR_WEARINESS_MODIFIER, FREE_SPECIALIST, TRADE_ROUTES, NO_FOREIGN_TRADE, NO_CORPORATIONS, NO_FOREIGN_CORPORATIONS, CIVIC_PERCENT_ANGER, 
		STATE_RELIGION, NO_NON_STATE_RELIGION_SPREAD, STATE_RELIGION_HAPPINESS, NON_STATE_RELIGION_HAPPINESS, STATE_RELIGION_UNIT_PRODUCTION_MODIFIER, STATE_RELIGION_BUILDING_PRODUCTION_MODIFIER, 
		STATE_RELIGION_FREE_EXPERIENCE, UNIT_RANGE_UNBOUND, UNIT_TERRITORY_UNBOUND, UNIT_RANGE_CHANGE, UNIT_RANGE_MODIFIER, CULTURE_DEFENCE_CHANGE, YIELD_MODIFIERS, CAPITAL_YIELD_MODIFIERS, 
		TRADE_YIELD_MODIFIERS, COMMERCE_MODIFIERS, CAPITAL_COMMERCE_MODIFIERS, SPECIALIST_EXTRA_COMMERCES, HURRYS, SPECIAL_BUILDING_NOT_REQUIREDS, SPECIALIST_VALIDS, BUILDING_HAPPINESS_CHANGES, 
		BUILDING_HEALTH_CHANGES, FEATURE_HAPPINESS_CHANGES, IMPROVEMENT_YIELD_CHANGES, WE_LOVE_THE_KING;

		@Override
		public String toString() {
			return StringUtils.titleCaseSpace(this.name(), '_');
		}
	}
}