package com.datachester.ordermanagement.orderprocessing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.service.*;
import com.datachester.ordermanagement.orderprocessing.vo.*;

@RestController
public class OrderProcessingController {
	@Autowired
	private OrderServiceImpl orderservice;
	@Autowired
	private DeliveryServiceImpl deliveryservice;

	@RequestMapping(value = "/ordering", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody OrderRequest order) {

		orderservice.create(order);

	}

	@RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteOrderDB(@RequestBody OrderRequest orderCancel) {
		if (orderservice.get(orderCancel.getOrderID()).getStatus() == "preparing shipping") {
			orderservice.delete(orderCancel.getOrderID());
			return String.format("Order %s Cancelled", orderCancel.getOrderID());
		} else if (orderservice.get(orderCancel.getOrderID()).getStatus() == "Shipping") {
			return "Order " + orderCancel.getOrderID() + " already been shipped, can not be cancel now.";
		} else if (orderservice.get(orderCancel.getOrderID()).getStatus() == "Delivered") {
			return "Order " + orderCancel.getOrderID() + " already beeb delivered, can not be cancel now.";
		} else {
			return "Please retype the Order Information";
		}
	}

	@RequestMapping(value = "/ordering/{OrderID}", method = RequestMethod.GET)
	public OrderResponse getOrderDB(@PathVariable("OrderID") String Orderid) {
		return orderservice.get(Orderid);
	}

	@RequestMapping(value = "/status/{OrderID}", method = RequestMethod.GET)
	public String getOrderStatus(@PathVariable("OrderID") String Orderid) {
		return orderservice.getStatus(Orderid);
	}

	@RequestMapping("/history")
	public List<OrderEntity> findAll() {
		return orderservice.getAll();
	}

	@RequestMapping("/total")
	public long countAll() {
		return orderservice.getnum();
	}

	@RequestMapping(value = "/ship/{orderID}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void ship(@PathVariable String orderID) {

		deliveryservice.ship(orderID);

	}

	@RequestMapping(value = "/deliver/{orderID}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void deliver(@RequestBody String orderID) {

		deliveryservice.deliver(orderID);

	}

}
