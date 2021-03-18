package com.gridnine.testing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private void print(List<Flight> flights)
    {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("________________________________________");
    }
    public static void main(String[] args) {
        Main m = new Main();
        List<Flight> flights = FlightBuilder.createFlights();
        m.print(flights);
        Filter f = new Filter(flights);
        f.addFiltrationType(new BrokenTimeSegmentFilter());
        f.addFiltrationType(new LongTransferFilter());
        f.addFiltrationType(new OldFlightsFilter());
        f.filter();
        m.print(f.flights);
//        Filter f2 = new BrokenTimeSegmentFilter(flights);
//        f2.filter();
//        m.print(f2.flights);
//
//        Filter f3 = new LongTransferFilter(flights);
//        f3.filter();
//        m.print(f3.flights);


    }
}
