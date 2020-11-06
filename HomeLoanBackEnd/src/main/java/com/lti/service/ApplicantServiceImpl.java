package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Applicant;
import com.lti.exception.ApplicantServiceException;
import com.lti.repository.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	ApplicantRepository applicantRepository;
	@Autowired
	EmailService emailService;

	@Override
	public void register(Applicant applicant) {
		// TODO Auto-generated method stub
		if(!applicantRepository.isApplicantPresent(applicant.getEmail())) {
            int id=applicantRepository.register(applicant);
            String text="Successfully registered. Your id is "+id;
            String subject="Registration Confirmation";
            emailService.sendEmailForNewRegistration(applicant.getEmail(), text, subject);
            }
            else
                throw new ApplicantServiceException("Customer already registered!");
	}

	@Override
	public Applicant get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Applicant applicant) {
		// TODO Auto-generated method stub

	}

	@Override
	public Applicant login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			if(!applicantRepository.isApplicantPresent(email))
				throw new ApplicantServiceException("Incorrect email OR Customer not registered!");
			int id = applicantRepository.findByEmailAndPassword(email, password);
			Applicant applicant = applicantRepository.findbyId(id);
			return applicant;
		}
		catch(EmptyResultDataAccessException e) {
			throw new ApplicantServiceException("Incorrect password");
		}
	}

}
