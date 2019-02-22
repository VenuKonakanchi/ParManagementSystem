package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.PreScreener;

/**
 * Repository for PreScreener Entity
 *
 */

@Repository
public interface PreScreenerRepository extends JpaRepository<PreScreener, Integer>{
	
	public Optional<PreScreener> findByPreScreenerIdAndPreScreenerActive(@Param("preScreenerId") Integer preScreenerId,@Param("preScreenerActive") boolean preScreenerActive);

	public Optional<PreScreener> findByPreScreenerName(@Param("preScreenerName") String preScreenerName);
	
	public Optional<PreScreener> findByPreScreenerPhoneNumber(@Param("preScreenerPhoneNumber") String preScreenerPhoneNumber);
	
	public List<PreScreener> findAllByPreScreenerActive(@Param("preScreenerActive") boolean preScreenerActive);
}
