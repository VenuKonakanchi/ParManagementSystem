/**
 * 
 */
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

/**
*********************************************************************************************
*****************Entity class for PAR_MSTR table.********************************************
*****************DO NOT USE this class, as it is not fully implemented***********************
*********************************************************************************************
*/
//@Entity
//@Table(name = "par_mstr")
public class PARAllocation {
	
	@Id
	@Column(name = "par_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "par_alloc_seq")
	@SequenceGenerator(name = "par_alloc_seq", sequenceName = "par_alloc_seq", initialValue = 2000, allocationSize = 1)
	private Integer parAllocationIndicator;
	
	//TODO: Identify Relationship
	//private PARMaster parMaster;
	
	@ManyToOne()
	@JoinColumn(name="recruit_cd", referencedColumnName="recruit_id")
	private Recruiter recruiter;
	
	@ManyToOne()
	@JoinColumn(name="pre_scr_cd", referencedColumnName="pre_scr_id")
	private PreScreener preScreener;
	
	@ManyToOne()
	@JoinColumn(name="cand_cd", referencedColumnName="cand_id")
	private Candidate candidate;
	
	@Column(name = "pre_scr_dt")
	private LocalDate preScreeningDate;
	
	@Column(name = "pre_scr_cmnt_txt")
	private String  preScreenerCommentText;
	
	@Column(name = "submit_ind")
	private Boolean  submitIndicator;
	
	@Column(name = "submit_dt")
	private LocalDate  submittedDate;
	
	@Column(name = "offer_recvd_ind")
	private Boolean  offerReceviedDate;
	
	@Column(name = "exptd_start_dt")
	private LocalDate  expectedStartDate;
	
	@Column(name = "actual_start_dt")
	private LocalDate  actualStartDate;
	
	
}
