package com.htc.par.to;

public class PreScreenerTO {

	private int preScreenerId;
	private String preScreenerName;
	private String preScreenerPhoneNumber;
	private boolean isPreScreenerActive;

	public PreScreenerTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreScreenerTO(int preScreenerId, String preScreenerName, String preScreenerPhoneNumber,
			boolean isPreScreenerActive) {
		super();
		this.preScreenerId = preScreenerId;
		this.preScreenerName = preScreenerName;
		this.preScreenerPhoneNumber = preScreenerPhoneNumber;
		this.isPreScreenerActive = isPreScreenerActive;
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
		return isPreScreenerActive;
	}

	public void setPreScreenerActive(boolean isPreScreenerActive) {
		this.isPreScreenerActive = isPreScreenerActive;
	}

	@Override
	public String toString() {
		return "PreScreenerTO [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerPhoneNumber=" + preScreenerPhoneNumber + ", isPreScreenerActive=" + isPreScreenerActive
				+ "]";
	}

}
