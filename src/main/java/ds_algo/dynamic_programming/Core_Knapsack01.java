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


    @Test
    public void test() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsackRecursive(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);//22
        maxProfit = solveKnapsackRecursive(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);//17
    }
}
