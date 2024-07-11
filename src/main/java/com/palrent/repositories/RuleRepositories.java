package com.palrent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Offer;
import com.palrent.models.Rule;

@Repository
public interface RuleRepositories extends CrudRepository< Rule,Long> {
	List<Rule> findAll();
	
	@Query("select r "
			+ " from Rule r "
			+ "where r.id not in ("
			+ " select r.id "
			+ " from Rule r "
			+ "	join r.departments d "
			+ " where d.id = ?1 ) ")
	List<Rule> findAllRulwexclude(Long apartmentId);
}
