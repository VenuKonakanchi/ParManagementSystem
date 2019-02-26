package com.htc.par.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.Area;
import com.htc.par.entity.Area;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.AreaRepository;
import com.htc.par.service.AreaService;
import com.htc.par.to.AreaTO;
import com.htc.par.to.AreaTO;
import com.htc.par.utilities.NullAwareBeanUtil;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	AreaRepository arearepository;
	static List<Area> areas = new ArrayList<Area>();
	@Override
	public Area getArea(AreaTO areaTo) {
		Area area = new Area(areaTo.getAreaId(),  areaTo.getAreaName(), areaTo.getAreaActive());
		return area;
	}
	@Override
	public AreaTO getAreaTO (Area area) {
		
		AreaTO areaTo = new AreaTO (area.getAreaId(), area.getAreaName(), area.getAreaActive());	
		return areaTo;
	}
	/*
	 * Request handler to CREATE new Area
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 * @ResourceDuplicateException
	 */
	@Override
	public AreaTO createArea(AreaTO areaTo) throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<Area> areaOptional = arearepository.findByAreaName(areaTo.getAreaName());
			Area area = null;
			if (!areaOptional.isPresent()) {
				areaTo.setAreaActive(true);
				area = getArea(areaTo);
			} else {
				area = areaOptional.get();
				area.setAreaActive(true);
				areaTo.setAreaActive(true);
			}
			area = arearepository.save(area);
			areaTo = getAreaTO(area);
		} catch (DataIntegrityViolationException dae) {
			throw new ResourceDuplicateException(String.format("Area: %s Already Exist.", areaTo.getAreaName()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("Area: %s not created.", areaTo.getAreaName()));
		}
		return areaTo;
	}
	/*
	 * Request handler to GET AREA by given Id
	 * @Param AreaId
	 * 
	 * @ResourseNotFoundException
	 */
	@Override
	public AreaTO getAreaById(int areaId) throws ResourceNotFoundException {
		Optional<Area> areaOptional = arearepository.findByAreaIdAndAreaActive(areaId, true);
		AreaTO areaTo = null;
		if (!areaOptional.isPresent())
			throw new ResourceNotFoundException(String.format("Area Id: %s not found.", areaId));
		areaTo = getAreaTO(areaOptional.get());
		return areaTo;
	}
	/*
	 * Request handler to GET all Areas
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 */
 

		@Override
		public List<AreaTO> getAllAreas() throws ResourceNotFoundException {
			List<Area> areaEntities = arearepository.findAllByAreaActive(true);
			if (CollectionUtils.isEmpty(areaEntities))
				throw new ResourceNotFoundException("No Areas Found.");
			List<AreaTO> areaList = areaEntities.stream().map(area -> {
				return getAreaTO(area);
			}).collect(Collectors.toList());
			return areaList;
		}


	/*
	 * Request handler to Update Areas
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 * @ResourceNotUpdatedException 
	 */
	@Override
	  public AreaTO updateArea(AreaTO areaTo) throws ResourceNotFoundException, ResourceNotUpdatedException {
		AreaTO updatedAreaTo = null;
		try {
			Optional<Area> areaOptional = arearepository.findByAreaIdAndAreaActive(areaTo.getAreaId(), true);
 
			Area area = areaOptional.get();
			NullAwareBeanUtil.copyProperties(areaTo, area);
			updatedAreaTo = getAreaTO(arearepository.save(area));
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("Area: %s Not Found.", areaTo.getAreaName()));
		}
		return updatedAreaTo;
	}
	/*
	 * Request handler to DELETE Area by AreaId
	 * @Param AreaId
	 * 
	 * @ResourseNotFoundException
	 * @ResourceNotDeletedException
	 */
	@Override
		public boolean deleteArea(int areaId) throws ResourceNotFoundException, ResourceNotDeletedException {
			try {
				Optional<Area> areaOptional = arearepository.findByAreaIdAndAreaActive(areaId, true);

				Area area = areaOptional.get();
				area.setAreaActive(false);
				arearepository.save(area);
			} catch (DataAccessException dae) {
				throw new ResourceNotDeletedException("Area not deleted.");
			}
			return true;
		}
 
}
