package com.gr8.jobhunt.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gr8.jobhunt.entity.ApplyJob;
import com.gr8.jobhunt.repo.ApplyJobRepo;
import com.gr8.jobhunt.service.ApplyJobService;

public class ApplyJobServiceImpl implements ApplyJobService{
	
	@Autowired
	ApplyJobRepo applyJobRepo;

	@Override
	public ApplyJob create(ApplyJob applyJob) {	
		return applyJobRepo.save(applyJob);
	}

	@Override
	public List<ApplyJob> getAll() {
		return applyJobRepo.findAll();
	}

}
