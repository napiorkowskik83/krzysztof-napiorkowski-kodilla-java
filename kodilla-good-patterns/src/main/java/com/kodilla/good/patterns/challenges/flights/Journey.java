package com.kodilla.good.patterns.challenges.flights;

public class Journey {
    private Flight firstFlight;
    private Flight secondFlight;
    private Flight thirdFlight;
    int price;

    public Journey(final Flight firstFlight) {
        this.firstFlight = firstFlight;
        this.price = firstFlight.getPrice();
    }

    public Journey(final Flight firstFlight, final Flight secondFlight) {
        this.firstFlight = firstFlight;
        this.secondFlight = secondFlight;
        this.price = firstFlight.getPrice() + secondFlight.getPrice();
    }

    public String toString() {
        if (this.secondFlight == null && this.thirdFlight == null) {
            return "Flight from " + this.firstFlight.getDeparture() + " to "
                    + this.firstFlight.getArrival() + ", cost " + this.price + ".";
        } else if (this.thirdFlight == null) {
            return "Flight from " + this.firstFlight.getDeparture() + " to "
                    + this.secondFlight.getArrival() + " via " + this.secondFlight.getDeparture()
                    + ", cost " + this.price + ".";
        } else {
            return "Flight from " + this.firstFlight.getDeparture() + " to "
                    + this.thirdFlight.getArrival() + " via " + this.secondFlight.getDeparture() + " and "
                    + this.thirdFlight.getDeparture() + ", cost " + this.price + ".";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journey journey = (Journey) o;

        if (price != journey.price) return false;
        if (!firstFlight.equals(journey.firstFlight)) return false;
        if (secondFlight != null ? !secondFlight.equals(journey.secondFlight) : journey.secondFlight != null)
            return false;
        return thirdFlight != null ? thirdFlight.equals(journey.thirdFlight) : journey.thirdFlight == null;
    }

    @Override
    public int hashCode() {
        int result = firstFlight.hashCode();
        result = 31 * result + (secondFlight != null ? secondFlight.hashCode() : 0);
        result = 31 * result + (thirdFlight != null ? thirdFlight.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}

