package org.archid.civ4.info.unit;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.archid.civ4.info.AbstractImporter;
import org.archid.civ4.info.IInfoWorkbook;
import org.archid.civ4.info.IInfos;
import org.archid.civ4.info.InfosFactory.EInfos;
import org.archid.civ4.info.unit.UnitInfos.UnitMeshGroup;
import org.archid.civ4.info.unit.UnitInfos.UnitMeshGroups;
import org.archid.utils.IPair;
import org.archid.utils.StringUtils;

public class UnitImporter extends AbstractImporter<IInfos<IUnitInfo>, IUnitInfo>{

	/** Logging facility */
	static Logger log = Logger.getLogger(UnitImporter.class.getName());
	
	public UnitImporter(EInfos infoEnum) {
		super(infoEnum, new UnitInfoXmlFormatter());
	}
	
	@Override
	protected IUnitInfo parseRow(Row row) {
		int colNum = 0;
		String clazz = row.getCell(colNum++).getStringCellValue();
		String type = row.getCell(colNum++).getStringCellValue();
		
		// Handle units that have been deleted
		if (clazz.isEmpty() || type.isEmpty())
			return null;
		
		IUnitInfo info = UnitInfos.createInfo(type);
		info.setUnitClass(clazz);
		
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUniqueName(str);
		}
	
