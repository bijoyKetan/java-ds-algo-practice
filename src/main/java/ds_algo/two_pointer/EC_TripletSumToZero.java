package ds_algo.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EC_TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        // Sort the array (n log n)
        // Iterate through the array
        // for each item in iteration, find a pair where sum(pair) == -arr[item in iteration]
        // the pair will be for the items after item in iteration only, since we're interested in combination and nor permutation
        // skip the seen items to remove duplicates from the combination

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {//last two elements will be part of the sum
            if (i == 0 || arr[i] != arr[i - 1]) {// first item always unique. Skip duplicates
                int start = i + 1;
                int end = arr.length - 1;
                while (start < end) {
                    if (-arr[i] == arr[start] + arr[end]) {
                        result.add(Arrays.asList(arr[i], arr[start], arr[end]));
                        while (start < end && arr[end] == arr[end - 1]) end--;  //skip duplicates
                        while (start < end && arr[start] == arr[start + 1]) start++; //skip duplicates
                        start++;
                        end--;
                    } else if (-arr[i] < arr[start] + arr[end]) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));// [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));//[[-5, 2, 3], [-2, -1, 3]]
        System.out.println(searchTriplets(new int[]{-1, 0, 1, 2, -1, -4}));//[[-1,-1,2],[-1,0,1]]
    }
}
