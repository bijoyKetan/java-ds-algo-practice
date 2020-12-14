package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

public class LC152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int prevMax = nums[0];
        int prevMin = nums[0];
        int maxRes = prevMax;
        for (int i = 1; i <nums.length; i++){
            //NOTE: A temp pointer needed. Otherwise max would be changed affecting calc of min
            int tempMax = Math.max(Math.max(nums[i], prevMax * nums[i]), prevMin * nums[i]);
            prevMin = Math.min(Math.min(nums[i], prevMax * nums[i]), prevMin * nums[i]);
            prevMax = tempMax;
            if (prevMax > maxRes) maxRes = prevMax;
        }
        return maxRes;
    }

    @Test
    public void testMax() {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
    }
}
