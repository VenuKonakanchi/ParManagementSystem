package com.htc.par.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.PARMaster;

/**
 * Repository for PAR Role Entity
 *
 */

@Repository
public interface PARMasterRepository extends JpaRepository<PARMaster, Integer> {

	List<PARMaster> findAllByParStatusAndParReceivedDateBetween(String parStatus, LocalDate startDate,	LocalDate endDate);

	List<PARMaster> findAllByParReceivedDateBetween(LocalDate startDate, LocalDate endDate); 

}
