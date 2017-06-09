package com.datachester.ordermanagement.orderprocessing.service;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.vo.*;
import java.util.List;


public interface OrderService {
      public void create(OrderRequest order);
      public List<OrderEntity> getAll();
      public OrderResponse get(String orderid);
      public long getnum();
      public void delete(String orderID);
      public String getStatus(String orderid);
}
