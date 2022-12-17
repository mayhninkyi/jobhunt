package com.gr8.jobhunt.service;

import java.util.List;

import com.gr8.jobhunt.entity.User;

public interface UserService {
  public List<User> getAllUser();
  
  public User get(int id);
  
  public User create(User user);
  
  public User update(int id,User user);
  
  public boolean delete(int id);
  
  public User userLogin(String gmail,String password);
  
  public User updateStatus(int id,String status);
  
  public List<String> getAllStatus();
  
  public void updatePassword(int id,String newPassword);
}
