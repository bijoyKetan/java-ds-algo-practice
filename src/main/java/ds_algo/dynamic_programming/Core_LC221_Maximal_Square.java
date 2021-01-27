package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class Core_LC221_Maximal_Square {

    //Space optimized dp
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length + 1];

        int maxLen = 0;
        int prev = 0;
        //temp to held diagLeft item
        int temp;

        for (int row = 1; row <= matrix.length; row++) {
            for (int col = 1; col <= matrix[0].length; col++) {
                temp = dp[col];

                //dp (i) = min( left, up, diagLeft)
                if (matrix[row - 1][col - 1] == '1') {
                    dp[col] = Math.min(Math.min(dp[col - 1], dp[col]), prev) + 1;
                } else {
                    //if curr item == 0 then set len = 0
                    dp[col] = 0;
                }
                maxLen = Math.max(maxLen, dp[col]);
                prev = temp;
            }
        }
        return maxLen * maxLen;
    }

    public int maximalSquare2(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        //dp contains the max Sq,
        //if noms(i) were included
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;//global maxima variable

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    //NOTE: Math.min/max function can be applied to only two items,
                    // i.e. Math.min(a, b);
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    //update global maxima if local max > global max
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max * max;
        // Note: The following will also work. (int) Math.pow(base, power);
        //return (int)Math.pow(max, 2);
    }

    @Test
    public void testMaxSq() {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }
}
