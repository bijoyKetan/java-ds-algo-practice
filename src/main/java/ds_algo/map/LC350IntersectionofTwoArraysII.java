package ds_algo.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC350IntersectionofTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 ==null) return new int[]{};

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> intersectionList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            countMap.put(nums1[i], countMap.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (countMap.containsKey(nums2[i]) && countMap.get(nums2[i]) > 0) {
                intersectionList.add(nums2[i]);
                countMap.put(nums2[i], countMap.get(nums2[i]) - 1);
            }
        }

        int[] resultArr = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            resultArr[i] = intersectionList.get(i);
        }
        return resultArr;
    }


    @Test
    public void testIntersectingArrays() {
        assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1, 2, 2}, new int[]{2, 2}));
    }

    @Test
    public void testIntersectingArrays2() {
        assertArrayEquals(new int[]{}, intersect(new int[]{1, 2, 2, 1, 2, 2}, new int[]{}));
    }


}
