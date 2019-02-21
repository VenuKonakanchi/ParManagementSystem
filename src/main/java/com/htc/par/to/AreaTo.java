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
	private int areaId;
	
	@NotEmpty(message="Area Name is mandatory") 
	private String areaName;


	

	// CONSTRUCTORS
	
	
	public AreaTo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	 
	public AreaTo(int areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}



	// GETTER SETTER
	
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

	
	
	
	// OVER RIDE TO STRING


	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + "]";
	}


	
	
	
	// OVER RIDE HASHCODE
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaId;
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
		if (areaId != other.areaId)
			return false;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		return true;
	}
	

 
	

}
