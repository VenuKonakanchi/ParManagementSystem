package com.htc.par.service;

import java.util.List;
import java.util.stream.Collectors;

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

		AppUser appUser = userRepository.findByUsername(username);
		

		if(appUser == null)
			throw new UsernameNotFoundException("Username not found");
		
		List<GrantedAuthority> authorities = appUser.getRoles().stream()
												    .map(role -> {return new SimpleGrantedAuthority("ROLE_"+role.getRole());})
												    .collect(Collectors.toList());
		
		
		return new User(appUser.getUsername(), appUser.getPassword(), appUser.isEnabled(), true, true, true, authorities);
	}

}
