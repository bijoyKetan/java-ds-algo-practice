package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LC80_RemoveDuplicates {

    public int removeDuplicatesOptimal(int[] nums) {

        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    public int removeDuplicatesSubOptimal(int[] nums) {
        /*
        iterate til counter < partition
        prev, curr pointers
        freq -> count of current item
        partition to keep track of the length of result arr
        if freq > 2 then pushToEnd until curr != prev
            reduce partition
        */

        if (nums.length <= 2) return nums.length;
        int partition = nums.length;
        int freq = 1;
        int i = 1;

        while (i < partition) {
            if (nums[i] == nums[i - 1]) {
                freq++;
                if (freq > 2) {
                    pushToEnd(nums, i);
                    partition--;
                } else {
                    i++;
                }
            } else {
                freq = 1;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return partition;
    }

    private void pushToEnd(int[] nums, int index) {
        // [1 2 3 4] -> [2 3 4 1]
        while (index < nums.length - 1) {
            int temp = nums[index];
            nums[index] = nums[index + 1];
            nums[index + 1] = temp;
            index++;
        }
    }

    @Test
    public void test() {
        assertThat(removeDuplicatesOptimal(new int[]{1, 1, 1, 2, 2, 3})).isEqualTo(5);
        assertThat(removeDuplicatesOptimal(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3})).isEqualTo(7);
    }
}
