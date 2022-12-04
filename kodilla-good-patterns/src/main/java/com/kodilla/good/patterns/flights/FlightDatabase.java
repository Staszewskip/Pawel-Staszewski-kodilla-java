package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightDatabase {
    Set<Flight> flightSet = new HashSet<>();

    public FlightDatabase() {
        addFlight();
    }

    private Set<Flight> addFlight() {
        flightSet.add(new Flight("Warszawa", "Gdansk"));
        flightSet.add(new Flight("Krakow", "Wroclaw"));
        flightSet.add(new Flight("Gdansk", "Krakow"));
        flightSet.add(new Flight("Gdansk", "Wroclaw"));
        flightSet.add(new Flight("Warszawa", "Wroclaw"));
        return flightSet;
    }

    public Set<Flight> findFlightsFromGivenAirport(String city) {
        return flightSet.stream()
                .filter(flight -> flight.departureAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsToGivenAirport(String city) {
        return flightSet.stream()
                .filter(flight -> flight.arrivalAirport().equals(city))
                .collect(Collectors.toSet());
    }

    Set<Flight> findConnectingFlight(String departureAirport, String arrivalAirport) {
        Set<Flight> results = new HashSet<>();
        Set<Flight> flightsFromGivenAirport = flightSet.stream()
                .filter(flight -> flight.departureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
        Set<Flight> flightsToGivenAirport = flightSet.stream()
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDatabase that = (FlightDatabase) o;
        return Objects.equals(flightSet, that.flightSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightSet);
    }

}
