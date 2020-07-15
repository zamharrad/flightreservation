package com.rad.flightreservation.repositories;

import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.modal.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
