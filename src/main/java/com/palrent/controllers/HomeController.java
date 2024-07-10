package com.palrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "main/home.jsp";
		}
	

}
