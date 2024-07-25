package com.palrent.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palrent.services.UserService;

@Controller
public class AboutUsController {
@Autowired UserService userService;	

	
@GetMapping("/about")
public String home2(Principal principal, Model model) {
	if(principal == null) {
		model.addAttribute("user", null);
        return "aboutus.jsp";
	}
    String username = principal.getName();
    model.addAttribute("user", userService.findByUsername(username));
	        return "aboutus.jsp";
		}

}
