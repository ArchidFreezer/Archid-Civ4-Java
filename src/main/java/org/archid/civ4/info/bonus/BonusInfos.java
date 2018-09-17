package org.archid.civ4.info.bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.archid.civ4.info.AbstractInfos;

@XmlRootElement(name="Civ4BonusInfos", namespace="x-schema:CIV4TerrainSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class BonusInfos extends AbstractInfos<IBonusInfo> {
	
	public BonusInfos() {
		super(new TreeMap<String, IBonusInfo>());
	}
	
	@XmlJavaTypeAdapter(BonusMapAdapter.class)
	@XmlElement(name="BonusInfos")
	public Map<String, IBonusInfo> getInfoMap() {
		return infos;
	}
	
	public static IBonusInfo createInfo(String type) {
		return new BonusInfo(type);
	}
	
	@Override
	public void setInfoMap(Map<String, IBonusInfo> infos) {
		this.infos = infos;
	}
	
	private static class BonusInfo implements IBonusInfo {
		private String artDefineTag;
		private String bonusClassType;
		private String civilopedia;
		private String description;
		private String help;
		private String techCityTrade;
		private String techObsolete;
		private String techReveal;
		private String type;
		private int aiTradeModifier;
		private int aiObjective;
		private int constAppearance;
		private int groupRand;
		private int groupRange;
		private int happiness;
		private int health;
		private int maxLatitude;
		private int minAreaSize;
		private int minLandPercent;
		private int minLatitude;
		private int placementOrder;
		private int player;
		private int tilesPer;
		private int unique;
		private boolean area;
		private boolean flatlands;
		private boolean hills;
		private boolean noRiverSide;
		private boolean normalize;
		private boolean peaks;
		private boolean useLSystem;
		private List<String> featureBooleans = new ArrayList<String>();
		private List<String> featureTerrainBooleans = new ArrayList<String>();
		private List<String> terrainBooleans = new ArrayList<String>();
		private List<Integer> rands = new ArrayList<Integer>();
		private List<Integer> yieldChanges = new ArrayList<Integer>();
		
		private BonusInfo(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getArtDefineTag()
		 */
		@Override
		public String getArtDefineTag() {
			return artDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setArtDefineTag(java.lang.String)
		 */
		@Override
		public void setArtDefineTag(String artDefineTag) {
			this.artDefineTag = artDefineTag;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getBonusClassType()
		 */
		@Override
		public String getBonusClassType() {
			return bonusClassType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setBonusClassType(java.lang.String)
		 */
		@Override
		public void setBonusClassType(String bonusClassType) {
			this.bonusClassType = bonusClassType;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getCivilopedia()
		 */
		@Override
		public String getCivilopedia() {
			return civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setCivilopedia(java.lang.String)
		 */
		@Override
		public void setCivilopedia(String civilopedia) {
			this.civilopedia = civilopedia;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getDescription()
		 */
		@Override
		public String getDescription() {
			return description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setDescription(java.lang.String)
		 */
		@Override
		public void setDescription(String description) {
			this.description = description;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getHelp()
		 */
		@Override
		public String getHelp() {
			return help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setHelp(java.lang.String)
		 */
		@Override
		public void setHelp(String help) {
			this.help = help;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getTechCityTrade()
		 */
		@Override
		public String getTechCityTrade() {
			return techCityTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setTechCityTrade(java.lang.String)
		 */
		@Override
		public void setTechCityTrade(String techCityTrade) {
			this.techCityTrade = techCityTrade;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getTechObsolete()
		 */
		@Override
		public String getTechObsolete() {
			return techObsolete;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setTechObsolete(java.lang.String)
		 */
		@Override
		public void setTechObsolete(String techObsolete) {
			this.techObsolete = techObsolete;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getTechReveal()
		 */
		@Override
		public String getTechReveal() {
			return techReveal;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setTechReveal(java.lang.String)
		 */
		@Override
		public void setTechReveal(String techReveal) {
			this.techReveal = techReveal;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getType()
		 */
		@Override
		public String getType() {
			return type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setType(java.lang.String)
		 */
		@Override
		public void setType(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getAiTradeModifier()
		 */
		@Override
		public int getAiTradeModifier() {
			return aiTradeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setAiTradeModifier(int)
		 */
		@Override
		public void setAiTradeModifier(int aiTradeModifier) {
			this.aiTradeModifier = aiTradeModifier;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getAiObjective()
		 */
		@Override
		public int getAiObjective() {
			return aiObjective;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setAiObjective(int)
		 */
		@Override
		public void setAiObjective(int aiObjective) {
			this.aiObjective = aiObjective;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getConstAppearance()
		 */
		@Override
		public int getConstAppearance() {
			return constAppearance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setConstAppearance(int)
		 */
		@Override
		public void setConstAppearance(int constAppearance) {
			this.constAppearance = constAppearance;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getGroupRand()
		 */
		@Override
		public int getGroupRand() {
			return groupRand;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setGroupRand(int)
		 */
		@Override
		public void setGroupRand(int groupRand) {
			this.groupRand = groupRand;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getGroupRange()
		 */
		@Override
		public int getGroupRange() {
			return groupRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setGroupRange(int)
		 */
		@Override
		public void setGroupRange(int groupRange) {
			this.groupRange = groupRange;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getHappiness()
		 */
		@Override
		public int getHappiness() {
			return happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setHappiness(int)
		 */
		@Override
		public void setHappiness(int happiness) {
			this.happiness = happiness;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getHealth()
		 */
		@Override
		public int getHealth() {
			return health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setHealth(int)
		 */
		@Override
		public void setHealth(int health) {
			this.health = health;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getMaxLatitude()
		 */
		@Override
		public int getMaxLatitude() {
			return maxLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setMaxLatitude(int)
		 */
		@Override
		public void setMaxLatitude(int maxLatitude) {
			this.maxLatitude = maxLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getMinAreaSize()
		 */
		@Override
		public int getMinAreaSize() {
			return minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setMinAreaSize(int)
		 */
		@Override
		public void setMinAreaSize(int minAreaSize) {
			this.minAreaSize = minAreaSize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getMinLandPercent()
		 */
		@Override
		public int getMinLandPercent() {
			return minLandPercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setMinLandPercent(int)
		 */
		@Override
		public void setMinLandPercent(int minLandPercent) {
			this.minLandPercent = minLandPercent;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getMinLatitude()
		 */
		@Override
		public int getMinLatitude() {
			return minLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setMinLatitude(int)
		 */
		@Override
		public void setMinLatitude(int minLatitude) {
			this.minLatitude = minLatitude;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getPlacementOrder()
		 */
		@Override
		public int getPlacementOrder() {
			return placementOrder;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setPlacementOrder(int)
		 */
		@Override
		public void setPlacementOrder(int placementOrder) {
			this.placementOrder = placementOrder;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getPlayer()
		 */
		@Override
		public int getPlayer() {
			return player;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setPlayer(int)
		 */
		@Override
		public void setPlayer(int player) {
			this.player = player;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getTilesPer()
		 */
		@Override
		public int getTilesPer() {
			return tilesPer;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setTilesPer(int)
		 */
		@Override
		public void setTilesPer(int tilesPer) {
			this.tilesPer = tilesPer;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getUnique()
		 */
		@Override
		public int getUnique() {
			return unique;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setUnique(int)
		 */
		@Override
		public void setUnique(int unique) {
			this.unique = unique;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isArea()
		 */
		@Override
		public boolean isArea() {
			return area;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setArea(boolean)
		 */
		@Override
		public void setArea(boolean area) {
			this.area = area;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isFlatlands()
		 */
		@Override
		public boolean isFlatlands() {
			return flatlands;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setFlatlands(boolean)
		 */
		@Override
		public void setFlatlands(boolean flatlands) {
			this.flatlands = flatlands;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isHills()
		 */
		@Override
		public boolean isHills() {
			return hills;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setHills(boolean)
		 */
		@Override
		public void setHills(boolean hills) {
			this.hills = hills;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isNoRiverSide()
		 */
		@Override
		public boolean isNoRiverSide() {
			return noRiverSide;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setNoRiverSide(boolean)
		 */
		@Override
		public void setNoRiverSide(boolean noRiverSide) {
			this.noRiverSide = noRiverSide;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isNormalize()
		 */
		@Override
		public boolean isNormalize() {
			return normalize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setNormalize(boolean)
		 */
		@Override
		public void setNormalize(boolean normalize) {
			this.normalize = normalize;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isPeaks()
		 */
		@Override
		public boolean isPeaks() {
			return peaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setPeaks(boolean)
		 */
		@Override
		public void setPeaks(boolean peaks) {
			this.peaks = peaks;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#isUseLSystem()
		 */
		@Override
		public boolean isUseLSystem() {
			return useLSystem;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#setUseLSystem(boolean)
		 */
		@Override
		public void setUseLSystem(boolean useLSystem) {
			this.useLSystem = useLSystem;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getFeatureBooleans()
		 */
		@Override
		public List<String> getFeatureBooleans() {
			return featureBooleans;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#addFeatureBoolean(java.lang.String)
		 */
		@Override
		public void addFeatureBoolean(String featureBoolean) {
			this.featureBooleans.add(featureBoolean);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getFeatureTerrainBooleans()
		 */
		@Override
		public List<String> getFeatureTerrainBooleans() {
			return featureTerrainBooleans;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#addFeatureTerrainBoolean(java.lang.String)
		 */
		@Override
		public void addFeatureTerrainBoolean(String featureTerrainBoolean) {
			this.featureTerrainBooleans.add(featureTerrainBoolean);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getTerrainBooleans()
		 */
		@Override
		public List<String> getTerrainBooleans() {
			return terrainBooleans;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#addTerrainBoolean(java.lang.String)
		 */
		@Override
		public void addTerrainBoolean(String terrainBoolean) {
			this.terrainBooleans.add(terrainBoolean);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getRands()
		 */
		@Override
		public List<Integer> getRands() {
			return rands;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#addRand(java.lang.Integer)
		 */
		@Override
		public void addRand(Integer rand) {
			this.rands.add(rand);
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#getYieldChanges()
		 */
		@Override
		public List<Integer> getYieldChanges() {
			return yieldChanges;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonus.IBonusInfo#addYieldChange(java.lang.Integer)
		 */
		@Override
		public void addYieldChange(Integer yieldChange) {
			this.yieldChanges.add(yieldChange);
		}
	}

}
