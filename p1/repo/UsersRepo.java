package com.revature.p1.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.p1.model.Users;


public interface UsersRepo extends JpaRepository<Users, Integer> {

	public Users findByUsernameAndPassword(String username, String password);

	public Users findByUsername(String username);

	public Users getById(Integer id);
	

}

