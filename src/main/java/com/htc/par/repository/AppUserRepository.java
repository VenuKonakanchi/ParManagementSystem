package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.AppUser;



@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	public Optional<AppUser> findByUserIdAndUserActive(int userId,boolean active);
	
	public Optional<AppUser>  findByUserNameAndUserActive(String username,boolean active);
	
	public Optional<AppUser>  findByPhoneAndUserActive(String phone,boolean active);
	
	public Optional<AppUser>  findByEmailAndUserActive(String email,boolean active);
	
	public List<AppUser>  findAllByUserActive(boolean active);
	
	public Optional<AppUser>  findByUserName(String username);
}
