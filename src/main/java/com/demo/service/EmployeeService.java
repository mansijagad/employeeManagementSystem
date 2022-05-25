package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.demo.model.Employee;

public interface EmployeeService {

	@Transactional
	public void addEmp(Employee e);

	public List<Employee> getAllEmp();

	public Employee getEmpById(int id);

	@Transactional
	public void updateEmp(Employee e);

	@Transactional
	public void deleteEmpById(int id);
	
	public Employee checkEmailExist(String email);
	
	public int getMaxEmpId();
}
