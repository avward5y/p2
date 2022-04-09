package com.revature.p1.serv;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.p1.model.Users;
import com.revature.p1.repo.UsersRepo;


@Service
public class UsersServImpl implements UsersServ {
    
	@Autowired
	UsersRepo usersRepository;
                  
	@Override
	public Users userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return usersRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Users userLogout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.getById(id);
	}

	@Override
	public Users viewUser(String username) {
		// TODO Auto-generated method stub
		return usersRepository.findByUsername(username);
	}

	@Override
	public void add(Users users) {
		// TODO Auto-generated method stub
	usersRepository.save(users);	
	}

	@Override
	public void update(int id, Users users) {
		// TODO Auto-generated method stub
      usersRepository.save(users);		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Users getUser(Integer id) {
		// TODO Auto-generated method stub
		return usersRepository.getById(id);
	}

   
     
	
}

