package com.htc.par.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.AppRole;
import com.htc.par.entity.Area;
import com.htc.par.to.AreaTo;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
	
	List<Area> findByareaId(int areaId);
	List<Area> findByareaName(String areaName);
	

	
}
