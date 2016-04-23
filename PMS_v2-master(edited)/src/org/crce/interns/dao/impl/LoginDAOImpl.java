package org.crce.interns.dao.impl;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.crce.interns.dao.LoginDAO;
import org.crce.interns.model.RoleMaster;
import org.crce.interns.model.UserDetails;
//import org.crce.interns.model.UserDetails;
import org.hibernate.Query;
import java.util.List;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

	public String checkLogin(String userName, String userPassword) {
		
		System.out.println("In Check login");
		
		Session session = sessionFactory.openSession();
		
		String roleName="";
		
		//Query using Hibernate Query Language
		String SQL_QUERY ="from RoleMaster as r where r.roleId=(select roleId from UserDetails as u where u.userName=? and u.userPassword=?)";
		
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,userName);
		query.setParameter(1,userPassword);
		
		List list = query.list();
		
		if  ( !(list.isEmpty())){
			RoleMaster r=(RoleMaster)list.get(0);
			roleName=r.getRoleName();
			System.out.println("Role:"+roleName);
		}
		
		session.close();

		return roleName;
	}
	
	public int getStudentById(String userName) 
	{
		System.out.println("In getStudentById");
		Session session = sessionFactory.openSession();
		int list=session.createQuery("update UserDetails u set u.notified=true where u.userName=? ")
				.setParameter(0,userName)
				.executeUpdate();
		System.out.println("LIST:"+list);
		session.close();
		return list;
	}
	public boolean getNotification(String userName)
	{
		System.out.println("In getNotification username:+ "+userName);
		Session session = sessionFactory.openSession();
		List list=session.createQuery("from UserDetails u where u.userName=?")
				.setParameter(0,userName)
				.list();
		UserDetails u=(UserDetails)list.get(0);
		boolean b=u.isNotified();
		session.close();
		return b;
	}
  }