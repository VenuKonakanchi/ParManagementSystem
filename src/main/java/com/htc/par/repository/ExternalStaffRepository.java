package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.ExternalStaff;
import com.htc.par.entity.Skill;

@Repository
public interface ExternalStaffRepository extends JpaRepository<ExternalStaff, Integer>{
	
	public Optional<ExternalStaff> findByExtStaffIdAndExtStaffActive(@Param("extStaffId") Integer extStaffId,
															   @Param("extStaffActive") boolean extStaffActive);
	
	public Optional<ExternalStaff> findByExtStaffNameAndExtStaffActive(@Param("extStaffName") String extStaffName,
			   @Param("extStaffActive") boolean extStaffActive);

	public Optional<ExternalStaff> findByExtStaffName(@Param("extStaffName") String extStaffName);
	
	public List<ExternalStaff> findAllByExtStaffActive(@Param("skillActive") boolean skillActive);

}
