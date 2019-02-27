package com.htc.par.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.service.AreaService;
import com.htc.par.to.AreaTO;
 
 
/*
 * @ Author - Allen
 * Controller to handle Capability Area information 
 * 
 */
@RestController
@RequestMapping("/par")
public class AreaController {
	@Autowired
	private AreaService areaservice;
	
	@GetMapping(value="/area")
	public String area() {
		return "areaAndProductForm";
	}

	/*
	 * Request handler to GET all Areas
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 */
	@GetMapping("/Areas")
	public ResponseEntity<List<AreaTO>> getAreas() throws ResourceNotFoundException {
		return ResponseEntity.ok(areaservice.getAllAreas());
	}
	/*
	 * Request handler to GET AREA by given Id
	 * @Param AreaId
	 * 
	 * @ResourseNotFoundException
	 */
	@GetMapping("/Areas/{areaId}")
	public ResponseEntity<AreaTO> getAreaById(@PathVariable("areaId") int areaId) throws ResourceNotFoundException {
		return ResponseEntity.ok(areaservice.getAreaById(areaId));
	}
	/*
	 * Request handler to CREATE new Area
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 * @ResourceDuplicateException
	 */
	@PostMapping("/Areas")
	public ResponseEntity<AreaTO> createArea(@RequestBody @Valid AreaTO areaTo)
			throws ResourceNotCreatedException, ResourceDuplicateException {
		return ResponseEntity.created(null).body(areaservice.createArea(areaTo));
	}
	/*
	 * Request handler to Update Areas
	 * @Param AreaTo
	 * 
	 * @ResourseNotFoundException
	 * @ResourceNotUpdatedException 
	 */
	@PutMapping("/Areas")
	public ResponseEntity<AreaTO> updateArea(@RequestBody AreaTO areaTO)
			throws ResourceNotFoundException, ResourceNotUpdatedException {
		return ResponseEntity.ok(areaservice.updateArea(areaTO));
	}
	/*
	 * Request handler to DELETE Area by AreaId
	 * @Param AreaId
	 * 
	 * @ResourseNotFoundException
	 * @ResourceNotDeletedException
	 */
	@DeleteMapping("/Areas/{areaId}")
	public ResponseEntity<Boolean> deleteArea(@PathVariable("areaId") int areaId)
			throws ResourceNotFoundException, ResourceNotDeletedException {
		return ResponseEntity.ok(areaservice.deleteArea(areaId));
	}
}
