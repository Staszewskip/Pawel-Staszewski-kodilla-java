package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightsMap {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Paris", true);
        flightsMap.put("Warsaw", true);
        flightsMap.put("Berlin", false);

        if (flightsMap.containsKey(flight.getArrivalAirport()) && flightsMap.get(flight.getArrivalAirport())) {
            return true;
        } else {
            throw new RouteNotFoundException();
        }
    }
}

