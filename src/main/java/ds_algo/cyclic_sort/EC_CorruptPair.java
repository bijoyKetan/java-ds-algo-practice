package ds_algo.cyclic_sort;

import org.junit.jupiter.api.Test;

public class EC_CorruptPair {

    public int[] findNumbers(int[] nums) {
        if (nums.length < 2) return new int[]{-1, -1};
        int[] result = new int[2];
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result[0] = nums[i];
                result[1] = i + 1;
            }
        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void testPair(){
        int[] nums = findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
