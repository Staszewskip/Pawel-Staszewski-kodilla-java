package com.kodilla.good.patterns.flights;

public record Flight(String departureAirport, String arrivalAirport) {

    @Override
    public String toString() {
        return
                departureAirport +
                        " to " + arrivalAirport;
    }
}
