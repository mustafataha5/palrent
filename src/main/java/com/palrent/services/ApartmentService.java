package com.palrent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Department;
import com.palrent.repositories.ApartmentRepository;

@Service
public class ApartmentService {
	@Autowired
	ApartmentRepository apartmentRepository;
	
	
	public Iterable<Department> findall(){
		return apartmentRepository.findAll();
	}


	public Department creatAdminApartment(Department apartment) {

		return apartmentRepository.save(apartment);
		
		
	}
	
}
