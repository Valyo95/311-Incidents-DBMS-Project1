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
	
	@Query(value = "select * from incident offset ?1 limit ?2", nativeQuery = true)
	List<Incident> findAllPaged(int start, int size);
	
	@Query(value = "select * from incident where zip_code = ?1 offset ?2 limit ?3", nativeQuery = true)
	List<Incident> findByZipCodePaged(String zipCode, int start, int size);
	
	List<Incident> findByStreetAddress(String streetAddress);
	
	@Query(value = "select * from incident where street_address = ?1 offset ?2 limit ?3", nativeQuery = true)
	List<Incident> findByStreetAddressPaged(String streetAddress, int start, int size);
	
	List<Incident> findByType(TypeOfServiceRequest type);
	
	@Query(value = "select * from incident where service_request_type = ?1 offset ?2 limit ?3", nativeQuery = true)
	List<Incident> findByTypePaged(String type, int start, int size);
	
	List<Incident> findByZipCodeAndStreetAddress(String zipCode, String streeAddress);
	
	@Query(value = "select * from incident where zip_code = ?1 and street_address = ?2 offset ?3 limit ?4", nativeQuery = true)
	List<Incident> findByZipCodeAndStreetAddressPaged(String zipCode, String streeAddress, int start, int size);
	
	List<Incident> findByZipCodeAndType(String zipCode, TypeOfServiceRequest type);
	
	@Query(value = "select * from incident where zip_code = ?1 and service_request_type = ?2 offset ?3 limit ?4", nativeQuery = true)
	List<Incident> findByZipCodeAndTypePaged(String zipCode, String type, int start, int size);
	
	List<Incident> findByStreetAddressAndType(String streetAddress, TypeOfServiceRequest type);
	
	@Query(value = "select * from incident where street_address = ?1 and service_request_type = ?2 offset ?3 limit ?4", nativeQuery = true)
	List<Incident> findByStreetAddressAndTypePaged(String streetAddress, String type, int start, int size);
	
	List<Incident> findByStreetAddressAndZipCodeAndType(String streetAddress, String zipCode, TypeOfServiceRequest type);
	
	@Query(value = "select * from incident where street_address = ?1 and zip_code = ?2 and service_request_type = ?3 offset ?4 limit ?5", nativeQuery = true)
	List<Incident> findByStreetAddressAndZipCodeAndTypePaged(String streetAddress, String zipCode, String type, int start, int size);

	@Query(value = "select * from policedistricts()", nativeQuery = true)
    List<Object> policeDistricts();

}
