package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	UserService userService ; 
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("newUser") User user,Model model,HttpSession session){
		if(session.getAttribute("userId")==null) {
			model.addAttribute("newLogin", new LoginUser());
			return "main/home.jsp";
		}
		Long id = (long)session.getAttribute("userId"); 
		model.addAttribute("user", userService.findUser(id) );
		return "main/home.jsp";
	}

	@GetMapping("/apartment")
	public String getMethodName() {
		return "apartment/apartmentdetails.jsp";
		
	}
	@GetMapping("/register")
	public String register() {
		
		return "main/register.jsp";
	}
	@GetMapping("/login")
	public String logIn() {
		
		return "main/login.jsp";
	}

}
