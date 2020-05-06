package ds_algo.sliding_window;

public class EC_MaximumSumSubarray {
    //Find maximum sum of any contiguous subarray of size ‘k’.
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        for (end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
