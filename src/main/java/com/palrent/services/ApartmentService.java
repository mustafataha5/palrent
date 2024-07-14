package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Department;
import com.palrent.repositories.ApartmentRepository;

@Service
public class ApartmentService {
	
	public static String[] cities = {"Ramallah","Nablus","Betlahem","Hebron","Jenin","Birzeit"};
	
	@Autowired
	ApartmentRepository apartmentRepository;
	
	
	public Iterable<Department> findall(){
		return apartmentRepository.findAll();
	}


	public Department creatAdminApartment(Department apartment) {
		return apartmentRepository.save(apartment);		
	}


	public Department findById(Long id) {
		Optional<Department> op = apartmentRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null; 
	}


	public Department updateApartment(Department editedApartment) {
		Optional<Department> optional = apartmentRepository.findById(editedApartment.getId());
		if(optional.isPresent()){
			return apartmentRepository.save(editedApartment);
		}
				
				return null;
		
	}

	public void deleteApartment(Long id) {
		apartmentRepository.deleteById(id);
		
		
	}
	
	public List<Department> search(String city , Integer numOfGuest){
		return apartmentRepository.myquery1(city, numOfGuest);
	}
	
}
