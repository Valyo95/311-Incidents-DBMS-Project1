package com.incidents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.incidents.entities.AbandonedVehicles;

public interface AbandonedVehiclesDAO extends JpaRepository<AbandonedVehicles, Integer> {

	@Query(value = "select * from morethanonceabandoned()", nativeQuery = true)
	List<Object> moreThanOnceAbandoned();

	@Query(value = "select * from secondCommonColor()", nativeQuery = true)
	List<Object> secondCommonColor();
}
