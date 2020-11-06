package com.lti.service;

import com.lti.entity.Applicant;

public interface ApplicantService {
	void register(Applicant applicant);
    Applicant get(int id);
    void update(Applicant applicant);
    Applicant login(String email, String password);
}
