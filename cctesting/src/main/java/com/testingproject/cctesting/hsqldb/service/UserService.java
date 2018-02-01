package com.testingproject.cctesting.hsqldb.service;
import java.util.*;

import com.testingproject.cctesting.hsqldb.entity.User;
import com.testingproject.cctesting.hsqldb.vo.UserRequest;
import com.testingproject.cctesting.hsqldb.vo.UserResponse;
public interface UserService {

	public void create(UserRequest user);
	public List<User> getAll();
	public UserResponse get(Long id);
	public void delete(Long id);
}
