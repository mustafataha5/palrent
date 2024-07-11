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
import com.palrent.models.Rule;
import com.palrent.models.User;
import com.palrent.services.ApartmentService;
import com.palrent.services.OfferService;
import com.palrent.services.RuleServices;
import com.palrent.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.Session;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	OfferService offerService ; 
	@Autowired
	UserService userService ; 
	@Autowired
	RuleServices ruleServices ; 
	
	
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

	@GetMapping("apartment/new")
	public String getApartment(@ModelAttribute("Apartment") Department apartment,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "user/apartment/newpartment.jsp";
	}

	@PostMapping("/apartment/new")
	public String addApartmentPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result
			,HttpSession session) {
		if (result.hasErrors()) {
			return "user/apartment/newpartment.jsp";
		}
		User user = userService.findUser((long) session.getAttribute("userId"));
		apartment.setOwner(user);
		apartmentService.creatAdminApartment(apartment);

		return "redirect:/user/apartment";
	}
	
	@GetMapping("/admins/apartment/{id}/edit")
	public String adminApartmentPutMapping(@PathVariable("id") Long id, Model model) {

		Department apartment = apartmentService.findById(id);
		model.addAttribute("Apartment", apartment);
		model.addAttribute("exOffer",offerService.allOffernotIn(id));
		model.addAttribute("exRule",ruleServices.allRulenotIn(id));

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
	
	
	@PatchMapping("/admins/apartmet/{id}/AddRule")
	public String addRule(@PathVariable("id") Long Id ,@RequestParam("ruleId")Long ruleId ,Model model)
	{
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().add(rule);
		apartmentService.updateApartment(department);
						
		return "redirect:/admins/apartment/"+Id+"/edit";
	}
	
	@DeleteMapping("/admins/apartmet/{id}/DelRule")
	public String delRule(@PathVariable("id") Long Id ,@RequestParam("ruleId")Long ruleId ,Model model)
	{
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().remove(rule);
		apartmentService.updateApartment(department);
						
		return "redirect:/admins/apartment/"+Id+"/edit";
	}

}
