package com.revature.p2.myp2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.p2.myp2.model.User;


public interface UserRepo extends JpaRepository <User , Integer>{
	

	
	List<User> findByEmail(String email);
	List<User> findByMobile(long mobile);
	
 
	User findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

}
