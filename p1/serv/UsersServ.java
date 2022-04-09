package com.revature.p1.serv;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.revature.p1.model.Users;


public interface UsersServ {
	
	
	public Users userLogin(String username, String password);
	public Users userLogout();
	public Users findById(int id);
	public Users viewUser (String username);
	public void add(Users users);
	public void update (int id, Users users);
	public void deleteById(int id);
	public List<Users> findAll();
	public Users getUser(Integer id);
   }


