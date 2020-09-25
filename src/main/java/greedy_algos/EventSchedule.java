package greedy_algos;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventSchedule {
    private static final Logger log = LoggerFactory.getLogger(EventSchedule.class);

    public int maxEvents(List<Integer> events, List<Integer> durations) {
        int numEvents = events.size();
        int numDurations = durations.size();
        List<int[]> eventStartEnd = new ArrayList<>();
        if (numEvents != numDurations) throw new IllegalArgumentException("Invalid input");

        if (numEvents < 2) return numEvents;

        for (int i = 0; i < numEvents; i++) {
            eventStartEnd.add(new int[]{events.get(i), events.get(i) + durations.get(i)});
        }
        eventStartEnd.sort((e1, e2) -> e1[1] - e2[1]);
        //eventStartEnd.forEach((x) -> log.info(Arrays.toString(x)));

        List<int[]> scheduledEvents = new ArrayList<>();
        scheduledEvents.add(eventStartEnd.get(0));
        int counter = 0;

        for (int i = 0; i < eventStartEnd.size(); i++) {
            if (scheduledEvents.get(counter)[1] <= eventStartEnd.get(i)[0]) {
                scheduledEvents.add(eventStartEnd.get(i));
                counter++;
            }
        }
        return scheduledEvents.size();
    }

    @Test
    public void testEventsSchedule() {
        log.info("Number of events that can be scheduled: " + maxEvents(Arrays.asList(3, 1, 2), Arrays.asList(1, 1, 1)));
        log.info("Number of events that can be scheduled: " + maxEvents(Arrays.asList(3, 1, 2), Arrays.asList(2, 2, 2)));
        log.info("Number of events that can be scheduled: " + maxEvents(Arrays.asList(3), Arrays.asList(2)));
        log.info("Number of events that can be scheduled: " + maxEvents(Collections.emptyList(), Collections.emptyList()));
    }
}
