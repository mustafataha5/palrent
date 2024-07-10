package com.palrent.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Offer;



@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
	List<Offer> findAll();
	

}
