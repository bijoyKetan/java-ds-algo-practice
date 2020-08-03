package core;

import java.util.Arrays;

public class ArrayCore {

    public static void main(String[] args) {

        //Create the DS
        String[] strArr = {"Asia", "Europe", "Africa", "America", "Australia"};

        //First and last items
        String firstItem = strArr[0];
        String lastItem = strArr[strArr.length - 1];

        //Copy array (from inclusive, to exclusive)
        String[] copyArr = Arrays.copyOfRange(strArr, 0, strArr.length);

        //String as char array. Reverse string
        String str = "FooBar";
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - i - 1];
            charArr[charArr.length - i - 1] = temp;
        }
        String reversedString = new String(charArr);

        //Arrays.copyOf(srcArr, length) => returns new array. if length > srcArray, then the rest will be filled with 0
        //Arrays.copyOfRange(srcArr, startIndex, endIndex) => returns new array. Start inclusive, end exclusive. If end> srcArr.length, rest filled with 0
        //System.arraycopy(src, srcStart, dst, dstStart, length) => void method. Copies items from src to dst.
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
        System.out.println(Arrays.toString(arr4));// 1,2,3

        //Print results
        System.out.println(String.format("First iItem: %s \nLast item: %s", firstItem, lastItem));
        System.out.println("Array copy: " + Arrays.toString(copyArr) + "\n");
        System.out.println("Reserved String: " + reversedString + "\n");
    }
}
