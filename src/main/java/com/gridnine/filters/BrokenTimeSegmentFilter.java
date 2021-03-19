package com.gridnine.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.ListIterator;

public class BrokenTimeSegmentFilter extends Filter {

    @Override
    protected boolean filter(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().compareTo(segment.getDepartureDate()) < 0) {
                return true;
            }
        }
        return false;
    }
}
