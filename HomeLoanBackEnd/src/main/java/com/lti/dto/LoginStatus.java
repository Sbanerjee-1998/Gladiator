package com.lti.dto;

public class LoginStatus extends Status {
	private int applicantId;
	private String name;
	public int getCustomerId() {
		return applicantId;
	}
	public void setCustomerId(int customerId) {
		this.applicantId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
