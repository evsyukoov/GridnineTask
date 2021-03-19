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
        System.out.printf("Before all filters:\n %s\n", flights);
        Filter filterAll  = new Filter(flights);
        filterAll.addFiltration(new BrokenTimeSegmentFilter());
        filterAll.addFiltration(new LongTransferFilter());
        filterAll.addFiltration(new OldFlightsFilter());
        filterAll.filter();
        System.out.printf("After all filters:\n %s\n", filterAll.getFlights());

        Filter firstFilter = new Filter(flights);
        firstFilter.addFiltration(new OldFlightsFilter());
        firstFilter.filter();
        System.out.printf("After filter: 'вылет до текущего момента времени':\n %s\n", firstFilter.getFlights());

        Filter secondFilter = new Filter(flights);
        secondFilter.addFiltration(new BrokenTimeSegmentFilter());
        secondFilter.filter();
        System.out.printf("After filter: 'имеются сегменты с датой прилёта раньше даты вылета':\n %s\n", secondFilter.getFlights());

        Filter thirdFilter = new Filter(flights);
        thirdFilter.addFiltration(new LongTransferFilter());
        thirdFilter.filter();
        System.out.printf("After filter: 'общее время, проведённое на земле превышает два часа ':\n %s\n", thirdFilter.getFlights());

    }
}
