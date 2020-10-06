package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DPNotes {
    private static final Logger log = LoggerFactory.getLogger(DPNotes.class);

    //----------------------------------//
    // NAIVE RECURSIVE //
    //----------------------------------//
    //Same computation done multiple times.
    //Stack grows exponentially

    public int fibNaive(int n) {
        if (n < 0) return -1;
        else if (n < 2) return n;
        else return fibNaive(n - 1) + fibNaive(n - 2);
    }

    //----------------------------------//
    // TOP DOWN //
    //----------------------------------//
    //Can still result in stack overflow

    public int fibTopDownHelper(int n, int[] memo) {
        if (n < 0) return -1;
        else if (n < 2) return n;
        else {
            if (memo[n] != -1) return memo[n];
            else {
                int result = fibTopDownHelper(n - 1, memo) + fibTopDownHelper(n - 2, memo);
                memo[n] = result;
                return result;
            }
        }
    }

    public int fibTopDown(int n) {
        //For easier index management , create a +1 size array for memo table
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibTopDownHelper(n, memo);
    }

    //----------------------------------//
    // BOTTOM UP //
    //----------------------------------//
    //No issue with stack overflow

    public int fibBottomUp(int n) {
        int[] results = new int[n+1];
        if (n < 0) return -1;
        results[0] = 0;
        results[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            results[i] = results[i-1] + results[i-2];
        }
        return results[n];
    }


    @Test
    public void testFib() {
        log.info("FibNaive(10) is: " + fibNaive(10));//55
        log.info("FibTopDown(10) is: " + fibTopDown(10));//55
        log.info("FibBottomUp(10) is: " + fibBottomUp(10));//55
    }

    @Test
    public void testDP(){
        // Changing parameters
        // State transition equation
        // Base cases & boundary conditions
        // Memoization table

        //int[][] 2dArr = new int[row][col]
        int[][] test2DArr = new int[][]{{1,2,3}, {4,5, 6}};
        System.out.println(test2DArr[0][1]);


    }
}
