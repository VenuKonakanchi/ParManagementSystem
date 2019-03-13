package com.htc.par.controller;

import java.time.LocalDate;
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
import com.htc.par.service.PARMasterService;
import com.htc.par.to.PARMasterTO;

/**
 * Controller for PAR master
 *
 */
@RestController
@RequestMapping("/par")
public class PARMasterController {

	@Autowired
	private PARMasterService parMasterService;

	/**
	 * Request handler to get Par Master by id
	 * 
	 * @param parId
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/id/{parId}")
	public ResponseEntity<PARMasterTO> getParMasterById(@PathVariable("parId") Integer parId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getParMasterById(parId));
	}
	
	/**
	 * Request handler to get Par Master by PAR#
	 * 
	 * @param parId
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/parnumnber/{parId}")
	public ResponseEntity<PARMasterTO> getParMasterByParNumber(@PathVariable("parNumber") String parNumber)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getParMasterByParNumber(parNumber));
	}

	/**
	 * Request handler to get all Par Master
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/all")
	public ResponseEntity<List<PARMasterTO>> getAllParMaster() throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getAllParMaster());
	}
	
	/**
	 * Request handler to get all active or received Pars
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/validpars")
	public ResponseEntity<List<PARMasterTO>> getAllActiveOrReceivedPar() throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getAllActiveOrReceivedPar());
	}
	
	/**
	 * Request handler to get all active or received Pars
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/all/status")
	public ResponseEntity<List<PARMasterTO>> getAllParByStatus() throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getAllParByStatus());
	}
	
	/**
	 * Request handler to get all Pars by status and date range
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/status/{parStatus}/from/{fromdate}/todate/{todate}")
	public ResponseEntity<List<PARMasterTO>> getAllParsByStatusAndDateRange(@PathVariable("parStatus") String parStatus, @PathVariable("fromdate") LocalDate startDate, @PathVariable("todate") LocalDate endDate) throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getAllParsByStatusAndDateRange(parStatus, startDate, endDate));
	}
	
	/**
	 * Request handler to get all Pars by status and date range
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */

	@GetMapping("/parmasters/by/from/{fromdate}/todate/{todate}")
	public ResponseEntity<List<PARMasterTO>> getAllParsByDateRange(@PathVariable("fromdate") LocalDate startDate, @PathVariable("todate") LocalDate endDate) throws ResourceNotFoundException {
		return ResponseEntity.ok(parMasterService.getAllParsByDateRange(startDate, endDate));
	}


	/**
	 * Request handler to new Par Master
	 * 
	 * @param ParMasterTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */

	@PostMapping("/parmasters")
	public ResponseEntity<PARMasterTO> createParMaster(@Valid @RequestBody PARMasterTO parMasterTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(parMasterService.createParMaster(parMasterTO));
	}
	
	/**
	 * Request handler to send email to recruiters
	 * 
	 * @param ParMasterTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */

	@PostMapping("/parmasters/{parId}/sendemail")
	public ResponseEntity<Boolean> sendEmailToRecruiters(@PathVariable("parId") Integer parId) {
		//TODO: Create custom exception for e-mail failures
		return ResponseEntity.ok(parMasterService.sendEmailToRecruiters(parId));
	}

	/**
	 * Request handler to update Par Master 
	 * 
	 * @param ParMasterTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */

	@PutMapping("/parmasters/{parId}/fill/{intentToFillDate}/{intentToFillIndicator}")
	public ResponseEntity<PARMasterTO> intentToFill(@PathVariable("parId") Integer parId, @PathVariable("intentToFillDate") LocalDate intentToFillDate, @PathVariable("intentToFillIndicator") Boolean intentToFillIndicator)
			throws ResourceDuplicateException, ResourceNotUpdatedException {
		return ResponseEntity.ok(parMasterService.intentToFill(parId, intentToFillDate, intentToFillIndicator));
	}
	

	
	/**
	 * Request handler for intent to fill 
	 * 
	 * @param ParMasterTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */

	@PutMapping("/parmasters")
	public ResponseEntity<PARMasterTO> updateParMaster(@Valid @RequestBody PARMasterTO parMasterTO)
			throws ResourceDuplicateException, ResourceNotUpdatedException {
		return ResponseEntity.ok(parMasterService.updateParMaster(parMasterTO));
	}

	/**
	 * Request handler to delete Par Master
	 * 
	 * @param parId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/parmasters/{parId}")
	public ResponseEntity<Boolean> deleteParMaster(@PathVariable("parId") Integer parId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(parMasterService.deleteParMaster(parId));
	}

}
