package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incidents.entities.Incident;

public interface IncidentDAO extends JpaRepository<Incident, String>{

}
