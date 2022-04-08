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

import com.revature.p2.myp2.model.Users;
import com.revature.p2.myp2.serv.UsersServ;

@RestController
@RequestMapping("/")
public class UsersCtrl {

    @Autowired
	UsersServ usersServices;
	

	@GetMapping("/users")
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersServices.findAll();
	}
        
	
//	@GetMapping("/users/{id}")
//    	public Users getUser(@PathVariable int id ) {
//    		// TODO Auto-generated method stub
//    		return usersServices.getUser(id);
//    	}

	@GetMapping("/users/{id}")
	public Users findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return usersServices.findById(id);
	}

	@GetMapping("/users/email/{email}")
	public List<Users> findAllByEmail(@PathVariable String email) {
		// TODO Auto-generated method stub
		return usersServices.findAllByEmail(email);
	}

	@PostMapping("/users")
	public void addUsers(@RequestBody Users Users) {
		// TODO Auto-generated method stub
		usersServices.add(Users);
	}

	@PutMapping("/users/{id}")
	public void updateUsers(@PathVariable int id, @RequestBody Users Users) {
		// TODO Auto-generated method stub
		usersServices.updateUsers(id, Users);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUsers(int id) {
		// TODO Auto-generated method stub
		usersServices.deleteUsers(id);
	}

	@GetMapping("/users/mobile/{mobile}")
	public Users findByMobile(@PathVariable long mobile) {
		// TODO Auto-generated method stub
		return usersServices.findByMobile(mobile);
	}
	
//	@GetMapping("/register")
//	public String showRegistrationForm(Model model) {
//	    model.addAttribute("user", new Users());
//	     
//	    return "signup_form";
//	}

//	@PostMapping("/users/login")
//	public Users userLogin(@RequestBody String username, String password) {
//		// TODO Auto-generated method stub
//		return usersServices.userLogin(username, password);
//	}
//
//	@PostMapping("/users/logout")
//	public Users userLogout() {
//		// TODO Auto-generated method stub
//		return usersServices.userLogout();
//	}
//

}
//}
//  	
//    	
//        
//    	@Override
//    	public Users viewUser(String username) {
//    		// TODO Auto-generated method stub
//    		return UsersRepository.findByUsername(username);
// 
//    	@Override
//    	public List<Users> getUser() {
//    		// TODO Auto-generated method stub
//    		return UsersRepository.findAll();
//    	}
//    	
//    }

//    @RequestMapping(path = "/users", method = RequestMethod.GET)
//    public String getUser(Model model) {
//        List<Users> users = usersService.getUser();
//        model.addAttribute("users-data", users);
//        model.addAttribute("users", new Users());
//        return "users";
//    }
//
// 
//    @RequestMapping(path = "/users", method = RequestMethod.POST)
//    public ModelAndView save(@ModelAttribute Users user) {
//    	usersService.add(user);
//    	List<Users> users = usersService.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users-data");
//        modelAndView.addObject("users", users);
//        return modelAndView;
//    }
