package com.datachester.ordermanagement.orderprocessing.service;

import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderServiceImpl implements OrderService {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
    @Override
    public void create(OrderEntity order){
    	String sql = "INSERT INTO orders " + "(id, name) VALUES (seq_users_id.nextval, ?)";
    	jdbcTemplate.update(sql, new Object[] { OrderEntity.getName()});
    }
    
    @Override
    public List<OrderEntity> getAll() {
    	String sql = "SELECT * FROM users";

        return jdbcTemplate.query(sql,
                (resultSet, rowNum) ->
                    new OrderEntity (
                            resultSet.getLong("id"),
                            resultSet.getString("Name")
                    ));
    }
}
