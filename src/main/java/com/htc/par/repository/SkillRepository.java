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
	
	public Optional<Skill> findBySkillIdAndSkillActive(@Param("skillId") Integer skillId,@Param("skillActive") boolean skillActive);

	public Optional<Skill> findBySkillName(@Param("skillName") String skillName);
	
	public List<Skill> findAllBySkillActive(@Param("skillActive") boolean skillActive);
}
