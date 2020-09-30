package ds_impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortedArrays {

    public int[] merge(int[] leftArray, int[] rightArray) {
        if (leftArray.length == 0) return rightArray;
        if (rightArray.length == 0) return leftArray;

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int[] result = new int[leftSize + rightSize];
        int i = 0;
        int j = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                result[i + j] = leftArray[i];
                i++;
            } else {
                result[i + j] = rightArray[j];
                j++;
            }
        }

        //Copying ove remaining elements from either left or right array
        while (i < leftSize) {
            result[i + j] = leftArray[i];
            i++;
        }
        while (j < rightSize) {
            result[i + j] = rightArray[j];
            j++;
        }
        return result;
    }

    @Test
    public void testMergeOfTwoSortedArrays() {
        int[] arr1 = new int[]{2, 3, 4, 5, 8};
        int[] arr2 = new int[]{4, 5};
        System.out.println(Arrays.toString(merge(arr1, arr2))); //[2, 3, 4, 4, 5, 5, 8]
    }
}
