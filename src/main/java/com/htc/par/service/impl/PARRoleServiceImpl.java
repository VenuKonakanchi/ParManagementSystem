package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Area;
import com.htc.par.entity.PARRole;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.PARRoleRepository;
import com.htc.par.service.PARRoleService;
import com.htc.par.to.PARRoleTO;
import com.htc.par.utilities.NullAwareBeanUtil;

/**
 * PAR Role Service Implementation
 *
 */

@Service
public class PARRoleServiceImpl implements PARRoleService{

	
	@Autowired
	PARRoleRepository parRoleRepository;

	public PARRole getPARRole(PARRoleTO parRoleTO) {
		PARRole parRole = new PARRole(parRoleTO.getRoleId(), parRoleTO.getRoleName(), parRoleTO.getRoleActive());
		return parRole;
	}

	public PARRoleTO getPARRoleTO(PARRole parRole) {
		PARRoleTO parRoleTO = new PARRoleTO(parRole.getRoleId(), parRole.getRoleName(), parRole.getRoleActive());
		return parRoleTO;
	}



	/**
	 * Get active Role by Id
	 * 
	 * @param roleId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	@Override
	public PARRoleTO getPARRoleById(int roleId) throws ResourceNotFoundException {
		Optional<PARRole> roleOptional = parRoleRepository.findByRoleIdAndRoleActive(roleId, true);
		PARRoleTO parRoleTO = null;
		if (!roleOptional.isPresent())
			throw new ResourceNotFoundException(String.format("Role Id: %s not found.", roleId));
		parRoleTO = getPARRoleTO(roleOptional.get());
		return parRoleTO;
	}

	/**
	 * Get All active Roles
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	@Override
	public List<PARRoleTO> getAllPARRoles() throws ResourceNotUpdatedException {
		List<PARRole> roleEntities = parRoleRepository.findAllByRoleActive(true);
		if (CollectionUtils.isEmpty(roleEntities))
			throw new ResourceNotFoundException("No Roles Found.");
		List<PARRoleTO> roleList = roleEntities.stream().map(role -> {
			return getPARRoleTO(role);
		}).collect(Collectors.toList());
		return roleList;
	}

	
	/**
	 * create new Role
	 * 
	 * @return
	 * @throws ResourceDuplicateException, ResourceNotCreatedException
	 */
	@Override
	public PARRoleTO createPARRole(PARRoleTO parRoleTO) throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<PARRole> roleOptional = parRoleRepository.findByRoleName(parRoleTO.getRoleName());
			PARRole parRole = null;
			if (!roleOptional.isPresent()) {
				parRoleTO.setRoleActive(true);
				parRole = getPARRole(parRoleTO);
			} else {
				parRole = roleOptional.get();
				if(parRole.getRoleActive())
					throw new ResourceDuplicateException(
							String.format("PAR Role: %s Already Exist.", parRoleTO.getRoleName()));
				parRole.setRoleActive(true);
				parRoleTO.setRoleActive(true);
			}
			parRole = parRoleRepository.save(parRole);
			parRoleTO = getPARRoleTO(parRole);
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("Role: %s not created.", parRoleTO.getRoleName()));
		}
		return parRoleTO;
	}

	
	/**
	 * De-activate Role
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotDeletedException
	 */
	
	@Override
	public boolean deletePARRole(int roleId) throws ResourceNotFoundException, ResourceNotDeletedException {
		try {
			Optional<PARRole> roleOptional = parRoleRepository.findByRoleIdAndRoleActive(roleId, true);
			if (!roleOptional.isPresent())
				throw new ResourceNotFoundException("Role not found.");
			PARRole role = roleOptional.get();
			role.setRoleActive(false);
			parRoleRepository.save(role);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("Role not deleted.");
		}
		return true;
	}

	
	/**
	 * Update active Role
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotUpdatedException
	 */
	@Override
	public PARRoleTO updatePARRole(PARRoleTO parRoleTO) throws ResourceNotUpdatedException {
		PARRoleTO updatedparRoleTO=null; 
		PARRole role = null;
		try {
			Optional<PARRole> roleOptional = parRoleRepository.findByRoleIdAndRoleActive(parRoleTO.getRoleId(), true);
			if (!roleOptional.isPresent())
				throw new ResourceNotFoundException(String.format("Role: %s Not Found.", parRoleTO.getRoleName()));
			role = roleOptional.get();
			NullAwareBeanUtil.copyProperties(parRoleTO, role);
			updatedparRoleTO = getPARRoleTO(parRoleRepository.save(role));
			
		} catch (DataIntegrityViolationException daeintexp) {
			
			Optional<PARRole> existingRoleOptional = parRoleRepository.findByRoleName(parRoleTO.getRoleName());
			if (existingRoleOptional.isPresent()) {
				role = existingRoleOptional.get();
				if(role.getRoleActive()) {
					throw new ResourceDuplicateException(String.format("PAR Role: %s Already Exist.", parRoleTO.getRoleName()));				
				}else {
					throw new ResourceDuplicateException(String.format("PAR Role: %s has already been in-activated. Please add it as new PAR Role.", parRoleTO.getRoleName()));
				}
			} else {
				throw new ResourceDuplicateException(String.format("PAR Role: %s Already Exist.", parRoleTO.getRoleName()));
			}
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("PAR Role: %s Not Found.", parRoleTO.getRoleName()));
		}
		return updatedparRoleTO;
	}

}
