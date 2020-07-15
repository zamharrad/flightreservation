package com.rad.flightreservation.controller;

import com.rad.flightreservation.modal.Flight;
import com.rad.flightreservation.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam(name = "departureDate", defaultValue = "02-06-2019") String departureDate,
                              ModelMap modelMap) throws ParseException {

        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("MM-dd-yyyy");
        date = (Date) formatter.parse(departureDate);
        System.out.println("----------------------");
        System.out.println("argument date ::"+departureDate);
        System.out.println("hard coded date ::"+ date);

        List<Flight> flights = flightRepository.findFlights(from, to, date);
        modelMap.addAttribute("flights", flights);
        return "displayFlights";
    }
}
