package com.htc.par.to;

import java.time.LocalDate;

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
	
	@NotNull(message = "Candidate Received date cannot be null")
	private LocalDate candidateReceivedDate;
	
	@NotNull(message="Recruiter can not be null")
	private RecruiterTO recruiter;

	
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



	public RecruiterTO getRecruiter() {
		return recruiter;
	}



	public void setRecruiter(RecruiterTO recruiter) {
		this.recruiter = recruiter;
	}

	public LocalDate getCandidateReceivedDate() {
		return candidateReceivedDate;
	}

	public void setCandidateReceivedDate(LocalDate candidateReceivedDate) {
		this.candidateReceivedDate = candidateReceivedDate;
	}



	public CandidateTO(Integer candidateId, String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive, RecruiterTO recruiter,LocalDate candidateReceivedDate) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.candidateActive = candidateActive;
		this.recruiter = recruiter;
		this.candidateReceivedDate = candidateReceivedDate;
	}


	public CandidateTO(String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive, RecruiterTO recruiter,LocalDate candidateReceivedDate) {
		super();
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.candidateActive = candidateActive;
		this.recruiter = recruiter;
		this.candidateReceivedDate = candidateReceivedDate;
	}

	@Override
	public String toString() {
		return "CandidateTO [candidateId=" + candidateId + ", candidateName=" + candidateName
				+ ", candidatePhoneNumber=" + candidatePhoneNumber + ", candidateEmail=" + candidateEmail
				+ ", candidateActive=" + candidateActive + ", candidateReceivedDate=" + candidateReceivedDate
				+ ", recruiter=" + recruiter + "]";
	}	

}
