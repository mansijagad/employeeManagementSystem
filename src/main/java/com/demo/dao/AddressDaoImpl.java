package com.demo.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.demo.model.Address;
import com.demo.model.Employee;

@Repository
public class AddressDaoImpl implements AddressDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Transactional
	public void addAddress(Address a) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
//		hibernateTemplate.save(e);
	}
}
