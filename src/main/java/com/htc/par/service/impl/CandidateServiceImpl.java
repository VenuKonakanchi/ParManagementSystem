package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Candidate;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.CandidateRepository;
import com.htc.par.service.CandidateService;
import com.htc.par.service.RecruiterService;
import com.htc.par.to.CandidateTO;
import com.htc.par.to.RecruiterTO;
import com.htc.par.utilities.NullAwareBeanUtil;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private RecruiterService recruiterService;

	@Override
	public CandidateTO getCandidateById(int candId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Candidate> candOptional = candidateRepository.findByCandidateIdAndCandidateActive(candId, true);
		CandidateTO candidateTO = null;
		if (!candOptional.isPresent())
			throw new ResourceNotFoundException(String.format(" Id : %s not found.", candId));
		candidateTO = getCandidateTO(candOptional.get());
		return candidateTO;
	}

	@Override
	public List<CandidateTO> getAllCandidate() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<Candidate> candidates = candidateRepository.findAllByCandidateActive(true);
		if (CollectionUtils.isEmpty(candidates))
			throw new ResourceNotFoundException("No Candidates Found.");
		List<CandidateTO> candidateTOs = candidates.stream().map(Candidate -> {
			return getCandidateTO(Candidate);
		}).collect(Collectors.toList());
		return candidateTOs;

	}

	@Override
	public CandidateTO updateCandidate(CandidateTO candidateTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException, ResourceDuplicateException {
		try {
			Optional<Candidate> candidateOptional = candidateRepository.findByCandidateIdAndCandidateActive(
					candidateTO.getCandidateId(), candidateTO.getCandidateActive());
			boolean isCandidatePresent = candidateOptional.isPresent();
			Candidate candidateToUpdate = (isCandidatePresent) ? candidateOptional.get() : null;
			if (!isCandidatePresent) {
				throw new ResourceNotFoundException(
						String.format("Candidate: %s Not Found.", candidateTO.getCandidateName()));
			} else {
				if (candidateTO.getCandidatePhoneNumber().equals(candidateToUpdate.getCandidatePhoneNumber())) {
					if (candidateTO.getCandidateEmail().equals(candidateToUpdate.getCandidateEmail())) {
						NullAwareBeanUtil.copyProperties(candidateTO, candidateToUpdate);
						// candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
						RecruiterTO recruiterTO = recruiterService
								.getRecruiterById(candidateTO.getRecruiter().getRecruiterId());
						candidateToUpdate.setRecruiter(recruiterService.getRecruiter(recruiterTO));

						candidateToUpdate = candidateRepository.save(candidateToUpdate);
						candidateTO = getCandidateTO(candidateToUpdate);
					} else {
						candidateOptional = candidateRepository.findByCandidateEmail(candidateTO.getCandidateEmail());
						isCandidatePresent = candidateOptional.isPresent();
						Candidate anotherCandidate = (isCandidatePresent) ? candidateOptional.get() : null;
						if (isCandidatePresent && anotherCandidate.getCandidateActive()) {
							throw new ResourceDuplicateException(
									String.format("Candidate with same email id: %s already exist.",
											candidateTO.getCandidateEmail()));
						} else if (isCandidatePresent && (!anotherCandidate.getCandidateActive())) {
							throw new ResourceDuplicateException(
									String.format("Another In-active candidate with same email id: %s already exist.",
											candidateTO.getCandidateEmail()));
						} else {
							NullAwareBeanUtil.copyProperties(candidateTO, candidateToUpdate);
							// candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
							RecruiterTO recruiterTO = recruiterService
									.getRecruiterById(candidateTO.getRecruiter().getRecruiterId());
							candidateToUpdate.setRecruiter(recruiterService.getRecruiter(recruiterTO));
							candidateToUpdate = candidateRepository.save(candidateToUpdate);
							candidateTO = getCandidateTO(candidateToUpdate);
						}
					}
				} else {
					candidateOptional = candidateRepository
							.findByCandidatePhoneNumber(candidateTO.getCandidatePhoneNumber());
					isCandidatePresent = candidateOptional.isPresent();
					Candidate anotherCandidate = (isCandidatePresent) ? candidateOptional.get() : null;
					if (!isCandidatePresent) {
						candidateOptional = candidateRepository.findByCandidateEmail(candidateTO.getCandidateEmail());
						boolean isAnotherCandidatePresent = candidateOptional.isPresent();
						Candidate candidateWithSameEmail = (isAnotherCandidatePresent) ? candidateOptional.get() : null;
						if (isAnotherCandidatePresent && candidateWithSameEmail.getCandidateActive()) {
							throw new ResourceDuplicateException(
									String.format("Candidate with same email id: %s already exist.",
											candidateTO.getCandidateEmail()));
						} else if (isAnotherCandidatePresent && (!candidateWithSameEmail.getCandidateActive())) {
							throw new ResourceDuplicateException(
									String.format("Another In-active candidate with same email id: %s already exist.",
											candidateTO.getCandidateEmail()));
						}else {
							NullAwareBeanUtil.copyProperties(candidateTO, candidateToUpdate);
							// candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
							candidateToUpdate = candidateRepository.save(candidateToUpdate);
							RecruiterTO recruiterTO = recruiterService
									.getRecruiterById(candidateTO.getRecruiter().getRecruiterId());
							candidateToUpdate.setRecruiter(recruiterService.getRecruiter(recruiterTO));
							candidateTO = getCandidateTO(candidateToUpdate);
						}
					} else if (isCandidatePresent && anotherCandidate.getCandidateActive()) {
						throw new ResourceDuplicateException(
								String.format("Candidate with same mobile number: %s already exist.",
										candidateTO.getCandidatePhoneNumber()));
					} else if (isCandidatePresent && (!anotherCandidate.getCandidateActive())) {
						throw new ResourceDuplicateException(
								String.format("Another in-active candidate with same mobile number: %s already exist.",
										candidateTO.getCandidatePhoneNumber()));
					} else {
						NullAwareBeanUtil.copyProperties(candidateTO, candidateToUpdate);
						// candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
						candidateToUpdate = candidateRepository.save(candidateToUpdate);
						RecruiterTO recruiterTO = recruiterService
								.getRecruiterById(candidateTO.getRecruiter().getRecruiterId());
						candidateToUpdate.setRecruiter(recruiterService.getRecruiter(recruiterTO));
						candidateTO = getCandidateTO(candidateToUpdate);
					}
				}
			}
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(
					String.format("Candidate : %s Not Found.", candidateTO.getCandidateName()));
		}
		return candidateTO;
	}

	@Override
	public CandidateTO createCandidate(CandidateTO candidateTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<Candidate> candidateOptional = candidateRepository
					.findByCandidatePhoneNumber(candidateTO.getCandidatePhoneNumber());
			boolean isCandidatePresent = candidateOptional.isPresent();

			Candidate candidate = (isCandidatePresent) ? candidateOptional.get() : null;
			if (isCandidatePresent && candidate.getCandidateActive()) {
				throw new ResourceDuplicateException(String.format(
						"Candidate with same mobile number: %s already exist.", candidateTO.getCandidatePhoneNumber()));
			} else if (isCandidatePresent && (!candidate.getCandidateActive())) {
				candidateTO.setCandidateActive(true);
				NullAwareBeanUtil.copyProperties(candidateTO, candidate);
				candidate.setRecruiter(recruiterService.getRecruiter(candidateTO.getRecruiter()));
			} else if (!isCandidatePresent) {
				candidateOptional = candidateRepository.findByCandidateEmail(candidateTO.getCandidateEmail());
				isCandidatePresent = candidateOptional.isPresent();
				candidate = (isCandidatePresent) ? candidateOptional.get() : null;
				if (isCandidatePresent && candidate.getCandidateActive()) {
					throw new ResourceDuplicateException(String.format(
							"Candidate with same email id: %s already exist.", candidateTO.getCandidateEmail()));
				} else if (isCandidatePresent && (!candidate.getCandidateActive())) {
					candidateTO.setCandidateActive(true);
					NullAwareBeanUtil.copyProperties(candidateTO, candidate);
					candidate.setRecruiter(recruiterService.getRecruiter(candidateTO.getRecruiter()));
				} else {
					candidateTO.setCandidateActive(true);
					candidate = getCandidate(candidateTO);

				}
			}

			if (candidate != null) {
				RecruiterTO recruiterTO = recruiterService
						.getRecruiterById(candidateTO.getRecruiter().getRecruiterId());
				candidate.setRecruiter(recruiterService.getRecruiter(recruiterTO));
				candidate = candidateRepository.save(candidate);
				candidateTO = getCandidateTO(candidate);
			} else {
				throw new ResourceNotCreatedException("Error while creating candidate record.");
			}

		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException("Error while creating candidate record.");
		}
		return candidateTO;
	}

	@Override
	public boolean deleteCandidate(int candId) throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		try {
			Optional<Candidate> candidatenOptional = candidateRepository.findByCandidateIdAndCandidateActive(candId,
					true);
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

		return new CandidateTO(candidate.getCandidateId(), candidate.getCandidateName(),
				candidate.getCandidatePhoneNumber(), candidate.getCandidateEmail(), candidate.getCandidateActive(),
				recruiterService.getRecruiterTO(candidate.getRecruiter()), candidate.getCandidateReceivedDate());

	}

	@Override
	public Candidate getCandidate(CandidateTO candidateTO) {
		// TODO Auto-generated method stub

		return new Candidate(candidateTO.getCandidateName(), candidateTO.getCandidatePhoneNumber(),
				candidateTO.getCandidateEmail(), candidateTO.getCandidateActive(),
				recruiterService.getRecruiter(candidateTO.getRecruiter()), candidateTO.getCandidateReceivedDate());
	}

	public CandidateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}