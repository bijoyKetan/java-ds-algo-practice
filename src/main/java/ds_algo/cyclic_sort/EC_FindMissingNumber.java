package ds_algo.cyclic_sort;

class EC_FindMissingNumber {

    public static int findMissingNumber(int[] nums) {

        int i = 0;
        int count = 0; //counter to track the number of iterations inside the while loop
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
                count++;
                if (count >= nums.length - i) return i;
            } else {
                i++;
                count = 0;
            }
        }
        return -1;

        //The following will also work instead of using a counter
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != j) return j;
//        }
//        return nums.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}