package com.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Address;
import com.demo.model.Employee;
import com.demo.service.AddressService;
import com.demo.service.EmployeeService;

import dto.LoginDTO;

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

//	@PostMapping("/validateUser")
//	@PostMapping(produces = {
//			MediaType.
//	})
	@RequestMapping(value = { "/validateUser" }, method = RequestMethod.POST)
	public String validateUser(HttpServletRequest request, Model m) {
//		if (email != null && password.equals(password)) {
//			System.out.println("entered email is " +email);
//			System.out.println(email);
//			System.out.println(email);
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		Employee emp = this.employeeService.checkEmailExist(email);
		if (password.equals(emp.getPassword())) {

			System.out.println("email : " + emp.getEmail());
			int empId = emp.getEmpId();
			m.addAttribute("emp", this.employeeService.getEmpById(empId));
			session.setAttribute("emp", emp);

			int isAdmin = emp.getIsAdmin();
			System.out.println(" isAdmin = " + isAdmin);
			System.out.println("employee id : " + empId);
			if (emp.getEmpId() != 0) {
				if (emp.getIsAdmin() == 1) {
					System.out.println("login employee is admin");
					m.addAttribute("employee", this.employeeService.getAllEmp());
					m.addAttribute("title", "Employee List");
					return "employee-list";
				} else {
					return "emp-homepage";
				}

			} else {

				System.out.println("not registered emp id");
				return null;

			}
		} else {
			return "error";
		}
//			System.out.println(emp.getEmpId());
//			  Iterator<Employee> itr=emp.iterator();    
//			     while(itr.hasNext()){    
//			    Employee e=itr.next();    
//			    System.out.println(e.getEmpId());  
//				System.out.println(e.getEmail());
//				System.out.println(e.getPassword());
//			     }

	}
//		else {
//			return "errorPage";
//		}

