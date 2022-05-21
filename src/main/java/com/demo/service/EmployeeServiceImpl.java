package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;

import com.demo.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}

	// add emp
	@Transactional
	public void addEmp(Employee e) {

		this.employeeDao.addEmployee(e);
	}

	// get all emp
	@Transactional
	public List<Employee> getAllEmp() {
		
		return this.employeeDao.getAllEmp();
	}
	
	// get emp by id
	@Transactional
	public Employee getEmpById(int id) {
		
		return this.employeeDao.getEmpById(id);
		
	}
	
	// update emp
	@Transactional
	public void updateEmp(Employee e) {
		
		this.employeeDao.updateEmp(e);
	}
	
	//delete emp by id
	@Transactional
	public void deleteEmpById(int id) {
		this.employeeDao.deleteEmp(id);
	}

	@Transactional
	public Employee checkEmailExist(String email,String password) {
		// TODO Auto-generated method stub
		return this.employeeDao.checkEmailExist(email,password);
	}
	public int getMaxEmpId() {
		return this.employeeDao.getMaxEmpId();
	}

}
