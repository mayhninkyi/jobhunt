package com.gr8.jobhunt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gr8.jobhunt.entity.Category;
import com.gr8.jobhunt.service.CategoryService;
import com.gr8.jobhunt.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/userStatus")
	public List<String> getAllStatus(){
		return userService.getAllStatus();
	}
	
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return categoryService.getAll();
	}
	
	@PostMapping("/category/create")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		Category newCategory=categoryService.create(category);
		if(newCategory==null) {
			return ResponseEntity.badRequest().body("Category already exists");
		}
		return ResponseEntity.ok().body(category);
	}
	
	@DeleteMapping("/category/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") int id){
		boolean isDelete=categoryService.delete(id);
		if(isDelete==false) {
			return ResponseEntity.badRequest().body("Category cannot be deleted");
			
		}
		return ResponseEntity.ok().body("deleted successfully!");
	}
	
	@PutMapping("/category/update")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		Category updatedCategory= categoryService.update(category.getId(),category);
		if(updatedCategory==null) {
			return ResponseEntity.badRequest().body("Category cannot be updated");
		}
		return ResponseEntity.ok(updatedCategory);
	}
	
	
  
}
