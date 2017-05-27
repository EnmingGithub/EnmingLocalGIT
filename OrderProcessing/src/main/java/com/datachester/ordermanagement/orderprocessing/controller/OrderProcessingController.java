package com.datachester.ordermanagement.orderprocessing.controller;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.ordermanagement.orderprocessing.service.OrderServiceImpl;
import com.datachester.ordermanagement.orderprocessing.entity.*;
//import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
@RestController
@RequestMapping("/ordering")
public class OrderProcessingController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private OrderServiceImpl Orderservice;
	//private OrderRepository repository;

	//TODO need to replace with DB calls
	//Map<String, Order> orderMap = new HashMap<String, Order>();
  //  int orderindex = 1;
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(@RequestBody OrderEntity order){
	//	orderMap.put(order.getOrderNumber(), order);
	//	repository.save(new OrderEntity(order.getOrderNumber(),order.getName()));
		
		Orderservice.create(order);
		//return order.getOrderId()+order.getName();
		return "saved";
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteOrderMAP(@RequestBody OrderEntity order){
	//	orderMap.remove(order.getOrderNumber());
		return order.getOrderId();
	}
	
	@RequestMapping(value="/{OrderID}",method=RequestMethod.DELETE)
	public String deleteOrderDB(@PathVariable("OrderID") int Orderid){
	//	repository.delete(repository.findOne(Orderid));
		return "Order "+Orderid+" deleted";
	}
	@RequestMapping(value="/{OrderID}",method=RequestMethod.GET)
	public List<Map<String, Object>> getOrderDB(@PathVariable("OrderID") String Orderid){
		return Orderservice.get(Orderid);
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
    public List<Map<String, Object>> findAll(){
    	return Orderservice.getAll();
    }
	//@RequestMapping("/{orderNumber}")
	//public Order getOrder(@PathVariable String orderNumber){
	//	return orderMap.get(orderNumber);
		
	
    @RequestMapping("/total")
    public int countAll(){
    	return Orderservice.getnum();
    }
}
