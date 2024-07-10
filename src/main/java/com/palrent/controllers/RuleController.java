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
import com.palrent.models.Rule;
import com.palrent.services.RuleServices;

import jakarta.validation.Valid;

@Controller
public class RuleController {
	@Autowired
	RuleServices ruleservices;
	
	@GetMapping("/admins/rule")
	public String showRule(Model model) {
		model.addAttribute("rules", ruleservices.allRules());
		return "admin/rule/rule.jsp";
	}
	
	@GetMapping("/admins/rule/new")
	public String shownewRule(@ModelAttribute("newRule") Rule newRule) {

		return "admin/rule/newrule.jsp";
	}
	
	@GetMapping("/admins/rule/{id}/edit")
	public String showEditRule(@PathVariable("id") Long id, Model model) {
		Rule editRule = ruleservices.findRule(id);
		model.addAttribute("editRule", editRule);
		return "admin/rule/edit_rule.jsp";
	}
	
	@PostMapping("/admins/rule/new")
	public String newRule(@Valid@ModelAttribute("newRule") Rule newRule,BindingResult result) {
		if (result.hasErrors()) {
			
			return "admin/rule/newrule.jsp";
		}
		ruleservices.createRule(newRule);
		return "redirect:/admins/rule";
	}
	
	@PatchMapping("/admins/rule/{id}/edit")
	public String EditOffer(@Valid @ModelAttribute("editRule")Rule editRule
			,BindingResult result
			,@PathVariable("id") Long id 
			,Model model
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/rule/edit_rule.jsp";
		}
		redirectAttributes.addAttribute("success", "Successfully update rule");
		ruleservices.updateRule(editRule);
		return "redirect:/admins/rule";
	}
	
	@DeleteMapping("/admins/rule/{id}/delete")
	public String deleteRule(@PathVariable("id") Long id ) {
		ruleservices.deleteRule(id);
		
		return "redirect:/admins/rule";
	}
	
	

}
