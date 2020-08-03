import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayPlayground {

    //Arrays.copyOf(srcArr, length) => returns new array. if length > srcArray, then the rest will be filled with 0
    //Arrays.copyOfRange(srcArr, startIndex, endIndex) => returns new array. Start inclusive, end exclusive. If end> srcArr.length, rest filled with 0
    //System.arraycopy(src, srcStart, dst, dstStart, length) => void method. Copies items from src to dst.
    @Test
    public void testArrayMethods() {
        int[] arr = {1, 2, 3, 4, 5};

        //Copy all but the first and last items to another array
        int[] arr2 = Arrays.copyOfRange(arr, 1, arr.length - 1);
        System.out.println(Arrays.toString(arr2));

        //Fill an array of size 5 with 0 and then with 1
        int[] arr3 = new int[5];
        Arrays.fill(arr3, 0);
        System.out.println(Arrays.toString(arr3));
        Arrays.fill(arr3, 1);
        System.out.println(Arrays.toString(arr3)); // 1,1,1,1,1

        //Copy the first three items from arr to the last three positions of arr3
        System.arraycopy(arr, 0, arr3, arr.length - 3, 3);
        System.out.println(Arrays.toString(arr3)); // 1,1,1,2,3

        //Copy the first three items of arr into a new array
        int[] arr4 = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(arr4));

    }
}
