package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {
    public static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //A normal flight with two hour duration
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                //A normal multi segment flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //A flight departing in the past
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //A flight that departs before it arrives
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //A flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Another flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    public static List<Flight> createFlights2() {
        LocalDateTime Now = LocalDateTime.now();
        return Arrays.asList(
                createFlight(Now, Now.plusHours(2)),
                createFlight(Now, Now.plusHours(2),
                        Now.plusHours(3), Now.plusHours(5)),
                createFlight(Now.minusHours(2), Now.minusHours(2).minusMinutes(2)),
                createFlight(Now.minusHours(4), Now.minusHours(4).minusMinutes(1)),
                createFlight(Now, Now.plusHours(2),
                        Now.plusHours(3), Now.plusHours(5)));
    }

    public static List<Flight> createFlights3() {
        LocalDateTime Now = LocalDateTime.now();
        return Arrays.asList(
                createFlight(Now, Now.plusHours(2)),
                createFlight(Now, Now.plusHours(2),
                        Now.plusHours(4).plusMinutes(1), Now.plusHours(5)),
                createFlight(Now.plusHours(1), Now.plusHours(2), Now.plusHours(3), Now.plusHours(5), Now.plusHours(5).plusMinutes(59), Now.plusHours(8)),
                createFlight(Now.plusHours(1), Now.plusHours(2), Now.plusHours(2).plusMinutes(30), Now.plusHours(4),
                        Now.plusHours(4).plusMinutes(20), Now.plusHours(6),
                        Now.plusHours(6).plusMinutes(12), Now.plusHours(8), Now.plusHours(9), Now.plusHours(12)),
                createFlight(Now, Now.plusHours(2),
                        Now.plusHours(3), Now.plusHours(5)));
    }

    public static List<Flight> createFlights4() {
        LocalDateTime Now = LocalDateTime.now();
        return Arrays.asList(
                createFlight(Now.plusHours(1), Now.plusHours(2)),
                createFlight(Now.plusMinutes(30), Now.plusHours(2),
                        Now.plusHours(4).plusMinutes(1), Now.plusHours(5)),
                createFlight(Now.minusMinutes(2), Now.plusHours(2), Now.plusHours(3), Now.plusHours(5), Now.plusHours(5).plusMinutes(59), Now.plusHours(8)),
                createFlight(Now.plusHours(1), Now.plusHours(2), Now.plusHours(2).plusMinutes(30), Now.plusHours(4),
                        Now.plusHours(4).plusMinutes(20), Now.plusHours(6),
                        Now.plusHours(6).plusMinutes(12), Now.plusHours(8), Now.plusHours(9), Now.plusHours(12)),
                createFlight(Now.minusHours(1), Now.plusHours(2),
                        Now.plusHours(3), Now.plusHours(5)),
                createFlight(Now.plusMinutes(15), Now.plusHours(2),
                    Now.plusHours(3), Now.plusHours(5)));
    }


    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}
