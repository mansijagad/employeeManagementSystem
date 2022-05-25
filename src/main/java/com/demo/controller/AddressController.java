package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Address;
import com.demo.service.AddressService;

@Controller
@RequestMapping("/springmvcproject")
public class AddressController {

	AddressService addressService;
	
	@Autowired(required = true)
	@Qualifier(value = "addressService")
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping("/repeater.js")
	public String callRepeaterjs(@ModelAttribute("insertAddress") Address address) {
		
		return "repeater.js";
		
	}
	
	
}
