package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.User;
import com.palrent.services.UserService;

import jakarta.validation.Valid;

@Controller
public class MustafaController {

	@Autowired
	UserService userService ;
	
	
	@GetMapping("/admins/user")
	public String showUser(Model model){
		model.addAttribute("users",userService.allUsers());
		return "admin/user/user.jsp";
	}
	
	@GetMapping("/admins/user/new")
	public String newUser(@ModelAttribute("newUser") User newUser){
		
		return "admin/user/new_user.jsp";
	}
	
	@PostMapping("/admins/user/new")
	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
			,BindingResult result
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/user/new_user.jsp";
		}
	
		newUser = userService.prepareUser(newUser);
		redirectAttributes.addAttribute("success", "Successfully added user");
		userService.createUser(newUser);
		
		return "redirect:/admins/user";
	}
	
}
