package ds_algo.binary_search;

import org.junit.jupiter.api.Test;

public class EC_CeilingNumber {
    public int searchCeilingOfANumber(int[] arr, int key) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        //boundary checks
        if (arr[start] >= key) return 0;
        if (arr[end] < key) return -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //NOTE:
        // End of while loop -> start == end + 1
        // exact element not found, so the next big number will be arr[start]
        // base cases at the top ensure we don't go out of bound
        // we do not know the exact position of mid (depends on exact control flow)
        return start;
    }

    @Test
    public void testCeiling() {
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, 6)); //1
        System.out.println(searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12)); //4
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, 17)); // -1
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10}, -1)); // 0
        System.out.println(searchCeilingOfANumber(new int[]{}, -5));
    }
}
