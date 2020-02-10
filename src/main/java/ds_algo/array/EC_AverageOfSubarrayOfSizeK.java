package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EC_AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int K, int[] arr) {

        double[] arrAve = new double[arr.length - K + 1];
        double sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < arr.length - K + 1; i++) {
            double ave = sum / K;
            arrAve[i] = ave;
            if (i < K-1) {
                sum -= arr[i];
                sum += arr[i + K];
            }
        }
        return arrAve;
    }

    @Test
    public void testAveArr() {
        System.out.println(Arrays.toString(findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 })));
    }
}
