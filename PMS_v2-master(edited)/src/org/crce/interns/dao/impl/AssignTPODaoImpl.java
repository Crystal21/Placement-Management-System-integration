package org.crce.interns.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.dao.AssignTPODao;
import org.crce.interns.model.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AssignTPODaoImpl implements AssignTPODao {

	@Autowired
	private SessionFactory sessionFactory;
	/*@PersistenceContext
	private EntityManager entityManager;*/
	
	@Override
	public void assignTPO(UserDetails user) {
		sessionFactory.getCurrentSession().update(user);
		// entityManager.merge(user);
	}

	@Override
	public List<UserDetails> viewUsers() {
		// TODO Auto-generated method stub
	//return entityManager.createQuery("select u from UserDetails u", UserDetails.class).getResultList();
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from UserDetails as u";

		Query query = session.createQuery(SQL_QUERY);
		List<UserDetails> listUserDetails = query.list();
		return listUserDetails;
	
	}

	public UserDetails getUser(UserDetails checkUser) {
		// TODO Auto-generated method stub
		/*String userName = checkUser.getUsername();
		UserDetails user = (UserDetails) entityManager.createQuery("select u from UserDetails u where u.username = :n")
				.setParameter("n", userName).getSingleResult();
		return user;*/
		
		System.out.println("before get");
		UserDetails result = (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class,
				checkUser.getUserName());
		System.out.println("after get");
		return result;
	}

	@Override
	public void removeTPO(UserDetails user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
		// entityManager.merge(user);
	}

}