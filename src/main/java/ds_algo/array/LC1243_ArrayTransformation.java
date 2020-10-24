package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LC1243_ArrayTransformation {

    public List<Integer> transformArray(int[] arr) {
        int prev = arr[0];
        boolean changed = true;
        List<Integer> result = new ArrayList<>();
        int changeCount = 1;

        while (changeCount > 0) {

            changeCount = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < prev && arr[i] < arr[i + 1]) {
                    prev = arr[i];
                    arr[i]++;
                    changeCount++;
                } else if (arr[i] > prev && arr[i] > arr[i + 1]) {
                    prev = arr[i];
                    arr[i]--;
                    changeCount++;
                } else {
                    prev = arr[i];
                }
            }

        }

        for (int item : arr) {
            result.add(item);
        }

        return result;
    }

    @Test
    public void test() {
        int[] arr = new int[]{6, 5, 8, 6, 7, 7, 3, 9, 8, 8, 3, 1, 2, 9, 8, 3};
        System.out.println(transformArray(arr).toString());
    }

}
