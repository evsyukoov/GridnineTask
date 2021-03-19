package com.gridnine.filters;

import com.gridnine.filters.Filter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

public class LongTransferFilter extends Filter {

    @Override
    public void filter() {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext())
        {
           long sum = 0;
            List<Segment> segments = iterator.next().getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                Duration d =  Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
                sum += d.toMillis();
                if (sum > 7200000)
                {
                    iterator.remove();
                    break ;
                }
            }
        }
    }
}
