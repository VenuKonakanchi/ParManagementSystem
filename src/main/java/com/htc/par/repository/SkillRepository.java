/**
 * 
 */
package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.Skill;

/**
 * Repository for Skill Entity
 *
 */

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
	
	public Optional<Skill> findBySkillIdAndIsSkillActive(@Param("skillId") Integer skillId,@Param("isSkillActive") boolean isSkillActive);

	public List<Skill> findAllByIsSkillActive(@Param("isSkillActive") boolean isSkillActive);
}
