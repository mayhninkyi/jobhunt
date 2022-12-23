package com.gr8.jobhunt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.repo.JobRepo;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepo jobRepo;

//	@Override
//	public Job create(Job job) {
//		job.setCreatedAt(LocalDateTime.now());
//		return jobRepo.save(job);
//	}

	@Override
	public Job get(int id) {
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public List<Job> getAll() {
		return jobRepo.findAll();
	}

//	@Override
//	public Job update(int id, Job job) {
//		Job toUpdateJob = this.get(id);
//		if (toUpdateJob == null) {
//			return null;
//		}
////		toUpdateJob.setTitle(job.getTitle());
////		toUpdateJob.setDescription(job.getDescription());
////		toUpdateJob.setRequirement(job.getRequirement());
////        toUpdateJob.setNoOfEmployee(job.getNoOfEmployee());
////        toUpdateJob.setSalary(job.getSalary());
////		toUpdateJob.setCategory(job.getCategory());
////		toUpdateJob.setCompany(job.getCompany());
////        toUpdateJob.setIsCloseJob(job.getCompany());
////		toUpdateJob.setUpdatedAt(LocalDateTime.now());
//		toUpdateJob.setTitle("");
//		toUpdateJob.setDescription(job.getDescription());
//		toUpdateJob.setRequirement(job.getRequirement());
//        toUpdateJob.setNoOfEmployee(job.getNoOfEmployee());
//        toUpdateJob.setSalary(job.getSalary());
//		toUpdateJob.setCategory(job.getCategory());
//		toUpdateJob.setCompany(job.getCompany());
//        toUpdateJob.setIsCloseJob(job.getCompany());
//		toUpdateJob.setUpdatedAt(LocalDateTime.now());
//		jobRepo.save(toUpdateJob);
//		return toUpdateJob;
//	}

	@Override
	public boolean delete(int id) {
		Job job = this.get(id);
		if (job == null) {
			return false;
		}
		jobRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Job> getAllByCategory(Category category) {
		return jobRepo.findByCategory(category);
	}

	@Override
	public Job getByTitle(String title) {
		return jobRepo.findByTitle(title);
	}

}
