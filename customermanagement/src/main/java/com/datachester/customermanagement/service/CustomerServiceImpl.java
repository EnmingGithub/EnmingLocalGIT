package com.datachester.customermanagement.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datachester.customermanagement.entity.Customer;
import com.datachester.customermanagement.repo.CustomerRepository;
import com.datachester.customermanagement.vo.CustomerRequest;
import com.datachester.customermanagement.vo.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService{
     @Autowired(required=false)
     private CustomerRepository customerRepo;
     
     @Override
     public Customer create(CustomerRequest cust){
    	 Customer newcust = new Customer();
    	 newcust.setName(cust.getName());
    	 newcust.setAge(cust.getAge());
    	 newcust.setPhone(cust.getPhone());
    	 newcust.setAddress(cust.getAddress());
    	 return customerRepo.save(newcust);
     }
     
     @Override
     public List<Customer> getAll(){
    	 return customerRepo.findAll();

     }
     
     @Override
     public long getnum(){
       	 return customerRepo.count();

     }
     
     @Override
     public CustomerResponse getCustomer(String name){
    	 CustomerResponse custResponse = new CustomerResponse();
     	 BeanUtils.copyProperties(customerRepo.findByName(name), custResponse);
     	 return custResponse;
     }
     
     @Override
     public void deleteCustomer(String name){
    	 customerRepo.deleteCustomerByName(name);
     }
     
}
