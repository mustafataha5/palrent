package com.palrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Ibrahim {

	@GetMapping("/userinfo")
	public String getMethodName() {
		return "user/Userinfo.jsp";
	}
	
}