package com.datachester.ordermanagement.orderprocessing.repo;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
 
public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{
	List<OrderEntity> findByOrderID(String OrderID);
	List<OrderEntity> findByName(String Name);
	@Query("select c from OrderEntity c where c.OrderID = :OrderID")
	Stream<OrderEntity> findByOrderIDReturnStream(@Param("OrderID") String OrderID);
}
