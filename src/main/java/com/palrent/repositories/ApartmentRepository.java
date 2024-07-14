package com.palrent.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Department;

@Repository
public interface ApartmentRepository extends CrudRepository<Department, Long> {

	@Query("select distinct d "
			+" from Department d "
			+" where d.city =?1 and d.numOfGuest=?2 ")
	List<Department> myquery1(String cirt,Integer guest);
}
