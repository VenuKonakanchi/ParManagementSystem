/**
 * 
 */
package com.htc.par.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.PARMaster;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.PARMasterRepository;
import com.htc.par.service.PARMasterService;
import com.htc.par.to.PARMasterTO;

/**
 * Service Implementation for PAR Master service
 *
 */

@Service
public class PARMasterServiceImpl implements PARMasterService {
	
	@Autowired
	PARMasterRepository parMasterRepository;
	

	@Override
	public PARMasterTO getParMasterById(Integer parId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllParMaster() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO updateParMaster(PARMasterTO parMasterTO)
			throws ResourceDuplicateException, ResourceNotUpdatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO createParMaster(PARMasterTO parMasterTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteParMaster(Integer parId) throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PARMasterTO getParMasterTO(PARMaster parMaster) {
		
		return new PARMasterTO(parMaster.getParId(), parMaster.getParNumber(), parMaster.getParDescriptionText(), parMaster.getParReceivedDate(),
			parMaster.getParStatus(), parMaster.getIntentToFillIndicator(),parMaster.getIntentToFillDate(), parMaster.getEmailSent(), parMaster.getParComment());
	}

	@Override
	public PARMaster getParMaster(PARMasterTO parMasterTO) {
		
		return new PARMaster(parMasterTO.getParId(),parMasterTO.getParNumber(), parMasterTO.getParDescriptionText(), parMasterTO.getParReceivedDate(),
				parMasterTO.getParStatus(), parMasterTO.getIntentToFillIndicator(), parMasterTO.getEmailSent(), parMasterTO.getParComment(),
				parMasterTO.getIntentToFillDate());
	}

	@Override
	public List<PARMasterTO> getAllParMasters() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO getParMasterByParNumber(String parNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllActiveOrReceivedPar() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllParByStatus() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO intentToFill(Integer parId, LocalDate intentToFillDate, Boolean intentToFillIndicator) throws ResourceNotFoundException, ResourceNotUpdatedException {
		
		PARMasterTO parMasterTO = null;
		try
		{
		Optional<PARMaster> parMasterOptional = parMasterRepository.findById(parId);
		if(!parMasterOptional.isPresent())
			throw new ResourceNotFoundException(String.format("PAR ID : %s not found!", parId));
		
		PARMaster parMaster = parMasterOptional.get();
		
		parMaster.setIntentToFillDate(intentToFillDate);
		parMaster.setIntentToFillIndicator(intentToFillIndicator);
		
		parMaster = parMasterRepository.save(parMaster);
		
		parMasterTO = getParMasterTO(parMaster);
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException("PAR Intent to fill  is not Updated!");
		}
		
		return parMasterTO;
	}

	@Override
	public boolean sendEmailToRecruiters(Integer parId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PARMasterTO> getAllParsByStatusAndDateRange(String parStatus, LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		List<PARMaster> parMasters = parMasterRepository.findAllByParStatusAndParReceivedDateBetween(parStatus,startDate,endDate);
		
		if (CollectionUtils.isEmpty(parMasters))
			throw new ResourceNotFoundException(String.format("No PARs found between given dates %s and %s whith status %s", startDate,endDate, parStatus));
		List<PARMasterTO> parMasterTOs = parMasters.stream().map(PARMaster -> {
			return getParMasterTO(PARMaster);
		}).collect(Collectors.toList());
		return parMasterTOs;

	}

	@Override
	public List<PARMasterTO> getAllParsByDateRange(LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		List<PARMaster> parMasters = parMasterRepository.findAllByParReceivedDateBetween(startDate,endDate);
		
		if (CollectionUtils.isEmpty(parMasters))
			throw new ResourceNotFoundException(String.format("No PARs received between given dates %s and %s", startDate,endDate));
		List<PARMasterTO> parMasterTOs = parMasters.stream().map(PARMaster -> {
			return getParMasterTO(PARMaster);
		}).collect(Collectors.toList());
		return parMasterTOs;
	}

}
