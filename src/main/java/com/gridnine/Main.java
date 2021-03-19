package com.gridnine;

import com.gridnine.filters.BrokenTimeSegmentFilter;
import com.gridnine.filters.Filter;
import com.gridnine.filters.LongTransferFilter;
import com.gridnine.filters.OldFlightsFilter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.printf("Before filter: %s\n", flights);
        Filter filter  = new Filter(flights);
        filter.addFiltration(new BrokenTimeSegmentFilter());
        filter.addFiltration(new LongTransferFilter());
        filter.addFiltration(new OldFlightsFilter());
        filter.filter();
        System.out.printf("After filter: %s", Filter.getFlights());
    }
}
