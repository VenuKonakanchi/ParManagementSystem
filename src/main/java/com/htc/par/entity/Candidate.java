package com.htc.par.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {

	@Id 
	@Column(name="cand_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cand_seq")
	@SequenceGenerator(name="cand_seq", sequenceName="cand_seq",initialValue = 7000, allocationSize=1)
	private Integer candidateId ;
	
	@Column(name="cand_nm")
	private String candidateName;
	
	@Column(name="cand_phn_num")
	private String candidatePhoneNumber;
	
	@Column(name="cand_email_txt")
	private String candidateEmail;

	@Column(name="cand_active")
	private Boolean candidateActive ;
	
	@Column(name="cand_rcvd_dt")
	private LocalDate candidateReceivedDate;
	
	@ManyToOne()
	@JoinColumn(name="recruit_cd", referencedColumnName="recruit_id")
	private Recruiter recruiter;

	
	
	public Candidate() {
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



	public Recruiter getRecruiter() {
		return recruiter;
	}



	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public LocalDate getCandidateReceivedDate() {
		return candidateReceivedDate;
	}

	public void setCandidateReceivedDate(LocalDate candidateReceivedDate) {
		this.candidateReceivedDate = candidateReceivedDate;
	}


	public Candidate(Integer candidateId, String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive,Recruiter recruiter,LocalDate candidateReceivedDate) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.candidateActive = candidateActive;
		this.recruiter = recruiter;
		this.candidateReceivedDate = candidateReceivedDate;
	}


	public Candidate(String candidateName, String candidatePhoneNumber, String candidateEmail,
			Boolean candidateActive,Recruiter recruiter,LocalDate candidateReceivedDate) {
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
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidatePhoneNumber="
				+ candidatePhoneNumber + ", candidateEmail=" + candidateEmail + ", candidateActive=" + candidateActive
				+ ", candidateReceivedDate=" + candidateReceivedDate + "]";
	}

}
