package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;

import org.springframework.stereotype.Repository;

import com.demo.model.Employee;


public interface EmployeeDao {
	

	@Transactional
	public void addEmployee(Employee e);

	public List<Employee> getAllEmp();

	public Employee getEmpById(int id);

	@Transactional
	public void updateEmp(Employee e);

	@Transactional
	public void deleteEmp(int id);
	
	public Employee checkEmailExist(String email,String password);
	
	public int getMaxEmpId();
}
