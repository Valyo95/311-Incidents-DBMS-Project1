package com.incidents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.incidents.entities.RodentBaiting;


public interface RodentBaitingDAO extends JpaRepository<RodentBaiting, Integer> {

	@Query(value = "select * from rodentBaitingWithPremisesBaitedLessThan(?1)", nativeQuery = true)
    List<Object> rodentBaitingWithPremisesBaitedLessThan(int number);

	@Query(value = "select * from rodentBaitingWithGarbagePremisesBaitedLessThan(?1)", nativeQuery = true)
    List<Object> rodentBaitingWithGarbagePremisesBaitedLessThan(int number);
	
	@Query(value = "select * from rodentBaitingWithRatsPremisesBaitedLessThan(?1)", nativeQuery = true)
    List<Object> rodentBaitingWithRatsPremisesBaitedLessThan(int number);
	
}
