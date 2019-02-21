/**
 * 
 */
package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.entity.Skill;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.SkillTO;

/**
 * Service class for Skill Repository
 *
 */

@Service
public interface SkillService{
	
	
	public SkillTO getSkillById(int skillId) throws ResourceNotFoundException;
	
	public List<SkillTO> getAllSkills() throws ResourceNotFoundException;
	
	public SkillTO updateSkill(SkillTO skillTO) throws ResourceNotUpdatedException;
	
	public SkillTO createSkill(SkillTO skillTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteSkill(int skillId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public SkillTO getSkillTO(Skill skill);
	
	public Skill getSkill(SkillTO skillTO);
}
