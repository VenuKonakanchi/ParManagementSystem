package com.htc.par.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.PARMaster;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.PARMasterTO;
 

/**
 * PAR Master Service
 *
 */
@Service
public interface PARMasterService {

	
	public PARMasterTO getParMasterById(Integer parId) throws ResourceNotFoundException;
	
	public List<PARMasterTO> getAllParMaster() throws ResourceNotFoundException;
	
	public PARMasterTO updateParMaster(PARMasterTO parMasterTO) throws ResourceDuplicateException, ResourceNotUpdatedException;
	
	public PARMasterTO createParMaster(PARMasterTO parMasterTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteParMaster(Integer parId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public PARMasterTO getParMasterTO(PARMaster parMaster);
	
	public PARMaster getParMaster(PARMasterTO parMasterTO);
	
	public List<PARMasterTO> getAllParMasters() throws ResourceNotFoundException;
	
	public PARMasterTO getParMasterByParNumber(String parNumber) throws ResourceNotFoundException;
	
	public List<PARMasterTO> getAllActiveOrReceivedPar() throws ResourceNotFoundException;
	
	public List<PARMasterTO> getAllParByStatus() throws ResourceNotFoundException;
	
	public PARMasterTO intentToFill(Integer parId, LocalDate intentToFillDate, Boolean intentToFillIndicator) throws ResourceNotFoundException, ResourceNotUpdatedException;
	
	public boolean sendEmailToRecruiters(Integer parId);
	
	public List<PARMasterTO> getAllParsByStatusAndDateRange(String parStatus,LocalDate startDate,LocalDate endDate) throws ResourceNotFoundException;
	
	public List<PARMasterTO> getAllParsByDateRange(LocalDate startDate,LocalDate endDate) throws ResourceNotFoundException;
	
	
}
