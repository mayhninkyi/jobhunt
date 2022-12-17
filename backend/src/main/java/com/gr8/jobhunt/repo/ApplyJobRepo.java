package com.gr8.jobhunt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gr8.jobhunt.entity.ApplyJob;

@EnableJpaRepositories
public interface ApplyJobRepo extends JpaRepository<ApplyJob, Integer>{
   
}
