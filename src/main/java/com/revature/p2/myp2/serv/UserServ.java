package com.revature.p2.myp2.serv;

import java.util.List;

import com.revature.p2.myp2.model.User;



public interface UserServ {
	
	
	public List <User> findAll();
	public User findById(int id);
	public List<User> findByMobile(long mobile);
//	public List<User> findAllByAccounts(int accountss);
	public List<User> findByEmail(String email);
	public void add(User id);
	public void updateUser(int id, User User);
	public void deleteUser(Integer id);
//	public User getUser(int id);
	public void addUser(User user);
	public User userLogin(String username, String password);
	public void userLogout();
	public User viewUser (String username);
	public List<User> getUser();

}
