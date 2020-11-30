package ds_algo.dynamic_programming;

import core.Util.HelperMethods;
import org.junit.jupiter.api.Test;

public class Core_CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        int MAX_VALUE = amount + 1;
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //Fill first col, i.e. how many coins to get sum == 0 -> 0
                if (j == 0) {
                    dp[i][0] = 0;
                }
                //Fill first row -> how many coins (with 0 coin set) needed to make a sum -> Infinity
                else if (i == 0) {
                    dp[0][j] = MAX_VALUE;
                }
                //Exclusion
                else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                //Inclusion
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }

        }
        HelperMethods.print2DArray(dp);
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }


    @Test
    //coins = [1,2,5], amount = 11
    public void testCoinChange() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // Ans 3
        System.out.println(coinChange(new int[]{2}, 3)); // Ans -1

    }
}
