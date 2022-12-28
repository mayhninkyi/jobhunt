package com.gr8.jobhunt.service;

import java.util.List;

import com.gr8.jobhunt.entity.ApplyJob;

public interface ApplyJobService {
	public ApplyJob create(ApplyJob applyJob);
	
	public List<ApplyJob> getAll();
}
