package core;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindow {
    //find the average of all contiguous subarrays of size ‘K’ in it.
    public static double[] findAverages(int K, int[] arr) {
        //base case- add item from right and remove from left
        double sum = 0;
        int start = 0;
        int end = 0;
        double[] sumArray = new double[arr.length - K + 1];
        for (end = 0; end < arr.length; end++) {
            sum += arr[end];
            if (end >= K - 1) {
                sumArray[start] = sum / K;
                sum -= arr[start];
                start++;
            }
        }
        return sumArray;
    }

    public static void main(String[] args) {
        double[] result = findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
        assertThat(result).containsExactly(2.2, 2.8, 2.4, 3.6, 2.8);
    }

}
