package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService ; 
	
	
	@PostMapping("/user/new")
	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
			,BindingResult result
			,HttpSession session, Model model 
			,RedirectAttributes redirectAttributes){
		newUser = userService.prepareUser(newUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "main/regiter.jsp";
		}
//		redirectAttributes.addAttribute("success", "Successfully added user");
		User user = userService.createUser(newUser);
		session.setAttribute("userId", user.getId());
		return "redirect:/";
		
	}
	
	@PostMapping("/user/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser
			, BindingResult result
			, Model model
			,HttpSession session) {
		
		User user = userService.login(loginUser, result);
		if (user == null) {
			model.addAttribute("newUser", new User());
			return "redirect:/";
		}
		//System.out.println(">>>>>>"+user.getId());
		session.setAttribute("userId", user.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public  String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
