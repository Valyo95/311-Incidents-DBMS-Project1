package com.incidents.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.incidents.entities.MyUser;

@Repository
public interface UserDAO extends JpaRepository<MyUser, Long>{

	MyUser findByUsername(String username);
	MyUser findById(long id);
	List<MyUser> findByEmail(String email);
	List<MyUser> findByFirstNameContaining(String place);
	List<MyUser> findByLastNameContaining(String place);
	List<MyUser> findByEmailContaining(String place);
	
}
