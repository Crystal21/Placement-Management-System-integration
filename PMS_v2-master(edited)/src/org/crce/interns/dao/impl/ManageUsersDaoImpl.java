package org.crce.interns.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.dao.ManageUsersDao;
//import org.apache.commons.collections.list.LazyList;
import org.crce.interns.model.Company;
//import org.crce.interns.model.User;
import org.crce.interns.model.UserCompany;
//import org.crce.interns.model.UserCompanyId;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("crudDao")
@Transactional
public class ManageUsersDaoImpl implements ManageUsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	public void createDetails(UserCompany user){
		//System.out.println("dao "+user.getUsername());
		session=this.sessionFactory.openSession();
		//Company cpny=new Company(); 
		//Company cmpny=new Company();
		/*cpny.setCompany_name(user.getCompany());
		cpny.setCompany_id(user.getCompany_id());
		System.out.println(cpny.getCompany_id());
		cmpny=(Company) sessionFactory.getCurrentSession().get(Company.class, cpny.getCompany_id());
		user.setCompany(cmpny.getCompany_name());
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		//sessionFactory.getCurrentSession().save(user);
		//sessionFactory.getCurrentSession().persist(user);
		//sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("After sf");
		//session.save("User.class",user);
		//session.close();
*/	
		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.company_name = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		//UserCompanyId uci=new UserCompanyId();
		//uci.setUsername(user.getId().getUsername());
		//uci.setCompany_id(company_id);
		//LazyList l=null; l.add(company_id);
		user.setCompany_id(company_id);
		//user.setId(uci);
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();

		
	}
		
	
	@SuppressWarnings("unchecked")
	public List<UserCompany> retreiveDetails(String company){
		System.out.println("company= "+company);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(UserCompany.class);

	//	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
		System.out.println("inside DAO: "+company);
		//criteria.add(Restrictions.gt("company_id",company));
		//System.out.println("company= "+company);
		List<UserCompany> list=new ArrayList<UserCompany>();
		//List<User> list=new ArrayList<User>();
		list.addAll(criteria.list());
		List<UserCompany> userList=new ArrayList<UserCompany>();
		for(UserCompany d:list){
			if(d.getCompany().equals(company)) userList.add(d);
			//System.out.println(d.getUsername()+" "+d.getCompany_id());
	}
		System.out.println("outside DAO.....");
		tx.commit();
		session.close();
		
		return userList;
	}
	
	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Company.class);
		list.addAll(criteria.list());
		return list;
	}
	public void deleteDetails(UserCompany user){
		
		//UserCompany user1=new UserCompany();
		//user1.setUsername(user.getUsername());
		//user1.setCompany(user.getCompany());
		//User user2=new User();
		//user.setUsername(name);
		//user2.setCompany_id(company);
		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.company_name = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		
		System.out.println(company_id);
		user.setCompany_id(company_id);
		//user1.setCompany_id(company_id);
		//user1.setUsername(userName);

		
		user=(UserCompany) sessionFactory.getCurrentSession().get(UserCompany.class,user);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
