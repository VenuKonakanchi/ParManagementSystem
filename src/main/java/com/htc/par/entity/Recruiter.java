package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECRUITER")
public class Recruiter {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "recruit_seq")
	@SequenceGenerator(name="recruit_seq", sequenceName="recruit_seq",initialValue = 8000, allocationSize=1)
	@Column(name="recruit_id")
	private Integer recruiterId;
	
	@Column(name="recruit_nm")
	private String recruiterName;

	@Column(name="recruit_phn_num")
	private String recruiterPhoneNumber;
	
	@Column(name="recruit_email_txt")
	private String recruiterEmail;
	
	@Column(name="recruit_email_flag")
	private Boolean recruiterEmailFlag;
	
	@Column(name="recruit_active")
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

	public Recruiter(Integer recruiterId, String recruiterName, String recruiterPhoneNumber, String recruiterEmail,
			Boolean recruiterEmailFlag, Boolean recruiterActive) {
		super();
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.recruiterPhoneNumber = recruiterPhoneNumber;
		this.recruiterEmail = recruiterEmail;
		this.recruiterEmailFlag = recruiterEmailFlag;
		this.recruiterActive = recruiterActive;
	}

	public Recruiter() {
	}

	@Override
	public String toString() {
		return "Recruiter [recruiterId=" + recruiterId + ", recruiterName=" + recruiterName + ", recruiterPhoneNumber="
				+ recruiterPhoneNumber + ", recruiterEmail=" + recruiterEmail + ", recruiterEmailFlag="
				+ recruiterEmailFlag + ", isRecruiterActive=" + recruiterActive + "]";
	}

}
