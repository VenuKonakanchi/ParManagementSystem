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
	private int userId;
	
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
	private boolean userActive;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public boolean isUserActive() {
		return userActive;
	}

	public void setUserActive(boolean userActive) {
		this.userActive = userActive;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", userName=" + userName + ", role=" + role + ", userActive=" + userActive + "]";
	}
	
	
	
	
}



/*

CREATE TABLE USER_ROLE (
user_role_id int,
user_role_nm varchar,
PRIMARY KEY (user_role_id)
);
CREATE UNIQUE INDEX UQ_USER_ROLE ON  USER_ROLE (user_role_nm);


CREATE TABLE USER_MSTR (
user_id int,
user_first_nm varchar,
user_last_nm varchar,
user_email_txt varchar,
user_phn_num varchar,
user_active boolean,
user_usr_nm varchar,
user_pwd varchar,
user_role_cd int references USER_ROLE(user_role_id),
PRIMARY KEY (user_id)
);
CREATE UNIQUE INDEX UQ_USER_MATR  ON  USER_MSTR (user_phn_num);
*/