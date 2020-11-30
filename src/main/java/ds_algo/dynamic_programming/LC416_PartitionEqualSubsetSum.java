package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class LC416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];


        //Fill out first col
        //dp[row][0] -> Col fixed at 0
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }

        //fill out first row
        for (int i = 0; i <= target; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }

        for (int row = 1; row < nums.length; row++) {
            for (int col = 1; col <= target; col++) {
                int sum0 = 0, sum1 = 0;

                //Option - not choose
                sum0 = dp[row - 1][col];

                //Option - choose
                if (nums[row] <= col) {
                    sum1 = nums[row] + dp[row - 1][col - nums[row]];
                }
                //Choose the max
                dp[row][col] = Math.max(sum0, sum1);
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    @Test
    public void testPartitionEqualSubsetSum() {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
    }

}
