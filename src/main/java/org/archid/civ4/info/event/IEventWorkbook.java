package org.archid.civ4.info.event;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IEventWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "EventList";

	public enum SheetHeaders {
		TYPE, DESCRIPTION, LOCAL_INFO_TEXT, WORLD_NEWS_TEXTS, OTHER_PLAYER_POPUP, QUEST_FAIL_TEXT, QUEST, GLOBAL, TEAM, PICK_CITY, PICK_OTHER_PLAYER_CITY, DECLARE_WAR, GOLD, GOLD_TO_PLAYER, 
		RANDOM_GOLD, CULTURE, ESPIONAGE_POINTS, GOLDEN_AGE, FREE_UNIT_SUPPORT, INFLATION_MOD, SPACE_PRODUCTION_MOD, TECH, TECH_FLAVORS, TECH_PERCENT, TECH_COST_PERCENT, TECH_MIN_TURNS_LEFT, 
		PREREQ_TECH, UNIT_CLASS, NUM_FREE_UNITS, DISBAND_UNIT, UNIT_EXPERIENCE, UNIT_IMMOBILE_TURNS, UNIT_PROMOTION, UNIT_NAME, UNIT_COMBAT_PROMOTIONS, UNIT_CLASS_PROMOTIONS, 
		BUILDING_CLASS, BUILDING_CHANGE, BUILDING_EXTRA_YIELDS, BUILDING_EXTRA_COMMERCES, BUILDING_EXTRA_HAPPIES, BUILDING_EXTRA_HEALTHS, HAPPY, HEALTH, HURRY_ANGER, HAPPY_TURNS, 
		REVOLT_TURNS, MIN_PILLAGE, MAX_PILLAGE, FOOD, FOOD_PERCENT, FREE_SPECIALIST_COUNTS, FEATURE_TYPE, FEATURE_CHANGE, IMPROVEMENT_TYPE, IMPROVEMENT_CHANGE, BONUS_TYPE, BONUS_CHANGE, 
		ROUTE_TYPE, ROUTE_CHANGE, BONUS_REVEALED, BONUS_GIFT, PLOT_EXTRA_YIELDS, CONVERT_OWN_CITIES, CONVERT_OTHER_CITIES, MAX_NUM_RELIGIONS, OUR_ATTITUDE_MODIFIER, ATTITUDE_MODIFIER, 
		THEIR_ENEMY_ATTITUDE_MODIFIER, POPULATION_CHANGE, ADDITIONAL_EVENTS, EVENT_TIMES, CLEAR_EVENTS, PYTHON_CALLBACK, PYTHON_EXPIRE_CHECK, PYTHON_CAN_DO, PYTHON_HELP, BUTTON, 
		A_I_VALUE;

		@Override
		public String toString() {
			return StringUtils.titleCaseSpace(this.name(), '_');
		}
	}
}