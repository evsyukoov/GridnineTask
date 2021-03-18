package com.gridnine.testing;

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

    public void     addFiltrationType(Filter f)
    {
        filters.add(f);
    }

    public void filter()
    {
        for (Filter f : filters) {
            f.doFiltration();
        }
    }

    public void doFiltration(){};
}
