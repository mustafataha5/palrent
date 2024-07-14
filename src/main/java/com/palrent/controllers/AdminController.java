package com.palrent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.palrent.models.Booking;
import com.palrent.models.Department;
import com.palrent.models.Image;
import com.palrent.models.Offer;
import com.palrent.models.Role;
import com.palrent.models.Rule;
import com.palrent.models.User;
import com.palrent.services.ApartmentService;
import com.palrent.services.BookingService;
import com.palrent.services.ImageSerivce;
import com.palrent.services.OfferService;
import com.palrent.services.RuleServices;
import com.palrent.services.UserService;
import com.palrent.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class AdminController {
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	OfferService offerService ; 
	@Autowired
	UserService userService ; 
	@Autowired
	RuleServices ruleServices ; 
	@Autowired
	UserValidator userValidator;
	@Autowired
	ImageSerivce imageSerivce;
	@Autowired
	BookingService bookingService ; 
	
	
	@GetMapping("/admin")
	public String index(){
		return "admin/index.jsp";
	}
	
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
		Department dep1 = apartmentService.findById(id);
//		for(Role role:user.getRoles()) {
//			user.getRoles().remove(role);
//		}
		for (Image i : dep1.getImages()) {
			i.setDepartment(null);
			imageSerivce.update(i);
			imageSerivce.deleteImage(i.getId());

		}
		for(Booking book:dep1.getUsers()) {
			book.setUser(null);
			book.setDepartment(null);
			bookingService.updateBooking(book);
		}
//		userService.updateUser(id, user);
		apartmentService.deleteApartment(id);
		return"redirect:/admins/apartment";
	}
	
	public String deleteUserApartment(@PathVariable("id") Long id) {
		Department dep1 = apartmentService.findById(id);
		
		
		apartmentService.deleteApartment(id);
		return "redirect:/user/apartment";
	}
	
	
	@PatchMapping("/admins/apartmet/{id}/AddOffer")
	public String addOffer(@PathVariable("id") Long Id ,@RequestParam(value = "offerId", required = false)Long offerId ,Model model)
	{
		if (offerId == null) {
			return "redirect:/admins/apartment/" + Id + "/edit";
		}
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
	public String addRule(@PathVariable("id") Long Id ,@RequestParam(value ="ruleId",required = false)Long ruleId ,Model model)
	{
		if (ruleId == null) {
		return	"redirect:/admins/apartment/"+Id+"/edit";
		}
		
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
	@GetMapping("/admins/user")
	public String showUser(Model model){
		model.addAttribute("users",userService.allUsers());
		return "admin/user/user.jsp";
	}
	
	@GetMapping("/admins/user/new")
	public String newUser(@ModelAttribute("newUser") User newUser){
		
		return "admin/user/new_user.jsp";
	}
	
	@GetMapping("/admins/user/{id}/edit")
	public String showEditUser(@PathVariable("id")Long id ,Model model){
		User editUser = userService.findUser(id);
		model.addAttribute("editUser",editUser );
		return "admin/user/edit_user.jsp";
	}
	
	
//	@PostMapping("/admins/user/new")
//	public String addNewUser(@Valid @ModelAttribute("newUser") User newUser 
//			,BindingResult result
//			,RedirectAttributes redirectAttributes){
//		newUser = userService.prepareUser(newUser,result);
//		if(result.hasErrors()) {
//			return "admin/user/new_user.jsp";
//		}
//	
//		
//		redirectAttributes.addAttribute("success", "Successfully added user");
//		userService.createUser(newUser);
//		
//		return "redirect:/admins/user";
//	}
//	
	@PatchMapping("/admins/user/{id}/edit")
	public String EditUser(@Valid @ModelAttribute("editUser")User editUser
			,BindingResult result
			,@PathVariable("id") Long id 
			,Model model
			,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/user/edit_user.jsp";
		}
	
		
		redirectAttributes.addAttribute("success", "Successfully update user");
		userService.updateUser(id,editUser);
		return "redirect:/admins/user";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/admins/user/{id}/delete")
	public String deleteUser(@PathVariable("id")Long id) {
		
		userService.deleteUser(id);
		return "redirect:/admins/user";
	}
	
	@PostMapping("/admins/register")
    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
       userValidator.validate(user, result);
	 	if (result.hasErrors()) {
            return "main/register.jsp";
        }
       // userService.saveWithUserRole(user);
       userService.saveWithUserRole(user);
	 	return "redirect:/admins/user";
    }

	
	
}
