package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

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
}
