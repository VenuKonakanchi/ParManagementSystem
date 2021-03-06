package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Area;
import com.htc.par.entity.ExternalStaff;
import com.htc.par.entity.Skill;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.AreaRepository;
import com.htc.par.repository.ExternalStaffRepository;
import com.htc.par.repository.SkillRepository;
import com.htc.par.service.ExternalStaffService;
import com.htc.par.to.AreaTO;
import com.htc.par.to.ExternalStaffTO;
import com.htc.par.to.SkillTO;
import com.htc.par.utilities.NullAwareBeanUtil;

import javassist.expr.NewArray;

@Service
public class ExternalStaffServiceImpl implements ExternalStaffService {
  
	@Autowired
	private ExternalStaffRepository externalStaffRepository;
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	
	@Override
	public ExternalStaffTO getExternalStaffById(int externalStaffId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<ExternalStaff> extStaffOptional = externalStaffRepository.findByExtStaffIdAndExtStaffActive(externalStaffId, true);
		ExternalStaffTO externalStaffTO = null;
		if (!extStaffOptional.isPresent())
			throw new ResourceNotFoundException(String.format("External Staff Id : %s not found.", externalStaffId));
		externalStaffTO = getExternalStaffTO(extStaffOptional.get());
		return externalStaffTO;
	   }

