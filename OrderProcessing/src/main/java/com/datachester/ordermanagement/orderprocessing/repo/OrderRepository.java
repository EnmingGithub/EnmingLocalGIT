package com.datachester.ordermanagement.orderprocessing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.vo.OrderRequest;

import java.lang.String;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	List<OrderEntity> findByOrderID(String orderid);

	//void save(Order order);
}
