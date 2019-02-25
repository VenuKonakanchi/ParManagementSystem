package com.htc.par.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AREA_LKUP")
public class Area {
	
	@Id 
	@Column(name="area_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "area_seq")
	@SequenceGenerator(name="area_seq", sequenceName="area_seq",initialValue = 9000, allocationSize=1)
	private Integer areaId;
	
	@Column(name="area_nm")
	private String areaName;
	
	@Column(name="area_active")
    private Boolean areaActive;
    
    @OneToMany(mappedBy="area",cascade=CascadeType.ALL)
    private Set<ExternalStaff> externalStaff ;

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
		areaActive = areaActive;
	}




	public Area() {
		// TODO Auto-generated constructor stub
	}




	public Area(Integer areaId, String areaName, Boolean areaActive) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		areaActive = areaActive;
	}
	public Area( String areaName, Boolean areaActive) {
		super();
		
		this.areaName = areaName;
		areaActive = areaActive;
	}


	public Set<ExternalStaff> getExternalStaff() {
		return externalStaff;
	}


	public void setExternalStaff(Set<ExternalStaff> externalStaff) {
		this.externalStaff = externalStaff;
	}


	public Area(Integer areaId, String areaName, Boolean areaActive, Set<ExternalStaff> externalStaff) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		areaActive = areaActive;
		this.externalStaff = externalStaff;
	}


	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", AreaActive=" + areaActive + "]";
	}


	
 
	

}
