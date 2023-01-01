package com.gr8.jobhunt.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gr8.jobhunt.entity.ChangePassword;
import com.gr8.jobhunt.entity.LoginRequest;
import com.gr8.jobhunt.entity.User;
import com.gr8.jobhunt.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(
			@Valid @RequestBody LoginRequest loginRequest){
		User user=userService.userLogin(loginRequest.getGmail(), loginRequest.getPassword());
		if(user==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user){
		User createdUser=userService.create(user);
		if(createdUser==null) {
			return ResponseEntity.badRequest().body("User with same gmail already exists!");
		}
		return ResponseEntity.ok().body(createdUser);
	}
	
	@GetMapping("/getAllUser")
	public List<User> listUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/profile")
	public ResponseEntity<User> getProfile(@RequestParam int id){
		User user=userService.get(id);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateProfile(@Valid @RequestBody User user ){
		User userExist=userService.get(user.getId());
		if(userExist==null) {
			return ResponseEntity.badRequest().build();
		}
		User updateUser=userService.update(user.getId(), user);
		if(updateUser==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(updateUser);
		
	}
	
	@PostMapping("/changePwd")
	public ResponseEntity<Object> changePassword(
			@Valid @RequestBody ChangePassword changePwd
	) throws IOException {
		User user = userService.get(changePwd.getOri_id());
		
		if (user == null) {
			System.out.println("user not found");
			return new ResponseEntity<Object>(
					new Exception("Something wrong"), HttpStatus.CONFLICT
			);
		}
		if (!changePwd.getCon_new_pwd().equals(changePwd.getNew_pwd())) {
			return new ResponseEntity<Object>(
					new Exception("Confirm Password does not match"),
					HttpStatus.CONFLICT
			);
		}
		if (!passwordEncoder
				.matches(changePwd.getCurrent_pwd(), user.getPassword())) {
			return new ResponseEntity<Object>(
					new Exception("Current Password does not match"),
					HttpStatus.CONFLICT
			);
		}
		userService.updatePassword(user.getId(), changePwd.getNew_pwd());
		return ResponseEntity.ok().body(user);
	}

}
