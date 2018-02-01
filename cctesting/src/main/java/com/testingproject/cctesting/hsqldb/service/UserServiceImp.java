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
	public UserResponse get(Long id){
		UserResponse userresponse = new UserResponse();
		userresponse.setId(id);
		userresponse.setAge(userRepo.findByid(id).getAge());
		userresponse.setName(userRepo.findByid(id).getName());
		return userresponse;
	}
	
	@Override
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	@Override
	public void delete(Long id){
		userRepo.delete(id);
	}
}
