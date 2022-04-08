package com.revature.p2.myp2.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.p2.myp2.model.Users;
import com.revature.p2.myp2.repo.UsersRepo;

@Service
public class UsersServImpl implements UsersServ {
   
	
	@Autowired
	UsersRepo UsersRepository;

	@Override
	public List<Users> findAll() {
// TODO Auto-generated method stub
		return UsersRepository.findAll();
	}

//	@Override
//	public Users getUser(int id) {
//		// TODO Auto-generated method stub
//		return UsersRepository.getUser(id);
//	}

	@Override
	public Users findById(int id) {
// TODO Auto-generated method stub
		return UsersRepository.findById(id).get();
	}

	@Override
	public List<Users> findAllByEmail(String email) {
// TODO Auto-generated method stub
		return UsersRepository.findAllByEmail(email);
	}

	@Override
	public void addUsers(Users Users) {
// TODO Auto-generated method stub
		UsersRepository.save(Users);
	}

	@Override
	public void updateUsers(int id, Users Users) {
// TODO Auto-generated method stub
		UsersRepository.save(Users);
	}

	@Override
	public void deleteUsers(int id) {
// TODO Auto-generated method stub
		UsersRepository.deleteById(id);
	}

	@Override
	public Users findByMobile(long mobile) {
		// TODO Auto-generated method stub
		return UsersRepository.findAllByMobile(mobile);
	}

//	@Override
//	public List<Users> findAllByAccounts(int id  ){
//		// TODO Auto-generated method stub
//		return UsersRepository.findAll();
//	}

	@Override
	public Users userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return UsersRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Users userLogout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users viewUser(String username) {
		// TODO Auto-generated method stub
		return UsersRepository.findByUsername(username);
	}

	@Override
	public void add(Users id) {
		// TODO Auto-generated method stub
		UsersRepository.save(id);
	}

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return UsersRepository.findAll();
	}

}
