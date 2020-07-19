package com.rad.flightreservation.controller;

import com.rad.flightreservation.dto.ReservationRequest;
import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.modal.Reservation;
import com.rad.flightreservation.repositories.FlightRepository;
import com.rad.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(Long flightId, ModelMap modelMap) {

        LOGGER.info("Inside the showCompleteReservation() invoked with flight id :" + flightId);

        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            modelMap.addAttribute("flight", flight.get());
        }
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {

        LOGGER.info("Inside the completeReservation() :" + request);

        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation completed successfully and the id is :" + reservation.getId());
        return "reservationConfirmation";
    }
}
