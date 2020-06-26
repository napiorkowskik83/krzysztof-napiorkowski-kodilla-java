package com.kodilla.good.patterns.challenges.flights;

public class FlightsMain {
    public static void main(String[] args) {
        FlightSearchEngine searchEngine = new FlightSearchEngine();

        searchEngine.displayFlightsFrom("gdansk");
        searchEngine.displayFlightsTo("Rzeszow");
        searchEngine.displayFlightsFromTo("WARSZAWA", "poznan");
    }
}
