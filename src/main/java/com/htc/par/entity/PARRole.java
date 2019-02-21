package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_LKUP")
public class PARRole {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name="role_seq", sequenceName="role_seq",initialValue = 6000, allocationSize=1)
	private Integer roleId;
	
	@Column(name ="role_nm")
	private String roleName;
	
	@Column(name = "role_active")
	private Boolean roleActive;
	
	public PARRole() {}

	public PARRole(Integer roleId, String roleName, Boolean roleActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleActive = roleActive;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getRoleActive() {
		return roleActive;
	}

	public void setRoleActive(Boolean roleActive) {
		this.roleActive = roleActive;
	}

	@Override
	public String toString() {
		return "PARRole [roleId=" + roleId + ", roleName=" + roleName + ", roleActive=" + roleActive + "]";
	}

		
	

}
