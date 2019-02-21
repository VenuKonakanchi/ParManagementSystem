package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_MSTR")
public class AppUser {

	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq",initialValue = 1000, allocationSize=1)
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_FIRST_NM")
	private String firstName;
	
	@Column(name="USER_LAST_NM")
	private String lastName;
	
	@Column(name="USER_EMAIL_TXT")
	private String email;
	
	@Column(name="USER_PHN_NUM",unique=true)
	private String phone;
	
	
	@Column(name="USER_USR_NM",unique=true)
	private String userName;
	
	@Column(name="USER_PWD")
	private String password;
	
	@OneToOne()
	@JoinColumn(name = "user_role_cd")
	private AppUserRole role;
	
	@Column(name="USER_ACTIVE")
	private Boolean userActive;

	

	public AppUser() {
		super();
	}
	



	public AppUser(Integer userId, String firstName, String lastName, String email, String phone, String userName,
			String password, AppUserRole role, Boolean userActive) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.userActive = userActive;
	}




	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public AppUserRole getRole() {
		return role;
	}




	public void setRole(AppUserRole role) {
		this.role = role;
	}




	public Boolean getUserActive() {
		return userActive;
	}




	public void setUserActive(Boolean userActive) {
		this.userActive = userActive;
	}




	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", userActive=" + userActive + "]";
	}


	
	
	
	
}

