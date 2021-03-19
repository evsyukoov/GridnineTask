package com.gridnine.filters;

import com.gridnine.testing.Flight;

import java.util.LinkedList;
import java.util.List;

public class Filter {
    protected static LinkedList<Flight> flights;

    private List<Filter> filters;

    public Filter(List<Flight> flights) {
        Filter.flights = new LinkedList<>(flights);
        filters = new LinkedList<>();
    }

    public Filter() {
    }

    public void     addFiltration(Filter f)
    {
        if (f == null)
            throw new IllegalArgumentException("Null pointer of filtration");
        filters.add(f);
    }

    public void filter()
    {
        for (Filter f : filters) {
            f.filter();
        }
    }

    public static LinkedList<Flight> getFlights() {
        return flights;
    }
}
