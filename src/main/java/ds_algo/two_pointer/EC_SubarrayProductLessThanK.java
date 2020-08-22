package ds_algo.two_pointer;

//Sliding window
//start = 0; end = 0;
//product = arr[start] * arr[end]
//resultArr
//while product < target then add to resultArray and end++
//else while product > target,  start ++ and remove from arr
//continue until both start and end >= arr.length

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EC_SubarrayProductLessThanK {

    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        int start = 0;
        int end = 0;
        int product = arr[start];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> subArrays = new ArrayList<>();

        while (end < arr.length - 1 && start < arr.length - 1) {
            System.out.println("product " + product);
            if (product < target) {
                result.add(arr[end]);
                subArrays.add(result);
                end++;
                product = start == end ? arr[start] : product * arr[end];
            } else {
                start++;
                product = start == end ? arr[start] : product / arr[start];
            }
        }
        return subArrays;
    }

    @Test
    public void testSubArrays() {
        System.out.println(findSubarrays(new int[]{3, 2, 4}, 10));
    }
}
