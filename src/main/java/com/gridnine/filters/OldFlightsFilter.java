package com.gridnine.filters;

import com.gridnine.filters.Filter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.ListIterator;

public class OldFlightsFilter extends Filter {

    @Override
    public void filter() {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext()) {
            Segment first = iterator.next().getSegments().get(0);
            if (first.getDepartureDate().compareTo(LocalDateTime.now()) < 0)
                iterator.remove();
        }
    }
}
