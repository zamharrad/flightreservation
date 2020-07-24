package com.rad.flightreservation.services;

import com.rad.flightreservation.dto.ReservationRequest;
import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.modal.Passenger;
import com.rad.flightreservation.modal.Reservation;
import com.rad.flightreservation.repositories.FlightRepository;
import com.rad.flightreservation.repositories.PassengerRepository;
import com.rad.flightreservation.repositories.ReservationRepository;
import com.rad.flightreservation.util.EmailUtil;
import com.rad.flightreservation.util.PDFGenarator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    PDFGenarator pdfGenarator;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Value(value = "${com.rad.flightreservation.itinerary.dir}")
    private String ITINERARY_DIR;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        LOGGER.info("Inside bookFlight()");
        // make payment
        Flight flight = flightRepository.getOne(request.getFlightId());
        LOGGER.info("Fetching flight for flight id :" + flight.getId());

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        LOGGER.info("Saving the passengers :" + passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation :" + reservation);
        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";

        LOGGER.info("Generating the itinerary");
        pdfGenarator.genarateItinerary(savedReservation, filePath);
        LOGGER.info("Sending the itinerary");
        emailUtil.sendItinerary(passenger.getEmail(), filePath);

        return savedReservation;
    }
}
