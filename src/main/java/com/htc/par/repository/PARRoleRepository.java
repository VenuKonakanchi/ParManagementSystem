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
	
	public Optional<PARRole> findByRoleIdAndIsRoleActive(@Param("roleId") Integer skillId,@Param("isRoleActive") boolean isSkillActive);

	public List<PARRole> findAllByIsRoleActive(@Param("isRoleActive") boolean isRoleActive);

}
