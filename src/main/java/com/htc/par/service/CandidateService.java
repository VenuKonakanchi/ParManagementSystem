package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.Candidate;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.CandidateTO;

@Service
public interface CandidateService {
	
	public CandidateTO getCandidateById(int candId) throws ResourceNotFoundException;
	
	public List<CandidateTO> getAllCandidate() throws ResourceNotFoundException;
	
	public CandidateTO updateCandidate(CandidateTO candidateTO) throws ResourceNotFoundException, ResourceNotUpdatedException, ResourceDuplicateException;
	
	public CandidateTO createCandidate(CandidateTO candidateTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteCandidate(int candId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public Candidate getCandidate(CandidateTO candidateTO);
	
	public CandidateTO getCandidateTO(Candidate candidate);

}
