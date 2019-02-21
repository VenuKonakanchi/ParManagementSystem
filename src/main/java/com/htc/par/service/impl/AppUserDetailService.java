package com.htc.par.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.htc.par.entity.AppUser;
import com.htc.par.repository.AppUserRepository;

@Service
public class AppUserDetailService implements UserDetailsService{

	@Autowired
	AppUserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser appUser = userRepository.findByUserNameAndUserActive(username, true);
		

		if(appUser == null)
			throw new UsernameNotFoundException("Username not found");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new  SimpleGrantedAuthority("ROLE_"+appUser.getRole().getRoleName()));
			
		return new User(appUser.getUserName(), appUser.getPassword(), appUser.isUserActive(), true, true, true, authorities);
	}

}
