package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AREA_LKUP")
public class Area {
	
	@Id 
	@Column(name="area_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "area_seq")
	@SequenceGenerator(name="area_seq", sequenceName="area_seq",initialValue = 9000, allocationSize=1)
	private int areaId;
	
	@Column(name="area_nm")
	private String areaName;
	
	@Column(name="area_active")
    private boolean IsAreaActive;
    
    
    
	public int getAreaId() {
		return areaId;
	}



	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}



	public String getAreaName() {
		return areaName;
	}



	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



	public boolean isIsAreaActive() {
		return IsAreaActive;
	}



	public void setIsAreaActive(boolean isAreaActive) {
		IsAreaActive = isAreaActive;
	}



	public Area(int areaId, String areaName, boolean isAreaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		IsAreaActive = isAreaActive;
	}



	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", IsAreaActive=" + IsAreaActive + "]";
	}



	public Area() {
		// TODO Auto-generated constructor stub
	}
	
	

}
