package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
 

@Service
public interface ParMasterService {

	
	public ParMasterTO getParMasterById(int parId) throws ResourceNotFoundException;
	
	public List<ParMasterTO> getAllParMaster() throws ResourceNotFoundException;
	
	public ParMasterTO updateParMaster(ParMasterTO parMasterTO) throws ResourceNotUpdatedException;
	
	public ParMasterTO createParMaster(ParMasterTO parMasterTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteParMaster(int parId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public ParMasterTO getParMasterTO(ParMaster parMaster);
	
	public ParMaster getParMaster(ParMasterTO parMasterTO);
}
