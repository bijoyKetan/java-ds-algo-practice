package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class Core_LC221_Maximal_Square {

    //Space optimized dp
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length + 1];

        int maxLen = 0; //global max
        int diag; //diagonal value
        int nextDiag; //temp to hold next diagLeft item
        //Curr item before change is the next diag item

        for (int r = 1; r <= matrix.length; r++) {
            diag = 0;//resetting diag when new row
            for (int c = 1; c <= matrix[0].length; c++) {
                nextDiag = dp[c];//save curr value to be used as next diagonal val

                if (matrix[r - 1][c - 1] == '1') {
                    //dp (i) = min( left, up, diag) + 1
                    dp[c] = Math.min(Math.min(dp[c - 1], dp[c]), diag) + 1;
                } else {
                    //if curr item == 0 then set len = 0
                    dp[c] = 0;
                }
                maxLen = Math.max(maxLen, dp[c]);
                diag = nextDiag;
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
