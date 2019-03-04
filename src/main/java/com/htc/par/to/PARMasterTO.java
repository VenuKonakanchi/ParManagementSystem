/**
 * 
 */
package com.htc.par.to;

import java.time.LocalDate;

import com.htc.par.entity.Area;
import com.htc.par.entity.ExternalStaff;
import com.htc.par.entity.PARRole;
import com.htc.par.entity.Skill;

/**
 *
 * TO Class for PAR master
 *
 */

public class PARMasterTO {

	private Integer parId;

	private String parNumber;

	private String parDescriptionText;

	private String parReceivedDate;

	private String parStatus;

	private Boolean intentToFillIndicator;
	
	private LocalDate intentToFillDate;

	private Boolean emailSent;

	private String parComment;
	
	private PARRole parRole;
	
	private Skill skill;
	
	private Area area;
	
	private ExternalStaff externalStaff;
	
	public PARMasterTO(Integer parId, String parNumber, String parDescriptionText, String parReceivedDate,
			String parStatus, Boolean intentToFillIndicator, LocalDate intentToFillDate, Boolean emailSent,
			String parComment) {
		super();
		this.parId = parId;
		this.parNumber = parNumber;
		this.parDescriptionText = parDescriptionText;
		this.parReceivedDate = parReceivedDate;
		this.parStatus = parStatus;
		this.intentToFillIndicator = intentToFillIndicator;
		this.intentToFillDate = intentToFillDate;
		this.emailSent = emailSent;
		this.parComment = parComment;
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

	public void setParComment(String parComment) {
		this.parComment = parComment;
	}
	
	public PARRole getParRole() {
		return parRole;
	}

	public void setParRole(PARRole parRole) {
		this.parRole = parRole;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ExternalStaff getExternalStaff() {
		return externalStaff;
	}

	public void setExternalStaff(ExternalStaff externalStaff) {
		this.externalStaff = externalStaff;
	}

	public LocalDate getIntentToFillDate() {
		return intentToFillDate;
	}

	public void setIntentToFillDate(LocalDate intentToFillDate) {
		this.intentToFillDate = intentToFillDate;
	}

	@Override
	public String toString() {
		return "PARMasterTO [parId=" + parId + ", parNumber=" + parNumber + ", parDescriptionText=" + parDescriptionText
				+ ", parReceivedDate=" + parReceivedDate + ", parStatus=" + parStatus + ", intentToFillIndicator="
				+ intentToFillIndicator + ", intentToFillDate=" + intentToFillDate + ", emailSent=" + emailSent
				+ ", parComment=" + parComment + "]";
	}
}
