package com.revature.p2.myp2.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.revature.p2.myp2.model.Status;
import com.revature.p2.myp2.model.User;
import com.revature.p2.myp2.repo.UserRepo;

import java.util.List;



@RestController
public class LogCtrl {

	@Autowired
	UserRepo usersRepository;

	@PostMapping("/users/register")
	public Status registerUser(@Validated @RequestBody User newUser) {
		List<User> users = usersRepository.findAll();
		System.out.println("New user: " + newUser.toString());
		for (User user : users) {
			System.out.println("Registered user: " + newUser.toString());
			if (user.equals(newUser)) {
				System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}
		usersRepository.save(newUser);
		return Status.SUCCESS;
	}

	@PostMapping("/users/login")
	public Status loginUser(@Validated @RequestBody User user) {
		List<User> users = usersRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				user.setActive(true);
				usersRepository.save(user);
				return Status.SUCCESS;
			}
			
		}
		
		
		return Status.FAILURE;
	}

	@PostMapping("/users/logout")
	public Status logUserOut(@Validated @RequestBody User user) {
		List<User> users = usersRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				user.setActive(false);
				usersRepository.save(user);
				return Status.SUCCESS;
			}
		}
		return Status.SUCCESS;
	}

	@DeleteMapping("/users/all")
	public Status deleteUser() {
		usersRepository.deleteAll();
		return Status.SUCCESS;
	}
}
