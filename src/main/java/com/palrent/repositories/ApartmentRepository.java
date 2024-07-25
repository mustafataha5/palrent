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
			+ " and ( (u.startDate > ?3  and u.startDate > ?4) or (u.endDate < ?3  and  u.endDate < ?4 )) "
			+ " UNION "
			+ " SELECT DISTINCT d "
			+ " FROM Department d "
			+ " where d.city =?1 and d.numOfGuest=?2 and  d.approval= true "
			+ " and d.id not in (SELECT d1.id FROM Department d1 join d1.users u1) "  )
	List<Department> myquery2(String cirt,Integer guest,Date start ,Date end);
	
	@Query("select  d "
			+" from Department d "
			+ "	where d.id in ( select d1.id  "
			+ "	from Department d1 "
			+ "	join d1.users u "
			+" 	where u.department.id =?1 and  d1.approval= true  and "
			+ "( (u.startDate > ?2  and u.startDate > ?3) or (u.endDate < ?2  and  u.endDate < ?3 )) )")
	List<Department> myquery3(Long id, Date start ,Date end);

	@Query("select distinct d "
            + " from Department d "
            + " join d.users u "
            + " where d.city = ?1 and d.numOfGuest = ?2 and d.approval = true "
            + " and ((u.startDate > ?3 and u.startDate > ?4) or (u.endDate < ?3 and u.endDate < ?4))")
    List<Department> findDepartmentsWithUsers(String city, Integer numOfGuests, Date startDate, Date endDate);

    @Query("select distinct d "
            + " from Department d "
            + " where d.city = ?1 and d.numOfGuest = ?2 and d.approval = true "
            + " and d.id not in (select d1.id from Department d1 join d1.users u1)")
    List<Department> findDepartmentsWithoutUsers(String city, Integer numOfGuests);

}
