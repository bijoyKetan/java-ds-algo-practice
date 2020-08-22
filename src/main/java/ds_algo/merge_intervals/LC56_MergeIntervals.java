package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56_MergeIntervals {
    //Given a collection of intervals, merge all overlapping intervals.
    public int[][] merge(int[][] intervals) {

        //Sort the arrays by the first item
        //Have a list of results, List<int[]>
        //Iterate over the sorted arrays
        //Add the first item to the result list
        //Compare the current array element vs the last item in merged interval
        //For non-overlapping lists, add the element to result
        //For overlapping lists, merge the last item in result to element
        //Merge -> [start of the prevMerged, Math.max(end of prevMerged, end of element)]
        //Finally convert the list to an array and output that

        List<int[]> results = new ArrayList<>();
        if (intervals.length < 2) {
            return intervals;
        }

        //2d array sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        results.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            int lastItem = results.size() - 1;
            if (intervals[i][0] > results.get(lastItem)[1]) {
                results.add(intervals[i]); //non overlapping intervals
            } else { //Overlapping intervals
                results.set(lastItem, new int[]{results.get(lastItem)[0], Math.max(results.get(lastItem)[1], intervals[i][1])});
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
