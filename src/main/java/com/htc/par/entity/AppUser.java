package com.htc.par.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class AppUser {

	@Id	
	@Column(name="USER_ID")
	private int userId;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private boolean enabled;
	
	@ManyToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLES",
	           joinColumns=@JoinColumn(name="USER_ID"),
	           inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	Set<AppRole> roles = new HashSet<>();
	
	public AppUser() {}
	
	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}

	public AppUser(int userId, String username, String password, String email, boolean enabled) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AppRole> roles) {
		this.roles = roles;
	}
	
	
	
}
