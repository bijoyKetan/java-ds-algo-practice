package ds_algo.merge_intervals;


import java.util.ArrayList;
import java.util.List;

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
};


public class LC_759_EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        //create list of all intervals
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            for (Interval i : intervals) {
                allIntervals.add(i);
            }
        }

        //sort the intervals
        allIntervals.sort((i1, i2) -> i1.start - i2.start);

        List<Interval> merged = new ArrayList<>();
        merged.add(allIntervals.get(0));
        int counter = 0;

        //merge overlapping intervals
        for (int i = 1; i < allIntervals.size(); i++) {
            //overlap
            if (merged.get(counter).end >= allIntervals.get(i).start) {
                merged.get(counter).end = Math.max(merged.get(counter).end, allIntervals.get(i).end);
            } else {
                //no overlap
                merged.add(allIntervals.get(i));
                counter++;
            }
        }

        List<Interval> result = new ArrayList<>();

        //Find the open slots from the merged intervals
        for (int i = 0; i < merged.size() - 1; i++) {
            if (merged.get(i).end < merged.get(i + 1).start) {
                result.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
            }
        }
        return result;
    }
}
