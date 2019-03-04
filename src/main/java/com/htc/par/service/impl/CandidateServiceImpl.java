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
import com.htc.par.service.SkillService;
import com.htc.par.to.CandidateTO;
import com.htc.par.to.SkillTO;
import com.htc.par.utilities.NullAwareBeanUtil;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private SkillService skillService;


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
	public CandidateTO updateCandidate(CandidateTO candidateTO) throws ResourceNotFoundException, ResourceNotUpdatedException, ResourceDuplicateException {
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
					//	candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
						SkillTO	skillTO = skillService.getSkillById(candidateTO.getSkill().getSkillId());
						candidateToUpdate.setSkill(skillService.getSkill(skillTO));
						
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
						//	candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
							SkillTO	skillTO = skillService.getSkillById(candidateTO.getSkill().getSkillId());
							candidateToUpdate.setSkill(skillService.getSkill(skillTO));
							
							candidateToUpdate = candidateRepository.save(candidateToUpdate);
							candidateTO = getCandidateTO(candidateToUpdate);
						}
					}
				} else {
					candidateOptional = candidateRepository
							.findByCandidatePhoneNumber(candidateTO.getCandidatePhoneNumber());
					isCandidatePresent = candidateOptional.isPresent();
					Candidate anotherCandidate = (isCandidatePresent) ? candidateOptional.get() : null;
					if (isCandidatePresent && anotherCandidate.getCandidateActive()) {
						throw new ResourceDuplicateException(
								String.format("Candidate with same mobile number: %s already exist.",
										candidateTO.getCandidatePhoneNumber()));
					} else if (isCandidatePresent && (!anotherCandidate.getCandidateActive())) {
						throw new ResourceDuplicateException(
								String.format("Another in-active candidate with same mobile number: %s already exist.",
										candidateTO.getCandidatePhoneNumber()));
					} else {
						NullAwareBeanUtil.copyProperties(candidateTO, candidateToUpdate);
					//	candidateToUpdate.setSkill(skillService.getSkill(candidateTO.getSkill()));
						candidateToUpdate = candidateRepository.save(candidateToUpdate);
						SkillTO	skillTO = skillService.getSkillById(candidateTO.getSkill().getSkillId());
						candidateToUpdate.setSkill(skillService.getSkill(skillTO));
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
				candidate.setSkill(skillService.getSkill(candidateTO.getSkill()));
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
					candidate.setSkill(skillService.getSkill(candidateTO.getSkill()));
				} else {
					candidateTO.setCandidateActive(true);
					candidate = getCandidate(candidateTO);

				}
			}

			if (candidate != null) {
				SkillTO	skillTO = skillService.getSkillById(candidateTO.getSkill().getSkillId());
				candidate.setSkill(skillService.getSkill(skillTO));
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
				skillService.getSkillTO(candidate.getSkill()));

	}

	@Override
	public Candidate getCandidate(CandidateTO candidateTO) {
		// TODO Auto-generated method stub

		return new Candidate(candidateTO.getCandidateName(), candidateTO.getCandidatePhoneNumber(),
				candidateTO.getCandidateEmail(), candidateTO.getCandidateActive(),
				skillService.getSkill(candidateTO.getSkill()));
	}

	public CandidateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}