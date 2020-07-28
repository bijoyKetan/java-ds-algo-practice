package ds_algo.two_pointer;

import java.util.Arrays;
import java.util.List;

//https://www.educative.io/courses/grokking-the-coding-interview/mElknO5OKBO
public class EC_TripletsWithSmallerSum {
    //arr[i] + arr[j] + arr[k] < target
    //Find the count of such triplets
    public static int searchTriplets(int[] arr, int target) {
        //iterate through the arr
        //for each ith item
        //two pointer sum for the elements to the right of ith item
        //if a triplet is found such that sum triplet < target
        //then count += end-start (since for a given start, all the items to left od end also satisfy the condition)

        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                if (arr[i] + arr[start] + arr[end] < target) {
                    count += end - start;
                    start++;
                } else end--;
            }
        }
        return count;
    }

    public static List<List<Integer>> getAllTriplets(int[] arr, int target) {
        //TODO - Complete this part
        return null;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));//2
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5)); //4
    }
}
