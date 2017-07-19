package com.datachester.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.customermanagement.entity.Customer;
import com.datachester.customermanagement.service.CustomerServiceImpl;
import com.datachester.customermanagement.vo.*;

@RestController
public class CustomerManagementController {
     @Autowired
     private CustomerServiceImpl customerservice;
     
 	@RequestMapping(value = "/customer", method = RequestMethod.POST)
 	@ResponseStatus(HttpStatus.CREATED)
 	public void save(@RequestBody CustomerRequest cust) {
 		customerservice.create(cust);
 	}
 	
	@RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@RequestBody CustomerRequest cust) {
			customerservice.deleteCustomer(cust.getName());
               
	}

	@RequestMapping(value = "/customer/{Name}", method = RequestMethod.GET)
	public CustomerResponse getCustomer(@PathVariable("Name") String Name) {
		return customerservice.getCustomer(Name);
	}

	@RequestMapping("/history")
	public List<Customer> findAll() {
		return customerservice.getAll();
	}

	@RequestMapping("/total")
	public long countAll() {
		return customerservice.getnum();
	}
}
