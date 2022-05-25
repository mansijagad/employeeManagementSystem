package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		session.save(a);
//		hibernateTemplate.save(e);
	}

	public List<Address> getAddressByEmpId(int id) {
		Session session = this.sessionFactory.openSession();
//		List<Address> addList = session.createQuery("from Address ").list();
//		for(Address add : addList){
//			System.out.println(("Person List::"+add));
//		}
//		return addList;
//		
		String hql = "FROM Address a WHERE a.empId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List results = query.list();
		System.out.println("result size is " + results.size());
		return results;
//		Query query = session.createQuery("from address");
//		List<Address> addList  = query.list();
//		System.out.println("size of address is : "+addList.size());
////		List<Address> addList = (List<Address>) session.createQuery("from address").list();
////		System.out.println(addList.get(0).getAddId());
//		return addList;
	}

	// delete emp
	@Transactional
	public void deleteByAddId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = session.load(Address.class, id);
		if (null != address) {
			session.delete(address);
		}
//			hibernateTemplate.delete(hibernateTemplate.get(Employee.class, id));
	}
	
	
}
