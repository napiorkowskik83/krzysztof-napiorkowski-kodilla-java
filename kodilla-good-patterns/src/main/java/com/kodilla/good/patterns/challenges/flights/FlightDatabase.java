package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {
    private final List<Flight> flights = new ArrayList<>();

    public FlightDatabase(){
        this.flights.add(new Flight("RZESZOW", "KRAKOW", 89));
        this.flights.add(new Flight("KRAKOW", "RZESZOW", 89));
        this.flights.add(new Flight("WROCLAW", "RZESZOW", 135));
        this.flights.add(new Flight("RZESZOW", "WROCLAW", 135));
        this.flights.add(new Flight("WARSZAWA", "KRAKOW", 190));
        this.flights.add(new Flight("KRAKOW", "WARSZAWA", 190));
        this.flights.add(new Flight("POZNAN", "RZESZOW", 250));
        this.flights.add(new Flight("RZESZOW", "POZNAN", 250));
        this.flights.add(new Flight("RZESZOW", "WARSZAWA", 177));
        this.flights.add(new Flight("WARSZAWA", "RZESZOW", 177));
        this.flights.add(new Flight("KRAKOW", "POZNAN", 203));
        this.flights.add(new Flight("POZNAN", "KRAKOW", 203));
        this.flights.add(new Flight("GDANSK", "WARSZAWA", 212));
        this.flights.add(new Flight("WARSZAWA", "GRANSK", 212));
        this.flights.add(new Flight("POZNAN", "GDANSK", 172));
        this.flights.add(new Flight("GDANSK", "POZNAN", 172));
        this.flights.add(new Flight("POZNAN", "WARSZAWA", 180));
        this.flights.add(new Flight("WARSZAWA", "POZNAN", 180));
        this.flights.add(new Flight("GDANSK", "KRAKOW", 425));
        this.flights.add(new Flight("KRAKOW", "GDANSK", 425));
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
