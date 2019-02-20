package com.htc.par.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.AppRole;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Integer>{
	
	List<AppRole> findByRole(String role);
	
	
}
