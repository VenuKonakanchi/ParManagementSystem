package com.htc.par.service.impl;

import java.util.List;

import com.htc.par.entity.ExternalStaff;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.ExternalStaffService;
import com.htc.par.to.ExternalStaffTO;

public class ExternalStaffServiceImpl implements ExternalStaffService {
  
	
	@Override
	public ExternalStaffTO getExternalStaffById(int externalStaffId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExternalStaffTO> getAllExternalStaff() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExternalStaffTO updateExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceNotUpdatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExternalStaffTO createExternalStaff(ExternalStaffTO externalStaffTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteExternalStaff(int externalStaffId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExternalStaffTO getExternalStaffTO(ExternalStaff externalStaff) {
		// TODO Auto-generated method stub
		
		return new ExternalStaffTO(externalStaff.getExtStaffId(),
								   externalStaff.getExtStaffName(),
								   externalStaff.getArea(),
								   externalStaff.IsExtStaffActive());
	}

	@Override
	public ExternalStaff getExternalStaff(ExternalStaffTO externalStaffTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExternalStaffServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
