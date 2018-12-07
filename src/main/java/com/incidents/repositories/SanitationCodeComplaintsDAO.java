package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.SanitationCodeComplaints;


public interface SanitationCodeComplaintsDAO extends JpaRepository<SanitationCodeComplaints, Integer> {

}
