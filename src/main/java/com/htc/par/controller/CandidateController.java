/**
 * 
 */
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
import com.htc.par.service.CandidateService;
import com.htc.par.to.CandidateTO;

/**
 * controller class for candidate
 *
 */
@RestController
@RequestMapping("/par")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	/**
	 * Request handler to get candidate by id
	 * @param candidateId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/candidates/{candidateId}")
	public ResponseEntity<CandidateTO> getCandidateById(@PathVariable("candidateId") int candidateId) throws ResourceNotFoundException {
		return ResponseEntity.ok(candidateService.getCandidateById(candidateId));
	}

	/**
	 * Request handler to get all candidates 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/candidates")
	public ResponseEntity<List<CandidateTO>> getAllCandidates() throws ResourceNotFoundException {
		return ResponseEntity.ok(candidateService.getAllCandidate());
	}
	
	/**
	 * Request handler to add new active candidate
	 * @param skillTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/candidates")
	public ResponseEntity<CandidateTO> createCandidate(@Valid @RequestBody CandidateTO candidateTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(candidateService.createCandidate(candidateTO));
	}
	
	/**
	 * Request handler to update active skill 
	 * @param skillTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/candidates")
	public ResponseEntity<CandidateTO> updateCandidate(@Valid @RequestBody CandidateTO candidateTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException, ResourceDuplicateException  {
		return ResponseEntity.ok(candidateService.updateCandidate(candidateTO));
	}
	
	/**
	 * Request handler to delete candidate
	 * @param skillId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/candidates/{candidateId}")
	public ResponseEntity<Boolean> deleteCandidate(@PathVariable("candidateId") int candidateId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(candidateService.deleteCandidate(candidateId));
	}
}
