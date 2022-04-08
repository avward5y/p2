package com.revature.p2.myp2.ctrl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexCtrl {
	
    
	
	@GetMapping("/")
	public String  viewHomePage() {
	
	return "index";}
}