package ds_algo.cyclic_sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CyclicSortTest {

    // For questions involving in place sorting of a range of positive integers
    public int[] cycleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) { //Condition for iteration
            int j = nums[i] - 1; //Establish j
            if (j < nums.length && nums[i] != i + 1) { //Condition for swap.
                //Swap continues until we get the correct element in ith index
                //Must check if it is possible to get the correct element (e.g. impossible for n+1)
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        return nums;
    }

    public int[] cycleSort2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != i + 1) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        return nums;
    }

    //Swap helper function that swaps two elements in the given indices
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testCycleSort() {
        int[] nums = new int[]{4, 3, 2, 1};
        System.out.println(Arrays.toString(cycleSort(nums)));
        System.out.println(Arrays.toString(cycleSort2(nums)));
    }
}
