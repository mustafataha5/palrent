package com.palrent.repositories;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Department;

@Repository
public interface ApartmentRepository extends CrudRepository<Department, Long> {

	@Query("select distinct d "
			+" from Department d "
			+" where d.city =?1 and d.numOfGuest=?2 and  d.approval= true ")
	List<Department> myquery1(String cirt,Integer guest);
	@Query("select distinct d "
			+" from Department d "
			+ " join d.users u "
			+" where d.city =?1 and d.numOfGuest=?2 and  d.approval= true "
			+ "and ( (u.startDate > ?3  and u.startDate > ?4) or (u.endDate < ?3  and  u.endDate < ?4 ))"  )
	List<Department> myquery2(String cirt,Integer guest,Date start ,Date end);
}
