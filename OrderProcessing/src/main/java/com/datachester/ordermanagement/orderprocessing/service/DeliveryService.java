package com.datachester.ordermanagement.orderprocessing.service;
import com.datachester.ordermanagement.orderprocessing.vo.*;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
public interface DeliveryService {
      public void ship(OrderRequest orderID);
      public void deliver(OrderRequest orderID);
}
