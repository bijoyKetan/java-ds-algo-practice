package core;

import org.junit.jupiter.api.Test;

public class Array2D {

    @Test
    /*
    [0, 0, 0, 0, 0]
    [1, 3, 3, 3, 3]
    [1, 3, 3, 3, 3]
    [1, 3, 3, 3, 3]
    [1, 3, 3, 3, 3]
     */
    public void testArrayConstruction() {
        //int[][] dp = new int [rows][cols]
        int[][] dp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) dp[0][j] = 0;//all columns of first row
                else if (j == 0) dp[i][0] = 1; //all rows of first column
                else dp[i][j] = 3; // the rest
            }
        }
    }
}
