package com.htc.par.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.AppUser;



@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByUserNameAndUserActive(String username,boolean active);
	
	public AppUser findByPhoneAndUserActive(String phone,boolean active);
	
	public AppUser findByEmailAndUserActive(String email,boolean active);
}
