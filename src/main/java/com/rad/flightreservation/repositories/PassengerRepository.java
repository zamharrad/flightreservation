package com.rad.flightreservation.repositories;

import com.rad.flightreservation.modal.Passenger;
import com.rad.flightreservation.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
