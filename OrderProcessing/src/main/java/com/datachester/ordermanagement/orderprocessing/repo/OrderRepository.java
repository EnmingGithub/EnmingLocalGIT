package com.datachester.ordermanagement.orderprocessing.repo;
import com.datachester.ordermanagement.orderprocessing.entity.OrderDB;
import org.springframework.data.repository.CrudRepository;
 
public interface OrderRepository extends CrudRepository<OrderDB, Integer>{
}
