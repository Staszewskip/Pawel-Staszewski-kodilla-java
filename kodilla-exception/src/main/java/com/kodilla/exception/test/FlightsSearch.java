package com.kodilla.exception.test;

public class FlightsSearch {
    public void findFlight(Flight flight) {
        FlightsMap flightsMap = new FlightsMap();

        try {
            flightsMap.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("Airport not found");
        } finally {
            System.out.println("");
        }
    }
}

