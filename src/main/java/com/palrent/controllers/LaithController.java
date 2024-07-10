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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.Offer;
import com.palrent.models.User;
import com.palrent.services.OfferService;

import jakarta.validation.Valid;

@Controller
public class LaithController {
	@Autowired
	OfferService offerservice;

	@GetMapping("/admins/offer")
	public String showOffer(Model model) {
		model.addAttribute("offers", offerservice.allOffers());
		return "admin/offer/offer.jsp";
	}

	@GetMapping("/admins/offer/new")
	public String shownewOffer(@ModelAttribute("newOffer") Offer newOffer) {

		return "admin/offer/newoffer.jsp";
	}

	@GetMapping("/admins/offer/{id}/edit")
	public String showEditOffer(@PathVariable("id") Long id, Model model) {
		Offer editOffer = offerservice.findOffer(id);
		model.addAttribute("editOffer", editOffer);
		return "admin/offer/edit.jsp";
	}
	
	@PostMapping("/admins/offer/new")
	public String newOffer(@Valid@ModelAttribute("newOffer") Offer newOffer,BindingResult result) {
		if (result.hasErrors()) {
			
			return "admin/offer/newoffer.jsp";
		}
		offerservice.createOffer(newOffer);
		return "redirect:/admins/offer";
	}
	@PatchMapping("/admins/offer/{id}/edit")
	public String EditOffer(@Valid @ModelAttribute("editOffer")Offer editOffer
			,BindingResult result
			,@PathVariable("id") Long id 
			,Model model
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/offer/offer.jsp";
		}
		redirectAttributes.addAttribute("success", "Successfully update offer");
		offerservice.updateOffer(editOffer);
		return "redirect:/admins/offer";
	}
	
	@DeleteMapping("/admins/offer/{id}/delete")
	public String deleteOffer(@PathVariable("id") Long id ) {
		offerservice.deleteOffer(id);
		
		return "redirect:/admins/offer";
	}

}
