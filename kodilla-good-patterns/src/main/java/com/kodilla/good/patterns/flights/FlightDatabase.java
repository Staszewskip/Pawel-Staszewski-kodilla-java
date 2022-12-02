package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightDatabase {
    List<Flight> flightList = new ArrayList<>();
public FlightDatabase(){
    addFlight();
}
    private List<Flight> addFlight() {
        flightList.add(new Flight("Warszawa", "Gdansk"));
        flightList.add(new Flight("Krakow", "Wroclaw"));
        flightList.add(new Flight("Gdansk", "Krakow"));
        flightList.add(new Flight("Gdansk", "Wroclaw"));
        flightList.add(new Flight("Warszawa", "Wroclaw"));
        return flightList;
    }
    public Set<Flight> findFlightsFromGivenAirport(String city){
        return flightList.stream()
                .filter(flight -> flight.departureAirport().equals(city))
                .collect(Collectors.toSet());
    }
    public Set<Flight> findFlightsToGivenAirport(String city){
        return flightList.stream()
                .filter(flight -> flight.arrivalAirport().equals(city))
                .collect(Collectors.toSet());
    }
    Set<Flight> findConnectingFlight(String departureAirport, String arrivalAirport) {
        Set<Flight> results = new HashSet<>();
        List<Flight> flightsFromGivenAirport = flightList.stream()
                .filter(flight -> flight.departureAirport().equals(departureAirport))
                .collect(Collectors.toList());
        List<Flight> flightsToGivenAirport = flightList.stream()
                .filter(flight -> flight.arrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
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
        return Objects.equals(flightList, that.flightList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightList);
    }

}
