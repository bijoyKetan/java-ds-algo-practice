package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class LC53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0]  = nums[0];

        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            //NOTE: dp -> function of the max by including item in ith index.
            // Inclusion is must for substring/subarray. Not necessary for subsequence
            // Choice 1: Pick this item only (it is a subarray by itself) OR
            // Choice 2: Pick max of last item's index
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test
    public void testMaxSubArr() {
        System.out.println(maxSubArray(new int[]{1}));
    }
}
