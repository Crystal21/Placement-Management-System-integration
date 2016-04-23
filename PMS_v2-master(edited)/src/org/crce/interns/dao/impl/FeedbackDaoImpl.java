package org.crce.interns.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.crce.interns.dao.FeedbackDao;
import org.crce.interns.model.*;

@Repository("feedbackDao")
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Feedback> listFeedback() {
		List<Feedback> list = sessionFactory.getCurrentSession().createCriteria(Feedback.class).list();
		
		System.out.println("inside dao size of list = " + list.size());
		
		return list;
	}

	public void addFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().saveOrUpdate(feedback);
	}

}
