package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.impl.PARRoleServiceImpl;
import com.htc.par.to.PARRoleTO;

/*@author - Fazlur Rahman
 * Controller to handle Role information
 */
@RestController
@RequestMapping("/par")
public class PARRoleController {

	@Autowired
	PARRoleServiceImpl parRoleService;

	/**
	 * Request handler to get Role by id
	 * 
	 * @param roleId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/parroles/{roleId}")
	public ResponseEntity<PARRoleTO> getPARRoleById(@RequestBody @Valid  @PathVariable("roleId") int roleId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(parRoleService.getPARRoleById(roleId));
	}

	/**
	 * Request handler to get all Roles
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/parroles")
	public ResponseEntity<List<PARRoleTO>> getPARRoles() throws ResourceNotFoundException {
		return ResponseEntity.ok(parRoleService.getAllPARRoles());
	}

	/**
	 * Request handler to Add new skill
	 * 
	 * @param PARRoleTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/parroles")
	public ResponseEntity<PARRoleTO> createPARRole(@RequestBody @Valid PARRoleTO parRoleTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(parRoleService.createPARRole(parRoleTO));
	}

	/**
	 * Request handler to update active Role
	 * 
	 * @param PARRoleTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/parroles")
	public ResponseEntity<PARRoleTO> updatePARRole(@RequestBody @Valid PARRoleTO parRoleTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(parRoleService.updatePARRole(parRoleTO));
	}

	/**
	 * Request handler to delete/deactivate Role
	 * 
	 * @param roleId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/parroles/{roleId}")
	public ResponseEntity<Boolean> deletePARRole(@RequestBody @Valid @PathVariable("roleId") int roleId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(parRoleService.deletePARRole(roleId));
	}

}
