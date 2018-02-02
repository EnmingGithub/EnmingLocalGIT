package com.testingproject.cctesting.hsqldb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testingproject.cctesting.hsqldb.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
	@Modifying
	@Query("delete from User as U where U.name = ?1") 
	void deleteByName(String name);
}
