package com.palrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	@GetMapping("/contactus")
	public String contact() {
	      
		        return "main/contactus.jsp";
			}

	}

