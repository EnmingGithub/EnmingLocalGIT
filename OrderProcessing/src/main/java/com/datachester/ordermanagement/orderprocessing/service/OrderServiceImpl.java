package com.datachester.ordermanagement.orderprocessing.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.vo.OrderRequest;
import com.datachester.ordermanagement.orderprocessing.vo.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Override
    public OrderEntity create(OrderRequest order){
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderID(order.getOrderID());
		orderEntity.setName(order.getName());
		return orderRepo.save(orderEntity);
		
	}

    @Override
    public OrderResponse get(String orderID){
    	OrderResponse orderResponse = new OrderResponse();
    	BeanUtils.copyProperties(orderRepo.findByOrderID(orderID), orderResponse);
        return orderResponse;
        
    }
    @Override
    public List<OrderEntity> getAll() {
        return orderRepo.findAll();
    }
    @Override
    public long getnum(){
    	return orderRepo.count();
    }
    @Override
    public void delete(String orderID){
    	orderRepo.delete(orderRepo.findByOrderID(orderID).getId());
    }
    @Override
    public String getStatus(String Orderid){
    	return orderRepo.findByOrderID(Orderid).getStatus();
    }
}
