package com.datachester.ordermanagement.orderprocessing.service;

public interface DeliveryService {
      public void ship(String orderID);
      public void deliver(String orderID);
}
