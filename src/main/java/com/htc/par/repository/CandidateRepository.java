package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	
	public Optional<Candidate> findByCandidateIdAndCandidateActive(@Param("candId") Integer candId,
															   @Param("candActive") boolean candActive);
	
	public Optional<Candidate> findByCandidateNameAndCandidateActive(@Param("candName") String candName,
			   @Param("candActive") boolean candActive);

	public Optional<Candidate> findByCandidateName(@Param("candName") String candName);
	
	public List<Candidate> findAllByCandidateActive(@Param("candActive") boolean candActive);
	
	public Optional<Candidate> findByCandidatePhoneNumber(@Param("candidatePhoneNumber") String candidatePhoneNumber);
	public Optional<Candidate> findByCandidateEmail(@Param("candidateEmail") String candidateEmail);
	
	@Query("select count(c) from Candidate c where  c.candidateActive = :candActive and c.recruiter.recruiterId = :recruiterId")
	public long countActiveCandidatesForRecruiter(@Param("candActive") boolean candActive,@Param("recruiterId") Integer recruiterId);
}
