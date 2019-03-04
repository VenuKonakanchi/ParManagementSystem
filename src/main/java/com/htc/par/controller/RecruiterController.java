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
import com.htc.par.service.RecruiterService;
import com.htc.par.to.RecruiterTO;

/**
 * @author Ram
 * Rest Controller to handle Recruiter's information.
 */

@RestController
@RequestMapping("/par")
public class RecruiterController {
	
	@Autowired
	private RecruiterService recruiterService;

	/**
	 * Request handler to get Recruiter by id
	 * @param recruiterId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/recruiters/{recruiterId}")
	public ResponseEntity<RecruiterTO> getRecruiterById(@PathVariable("recruiterId") int recruiterId) throws ResourceNotFoundException {
		return ResponseEntity.ok(recruiterService.getRecruiterById(recruiterId));
	}

	/**
	 * Request handler to get all recruiters 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/recruiters")
	public ResponseEntity<List<RecruiterTO>> getRecruiters() throws ResourceNotFoundException {
		return ResponseEntity.ok(recruiterService.getAllRecruiters());
	}

	/**
	 * Request handler to create new Recruiter entry
	 * @param RecruiterTO
	 * @return
	 * @throws ResourceNotCreatedException
	 * @throws ResourceDuplicateException
	 */
	@PostMapping("/recruiters")
	public ResponseEntity<RecruiterTO> createRecruiter(@Valid @RequestBody RecruiterTO recruiterTO)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(recruiterService.createRecruiter(recruiterTO));
	}

	/**
	 * Request handler to update active recruiter
	 * @param RecruiterTO
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotUpdatedException
	 */
	@PutMapping("/recruiters")
	public ResponseEntity<RecruiterTO> updateRecruiter(@Valid @RequestBody RecruiterTO recruiterTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(recruiterService.updateRecruiter(recruiterTO));
	}

	/**
	 * Request handler to delete recruiter
	 * @param RecruiterId
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceNotDeletedException
	 */
	@DeleteMapping("/recruiters/{recruiterId}")
	public ResponseEntity<Boolean> deleteRecruiter(@PathVariable("recruiterId") int recruiterId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(recruiterService.deleteRecruiter(recruiterId));
	}
	
	@GetMapping("/recruiters/email/{recruiterEmailFlag}")
	public ResponseEntity<List<RecruiterTO>> getRecruiters(@PathVariable("recruiterEmailFlag") boolean recruiterEmailFlag) throws ResourceNotFoundException {
		return ResponseEntity.ok(recruiterService.getRecruiterByRecruiterEmailFlag(recruiterEmailFlag));
	}
	
}
