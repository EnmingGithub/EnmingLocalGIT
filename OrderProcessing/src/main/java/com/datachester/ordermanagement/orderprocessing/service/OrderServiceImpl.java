package com.datachester.ordermanagement.orderprocessing.service;

//import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datachester.ordermanagement.orderprocessing.vo.*;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Override
    public void create(OrderRequest order){
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderID(order.getOrderID());
		orderEntity.setName(order.getName());
		orderRepo.save(orderEntity);
	}

    @Override
    public OrderResponse get(String orderID){
    	OrderResponse orderresponse = new OrderResponse();
    	orderresponse.setOrderID(orderRepo.findByOrderID(orderID).getOrderID());
    	orderresponse.setName(orderRepo.findByOrderID(orderID).getName());
    	orderresponse.setStatus(orderRepo.findByOrderID(orderID).getStatus());
        orderresponse.setDate(orderRepo.findByOrderID(orderID).getDate());
        return orderresponse;
        
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
    public void delete(Integer id){
    	orderRepo.delete(id);
    }
    @Override
    public String getStatus(String Orderid){
    	return orderRepo.findByOrderID(Orderid).getStatus();
    }
}
