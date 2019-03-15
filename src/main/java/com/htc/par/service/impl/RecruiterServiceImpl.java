/**
 * 
 */
package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Recruiter;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.CandidateRepository;
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

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public RecruiterTO getRecruiterTO(Recruiter recruiter) {
		RecruiterTO recruiterTO = new RecruiterTO(recruiter.getRecruiterId(), recruiter.getRecruiterName(),
				recruiter.getRecruiterPhoneNumber(), recruiter.getRecruiterEmail(), recruiter.getRecruiterEmailFlag(),
				recruiter.getRecruiterActive());
		return recruiterTO;
	}

	@Override
	public Recruiter getRecruiter(RecruiterTO recruiterTO) {
		Recruiter recruiter = new Recruiter(recruiterTO.getRecruiterId(), recruiterTO.getRecruiterName(),
				recruiterTO.getRecruiterPhoneNumber(), recruiterTO.getRecruiterEmail(),
				recruiterTO.getRecruiterEmailFlag(), recruiterTO.getRecruiterActive());
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
		Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterIdAndRecruiterActive(recruiterId,
				true);
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
	public RecruiterTO updateRecruiter(RecruiterTO recruiterTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		RecruiterTO updatedRecruiterTO = null;
		try {
			Optional<Recruiter> recruiterOptional = recruiterRepository
					.findByRecruiterIdAndRecruiterActive(recruiterTO.getRecruiterId(), true);

			boolean isRecruiterPresent = recruiterOptional.isPresent();
			Recruiter recruiterToUpdate = (isRecruiterPresent) ? recruiterOptional.get() : null;

			if (!isRecruiterPresent) {
				throw new ResourceNotFoundException(
						String.format("Recruiter: %s Not Found.", recruiterTO.getRecruiterName()));
			} else {

				if (recruiterTO.getRecruiterPhoneNumber().equals(recruiterToUpdate.getRecruiterPhoneNumber())) {
					if (recruiterTO.getRecruiterEmail().equals(recruiterToUpdate.getRecruiterEmail())) {
						NullAwareBeanUtil.copyProperties(recruiterTO, recruiterToUpdate);

						recruiterToUpdate = recruiterRepository.save(recruiterToUpdate);
						updatedRecruiterTO = getRecruiterTO(recruiterToUpdate);
					} else {
						recruiterOptional = recruiterRepository.findByRecruiterEmail(recruiterTO.getRecruiterEmail());
						isRecruiterPresent = recruiterOptional.isPresent();
						Recruiter anotherRecruiter = (isRecruiterPresent) ? recruiterOptional.get() : null;
						if (isRecruiterPresent && anotherRecruiter.getRecruiterActive()) {
							throw new ResourceDuplicateException(
									String.format("Recruiter with same email id: %s already exist.",
											recruiterTO.getRecruiterEmail()));
						} else if (isRecruiterPresent && (!anotherRecruiter.getRecruiterActive())) {
							throw new ResourceDuplicateException(
									String.format("Another Recruiter with same email id: %s already exist.",
											recruiterTO.getRecruiterEmail()));
						} else {
							NullAwareBeanUtil.copyProperties(recruiterTO, recruiterToUpdate);

							recruiterToUpdate = recruiterRepository.save(recruiterToUpdate);
							updatedRecruiterTO = getRecruiterTO(recruiterToUpdate);
						}
					}
				} else {
					recruiterOptional = recruiterRepository
							.findByRecruiterPhoneNumber(recruiterTO.getRecruiterPhoneNumber());
					isRecruiterPresent = recruiterOptional.isPresent();
					Recruiter anotherRecruiter = (isRecruiterPresent) ? recruiterOptional.get() : null;
					if (isRecruiterPresent && anotherRecruiter.getRecruiterActive()) {
						throw new ResourceDuplicateException(
								String.format("Recruiter with same mobile number: %s already exist.",
										recruiterTO.getRecruiterPhoneNumber()));
					} else if (isRecruiterPresent && (!anotherRecruiter.getRecruiterActive())) {
						throw new ResourceDuplicateException(
								String.format("Another Recruiter with same mobile number: %s already exist.",
										recruiterTO.getRecruiterPhoneNumber()));
					} else {
						NullAwareBeanUtil.copyProperties(recruiterTO, recruiterToUpdate);

						recruiterToUpdate = recruiterRepository.save(recruiterToUpdate);
						updatedRecruiterTO = getRecruiterTO(recruiterToUpdate);
					}
				}
			}
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(
					String.format("Recruiter : %s Not Found.", recruiterTO.getRecruiterName()));
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
			Optional<Recruiter> recruiterOptional = recruiterRepository
					.findByRecruiterPhoneNumber(recruiterTO.getRecruiterPhoneNumber());
			Recruiter recruiter = null;

			boolean isRecruiterPresent = recruiterOptional.isPresent();

			recruiter = (isRecruiterPresent) ? recruiterOptional.get() : null;
			if (isRecruiterPresent && recruiter.getRecruiterActive()) {
				throw new ResourceDuplicateException(String.format(
						"Recruiter with same mobile number: %s already exist.", recruiterTO.getRecruiterPhoneNumber()));
			} else if (isRecruiterPresent && (!recruiter.getRecruiterActive())) {
				recruiterTO.setRecruiterActive(true);
				NullAwareBeanUtil.copyProperties(recruiterTO, recruiter);
			} else if (!isRecruiterPresent) {
				recruiterOptional = recruiterRepository.findByRecruiterEmail(recruiterTO.getRecruiterEmail());
				isRecruiterPresent = recruiterOptional.isPresent();

				recruiter = (isRecruiterPresent) ? recruiterOptional.get() : null;

				if (isRecruiterPresent && recruiter.getRecruiterActive()) {
					throw new ResourceDuplicateException(String.format(
							"Recruiter with same email id: %s already exist.", recruiterTO.getRecruiterEmail()));
				} else if (isRecruiterPresent && (!recruiter.getRecruiterActive())) {
					recruiterTO.setRecruiterActive(true);
					NullAwareBeanUtil.copyProperties(recruiterTO, recruiter);
				} else {
					recruiterTO.setRecruiterActive(true);
					recruiter = getRecruiter(recruiterTO);
				}
			}

			if (recruiter != null) {
				recruiter = recruiterRepository.save(recruiter);
				recruiterTO = getRecruiterTO(recruiter);
			} else {
				throw new ResourceNotCreatedException("Error while creating Recruiter record.");
			}
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException("Error while creating Recruiter record.");
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
			Optional<Recruiter> recruiterOptional = recruiterRepository.findByRecruiterIdAndRecruiterActive(recruiterId,
					true);
			Recruiter recruiter;
			if (!recruiterOptional.isPresent()) {
				throw new ResourceNotFoundException("Recruiter not found.");
			} else if (recruiterOptional.isPresent()) {
				recruiter = recruiterOptional.get();
				Long totalCandidate = candidateRepository.countActiveCandidatesForRecruiter(true,
						recruiter.getRecruiterId());
				// if(recruiter.getCandidates().size()>0) {
				if ((totalCandidate != null) && (totalCandidate > 0)) {
					throw new ResourceNotDeletedException(recruiter.getRecruiterName()
							+ " - recruiter info cannot be deleted, since there are some candidate(s) tied up to this recruiter.");
				}
			}
			recruiter = recruiterOptional.get();
			recruiter.setRecruiterActive(false);
			recruiterRepository.save(recruiter);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("Unable to delete recruiter");
		}
		return true;
	}

	@Override
	public List<RecruiterTO> getRecruiterByRecruiterEmailFlag(boolean recruiterEmailFlag)
			throws ResourceNotFoundException {

		List<Recruiter> recruiterEntities = recruiterRepository.findAllByRecruiterEmailFlag(recruiterEmailFlag);
		if (CollectionUtils.isEmpty(recruiterEntities))
			throw new ResourceNotFoundException("No Recruiters Found.");
		List<RecruiterTO> recruiterList = recruiterEntities.stream().map(recruiter -> {
			return getRecruiterTO(recruiter);
		}).collect(Collectors.toList());
		return recruiterList;
	}
}
