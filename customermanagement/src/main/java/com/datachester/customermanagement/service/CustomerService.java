package com.datachester.customermanagement.service;

import java.util.List;

import com.datachester.customermanagement.entity.Customer;
import com.datachester.customermanagement.vo.*;

public interface CustomerService {
    public Customer create(CustomerRequest cust);
    public List<Customer> getAll();
    public CustomerResponse getCustomer(String name);
    public long getnum();
    public void deleteCustomer(String name);

}
