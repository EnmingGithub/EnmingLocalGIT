package com.datachester.ordermanagement.orderprocessing.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
public class OrderDB {
    
	    @Id
	    @GeneratedValue
	    //(strategy = GenerationType.AUTO)
	    private int id;
	    
	    private String OrderID;
	 
	    private String Name;
	    
	    private Date CreateDate;
        public OrderDB(){
    		CreateDate = new Date();
        }
        public OrderDB(String orderID,String name){
        	this.OrderID = orderID;
        	this.Name = name;
        	this.CreateDate = new Date();
        }
	    public void setid(int id){
	    	this.id = id;
	    }
	    public long getid(){
	    	return id;
	    }
	    public String getName() {
	        return Name;
	    }
	 
	    public void setName(String name) {
	        this.Name = name;
	    }

	    public String getOrderId() {
	        return OrderID;
	    }
	 
	    public void setOrderId(String orderid) {
	        this.OrderID = orderid;
	    }
	 
	    public Date getCreateDate() {
	        return CreateDate;
	    }
	 
	    public void setCreateDate(Date createdate) {
	        this.CreateDate = createdate;
	    }
	 
	
}
