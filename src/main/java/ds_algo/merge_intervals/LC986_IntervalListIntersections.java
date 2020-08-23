package ds_algo.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC986_IntervalListIntersections {
    /*
    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
    Return the intersection of these two interval lists.
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
    /*
    Pseudocode
    Iterate through A
    For each item in A, check if there's any overlap (either start or end can overlap)
        - a's start can be in between b
        - a's end can be in between b
        - b can be a subset of a (bStart >= aStart && bEnd <= aEnd)
    If overlap then get the intersection (opposite of merge)
    Continue with this item until item end < interval start
    */
        if (A.length == 0 || B.length == 0) {
            return new int[][]{};
        }

        List<int[]> result = new ArrayList<>();
        for (int[] a : A) {
            for (int[] b : B) {
                if (a[1] < b[0]) {
                    //No chance of further overlap so break out of inner for loop
                    break;
                }
                //a overlaps with b (a left, a right, a subset)
                else if ((a[0] >= b[0] && a[0] <= b[1]) || (a[1] >= b[0] && a[1] <= b[1])) {
                    int[] intersection = new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
                    result.add(intersection);
                }
                //b subset of a
                //Some of the following checks are redundant
                //else if ((b[0] >= a[0] && b[0] <= a[1]) || (b[1] > a[0] && b[1] <=a[1])){
                else if (b[0] > a[0]) {
                    int[] intersection = new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
                    result.add(intersection);
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    @Test
    public void testIntersection() {
        int[][] A = new int[][]{{1, 3}, {5, 6}, {7, 9}};
        int[][] B = new int[][]{{2, 3}, {5, 7}};
        int[][] results = intervalIntersection(A, B);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}
