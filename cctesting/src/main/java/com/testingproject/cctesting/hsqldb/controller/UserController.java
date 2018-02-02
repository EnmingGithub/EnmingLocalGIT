package com.testingproject.cctesting.hsqldb.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testingproject.cctesting.hsqldb.service.UserService;
import com.testingproject.cctesting.hsqldb.vo.UserRequest;
import com.testingproject.cctesting.hsqldb.vo.UserResponse;

@RestController
public class UserController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserService userservice;
	
	@PostMapping (path = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody UserRequest user){
		userservice.create(user);
	}
	
	@GetMapping (path = "/user/{name}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse query (@PathVariable String name){
		return userservice.get(name);
	}
	
	@DeleteMapping (path = "/userremove/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void delete (@PathVariable String name){
		userservice.delete(name);
	}
	
	
	
	
}
