package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRE_SCREENER")
public class PreScreener {

	@Id
	@Column(name = "pre_scr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_scr_seq")
	@SequenceGenerator(name = "pre_scr_seq", sequenceName = "pre_scr_seq", initialValue = 4000, allocationSize = 1)
	private Integer preScreenerId;

	@Column(name = "pre_scr_nm")
	private String preScreenerName;

	@Column(name = "pre_scr_phn_num")
	private String preScreenerPhoneNumber;

	@Column(name = "pre_scr_active")
	private Boolean preScreenerActive;

	public PreScreener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreScreener(Integer preScreenerId, String preScreenerName, String preScreenerPhoneNumber,
			Boolean preScreenerActive) {
		super();
		this.preScreenerId = preScreenerId;
		this.preScreenerName = preScreenerName;
		this.preScreenerPhoneNumber = preScreenerPhoneNumber;
		this.preScreenerActive = preScreenerActive;
	}

	public Integer getPreScreenerId() {
		return preScreenerId;
	}

	public void setPreScreenerId(Integer preScreenerId) {
		this.preScreenerId = preScreenerId;
	}

	public String getPreScreenerName() {
		return preScreenerName;
	}

	public void setPreScreenerName(String preScreenerName) {
		this.preScreenerName = preScreenerName;
	}

	public String getPreScreenerPhoneNumber() {
		return preScreenerPhoneNumber;
	}

	public void setPreScreenerPhoneNumber(String preScreenerPhoneNumber) {
		this.preScreenerPhoneNumber = preScreenerPhoneNumber;
	}

	public Boolean getPreScreenerActive() {
		return preScreenerActive;
	}

	public void setPreScreenerActive(Boolean preScreenerActive) {
		this.preScreenerActive = preScreenerActive;
	}

	@Override
	public String toString() {
		return "PreScreener [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerPhoneNumber=" + preScreenerPhoneNumber + ", preScreenerActive=" + preScreenerActive
				+ "]";
	}

	
}
