package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args){

        Flight flight = new Flight("Warsaw", "Palermo");
        FlightFinder flightFinder = new FlightFinder();

        try {

            flightFinder.findFlight(flight);

        } catch (RouteNotFoundException e){

            System.out.println("Error!" + e);

        } finally {

            System.out.println("Thank you for using our flight finder");
        }
    }
}
