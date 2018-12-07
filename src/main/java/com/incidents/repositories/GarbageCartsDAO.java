package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.GarbageCarts;

public interface GarbageCartsDAO extends JpaRepository<GarbageCarts, Integer> {

}
