package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayQuestions {

    /*
  LC 560. Subarray Sum Equals K
  Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
  [1,1,1], k = 2
  ans: 2
   */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0, target = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) count++;
            target = sum - k;
            if (map.containsKey(target)) count += map.get(target);
            //NOTE: Be careful when the map is populated
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    void subarraySumTest(){
        assertThat(subarraySum(new int[] {1,1,1}, 2)).isEqualTo(2);//2
        assertThat(subarraySum(new int[] {1,2,3}, 3)).isEqualTo(2);//2
        assertThat(subarraySum(new int[] {1}, 0)).isEqualTo(0);//0
    }

    /////////////////////////////////////////////////////////////////////
}
