package org.crce.interns.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.dao.EventDao;
import org.crce.interns.model.Event_details;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EventDaoImpl implements EventDao {

	

	@Autowired
	private SessionFactory sessionFactory;
	/*@PersistenceContext
	private EntityManager entityManager;*/

	@Override
	public List<Event_details> viewEvents(Integer months) {
		System.out.println("Month in Dao Impl :" + months);
		/*List<Event_details> allEvents = entityManager.createQuery("select ed from Event_details ed " + " where EXTRACT(MONTH from ed.dates)= :m" 
		+ " order by ed.dates").setParameter("m", months).getResultList();
		if (allEvents.isEmpty()) {
			System.out.println("Error null query");
		}
		return allEvents;*/
		Session session = sessionFactory.openSession();
		List<Event_details> edList = session.createQuery("select ed from Event_details ed where month(ed.dates) = :m order by ed.dates").setParameter("m", months).list();
		if(edList.isEmpty())
			return null;
		
		return edList;
	}
		
}
