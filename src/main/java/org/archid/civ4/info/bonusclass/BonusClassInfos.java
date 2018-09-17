package org.archid.civ4.info.bonusclass;

import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.archid.civ4.info.AbstractInfos;

@XmlRootElement(name="Civ4BonusClassInfos", namespace="x-schema:CIV4TerrainSchema.xml")
@XmlAccessorType(XmlAccessType.NONE)
public class BonusClassInfos extends AbstractInfos<IBonusClassInfo>{
	
	public BonusClassInfos() {
		super(new TreeMap<String, IBonusClassInfo>());
	}
	
	@XmlJavaTypeAdapter(BonusClassMapAdapter.class)
	@XmlElement(name="BonusClassInfos")
	public Map<String, IBonusClassInfo> getInfoMap() {
		return infos;
	}
	
	public void setInfoMap(Map<String, IBonusClassInfo> infos) {
		this.infos = infos;
	}
	
	public static IBonusClassInfo createInfos(String type) {
		return new BonusClassInfo(type);
	}
	
	private static class BonusClassInfo implements IBonusClassInfo {
		private String type;
		private int unique;
		
		private BonusClassInfo(String type) {
			this.type = type;
		}

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) {
			this.type = type;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonusclass.IBonusClassInfo#getUnique()
		 */
		@Override
		public int getUnique() {
			return unique;
		}

		/* (non-Javadoc)
		 * @see org.archid.civ4.info.bonusclass.IBonusClassInfo#setUnique(int)
		 */
		@Override
		public void setUnique(int unique) {
			this.unique = unique;
		}
	}

}
