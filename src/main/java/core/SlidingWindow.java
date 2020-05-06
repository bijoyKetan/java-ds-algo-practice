package core;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindow {
    //Find the average of all contiguous subarrays of size ‘K’ in it.
    public static double[] findAverages(int K, int[] arr) {
        double sum = 0; //variable to be tracked for processing
        int start = 0; // window start
        int end = 0; //window end
        double[] sumArray = new double[arr.length - K + 1];

        for (end = 0; end < arr.length; end++) { //grow from right, end++
            sum += arr[end];
            if (end >= K - 1) { //condition for window to grow to required size
                sumArray[start] = sum / K;
                sum -= arr[start];
                start++; //shrink from left
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
