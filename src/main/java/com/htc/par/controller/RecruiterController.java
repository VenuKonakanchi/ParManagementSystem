package com.htc.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.repository.RecruiterRepository;
import com.htc.par.to.RecruiterTO;

/* @author - Ram
 * Controller to handle Recruiter's information.
 */
@RestController
public class RecruiterController {
	
	@Autowired
	RecruiterRepository recruiterRepository;

	@GetMapping("/par/recruiter")
	public List<RecruiterTO> getRecruiters() {
		return null;
	}

	@PostMapping("/par/recruiter")
	public List<RecruiterTO> getRecruitersInfo() {
		return null;
	}
	
}
