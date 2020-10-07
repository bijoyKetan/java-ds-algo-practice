package ds_algo.cyclic_sort;

import org.junit.jupiter.api.Test;

public class EC_FirstMissingPositive {
    //Given an unsorted array containing numbers,
    //find the smallest missing positive number in it.
    public int findNumber(int[] nums) {

        int n = nums.length;
        int i = 0;
        while (i < n) {
            int j = nums[i] - 1; // j is the "correct index"
            if (nums[i] < n && nums[i] > 0 && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
            //nums[i] => duplicates and i+1 => missing num
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testFirstMissingPositive() {
        System.out.println(findNumber(new int[]{-3, 1, 5, 4, 2}));
        System.out.println(findNumber(new int[]{3, -2, 0, 1, 2}));
        System.out.println(findNumber(new int[]{3, 2, 5, 1}));
        System.out.println(findNumber(new int[]{3}));
        System.out.println(findNumber(new int[]{}));
    }
}
