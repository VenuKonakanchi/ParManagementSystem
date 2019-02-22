/**
 * 
 */
package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Recruiter;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.RecruiterRepository;
import com.htc.par.service.RecruiterService;
import com.htc.par.to.RecruiterTO;
import com.htc.par.utilities.NullAwareBeanUtil;

/**
 * Recruiter Service Implementation
 *
 */

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Override
	public RecruiterTO getRecruiterTO(Recruiter recruiter) {
		RecruiterTO recruiterTO = new RecruiterTO(recruiter.getRecruiterId(), recruiter.getRecruiterName(), recruiter.getRecruiterPhoneNumber(), recruiter.getRecruiterEmail(),recruiter.getRecruiterEmailFlag(),recruiter.getRecruiterActive());
		return recruiterTO;
	}

	@Override
	public Recruiter getRecruiter(RecruiterTO recruiterTO) {
		Recruiter recruiter = new Recruiter(recruiterTO.getRecruiterId(), recruiterTO.getRecruiterName(), recruiterTO.getRecruiterPhoneNumber(), recruiterTO.getRecruiterEmail(),recruiterTO.getRecruiterEmailFlag(),recruiterTO.getRecruiterActive());
		return recruiter;
	}

	/**
	 * Get active Recruiter by Id
	 * 
	 * @param recruiterId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@Override
	public RecruiterTO getRecruiterById(int recruiterId) throws ResourceNotFoundException {
		Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterIdAndRecruiterActive(recruiterId, true);
		RecruiterTO recruiterTO = null;
		if (!recruiterOptional.isPresent())
			throw new ResourceNotFoundException(String.format("Recruiter Id: %s not found.", recruiterId));
		recruiterTO = getRecruiterTO(recruiterOptional.get());
		return recruiterTO;
	}

	/**
	 * Get active Recruiters
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@Override
	public List<RecruiterTO> getAllRecruiters() throws ResourceNotFoundException {
		List<Recruiter> recruiterEntities = recruiterRepository.findAllByRecruiterActive(true);
		if (CollectionUtils.isEmpty(recruiterEntities))
			throw new ResourceNotFoundException("No Recruiters Found.");
		List<RecruiterTO> recruiterList = recruiterEntities.stream().map(recruiter -> {
			return getRecruiterTO(recruiter);
		}).collect(Collectors.toList());
		return recruiterList;
	}

	/**
	 * Update active Recruiter
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotUpdatedException
	 */
	@Override
	public RecruiterTO updateRecruiter(RecruiterTO recruiterTO) throws ResourceNotFoundException, ResourceNotUpdatedException {
		RecruiterTO updatedRecruiterTO = null;
		try {
			Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterIdAndRecruiterActive(recruiterTO.getRecruiterId(), true);
			if (!recruiterOptional.isPresent())
				throw new ResourceNotFoundException(String.format("Recruiter: %s Not Found.", recruiterTO.getRecruiterName()));
			Recruiter recruiter = recruiterOptional.get();
			NullAwareBeanUtil.copyProperties(recruiterTO, recruiter);
			updatedRecruiterTO = getRecruiterTO(recruiterRepository.save(recruiter));
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("Recruiter: %s Not Found.", recruiterTO.getRecruiterName()));
		}
		return updatedRecruiterTO;
	}

	/**
	 * create new Recruiter
	 * 
	 * @return
	 * @throws ResourceDuplicateException, ResourceNotCreatedException
	 */
	@Override
	public RecruiterTO createRecruiter(RecruiterTO recruiterTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterName(recruiterTO.getRecruiterName());
			Recruiter recruiter = null;
			if (!recruiterOptional.isPresent()) {
				recruiterTO.setRecruiterActive(true);
				recruiter = getRecruiter(recruiterTO);
			} else {
				recruiter = recruiterOptional.get();
				recruiter.setRecruiterActive(true);
				recruiterTO.setRecruiterActive(true);
			}
			recruiter = recruiterRepository.save(recruiter);
			recruiterTO = getRecruiterTO(recruiter);
		} catch (DataIntegrityViolationException die) {
			throw new ResourceDuplicateException(String.format("Recruiter Phone number: %s already exists.", recruiterTO.getRecruiterPhoneNumber()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("Unable to create Recruiter: %s.", recruiterTO.getRecruiterName()));
		}
		return recruiterTO;
	}

	/**
	 * De-activate recruiter
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotDeletedException
	 */
	@Override
	public boolean deleteRecruiter(int recruiterId) throws ResourceNotFoundException, ResourceNotDeletedException {
		try {
			Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterIdAndRecruiterActive(recruiterId, true);
			if (!recruiterOptional.isPresent())
				throw new ResourceNotFoundException("Recruiter not found.");
			Recruiter recruiter = recruiterOptional.get();
			recruiter.setRecruiterActive(false);
			recruiterRepository.save(recruiter);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("Unable to delete recruiter");
		}
		return true;
	}
}
