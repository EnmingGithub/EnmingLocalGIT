package com.datachester.ordermanagement.orderprocessing.service;

public class TestServiceImpl implements TestService{

	public String query(String orderid) {
        System.out.println("orderid:"+orderid);

        return "test-orderid";
    }
	public void delete(String orderid){
		
	}
}
