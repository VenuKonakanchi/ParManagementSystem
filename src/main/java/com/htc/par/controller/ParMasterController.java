package com.htc.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.htc.par.service.ExternalStaffService;
import com.htc.par.to.ExternalStaffTO;

@RestController
@RequestMapping("/par")
public class ParMasterController {
	
	  @GetMapping(value="/preScreenerForm") public String preScreenerInfo() {
	  return "preScreenerForm"; }
	  
	  @GetMapping(value="/recruiterForm") public String recruiterInfo() { return
	  "recruiterForm"; }
	  
	  @GetMapping(value="/areaAndProductForm") public String areaAndProductForm() {
	  return "areaAndProductForm"; }
	  
	  @GetMapping(value="/skillForm") public String skillForm() { return
	  "skillForm"; }
	  
	  @GetMapping(value="/candidateMaster") public String candidateMaster() {
	  return "candidateMaster"; }
	  
	  @GetMapping(value="/externalStaffingInfoForm") public String
	  externalStaffingInfoForm() { return "externalStaffingInfoForm"; }
	  
	  @GetMapping(value="/candidateRole") public String candidateRole() { return
	  "candidateRole"; }
	  
	  @GetMapping(value="/preScreener") public String preScreener() { return
	  "preScreener"; }
	  
	  @GetMapping(value="/userForm") public String userForm() { return "userForm";
	  }
	 

	
	  @Autowired private ParMasterService parMasterService;
	  
	 /**
		 * Request handler to get Par Master by id
		 * 
		 * @param parId
		 * @return
		 * @throws ResourceNotFoundException
		 */
	
	  @GetMapping("/parmasters/{parId}") public ResponseEntity<parMasterTO>
	  getParMasterById(@PathVariable("parId") int parId) throws
	  ResourceNotFoundException { return
	  ResponseEntity.ok(parMasterService.getParMasterById(parId)); }
	  
	 /**
		 * Request handler to get all Par Master
		 * 
		 * @return
		 * @throws ResourceNotFoundException
		 */
	
	  @GetMapping("/parmasters") public ResponseEntity<List<ParMasterTO>>
	  getAllParMaster() throws ResourceNotFoundException { return
	  ResponseEntity.ok(parMasterService.getAllParMaster()); }
	  
	 /**
		 * Request handler to new Par Master
		 * 
		 * @param ParMasterTO
		 * @return
		 * @throws ResourceNotCreatedException
		 * @throws ResourceDuplicateException
		 */
	
	  @PostMapping("/parmasters") public ResponseEntity<ParMasterTO>
	  createParMaster(@RequestBody ParMasterTO parMasterTO) throws
	  ResourceNotCreatedException, ResourceDuplicateException { return
	  ResponseEntity.created(null).body(parMasterService.createParMaster(
	  parMasterTO)); }
	  
	 /**
		 * Request handler to update Par Master
		 * 
		 * @param ParMasterTO
		 * @return
		 * @throws ResourceNotFoundException
		 * @throws ResourceNotUpdatedException
		 */
	
	  @PutMapping("/parmasters") public ResponseEntity<ParMasterTO>
	  updateParMaster(@RequestBody ParMasterTO parMasterTO) throws
	  ResourceNotFoundException, ResourceNotUpdatedException { return
	  ResponseEntity.ok(parMasterService.updateParMaster(parMasterTO)); }
	  
	 /**
		 * Request handler to delete Par Master
		 * 
		 * @param parId
		 * @return
		 * @throws ResourceNotFoundException
		 * @throws ResourceNotDeletedException
		 */
			  @DeleteMapping("/parmasters/{parId}") public ResponseEntity<Boolean>
			  deleteParMaster(@PathVariable("parId") int parId) throws
			  ResourceNotFoundException, ResourceNotDeletedException { return
			  ResponseEntity.ok(parMasterService.deleteParMaster(parId)); }
			 
}
