package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.AlleyLightsOut;

public interface AlleyLightsOutDAO extends JpaRepository<AlleyLightsOut, Integer> {

}
