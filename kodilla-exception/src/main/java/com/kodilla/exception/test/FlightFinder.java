package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Madrid", false);
        airports.put("Vienna", true);
        airports.put("Brussels", true);
        airports.put("Lisbon", true);
        airports.put("Cracow", false);
        airports.put("Rome", true);
        airports.put("Oslo", true);
        airports.put("Helsinki", false);

        if (areAirportsInDatabase(flight, airports)) {
            if (areFlightsAvailable(flight, airports)) {
                System.out.println("Flight from " + flight.getArrivalAirport() +
                        " to " + flight.getDepartureAirport() + " is available!");
            } else {
                System.out.println("Flight from " + flight.getArrivalAirport() +
                        " to " + flight.getDepartureAirport() + " is not available!");
            }
        } else {
            throw new RouteNotFoundException("Airport(s) pointed in searched " +
                    "flight do not exist(s)");
        }
    }

    private boolean areAirportsInDatabase(Flight flight, Map<String, Boolean> airports) {

        Boolean firstFlight = airports.getOrDefault(flight.getDepartureAirport(), false);
        Boolean secondFlight = airports.getOrDefault(flight.getArrivalAirport(), false);
        return firstFlight && secondFlight;
    }

    private boolean areFlightsAvailable(Flight flight, Map<String, Boolean> airports) {
        return airports.get(flight.getArrivalAirport())
                && airports.get(flight.getDepartureAirport());
    }
}
