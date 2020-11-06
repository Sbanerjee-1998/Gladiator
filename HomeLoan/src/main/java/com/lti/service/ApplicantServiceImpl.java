package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Applicant;
import com.lti.exception.ApplicantException;
import com.lti.repository.ApplicantRepository;
@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantRepository applicantRepo;
	@Autowired
	private EmailService emailService;
	@Override
	public void register(Applicant applicant) {
		 if(!applicantRepo.isApplicantPresent(applicant.getEmail())) {
		        int id=applicantRepo.register(applicant);
		        String text="Successfully registered. Your id is "+id;
		        String subject="Registration Confirmation";
		        emailService.sendEmailForNewRegistration(applicant.getEmail(), text, subject);
		        }
		        else
		            throw new ApplicantException("Customer already registered!");
		    }

	@Override
	public Applicant get(int id) {
		return applicantRepo.findbyId(id);
	}

	@Override
	public void update(Applicant applicant) {
		 applicantRepo.register(applicant);
	}

	@Override
	public Applicant login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
