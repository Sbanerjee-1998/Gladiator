package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.dto.LoginStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Applicant;
import com.lti.exception.ApplicantServiceException;
import com.lti.service.ApplicantService;

@RestController
@CrossOrigin
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @PostMapping(path = "/register")
    public Status register(@RequestBody Applicant applicant) {
        try {
            applicantService.register(applicant);

            Status status = new Status();
            status.setStatus(StatusType.SUCCESS);
            status.setMessage("Registration successful!");
            return status;
        }
        catch(ApplicantServiceException e) {
            Status status = new Status();
            status.setStatus(StatusType.FAILURE);
            status.setMessage(e.getMessage());
            return status;
        }
    }
    @PostMapping("/login")
    public LoginStatus login(@RequestBody LoginDto loginDto) {
    		try {
    			Applicant applicant = applicantService.login(loginDto.getEmail(), loginDto.getPassword());
    			LoginStatus loginStatus = new LoginStatus();
    			loginStatus.setStatus(StatusType.SUCCESS);
    			loginStatus.setMessage("Login Successful!");
    			loginStatus.setCustomerId(applicant.getId());
    			loginStatus.setName(applicant.getFname());
    			return loginStatus;
    		}
    		catch(ApplicantServiceException e) {
    			LoginStatus loginStatus = new LoginStatus();
    			loginStatus.setStatus(StatusType.FAILURE);
    			loginStatus.setMessage(e.getMessage());
    			return loginStatus;
    		}
    	}


}