package com.datachester.ordermanagement.orderprocessing.service;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import java.util.List;
import java.util.Map;

public interface OrderService {
      public void create(OrderEntity order);
      public List<Map<String, Object>> getAll();
      public List<Map<String, Object>> get(String orderid);
      public int getnum();
}
