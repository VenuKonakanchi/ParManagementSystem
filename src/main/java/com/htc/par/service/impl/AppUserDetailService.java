package com.htc.par.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import com.htc.par.service.UserService;
import com.htc.par.to.RoleTO;
import com.htc.par.to.UserTO;
import com.htc.par.utilities.NullAwareBeanUtil;

@Service
public class AppUserDetailService implements UserDetailsService,UserService{

	@Autowired
	AppUserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<AppUser>  optionalAppUser = userRepository.findByUserNameAndUserActive(username, true);
		
		AppUser appUser=null;
		if(!optionalAppUser.isPresent())
			throw new UsernameNotFoundException("Username not found");
		else
			appUser=optionalAppUser.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new  SimpleGrantedAuthority("ROLE_"+appUser.getRole().getRoleName()));
			
		return new User(appUser.getUserName(), appUser.getPassword(), appUser.getUserActive(), true, true, true, authorities);
	}


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
			Optional<AppUser> appUserOptional = userRepository.findByUserIdAndUserActive(userTO.getUserId(), true);
			if (!appUserOptional.isPresent())
				throw new ResourceNotFoundException(String.format("User: %s Not Found.", userTO.getUserName()));
			AppUser appUser = appUserOptional.get();
			NullAwareBeanUtil.copyProperties(userTO, appUser);
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
				throw new ResourceNotFoundException("User not found.");
			AppUser appUser = appUserOptional.get();
			appUser.setUserActive(false);
			userRepository.save(appUser);
		} catch (DataAccessException dae) {
			throw new ResourceNotDeletedException("User not deleted.");
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
		AppUser user = new AppUser(userTO.getUserId(),userTO.getFirstName(),userTO.getLastName(),userTO.getEmail(),userTO.getPhone(),userTO.getUserName(),userTO.getPassword(),role,userTO.isUserActive());
		return user;
	}


	@Override
	public UserTO getUserByUSerName(String userName) throws ResourceNotFoundException {
		Optional<AppUser>  appUserOptional = userRepository.findByUserNameAndUserActive(userName, true);
		if (!appUserOptional.isPresent())
			throw new ResourceNotFoundException("User not found.");
		return getUserTO(appUserOptional.get());
	}


	@Override
	public UserTO getUserByEmail(String email) throws ResourceNotFoundException {
		Optional<AppUser>  appUserOptional = userRepository.findByEmailAndUserActive(email, true);
		if (!appUserOptional.isPresent())
			throw new ResourceNotFoundException("User not found.");
		return getUserTO(appUserOptional.get());
	}

}
