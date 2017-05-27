package com.datachester.ordermanagement.orderprocessing.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
public class OrderEntity {
    
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	    
	    //(strategy = GenerationType.AUTO)
	    private int id;
	    
	    private String OrderID;
	 
	    private String Name;
	    
	 //   @Column(name = "CREATED_DATE")
	    private Date date;
        public OrderEntity(){
    		date = new Date();
        }
        public OrderEntity(String orderID,String name){
        	this.OrderID = orderID;
        	this.Name = name;
        	this.date = new Date();
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
	        return date;
	    }
	 
	    public void setCreateDate(Date createdate) {
	        this.date = createdate;
	    }
	 
	
}

