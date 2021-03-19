package com.gridnine.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;

public class OldFlightsFilter extends Filter {

    @Override
    protected boolean filter(Flight flight) {
        Segment first = flight.getSegments().get(0);
        return first.getDepartureDate().compareTo(LocalDateTime.now()) < 0;
    }
}
