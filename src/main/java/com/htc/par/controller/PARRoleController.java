package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.service.PARRoleServiceImpl;
import com.htc.par.to.PARRoleTO;

/*@author - Fazlur Rahman
 * Controller to handle Role information
 */
@RestController
public class PARRoleController {
	
	
	@Autowired
	PARRoleServiceImpl parRoleService;
	
	private int totalRowsAffected;
	
	// Add New PAR Role 
	@PostMapping(value="/par/roles", consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<Integer> newproduct(@RequestBody @Valid PARRoleTO parRoleTO, BindingResult result) throws Exception{
		
			totalRowsAffected = parRoleService.newparRole(parRoleTO);
			if(totalRowsAffected == 1)
				throw new Exception(String.format("New Par Role has been added successfully"));
			
			else if(totalRowsAffected == 0)
				throw new ResourceDuplicateException(String.format("This Role is already Available!"));
			
			else if(totalRowsAffected == -1)
				throw new ResourceNotCreatedException(String.format("Error while adding New Par Role!!"));
			
			return ResponseEntity.created(null).body(this.totalRowsAffected);
	}
	
	//Update PAR ROLE
	
	
	// Get All PAR Roles Available 
	@GetMapping(value="/AvailablePARRoles", consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<List<PARRoleTO>> getCustomers() throws Exception {
		List<PARRoleTO> parRoleList = parRoleService.getAllPARRoles();
		
		parRoleList.forEach(System.out::println);
		
		if (parRoleList.size() == 0) {
			throw new Exception("PAR Roles Table is Empty!- Table name : ROLE_LKUP");
		} else {
			return ResponseEntity.ok(parRoleList);
		}
	}
	
}
