import com.gridnine.filters.Filter;
import com.gridnine.filters.OldFlightsFilter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class OldFlightsFilterTest {
    Filter f;
    OldFlightsFilter olff = new OldFlightsFilter();

    @Test
    public void     basicTest() {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(2);
        f.addFiltration(olff);
        f.filter();
        assertEquals(sourceFlights, Filter.getFlights());
    }

    @Test
    public void     Test2() {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights4());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(2);
        sourceFlights.remove(3);
        f.addFiltration(olff);
        f.filter();
        assertEquals(sourceFlights, Filter.getFlights());
    }
}
