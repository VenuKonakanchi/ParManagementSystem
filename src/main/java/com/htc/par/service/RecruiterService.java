/**
 * 
 */
package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.Recruiter;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.RecruiterTO;

/**
 * Service class for Recruiter Repository
 *
 */

@Service
public interface RecruiterService{
	
	
	public RecruiterTO getRecruiterById(int recruiterId) throws ResourceNotFoundException;
	
	public List<RecruiterTO> getAllRecruiters() throws ResourceNotFoundException;
	
	public RecruiterTO updateRecruiter(RecruiterTO recruiterTO) throws ResourceNotUpdatedException;
	
	public RecruiterTO createRecruiter(RecruiterTO recruiterTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteRecruiter(int recruiterId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public RecruiterTO getRecruiterTO(Recruiter recruiter);
	
	public Recruiter getRecruiter(RecruiterTO recruiterTO);
}
