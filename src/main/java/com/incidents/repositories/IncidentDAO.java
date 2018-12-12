package com.incidents.repositories;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;

import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;

public interface IncidentDAO extends JpaRepository<Incident, String>{
	@Query(value = "select * from totalrequestspertype(?1, ?2)", nativeQuery = true)
    List<Object> getTotalRequestsPerType(Date start_date, Date end_date);
	
	@Query(value = "select * from totalrequestsperday(?1, ?2, ?3)", nativeQuery = true)
    List<Object> getTotalRequestsPerDayAndType(TypeOfServiceRequest type,Date start_date, Date end_date);
	
	@Query(value = "select * from mostcommonserviceperzipcode(date ?1)", nativeQuery = true)
    List<Object> mostCommonServicePerZipCode(Date date);

	@Query(value = "select * from avgcompletiontime(date ?1, date ?2)", nativeQuery = true)
    List<Object> avgCompletionTime(Date start_date, Date end_date);

	@Query(value = "select * from topfivessa(date ?1, date ?2)", nativeQuery = true)
    List<Object> topFiveSSA(Date start_date, Date end_date);
}
