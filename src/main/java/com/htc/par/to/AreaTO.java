package com.htc.par.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


public class AreaTO {

	
	private Integer areaId;
	
	private String areaName;
	
	
	private Boolean AreaActive;
    
    
    
	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public Boolean getAreaActive() {
		return AreaActive;
	}

	public void setAreaActive(Boolean areaActive) {
		AreaActive = areaActive;
	}


	public AreaTO() {
		// TODO Auto-generated constructor stub
	}

	public AreaTO(Integer areaId) {
		super();
		this.areaId = areaId;
		
	}

	public AreaTO(Integer areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	
	}

	
	public AreaTO(Integer areaId, String areaName, Boolean areaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		AreaActive = areaActive;
	}


	@Override
	public String toString() {
		return "AreaTO [areaId=" + areaId + ", areaName=" + areaName + ", AreaActive=" + AreaActive + "]";
	}

	
	

  }
