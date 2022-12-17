package com.gr8.jobhunt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gr8.jobhunt.entity.User;
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByGmail(String gmail);

	public User findByName(String name);
}