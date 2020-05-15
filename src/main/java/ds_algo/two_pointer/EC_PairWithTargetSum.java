package ds_algo.two_pointer;

//https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
public class EC_PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        //pseudo code
        //left pointer (smallest)
        //right pointer
        //sum = arr[left] + arr[right]
        //while (left < right)
        //check for the success condition
        //return new int[] {left, right} for success

        int left = 0;
        int right = arr.length - 1;
        int sum = 0;

        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == targetSum) {
                return new int[]{left, right};
            } else if (sum < targetSum) {
                left++;
            } else
                right--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]"); //[1,3]
        result = search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");//[0,2]
    }
}
