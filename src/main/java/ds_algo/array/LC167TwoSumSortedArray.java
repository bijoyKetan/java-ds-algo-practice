package ds_algo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//assume there will always be a solution.

public class LC167TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;
        while (p1 < p2) {
            int value = numbers[p1] + numbers[p2];
            if (value == target) return (new int[]{p1 + 1, p2 + 1});
            else if (value > target) p2--;
            else p1++;
        }
        return (new int[]{p1 + 1, p2 + 1});
    }

    @Test
    public void test1() {
        int[] expectedOutput = new int[] {1,2};
        assertArrayEquals(twoSum(new int[]{2,7,11,15},9), expectedOutput);
    }

    @Test
    public void test2() {
        int[] expectedOutput = new int[] {2,4};
        assertArrayEquals(twoSum(new int[]{1,9,10,15},24), expectedOutput);
    }

}
