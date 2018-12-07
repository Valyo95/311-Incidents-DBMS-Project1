package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.PotHoles;

public interface PotHolesDAO extends JpaRepository<PotHoles, Integer> {

}
