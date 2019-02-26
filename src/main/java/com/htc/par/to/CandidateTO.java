package com.htc.par.to;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.htc.par.entity.Skill;

public class CandidateTO {

	private Integer candidateId ;
	
	private String candidateName;
	
	private String candidatePhoneNumber;
	
	private String candidateEmail;

	private Boolean candidateActive ;
	
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
