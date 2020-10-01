package cyclic_sort;

import org.junit.jupiter.api.Test;

class EC_FindDuplicate {

    public int findNumber(int[] nums) {
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
            if (nums[i] != i + 1) return nums[i];
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testDuplicate(){
        System.out.println(findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
