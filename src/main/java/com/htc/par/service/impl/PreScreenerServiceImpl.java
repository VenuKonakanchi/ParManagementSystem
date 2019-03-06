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

import com.htc.par.entity.PreScreener;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.PreScreenerRepository;
import com.htc.par.service.PreScreenerService;
import com.htc.par.to.PreScreenerTO;
import com.htc.par.utilities.NullAwareBeanUtil;

/**@author Shyam Kandi
 * PreScreener Service Implementation  */

@Service
public class PreScreenerServiceImpl implements PreScreenerService {

	@Autowired
	private PreScreenerRepository preScreenerRepository;

	@Override
	public PreScreenerTO getPreScreenerTO(PreScreener preScreener) {
		PreScreenerTO preScreenerTO = new PreScreenerTO(preScreener.getPreScreenerId(), preScreener.getPreScreenerName(), preScreener.getPreScreenerPhoneNumber(), preScreener.getPreScreenerActive());
		return preScreenerTO;
	}

	@Override
	public PreScreener getPreScreener(PreScreenerTO preScreenerTO) {
		PreScreener preScreener = new PreScreener(preScreenerTO.getPreScreenerId(), preScreenerTO.getPreScreenerName(), preScreenerTO.getPreScreenerPhoneNumber(), preScreenerTO.getPreScreenerActive());
		return preScreener;
	}

