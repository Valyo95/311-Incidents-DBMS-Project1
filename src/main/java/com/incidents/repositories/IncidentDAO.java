package com.incidents.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;

import com.incidents.entities.Incident;

public interface IncidentDAO extends JpaRepository<Incident, String>{
	@Query(value = "select * from totalrequestspertype(start_date, end_date)", nativeQuery = true)
    List<Pair<String, Integer>> first(@Param("start_date") Date start_date, @Param("end_date") Date end_date);
}
