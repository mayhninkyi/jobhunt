package com.gr8.jobhunt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.entity.Job;

@EnableJpaRepositories
public interface JobPostRepo extends JpaRepository<Job, Integer> {

	public List<Job> findByCategory(Category category);

	public Job findByTitle(String title);

}
