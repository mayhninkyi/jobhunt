package com.gr8.jobhunt.service;

import java.util.List;

import com.gr8.jobhunt.entity.Job;
import com.gr8.jobhunt.entity.Category;

public interface JobPostService {

	public List<Job> getAll();

	public Job get(int id);

	public Job create(Job job);

	public Job update(int id, Job job);

	public boolean delete(int id);

	public List<Job> getAllByCategory(Category category);

	public Job getByTitle(String title);

}
