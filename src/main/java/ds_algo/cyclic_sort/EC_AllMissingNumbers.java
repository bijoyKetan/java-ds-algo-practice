package ds_algo.cyclic_sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//given an unsorted array containing numbers taken from the range 1 to ‘n with duplicates
//Find all those missing numbers.

public class EC_AllMissingNumbers {
    public List<Integer> findNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                // Index +1 should have the correct numbers
                // if not, index +1 is the missing number
                result.add(i + 1); //This will add the missing numbers
                result.add(nums[i]);// This will add the duplicates
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testMissingNumbers() {
        List<Integer> missing = findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        System.out.println("Missing numbers: " + missing); //[4, 6, 7]

        missing = findNumbers(new int[]{2, 4, 1, 2}); //3
        System.out.println("Missing numbers: " + missing);

        missing = findNumbers(new int[]{2, 3, 2, 1}); //4
        System.out.println("Missing numbers: " + missing);

    }
}
