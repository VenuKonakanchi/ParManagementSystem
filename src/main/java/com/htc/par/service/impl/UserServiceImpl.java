package com.htc.par.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.htc.par.entity.AppUser;
import com.htc.par.entity.AppUserRole;
import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.repository.AppUserRepository;
import com.htc.par.repository.RoleRepository;
import com.htc.par.service.UserService;
import com.htc.par.to.RoleTO;
import com.htc.par.to.UserTO;
import com.htc.par.utilities.NullAwareBeanUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	AppUserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserTO getUserById(int userId) throws ResourceNotFoundException {
		Optional<AppUser> appUSer = userRepository.findByUserIdAndUserActive(userId, true);
		UserTO userTO = null;
		if (!appUSer.isPresent())
			throw new ResourceNotFoundException(String.format("User Id: %s not found.", userId));
		userTO = getUserTO(appUSer.get());
		return userTO;
	}


	@Override
	public List<UserTO> getAllUsers() throws ResourceNotFoundException {
		List<AppUser>  userEntities = userRepository.findAllByUserActive(true);
		
		if (CollectionUtils.isEmpty(userEntities))
			throw new ResourceNotFoundException("No Users Found.");
		List<UserTO> userList = userEntities.stream().map(user -> {
			return getUserTO(user);
		}).collect(Collectors.toList());
		return userList;
	}


	@Override
	public UserTO updateUser(UserTO userTO) throws ResourceNotUpdatedException {
		UserTO updatedUserTO = null;
		
		try {
			Optional<AppUser> appUserOptional  = userRepository.findByUserName(userTO.getUserName());
			
			if (!appUserOptional.isPresent())
				throw new ResourceNotFoundException(String.format("User: %s Not Found.", userTO.getUserName()));
			AppUser appUser = appUserOptional.get();
			appUser.setPassword(passwordEncoder.encode(userTO.getPassword()));
			NullAwareBeanUtil.copyProperties(userTO, appUser);
			
			if(userTO.getRole().getRoleId()!=null) {
				Optional<AppUserRole> roleFromDB=	roleRepository.findById(userTO.getRole().getRoleId());
				if(roleFromDB.isPresent()) {
					appUser.setRole(roleFromDB.get());
				}
			}else if(userTO.getRole().getRoleName()!=null) {
				Optional<AppUserRole> roleFromDB=		roleRepository.findByRoleName(userTO.getRole().getRoleName());
				if(roleFromDB.isPresent()) {
					appUser.setRole(roleFromDB.get());
				}		
			}
			
			
			updatedUserTO = getUserTO(userRepository.save(appUser));
		} catch (DataAccessException dae) {
			throw new ResourceNotUpdatedException(String.format("User: %s Not Found.", userTO.getUserName()));
		}
		return updatedUserTO;
	}


	@Override
	public UserTO createUser(UserTO userTO) throws ResourceDuplicateException, ResourceNotCreatedException {
		try {
			Optional<AppUser> appUserOptional = userRepository.findByUserName(userTO.getUserName());
			AppUser appUSer = null;
			if (!appUserOptional.isPresent()) {
				userTO.setUserActive(true);
				appUSer = getUser(userTO);
			} else {
				appUSer = appUserOptional.get();
				appUSer.setUserActive(true);
				userTO.setUserActive(true);
			}
			if(userTO.getRole().getRoleId()!=null) {
				Optional<AppUserRole> roleFromDB=	roleRepository.findById(userTO.getRole().getRoleId());
				if(roleFromDB.isPresent()) {
					appUSer.setRole(roleFromDB.get());
				}
			}else if(userTO.getRole().getRoleName()!=null) {
				Optional<AppUserRole> roleFromDB=		roleRepository.findByRoleName(userTO.getRole().getRoleName());
				if(roleFromDB.isPresent()) {
					appUSer.setRole(roleFromDB.get());
				}		
			}
			appUSer = userRepository.save(appUSer);
			userTO = getUserTO(appUSer);
		} catch (DataIntegrityViolationException die) {
			throw new ResourceDuplicateException(String.format("USer with  UserName: %s Already Exist.", userTO.getUserName()));
		} catch (DataAccessException dae) {
			throw new ResourceNotCreatedException(String.format("USer with  UserName: %s not created.", userTO.getUserName()));
		}
		return userTO;
	}


	@Override
	public boolean deleteUser(int userId) throws ResourceNotFoundException, ResourceNotDeletedException {
		try {
			Optional<AppUser> appUserOptional = userRepository.findByUserIdAndUserActive(userId, true);
			if (!appUserOptional.isPresent())
				throw new ResourceNotFoundException(String.format("User Id: %s not found or inactive", userId));
			AppUser appUser = appUserOptional.get();
			appUser.setUserActive(false);
			userRepository.save(appUser);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException(String.format("User with User Id: %s not deleted ", userId));
		}
		return true;
	}
	
	


	@Override
	public UserTO getUserTO(AppUser user) {
		RoleTO roleTO= new RoleTO(user.getRole().getRoleId(),user.getRole().getRoleName());
		UserTO userTO = new UserTO(user.getUserId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhone(),user.getUserName(),user.getPassword(),roleTO,user.getUserActive());
		return userTO;
	}

	@Override
	public AppUser getUser(UserTO userTO) {
		AppUserRole role= new AppUserRole();
		role.setRoleId(userTO.getRole().getRoleId());
		role.setRoleName(userTO.getRole().getRoleName());
		AppUser user = new AppUser(userTO.getFirstName(),userTO.getLastName(),userTO.getEmail(),userTO.getPhone(),userTO.getUserName(),passwordEncoder.encode(userTO.getPassword()),role,userTO.getUserActive());
		return user;
	}


	@Override
	public UserTO getUserByUSerName(String userName) throws ResourceNotFoundException {
		Optional<AppUser>  appUserOptional = userRepository.findByUserNameAndUserActive(userName, true);
		if (!appUserOptional.isPresent())
			throw new ResourceNotFoundException(String.format("User: %s Not Found or Inactive.", userName));
		return getUserTO(appUserOptional.get());
	}


	@Override
	public UserTO getUserByEmail(String email) throws ResourceNotFoundException {
		Optional<AppUser>  appUserOptional = userRepository.findByEmailAndUserActive(email, true);
		if (!appUserOptional.isPresent())
			throw new ResourceNotFoundException(String.format("User: %s Not Found or Inactive.", email));
		return getUserTO(appUserOptional.get());
	}


	@Override
	public List<RoleTO> getAllRoles() {
	List<AppUserRole>  roleEntities = roleRepository.findAll();	
		if (CollectionUtils.isEmpty(roleEntities))
			throw new ResourceNotFoundException("No Roles Found.");
		List<RoleTO> roleList = roleEntities.stream().map(role -> {
			return new RoleTO(role.getRoleId(),role.getRoleName());
		}).collect(Collectors.toList());
		return roleList;
	}
	
	

}
