package com.palrent.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.services.ApartmentService;
import com.palrent.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	UserService userService ; 
	@Autowired
	ApartmentService apartmentService;
//	@GetMapping("/")
//	public String homePage(@ModelAttribute("newUser") User user,Model model,HttpSession session){
//		if(session.getAttribute("userId")==null) {
//			model.addAttribute("newLogin", new LoginUser());
//			return "main/home.jsp";
//		}
//		Long id = (long)session.getAttribute("userId"); 
//		model.addAttribute("user", userService.findUser(id) );
//		return "main/home.jsp";
//	}
	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
		 model.addAttribute("cities", apartmentService.cities);
		if(principal == null) {
			model.addAttribute("user", null);
	        return "main/home.jsp";
		}
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("apartments", apartmentService.findall());
        return "main/home.jsp";
    }


	@RequestMapping(value = {"/home2"})
    public String home2(Principal principal, Model model) {
        // 1
		 model.addAttribute("cities", apartmentService.cities);
		if(principal == null) {
			model.addAttribute("user", null);
	        return "main/home.jsp";
		}
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        //model.addAttribute("apartments",apartmentService.findall());
        return "main/home2.jsp";
    }
	
//	@GetMapping("/apartment")
//	public String getMethodName() {
//		return "apartment/apartmentdetails.jsp";
//		
//	}
	


	
	
	@PostMapping("/search")
	public String sreach(@RequestParam(value="city",required = false)String city
			,@RequestParam(value="start",required = false)String start
			,@RequestParam(value="end",required = false)String end
			,@RequestParam(value="guest",required = false)Integer guest
			,Model model
			,HttpSession session 
			,RedirectAttributes redirectAttributes) {
		
		if(city.equals("0") || guest == null) {
			
			redirectAttributes.addFlashAttribute("error","Need to enter Location and guest number");
			return "redirect:/";
		}
		
//		System.out.println(">>>>>>>>>>>>>"+apartmentService.search(city, guest).size());
		model.addAttribute("apartments", apartmentService.search(city, guest));
		model.addAttribute("cities", apartmentService.cities);
		return "main/home.jsp" ; 
	}
	
}
