package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightsMap {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Paris", true);
        flightsMap.put("Warsaw", true);
        flightsMap.put("Berlin", false);

        if (flightsMap.containsKey(flight.getArrivalAirport()) && flightsMap.get(flight.getArrivalAirport()))
//        metoda containsKey sprawdza czy dany klucz jest w mapie, a get pobiera wartość i w tym przypadku sprawdza czy jest true
        {
            return true;
        } else {
            throw new RouteNotFoundException();
        }
    }
}

