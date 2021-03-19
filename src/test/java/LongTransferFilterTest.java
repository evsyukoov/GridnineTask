import com.gridnine.filters.BrokenTimeSegmentFilter;
import com.gridnine.filters.Filter;
import com.gridnine.filters.LongTransferFilter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LongTransferFilterTest {
    Filter f;
    LongTransferFilter ltf = new LongTransferFilter();

    @Test
    public void     basicTest() {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(sourceFlights.size() - 1);
        sourceFlights.remove(sourceFlights.size() - 1);
        f.addFiltration(ltf);
        f.filter();
        assertEquals(sourceFlights, Filter.getFlights());
    }

    @Test
    public void     Test2() {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights3());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(1);
        sourceFlights.remove(2);
        f.addFiltration(ltf);
        f.filter();
        assertEquals(sourceFlights, Filter.getFlights());
    }
}
