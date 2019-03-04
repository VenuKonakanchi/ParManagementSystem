/**
 * 
 */
package com.htc.par.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.PARMaster;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.PARMasterService;
import com.htc.par.to.PARMasterTO;

/**
 * Service Implementation for PAR Master service
 *
 */

@Service
public class PARMasterServiceImpl implements PARMasterService {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PARMasterTO getParMaster(PARMasterTO parMasterTO) {
		// TODO Auto-generated method stub
		return null;
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
	public PARMasterTO intentToFill(Integer parId, LocalDate intentToFillDate) throws ResourceNotFoundException, ResourceNotUpdatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sendEmailToRecruiters(Integer parId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PARMasterTO> getAllParsByStatusAndDateRange(String parStatus, LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PARMasterTO> getAllParsByDateRange(LocalDate startDate, LocalDate endDate)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
