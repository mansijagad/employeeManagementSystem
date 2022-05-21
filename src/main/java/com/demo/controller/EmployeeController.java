package com.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Address;
import com.demo.model.Employee;
import com.demo.service.AddressService;
import com.demo.service.EmployeeService;

@Controller("/springmvccrud")
public class EmployeeController {

	EmployeeService employeeService;
	
	AddressService addressService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@Autowired(required = true)
	@Qualifier(value = "addressService")
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String loginPage() {
		return "index";
	}

	@PostMapping("/validateUser")
	public String validateUser(@RequestBody String email, @RequestBody String password) {
//		if (email != null && password.equals(password)) {
			System.out.println("entered email is " +email);
			System.out.println(email);
			System.out.println(email);
			
			Employee emp =  this.employeeService.checkEmailExist(email,password);
			System.out.println("email is " +emp.getEmail());
			int empId = emp.getEmpId();
//			System.out.println(emp.getEmpId());
//			  Iterator<Employee> itr=emp.iterator();    
//			     while(itr.hasNext()){    
//			    Employee e=itr.next();    
//			    System.out.println(e.getEmpId());  
//				System.out.println(e.getEmail());
//				System.out.println(e.getPassword());
//			     }
			return "homepage";
		}
//		else {
//			return "errorPage";
//		}
	
//	@GetMapping("/profilePage")
//	public String profile() {
//		this.employeeService.getEmpById(SessionFactory );
//	}


	@GetMapping("/getAllEmployee")
	public String getAllEmp(Model m) {
		m.addAttribute("employee", this.employeeService.getAllEmp());
		m.addAttribute("title", "Employee List");
		return "employee-list";
	}

	@RequestMapping("/register")
	public String RegisterPage() {
		return "register";
	}

	@RequestMapping("/reset-password")
	public String forgetPassPage() {
		return "reset-password";
	}

	@PostMapping("/addEmployee")
	public String addNewEmployee(@ModelAttribute("addEmployee") Employee emp ,@ModelAttribute("addAddress") Address add, @RequestBody String[][] test ) {
		if (emp.getPassword().equals(emp.getConfirmPassword())) {
			this.employeeService.addEmp(emp);
			System.out.println(add.getPinCode());
			int empId = this.employeeService.getMaxEmpId();
			System.out.println("employee id in controller " +empId);
			add.setEmpId(empId);
			int count;
//			for (count = 0; count < 10; count++) {
//				String stret = test[count]["steet"];
//				String street = request.getParameter("test[" + count + "][street]");
//				String city = request.getParameter("test[" + count + "][city]");
//				String state = request.getParameter("test[" + count + "][state]");
//				String pinCode = request.getParameter("test[" + count + "][pinCode]");
//				System.out.println("value of index is: " + count);
//				if (street == null && city ==null && state==null && pinCode==null) 
//					break;
//			}
//			System.out.println("count of city are: " + count);
//			
//			for (int j = 0; j < count; j++) {
//				String street = request.getParameter("test[" + j + "][street]");
//				String city = request.getParameter("test[" + j + "][city]");
//				String state = request.getParameter("test[" + j + "][state]");
//				String pin = request.getParameter("test[" + j + "][pincode]");

//				System.out.println("entered street:" + street);
//				System.out.println("entered city:" + city);
//				System.out.println("entered state: " + state);
//				System.out.println("entered pin :" + pin);
//				System.out.println();
//				System.out.println();
//
//				Address address = new Address();
//				address.setStreet(street);
//				address.setCity(city);
//				address.setState(state);
//				address.setPinCode(pin);
//				address.setEmpId(empId);
//			}
			this.addressService.addAddress(add);
			return "register";
		} else {
			return "error";
		}

	}

	// edit employee details
	@GetMapping("/edit-employee-details/{id}")
	public String editEmp(@PathVariable(value = "id") int id, Model m) {

		Employee emp = this.employeeService.getEmpById(id);
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getMobNo());
		System.out.println(emp.getEmail());
		System.out.println(emp.getDob());
		System.out.println(emp.getHobbies());
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee Details");

		return "edit-employee-details";
	}

	@PostMapping("/edit-employee-details/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee emp) {
		this.employeeService.updateEmp(emp);
		return "redirect:/getAllEmployee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmpById(@PathVariable int id) {
		this.employeeService.deleteEmpById(id);
		return "redirect:/getAllEmployee";
	}

	@GetMapping("/logout")
	public String logout() {
		return "index";
	}
	
	
}
