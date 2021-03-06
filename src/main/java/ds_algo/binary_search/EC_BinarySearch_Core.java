package ds_algo.binary_search;

import org.junit.jupiter.api.Test;

//Given a sorted array of numbers, find if a given number ‘key’ is present in the array
public class EC_BinarySearch_Core {

    public int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        //ascending vs descending
        if (arr.length == 1) return arr[0] == key ? 0 : -1;

        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean ascending = arr[start] < arr[end];

        while (start <= end) {
            //not (start + end) / 2 -> integer overflow
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (ascending) {
                if (key > arr[mid]) start = mid + 1;
                else end = mid - 1;
            } else {
                if (key > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }


    @Test
    public void testBinarySearch() {
        System.out.println(search(new int[]{4, 6, 10}, 10)); //2
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5)); //4
        System.out.println(search(new int[]{10, 6, 4}, 10)); //0
        System.out.println(search(new int[]{10, 6, 4}, 4)); //2
        System.out.println(search(new int[]{10, 6, 4}, 20)); //-1
    }
}
