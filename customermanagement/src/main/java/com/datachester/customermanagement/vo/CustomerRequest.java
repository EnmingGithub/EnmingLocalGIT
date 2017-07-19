package com.datachester.customermanagement.vo;

import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

public class CustomerRequest {

	private String name;
	private Integer age;
	private String phone;
	private String address;
	private Date created_date;
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}
