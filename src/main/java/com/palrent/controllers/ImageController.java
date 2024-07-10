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

import com.palrent.models.Image;
import com.palrent.services.ImageServices;

import jakarta.validation.Valid;

@Controller
public class ImageController {
	@Autowired
	ImageServices imageservices;
	
	@GetMapping("/admins/image")
	public String showImage(Model model) {
		model.addAttribute("images", imageservices.allImage());
		return "admin/image/image.jsp";
	}
	
	@GetMapping("/admins/image/new")
	public String shownewImage(@ModelAttribute("newImage") Image newImage) {

		return "admin/image/newimage.jsp";
	}
	
	@GetMapping("/admins/image/{id}/edit")
	public String showEditImage(@PathVariable("id") Long id, Model model) {
		Image editImage = imageservices.findImage(id);
		model.addAttribute("editImage", editImage);
		return "admin/image/editimage.jsp";
	}
	
	@PostMapping("/admins/image/new")
	public String newImage(@Valid@ModelAttribute("newRule") Image newImage,BindingResult result) {
		if (result.hasErrors()) {
			
			return "admin/image/newimage.jsp";
		}
		imageservices.createImage(newImage);
		return "redirect:/admins/image";
	}
	
	@PatchMapping("/admins/image/{id}/edit")
	public String EditImage(@Valid @ModelAttribute("editImage")Image editImage
			,BindingResult result
			,@PathVariable("id") Long id 
			,Model model
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/image/editimage.jsp";
		}
		redirectAttributes.addAttribute("success", "Successfully update image");
		imageservices.updateImage(editImage);
		return "redirect:/admins/image";
	}
	@DeleteMapping("/admins/image/{id}/delete")
	public String deleteImage(@PathVariable("id") Long id ) {
		imageservices.deleteImage(id);
		return "redirect:/admins/image";
	}
	
	
}
