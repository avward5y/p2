package com.revature.p2.myp2.ctrl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.revature.p2.myp2.model.User;
import com.revature.p2.myp2.serv.UserServ;

@RestController
@RequestMapping("/")
public class UsersCtrl {

    @Autowired
	UserServ userServices;
	

	@GetMapping("/users")
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userServices.findAll();
	}
        

	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return userServices.findById(id);
	}

	@GetMapping("/users/{email}")
	public List<User> findAllByEmail(@PathVariable String email) {
		// TODO Auto-generated method stub
		return userServices.findByEmail(email);
	}

	@PostMapping("/users")
	public void addUsers(@RequestBody User Users) {
		// TODO Auto-generated method stub
		userServices.add(Users);
	}
	
	@GetMapping("/users/logout")
	public User userLogout() {
		return new User();
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User Users) {
		// TODO Auto-generated method stub
		userServices.addUser(Users);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		userServices.deleteUser(id);
	}

	@GetMapping("/users/{mobile}")
	public List <User> findByMobile(@PathVariable long mobile) {
		// TODO Auto-generated method stub
		return userServices.findByMobile(mobile);
	}
	
}	

