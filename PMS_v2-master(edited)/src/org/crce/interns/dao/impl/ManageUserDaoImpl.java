package org.crce.interns.dao.impl;


import java.sql.SQLException;

import org.crce.interns.dao.ManageUserDao;
import org.crce.interns.model.Faculty;
import org.crce.interns.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("manageUserDao")
public class ManageUserDaoImpl implements ManageUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void createStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	public void createFaculty(Faculty faculty) {
		sessionFactory.getCurrentSession().saveOrUpdate(faculty);
	}
	
	public void deleteUser(Student student, String username){
		try{
		//sessionFactory.getCurrentSession().createQuery("DELETE FROM Student WHERE rollno ="+student.getRollno()).executeUpdate();
			/*Session session = sessionFactory.openSession();
			student.setRollno(username);
			session.delete(student);
			session.close();*/
			student.setRollno(username);
			sessionFactory.getCurrentSession().delete(student);
		}
		catch(HibernateException e){
			System.out.println(e);
		}
	}
}
