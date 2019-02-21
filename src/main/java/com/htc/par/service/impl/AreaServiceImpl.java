package com.htc.par.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.htc.par.entity.AppUser;
import com.htc.par.entity.Area;
import com.htc.par.repository.AreaRepository;
import com.htc.par.to.AreaTo;
 
 
 
 

@Service
public class AreaServiceImpl {
	
	
	@Autowired
	AreaRepository arearepository;
	
	static List<Area> areas = new ArrayList<Area>();
	
	
	
	public Area getArea(AreaTo areaTo) {
		
		Area area = new Area(areaTo.getAreaId(),  areaTo.getAreaName(), areaTo.getAreaActive());
		return area;
	}
	
	
	public AreaTo getAreaTo (Area area) {
		
		AreaTo areaTo = new AreaTo (area.getAreaId(), area.getAreaName(), area.getAreaActive());	
		return areaTo;
		
	}
	
	
	// CRUD get
	
	
 
	
	public AreaTo getArea(Integer areaid) {
		
		System.out.println("Inside area service get area");
		
		Optional<Area> ar= arearepository.findById(areaid);
		if(ar.isPresent()) {
			Area area = ar.get();
			AreaTo areaTo = getAreaTo(area);
			return areaTo;
		}
		else{
			return null;
		}
 
	}
	
 	public List<Area> getAreas() {
 		return areas;
 	}
	
	
 	/*
 	
	public List <AreaTo> getAreas() {
		
		List <Area> arealist = arearepository.findAll();
		
		List <AreaTo> arealistTo = arealist.stream()
											.map(area -> {return getAreaTo(area);})
											.collect(Collectors.toList());

		return arealistTo;
	}
	
	*/
	
	// CRUD save
	
	public boolean addArea(AreaTo areaTo) {
		try {
			System.out.println(areaTo);
			arearepository.save(getArea(areaTo));
			return true;
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
	  
	}
	
	
	
	// CRUD update
	
	
	public boolean updateArea(AreaTo areaTo) {	
		try{
			Area area = getArea(areaTo);
			
//			area.getAreaId().setAreaId(areaTo.getAreaId());
 
	// 		product.getAddress().setAddressId(productTO.getAddressId());
			arearepository.save(area);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	
	
	// CRUD delete
	
	

}
