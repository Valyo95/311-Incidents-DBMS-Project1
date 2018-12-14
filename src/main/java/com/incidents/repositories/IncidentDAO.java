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
    List<Object> getTotalRequestsPerDayAndType(String type,Date start_date, Date end_date);
	
	@Query(value = "select * from mostcommonserviceperzipcode(?1)", nativeQuery = true)
    List<Object> mostCommonServicePerZipCode(Date date);

	@Query(value = "select * from avgcompletiontime(?1, ?2)", nativeQuery = true)
    List<Object> avgCompletionTime(Date start_date, Date end_date);

	@Query(value = "select * from topfivessa(?1, ?2)", nativeQuery = true)
    List<Object> topFiveSSA(Date start_date, Date end_date);
	
	List<Incident> findByZipCode(String zipCode);
	List<Incident> findByStreetAddress(String streetAddress);
	List<Incident> findByType(TypeOfServiceRequest type);
	
	List<Incident> findByZipCodeAndStreetAddress(String zipCode, String streeAddress);
	List<Incident> findByZipCodeAndType(String zipCode, TypeOfServiceRequest type);
	List<Incident> findByStreetAddressAndType(String streetAddress, TypeOfServiceRequest type);
	
	List<Incident> findByStreetAddressAndZipCodeAndType(String streetAddress, String zipCode, TypeOfServiceRequest type);

	@Query(value = "select * from policedistricts()", nativeQuery = true)
    List<Object> policeDistricts();

}
