package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{9, 1, 6, 10, 0, 18, 9, 8, 5, 6, 3, 22, -10, -8, 2};
        // int[] a = new int[]{};
        // int[] a = new int[]{5};
        // int[] a = new int[]{8,6};
        System.out.println("Input array: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    /*
    Approach:
      - Sort from beginning
      - If new item > last item: do nothing
      - If new item < last item: swap
      - Swapping until new item in correct place
      - When entire array sorted, left to right, return
    */
    public static int[] insertionSort(int[] arr) {
        if (arr.length <= 1) return arr;

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
