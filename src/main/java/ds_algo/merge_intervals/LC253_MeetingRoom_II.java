package ds_algo.merge_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253_MeetingRoom_II {

    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length < 2) return intervals.length;

        //Sort by end time
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, (e1, e2) -> e1 - e2);
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}
