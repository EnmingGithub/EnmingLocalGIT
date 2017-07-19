package com.datachester.customermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datachester.customermanagement.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByName(String name);
	@Query("delete from Customer u where u.name = ?1") 
	void deleteCustomerByName(String name);
	

}