		info.setSpecial(row.getCell(colNum++).getStringCellValue());
		info.setCapture(row.getCell(colNum++).getStringCellValue());
		info.setCombatType(row.getCell(colNum++).getStringCellValue());

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addSubCombatType(str);
		}
	
		info.setDomain(row.getCell(colNum++).getStringCellValue());
		info.setDefaultUnitAI(row.getCell(colNum++).getStringCellValue());
		info.setFixedAI(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMaxWeaponTypeTier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setMaxAmmoTypeTier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setInvisibleType(row.getCell(colNum++).getStringCellValue());

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addSeeInvisble(str);
		}
	
		info.setDescription(row.getCell(colNum++).getStringCellValue());
		info.setCivilopedia(row.getCell(colNum++).getStringCellValue());
		info.setStrategy(row.getCell(colNum++).getStringCellValue());
		info.setHelp(row.getCell(colNum++).getStringCellValue());
		info.setAdvisor(row.getCell(colNum++).getStringCellValue());
		info.setAnimal(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setFood(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setNoBadGoodies(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setOnlyDefensive(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setNoCapture(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setQuickCombat(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setRivalTerritory(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMilitaryHappiness(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMilitarySupport(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMilitaryProduction(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setPillage(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setSpy(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setSabotage(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setDestroy(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setStealPlans(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setInvestigate(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setCounterSpy(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setFound(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setGoldenAge(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setInvisible(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setFirstStrikeImmune(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setNoDefensiveBonus(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setIgnoreBuildingDefense(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setCanMoveImpassable(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setCanMoveAllTerrain(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setFlatMovementCost(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setIgnoreTerrainCost(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setNukeImmune(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setPrereqBonuses(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setPrereqReligion(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMechanized(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setRenderBelowWater(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setRenderAlways(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setSuicide(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setSingleBuild(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setSlave(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setLineOfSight(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setHiddenNationality(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setAlwaysHostile(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setWorkerTrade(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setMilitaryTrade(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitClassUpgrade(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitClassTarget(type);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitCombatTarget(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitClassDefender(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitCombatDefender(str);
		}
	
		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addFlankingStrike(pair);
		}

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addUnitAI(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addNotUnitAIs(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addBuild(str);
		}
	
		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addReligionSpread(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addCorporationSpread(pair);
		}

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addGreatPerson(str);
		}
	
		info.setSlaveSpecialistType(row.getCell(colNum++).getStringCellValue());
		
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addBuilding(str);
		}

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addForceBuildings(str);
		}
	
		info.setHolyCity(row.getCell(colNum++).getStringCellValue());
		info.setReligionType(row.getCell(colNum++).getStringCellValue());
		info.setStateReligion(row.getCell(colNum++).getStringCellValue());
		info.setPrereqReligionType(row.getCell(colNum++).getStringCellValue());
		info.setPrereqCorporation(row.getCell(colNum++).getStringCellValue());
		info.setPrereqBuilding(row.getCell(colNum++).getStringCellValue());
		
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqTech(str);
		}
	
		info.setObsoleteTech(row.getCell(colNum++).getStringCellValue());
		info.setBonusType(row.getCell(colNum++).getStringCellValue());

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqOrBonus(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqAndCivic(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqOrCivic(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqAndTerrain(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqOrTerrain(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqOrBuildingClass(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqNotBuildingClass(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqVicinityAndBonus(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqVicinityOrBonus(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqVicinityImprovement(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqVicinityFeature(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addPrereqWorldView(str);
		}
	
		info.setMinPopulation(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setMinCultureLevel(row.getCell(colNum++).getStringCellValue());
		info.setPrereqPower(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		
		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addProductionTrait(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addFlavour(pair);
		}

		info.setAiWeight(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCost(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setEnslaveCount(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setHurryCostModifier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAdvancedStartCost(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAdvancedStartCostIncrease(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setMinAreaSize(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setMoves(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setUnitRangeType(row.getCell(colNum++).getStringCellValue());
		info.setNoRevealMap(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setAirRange(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAirUnitCap(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setDropRange(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setNukeRange(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setWorkRate(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setBaseDiscover(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setDiscoverMultiplier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setBaseHurry(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setHurryMultiplier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setBaseTrade(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setTradeMultiplier(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setGreatWorkCulture(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setEspionagePoints(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setSpyEscapeChance(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setSpyEvasionChance(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setSpyInterceptChance(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addTerrainImpassable(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addFeatureImpassable(str);
		}
	
		for (IPair<String, String> pair: parsePairs(row.getCell(colNum++), String.class, String.class)) {
			info.addTerrainPassableTech(pair);
		}

		for (IPair<String, String> pair: parsePairs(row.getCell(colNum++), String.class, String.class)) {
			info.addFeaturePassableTech(pair);
		}

		info.setCombat(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCombatLimit(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAirCombat(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAirCombatLimit(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setXpValueAttack(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setXpValueDefense(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setFirstStrikes(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setChanceFirstStrikes(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setInterceptionProbability(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setEvasionProbability(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setWithdrawalProb(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCollateralDamage(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCollateralDamageLimit(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCollateralDamageMaxUnits(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCityAttack(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCityDefense(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAnimalCombat(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setHillsAttack(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setHillsDefense(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addTerrainNative(str);
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addFeatureNative(str);
		}
	
		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addTerrainAttack(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addTerrainDefense(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addFeatureAttacks(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addFeatureDefense(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addUnitClassAttackMod(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addUnitClassDefenseMod(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addUnitCombatMod(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addUnitCombatCollateralImmune(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addDomainMod(pair);
		}

		for (IPair<String, Integer> pair: parsePairs(row.getCell(colNum++), String.class, Integer.class)) {
			info.addBonusProductionModifier(pair);
		}

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addYieldFromKill(Integer.parseInt(str));
		}
	
		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addCommerceFromKill(Integer.parseInt(str));
		}
	
		info.setBombRate(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setBombardRate(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setSpecialCargo(row.getCell(colNum++).getStringCellValue());
		info.setDomainCargo(row.getCell(colNum++).getStringCellValue());
		info.setCargo(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setConscription(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setCultureGarrison(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setExtraCost(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setAsset(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setPower(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setUnitMeshGroups(getUnitMeshGroups(row.getCell(colNum++).getStringCellValue()));
		info.setFormationType(row.getCell(colNum++).getStringCellValue());
		info.setHotKey(row.getCell(colNum++).getStringCellValue());
		info.setAltDown(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setShiftDown(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setCtrlDown(Boolean.parseBoolean(row.getCell(colNum++).getStringCellValue()));
		info.setHotKeyPriority(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));

		for (String str: row.getCell(colNum++).getStringCellValue().split(IInfoWorkbook.CELL_NEWLINE)) {
			if (StringUtils.hasCharacters(str))
				info.addFreePromotion(str);
		}
	
		info.setLeaderPromotion(row.getCell(colNum++).getStringCellValue());
		info.setLeaderExperience(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		info.setOrderPriority(Integer.parseInt(row.getCell(colNum++).getStringCellValue()));
		
		return info;
	}

	private UnitMeshGroups getUnitMeshGroups(String stringCellValue) {
		String[] rows = stringCellValue.split(IInfoWorkbook.CELL_NEWLINE);
		int index = 0;
		UnitMeshGroups mesh = new UnitMeshGroups();
		mesh.setGroupSize(Integer.parseInt(rows[index++]));
		mesh.setMaxSpeed(Float.parseFloat(rows[index++]));
		mesh.setPadTime(Float.parseFloat(rows[index++]));
		mesh.setMeleeWaveSize(Integer.parseInt(rows[index++]));
		mesh.setRangedWaveSize(Integer.parseInt(rows[index++]));
		List<UnitMeshGroup> groups = new ArrayList<UnitMeshGroup>();
		while (index < rows.length) {
			String row = rows[index++];
			if (row.equals(IUnitWorkbook.CELL_GROUP_DELIM)) {
				UnitMeshGroup group = new UnitMeshGroup();
				group.setRequired(Integer.parseInt(rows[index++].trim()));
				group.setEarlyArtDefineTag(rows[index++].trim());
				group.setLateArtDefineTag(StringUtils.getNullIfEmpty(rows[index++].trim()));
				group.setMiddleArtDefineTag(StringUtils.getNullIfEmpty(rows[index++].trim()));
				groups.add(group);
			}
			mesh.setUnitMeshGroupList(groups);
		}
		return mesh;
	}

	/* (non-Javadoc)
	 * @see org.archid.civ4.info.IImporter#getListSheetName()
	 */
	@Override
	public String getListSheetName() {
		return IUnitWorkbook.SHEETNAME_LIST;
	}

}
