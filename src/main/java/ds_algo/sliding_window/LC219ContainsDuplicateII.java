package ds_algo.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC219ContainsDuplicateII {
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j
// in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length < 2 || k < 1) return false;
        int windowStart = 0, windowEnd = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int leftItem, rightItem, windowSize;


        for (int i = 0; i < nums.length; i++) {
            rightItem = nums[windowEnd];
            leftItem = nums[windowStart];
            windowSize = windowEnd - windowStart + 1;
            countMap.put(rightItem, countMap.getOrDefault(rightItem, 0) + 1);
            if (countMap.size() < windowSize) return true;
            if (windowSize > k) {
                countMap.put(leftItem, countMap.get(leftItem) - 1);
                if (countMap.get(leftItem) == 0) countMap.remove(leftItem);
                windowStart++;
            }
            windowEnd++;
        }
        return false;
    }

    @Test
    public void testDuplicateNegative() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        assertEquals(false, containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testDuplicatePositive() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        assertEquals(true, containsNearbyDuplicate(nums, k));
    }
}
