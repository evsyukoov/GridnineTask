package com.gridnine.testing;

import java.util.List;
import java.util.ListIterator;

public class BrokenTimeSegmentFilter extends Filter {

    @Override
    public void doFiltration() {
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
