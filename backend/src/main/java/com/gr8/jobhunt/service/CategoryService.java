package com.gr8.jobhunt.service;

import java.util.List;

import com.gr8.jobhunt.entity.Category;

public interface CategoryService {
  public List<Category> getAll();
  
  public Category get(int id);
  
  public Category create(Category category);
  
  public Category update(int id,Category category);
  
  public boolean delete(int id);
}
