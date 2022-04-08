package com.revature.p2.myp2.serv;

import java.util.List;

import com.revature.p2.myp2.model.Users;



public interface UsersServ {
	
	
	public List <Users> findAll();
	public Users findById(int id);
	public Users findByMobile(long mobile);
//	public List<Users> findAllByAccounts(int accountss);
	public List<Users> findAllByEmail(String email);
	public void add(Users id);
	public void updateUsers(int id, Users Users);
	public void deleteUsers(int id);
//	public Users getUser(int id);
	public void addUsers(Users user);
	public Users userLogin(String username, String password);
	public Users userLogout();
	public Users viewUser (String username);
	public List<Users> getUsers();

}
