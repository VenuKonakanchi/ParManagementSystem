/**
 * 
 */
package com.htc.par.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Key for PARRelation entity
 *
 */

@Embeddable
public class PARRelationKey implements Serializable{

	private static final long serialVersionUID = -594520779853133886L;
	
	private Integer parId;
	
	private Integer roleId;
	
	private Integer skillId;
	
	private Integer areaId;
	
	private Integer extStaffId ;
	
	

	public PARRelationKey() {
		super();
	}

	public PARRelationKey(Integer parId, Integer roleId, Integer skillId, Integer areaId, Integer extStaffId) {
		super();
		this.parId = parId;
		this.roleId = roleId;
		this.skillId = skillId;
		this.areaId = areaId;
		this.extStaffId = extStaffId;
	}


	public Integer getParId() {
		return parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getExtStaffId() {
		return extStaffId;
	}

	public void setExtStaffId(Integer extStaffId) {
		this.extStaffId = extStaffId;
	}
}
