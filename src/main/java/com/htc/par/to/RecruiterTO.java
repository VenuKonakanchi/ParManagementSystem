package com.htc.par.to;

public class RecruiterTO {
	
	private Integer recruiterId;
	private String recruiterName;
	private String recruiterPhoneNumber;
	private String recruiterEmail;
	private Boolean recruiterEmailFlag;
	private Boolean recruiterActive;
	
	public Integer getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Integer recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getRecruiterPhoneNumber() {
		return recruiterPhoneNumber;
	}
	public void setRecruiterPhoneNumber(String recruiterPhoneNumber) {
		this.recruiterPhoneNumber = recruiterPhoneNumber;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public Boolean getRecruiterEmailFlag() {
		return recruiterEmailFlag;
	}
	public void setRecruiterEmailFlag(Boolean recruiterEmailFlag) {
		this.recruiterEmailFlag = recruiterEmailFlag;
	}
	public Boolean getRecruiterActive() {
		return recruiterActive;
	}
	public void setRecruiterActive(Boolean recruiterActive) {
		this.recruiterActive = recruiterActive;
	}
	public RecruiterTO(Integer recruiterId, String recruiterName, String recruiterPhoneNumber, String recruiterEmail,
			Boolean recruiterEmailFlag, Boolean recruiterActive) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.recruiterPhoneNumber = recruiterPhoneNumber;
		this.recruiterEmail = recruiterEmail;
		this.recruiterEmailFlag = recruiterEmailFlag;
		this.recruiterActive = recruiterActive;
	}
	public RecruiterTO() {
	}

}
