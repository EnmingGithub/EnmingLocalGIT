package com.datachester.ordermanagement.orderprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datachester.ordermanagement.orderprocessing.vo.*;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
@Service
public class DeliveryServiceImpl implements DeliveryService{
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void ship(OrderRequest orderID){
		
		OrderEntity orderupdate = new OrderEntity();
		orderupdate = orderRepo.findByOrderID(orderID.getOrderID());
		orderupdate.setStatus("Shipping");
		orderRepo.save(orderupdate);
		
	}
	
	@Override
    public void deliver(OrderRequest orderID){
		OrderEntity orderupdate = new OrderEntity();
		orderupdate = orderRepo.findByOrderID(orderID.getOrderID());
		orderupdate.setStatus("Delivered");
		orderRepo.save(orderupdate);
	}
}
