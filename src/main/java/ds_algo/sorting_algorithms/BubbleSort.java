package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5};
        int[] b = new int[]{1, 6, 7, 8};
        int[] c = new int[]{9, 1, 6, 10, 0, 18, 9, 8, 5, 6, 3, 22, -10, -8, 2};
        bubbleSort(c);
        System.out.println(Arrays.toString(c));
    }

    /*
    Approach:
      - Compare two items at a time
      - Ensure larger of two is on RHS
      - This bubbles largest item to end of arr
      - Reduce array size till empty array
      - Sorted partition forms RHS from 0 to arr.length
    */
    public static int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int partition = arr.length - 1;

        for (; partition >= 0; partition--) {
            for (int i = 0; i < partition; i++) {
                int j = i + 1;
                if (arr[i] > arr[j]) swap(arr, i, j);
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
