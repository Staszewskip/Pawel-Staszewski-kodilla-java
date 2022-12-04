package com.kodilla.good.patterns.flights;

import java.util.Scanner;

public class FlightMain {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();

        System.out.println("Select departure airport");
        Scanner airport = new Scanner(System.in);
        String departureAirport = airport.nextLine();
        System.out.println("Select arrival airport");
        String arrivalAirport = airport.nextLine();

        Flight flight = new Flight(departureAirport, arrivalAirport);
        if (flight == null) {
            System.out.println("You did not provide airports");
        }

        System.out.println("Direct flights from the airport: " + flight.departureAirport() + "->" + flightDatabase.findFlightsFromGivenAirport(flight.departureAirport()));
        System.out.println("Direct flights to the airport: " + flight.arrivalAirport() + "->" + flightDatabase.findFlightsToGivenAirport(flight.arrivalAirport()));
        System.out.println("Connecting flights from: " + flight.departureAirport() + " to: " + flight.arrivalAirport() + "->" + flightDatabase.findConnectingFlight(flight.departureAirport(), flight.arrivalAirport()));
    }
}
