/**
 * 
 */
package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.PreScreener;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.PreScreenerTO;

/**@author Shyam Kandi
 * Service class for PreScreener Repository
 *
 */

@Service
public interface PreScreenerService{
	
	
	public PreScreenerTO getPreScreenerById(int preScreenerId) throws ResourceNotFoundException;
	
	public List<PreScreenerTO> getAllPreScreeners() throws ResourceNotFoundException;
	
	public PreScreenerTO updatePreScreener(PreScreenerTO preScreenerTO) throws ResourceNotUpdatedException;
	
	public PreScreenerTO createPreScreener(PreScreenerTO preScreenerTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deletePreScreener(int preScreenerId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public PreScreenerTO getPreScreenerTO(PreScreener preScreener);
	
	public PreScreener getPreScreener(PreScreenerTO preScreenerTO);
}
