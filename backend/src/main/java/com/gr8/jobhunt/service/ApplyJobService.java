package com.gr8.jobhunt.service;

import java.util.List;

import com.gr8.jobhunt.entity.ApplyJob;
import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.entity.User;

public interface ApplyJobService {
	public ApplyJob create(ApplyJob applyJob);
		
	public List<ApplyJob> getByUser(User user);
	
	public List<ApplyJob> getByJob(Job job);
	
}
