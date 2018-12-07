package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incidents.entities.Complaint;

public interface ComplaintDAO extends JpaRepository<Complaint, String>{

}
