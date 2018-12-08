package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incidents.entities.Incident;

public interface ComplaintDAO extends JpaRepository<Incident, String>{

}
