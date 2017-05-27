package com.datachester.ordermanagement.orderprocessing.service;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class OrderServiceImpl implements OrderService {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
   // @Autowired
   // public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
   //     this.jdbcTemplate = jdbcTemplate;
   // }
	int i = 1;
    @Autowired
	@Override
    public void create(OrderEntity order){
    	String sql = "INSERT INTO orders (id,OrderID,Name,CREATED_DATE) VALUES (?,?,?,?)";
    	//jdbcTemplate.update(sql);
    	jdbcTemplate.update(sql,i, order.getOrderId(), order.getName(),order.getCreateDate());
    	i++;
    	//return order.getOrderId();
    }
    
    @Override
    public List<Map<String,Object>> get(String OrderID){
    	String sql = "SELECT * FROM orders WHERE OrderID = ?";
    	return jdbcTemplate.queryForList(sql, OrderID);

    }
    @Override
    public List<Map<String, Object>> getAll() {
    	String sql = "SELECT * FROM orders";

        return jdbcTemplate.queryForList(sql);
                
    }
    @Override
    public int getnum(){
    	String sql = "SELECT COUNT(*) FROM ORDERS";

    	int total = jdbcTemplate.queryForObject(sql,Integer.class);

    	return total;
    }
    
}
