package com.gridnine.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.ListIterator;

public class BrokenTimeSegmentFilter extends Filter {

    @Override
    public void filter() {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext())
        {
            for (Segment segment : iterator.next().getSegments()) {
                if (segment.getArrivalDate().compareTo(segment.getDepartureDate()) < 0)
                {
                    iterator.remove();
                    break ;
                }
            }
        }
    }
}
