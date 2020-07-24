package com.rad.flightreservation.repositories;

import com.rad.flightreservation.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
