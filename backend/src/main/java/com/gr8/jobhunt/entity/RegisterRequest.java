package com.gr8.jobhunt.entity;

import javax.validation.constraints.NotBlank;

public class RegisterRequest {
	@NotBlank(message = "Required")
	private String gmail;

	@NotBlank(message = "Required")
	private String password;
	
	@NotBlank(message = "Required")
	private String name;
	
	@NotBlank(message = "Required")
	private String role;

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
}
