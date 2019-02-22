package com.htc.par.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.htc.par.entity.Area;
@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
	public Optional<Area> findByAreaIdAndAreaActive(@Param("areaId") Integer areaId,@Param("areaActive") boolean areaActive);
	public Optional<Area> findByAreaName(@Param("areaName") String areaName);
	public List<Area> findAllByAreaActive(@Param("areaActive") boolean areaActive);
}
