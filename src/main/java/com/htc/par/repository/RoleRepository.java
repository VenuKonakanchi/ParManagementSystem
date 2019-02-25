package com.htc.par.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.AppUserRole;

@Repository
public interface RoleRepository extends JpaRepository<AppUserRole, Integer>{
	
	Optional<AppUserRole>  findByRoleName(String roleName);
	
	
}
