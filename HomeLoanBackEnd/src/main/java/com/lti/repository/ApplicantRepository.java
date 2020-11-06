package com.lti.repository;

import java.util.List;

import com.lti.entity.Applicant;

public interface ApplicantRepository {
	int register(Applicant applicant);
    Applicant findbyId(int id);
    List<Applicant> findAll();
    boolean isApplicantPresent(String email);
    int findByEmailAndPassword(String email, String password);
}
