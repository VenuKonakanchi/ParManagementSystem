/**
 * 
 */
package com.htc.par.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 *Entity class for PAR_MSTR table
 *
 */
@Entity
@Table(name = "par_mstr")
public class PARMaster {

	@Id
	@Column(name = "par_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "par_seq")
	@SequenceGenerator(name = "par_seq", sequenceName = "par_seq", initialValue = 1000, allocationSize = 1)
	private Integer parId;

	@Column(name = "par_num")
	private String parNumber;

	@Column(name = "par_desc_txt")
	private String parDescriptionText;

	@Column(name = "par_rcvd_dt")
	private String parReceivedDate;

	@Column(name = "par_stts")
	private String parStatus;

	@Column(name = "intnt_to_fill_ind")
	private Boolean intentToFillIndicator;

	@Column(name = "email_sent")
	private Boolean emailSent;

	@Column(name = "par_cmmnt")
	private String parComment;
	
	@Column(name = "intnt_to_fill_dt")
	private LocalDate intentToFillDate;
	
	@OneToOne(mappedBy = "parMaster", fetch = FetchType.LAZY)
	private PARRelation parRelation;

	public PARMaster(Integer parId, String parNumber, String parDescriptionText, String parReceivedDate,
			String parStatus, Boolean intentToFillIndicator, Boolean emailSent, String parComment,
			LocalDate intentToFillDate) {
		super();
		this.parId = parId;
		this.parNumber = parNumber;
		this.parDescriptionText = parDescriptionText;
		this.parReceivedDate = parReceivedDate;
		this.parStatus = parStatus;
		this.intentToFillIndicator = intentToFillIndicator;
		this.emailSent = emailSent;
		this.parComment = parComment;
		this.intentToFillDate = intentToFillDate;
	}

	public PARMaster(String parNumber, String parDescriptionText, String parReceivedDate, String parStatus,
			Boolean intentToFillIndicator, Boolean emailSent, String parComment, LocalDate intentToFillDate) {
		super();
		this.parNumber = parNumber;
		this.parDescriptionText = parDescriptionText;
		this.parReceivedDate = parReceivedDate;
		this.parStatus = parStatus;
		this.intentToFillIndicator = intentToFillIndicator;
		this.emailSent = emailSent;
		this.parComment = parComment;
		this.intentToFillDate = intentToFillDate;
	}

	public Integer getParId() {
		return parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
	}

	public String getParNumber() {
		return parNumber;
	}

	public void setParNumber(String parNumber) {
		this.parNumber = parNumber;
	}

	public String getParDescriptionText() {
		return parDescriptionText;
	}

	public void setParDescriptionText(String parDescriptionText) {
		this.parDescriptionText = parDescriptionText;
	}

	public String getParReceivedDate() {
		return parReceivedDate;
	}

	public void setParReceivedDate(String parReceivedDate) {
		this.parReceivedDate = parReceivedDate;
	}

	public String getParStatus() {
		return parStatus;
	}

	public void setParStatus(String parStatus) {
		this.parStatus = parStatus;
	}

	public Boolean getIntentToFillIndicator() {
		return intentToFillIndicator;
	}

	public void setIntentToFillIndicator(Boolean intentToFillIndicator) {
		this.intentToFillIndicator = intentToFillIndicator;
	}

	public Boolean getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	public String getParComment() {
		return parComment;
	}

	public LocalDate getIntentToFillDate() {
		return intentToFillDate;
	}

	public void setIntentToFillDate(LocalDate intentToFillDate) {
		this.intentToFillDate = intentToFillDate;
	}

	public void setParComment(String parComment) {
		this.parComment = parComment;
	}
	
	public PARRelation getParRelation() {
		return parRelation;
	}

	public void setParRelation(PARRelation parRelation) {
		this.parRelation = parRelation;
	}

	@Override
	public String toString() {
		return "PARMaster [parId=" + parId + ", parNumber=" + parNumber + ", parDescriptionText=" + parDescriptionText
				+ ", parReceivedDate=" + parReceivedDate + ", parStatus=" + parStatus + ", intentToFillIndicator="
				+ intentToFillIndicator + ", emailSent=" + emailSent + ", parComment=" + parComment
				+ ", intentToFillDate=" + intentToFillDate + "]";
	}

}
