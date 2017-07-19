package com.datachester.ordermanagement.orderprocessing.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Orders")
public class OrderEntity {

	@Id
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
	@SequenceGenerator(sequenceName = "order_seq", allocationSize = 1, name = "ORDER_SEQ")
	private Integer id;
	private String orderID;
	private String name;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date date;
    
	public OrderEntity() {
		date = new Date();
		status = "preparing shipping";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}