package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class Core_LC221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col +1];
        int max = 0;

        for(int i = 1; i<= row; i++){
            for (int j = 1; j<= col; j++){
                if (matrix[i-1][j-1] == '1'){
                    //NOTE: Math.min/max function can be applied to only two items, i.e. Math.min(a, b);
                    dp[i][j] = Math.min( Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max * max;
        // Note: The following will also work. (int) Math.pow(base, power);
        //return (int)Math.pow(max, 2);
    }

    @Test
    public void testMaxSq(){
        char[][] matrix = new char [][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
