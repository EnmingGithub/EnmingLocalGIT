package com.datachester.ordermanagement.orderprocessing.controller;
//import java.util.HashMap;
import java.util.List;


//import java.util.Map;
import javax.sql.DataSource;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datachester.ordermanagement.orderprocessing.service.OrderServiceImpl;
//import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.vo.OrderRequest;
@RestController
@RequestMapping("/ordering")
public class OrderProcessingController {
    @Autowired
    DataSource dataSource;

    @Autowired
    private OrderServiceImpl orderservice;
	//private OrderRepository repository;

	//TODO need to replace with DB calls
	//Map<String, Order> orderMap = new HashMap<String, Order>();
  //  int orderindex = 1;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody OrderRequest order){

		orderservice.create(order);
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteOrderMAP(@RequestBody OrderRequest order){
	//	orderMap.remove(order.getOrderNumber());
		//Orderservice.delete(order);
		return "Order  deleted";
	}
	
	@RequestMapping(value="/{OrderID}",method=RequestMethod.DELETE)
	public String deleteOrderDB(@PathVariable("OrderID") int Orderid){
	//	repository.delete(repository.findOne(Orderid));
		orderservice.delete(Orderid);
		return "Order "+Orderid+" deleted";
	}
	@RequestMapping(value="/{OrderID}",method=RequestMethod.GET)
	public List<OrderEntity> getOrderDB(@PathVariable("OrderID") String Orderid){
		return orderservice.get(Orderid);
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
    public List<OrderEntity> findAll(){
    	return orderservice.getAll();
    }
	//@RequestMapping("/{orderNumber}")
	//public Order getOrder(@PathVariable String orderNumber){
	//	return orderMap.get(orderNumber);
		
	
    @RequestMapping("/total")
    public long countAll(){
    	return orderservice.getnum();
    }
}