//	@GetMapping("/profilePage")
//	public String profile() {
//		this.employeeService.getEmpById(SessionFactory );
//	}

	@GetMapping("/getAllEmployee")
	public String getAllEmp(Model m, HttpServletRequest request) {

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

	@PostMapping("/reset-password-response")
	public String reSetPasswordResponse(HttpServletRequest request) {
		String email = request.getParameter("email");

		Employee emp = this.employeeService.checkEmailExist(email);
		if (emp.getEmail() != null) {
			request.setAttribute("employeeEmail", emp);
			return "reset-password-response";
		} else {
			return "errorPage";
		}

	}

	@PostMapping("/addEmployee")
	public String addNewEmployee(@ModelAttribute("addEmployee") Employee emp, Errors errors,
			HttpServletRequest request) {
		if (errors.hasErrors()) {
			return "register";
		} else {

			if (emp.getPassword().equals(emp.getConfirmPassword())) {
				this.employeeService.addEmp(emp);
				int empId = this.employeeService.getMaxEmpId();
				System.out.println("new employee id is" + empId);
				int count;
				for (count = 0; count < 10; count++) {

					String street = request.getParameter("test[" + count + "][street]");
					String city = request.getParameter("test[" + count + "][city]");
					String state = request.getParameter("test[" + count + "][state]");
					String pinCode = request.getParameter("test[" + count + "][pincode]");
					if (street == null && city == null && state == null && pinCode == null)
						break;
				}
				for (int j = 0; j < count; j++) {
					String street = request.getParameter("test[" + j + "][street]");
					String city = request.getParameter("test[" + j + "][city]");
					String state = request.getParameter("test[" + j + "][state]");
					String pin = request.getParameter("test[" + j + "][pincode]");
					Address add = new Address();
					add.setStreet(street);
					add.setCity(city);
					add.setState(state);
					add.setPinCode(pin);
					add.setEmpId(empId);
					this.addressService.addAddress(add);
				}
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
				return "register";
			} else {
				return "error";
			}
		}

	}

	// edit employee details
	@GetMapping("/edit-employee-details/{id}")
	public String editEmp(@PathVariable(value = "id") int id, Model m) {

		Employee emp = this.employeeService.getEmpById(id);
		System.out.println(emp.getEmpId());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getMobNo());
		System.out.println(emp.getEmail());
		System.out.println(emp.getDob());
		System.out.println(emp.getHobbies());
		List<Address> add = this.addressService.getAddressByEmpId(id);
		System.out.println("size of address in controller is " + add.size());
		m.addAttribute("employee", emp);
		m.addAttribute("address", add);
		m.addAttribute("title", "Edit Employee Details");
		return "edit-employee-details";
	}

	@PostMapping("/edit-employee-details/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee emp, HttpServletRequest request) {
		this.employeeService.updateEmp(emp);
		int empId = emp.getEmpId();
		List<Address> add = this.addressService.getAddressByEmpId(emp.getEmpId());
		
		for (int i =-1; i > -5; i--) {
			if (request.getParameter("street[" + i + "]") != null) {
				System.out.println(request.getParameter("street[-1]") != null);
				System.out.println("==================== address in minus value =======================");
				String street = request.getParameter("street[-1]");
				String city = request.getParameter("city[-1]");
				String state = request.getParameter("state[-1]");
				String pinCode = request.getParameter("pinCode[-1]");
				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				address.setPinCode(pinCode);
				address.setEmpId(empId);
				this.addressService.addAddress(address);
			}
		}
		if (add.size() == 0) {
			if (request.getParameter("street[0]") != null) {
				String street = request.getParameter("street[0]");
				String city = request.getParameter("city[0]");
				String state = request.getParameter("state[0]");
				String pinCode = request.getParameter("pinCode[0]");
				Address address = new Address();
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				address.setPinCode(pinCode);
				address.setEmpId(empId);
				this.addressService.addAddress(address);
			}
		}
		for (int i = 0; i < add.size(); i++) {
			if (request.getParameter("street[" + i + "]") == null && request.getParameter("city[" + i + "]") == null
					&& request.getParameter("state[" + i + "]") == null
					&& request.getParameter("pinCode[" + i + "]") == null) {

				this.addressService.deleteByAddId(add.get(i).getAddId());
				System.out.println("address deleted from controller : " + add.get(i).getAddId());
			}
		}
		int count;
		for (count = 0; count < 10; count++) {

			String street = request.getParameter("test[" + count + "][street]");
			String city = request.getParameter("test[" + count + "][city]");
			String state = request.getParameter("test[" + count + "][state]");
			String pinCode = request.getParameter("test[" + count + "][pincode]");
			if (street == null && city == null && state == null && pinCode == null)
				break;
		}
		for (int j = 0; j < count; j++) {
			String street = request.getParameter("test[" + j + "][street]");
			String city = request.getParameter("test[" + j + "][city]");
			String state = request.getParameter("test[" + j + "][state]");
			String pin = request.getParameter("test[" + j + "][pincode]");
			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setPinCode(pin);
			address.setEmpId(empId);
			this.addressService.addAddress(address);
		}
		System.out.println(emp.getIsAdmin() == 0);
		if (emp.getIsAdmin() == 0) {
			return "redirect:/profile";

		} else {
			return "redirect:/getAllEmployee";
		}

	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmpById(@PathVariable int id) {
		this.employeeService.deleteEmpById(id);
		List<Address> add = this.addressService.getAddressByEmpId(id);
		for (Address address : add) {
			int addId = address.getAddId();
			this.addressService.deleteByAddId(addId);
		}
		return "redirect:/getAllEmployee";
	}

	@GetMapping("/deleteAddress/{id}")
	public String deleteByAddId(@PathVariable int id) {
		this.addressService.deleteByAddId(id);
		return "redirect:/edit-employee-details";
	}

	@GetMapping("/profile")
	public String profile(HttpServletRequest request, Model m) {

		HttpSession session = request.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		m.addAttribute("employee", emp);
		int id = emp.getEmpId();
		List<Address> add = this.addressService.getAddressByEmpId(id);
		m.addAttribute("address", add);
		if (emp != null) {
			System.out.println(emp.getFirstName());
		}
//		System.out.println(emp.getFirstName());
		return "profile";
	}

	@GetMapping("/homepage")
	public String homePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("employee");
		return "emp-homepage";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("employee");
		session.removeAttribute("address");
		session.removeAttribute("emp");
		session.setMaxInactiveInterval(0);
		session.invalidate();

		return "index";
	}

}
