package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearch {
    FlightDatabase flightDatabase = new FlightDatabase();

    public Set<Flight> findFlightsFromGivenAirport(String city) {
        return flightDatabase.flightSet.stream()
                .filter(flight -> flight.departureAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsToGivenAirport(String city) {
        return flightDatabase.flightSet.stream()
                .filter(flight -> flight.arrivalAirport().equals(city))
                .collect(Collectors.toSet());
    }

    Set<Flight> findConnectingFlight(String departureAirport, String arrivalAirport) {
        Set<Flight> results = new HashSet<>();
        Set<Flight> flightsFromGivenAirport = flightDatabase.flightSet.stream()
                .filter(flight -> flight.departureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
        Set<Flight> flightsToGivenAirport = flightDatabase.flightSet.stream()
                .filter(flight -> flight.arrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
        for (Flight flight1 : flightsFromGivenAirport) {
            for (Flight flight2 : flightsToGivenAirport) {
                if (flight1.arrivalAirport().equals(flight2.departureAirport())) {
                    results.add(flight1);
                    results.add(flight2);
                }
            }
        }
        return results;
    }
}
