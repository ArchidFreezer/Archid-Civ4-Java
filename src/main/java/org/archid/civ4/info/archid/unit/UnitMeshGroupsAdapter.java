package org.archid.civ4.info.archid.unit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.archid.civ4.info.archid.unit.UnitInfos.UnitMeshGroup;
import org.archid.civ4.info.archid.unit.UnitInfos.UnitMeshGroups;
import org.archid.utils.CollectionUtils;
import org.archid.utils.JaxbUtils;

public class UnitMeshGroupsAdapter extends XmlAdapter<UnitMeshGroupsAdapter.AdaptedUnitMeshGroups, UnitMeshGroups>{
	
	public static class AdaptedUnitMeshGroups {
		@XmlElement(name="iGroupSize")
		private Integer groupSize;
		@XmlElement(name="fMaxSpeed")
		private Float maxSpeed;
		@XmlElement(name="fPadTime")
		private Float padTime;
		@XmlElement(name="iMeleeWaveSize")
		private Integer meleeWaveSize;
		@XmlElement(name="iRangedWaveSize")
		private Integer rangedWaveSize;
		@XmlElement(name="UnitMeshGroup")
		private List<AdaptedUnitMeshGroup> meshGroups;
	}
	
	public static class AdaptedUnitMeshGroup {
		@XmlElement(name="iRequired")
		private Integer required;
		@XmlElement(name="EarlyArtDefineTag")
		private String earlyArtDefineTag;
		@XmlElement(name="LateArtDefineTag")
		private String lateArtDefineTag;
		@XmlElement(name="MiddleArtDefineTag")
		private String middleArtDefineTag;
	}

	@Override
	public UnitMeshGroups unmarshal(AdaptedUnitMeshGroups v) throws Exception {
		UnitMeshGroups group = new UnitMeshGroups();
		group.setGroupSize(JaxbUtils.unmarshallInteger(v.groupSize));
		group.setMaxSpeed(JaxbUtils.unmarshallFloat(v.maxSpeed));
		group.setPadTime(JaxbUtils.unmarshallFloat(v.padTime));
		group.setMeleeWaveSize(JaxbUtils.unmarshallInteger(v.meleeWaveSize));
		group.setRangedWaveSize(JaxbUtils.unmarshallInteger(v.rangedWaveSize));
		if (CollectionUtils.hasElements(v.meshGroups)) {
			for (AdaptedUnitMeshGroup meshGroup: v.meshGroups) {
				UnitMeshGroup mesh = new UnitMeshGroup();
				mesh.setRequired(JaxbUtils.unmarshallInteger(meshGroup.required));
				mesh.setEarlyArtDefineTag(JaxbUtils.unmarshallString(meshGroup.earlyArtDefineTag));
				mesh.setMiddleArtDefineTag(JaxbUtils.unmarshallString(meshGroup.middleArtDefineTag));
				mesh.setLateArtDefineTag(JaxbUtils.unmarshallString(meshGroup.lateArtDefineTag));
				group.getUnitMeshGroupList().add(mesh);
			}
		}
		return group;
	}

	@Override
	public AdaptedUnitMeshGroups marshal(UnitMeshGroups v) throws Exception {
		AdaptedUnitMeshGroups group = new AdaptedUnitMeshGroups();
		group.groupSize = JaxbUtils.marshallInteger(v.getGroupSize());
		group.maxSpeed = JaxbUtils.marshallFloat(v.getMaxSpeed());
		group.padTime = JaxbUtils.marshallFloat(v.getPadTime());
		group.meleeWaveSize = JaxbUtils.marshallInteger(v.getMeleeWaveSize());
		group.rangedWaveSize = JaxbUtils.marshallInteger(v.getRangedWaveSize());
		if (CollectionUtils.hasElements(v.getUnitMeshGroupList())) {
			group.meshGroups = new ArrayList<AdaptedUnitMeshGroup>();
			for (UnitMeshGroup meshGroup: v.getUnitMeshGroupList()) {
				AdaptedUnitMeshGroup mesh = new AdaptedUnitMeshGroup();
				mesh.required = JaxbUtils.marshallInteger(meshGroup.getRequired());
				mesh.earlyArtDefineTag = JaxbUtils.marshallString(meshGroup.getEarlyArtDefineTag());
				mesh.middleArtDefineTag = JaxbUtils.marshallString(meshGroup.getMiddleArtDefineTag());
				mesh.lateArtDefineTag = JaxbUtils.marshallString(meshGroup.getLateArtDefineTag());
				group.meshGroups.add(mesh);
			}
		}
		return group;
	}

}
