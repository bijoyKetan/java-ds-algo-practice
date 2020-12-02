package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Core_UnboundedKnapsack {


    /*
        - Template for unbounded knapsack problem
        - Applies problems where the choices are the same in each stage (except some base conditions)
        Steps:
        1. dp array (1D for 1d item array and 2D for matrix/grid input)
        2. Fill array with initial values (max init values for minimization and vice versa)
        3. For each value of target (from 0 -> t), what choices (coins/steps etc) optimal?
        So, outer loop -> target
            inner loop -> choices
        4. Return answer

        //Template
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);

        for (int i = 0; i <= target; i++) {
            for (int item : items) { //item -> choice
                if (i == 0) dp[i] = 0;
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - item] + 1);
                }
            }
        }
        return dp[target] == target + 1 ? -1 : dp[target];

     */
    public int coinChange1D(int[] coins, int amount) {
        //Need to build till target
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i == 0) dp[i] = 0;
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    //Classic unbounded knapsack problem
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
        //HelperMethods.print2DArray(dp);
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }

    @Test
    public void testCoinChange() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // Ans 3
        System.out.println(coinChange(new int[]{2}, 3)); // Ans -1

        System.out.println(coinChange1D(new int[]{1, 2, 5}, 11)); // Ans 3
        System.out.println(coinChange1D(new int[]{2}, 3)); // Ans -1
    }
}
