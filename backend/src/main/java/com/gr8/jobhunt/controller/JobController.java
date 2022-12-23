package com.gr8.jobhunt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.service.CategoryService;
import com.gr8.jobhunt.service.JobService;

@RestController
public class JobController {

	@Autowired
	JobService jobService;

	@Autowired
	CategoryService categoryServie;

	@GetMapping(path = "/api/job")
	public List<Job> getAllJobs() {
		return jobService.getAll();
	}

	@GetMapping("/api/job/category/{category_id}")
	public ResponseEntity<?> getJobsByCategory(
			@PathVariable("category_id") int categoryID
	) {
		Category category = categoryServie.get(categoryID);
		if (category == null) {
			return ResponseEntity.badRequest().body("Category ID is invalid");
		}
		List<Job> jobList = jobService.getAllByCategory(category);
		return ResponseEntity.ok().body(jobList);
	}

	@GetMapping("/api/job/{job_id}")
	public ResponseEntity<Job> getJob(
			@PathVariable("job_id") int jobID
	) {
		Job job = jobService.get(jobID);
		if (job == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(job);
	}

	

}
