package org.archid.civ4.info.building;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IBuildingWorkbook extends IInfoWorkbook {

	public static final String SHEETNAME_LIST = "BuildingList";
	
	public enum SheetHeaders {
		BUILDING_CLASS, TYPE, SPECIAL_BUILDING_TYPE, DESCRIPTION, CIVILOPEDIA, STRATEGY, HELP, ADVISOR, ART_DEFINE_TAG, MOVIE_DEFINE_TAG, IS_AUTO_BUILD, HOLY_CITY, RELIGION_TYPE, STATE_RELIGION,
		IS_STATE_RELIGION, PREREQ_RELIGION, PREREQ_CORPORATION, FOUNDS_CORPORATION, GLOBAL_RELIGION_COMMERCE, GLOBAL_CORPORATION_COMMERCE, VICTORY_PREREQ, FREE_START_ERA, MAX_START_ERA, OBSOLETE_TECH,
		PREREQ_AND_TECHS, PREREQ_BONUS, PREREQ_OR_BONUSES, PREREQ_AND_CIVICS, PREREQ_OR_CIVICS, PREREQ_AND_TERRAINS, PREREQ_OR_TERRAINS, PREREQ_VICINITY_AND_BONUS, PREREQ_VICINITY_OR_BONUS,
		PREREQ_VICINITY_IMPROVEMENTS, PREREQ_VICINITY_FEATURES, PREREQ_WORLD_VIEWS, MIN_POPULATION, MIN_CULTURE_LEVEL, IS_PREREQ_POWER, PRODUCTION_TRAITS, HAPPINESS_TRAITS, NO_BONUS, POWER_BONUS,
		FREE_BONUS, NUM_FREE_BONUSES, FREE_BUILDING, FREE_PROMOTION, CIVIC_OPTION, GREAT_PEOPLE_UNIT_CLASS, GREAT_PEOPLE_RATE_CHANGE, HURRY_ANGER_MODIFIER, IS_BORDER_OBSTACLE, IS_TEAM_SHARE, IS_WATER,
		IS_RIVER, IS_POWER, IS_DIRTY_POWER, IS_AREA_CLEAN_POWER, DIPLO_VOTE_TYPE, IS_FORCE_TEAM_VOTE_ELIGIBLE, IS_CAPITAL, IS_GOVERNMENT_CENTER, IS_GOLDEN_AGE, IS_ALLOWS_NUKES, IS_MAP_CENTERING,
		IS_NO_UNHAPPINESS, UNHEALTHY_POPULATION_MODIFIER, IS_BUILDING_ONLY_HEALTHY, IS_NEVER_CAPTURE, IS_NUKE_IMMUNE, IS_PREREQ_RELIGION, IS_CENTER_IN_CITY, IS_SLAVE_MARKET, IS_FORCE_DISABLE_STAR_SIGNS,
		IS_STAR_SIGN_GOOD_ONLY, STAR_SIGN_MITIGATE_CHANGE_PERCENT, GLOBAL_STAR_SIGN_MITIGATE_CHANGE_PERCENT, STAR_SIGN_SCALE_CHANGE_PERCENT, GLOBAL_STAR_SIGN_SCALE_CHANGE_PERCENT, AIWEIGHT, COST,
		HURRY_COST_MODIFIER, ADVANCED_START_COST, ADVANCED_START_COST_INCREASE, MIN_AREA_SIZE, CONQUEST_PROB, CITIES_PREREQ, TEAMS_PREREQ, LEVEL_PREREQ, MIN_LATITUDE, MAX_LATITUDE, WORKABLE_RADIUS,
		GREAT_PEOPLE_RATE_MODIFIER, GREAT_GENERAL_RATE_MODIFIER, DOMESTIC_GREAT_GENERAL_RATE_MODIFIER, GLOBAL_GREAT_PEOPLE_RATE_MODIFIER, ANARCHY_MODIFIER, GOLDEN_AGE_MODIFIER, GLOBAL_HURRY_MODIFIER,
		EXPERIENCE, GLOBAL_EXPERIENCE, FOOD_KEPT, AIRLIFT, AIR_MODIFIER, AIR_UNIT_CAPACITY, NUKE_MODIFIER, NUKE_EXPLOSION_RAND, FREE_SPECIALIST, AREA_FREE_SPECIALIST, GLOBAL_FREE_SPECIALIST,
		MAINTENANCE_MODIFIER, WAR_WEARINESS_MODIFIER, GLOBAL_WAR_WEARINESS_MODIFIER, ENEMY_WAR_WEARINESS_MODIFIER, HEAL_RATE_CHANGE, HEALTH, AREA_HEALTH, GLOBAL_HEALTH, HAPPINESS, AREA_HAPPINESS,
		GLOBAL_HAPPINESS, STATE_RELIGION_HAPPINESS, WORKER_SPEED_MODIFIER, MILITARY_PRODUCTION_MODIFIER, SPACE_PRODUCTION_MODIFIER, GLOBAL_SPACE_PRODUCTION_MODIFIER, TRADE_ROUTES, COASTAL_TRADE_ROUTES,
		GLOBAL_TRADE_ROUTES, TRADE_ROUTE_MODIFIER, FOREIGN_TRADE_ROUTE_MODIFIER, GLOBAL_POPULATION_CHANGE, FREE_TECHS, DEFENSE, OBSOLETE_DEFENCE, BOMBARD_DEFENSE, ALL_CITY_DEFENSE, ESPIONAGE_DEFENSE, ASSET, POWER,
		VISIBILITY_PRIORITY, SEA_PLOT_YIELD_CHANGES, RIVER_PLOT_YIELD_CHANGES, GLOBAL_SEA_PLOT_YIELD_CHANGES, YIELD_CHANGES, YIELD_MODIFIERS, POWER_YIELD_MODIFIERS, AREA_YIELD_MODIFIERS, GLOBAL_YIELD_MODIFIERS,
		COMMERCE_CHANGES, OBSOLETE_SAFE_COMMERCE_CHANGES, COMMERCE_CHANGE_DOUBLE_TIMES, COMMERCE_MODIFIERS, GLOBAL_COMMERCE_MODIFIERS, SPECIALIST_EXTRA_COMMERCES, STATE_RELIGION_COMMERCES, COMMERCE_HAPPINESSES,
		RELIGION_CHANGES, SPECIALIST_COUNTS, FREE_SPECIALIST_COUNTS, COMMERCE_FLEXIBLES, COMMERCE_CHANGE_ORIGINAL_OWNERS, CONSTRUCT_SOUND, BONUS_HEALTH_CHANGES, BONUS_HAPPINESS_CHANGES,
		BONUS_PRODUCTION_MODIFIERS, UNIT_COMBAT_FREE_EXPERIENCES, DOMAIN_FREE_EXPERIENCES, DOMAIN_PRODUCTION_MODIFIERS, BUILDING_HAPPINESS_CHANGES, PREREQ_NUM_OF_BUILDING_CLASSES, PREREQ_AND_BUILDING_CLASSES,
		PREREQ_OR_BUILDING_CLASSES, PREREQ_NOT_BUILDING_CLASSES, REPLACED_BY_BUILDING_CLASSES, SPECIALIST_YIELD_CHANGES, BONUS_YIELD_MODIFIERS, VICINITY_BONUS_YIELD_CHANGES, IMPROVEMENT_FREE_SPECIALISTS,
		FLAVORS, HOT_KEY, IS_ALT_DOWN, IS_SHIFT_DOWN, IS_CTRL_DOWN, HOT_KEY_PRIORITY, ORDER_PRIORITY, GRAPHICAL_ONLY;
		
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
