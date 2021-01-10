package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5};
        int[] b = new int[]{1, 6, 7, 8};
        int[] c = new int[]{9, 1, 6, 10, 0, 18, 9, 8, 5, 6, 3, 22, -10, -8, 2};
        // System.out.println(Arrays.toString(merge(a, b)));
        System.out.println("Input array: " + Arrays.toString(c));
        System.out.println("Sorted result: " + Arrays.toString(mergeSort(c)));
    }

    public static int[] mergeSort(int[] arr) {
        //base case when the array is of length 1 or 0
        if (arr.length <= 1) return arr;

        //Divide array to left and right subarrays
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        System.out.println("Left subarray: " + Arrays.toString(left));
        System.out.println("Right subarray: " + Arrays.toString(right) + "\n");

        //merge the left and right arrays
        return merge(mergeSort(left), mergeSort(right));
    }


    //Merging two sorted arrays
    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        //output array -> merged
        int[] merged = new int[a.length + b.length];

        //Compare from a and b and put in merged
        while (i < a.length && j < b.length) {
            merged[i + j] = a[i] < b[j] ? a[i++] : b[j++];
        }

        //add any leftover from a
        while (i < a.length) {
            merged[i + j] = a[i++];
        }

        //add any leftover from b
        while (j < b.length) {
            merged[i + j] = b[j++];
        }

        //return final
        return merged;
    }
}
