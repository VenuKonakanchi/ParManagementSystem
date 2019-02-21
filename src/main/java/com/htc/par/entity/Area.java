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
	
 


	// GETTER SETTER
	 
	
	
	
	// OVER RIDE TO STRING

 
	
	
	
	// OVER RIDE HASHCODE
	
	
	
 
 
	

}
