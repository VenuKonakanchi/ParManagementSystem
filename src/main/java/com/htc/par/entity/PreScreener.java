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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preScreener_seq")
	@SequenceGenerator(name = "preScreener_seq", sequenceName = "preScreener_seq", initialValue = 8000, allocationSize = 1)
	private int preScreenerId;

	@Column(name = "pre_scr_nm")
	private String preScreenerName;

	@Column(name = "pre_scr_phn_num")
	private String preScreenerPhoneNumber;

	@Column(name = "pre_scr_active")
	private boolean preScreenerActive;

	public PreScreener() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreScreener(int preScreenerId, String preScreenerName, String preScreenerPhoneNumber,
			boolean preScreenerActive) {
		super();
		this.preScreenerId = preScreenerId;
		this.preScreenerName = preScreenerName;
		this.preScreenerPhoneNumber = preScreenerPhoneNumber;
		this.preScreenerActive = preScreenerActive;
	}

	public int getPreScreenerId() {
		return preScreenerId;
	}

	public void setPreScreenerId(int preScreenerId) {
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

	public boolean isPreScreenerActive() {
		return preScreenerActive;
	}

	public void setPreScreenerActive(boolean preScreenerActive) {
		this.preScreenerActive = preScreenerActive;
	}

	@Override
	public String toString() {
		return "PreScreener [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerPhoneNumber=" + preScreenerPhoneNumber + ", preScreenerActive=" + preScreenerActive
				+ "]";
	}

	
}
