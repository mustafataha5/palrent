package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Address;
import com.palrent.repositories.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository ; 
	
	
	public List<Address> allAddress(){
		return addressRepository.findAll();
	}
	
	public Address createAddress(Address a) {
		return addressRepository.save(a);
	}
	
	public Address findAddress(Long id) {
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null ;
	}
	public Address updateAddress(Address a) {
		Optional<Address> optional = addressRepository.findById(a.getId());
		if(optional.isPresent()){
			return addressRepository.save(a);
		}
		return null ;
	}
	
	public void deleteAddress(Long id) {
		 addressRepository.deleteById(id);
	}
	
}
