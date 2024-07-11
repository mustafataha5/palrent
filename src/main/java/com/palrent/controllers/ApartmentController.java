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
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller
public class ApartmentController {
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	OfferService offerService;
	@Autowired
	UserService userService;
	@Autowired
	RuleServices ruleServices;

	@GetMapping("/user/apartment/new")
	public String getApartment(@ModelAttribute("Apartment") Department apartment, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "user/apartment/newpartment.jsp";
	}

	@PostMapping("/user/apartment/new")
	public String addApartmentPosting(@Valid @ModelAttribute("Apartment") Department apartment, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "user/apartment/newpartment.jsp";
		}
		User user = userService.findUser((Long) session.getAttribute("userId"));
		apartment.setOwner(user);
		System.out.println(">>>>>>>>>>" + user.getEmail());
		apartmentService.creatAdminApartment(apartment);

		return "redirect:/user/apartment";
	}

	@GetMapping("/user/apartment")
	public String showUserApartment(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		return "user/apartment/apartment.jsp";
	}

	@GetMapping("/user/apartment/{id}/edit")
	public String userApartmentPutMapping(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Department apartment = apartmentService.findById(id);
		model.addAttribute("Apartment", apartment);
		model.addAttribute("exOffer", offerService.allOffernotIn(id));
		model.addAttribute("exRule", ruleServices.allRulenotIn(id));

		return "/user/apartment/editapartment.jsp";

	}

	@PatchMapping("/user/apartment/{id}/edit")
	public String userApartmentPatchPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("exOffer", offerService.allOffernotIn(id));
			return "user/apartment/editapartment.jsp";
		}
		Department EditedApartment = apartmentService.findById(id);
		EditedApartment.setNumOfRoom(apartment.getNumOfRoom());
		EditedApartment.setNumOfBath(apartment.getNumOfBath());
		EditedApartment.setNumOfBed(apartment.getNumOfBed());
		EditedApartment.setArea(apartment.getArea());
		EditedApartment.setNumOfGuest(apartment.getNumOfGuest());
		EditedApartment.setPrice(apartment.getPrice());
		EditedApartment.setTitle(apartment.getTitle());
		EditedApartment.setDescription(apartment.getDescription());
		EditedApartment.setDepartmentNum(apartment.getDepartmentNum());
		EditedApartment.setBuildingNum(apartment.getBuildingNum());
		EditedApartment.setStreet(apartment.getStreet());
		EditedApartment.setCity(apartment.getCity());
		apartmentService.updateApartment(EditedApartment);

		return "redirect:/user/apartment";

	}

	@DeleteMapping("/user/apartment/{id}/delete")
	public String deleteUserApartment(@PathVariable("id") Long id) {
		apartmentService.deleteApartment(id);
		return "redirect:/user/apartment";
	}

	@PatchMapping("/user/apartment/{id}/AddOffer")
	public String addOffer(@PathVariable("id") Long Id, @RequestParam(value = "offerId", required = false) Long offerId,
			Model model) {
		if (offerId == null) {
			return "redirect:/user/apartment/" + Id + "/edit";
		}
		Department department = apartmentService.findById(Id);
		Offer offer = offerService.findOffer(offerId);
		department.getOffers().add(offer);
		apartmentService.updateApartment(department);

		return "redirect:/user/apartment/" + Id + "/edit";
	}

	@DeleteMapping("/user/apartmet/{id}/DelOffer")
	public String delOffer(@PathVariable("id") Long Id, @RequestParam("offerId") Long offerId, Model model) {
		Department department = apartmentService.findById(Id);
		Offer offer = offerService.findOffer(offerId);
		department.getOffers().remove(offer);
		apartmentService.updateApartment(department);

		return "redirect:/user/apartment/" + Id + "/edit";
	}


	@PatchMapping("/user/apartmet/{id}/AddRule")
	public String addRule(@PathVariable("id") Long Id ,@RequestParam(value ="ruleId", required = false)Long ruleId ,Model model)
	{
		if (ruleId == null) {
			return "redirect:/user/apartment/" + Id + "/edit";
		}
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().add(rule);
		apartmentService.updateApartment(department);
						
		return "redirect:/user/apartment/"+Id+"/edit";
	}
	
	@DeleteMapping("/user/apartmet/{id}/DelRule")
	public String delRule(@PathVariable("id") Long Id ,@RequestParam("ruleId")Long ruleId ,Model model)
	{
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().remove(rule);
		apartmentService.updateApartment(department);
						
		return "redirect:/user/apartment/"+Id+"/edit";
	}
	
	
}
