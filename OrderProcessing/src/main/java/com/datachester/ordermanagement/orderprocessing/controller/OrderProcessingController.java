package com.datachester.ordermanagement.orderprocessing.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.ordermanagement.orderprocessing.entity.*;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.vo.Order;;
@RestController
@RequestMapping("/ordering")
public class OrderProcessingController {
    @Autowired
	private OrderRepository repository;

	//TODO need to replace with DB calls
	Map<String, Order> orderMap = new HashMap<String, Order>();
    int orderindex = 1;
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(@RequestBody Order order){
		orderMap.put(order.getOrderNumber(), order);
		repository.save(new OrderEntity(order.getOrderNumber(),order.getName()));
		return "saved";
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteOrderMAP(@RequestBody Order order){
		orderMap.remove(order.getOrderNumber());
		return order.getOrderNumber();
	}
	
	@RequestMapping(value="/{OrderID}",method=RequestMethod.DELETE)
	public String deleteOrderDB(@PathVariable("OrderID") int Orderid){
		repository.delete(repository.findOne(Orderid));
		return "Order "+Orderid+" deleted";
	}
	@RequestMapping(value="/{OrderID}",method=RequestMethod.GET)
	public OrderEntity getOrderDB(@PathVariable("OrderID") int Orderid){
		return repository.findOne(Orderid);
	}
    //@RequestMapping("/addone")
   // public String orderadd(){
   // 	String name = "Order NO."+Integer.toString(orderindex);
	//    repository.save(new OrderDB(Integer.toString(orderindex),name));
	//    orderindex++;
    //	return "one order added";
   // }
    //@RequestMapping(value="/addone/{OrderID}/{Name}",method = RequestMethod.GET)
    //public String orderaddcustom(@PathVariable("OrderID") String Orderid,@PathVariable("Name") String Name){
    //	
	//    repository.save(new OrderDB(Orderid,Name));
	//    orderindex++;
    //	return "one order added";
    //}
	
    @RequestMapping("/findAll")
    public Iterable<OrderEntity> findAll(){
    	return repository.findAll();
    }
	//@RequestMapping("/{orderNumber}")
	//public Order getOrder(@PathVariable String orderNumber){
	//	return orderMap.get(orderNumber);
		
	//}
}
