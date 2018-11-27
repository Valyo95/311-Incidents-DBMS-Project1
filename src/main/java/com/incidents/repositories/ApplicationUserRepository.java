package com.incidents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incidents.entities.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
