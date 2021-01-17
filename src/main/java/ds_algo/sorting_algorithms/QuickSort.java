package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class QuickSort {

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

        // Iterate from left through pivot-1
        // Everything to left of wall is smaller
        // Everything to right of wall is bigger or equal
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, wall++, i);
            }
        }
        //Finally swap (pivot, wall)
        swap(arr, pivot, wall);

        //Recursive case
        helperQuickSort(arr, left, wall - 1);
        helperQuickSort(arr, wall + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 7, 2, 9, 9, 8, 10};
        int[] input2 = new int[]{9, 1, 6, 10, 0, 18, 9, 8, 5, 6, 3, 22, -10, -8, 2};

        int[] sorted = quickSort(input);
        int[] sorted2 = quickSort(input2);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(sorted2));
    }
}
