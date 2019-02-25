package com.htc.par.to;

public class PreScreenerTO {

	private Integer preScreenerId;
	private String preScreenerName;
	private String preScreenerPhoneNumber;
	private Boolean preScreenerActive;

	public PreScreenerTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreScreenerTO(Integer preScreenerId, String preScreenerName, String preScreenerPhoneNumber,
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
		return "PreScreenerTO [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerPhoneNumber=" + preScreenerPhoneNumber + ", preScreenerActive=" + preScreenerActive
				+ "]";
	}

}
