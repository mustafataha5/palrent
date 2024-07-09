package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.palrent.models.Department;
import com.palrent.services.ApartmentService;

import jakarta.validation.Valid;


@Controller
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@GetMapping("/admins/apartment")
	public String adminApartment(Model model) {
		model.addAttribute("apartments",apartmentService.findall());
		return "admin/apartment/adminapartment.jsp";
	}

	@GetMapping("/admins/apartment/new")
	public String adminApartmentMaping(@ModelAttribute("Apartment") Department apartment ) {
		

		return "admin/apartment/newpartment.jsp";
	}
	
	@PostMapping("/admins/apartment/new")
	public String adminApartmentPosting(@Valid@ModelAttribute("Apartment") Department apartment ,BindingResult result) {
		if(result.hasErrors()) {
		return	"admin/apartment/newpartment.jsp";
		}
		apartmentService.creatAdminApartment(apartment);

		return "redirect:/admins/apartment";
	}

}
