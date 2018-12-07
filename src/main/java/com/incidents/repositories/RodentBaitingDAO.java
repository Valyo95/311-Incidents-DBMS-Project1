package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.RodentBaiting;


public interface RodentBaitingDAO extends JpaRepository<RodentBaiting, Integer> {

}
