package com.palrent.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.palrent.models.Booking;
import com.palrent.models.Department;
import com.palrent.services.ApartmentService;
import com.palrent.services.BookingService;

@RestController
public class AjaxController {
	
	@Autowired
	BookingService bookingService ; 
	@Autowired
	ApartmentService apartmentService ; 
	
	public static class RequestData {
		public String city;
		public String checkin;
		public String checkout;
		public int guests;

	}

	@GetMapping("/ajax")
	public String getMessage() {
		return "Hello from Spring Boot!";
	}
	
//	@PostMapping("/ajax")
//	public List<Department> postMessage(@RequestBody RequestData requestData) {
////		return "Received data - City: " +requestData.city + ", Check-in: " + requestData.checkin + 
////	               ", Check-out: " + requestData.checkout + ", Guests: " + requestData.guests;
//			//System.out.println(" >>>>>>>>>>"+apartmentService.search(requestData.city, requestData.guests).size());
//			List<Department> deps = apartmentService.search(requestData.city, requestData.guests); 
//			return deps ;
//	    }
	@PostMapping("/ajax")
	public List<Department> postMessage1(@RequestBody RequestData requestData) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 LocalDate localDate1 = LocalDate.parse(requestData.checkin, formatter);
			 LocalDate localDate2 = LocalDate.parse(requestData.checkout, formatter);
			Date d1 = Date.valueOf(localDate1) ; 
			Date d2 =  Date.valueOf(localDate2) ;
			List<Department> deps = apartmentService.search2(requestData.city, requestData.guests,d1,d2); 
			System.out.println(" >>>>>>>>>>"+deps);
			return deps ;
	    }
	
	}
