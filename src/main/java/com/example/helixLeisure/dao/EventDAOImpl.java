package com.example.helixLeisure.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.helixLeisure.model.Event;

@Component
public class EventDAOImpl implements EventDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void save(Event event) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(event);
		transaction.commit();
		session.close();
	}
	
	@Override
	public Event find(long id) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Query query = session.createQuery("from Event where id = :id", Event.class);
		query.setParameter("id", id);
		Event event = (Event) query.getSingleResult();
		session.close();
		return event;
	}

}
