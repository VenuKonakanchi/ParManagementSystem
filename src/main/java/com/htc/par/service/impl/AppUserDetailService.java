package com.htc.par.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
public class AppUserDetailService implements UserDetailsService{

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

}
