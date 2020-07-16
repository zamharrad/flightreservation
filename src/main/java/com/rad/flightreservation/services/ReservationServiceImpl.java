package com.rad.flightreservation.services;

import com.rad.flightreservation.dto.ReservationRequest;
import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.modal.Passenger;
import com.rad.flightreservation.modal.Reservation;
import com.rad.flightreservation.repositories.FlightRepository;
import com.rad.flightreservation.repositories.PassengerRepository;
import com.rad.flightreservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        // make payment
        Flight flight = flightRepository.getOne(request.getFlightId());

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
}
