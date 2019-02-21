package com.htc.par.service;

import java.util.List;

import com.htc.par.entity.AppUser;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.UserTO;

public interface UserService {
public UserTO getUserById(int userId) throws ResourceNotFoundException;
	
	public List<UserTO> getAllSkills() throws ResourceNotFoundException;
	
	public UserTO updateSkill(UserTO UserTO) throws ResourceNotUpdatedException;
	
	public UserTO createSkill(UserTO UserTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteSkill(int skillId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public UserTO getSkillTO(AppUser user);
	
	public AppUser getSkill(UserTO userTO);
}
