package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.PARRole;

/**
 * Repository for PAR Role Entity
 *
 */

@Repository
public interface PARRoleRepository extends JpaRepository<PARRole, Integer> {
	
	public Optional<PARRole> findByRoleIdAndRoleActive(@Param("roleId") Integer skillId,@Param("roleActive") boolean roleActive);

	public List<PARRole> findAllByRoleActive(@Param("roleActive") boolean roleActive);
	
	public Optional<PARRole> findByRoleName(@Param("roleName") String roleName);

}
