package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{4, 7, 2, 9, 9, 8, 10};
        int[] sorted = quickSort(input);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] quickSort(int[] arr) {
        //Edge cases
        if (arr == null || arr.length <= 1) return arr;
        helperQuickSort(arr, 0, arr.length - 1);
        return arr;
    }

    //helper function
    private static void helperQuickSort(int[] arr, int left, int right) {
        //Base case: No item or only one item
        if (left >= right) return;

        int pivot = right;
        int wall = left;

        // Iterate from left through pivot -1
        // Everything to left of wall is smaller
        // Everything to right of wall is bigger or equal
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                //Swap (wall, i)
                int temp = arr[i];
                arr[i] = arr[wall];
                arr[wall] = temp;
                wall++;
            }
        }

        //Finally swap (pivot, wall)
        int temp = arr[pivot];
        arr[pivot] = arr[wall];
        arr[wall] = temp;

        //Recursive case
        helperQuickSort(arr, left, wall - 1);
        helperQuickSort(arr, wall + 1, right);
    }
}
