package com.htc.par.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.par.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {

}
