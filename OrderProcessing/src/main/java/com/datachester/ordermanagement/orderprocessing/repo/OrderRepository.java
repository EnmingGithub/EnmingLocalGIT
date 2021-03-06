package com.datachester.ordermanagement.orderprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;


import java.lang.String;
//import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	OrderEntity findByOrderID(String orderid);
	@Query("delete from OrderEntity u where u.orderID = ?1") 
	void deleteOrdersByOrderId(String orderID);
	

    
	//void save(Order order);
}
