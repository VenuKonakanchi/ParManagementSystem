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
import com.htc.par.service.PreScreenerService;
import com.htc.par.to.PreScreenerTO;

/** Rest controller for PreScreener service **/

@RestController
@RequestMapping("/par")
public class PreScreenerController {

	@Autowired
	private PreScreenerService preScreenerService;

	/**
	 * Request handler to get preScreener by id
	 * @param preScreenerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/preScreeners/{preScreenerId}")
	public ResponseEntity<PreScreenerTO> getPreScreenerById(@PathVariable("preScreenerId") int preScreenerId) throws ResourceNotFoundException {
		return ResponseEntity.ok(preScreenerService.getPreScreenerById(preScreenerId));
	}

	/**
	 * Request handler to get all preScreeners 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/preScreeners")
	public ResponseEntity<List<PreScreenerTO>> getPreScreeners() throws ResourceNotFoundException {
		return ResponseEntity.ok(preScreenerService.getAllPreScreeners());
	}

	/**
	 * Request handler to new active preScreener
	 * @param preScreenerTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/preScreeners")
	public ResponseEntity<PreScreenerTO> createPreScreener(@RequestBody PreScreenerTO preScreenerTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(preScreenerService.createPreScreener(preScreenerTO));
	}

	/**
	 * Request handler to update active preScreener 
	 * @param preScreenerTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/preScreeners")
	public ResponseEntity<PreScreenerTO> updatePreScreener(@RequestBody PreScreenerTO preScreenerTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(preScreenerService.updatePreScreener(preScreenerTO));
	}

	/**
	 * Request handler to delete preScreener
	 * @param preScreenerId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/preScreeners/{preScreenerId}")
	public ResponseEntity<Boolean> deletePreScreener(@PathVariable("preScreenerId") int preScreenerId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(preScreenerService.deletePreScreener(preScreenerId));
	}
}
