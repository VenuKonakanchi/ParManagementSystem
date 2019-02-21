package com.htc.par.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/*
 * Area entity class for Area application flow
 */

 

public class AreaTo implements Serializable{
	
	// Data entities
 
 
	 
	@NotEmpty(message="Area id is mandatory")
	private Integer areaId;
	
	@NotEmpty(message="Area Name is mandatory")
	private String areaName;
 
	
	private Boolean areaActive;


	
	

	// CONSTRUCTORS
 
	
	
	public AreaTo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AreaTo(Integer areaId,
					String areaName, Boolean areaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaActive = areaActive;
	}
	
	

	public AreaTo(String areaName, Boolean areaActive) {
		super();

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
		return "AreaTo [areaId=" + areaId + ", areaName=" + areaName + ", areaActive=" + areaActive + "]";
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
		AreaTo other = (AreaTo) obj;
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
