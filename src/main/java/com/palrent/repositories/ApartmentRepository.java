package com.palrent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Department;

@Repository
public interface ApartmentRepository extends CrudRepository<Department, Long> {

	
}
