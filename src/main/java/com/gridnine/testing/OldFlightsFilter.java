package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class OldFlightsFilter extends Filter {

    @Override
    public void doFiltration() {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext()) {
            Segment first = iterator.next().getSegments().get(0);
            if (first.getDepartureDate().compareTo(LocalDateTime.now()) < 0)
                iterator.remove();
        }
    }
}
