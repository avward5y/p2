package com.revature.p1.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.p1.model.Users;
import com.revature.p1.serv.UsersServ;


@RestController
public class UsersControl {


    @Autowired
    private final UsersServ usersService;

    public UsersControl(UsersServ usersService) {
        this.usersService = usersService;
    }
    
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<Users> users = usersService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("users", new Users());
        return "users";
    }   

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Users user) {
    	usersService.add(user);
    	List<Users> users = usersService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users-data");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Users> users = usersService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("users", new Users());
        return "users";
   
    }
    @RequestMapping(path = "/find/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id) {
        Users users = (usersService).getUser(id);
        model.addAttribute("users", users);
        return "edit";
    
    }}
    

