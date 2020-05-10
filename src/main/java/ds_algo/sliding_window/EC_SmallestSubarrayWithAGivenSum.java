package ds_algo.sliding_window;

public class EC_SmallestSubarrayWithAGivenSum {
    //Find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    public static int findMinSubArray(int s, int[] arr) {
        //Pseudocode
        //sum -> var to keep track of the sum of contiguous items
        //variable window
        // end and start pointers for the window
        // min length each time sum >= s


        int sum = 0;
        int start = 0;
        int end = 0;
        int minLength = 0;
        for (end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= s) {
                sum -= arr[start];
                if (minLength == 0) minLength = end - start + 1;
                else minLength = Math.min(minLength, end - start + 1);
                start++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result); // Expected 2
        result = findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result); // Expected 1
        result = findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result); // Expected 3
    }
}

