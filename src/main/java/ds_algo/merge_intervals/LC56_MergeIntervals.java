package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56_MergeIntervals {
    //Given a collection of intervals, merge all overlapping intervals.
    public int[][] merge(int[][] intervals) {

        //Sort the arrays by the first item
        //Declare a list of results, List<int[]>
        //Var newInterval tracks resultLists's last item
        //Iterate over the sorted arrays (int[] interval:intervals)
        //Compare interval[0] vs. newInterval[1]
        //interval[0] > newInterval[1] => non overlapping
        //If non-overlapping, add interval to result
        //If overlapping, merge newInterval to interval
        //Merge -> set newInterval[1] to Math.max(interval[1], newInterval[1])
        //Convert resultList to array, results.toArray(new int[0][])

        List<int[]> results = new ArrayList<>();
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //newInterval refers to the last item in results list
        int[] newInterval = intervals[0];
        results.add(newInterval);
        for (int[] interval : intervals) {
            //non overlap case
            if (interval[0] > newInterval[1]) {
                newInterval = interval;
                results.add(newInterval);
            } else {
                //overlap - change just the end value of newInterval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        //list to array conversion
        return results.toArray(new int[0][]);
    }

    @Test
    public void testMergedIntervals() {
        int[][] input2 = new int[][]{new int[]{1, 4}, new int[]{0, 2}, new int[]{3, 5}};
        final var output2 = merge(input2); //[0, 5]
        for (int[] element : output2) {
            System.out.println(Arrays.toString(element));
        }
    }
}
