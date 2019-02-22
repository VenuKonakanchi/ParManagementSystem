package com.htc.par.to;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.htc.par.entity.Area;

public class ExternalStaffTO {

	private Integer extStaffId ;
	
	private String extStaffName;
	
	private Area area;
	
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
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

	public ExternalStaffTO(Integer extStaffId, String extStaffName, Area area, Boolean extStaffActive) {
		super();
		this.extStaffId = extStaffId;
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = extStaffActive;
	}

	@Override
	public String toString() {
		return "ExternalStaffTO [extStaffId=" + extStaffId + ", extStaffName=" + extStaffName + ", area=" + area
				+ ", extStaffActive=" + extStaffActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((extStaffActive == null) ? 0 : extStaffActive.hashCode());
		result = prime * result + ((extStaffId == null) ? 0 : extStaffId.hashCode());
		result = prime * result + ((extStaffName == null) ? 0 : extStaffName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalStaffTO other = (ExternalStaffTO) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (extStaffActive == null) {
			if (other.extStaffActive != null)
				return false;
		} else if (!extStaffActive.equals(other.extStaffActive))
			return false;
		if (extStaffId == null) {
			if (other.extStaffId != null)
				return false;
		} else if (!extStaffId.equals(other.extStaffId))
			return false;
		if (extStaffName == null) {
			if (other.extStaffName != null)
				return false;
		} else if (!extStaffName.equals(other.extStaffName))
			return false;
		return true;
	}
	
	

}
