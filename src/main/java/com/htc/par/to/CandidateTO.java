package com.htc.par.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CandidateTO {

	private Integer candidateId ;
	
	 @NotEmpty(message = "Candidate Name cannot be empty")
	 @NotNull(message = "Candidate Name cannot be null")
	 @Pattern(regexp="^[A-Za-z ]+$",message="Invalid Candidate Name ")
	private String candidateName;
	
	 @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid Mobile Number")
	private String candidatePhoneNumber;
	
	@Email(message="Email should be valid")
	private String candidateEmail;

	private Boolean candidateActive ;
	
	@NotNull(message="Skill can not be null")
	private SkillTO skill;

	
	public CandidateTO() {
		// TODO Auto-generated constructor stub
	}



	public Integer getCandidateId() {
		return candidateId;
	}



	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}



	public String getCandidatePhoneNumber() {
		return candidatePhoneNumber;
	}



	public void setCandidatePhoneNumber(String candidatePhoneNumber) {
		this.candidatePhoneNumber = candidatePhoneNumber;
	}



	public String getCandidateEmail() {
		return candidateEmail;
	}



	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}



	public Boolean getCandidateActive() {
		return candidateActive;
	}



	public void setCandidateActive(Boolean candidateActive) {
		this.candidateActive = candidateActive;
	}



	public SkillTO getSkill() {
		return skill;
	}



	public void setSkill(SkillTO skill) {
		this.skill = skill;
	}



	public CandidateTO(Integer candidateId, String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive, SkillTO skill) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.candidateActive = candidateActive;
		this.skill = skill;
	}


	public CandidateTO(String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive, SkillTO skill) {
		super();
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.candidateActive = candidateActive;
		this.skill = skill;
	}


	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidatePhoneNumber="
				+ candidatePhoneNumber + ", candidateEmail=" + candidateEmail + ", candidateActive=" + candidateActive
				+ ", skill=" + skill + "]";
	}
	
	
	

}
