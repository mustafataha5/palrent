package com.palrent.controllers;

import java.security.Principal;
import java.util.Iterator;

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
import com.palrent.models.Image;

import com.palrent.models.Offer;
import com.palrent.models.Rule;

import com.palrent.models.User;
import com.palrent.repositories.ImageRepository;
import com.palrent.services.ApartmentService;
import com.palrent.services.ImageSerivce;
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
	@Autowired
	ImageSerivce imageSerivce;

	@GetMapping("/user/apartment/new")
	public String getApartment(@ModelAttribute("Apartment") Department apartment, Principal principal, Model model) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
		String username = principal.getName();
		model.addAttribute("user", userService.findByUsername(username));
		return "user/apartment/newpartment.jsp";
	}

	@PostMapping("/user/apartment/new")
	public String addApartmentPosting(@Valid @ModelAttribute("Apartment") Department apartment, BindingResult result,
			Principal principal, Model model) {
//		if (result.hasErrors()) {
//			return "user/apartment/newpartment.jsp";
//		}
		String username = principal.getName();

		User user = userService.findByUsername(username);
		apartment.setOwner(user);

		apartmentService.creatAdminApartment(apartment);
		Image img = new Image(
				"https://images.pexels.com/photos/1918291/pexels-photo-1918291.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		img.setDepartment(apartment);
		imageSerivce.createImage(img);

		img = (new Image(
				"https://images.pexels.com/photos/5502218/pexels-photo-5502218.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
		img.setDepartment(apartment);
		imageSerivce.createImage(img);

		img = (new Image(
				"https://images.pexels.com/photos/1571468/pexels-photo-1571468.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
		img.setDepartment(apartment);
		imageSerivce.createImage(img);

		return "redirect:/user/apartment";
	}

	@GetMapping("/user/apartment")
	public String showUserApartment(Principal principal, Model model) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "user/apartment/apartment.jsp";
	}

	@GetMapping("/user/apartment/{id}/edit")
	public String userApartmentPutMapping(@PathVariable("id") Long id, Model model, Principal principal) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		System.out.println(">>>>>>>>>>>>>>>>>>>");
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		
		Department apartment = apartmentService.findById(id);
		model.addAttribute("Apartment", apartment);
		model.addAttribute("exOffer", offerService.allOffernotIn(id));
		model.addAttribute("exRule", ruleServices.allRulenotIn(id));
		System.out.println(">>>>>>>>>>>>>>>>>>> end edit");
		return "user/apartment/editapartment.jsp";

	}

	@PatchMapping("/user/apartment/{id}/edit")
	public String userApartmentPatchPosting(@Valid @ModelAttribute("Apartment") Department apartment,
			BindingResult result, @PathVariable("id") Long id, Model model, Principal principal) {
		if (result.hasErrors()) {
			model.addAttribute("exOffer", offerService.allOffernotIn(id));
			return "user/apartment/editapartment.jsp";
		}
//		model.addAttribute("user", userService.findUser((Long) session.getAttribute("userId")));
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);

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
		Department dep1 = apartmentService.findById(id);
		for (Image i : dep1.getImages()) {
			i.setDepartment(null);
			imageSerivce.update(i);

		}

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
	public String addRule(@PathVariable("id") Long Id, @RequestParam(value = "ruleId", required = false) Long ruleId,
			Model model) {
		if (ruleId == null) {
			return "redirect:/user/apartment/" + Id + "/edit";
		}
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().add(rule);
		apartmentService.updateApartment(department);

		return "redirect:/user/apartment/" + Id + "/edit";
	}

	@DeleteMapping("/user/apartmet/{id}/DelRule")
	public String delRule(@PathVariable("id") Long Id, @RequestParam("ruleId") Long ruleId, Model model) {
		Department department = apartmentService.findById(Id);
		Rule rule = ruleServices.findRule(ruleId);
		department.getRules().remove(rule);
		apartmentService.updateApartment(department);

		return "redirect:/user/apartment/" + Id + "/edit";
	}

}