	/**
	 * Get active PreScreener by Id
	 * 
	 * @param preScreenerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@Override
	public PreScreenerTO getPreScreenerById(int preScreenerId) throws ResourceNotFoundException {
		Optional<PreScreener> preScreenerOptional = preScreenerRepository.findByPreScreenerIdAndPreScreenerActive(preScreenerId, true);
		PreScreenerTO preScreenerTO = null;
		if (!preScreenerOptional.isPresent())
			throw new ResourceNotFoundException(String.format("PreScreener Id: %s not found.", preScreenerId));
		preScreenerTO = getPreScreenerTO(preScreenerOptional.get());
		return preScreenerTO;
	}

	/**
	 * Get active PreScreeners
	 * 
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@Override
	public List<PreScreenerTO> getAllPreScreeners() throws ResourceNotFoundException {
		List<PreScreener> preScreenerEntities = preScreenerRepository.findAllByPreScreenerActive(true);
		if (CollectionUtils.isEmpty(preScreenerEntities))
			throw new ResourceNotFoundException("No PreScreeners Found.");
		List<PreScreenerTO> preScreenerList = preScreenerEntities.stream().map(preScreener -> {
			return getPreScreenerTO(preScreener);
		}).collect(Collectors.toList());
		return preScreenerList;
	}

	/**
	 * Update active preScreener
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotUpdatedException
	 */
	@Override
	public PreScreenerTO updatePreScreener(PreScreenerTO preScreenerTO) throws ResourceNotFoundException, ResourceNotUpdatedException {
		PreScreenerTO updatedPreScreenerTO = null;
		
		try {
			Optional<PreScreener> preScreenerOptional = preScreenerRepository.findByPreScreenerIdAndPreScreenerActive(preScreenerTO.getPreScreenerId(), true);
			
			boolean isPreScreenerPresent = preScreenerOptional.isPresent();
			
			PreScreener preScreenerToUpdate = (isPreScreenerPresent) ? preScreenerOptional.get() : null;
			
			System.out.println("input data" +preScreenerOptional.get());
			
			if (!preScreenerOptional.isPresent())
				throw new ResourceNotFoundException(String.format("PreScreener: %s Not Found.", preScreenerTO.getPreScreenerName()));
			else {
				if (preScreenerTO.getPreScreenerPhoneNumber().equals(preScreenerToUpdate.getPreScreenerPhoneNumber())) {
					
					NullAwareBeanUtil.copyProperties(preScreenerTO, preScreenerToUpdate);
					updatedPreScreenerTO = getPreScreenerTO(preScreenerRepository.save(preScreenerToUpdate));
				}
				else {
					preScreenerOptional = preScreenerRepository.findByPreScreenerPhoneNumber(preScreenerTO.getPreScreenerPhoneNumber());
					
					isPreScreenerPresent = preScreenerOptional.isPresent();
					
					PreScreener anotherpreScreener = (isPreScreenerPresent) ? preScreenerOptional.get() : null; 
					if (isPreScreenerPresent && anotherpreScreener.getPreScreenerActive()) {
						throw new ResourceDuplicateException(String.format(
								"PreScreener with same mobile number: %s already exist.", preScreenerTO.getPreScreenerPhoneNumber()));
					} else if (isPreScreenerPresent && (!anotherpreScreener.getPreScreenerActive()))
					{
						anotherpreScreener.setPreScreenerName(preScreenerTO.getPreScreenerName());
						anotherpreScreener.setPreScreenerActive(true);	
						updatedPreScreenerTO = getPreScreenerTO(preScreenerRepository.save(anotherpreScreener));
						
						preScreenerOptional = preScreenerRepository.findById(preScreenerTO.getPreScreenerId());
						
						preScreenerOptional.get().setPreScreenerActive(false);
						preScreenerRepository.save(preScreenerOptional.get());
						
					}
				}
			}
			
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("PreScreener: %s Not Found.", preScreenerTO.getPreScreenerName()));
		}
		return updatedPreScreenerTO;
	}

	/**
	 * create new preScreener
	 * 
	 * @return
	 * @throws ResourceDuplicateException, ResourceNotCreatedException
	 */
	@Override
	public PreScreenerTO createPreScreener(PreScreenerTO preScreenerTO) throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<PreScreener> preScreenerOptional = preScreenerRepository.findByPreScreenerPhoneNumber(preScreenerTO.getPreScreenerPhoneNumber());
			PreScreener preScreener = null;
			
			boolean isPreScreenerPresent = preScreenerOptional.isPresent();
			
			preScreener = (isPreScreenerPresent) ? preScreenerOptional.get() : null;
			
			if (isPreScreenerPresent && preScreener.getPreScreenerActive()) {
				throw new ResourceDuplicateException(String.format(
						"PreScreener with same mobile number: %s already exist.", preScreenerTO.getPreScreenerPhoneNumber()));
			} else if (isPreScreenerPresent && (!preScreener.getPreScreenerActive())) {
				preScreenerTO.setPreScreenerActive(true);;
				NullAwareBeanUtil.copyProperties(preScreenerTO, preScreener);
			} else if (! isPreScreenerPresent) {	
				
				preScreenerTO.setPreScreenerActive(true);
				preScreener = getPreScreener(preScreenerTO);
			} else {
				preScreener = preScreenerOptional.get();
				preScreener.setPreScreenerActive(true);
				preScreenerTO.setPreScreenerActive(true);
			}
			preScreener = preScreenerRepository.save(preScreener);
			preScreenerTO = getPreScreenerTO(preScreener);
		} catch (DataIntegrityViolationException die) {
			throw new ResourceDuplicateException(String.format("PreScreener: %s Already Exist.", preScreenerTO.getPreScreenerName()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("PreScreener: %s not created.", preScreenerTO.getPreScreenerName()));
		}
		return preScreenerTO;
	}

	/**
	 * De-activate preScreener
	 * 
	 * @return
	 * @throws ResourceNotFoundException, ResourceNotDeletedException
	 */
	@Override
	public boolean deletePreScreener(int preScreenerId) throws ResourceNotFoundException, ResourceNotDeletedException {
		try {
			Optional<PreScreener> preScreenerOptional = preScreenerRepository.findByPreScreenerIdAndPreScreenerActive(preScreenerId, true);
			if (!preScreenerOptional.isPresent())
				throw new ResourceNotFoundException("PreScreener not found.");
			PreScreener preScreener = preScreenerOptional.get();
			preScreener.setPreScreenerActive(false);
			preScreenerRepository.save(preScreener);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("PreScreener not deleted.");
		}
		return true;
	}
}
