package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.ExternalStaff;
import com.htc.par.entity.Skill;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.ExternalStaffTO;
import com.htc.par.to.SkillTO;

@Service
public interface ExternalStaffService {
	
	public ExternalStaffTO getExternalStaffById(int externalStaffId) throws ResourceNotFoundException;
	
	public List<ExternalStaffTO> getAllExternalStaff() throws ResourceNotFoundException;
	
	public ExternalStaffTO updateExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceNotUpdatedException;
	
	public ExternalStaffTO createExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteExternalStaff(int externalStaffId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public ExternalStaffTO getExternalStaffTO(ExternalStaff externalStaff);
	
	public ExternalStaff getExternalStaff(ExternalStaffTO externalStaffTO);

}
