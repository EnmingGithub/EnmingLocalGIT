package com.testingproject.cctesting.hsqldb.service;
import java.util.*;

import com.testingproject.cctesting.hsqldb.entity.User;
import com.testingproject.cctesting.hsqldb.vo.UserRequest;
import com.testingproject.cctesting.hsqldb.vo.UserResponse;
public interface UserService {

	public void create(UserRequest user);
	public UserResponse get(String name);
	public void delete(String name);
}
