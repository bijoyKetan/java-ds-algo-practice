package leetcode.array;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int i = 0;
        int j = 1;
        while (i < nums.length-1 || j < nums.length-2){
            if (nums[i] == nums[j]) {
                nums[j] = nums[j+1];
            }
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,2,3,5});
    }
}
