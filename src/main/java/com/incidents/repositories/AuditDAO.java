package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.Audit;

public interface AuditDAO extends JpaRepository<Audit, Integer> {

}
