package com.palrent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Rule;

@Repository
public interface RuleRepositories extends CrudRepository< Rule,Long> {
	List<Rule> findAll();
}
