package com.gr8.jobhunt.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr8.jobhunt.entity.ApplyJob;
import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.entity.User;
import com.gr8.jobhunt.repo.ApplyJobRepo;

@Service
public class ApplyJobServiceImpl implements ApplyJobService{
	
	@Autowired
	ApplyJobRepo repo;

	@Override
	public ApplyJob create(ApplyJob applyJob) {
		applyJob.setCreatedAt(LocalDateTime.now());
		return repo.save(applyJob);
	}


	@Override
	public List<ApplyJob> getByUser(User user) {
		return repo.findByUser(user);
	}


	@Override
	public List<ApplyJob> getByJob(Job job) {
		return repo.findByJob(job);
	}

}
