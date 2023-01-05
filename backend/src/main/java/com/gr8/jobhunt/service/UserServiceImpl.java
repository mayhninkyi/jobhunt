package com.gr8.jobhunt.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gr8.jobhunt.entity.User;
import com.gr8.jobhunt.entity.UserRole;
import com.gr8.jobhunt.entity.UserStatus;
import com.gr8.jobhunt.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired 
	PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User get(int id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User create(User user) {
		User existUser= userRepo.findByGmail(user.getGmail());
		if(existUser!=null) {
			return null;
		}
		user.setAddress("");
		user.setAbout("");
		user.setPhone("");
		user.setProfilePath("");
		user.setStatus(UserStatus.active);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedAt(LocalDateTime.now());
		return userRepo.save(user);
	}

	@Override
	public User update(int id, User user) {
		User toUpdateUser = this.get(id);
		if (toUpdateUser == null) {
			return null;
		}
		user.setUpdatedAt(LocalDateTime.now());
		return userRepo.save(user);
	}

	@Override
	public boolean delete(int id) {
		User user = this.get(id);
		if (user == null) {
			return false;
		}
		userRepo.deleteById(id);
		return true;
	}

	@Override
	public User userLogin(String gmail, String password) {
		User user = userRepo.findByGmail(gmail);
		if (user == null) {
			return null;
		}
		
		if (!passwordEncoder.matches(password, user.getPassword())) {
			return null;
		}
		return user;
	}

	@Override
	public User updateStatus(int id, String status) {
		User toUpdateUser = this.get(id);
		if (toUpdateUser == null) {
			return null;
		}
		try {
			toUpdateUser.setStatus(UserStatus.valueOf(status));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
		toUpdateUser.setUpdatedAt(LocalDateTime.now());
		userRepo.save(toUpdateUser);
		return toUpdateUser;
	}

	@Override
	public List<String> getAllStatus() {
		List<String> userStatusList=new ArrayList<>();
		for(UserStatus status:Arrays.asList(UserStatus.values())) {
			userStatusList.add(status.toString());
		}
		return userStatusList;
	}

	@Override
	public void updatePassword(int id, String newPassword) {
		User toUpdateUserPwd = get(id);
		if (toUpdateUserPwd != null) {
			toUpdateUserPwd.setPassword(passwordEncoder.encode(newPassword));
			userRepo.save(toUpdateUserPwd);
			System.out.println("pwd updated");
		}

	}

	@Override
	public List<String> getAllRole() {
		List<String> userRoleList=new ArrayList<>();
		for(UserRole role:Arrays.asList(UserRole.values())) {
			userRoleList.add(role.toString());
		}
		return userRoleList;
	}

}
