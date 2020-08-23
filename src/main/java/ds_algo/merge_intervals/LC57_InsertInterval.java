package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57_InsertInterval {
    //Given a set of non-overlapping intervals, insert a new interval into the intervals
    /* Pseudocode:
    Sorted intervals provided
    List<int[]> for results
    lastInterval = newInterval
    Add the newInterval to result
    Iterate through the intervals
    Compare each interval to lastInterval
    There can be three cases:
    1. No overlap and lastInterval < interval => add but no merge
    2. No overlap and lastInterval > interval => add but no merge
    3. Overlap => merge and modify lastInterval boundaries
    return result converted to array

    Edge cases:
    if intervals is empty, return newInterval
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int[] lastInterval = newInterval;
        result.add(lastInterval);

        for (int[] interval : intervals) {
            //non overlap left
            if (lastInterval[1] < interval[0]) {
                lastInterval = interval;
                result.add(interval);
            }
            //non overlap right
            else if (lastInterval[0] > interval[1]) {
                result.remove(lastInterval);
                result.add(interval);
                result.add(lastInterval);

            } else {
                lastInterval[0] = Math.min(lastInterval[0], interval[0]);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
        return result.toArray(new int[0][]);
    }


    @Test
    public void insertIntervalTest() {
        //Case 1
        int[][] input = new int[][]{{1, 2}, {3, 5}, {9, 10}};
        int[] newInterval = new int[]{7, 12};
        int[][] result = insert(input, newInterval);
        System.out.println("---CASE 1---");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        } //[1, 2], [3, 5], [7, 12]

        //Case 2
        int[][] input2 = new int[][]{{1, 5}};
        int[] newInterval2 = new int[]{2, 3};
        int[][] result2 = insert(input2, newInterval2);
        System.out.println("---CASE 2---");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        } // [1, 5]
    }
}
