package ds_algo.map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC217ContainsDuplicates {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry e : countMap.entrySet()) {
            if ((Integer) e.getValue() > 1) return true;
        }
        return false;

//         for (int v: countMap.values()){
//              if (v>1) return true;
//         }
//         return false;
    }

    public static boolean containsDuplicateIterative(int[] nums) {
        Arrays.sort(nums);
        if (nums.equals(null) || nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            int p1 = nums[i];
            int p2 = nums[i + 1];
            if (p1 == p2) return true;
            p1++;
            p2++;
        }
        return false;
    }

    @Test
    public void testDuplicate() {
        assertEquals(true, containsDuplicate(new int[]{1, 2, 3, 4, 2}));
        assertEquals(false, containsDuplicate(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testDuplicateIterative() {
        assertEquals(true, containsDuplicateIterative(new int[]{1, 2, 3, 4, 2}));
        assertEquals(false, containsDuplicateIterative(new int[]{1, 2, 3, 4, 5}));
        assertEquals(false, containsDuplicateIterative(new int[]{1}));
    }
}

