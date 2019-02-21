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
	private int areaId;
	
	@Column (name ="area_name")
	private String areaName;


	
	
	
	// CONSTRUCTORS
	
	
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	 
	public Area(int areaId, String areaName) {
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
		Area other = (Area) obj;
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
