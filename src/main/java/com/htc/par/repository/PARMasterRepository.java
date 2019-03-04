package com.htc.par.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.PARMaster;

/**
 * Repository for PAR Role Entity
 *
 */

@Repository
public interface PARMasterRepository extends JpaRepository<PARMaster, Integer> {
	

}
