package com.revature.p2.myp2.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.p2.myp2.model.User;
import com.revature.p2.myp2.repo.UserRepo;

@Service
public class UserServImpl implements UserServ {
   
	
	@Autowired
	UserRepo UserRepository;

	@Override
	public List<User> findAll() {
// TODO Auto-generated method stub
		return UserRepository.findAll();
	}

//	@Override
//	public User getUser(int id) {
//		// TODO Auto-generated method stub
//		return UserRepository.getUser(id);
//	}

	@Override
	public User findById(int id) {
// TODO Auto-generated method stub
		return UserRepository.findById(id).get();
	}

	@Override
	public List<User> findByEmail(String email) {
// TODO Auto-generated method stub
		return UserRepository.findByEmail(email);
	}

	@Override
	public void addUser(User User) {
// TODO Auto-generated method stub
		UserRepository.save(User);
	}

	@Override
	public void updateUser(int id, User User) {
// TODO Auto-generated method stub
		UserRepository.save(User);
	}

	@Override
	public void deleteUser(Integer id) {
// TODO Auto-generated method stub
		UserRepository.deleteById(id);
	}

	@Override
	public List<User> findByMobile(long mobile) {
		// TODO Auto-generated method stub
		return UserRepository.findByMobile(mobile);
	}

//	@Override
//	public List<User> findAllByAccounts(int id  ){
//		// TODO Auto-generated method stub
//		return UserRepository.findAll();
//	}

	@Override
	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public void userLogout() {
		// TODO Auto-generated method stub
	  UserRepository.findAll();
	}

	@Override
	public User viewUser(String username) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsername(username);
	}

	@Override
	public void add(User id) {
		// TODO Auto-generated method stub
		UserRepository.save(id);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return UserRepository.findAll();
	}

}
