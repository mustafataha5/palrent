package com.palrent.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Booking;
import com.palrent.repositories.BookingRepositry;

@Service
public class BookingService {
	@Autowired
	BookingRepositry bookingRepositry ; 
	
	public List<Booking> allBookings(){
		return bookingRepositry.findAll();
	}
	
	public Booking createBooking(Booking book) {
		return bookingRepositry.save(book);
	}
	
	public Booking findBooking(Long id) {
		Optional<Booking> optional = bookingRepositry.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null ; 
	}
	
	public Booking updateBooking(Booking book) {
		Optional<Booking> optional = bookingRepositry.findById(book.getId());
		if(optional.isPresent()) {
			return bookingRepositry.save(book);
		}
		return null ; 
		
	}
	
	public void deleteBooking(Long id) {
		bookingRepositry.deleteById(id);
	}
	
}
