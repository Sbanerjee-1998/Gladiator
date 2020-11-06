package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.StatusDto;
import com.lti.dto.StatusDto.StatusType;
import com.lti.entity.Applicant;
import com.lti.exception.ApplicantException;
import com.lti.service.ApplicantService;

@RestController
@CrossOrigin
public class ApplicantController {
	@Autowired
	private ApplicantService applicantService;
	@PostMapping(path = "/register")
	public StatusDto register(@RequestBody Applicant applicant) {
		try {
			applicantService.register(applicant);
			
			StatusDto status = new StatusDto();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		}
		catch(ApplicantException e) {
			StatusDto status = new StatusDto();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	/*@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			 customer = customerService.login(loginDto.getEmail(), loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful!");
			loginStatus.setCustomerId(customer.getId());
			loginStatus.setName(customer.getName());
			return loginStatus;
		}
		catch(CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}*/
	
}
