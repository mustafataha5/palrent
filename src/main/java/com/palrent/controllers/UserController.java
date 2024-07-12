package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.services.UserService;
import com.palrent.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
private UserService userService;
    
    // NEW
    private UserValidator userValidator;
    
    // NEW
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	
	
<<<<<<< HEAD
//	@PostMapping("/user/new")
//	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
//			,BindingResult result
//			,HttpSession session, Model model 
//			,RedirectAttributes redirectAttributes){
//		newUser = userService.prepareUser(newUser,result);
//		if(result.hasErrors()) {
//			model.addAttribute("newLogin", new LoginUser());
//			return "main/regiter.jsp";
//		}
////		redirectAttributes.addAttribute("success", "Successfully added user");
//		User user = userService.createUser(newUser);
//		session.setAttribute("userId", user.getId());
//		return "redirect:/";
//		
//	}
	@GetMapping("/register")
	public String register(@ModelAttribute("newUser") User newUser) {
=======
	@PostMapping("/user/new")
	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
			,BindingResult result
			,HttpSession session, Model model 
			,RedirectAttributes redirectAttributes){
		newUser = userService.prepareUser(newUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());

			return "main/register.jsp";


		}
//		redirectAttributes.addAttribute("success", "Successfully added user");
		User user = userService.createUser(newUser);
		session.setAttribute("userId", user.getId());
		return "redirect:/";
>>>>>>> master
		
		return "main/register.jsp";
	}
	
	
	 @PostMapping("/register")
	    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
	       userValidator.validate(user, result);
		 	if (result.hasErrors()) {
	            return "main/register.jsp";
	        }
	       // userService.saveWithUserRole(user);
	       userService.saveUserWithAdminRole(user);
		 	return "redirect:/login";
	    }
	 
	 @RequestMapping("/login")
	    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
	        if(error != null) {
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successful!");
	        }
	        return "main/login.jsp";
	    }
	
	
	
//	@GetMapping("/logout")
//	public  String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}

}
