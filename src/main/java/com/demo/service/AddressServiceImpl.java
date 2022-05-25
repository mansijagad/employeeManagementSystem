package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.dao.AddressDao;
import com.demo.dao.EmployeeDao;
import com.demo.model.Address;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public void addAddress(Address a) {
		this.addressDao.addAddress(a);
	}

	public List<Address> getAddressByEmpId(int id) {
		return this.addressDao.getAddressByEmpId(id);
	}

	// delete emp by id
	@Transactional
	public void deleteByAddId(int id) {
		this.addressDao.deleteByAddId(id);
	}
}
