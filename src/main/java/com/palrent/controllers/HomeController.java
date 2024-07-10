package com.palrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.palrent.models.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage(@ModelAttribute("newUser") User user) {
		return "main/home.jsp";
	}

	@GetMapping("/apartment")
	public String getMethodName() {
		return "apartment/apartmentdetails.jsp";
	}

}
