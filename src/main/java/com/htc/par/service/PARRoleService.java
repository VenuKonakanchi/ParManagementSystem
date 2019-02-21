package com.htc.par.service;

import java.util.List;

import com.htc.par.to.PARRoleTO;

public interface PARRoleService {
	
	public Integer newparRole(PARRoleTO parRoleTO);
	
	public List<PARRoleTO> getAllPARRoles();

}
