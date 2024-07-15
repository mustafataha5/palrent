package com.palrent.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.Booking;
import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.services.ApartmentService;
import com.palrent.services.BookingService;
import com.palrent.services.UserService;
import com.palrent.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	private UserService userService;
	
	// NEW
	private UserValidator userValidator;
	private BookingService bookingService ; 
	private ApartmentService apartmentService ; 
	// NEW
	public UserController(UserService userService, UserValidator userValidator
			,BookingService bookingService , ApartmentService apartmentService ) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.bookingService = bookingService ;
		this.apartmentService = apartmentService ;
	}

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

		return "main/register.jsp";
	}

	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,
			HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "main/register.jsp";
		}
		// userService.saveWithUserRole(user);
		userService.saveUserWithAdminRole(user);

		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "main/login.jsp";
	}

	@GetMapping("/user/info/{id}")
	public String userinfo(@PathVariable("id") Long id, Model model ,Principal principal) {

		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);

		model.addAttribute("user", userService.findUser(id));
		
		return "user/Userinfo.jsp";
	}
	
	@GetMapping("/user/booking/{id}")
	public String showBooking(@PathVariable("id")Long id,Model model,Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("booking", bookingService.findBooking(id));
		return "apartment/booking_edit.jsp";
	}
	
	@PatchMapping("/user/booking/{id}")
	public String updateBooking(@PathVariable("id")Long id
			,@RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkin , 
			@RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date checkout ,
			Model model,Principal principal
			,RedirectAttributes redirectAttributes 
			) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		Booking booking = bookingService.findBooking(id) ;
		if(checkin.after(checkout)) {
			redirectAttributes.addFlashAttribute("error_q","Check-In must be before Check-Out ");
			return "redirect:/user/booking/"+booking.getId();
		}
		//System.out.println(">>>>>>>>>>>>>>>>"+apartmentService.search3(booking.getDepartment().getId(),new java.sql.Date( checkin.getTime()), new java.sql.Date(checkout.getTime())).size());
		if(apartmentService.search3(booking.getDepartment().getId(),new java.sql.Date( checkin.getTime()), new java.sql.Date(checkout.getTime())).size() == 0) {
			redirectAttributes.addFlashAttribute("error_q","conflect with other  ");
			return "redirect:/user/booking/"+booking.getId();
		}
		booking.setStartDate(checkin);
		booking.setEndDate(checkout);
		bookingService.updateBooking(booking);
		return "redirect:/user/info/"+user.getId();
	}
	
	@DeleteMapping("/user/booking/{id}")
	public String deleteBooking(@PathVariable("id")Long id,Model model,Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username);
		Booking booking = bookingService.findBooking(id) ;
		booking.setUser(null);
		booking.setDepartment(null);
		bookingService.deleteBooking(id);
		return "redirect:/user/info/"+user.getId();
	}
	
//	@GetMapping("/logout")
//	public  String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}

}
