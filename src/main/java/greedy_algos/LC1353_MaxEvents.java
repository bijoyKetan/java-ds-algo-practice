package greedy_algos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1353_MaxEvents {

    public int maxEvents(int[][] events) {

        if (events.length < 2) return events.length;

        Arrays.sort(events, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            return e1[1] - e2[1];
        });

        Set<Integer> eventSet = new HashSet<>();

        for (int[] e : events) {
            if (e[0] == e[1]) {
                eventSet.add(e[0]);
            } else {
                for (int j = e[0]; j < e[1]; j++) {
                    if (!eventSet.contains(j)) {
                        eventSet.add(j);
                        break;
                    }
                }
            }
        }
        return eventSet.size();
    }

    @Test
    public void testMaxEvents() {
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}})); //4
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}})); //3
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 2}, {3, 3}, {3, 4}, {3, 4}})); //4
    }
}
