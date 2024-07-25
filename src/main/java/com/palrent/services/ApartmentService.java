package com.palrent.services;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	public List<Department> search2(String city , Integer numOfGuest,Date start ,Date end){
//		return apartmentRepository.myquery2(city, numOfGuest,start,end);
		 List<Department> withUsers = apartmentRepository.findDepartmentsWithUsers(city, numOfGuest, start, end);
	        List<Department> withoutUsers = apartmentRepository.findDepartmentsWithoutUsers(city, numOfGuest);
	        
	        // Combine and remove duplicates
	        Set<Department> result = new HashSet<>();
	        result.addAll(withUsers);
	        result.addAll(withoutUsers);
	        
	        return new ArrayList<>(result);
	}
	public List<Department> search3(Long id ,Date start ,Date end){
		return apartmentRepository.myquery3(id,start,end);
	}
}
