package com.htc.par.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserTO {

	private Integer userId;
	 @NotEmpty(message = "First Name cannot be empty")
	 @NotNull(message = "First Name cannot be null")
	 @Pattern(regexp="^[A-Za-z ]+$",message="Invalid First Name ")
	private String firstName;
	 @NotEmpty(message = "Last Name cannot be null")
	 @Pattern(regexp="^[A-Za-z ]+$",message="Invalid Last Name ")
	 @NotEmpty(message = "First Name cannot be empty")
	private String lastName;
	@Email(message="Email should be valid")
	private String email;
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone Number")
	private String phone;
	 @NotNull(message = "User Name cannot be null")
	 @NotEmpty(message = "User Name cannot be empty")
	private String userName;
	 @NotNull(message = "Password cannot be null")
	 @NotEmpty(message = "User Name cannot be empty")
	private String password;
	@NotNull(message="Role can not be null")
	private RoleTO role;
	
	private Boolean userActive=true;

	public UserTO() {
		super();
	}

	public UserTO(Integer userId, @NotEmpty(message = "First Name cannot be null") String firstName,
			@NotEmpty(message = "Last Name cannot be null") String lastName,
			@Email(message = "Email should be valid") String email,
			@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone Number") String phone,
			@NotNull(message = "User Name cannot be null") String userName,
			@NotNull(message = "Password cannot be null") String password,
			@NotNull(message = "Role can not be null") RoleTO role, Boolean userActive) {
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

	public UserTO(@NotEmpty(message = "First Name cannot be null") String firstName,
			@NotEmpty(message = "Last Name cannot be null") String lastName,
			@Email(message = "Email should be valid") String email,
			@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone Number") String phone,
			@NotNull(message = "User Name cannot be null") String userName,
			@NotNull(message = "Password cannot be null") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
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

	public RoleTO getRole() {
		return role;
	}

	public void setRole(RoleTO role) {
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
		return "UserTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", userActive=" + userActive + "]";
	}

	
	
	

}
