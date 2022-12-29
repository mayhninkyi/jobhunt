package com.gr8.jobhunt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.gr8.jobhunt.entity.ApplyJob;
import com.gr8.jobhunt.entity.User;

@EnableJpaRepositories
public interface ApplyJobRepo extends JpaRepository<ApplyJob, Integer>{
	public List<ApplyJob> findByUser(User user);
}
