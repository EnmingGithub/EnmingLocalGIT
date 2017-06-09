package com.datachester.ordermanagement.orderprocessing.controller;
//import java.util.HashMap;
import java.util.List;

//import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
//import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
//import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.service.*;
import com.datachester.ordermanagement.orderprocessing.vo.*;
@RestController

public class OrderProcessingController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private OrderServiceImpl orderservice;
    @Autowired
    private DeliveryServiceImpl deliveryservice;

	@RequestMapping(value="/ordering",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody OrderRequest order){

		orderservice.create(order);
		
	}

	@RequestMapping(value="/cancel",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteOrderDB(@RequestBody OrderRequest Orderid){
		if ( orderservice.get(Orderid.getOrderID()).getStatus() == "preparing shipping"){
			orderservice.delete(Orderid.getOrderID());
		}		
	}
	@RequestMapping(value="/ordering/{OrderID}",method=RequestMethod.GET)
	public OrderResponse getOrderDB(@PathVariable("OrderID") String Orderid){
		return orderservice.get(Orderid);
	}
	@RequestMapping(value="/status/{OrderID}",method=RequestMethod.GET)
	public String getOrderStatus(@PathVariable("OrderID") String Orderid){
		return orderservice.getStatus(Orderid);
	}
	@RequestMapping("/history")
	public List<OrderEntity> findAll(){
		return orderservice.getAll();
	}
    @RequestMapping("/total")
    public long countAll(){
    	return orderservice.getnum();
    }
    
    @RequestMapping(value="/ship",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void ship(@RequestBody OrderRequest orderID){

		deliveryservice.ship(orderID);
		
	}
    @RequestMapping(value="/deliver",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void deliver(@RequestBody OrderRequest orderID){

		deliveryservice.deliver(orderID);
		
	}
    
}

