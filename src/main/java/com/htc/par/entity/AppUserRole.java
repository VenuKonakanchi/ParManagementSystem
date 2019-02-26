package com.htc.par.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<AppUser> users;
	
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


	public Set<AppUser> getUsers() {
		return users;
	}


	public void setUsers(Set<AppUser> users) {
		this.users = users;
	}
	

	@Override
	public String toString() {
		return "AppUserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	
	

	
	
}
