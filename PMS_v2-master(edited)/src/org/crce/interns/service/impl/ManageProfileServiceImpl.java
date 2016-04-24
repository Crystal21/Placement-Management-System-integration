package org.crce.interns.service.impl;


import java.util.List;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.dao.ManageProfileDao;
//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;
//import org.crce.interns.model.Profile;
import org.crce.interns.service.ManageProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("manageProfileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManageProfileServiceImpl implements ManageProfileService{
	
	@Autowired
	private ManageProfileDao manageProfileDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(JobBean jobBean) {
		// TODO Auto-generated method stub
		Job job = new Job();
		BeanUtils.copyProperties(jobBean, job);
		manageProfileDao.createProfile(job);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CriteriaBean criteriaBean) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		BeanUtils.copyProperties(criteriaBean, criteria);
		manageProfileDao.createProfile(criteria);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Job> listProfile() {
		// TODO Auto-generated method stub
		return manageProfileDao.listProfile();
	}

	//@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CompanyBean companyBean) {
		// TODO Auto-generated method stub
		Company company = new Company();
		BeanUtils.copyProperties(companyBean, company);
		manageProfileDao.createProfile(company);
	}

	/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(TryBean tryBean) {
		// TODO Auto-generated method stub
		
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		BeanUtils.copyProperties(profileBean, profile);
		//profile.setRole_id("1");

		manageProfileDao.createProfile(profile);
	}
	*/
}
