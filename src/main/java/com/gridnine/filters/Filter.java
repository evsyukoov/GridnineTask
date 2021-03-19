package com.gridnine.filters;

import com.gridnine.testing.Flight;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Filter {
    private LinkedList<Flight> flights;

    private List<Filter> filters;

    public Filter(List<Flight> flights) {
        this.flights = new LinkedList<>(flights);
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

    public void     removeFiltration(Filter f)
    {
        if (f == null)
            throw new IllegalArgumentException("Null pointer of filtration");
        filters.remove(f);
    }

    public void filter()
    {
        ListIterator<Flight> iterator = flights.listIterator();
        while (iterator.hasNext()) {
            Flight flight = iterator.next();
            for (Filter f : filters) {
                if (f.filter(flight))
                {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    protected boolean    filter(Flight flight){return true;}

    public LinkedList<Flight> getFlights() {
        return flights;
    }
}
