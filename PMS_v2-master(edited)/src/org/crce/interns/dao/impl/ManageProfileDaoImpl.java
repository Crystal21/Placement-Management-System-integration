package org.crce.interns.dao.impl;


//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;

import java.util.List;

import org.crce.interns.beans.JobBean;
import org.crce.interns.dao.ManageProfileDao;
//import org.crce.interns.model.Profile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("manageProfileDao")

public class ManageProfileDaoImpl implements ManageProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	public void createProfile(Profile profile) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().saveOrUpdate(profile);	
	}
	*/
	
	public void createProfile(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(job);	
	}

	public void createProfile(Criteria criteria) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(criteria);	
	}

	@SuppressWarnings("unchecked")
	public List<Job> listProfile() {
		// TODO Auto-generated method stub
		return (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
		//return (List<Allotment>) sessionFactory.openSession().createCriteria(Allotment.class).list();
	}

	//@Override
	public void createProfile(Company company) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(company);			
	}
	
}
