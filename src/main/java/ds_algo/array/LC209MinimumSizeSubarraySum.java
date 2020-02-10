package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC209MinimumSizeSubarraySum {


    public int minSubArrayLen(int s, int[] nums) {
        int count = 1;
        int resultCount = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) return 1;
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= s) {
                    if (resultCount == -1 || count < resultCount) resultCount = count;
                    count = 1;
                    break;
                }
            }
        }
        if (resultCount == -1) return 0;
        return resultCount;
    }

// Solution using a list to hold the successful counts.
//    public int minSubArrayLen(int s, int[] nums) {
//        List<Integer> countList = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= s) return 1;
//            int sum = nums[i];
//            int count = 1;
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                count++;
//                if (sum >= s) {
//                    countList.add(count);
//                    break;
//                }
//            }
//        }
//        Collections.sort(countList);
//        if (countList.size() > 0) return countList.get(0);
//        return 0;
//    }


    @Test
    public void testBase () {
        assertEquals(2, minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    @Test
    public void test2 () {
        assertEquals(3, minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    @Test
    public void testEmptyArr () {
        assertEquals(0, minSubArrayLen(5, new int[]{}));
    }

}
