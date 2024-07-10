package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Offer;

import com.palrent.repositories.OfferRepository;

@Service
public class OfferService {
	@Autowired
	OfferRepository offerrepository;
	
	public List<Offer> allOffers(){
		return offerrepository.findAll();
	}
	
	public Offer createOffer(Offer o) {
		return offerrepository.save(o);
	}
	
	public Offer findOffer(Long id) {
		Optional<Offer> optional = offerrepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null ;
	}
	
	public Offer updateOffer(Offer offer) {
		Optional<Offer> optional = offerrepository.findById(offer.getId());
		if(optional.isPresent()) {
			return offerrepository.save(offer);
		}
		return null ;
	}
	public void deleteOffer(Long id) {
		offerrepository.deleteById(id);
	}
	
	public List<Offer> allOffernotIn(Long ApaId){
		return offerrepository.findAllOfferexclude(ApaId);
	}

}
