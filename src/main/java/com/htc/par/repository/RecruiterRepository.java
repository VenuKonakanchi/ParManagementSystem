package com.htc.par.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.Recruiter;
import com.htc.par.to.RecruiterTO;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {

	public Optional<Recruiter> findByRecruiterIdAndRecruiterActive(@Param("recruiterId") Integer recruiterId,@Param("recruiterActive") boolean recruiterActive);

	public Optional<Recruiter> findByRecruiterName(@Param("recruiterName") String recruiterName);
	
	public List<Recruiter> findAllByRecruiterActive(@Param("recruiterActive") boolean recruiterActivef);
	
	public List<Recruiter> findAllByRecruiterEmailFlag(@Param("recruiterEmailFlag") boolean recruiterEmailFlag);

}
