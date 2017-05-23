package com.datachester.ordermanagement.orderprocessing.vo;
import java.util.*;

public class Order {
	private String orderNumber;
	private String name;
	private Date createDate;

	public Order(){
		createDate = new Date();
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}	
} 
