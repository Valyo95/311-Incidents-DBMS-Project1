package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.AbandonedVehicles;

public interface AbandonedVehiclesDAO extends JpaRepository<AbandonedVehicles, Integer> {

}
