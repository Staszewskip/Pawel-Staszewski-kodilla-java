package com.kodilla.good.patterns.flights;

public class FlightMain {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warszawa", "Krakow");

        System.out.println("Direct flights from the airport: " + flight.departureAirport() + "->" + flightSearch.findFlightsFromGivenAirport(flight.departureAirport()));
        System.out.println("Direct flights to the airport: " + flight.arrivalAirport() + "->" + flightSearch.findFlightsToGivenAirport(flight.arrivalAirport()));
        System.out.println("Connecting flights from: " + flight.departureAirport() + " to: " + flight.arrivalAirport() + "->" + flightSearch.findConnectingFlight(flight.departureAirport(), flight.arrivalAirport()));
    }
}
