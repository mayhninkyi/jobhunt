package com.gr8.jobhunt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}


	@Override
	public boolean delete(int id) {
		Category category = this.get(id);
		if (category == null) {
			return false;
		}
		categoryRepo.deleteById(id);
		return true;
	}

	@Override
	public Category update(int id,Category category) {
		// TODO Auto-generated method stub
		Category toUpdate=this.get(id);
		if(toUpdate==null) {
			return null;
		}
		return categoryRepo.save(category);
	}

	

}
