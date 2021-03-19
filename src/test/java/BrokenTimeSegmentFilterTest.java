import com.gridnine.filters.BrokenTimeSegmentFilter;
import com.gridnine.filters.Filter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class BrokenTimeSegmentFilterTest {
    Filter f;
    BrokenTimeSegmentFilter btsf = new BrokenTimeSegmentFilter();


    @Test
    public void     testTaskCases()
    {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(3);
        f.addFiltration(btsf);
        f.filter();
        assertEquals(sourceFlights, f.getFlights());
    }

    @Test
    public void     testSeveralWrongTimes()
    {
        LinkedList<Flight> sourceFlights = new LinkedList<>(FlightBuilder.createFlights2());
        Filter f = new Filter(sourceFlights);
        sourceFlights.remove(2);
        sourceFlights.remove(2);
        f.addFiltration(btsf);
        f.filter();
        assertEquals(sourceFlights, f.getFlights());
    }

}
