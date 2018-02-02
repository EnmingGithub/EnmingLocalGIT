package com.testingproject.cctesting.hsqldb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "User")
public class User {

	
	@Id
	@GeneratedValue
	private long id;
	public long getId() {
		return id;
	}

	@Column (nullable = false)
	private String name;
	@Column (nullable = false)
	private Integer age;
	public User() {

	}
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
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, age=%s]", id, name, age);
	}
}
