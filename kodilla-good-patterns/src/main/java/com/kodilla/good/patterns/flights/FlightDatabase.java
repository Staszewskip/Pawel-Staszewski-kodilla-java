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
