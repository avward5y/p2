package com.revature.p2.myp2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.p2.myp2.model.Users;


public interface UsersRepo extends JpaRepository <Users , Integer>{
	
	
//	List<Users> findAllUsers(Integer id, String accounts);
	
	List<Users> findAllByEmail(String email);
	
	Users findAllByMobile(long mobile);
	
//	List<Users> findByAccountss(Integer accountss);
 
	Users findByUsername(String username);

	Users findByUsernameAndPassword(String username, String password);

//    Users getUser (int id);
}
