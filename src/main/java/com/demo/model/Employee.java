package com.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToMany(mappedBy = "empId")
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "first_name")	
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mob_no")
	private String mobNo;
	
//	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String hobbies;
	
	private int isAdmin;
	
	@Column(unique = true)
	private String email;
	
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	
	private int addressId;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int id) {
		this.empId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Employee [id=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobNo=" + mobNo
				+ ", dob=" + dob + ", hobbies=" + hobbies + ", isAdmin=" + isAdmin + ", email=" + email + ", password="
				+ password + ", addressId=" + addressId + "]";
	}
	
	public Employee(int empId, String firstName, String lastName, String mobNo, Date dob, String hobbies, int isAdmin,
			String email, String password, int addressId) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobNo = mobNo;
		this.dob = dob;
		this.hobbies = hobbies;
		this.isAdmin = isAdmin;
		this.email = email;
		this.password = password;
		this.addressId = addressId;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
