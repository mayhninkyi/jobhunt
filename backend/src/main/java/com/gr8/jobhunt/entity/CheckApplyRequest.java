package com.gr8.jobhunt.entity;

import javax.validation.constraints.NotBlank;

public class CheckApplyRequest {
	@NotBlank(message = "Required")
	private int jobId;

	@NotBlank(message = "Required")
	private int userId;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
