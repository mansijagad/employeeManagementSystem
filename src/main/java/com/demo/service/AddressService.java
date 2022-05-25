package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.model.Address;


public interface AddressService  {

	public void addAddress(Address a);
	
	public List<Address> getAddressByEmpId(int id);
	
	@Transactional
	public void deleteByAddId(int id);
	
	
}
