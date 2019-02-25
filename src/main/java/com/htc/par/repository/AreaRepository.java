package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.htc.par.entity.Area;


public interface AreaRepository extends JpaRepository<Area, Integer> {


public Optional<Area> findByAreaName(@Param("areaName") String areaName);



}
