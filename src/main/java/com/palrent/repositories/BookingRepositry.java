package com.palrent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Booking;

@Repository
public interface BookingRepositry extends CrudRepository<Booking, Long>{
	List<Booking> findAll();
}
