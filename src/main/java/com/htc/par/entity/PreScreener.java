package com.htc.par.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRE_SCREENER")

public class PreScreener {

	@Id	
	@Column(name="PRE_SCR_ID")
	private int preScreenerId;
	@Column
	private String preScreenerName;
	@Column
	private String preScreenerPhoneNumber;
	@Column
	private boolean preScreenerActive;
	
	
	/*@ManyToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLES",
	           joinColumns=@JoinColumn(name="USER_ID"),
	           inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	Set<AppRole> roles = new HashSet<>();*/
	

}
