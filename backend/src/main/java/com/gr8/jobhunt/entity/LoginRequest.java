package com.gr8.jobhunt.entity;
import javax.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank(message = "Required")
	private String gmail;

	@NotBlank(message = "Required")
	private String password;

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

}
