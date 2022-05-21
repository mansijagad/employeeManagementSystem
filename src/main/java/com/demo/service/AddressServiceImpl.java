package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.dao.AddressDao;
import com.demo.dao.EmployeeDao;
import com.demo.model.Address;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao;
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao=addressDao;
	}
	public void addAddress(Address a) {
		this.addressDao.addAddress(a);
	}
}
