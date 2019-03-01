/**
 * 
 */
package com.htc.par.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class for PAR_RLTN
 *
 */

@Entity
@Table(name = "par_rltn")
public class PARRelation {
	
	@EmbeddedId
	private PARRelationKey parRelationKey;

	@OneToOne
    @MapsId("par_cd")
    @JoinColumn(name = "par_cd", referencedColumnName="par_id")
	private PARMaster parMaster;
	
	@OneToOne
    @MapsId("role_cd")
    @JoinColumn(name = "role_cd", referencedColumnName="role_id")
	private PARRole parRole;
	
	
	@OneToOne
    @MapsId("skill_cd")
    @JoinColumn(name = "skill_cd", referencedColumnName="skill_id")
	private Skill skill;
	
	@OneToOne
    @MapsId("area_cd")
    @JoinColumn(name = "area_cd", referencedColumnName="area_id")
	private Area area;
	
	@OneToOne
    @MapsId("ext_staff_cd")
    @JoinColumn(name = "ext_staff_cd", referencedColumnName="ext_staff_id")
	private ExternalStaff externalStaff;

	public PARRelation() {
		super();
	}

	public PARRelation(PARRelationKey parRelationKey, PARMaster parMaster, PARRole parRole, Skill skill, Area area,
			ExternalStaff externalStaff) {
		super();
		this.parRelationKey = parRelationKey;
		this.parMaster = parMaster;
		this.parRole = parRole;
		this.skill = skill;
		this.area = area;
		this.externalStaff = externalStaff;
	}



	public PARRelation(PARMaster parMaster, PARRole parRole, Skill skill, Area area, ExternalStaff externalStaff) {
		super();
		this.parMaster = parMaster;
		this.parRole = parRole;
		this.skill = skill;
		this.area = area;
		this.externalStaff = externalStaff;
	}

	public PARMaster getParMaster() {
		return parMaster;
	}

	public void setParMaster(PARMaster parMaster) {
		this.parMaster = parMaster;
	}

	public PARRole getParRole() {
		return parRole;
	}

	public void setParRole(PARRole parRole) {
		this.parRole = parRole;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ExternalStaff getExternalStaff() {
		return externalStaff;
	}

	public void setExternalStaff(ExternalStaff externalStaff) {
		this.externalStaff = externalStaff;
	}

	public PARRelationKey getParRelationKey() {
		return parRelationKey;
	}

	public void setParRelationKey(PARRelationKey parRelationKey) {
		this.parRelationKey = parRelationKey;
	}
	
	
}
