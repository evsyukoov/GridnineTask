package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

public class LongTransferFilter extends Filter {

    @Override
    public void doFiltration() {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext())
        {
            int sum = 0;
            List<Segment> segments = iterator.next().getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                Duration d =  Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
                sum += d.toHours();
                if (sum > 2)
                {
                    iterator.remove();
                    break ;
                }
            }
        }
    }
}
