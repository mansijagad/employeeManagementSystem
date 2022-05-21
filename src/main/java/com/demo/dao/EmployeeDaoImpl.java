package com.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

//	@Autowired
//	HibernateTemplate hibernateTemplate;
//	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	// add employee
	@Transactional
	public void addEmployee(Employee e) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
//		hibernateTemplate.save(e);
	}

	// get all employee
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmp() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> emplist = session.createQuery("from Employee").list();
		return emplist;
//		return hibernateTemplate.loadAll(Employee.class);
	}

	// get emp by id
	public Employee getEmpById(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, new Integer(id));

//		Employee emp = (Employee) session.createQuery("from Employee where id = :id");
//		return hibernateTemplate.get(Employee.class,id);
		return emp;
	}

	// get latest empId
	@Transactional
	public int getMaxEmpId() {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "SELECT max(e.empId) FROM Employee e";
		List list = session.createQuery(query).list();
		int maxempID = ((Integer) list.get(0)).intValue();
		System.out.println(maxempID);
		return maxempID;
	}

	// update employee data
	@Transactional
	public void updateEmp(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
//		hibernateTemplate.update(e);
	}

	// delete emp
	@Transactional
	public void deleteEmp(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = session.load(Employee.class, id);
		if (null != emp) {
			session.delete(emp);
		}
//		hibernateTemplate.delete(hibernateTemplate.get(Employee.class, id));
	}

	@Override
	public Employee checkEmailExist(String empEmail, String password) {
		// TODO Auto-generated method stub

		System.out.println(empEmail);
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> emplist = session.createQuery("from Employee").list();
		Employee emp = new Employee();
		System.out.println(emplist);
		System.out.println("entered email is" + empEmail);
		for (Employee e : emplist) {
			System.out.println(e.getEmail());

			System.out.println(empEmail.equals(e.getEmail()));
			System.out.println();
			if (empEmail.equals(e.getEmail())) {
				System.out.println("emp id is " + e.getEmpId());
				emp.setEmpId(e.getEmpId());
				emp.setPassword(e.getPassword());
				emp.setEmail(e.getEmail());

				return emp;
			}
		}
		return emp;
	}
}

////		Employee emp = (Employee) session.get(Employee.class,new String(email));
//			  Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.email = :email");
//			  query.setParameter("email", empEmail);
//			  query.getResultList();
//			  System.out.println("size of result is " +query.list().size());
//			  return (Employee) query.list().get(0);
//			}		

//		
//		
//		System.out.println("In Check login");
//		Session session = sessionFactory.openSession();
////		Employee emp = (Employee) session.get(Employee.class, email);
//
////		Employee emp = (Employee) session.createQuery("from Employee where email = :email");
//
//		boolean userFound = false;
//		// Query using Hibernate Query Language
//		String SQL_QUERY = "select emp_id from Employee as e where e.email=:email ";
//		Query query = session.createQuery(SQL_QUERY);
//		query.setParameter("email", email);
////		query.setParameter("password", password);
////		query.setParameter(0, email);
////		query.setParameter(1, password);
////		Employee emp = (Employee) query.getResultList();
////		List list = query.getResultList();
//		int id = query.getFirstResult();
//		System.out.println(id);
////		List<Employee> emp = query.getResultList();
////		System.out.println("getting parameters for in check email exist method");
////		System.out.println(emp.get(0));
////		  Iterator<Employee> itr=emp.iterator();    
////		     while(itr.hasNext()){    
////		    Employee e=itr.next();    
////		    System.out.println(e.getEmpId());  
////			System.out.println(e.getEmail());
////			System.out.println(e.getPassword());
////		     }
////		System.out.println(emp.getEmpId());
////		System.out.println(emp.getEmail());
////		System.out.println(emp.getPassword());
////
////		if ((emp != null)) {
////			userFound = true;
////		}
//
//		session.close();
//		return id;
//
////		if(emp!=null) {
////			String pw = emp.getPassword();
////			return pw;
////		}
////		else {
////			return "Email does not exist";
////		}
////		hibernateTemplate.find(email, Employee.class);
//
//	}
