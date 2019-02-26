package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Area;
import com.htc.par.entity.Candidate;
import com.htc.par.entity.ExternalStaff;
import com.htc.par.entity.Skill;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.AreaRepository;
import com.htc.par.repository.CandidateRepository;
import com.htc.par.repository.ExternalStaffRepository;
import com.htc.par.repository.SkillRepository;
import com.htc.par.service.CandidateService;
import com.htc.par.service.ExternalStaffService;
import com.htc.par.service.SkillService;
import com.htc.par.to.AreaTO;
import com.htc.par.to.CandidateTO;
import com.htc.par.to.ExternalStaffTO;
import com.htc.par.to.SkillTO;
import com.htc.par.utilities.NullAwareBeanUtil;

@Service
public class CandidateServiceImpl implements CandidateService {
  
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private SkillService skillService;
	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public CandidateTO getCandidateById(int candId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Candidate> candOptional = candidateRepository.findByCandidateIdAndCandidateActive(candId, true);
		CandidateTO candidateTO  = null;
		if (!candOptional.isPresent())
			throw new ResourceNotFoundException(String.format(" Id : %s not found.", candId));
		candidateTO = getCandidateTO(candOptional.get());
		return candidateTO;
	   }

	@Override
	public List<CandidateTO> getAllCandidate() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<Candidate> candidates = candidateRepository.findAllByExtCandidateActive(true);
		if (CollectionUtils.isEmpty(candidates))
			throw new ResourceNotFoundException("No Candidates Found.");
		List<CandidateTO> candidateTOs = candidates.stream().map(Candidate -> {
																				 return getCandidateTO(Candidate);
																			  }).collect(Collectors.toList());
		return candidateTOs;
	
	}

	@Override
	public CandidateTO updateCandidate(CandidateTO candidateTO) throws ResourceNotUpdatedException {
		// TODO Auto-generated method stub
		CandidateTO updatedCandidateTO = null;
		Optional<Candidate> candidateOptional = null;
		try {
			
			if(candidateTO.getCandidateId() !=null){
				candidateOptional = candidateRepository.findByCandidateIdAndCandidateActive(candidateTO.getCandidateId(),candidateTO.getCandidateActive());
			}else if (!candidateTO.getCandidateName().isEmpty()) {
				candidateOptional = candidateRepository.findByCandidateNameAndCandidateActive(candidateTO.getCandidateName(),candidateTO.getCandidateActive());
			}	
			
			if (!candidateOptional.isPresent())
				throw new ResourceNotFoundException(String.format("Candidate: %s Not Found.", candidateTO.getCandidateName()));
			
			Candidate candidate = candidateOptional.get();
		    NullAwareBeanUtil.copyProperties(candidateTO, candidate);
				
			if(candidateTO.getSkill().getSkillId()!=null){
					
				SkillTO skillTO = skillService.getSkillById(candidateTO.getSkill().getSkillId()) ;
				if(skillTO != null)
					candidate.setSkill(skillService.getSkill(skillTO)); 
			   					
			} else if (!candidateTO.getSkill().getSkillName().isEmpty()) {
					
				Optional<Skill> skillOptional = skillRepository.findBySkillNameAndSkillActive(candidateTO.getSkill().getSkillName(), 
																							candidateTO.getSkill().getSkillActive());
				if(skillOptional.isPresent())
					candidate.setSkill(skillOptional.get()) ;
			}
			updatedCandidateTO = getCandidateTO(candidateRepository.save(candidate));
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("Candidate : %s Not Found.", candidateTO.getCandidateName()));
		}
		return updatedCandidateTO;
    }

	@Override
	public CandidateTO createCandidate(CandidateTO candidateTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		// TODO Auto-generated method stub
		try {
			Optional<Candidate> candidateOptional =candidateRepository.findByCandidateName(candidateTO.getCandidateName());
			Candidate candidate = null;
			if (!candidateOptional.isPresent()) {
				candidateTO.setCandidateActive(true); 
				candidateTO.getSkill().setSkillActive(true);
				candidate = getCandidate(candidateTO);
			} else {
				candidate = candidateOptional.get();
				candidate.setCandidateActive(true);
				candidateTO.setCandidateActive(true);
			}
			
			if(candidateTO.getSkill().getSkillId() !=null){
				
				Optional<Skill> skillOptional = skillRepository.findById(candidateTO.getSkill().getSkillId()) ;
				if(skillOptional.isPresent()){ 
					candidate.setSkill(skillOptional.get());
					}
				
			} else if (!candidateTO.getSkill().getSkillName().isEmpty()) {
				
				Optional<Skill> skillOptional = skillRepository.findBySkillName(candidateTO.getSkill().getSkillName()) ;
				if(skillOptional.isPresent()){ 
					candidate.setSkill(skillOptional.get());
					}
				
			}
			candidate = candidateRepository.save(candidate);
			candidateTO = getCandidateTO(candidate);
		} catch (DataIntegrityViolationException die) {
			throw new ResourceDuplicateException(String.format("Candidate: %s Already Exist.",candidateTO.getCandidateName()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("Candidate: %s is not created.", candidateTO.getCandidateName()));
		}
		return candidateTO;
	}

	@Override
	public boolean deleteCandidate(int candId) throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		try {
			Optional<Candidate> candidatenOptional = candidateRepository.findByCandidateIdAndCandidateActive(candId, true);
			if (!candidatenOptional.isPresent())
				throw new ResourceNotFoundException("Candidate is not found.");
			Candidate candidate = candidatenOptional.get();
			candidate.setCandidateActive(false);
			candidateRepository.save(candidate);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("Candidate is not deleted.");
		}
		return true;
	
	}

	@Override
	public CandidateTO getCandidateTO(Candidate candidate) {
		// TODO Auto-generated method stub
		
		return new CandidateTO(candidate.getCandidateId(),
							   candidate.getCandidateName(),
							   candidate.getCandidatePhoneNumber(),
							   candidate.getCandidateEmail(),
							   candidate.getCandidateActive(),
							   skillService.getSkillTO(candidate.getSkill()) 
							   );
							  
	}

	@Override
	public Candidate getCandidate(CandidateTO candidateTO) {
		// TODO Auto-generated method stub
	
		return new Candidate(candidateTO.getCandidateName(),
							 candidateTO.getCandidatePhoneNumber(),
							 candidateTO.getCandidateEmail(),
							 candidateTO.getCandidateActive(),
							 skillService.getSkill(candidateTO.getSkill()));
	}



	public CandidateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
