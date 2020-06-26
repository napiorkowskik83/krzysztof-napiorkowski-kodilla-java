package com.kodilla.good.patterns.challenges.flights;

public class Flight {
    private String departure;
    private String arrival;
    private int price;

    public Flight(final String departure, final String arrival, final int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String toString() {
        return "Flight from " + this.departure + " to " + this.arrival + " cost " + this.price + ".";
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (price != flight.price) return false;
        if (!departure.equals(flight.departure)) return false;
        return arrival.equals(flight.arrival);
    }

    @Override
    public int hashCode() {
        int result = departure.hashCode();
        result = 31 * result + arrival.hashCode();
        result = 31 * result + price;
        return result;
    }
}
