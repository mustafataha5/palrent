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
import com.palrent.models.Offer;
import com.palrent.services.ApartmentService;
import com.palrent.services.OfferService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	OfferService offerService ; 
	
	
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
		model.addAttribute("exOffer",offerService.allOffernotIn(id));

		return "admin/apartment/editapartment.jsp";

	}

	@PatchMapping("/admins/apartment/{id}/edit")
	public String adminApartmentPatchPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("exOffer",offerService.allOffernotIn(id));
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
		EditedApartment.setDepartmentNum(apartment.getDepartmentNum());
		EditedApartment.setBuildingNum(apartment.getBuildingNum());
		EditedApartment.setStreet(apartment.getStreet());
		EditedApartment.setCity(apartment.getCity());
		apartmentService.updateApartment(EditedApartment);

		return "redirect:/admins/apartment";

	}
	@DeleteMapping("/admins/apartment/{id}/delete")
	public String deleteApartment(@PathVariable("id")Long id) {
		apartmentService.deleteApartment(id);
		return"redirect:/admins/apartment";
	}
	
	
	@PatchMapping("/admins/apartmet/{id}/AddOffer")
	public String addOffer(@PathVariable("id") Long Id ,@RequestParam("offerId")Long offerId ,Model model)
	{
		Department department = apartmentService.findById(Id);
		Offer offer = offerService.findOffer(offerId);
		department.getOffers().add(offer);
		apartmentService.updateApartment(department);
						
		return "redirect:/admins/apartment/"+Id+"/edit";
	}
	
	@DeleteMapping("/admins/apartmet/{id}/DelOffer")
	public String delOffer(@PathVariable("id") Long Id ,@RequestParam("offerId")Long offerId ,Model model)
	{
		Department department = apartmentService.findById(Id);
		Offer offer = offerService.findOffer(offerId);
		department.getOffers().remove(offer);
		apartmentService.updateApartment(department);
						
		return "redirect:/admins/apartment/"+Id+"/edit";
	}
	

}
