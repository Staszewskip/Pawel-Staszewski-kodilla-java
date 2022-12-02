package com.kodilla.good.patterns.flights;

import java.util.Objects;

public record Flight(String departureAirport, String arrivalAirport) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public String toString() {
        return
                departureAirport +
                        " to " + arrivalAirport;
    }
}
