package core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PointerExamples {
    @Test
    public void inPlaceExample() {
        int[] arr = new int[]{3, 4, 2, 3, 5, 7};

        boolean changed = true;
        int prev = arr[0];
        //while (changed == true) // same as the statement below
        while (changed) {
            changed = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < prev && arr[i] < arr[i + 1]) {
                    //Swap happens here
                    //before changing arr[i], the val is stored
                    //in a temp variable, prev
                    //No need for a next var, since
                    // arr[i+1] isn't affected
                    prev = arr[i];
                    arr[i]++;
                    changed = true;
                } else if (arr[i] > prev && arr[i] > arr[i + 1]) {
                    prev = arr[i];
                    arr[i]--;
                    changed = true;
                } else {
                    prev = arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void swapExample() {
        int i = 0;
        int j = 2;
        int[] arr = new int[]{1, 2, 3};

        //Swap the positions of 0th and 2nd item
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
        //[3, 2, 1]
    }
}
