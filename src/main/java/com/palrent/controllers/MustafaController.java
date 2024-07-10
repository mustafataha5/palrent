package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/admins/user/{id}/edit")
	public String showEditUser(@PathVariable("id")Long id ,Model model){
		User editUser = userService.findUser(id);
		editUser.setConfirm("test");
		model.addAttribute("editUser",editUser );
		return "admin/user/edit_user.jsp";
	}
	
	
	@PostMapping("/admins/user/new")
	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
			,BindingResult result
			,RedirectAttributes redirectAttributes){
		newUser = userService.prepareUser(newUser,result);
		if(result.hasErrors()) {
			return "admin/user/new_user.jsp";
		}
	
		
		redirectAttributes.addAttribute("success", "Successfully added user");
		userService.createUser(newUser);
		
		return "redirect:/admins/user";
	}
	
	@PatchMapping("/admins/user/{id}/edit")
	public String EditUser(@Valid @ModelAttribute("editUser")User editUser
			,BindingResult result
			,@PathVariable("id") Long id 
			,Model model
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/user/edit_user.jsp";
		}
	
		
		redirectAttributes.addAttribute("success", "Successfully update user");
		userService.updateUser(editUser);
		return "redirect:/admins/user";
	}
	
}
