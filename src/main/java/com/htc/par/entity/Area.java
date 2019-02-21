package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Area entity class for Area application flow
 */

@Entity
@Table

public class Area {
	
	// Data entities
 
	@Id
	@Column (name ="area_id")
	private Integer areaId;
	
	@Column (name ="area_nm")
	private String areaName;
	
	@Column (name ="area_active")
	private Boolean areaActive;


	
	
	// CONSTRUCTORS
	
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Area(String areaName, Boolean areaActive) {
		super();
		this.areaName = areaName;
		this.areaActive = areaActive;
	}

	


	public Area(Integer areaId, String areaName, Boolean areaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaActive = areaActive;
	}

	
	
	

	// GETTER SETTER
	
	
	 
	


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
		return areaActive;
	}



	public void setAreaActive(Boolean areaActive) {
		this.areaActive = areaActive;
	}




	
	
	// OVER RIDE TO STRING

 
	

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", areaActive=" + areaActive + "]";
	}

	
	
	
	
	
	// OVER RIDE HASHCODE
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaActive == null) ? 0 : areaActive.hashCode());
		result = prime * result + ((areaId == null) ? 0 : areaId.hashCode());
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
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
		Area other = (Area) obj;
		if (areaActive == null) {
			if (other.areaActive != null)
				return false;
		} else if (!areaActive.equals(other.areaActive))
			return false;
		if (areaId == null) {
			if (other.areaId != null)
				return false;
		} else if (!areaId.equals(other.areaId))
			return false;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		return true;
	}


	
	
 
 
	

}
