package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.StreetLightOneOut;

public interface StreetLightOneOutDAO extends JpaRepository<StreetLightOneOut, Integer> {

}
