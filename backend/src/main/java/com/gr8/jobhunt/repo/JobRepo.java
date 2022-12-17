package com.gr8.jobhunt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.entity.JobPost;

@EnableJpaRepositories
public interface JobRepo extends JpaRepository<JobPost, Integer> {
 public List<JobPost> findByCategory(Category category);
 
 public List<JobPost> findByTitle(String title);
 
 
}
