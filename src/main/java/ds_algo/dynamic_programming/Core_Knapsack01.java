package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class Core_Knapsack01 {

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        //Note: int[][] -> automatically initializes all elements with 0
        //Integer [][] -> Initializes all elements with null
        //Capacity is being built from 0 to p, so length +1 size needed
        Integer[][] memo = new Integer[profits.length][capacity + 1];
        return recurse(profits, weights, capacity, 0, memo);
    }

    //Recursive solution for DP usually require helper func to track index
    //Here only one index is enough since len (profits) == len (weights)
    private int recurse(int[] profits, int[] weights, int capacity, int index, Integer[][] memo) {
        //1. Pick and not pick decision tree
        //2. while picking make sure that capacity is not violated
        //3. Not picking is always an option
        // Recurrence relationship -> f(p, w, c) = max (f(p+1, w+1, c-w), f(p+1, w+1, c))

        //Base cases - always at the top
        // If end of array reached or if capacity is reached then no more profit
        if (capacity <= 0 || index >= profits.length) return 0;

        //Before any calculation, check cache
        //Retrieval from cache is constant time
        if (memo[index][capacity] != null) {
            return memo[index][capacity];
        }

        //Case 1: Not picking
        int profit0 = recurse(profits, weights, capacity, index + 1, memo);

        //Case 2: Picking
        int profit1 = 0;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + recurse(profits, weights, capacity - weights[index], index + 1, memo);
        }

        int maxProfit = Math.max(profit0, profit1);
        //Before returning, add to cache
        memo[index][capacity] = maxProfit;
        return maxProfit;
    }

    //Decision making DP template
    public int solveKnapsackDp(int[] profits, int[] weights, int capacity) {
        //1. Build target from 0 to t.
        //Here target is capacity
        int m = profits.length;

        //2. dp [array length of items, i.e. bag size of values][target +1]
        //Note: Row - Items. Row -> indexing used in recursion
        //Col -> target (0 to t)
        int[][] dp = new int[m][capacity + 1];

        //3.Initialize array.
        //Note: No need to initialize row/col where the entire row/col == 0
        // int[][] automatically initializes entire array with 0

        //Initialize the set of values/items that will be picked/not picked
        //Initialize 0th row by iterating through range(0, target+1)
        for (int i = 0; i <= capacity; i++) {
            if (weights[0] <= i) {
                dp[0][i] = profits[0];
            }
        }

        //4. Process the sub-arrays of all targets
        for (int row = 1; row < m; row++) { //index of items
            for (int col = 1; col <= capacity; col++) { //building target value

                int profit0 = 0, profit1 = 0;
                //Option 1: Do not pick
                profit0 = dp[row - 1][col];

                //Option 2: Pick, only if weight constraint not violated
                //Profit = profit from this item + Max profit from previous items
                if (weights[row] <= col) {
                    profit1 = profits[row] + dp[row - 1][col - weights[row]];
                }

                //Get the max of p0 and p1
                dp[row][col] = Math.max(profit0, profit1);
            }
        }
        //Return the last item
        return dp[m - 1][capacity];
    }


    @Test
    public void test() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsackRecursive(profits, weights, 7);
        System.out.println("Total knapsack profit 1 with recursion ---> " + maxProfit);//22
        maxProfit = solveKnapsackRecursive(profits, weights, 6);
        System.out.println("Total knapsack profit 2 with recursion ---> " + maxProfit);//17

        int maxProfit2 = solveKnapsackDp(profits, weights, 7);
        System.out.println("Total knapsack profit 1 with DP ---> " + maxProfit2);//22
        maxProfit2 = solveKnapsackDp(profits, weights, 6);
        System.out.println("Total knapsack profit 2 with DP ---> " + maxProfit2);//17
    }
}
