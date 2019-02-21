package com.htc.par.to;

public class PreScreener {

	private int preScreenerId;
	private String preScreenerName;
	private String preScreenerPhoneNumber;
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
		return "PreScreeners [preScreenerId=" + preScreenerId + ", preScreenerName=" + preScreenerName
				+ ", preScreenerPhoneNumber=" + preScreenerPhoneNumber + ", preScreenerActive=" + preScreenerActive
				+ "]";
	}

}
