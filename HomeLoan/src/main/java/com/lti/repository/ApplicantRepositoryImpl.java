package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.lti.entity.Applicant;

@Repository
public class ApplicantRepositoryImpl implements ApplicantRepository{
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public int register(Applicant applicant) {
		Applicant a =em.merge(applicant);
		return a.getId();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Applicant> findAll() {
		return em.createNamedQuery("fetch-all").getResultList();
	}

	@Override
	public Applicant findbyId(int id) {
		return em.find(Applicant.class, id);
	}

	@Override
	public boolean isApplicantPresent(String email) {
		return (Long)
                em
                .createQuery("select count(a.id) from Applicant a where a.email = :em")
                .setParameter("em", email)
                .getSingleResult() == 1 ? true : false;
	}
	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (Integer) em
                .createQuery("select a.id from Applicant a where a.email = :em and a.password = :pw")
                .setParameter("em", email)
                .setParameter("pw", password)
                .getSingleResult();
	}
}
