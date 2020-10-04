package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_759_EmployeeFreeTime_Heap {

    // Definition for an Interval.
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }


    class IntervalCounter {
        public Interval interval;
        public int employeeIndx;
        public int innerArrayIndx;

        public IntervalCounter() {
        }

        public IntervalCounter(Interval interval, int employeeIndx, int innerArrayIndx) {
            this.interval = interval;
            this.employeeIndx = employeeIndx;
            this.innerArrayIndx = innerArrayIndx;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        //Create PQ to hold the info (interval, empIndex, InnerArrayIndex)
        PriorityQueue<IntervalCounter> pq = new PriorityQueue<>(
                (i1, i2) -> i1.interval.start - i2.interval.start
        );

        for (int i = 0; i < schedule.size(); i++) {
            pq.offer(new IntervalCounter(schedule.get(i).get(0), i, 0));
        }

        List<Interval> result = new ArrayList<>();
        result.add(pq.peek().interval);
        int counter = 0;

        while (!pq.isEmpty()) {
            //Overlap
            if (pq.peek().interval.end >= result.get(counter).start) {
                //merge
                result.get(counter).end = Math.max(result.get(counter).end, pq.peek().interval.end);
            } else {
                //non overlap
                result.add(pq.peek().interval);
                counter++;
            }
            IntervalCounter c = pq.poll();
            pq.offer(new IntervalCounter(schedule.get(c.employeeIndx+1).get(c.innerArrayIndx+1), c.employeeIndx+1, c.innerArrayIndx+1));

        }


        List<Interval> freeTimes = new ArrayList<>();
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).end < result.get(i + 1).end) {
                freeTimes.add(new Interval(result.get(i).end, result.get(i + 1).start));
            }
        }
        return freeTimes;
    }


    @Test
    public void testFreeTime() {
        var a = Arrays.asList(Arrays.asList(new Interval(1, 2), Arrays.asList(new Interval(5, 6))));
        var b = Arrays.asList(Arrays.asList(new Interval(1, 3)));
        var c = Arrays.asList(Arrays.asList(new Interval(4, 10)));
        var inp = new ArrayList(Arrays.asList(a, b, c));
        System.out.println(employeeFreeTime(Arrays.asList(inp)));
    }
}