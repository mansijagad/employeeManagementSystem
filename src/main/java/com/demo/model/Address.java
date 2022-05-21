package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	private String street;
	
	private String city;
	
	private String state;
	
	@Column(name = "pin_code")
	private String pinCode;
	
//	@ManyToOne
	private int empId;

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Address(int addId, String street, String city, String state, String pinCode, int empId) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.empId = empId;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", street=" + street + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + ", empId=" + empId + "]";
	}
	
	
	

}
