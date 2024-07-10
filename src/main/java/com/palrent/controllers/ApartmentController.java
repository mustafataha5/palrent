package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.palrent.models.Department;
import com.palrent.services.ApartmentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;

	@GetMapping("/admins/apartment")
	public String adminApartment(Model model) {
		model.addAttribute("apartments", apartmentService.findall());
		return "admin/apartment/adminapartment.jsp";
	}

	@GetMapping("/admins/apartment/new")
	public String adminApartmentMaping(@ModelAttribute("Apartment") Department apartment) {

		return "admin/apartment/newpartment.jsp";
	}

	@PostMapping("/admins/apartment/new")
	public String adminApartmentPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result) {
		if (result.hasErrors()) {
			return "admin/apartment/newpartment.jsp";
		}
		apartmentService.creatAdminApartment(apartment);

		return "redirect:/admins/apartment";
	}

	@GetMapping("/admins/apartment/{id}/edit")
	public String adminApartmentPutMapping(@PathVariable("id") Long id, Model model) {

		Department apartment = apartmentService.findById(id);
		model.addAttribute("Apartment", apartment);

		return "admin/apartment/editapartment.jsp";

	}

	@PatchMapping("/admins/apartment/{id}/edit")
	public String adminApartmentPatchPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			return "admin/apartment/editapartment.jsp";
		}
		Department EditedApartment = apartmentService.findById(id);
		EditedApartment.setNumOfRoom(apartment.getNumOfRoom());
		EditedApartment.setNumOfBath(apartment.getNumOfBath());
		EditedApartment.setNumOfBed(apartment.getNumOfBed());
		EditedApartment.setArea(apartment.getArea());
		EditedApartment.setNumOfGuest(apartment.getNumOfGuest());
		EditedApartment.setApproval(apartment.getApproval());
		EditedApartment.setPrice(apartment.getPrice());
		EditedApartment.setTitle(apartment.getTitle());
		EditedApartment.setDescription(apartment.getDescription());
		apartmentService.updateApartment(EditedApartment);

		return "redirect:/admins/apartment";

	}
	@DeleteMapping("/admins/apartment/{id}/delete")
	public String deleteApartment(@PathVariable("id")Long id) {
		apartmentService.deleteApartment(id);
		return"redirect:/admins/apartment";
	}
	

}
