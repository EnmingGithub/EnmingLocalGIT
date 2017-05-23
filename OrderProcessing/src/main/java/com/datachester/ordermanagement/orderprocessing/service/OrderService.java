package com.datachester.ordermanagement.orderprocessing.service;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import java.util.List;

public interface OrderService {
      public void create(OrderEntity order);
      public List<OrderEntity> getAll();
      public void get(String orderid);
}
