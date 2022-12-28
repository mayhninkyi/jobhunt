package com.gr8.jobhunt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.service.CategoryService;
import com.gr8.jobhunt.service.JobPostService;

@RestController
@RequestMapping("/api")

public class JobPostController {

	@Autowired
	JobPostService jobService;

	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/job")
	public List<Job> getAllJobs() {
		return jobService.getAll();
	}

	@GetMapping("/job/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable int id) {
		Job job = jobService.get(id);
		if (job == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(job);
	}

	@PostMapping(path = "/job/create")
	public ResponseEntity<?> createJob(@RequestBody Job job) {
		Job createdJob= jobService.create(job);
		if(createdJob==null) {
			return ResponseEntity.badRequest().body("Error created job!");
		}
		return ResponseEntity.ok().body(createdJob);
	}

	@PutMapping(path = "/job/update/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable int id, @Valid @RequestBody Job job) {
		Job updatedJob = jobService.update(id, job);
		if (updatedJob == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(updatedJob);
	}

	@DeleteMapping(value = "/job/delete/{id}")
	public ResponseEntity<?> deleteJob(@PathVariable int id) {
		Job job = jobService.get(id);
		if (job == null) {
			return ResponseEntity.notFound().build();
		}

		// Delete job
		boolean isDeleted = jobService.delete(id);
		if (!isDeleted) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		return ResponseEntity.ok().body("deleted successfully!");
	}

	@GetMapping("/job/category/{id}")
	public ResponseEntity<List<Job>> getJobsByCategory(@PathVariable int id) {
		Category category = categoryService.get(id);
		if (category == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		List<Job> jobList = jobService.getAllByCategory(category);
		return ResponseEntity.ok(jobList);
	}

	@GetMapping("/job/title/{title}")
	public ResponseEntity<List<Job>> findJobByTitle(@PathVariable("title") String title) {
		List<Job> jobList = jobService.getByTitle(title);
		if (jobList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(jobList);
	}
}