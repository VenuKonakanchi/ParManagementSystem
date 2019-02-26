package com.htc.par.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.htc.par.entity.Area;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.AreaTO;
@Service
public interface AreaService {
	public AreaTO getAreaById(int areaId) throws ResourceNotFoundException;
	public List<AreaTO> getAllAreas() throws ResourceNotFoundException;
	public List<AreaTO> getAllAreas(int areaId) throws ResourceNotFoundException;
	public AreaTO updateArea(AreaTO areaTo) throws ResourceNotUpdatedException;
	public AreaTO createArea(AreaTO areaTo) throws ResourceDuplicateException, ResourceNotCreatedException;
	public boolean deleteArea(int areaId) throws ResourceNotFoundException, ResourceNotDeletedException;
	public AreaTO getAreaTo(Area area);
	public Area getArea(AreaTO areaTo);
}
