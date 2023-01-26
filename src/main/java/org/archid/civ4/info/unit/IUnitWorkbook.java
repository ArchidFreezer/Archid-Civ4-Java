package org.archid.civ4.info.unit;

import org.archid.civ4.info.IInfoWorkbook;
import org.archid.utils.StringUtils;

public interface IUnitWorkbook extends IInfoWorkbook {
	
	public static final String SHEETNAME_LIST = "UnitList";

	public enum SheetHeaders {
		CLASS, TYPE, UNIQUE_NAMES, SPECIAL, CAPTURE, COMBAT_TYPE, SUB_COMBAT_TYPES, DOMAIN, DEFAULT_UNIT_AI, FIXED_AI, MAX_WEAPON_TYPE_TIER, MAX_AMMO_TYPE_TIER, INVISIBLE_TYPE, SEE_INVISIBLES, DESCRIPTION,
		CIVILOPEDIA, STRATEGY, HELP, ADVISOR, ANIMAL, FOOD, NO_BAD_GOODIES, ONLY_DEFENSIVE, NO_CAPTURE, QUICK_COMBAT, RIVAL_TERRITORY, MILITARY_HAPPINESS, MILITARY_SUPPORT, MILITARY_PRODUCTION, PILLAGE, SPY,
		SABOTAGE, DESTROY, STEAL_PLANS, INVESTIGATE, COUNTER_SPY, FOUND, GOLDEN_AGE, INVISIBLE, FIRST_STRIKE_IMMUNE, NO_DEFENSIVE_BONUS, IGNORE_BUILDING_DEFENSE, CAN_MOVE_IMPASSABLE, CAN_MOVE_ALL_TERRAIN,
		FLAT_MOVEMENT_COST, IGNORE_TERRAIN_COST, NUKE_IMMUNE, PREREQ_BONUSES, PREREQ_RELIGION, MECHANIZED, RENDER_BELOW_WATER, RENDER_ALWAYS, SUICIDE, SINGLE_BUILD, SLAVE, LINE_OF_SIGHT, HIDDEN_NATIONALITY,
		ALWAYS_HOSTILE, WORKER_TRADE, MILITARY_TRADE, UNIT_CLASS_UPGRADES, UNIT_CLASS_TARGETS, UNIT_COMBAT_TARGETS, UNIT_CLASS_DEFENDERS, UNIT_COMBAT_DEFENDERS, FLANKING_STRIKES, UNIT_AIS, NOT_UNIT_AIS,
		BUILDS, RELIGION_SPREADS, CORPORATION_SPREADS, GREAT_PEOPLES, SLAVE_SPECIALIST_TYPE, BUILDINGS, FORCE_BUILDINGS, HOLY_CITY, RELIGION_TYPE, STATE_RELIGION, PREREQ_RELIGION_TYPE, PREREQ_CORPORATION,
		PREREQ_BUILDING, PREREQ_TECHS, OBSOLETE_TECH, BONUS_TYPE, PREREQ_OR_BONUSES, PREREQ_AND_CIVICS, PREREQ_OR_CIVICS, PREREQ_AND_TERRAINS, PREREQ_OR_TERRAINS, PREREQ_OR_BUILDING_CLASSES,
		PREREQ_NOT_BUILDING_CLASSES, PREREQ_VICINITY_AND_BONUS, PREREQ_VICINITY_OR_BONUS, PREREQ_VICINITY_IMPROVEMENTS, PREREQ_VICINITY_FEATURES, PREREQ_WORLD_VIEWS, MIN_POPULATION, MIN_CULTURE_LEVEL,
		PREREQ_POWER, PRODUCTION_TRAITS, FLAVORS, AIWEIGHT, COST, HURRY_COST_MODIFIER, ADVANCED_START_COST, ADVANCED_START_COST_INCREASE, MIN_AREA_SIZE, MOVES, UNIT_RANGE_TYPE, NO_REVEAL_MAP,
		AIR_RANGE, AIR_UNIT_CAP, DROP_RANGE, NUKE_RANGE, WORK_RATE, BASE_DISCOVER, DISCOVER_MULTIPLIER, BASE_HURRY, HURRY_MULTIPLIER, BASE_TRADE, TRADE_MULTIPLIER, GREAT_WORK_CULTURE, ESPIONAGE_POINTS,
		SPY_ESCAPE_CHANCE, SPY_EVASION_CHANCE, SPY_INTERCEPT_CHANCE, TERRAIN_IMPASSABLES, FEATURE_IMPASSABLES, TERRAIN_PASSABLE_TECHS, FEATURE_PASSABLE_TECHS, COMBAT, COMBAT_LIMIT, AIR_COMBAT, AIR_COMBAT_LIMIT,
		XP_VALUE_ATTACK, XP_VALUE_DEFENSE, FIRST_STRIKES, CHANCE_FIRST_STRIKES, INTERCEPTION_PROBABILITY, EVASION_PROBABILITY, WITHDRAWAL_PROB, COLLATERAL_DAMAGE, COLLATERAL_DAMAGE_LIMIT, COLLATERAL_DAMAGE_MAX_UNITS,
		CITY_ATTACK, CITY_DEFENSE, ANIMAL_COMBAT, HILLS_ATTACK, HILLS_DEFENSE, TERRAIN_NATIVES, FEATURE_NATIVES, TERRAIN_ATTACKS, TERRAIN_DEFENSES, FEATURE_ATTACKS, FEATURE_DEFENSES, UNIT_CLASS_ATTACK_MODS,
		UNIT_CLASS_DEFENSE_MODS, UNIT_COMBAT_MODS, UNIT_COMBAT_COLLATERAL_IMMUNES, DOMAIN_MODS, BONUS_PRODUCTION_MODIFIERS, YIELDS_FROM_KILL, COMMERCES_FROM_KILL, BOMB_RATE, BOMBARD_RATE, SPECIAL_CARGO, DOMAIN_CARGO,
		CARGO, CONSCRIPTION, CULTURE_GARRISON, EXTRA_COST, ASSET, POWER, UNIT_MESH_GROUPS, FORMATION_TYPE, HOT_KEY, ALT_DOWN, SHIFT_DOWN, CTRL_DOWN, HOT_KEY_PRIORITY, FREE_PROMOTIONS, LEADER_PROMOTION,
		LEADER_EXPERIENCE, ORDER_PRIORITY;
		
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
