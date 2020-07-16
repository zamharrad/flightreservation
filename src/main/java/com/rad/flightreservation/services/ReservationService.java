package com.rad.flightreservation.services;

import com.rad.flightreservation.dto.ReservationRequest;
import com.rad.flightreservation.modal.Reservation;


public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