	@Override
	public List<ExternalStaffTO> getAllExternalStaff() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<ExternalStaff> externalStaffs = externalStaffRepository.findAllByExtStaffActive(true);
		if (CollectionUtils.isEmpty(externalStaffs))
			throw new ResourceNotFoundException("No External Staff Found.");
		List<ExternalStaffTO> externalStaffTOs = externalStaffs.stream().map(ExternalStaff -> {
																						return getExternalStaffTO(ExternalStaff);
																					  }).collect(Collectors.toList());
		return externalStaffTOs;
	
	}

	@Override
	public ExternalStaffTO updateExternalStaff(ExternalStaffTO externalStaffTO) throws ResourceNotUpdatedException {
		ExternalStaffTO updatedExternalStaffTO = null;
		try {

			/*
			 * Optional<ExternalStaff> extStaffOptional =
			 * externalStaffRepository.findByExtStaffIdAndExtStaffActive(externalStaffTO.
			 * getExtStaffId(),true);
			 * 
			 * if (!extStaffOptional.isPresent()) throw new
			 * ResourceNotFoundException(String.format("External Staff: %s Not Found.",
			 * externalStaffTO.getExtStaffName())); ExternalStaff externalStaff =
			 * extStaffOptional.get(); NullAwareBeanUtil.copyProperties(externalStaffTO,
			 * externalStaff);
			 */
			
			List<ExternalStaff> externalStaffs = externalStaffRepository.findAllByExtStaffNameAndExtStaffActive(externalStaffTO.getExtStaffName(),true);
			ExternalStaff externalStaff = new ExternalStaff();
			
			if (externalStaffs.isEmpty()) { } 
			else {
				    for (ExternalStaff e : externalStaffs) {
				    	if ((e.getArea().getAreaId().equals(externalStaffTO.getArea().getAreaId())) ) {
				    		throw new ResourceDuplicateException(String.format("External Staff: %s Already Exist on %s .", externalStaffTO.getExtStaffName(),
				    											areaServiceImpl.getAreaById(externalStaffTO.getArea().getAreaId()).getAreaName() ));
				    		} /* if */
				    	} /* for loop */
				} /* else part */
			
				NullAwareBeanUtil.copyProperties(externalStaffTO,externalStaff);
			
			    if(externalStaffTO.getArea().getAreaId()!=null){
					
					Optional<Area> areaOptional = areaRepository.findById(externalStaffTO.getArea().getAreaId()) ;
					if(areaOptional.isPresent())
						externalStaff.setArea(areaOptional.get()) ;
				   					
				} else if (!externalStaffTO.getArea().getAreaName().isEmpty()) {
						
					Optional<Area> areaOptional = areaRepository.findByAreaName(externalStaffTO.getArea().getAreaName()) ;
					if(areaOptional.isPresent())
						externalStaff.setArea(areaOptional.get()) ;
				}
			    externalStaff.setExtStaffActive(true);
			    updatedExternalStaffTO = getExternalStaffTO(externalStaffRepository.save(externalStaff));
			  
			    
			} catch (DataIntegrityViolationException daeintexp) {
				
				Optional<ExternalStaff>	existingextStaffOptional = externalStaffRepository.findByExtStaffNameAndExtStaffActive(externalStaffTO.getExtStaffName(),true);
				if (existingextStaffOptional.isPresent()) {
					throw new ResourceDuplicateException(String.format("External Staff: %s Already Exist.", externalStaffTO.getExtStaffName()));
				}else {
					throw new ResourceDuplicateException(String.format("External Staff: %s has already been in-activated. Please add it as new External Staff.",externalStaffTO.getExtStaffName()));
				}
			} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("External Staff : %s Not Found.", externalStaffTO.getExtStaffName()));
		}
		return updatedExternalStaffTO;
    }

	@Override
	public ExternalStaffTO createExternalStaff(ExternalStaffTO externalStaffTO)
			throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
				List<ExternalStaff> externalStaffs = externalStaffRepository.findAllByExtStaffName(externalStaffTO.getExtStaffName());
				ExternalStaff externalStaff = null;
				boolean deletedExtStaffFound = false ;
				if (externalStaffs.isEmpty()) { } 
				else {
					    for (ExternalStaff e : externalStaffs) {
					    	if ((e.getArea().getAreaId().equals(externalStaffTO.getArea().getAreaId())) && (e.getExtStaffActive())) {
					    		throw new ResourceDuplicateException(String.format("External Staff: %s Already Exist.", externalStaffTO.getExtStaffName()));
					    		} /* if */
					    	else if( (e.getArea().getAreaId().equals(externalStaffTO.getArea().getAreaId())) && (!e.getExtStaffActive())){
					    			externalStaffTO = getExternalStaffTO(e);
					    			deletedExtStaffFound = true;
					    		} /*else if*/   
					    	} /* for loop */
					} /* else part */
				externalStaffTO.setExtStaffActive(true) ;
				externalStaffTO.getArea().setAreaActive(true);
				externalStaff = getExternalStaff(externalStaffTO);
				if(deletedExtStaffFound) {externalStaff.setExtStaffId(externalStaffTO.getExtStaffId()); }
				if(externalStaffTO.getArea().getAreaId()!=null){
					Optional<Area> areaOptional = areaRepository.findById(externalStaff.getArea().getAreaId()) ;
					if(areaOptional.isPresent()){ 
						externalStaff.setArea(areaOptional.get()) ;
					}/*if*/
				 } else if (!externalStaffTO.getArea().getAreaName().isEmpty()) {
					
					Optional<Area> areaOptional = areaRepository.findByAreaName(externalStaff.getArea().getAreaName()) ;
					if(areaOptional.isPresent()){ 
						externalStaff.setArea(areaOptional.get()) ;
				      } /*if */
				    } /*else if */
				externalStaff = externalStaffRepository.save(externalStaff);
				externalStaffTO = getExternalStaffTO(externalStaff);

		} catch (DataIntegrityViolationException die) {
			throw new ResourceDuplicateException(
					String.format("External Staff: %s Already Exist.", externalStaffTO.getExtStaffName()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(
					String.format("External Staff: %s not created.", externalStaffTO.getExtStaffName()));
		}
		return externalStaffTO;
	}

	@Override
	public boolean deleteExternalStaff(int externalStaffId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		// TODO Auto-generated method stub
		try {
			Optional<ExternalStaff> extStaffOptional = externalStaffRepository.findByExtStaffIdAndExtStaffActive(externalStaffId, true);
			if (!extStaffOptional.isPresent())
				throw new ResourceNotFoundException("External Staff is not found.");
			ExternalStaff externalStaff = extStaffOptional.get();
			externalStaff.setExtStaffActive(false);
			
			externalStaffRepository.save(externalStaff);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("External Staff is not deleted.");
		}
		return true;
	
	}

	@Override
	public ExternalStaffTO getExternalStaffTO(ExternalStaff externalStaff) {
		// TODO Auto-generated method stub
		
		return new ExternalStaffTO(externalStaff.getExtStaffId(),
								   externalStaff.getExtStaffName(),
								   getAreaTO(externalStaff.getArea()),
								   externalStaff.getExtStaffActive());
	}

	@Override
	public ExternalStaff getExternalStaff(ExternalStaffTO externalStaffTO) {
		// TODO Auto-generated method stub
		return new ExternalStaff(externalStaffTO.getExtStaffName(),
				   				 getArea(externalStaffTO.getArea()),
				   				 externalStaffTO.getExtStaffActive());
	}


	public AreaTO getAreaTO(Area area) {
		// TODO Auto-generated method stub
		
		return new AreaTO(area.getAreaId(),area.getAreaName(),area.getAreaActive());
	}

	 
	public Area getArea(AreaTO areaTO) {
		// TODO Auto-generated method stub
		return new Area(areaTO.getAreaId(),areaTO.getAreaName(),areaTO.getAreaActive());
	}
	public ExternalStaffServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
