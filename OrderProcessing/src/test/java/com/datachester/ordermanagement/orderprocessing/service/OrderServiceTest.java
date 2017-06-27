package com.datachester.ordermanagement.orderprocessing.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.vo.OrderRequest;
import com.datachester.ordermanagement.orderprocessing.vo.OrderResponse;

import org.junit.Assert;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    
	@InjectMocks
	private OrderService orderService = new OrderServiceImpl(); 
	@Mock
	private OrderRepository orderRepo;
	
	@Test
	public void createTest(){
		OrderRequest order = new OrderRequest();
		order.setOrderID("121");
		order.setName("1st");
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderID(order.getOrderID());
		orderEntity.setName(order.getName());
		
		
		when(orderRepo.save(any(OrderEntity.class))).thenReturn(orderEntity);
    	OrderEntity entity = orderService.create(order);
    	Assert.assertNotNull("OrderEntity should not be null", orderService.create(order));
    	Assert.assertEquals("OrderID not matched", "121", entity.getOrderID());
    }
	@Test
    public void getAllTest(){
		OrderRequest order = new OrderRequest();
		order.setOrderID("121");
		order.setName("1st");
		
		OrderEntity firstEntity = new OrderEntity();
		firstEntity.setOrderID(order.getOrderID());
		firstEntity.setName(order.getName());
		
		order.setOrderID("121");
		order.setName("1st");
		
		OrderEntity secondEntity = new OrderEntity();
		secondEntity.setOrderID(order.getOrderID());
		secondEntity.setName(order.getName());
		
		when(orderRepo.findAll()).thenReturn(Arrays.asList(firstEntity,secondEntity));
    	List<OrderEntity> entityList = orderService.getAll();
    	Assert.assertNotNull("OrderEntityList should not be null", orderService.getAll());
    	Assert.assertEquals("OrderID not matched", Arrays.asList(firstEntity,secondEntity), entityList);
    }

	@Test
    public void getTest(){
		OrderRequest order = new OrderRequest();
		order.setOrderID("121");
		order.setName("1st");
		
		OrderEntity firstEntity = new OrderEntity();
		firstEntity.setOrderID(order.getOrderID());
		firstEntity.setName(order.getName());
		
		OrderResponse orderResponse = new OrderResponse();
    	BeanUtils.copyProperties(firstEntity, orderResponse);
    	
		when(orderRepo.findByOrderID(anyString())).thenReturn(firstEntity);
    	OrderResponse entity= orderService.get(order.getOrderID());
    	Assert.assertNotNull("OrderEntity should not be null", orderService.get(order.getOrderID()));
    	Assert.assertEquals("Order not matched",orderResponse.getOrderID() , entity.getOrderID());
    }
	@Ignore
	@Test
    public void getnumTest(){
    	
    }
	@Ignore
	@Test
    public void deleteTest(){
    	
    }
	@Ignore
	@Test
    public void getStatusTest(){
    	
    }
}
