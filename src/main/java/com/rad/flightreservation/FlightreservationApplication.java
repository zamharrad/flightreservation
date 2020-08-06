package com.rad.flightreservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightreservationApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FlightreservationApplication.class);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightreservationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FlightreservationApplication.class, args);
        LOGGER.info("----------------------------------------------------------------------------------------------------------");
        LOGGER.info("----------------------------------------------------------------------------------------------------------");
        LOGGER.info("Flight Reservation Application Up and Running");
        LOGGER.info("----------------------------------------------------------------------------------------------------------");
        LOGGER.info("----------------------------------------------------------------------------------------------------------");

    }

}
