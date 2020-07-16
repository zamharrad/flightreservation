package com.rad.flightreservation.controller;

import com.rad.flightreservation.dto.ReservationUpdateRequeset;
import com.rad.flightreservation.modal.Reservation;
import com.rad.flightreservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Optional<Reservation> findReservation(@PathVariable("id") Long id) throws Exception {

        Optional<Reservation> reservationOptional =reservationRepository.findById(id);

        if (reservationOptional.isPresent()){
            return reservationOptional;
        }

        return null;
    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequeset requeset) {

        Optional<Reservation> reservation = reservationRepository.findById(requeset.getId());
        reservation.get().setNumberOfBags(requeset.getNumberOfBags());
        reservation.get().setCheckedIn(requeset.getCheckedIn());
//        reservationRepository.save(reservation.get());
        return reservationRepository.save(reservation.get());
    }
}
