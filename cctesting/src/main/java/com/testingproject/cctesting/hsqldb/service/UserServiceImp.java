package com.testingproject.cctesting.hsqldb.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testingproject.cctesting.hsqldb.entity.User;
import com.testingproject.cctesting.hsqldb.repository.UserRepository;
import com.testingproject.cctesting.hsqldb.vo.UserRequest;
import com.testingproject.cctesting.hsqldb.vo.UserResponse;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void create(UserRequest userRequest){
		User user = new User();
		user.setAge(userRequest.getAge());
		user.setName(userRequest.getName());
		userRepo.save(user);
	}
	
	@Override
	public UserResponse get(String name){
		UserResponse userresponse = new UserResponse();
		userresponse.setId(userRepo.findByName(name) == null ? 0:userRepo.findByName(name).getId());
		userresponse.setAge(userRepo.findByName(name) == null ? 0:userRepo.findByName(name).getAge());
		userresponse.setName(userRepo.findByName(name) == null ? "Not Existing":userRepo.findByName(name).getName());
		return userresponse;
	}
	
	
	@Override
	public void delete(String name){
		userRepo.deleteByName(name);
	}
}
