package org.crce.interns.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.UserDetails;
import org.crce.interns.dao.SearchDao;
import org.crce.interns.service.SearchService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("searchDaoImpl")
@Transactional
public class SearchDaoImpl implements SearchDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public List<UserDetails> searchUser(String searchString) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="from UserDetails as u where u.userName like :s";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("s", "%"+searchString+"%");
		List<UserDetails> userDetailsList = query.list();
		session.close();
		return userDetailsList;
	}

	@Override
	public UserDetails viewProfile(String userName) {
		Session session = sessionFactory.openSession();
		String SQL_QUERY ="from UserDetails as u where u.userName = ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, userName);
		List<UserDetails> userDetailsList = query.list();
		UserDetails userDetails = userDetailsList.get(0);
		session.close();
		return userDetails;
	}

}
