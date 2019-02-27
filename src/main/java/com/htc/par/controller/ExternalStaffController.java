package com.htc.par.controller;

import java.util.List;

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
import com.htc.par.service.ExternalStaffService;
import com.htc.par.to.ExternalStaffTO;
import com.htc.par.to.SkillTO;

@RestController
@RequestMapping("/par")
public class ExternalStaffController {
	@Autowired
	private ExternalStaffService externalStaffService;

	/**
	 * Request handler to get External Staff by id
	 * @param ExternalStaffId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/externalstaff/{extStaffId}")
	public ResponseEntity<ExternalStaffTO> getExtStaffById(@PathVariable("extStaffId") int extStaffId) throws ResourceNotFoundException {
		return ResponseEntity.ok(externalStaffService.getExternalStaffById(extStaffId));
	}

	/**
	 * Request handler to get all External Staff
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/externalstaff")
	public ResponseEntity<List<ExternalStaffTO>> getAllExtStaff() throws ResourceNotFoundException {
		return ResponseEntity.ok(externalStaffService.getAllExternalStaff());
	}

	/**
	 * Request handler to new External Staff
	 * @param ExternalStaffTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/externalstaff")
	public ResponseEntity<ExternalStaffTO> createExtStaff(@RequestBody ExternalStaffTO externalStaffTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		System.out.println(" Inside external controller "  );
		System.out.println("Input " + externalStaffTO);
		return ResponseEntity.created(null).body(externalStaffService.createExternalStaff(externalStaffTO));
	}

	/**
	 * Request handler to update External Staff
	 * @param ExternalStaffTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/externalstaff")
	public ResponseEntity<ExternalStaffTO> updateExtStaff(@RequestBody ExternalStaffTO externalStaffTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(externalStaffService.updateExternalStaff(externalStaffTO));
	}

	/**
	 * Request handler to delete External Staff
	 * @param extStaffId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/externalstaff/{extStaffId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("extStaffId") int extStaffId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(externalStaffService.deleteExternalStaff(extStaffId));
	}
	

}
