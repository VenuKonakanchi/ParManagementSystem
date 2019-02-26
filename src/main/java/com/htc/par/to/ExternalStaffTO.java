package com.htc.par.to;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import com.htc.par.entity.Area;

public class ExternalStaffTO {
	
	@NotEmpty(message="cannot be empty") 
	private Integer extStaffId ;
	
	@NotEmpty(message="cannot be empty")  
	private String extStaffName;
	
	private AreaTO area;
	
	private Boolean extStaffActive ;
	
	public Integer getExtStaffId() {
		return extStaffId;
	}

	public void setExtStaffId(Integer extStaffId) {
		this.extStaffId = extStaffId;
	}

	public String getExtStaffName() {
		return extStaffName;
	}

	public void setExtStaffName(String extStaffName) {
		this.extStaffName = extStaffName;
	}

	

	public AreaTO getArea() {
		return area;
	}

	public void setArea(AreaTO area) {
		this.area = area;
	}

	public Boolean getExtStaffActive() {
		return extStaffActive;
	}

	public void setExtStaffActive(Boolean extStaffActive) {
		this.extStaffActive = extStaffActive;
	}

	public ExternalStaffTO() {
		// TODO Auto-generated constructor stub
	}

	public ExternalStaffTO(Integer extStaffId, String extStaffName, AreaTO area, Boolean extStaffActive) {
		super();
		this.extStaffId = extStaffId;
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = extStaffActive;
	}

	public ExternalStaffTO(String extStaffName, AreaTO area) {
		super();
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = true;
	}
	
	@Override
	public String toString() {
		return "ExternalStaffTO [extStaffId=" + extStaffId + ", extStaffName=" + extStaffName + ", area=" + area
				+ ", extStaffActive=" + extStaffActive + "]";
	}

	

}
