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
	private int extStaffId ;
	
	@Column(name="ext_staff_nm")
	private String extStaffName;
	
	@OneToOne
	@JoinColumn(name="area_id")
	private Area area;
	
	@Column(name="ext_staff_active")
	private boolean IsExtStaffActive ;
	
	
	public ExternalStaff() {
		// TODO Auto-generated constructor stub
	}


	public int getExtStaffId() {
		return extStaffId;
	}


	public void setExtStaffId(int extStaffId) {
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


	public boolean IsExtStaffActive() {
		return IsExtStaffActive;
	}


	public void setIsExtStaffActive(boolean isExtStaffActive) {
		IsExtStaffActive = isExtStaffActive;
	}
	
	

}
