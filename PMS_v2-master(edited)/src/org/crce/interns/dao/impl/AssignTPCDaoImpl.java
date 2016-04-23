package org.crce.interns.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.dao.AssignTPCDao;
import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*@Repository
@Transactional*/
@Repository("assignTPCDao")
@Transactional
public class AssignTPCDaoImpl implements AssignTPCDao {

	
	/* @PersistenceContext 
	 private EntityManager entityManager;
	 */

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void assignTPC(UserDetails user) {
		sessionFactory.getCurrentSession().update(user);
		//entityManager.merge(user);
	}
	
	 @Override 
	 public void insertWork(FacultyUser fuser) {
	// entityManager.merge(fuser); // TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(fuser);
	 }
	

	@Override
	public List<UserDetails> viewUsers() {
		// TODO Auto-generated method stub
		//return entityManager.createQuery("select u from UserDetails u",UserDetails.class).getResultList();
	
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from UserDetails as u";

		Query query = session.createQuery(SQL_QUERY);
		List<UserDetails> listUserDetails = query.list();
		return listUserDetails;

	}

	@Override
	public List<FacultyUser> viewFacultyTasks() {
		// return entityManager.createQuery("select u from FacultyUser u", FacultyUser.class).getResultList();
		
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from FacultyUser as f";

		Query query = session.createQuery(SQL_QUERY);
		List<FacultyUser> listUserDetails = query.list();
		return listUserDetails;

	}
	@Override
	public UserDetails getUser(UserDetails checkUser) {
		// TODO Auto-generated method stub
		
		  /*String userName = checkUser.getUserName(); 
		  UserDetails user =(UserDetails) entityManager.createQuery("select u from UserDetails u where u.username = :n").setParameter("n", userName).getSingleResult(); return user;
		 */
		System.out.println("before get");
		UserDetails result = (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class,
				checkUser.getUserName());
		System.out.println("after get");
		return result;
	}
	
	@Override
	public FacultyUser getFacultyUser(FacultyUser fuser) {
		// TODO Auto-generated method stub
		/*String userName = fuser.getUsername();
		System.out.println("Username in DAO IMPL before query :" + fuser.getUserWork());

		
		  FacultyUser fuser1 = (FacultyUser) entityManager.createQuery("select f from FacultyUser f where f.username = :n").setParameter("n", userName).getSingleResult();
		 */
		System.out.println("before get");
		FacultyUser result = (FacultyUser) sessionFactory.getCurrentSession().get(FacultyUser.class,
				fuser.getUserName());
		System.out.println("after get");

		if (result == null) {
			System.out.println("Error : User not present in Faculty Table");
		}
		System.out.println("UserName in DAO IMPL after query:" + result.getUserName());
		System.out.println("UserWork in DAO IMPL after query:" + result.getUserWork());

		return result;
	}

	
	@Override
	public RMUser getUserRole(String role_id) {
		/*RMUser rmuser = new RMUser();
		rmuser = (RMUser) entityManager.createQuery("select r from RMUser r where r.role_id = :n").setParameter("n", role_id).getSingleResult();
		return rmuser;*/
		Session session = sessionFactory.openSession();
		String SQL_QUERY = "from RMUser r where r.role_id = :n";
		
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("n", role_id);
		List<RMUser> list = query.list();
		//return listUserDetails;

		return list.get(0);
	}

	
	
	
	@Override
	public void removeTPC(UserDetails user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(user);
	//	 entityManager.merge(user);
	}

}