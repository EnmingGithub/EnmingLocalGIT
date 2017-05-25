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
@Repository
public class OrderServiceImpl implements OrderService {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
   // @Autowired
   // public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
   //     this.jdbcTemplate = jdbcTemplate;
   // }
	
    @Override
    public void create(OrderEntity order){
    	String sql = "INSERT INTO orders " + "(id,OrderID,Name,Date) VALUES (seq_users_id.nextval, ?, ?, ?)";
    	jdbcTemplate.update(sql, order.getOrderId(), order.getName(),order.getCreateDate());
    	
    }
    
    @Override
    public List<OrderEntity> get(String OrderID){
    	String sql = "SELECT * FROM orders WHERE OrderID = "+OrderID;
    	return jdbcTemplate.query(sql, (rs,rowNum) -> new OrderEntity(rs.getString("OrderID"),rs.getString("Name") ));
    }
    @Override
    public List<OrderEntity> getAll() {
    	String sql = "SELECT * FROM orders";

        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new OrderEntity(rs.getString("OrderID"),rs.getString("Name") ));
    }
    
}
