package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incidents.entities.GraffitiRemoval;

public interface GraffitiRemovalDAO extends JpaRepository<GraffitiRemoval, Integer> {

}
