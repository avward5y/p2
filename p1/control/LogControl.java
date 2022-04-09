package com.revature.p1.control;

import java.util.Objects;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.p1.model.Users;
import com.revature.p1.serv.UsersServ;


@RestController
public class LogControl {

	@Autowired
	UsersServ userService;

	@RequestMapping("users")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("users", new User());
		return mav;
	}
	@PostMapping("users/login")
	public String login(@ModelAttribute("users") Users users) {
		Users oauthUser = userService.userLogin(users.getUsername(), users.getPassword());
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {
			return "users/login";
		} else {
			return "redirect:EmpLog.html";
		}
	}
	
}


