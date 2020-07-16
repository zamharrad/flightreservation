package com.rad.flightreservation.controller;

import com.rad.flightreservation.dto.ReservationRequest;
import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.repositories.FlightRepository;
import com.rad.flightreservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(Long flightId, ModelMap modelMap) {

        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            modelMap.addAttribute("flight", flight.get());
        }
        return "completeReservation";
    }

    public String completeReservation(ReservationRequest request){
        return "";
    }
}
