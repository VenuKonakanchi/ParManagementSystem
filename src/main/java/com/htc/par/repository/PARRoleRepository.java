package com.htc.par.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.PARRole;

@Repository
public interface PARRoleRepository extends JpaRepository<PARRole, Integer> {

}
