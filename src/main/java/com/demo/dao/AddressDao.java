package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.demo.model.Address;

public interface AddressDao {

	public void addAddress(Address a);
	
	public List<Address> getAddressByEmpId(int id);
	
	@Transactional
	public void deleteByAddId(int id);
	
}
