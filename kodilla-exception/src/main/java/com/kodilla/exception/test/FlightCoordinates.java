package com.kodilla.exception.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlightCoordinates {

    public Boolean findFilght(Flight flight) throws  RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        Boolean airportFound = flightMap.get(flight.getArrivalAirport());
        if (airportFound != null) {
            return airportFound;
        } else {
            throw new RouteNotFoundException("No such airport " + flight.getArrivalAirport().toString());
        }
    }
}
