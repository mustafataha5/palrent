package com.palrent.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.palrent.services.UserService;

@Controller
public class ContactController {
	@Autowired
	UserService userService ; 
	
	@GetMapping("/contactus")
	public String contact(Principal principal, Model model) {
		if(principal == null) {
			model.addAttribute("user", null);
	        return "main/contactus.jsp";
		}
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
		        return "main/contactus.jsp";
			}

	}

