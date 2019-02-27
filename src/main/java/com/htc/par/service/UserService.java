package com.htc.par.service;

import java.util.List;

import com.htc.par.entity.AppUser;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.RoleTO;
import com.htc.par.to.UserTO;

public interface UserService {
	
	public UserTO getUserById(int userId) throws ResourceNotFoundException;
	
	public List<UserTO> getAllUsers() throws ResourceNotFoundException;
	
	public UserTO updateUser(UserTO userTO) throws ResourceNotUpdatedException;
	
	public UserTO createUser(UserTO userTO) throws ResourceDuplicateException, ResourceNotCreatedException;

	public boolean deleteUser(int userId) throws ResourceNotFoundException, ResourceNotDeletedException;
	
	public UserTO getUserByUSerName(String userName) throws ResourceNotFoundException;
	
	public UserTO getUserByEmail(String email) throws ResourceNotFoundException;
	
	public UserTO getUserTO(AppUser user);
	
	public AppUser getUser(UserTO userTO);
	
	public List<RoleTO>  getAllRoles();
}
