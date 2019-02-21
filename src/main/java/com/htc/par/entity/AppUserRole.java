package com.htc.par.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class AppUserRole {

	@Id
	@Column(name="USER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_role_seq")
	@SequenceGenerator(name="user_role_seq", sequenceName="user_role_seq",initialValue = 11000, allocationSize=1)
	private Integer roleId;
	
	@Column(name="USER_ROLE_NM")
	private String roleName;
	
	@OneToOne(mappedBy = "role", cascade = CascadeType.ALL)
	private AppUser user;
	
	public AppUserRole() {}

	
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


	public AppUser getUser() {
		return user;
	}


	public void setUser(AppUser user) {
		this.user = user;
	}
	

	@Override
	public String toString() {
		return "AppUserRole [roleId=" + roleId + ", roleName=" + roleName + ", user=" + user + "]";
	}

	
	

	
	
}
