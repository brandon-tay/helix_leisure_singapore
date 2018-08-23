package com.example.helixLeisure.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.helixLeisure.model.Product;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void save(Product product) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(product);
		transaction.commit();
		session.close();
	}
	
	@Override
	public Product find(long id) {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Query query = session.createQuery("from Product where id = :id", Product.class);
		Product product = (Product) query.getSingleResult();
		session.close();
		return product;
	}

}
