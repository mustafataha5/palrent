package com.palrent.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Offer;



@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
	List<Offer> findAll();
	
	
	@Query("select o "
			+ " from Offer o "
			+ "where o.id not in ("
			+ " select o.id "
			+ " from Offer o "
			+ "	join o.departments d "
			+ " where d.id = ?1 ) ")
	List<Offer> findAllOfferexclude(Long apartmentId);
	

}
