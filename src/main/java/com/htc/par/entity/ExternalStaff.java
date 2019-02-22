package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXT_STAFF_LKUP")
public class ExternalStaff {
	
	@Id 
	@Column(name="ext_staff_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ext_staff_seq")
	@SequenceGenerator(name="ext_staff_seq", sequenceName="ext_staff_seq",initialValue = 7000, allocationSize=1)
	private Integer extStaffId ;
	
	@Column(name="ext_staff_nm")
	private String extStaffName;
	
	@OneToOne
	@JoinColumn(name="area_id")
	private Area area;
	
	@Column(name="ext_staff_active")
	private Boolean extStaffActive ;
	
	
	public ExternalStaff() {
		// TODO Auto-generated constructor stub
	}


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


	public ExternalStaff(Integer extStaffId, String extStaffName, Area area, Boolean extStaffActive) {
		super();
		this.extStaffId = extStaffId;
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = extStaffActive;
	}
	
	public ExternalStaff(String extStaffName, Area area, Boolean extStaffActive) {
		super();
		this.extStaffName = extStaffName;
		this.area = area;
		this.extStaffActive = extStaffActive;
	}


	@Override
	public String toString() {
		return "ExternalStaff [extStaffId=" + extStaffId + ", extStaffName=" + extStaffName + ", area=" + area
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
		ExternalStaff other = (ExternalStaff) obj;
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
