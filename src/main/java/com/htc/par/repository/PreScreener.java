package com.htc.par.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreScreener extends JpaRepository<PreScreener, Integer> {

	//List<PreScreener> findByPreScreenerId(int PreScreenerId);
	
	

}