package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.PARRole;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.PARRoleTO;
/**
 * Service class for PAR Role Repository
 *
 */

@Service
public interface PARRoleService {	
	
	public PARRoleTO getPARRoleById(int roleId) throws ResourceNotFoundException;
	
	public List<PARRoleTO> getAllPARRoles() throws ResourceNotFoundException;
	
	public PARRoleTO updatePARRole(PARRoleTO parRoleTO) throws ResourceNotUpdatedException;
	
	public PARRoleTO createPARRole(PARRoleTO parRoleTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deletePARRole(int roleId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public PARRoleTO getPARRoleTO(PARRole parRole);
	
	public PARRole getPARRole(PARRoleTO parRoleTO);

}
