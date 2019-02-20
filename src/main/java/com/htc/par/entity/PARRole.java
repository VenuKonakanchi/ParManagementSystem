package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_LKUP")
public class PARRole {
	
	@Id
	@Column(name = "role_id")
	private int roleId;
	@Column(name ="role_nm")
	private String roleName;
	
	public PARRole() {}

	public PARRole(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "PARRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	

}
