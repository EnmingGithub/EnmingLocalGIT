package com.testingproject.cctesting.hsqldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testingproject.cctesting.hsqldb.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByid(Long id);
}
