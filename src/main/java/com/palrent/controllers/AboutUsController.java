package com.palrent.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
	

	
@GetMapping("/aboutus")
public String home2() {
      
	        return "aboutus.jsp";
		}

}
