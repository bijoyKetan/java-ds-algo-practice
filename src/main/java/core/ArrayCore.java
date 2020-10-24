package core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
- Using Arrays.asList () you can efficiently create tuples
- Object returned by Arrays.asList (array), is partially mutable:
can change existing entries, but cannot add or delete entries
- Arrays.asList(array) returns an adapter around the original array.
- Arrays.asList(new Integer[]1,2,4)
- Copy array: Arrays .copyOf (A , A.length).
 */

public class ArrayCore {

    @Test
    public void arrayTest() {
        int[] arr = {1, 2, 3, 4, 5};//=> Initialization of a an int array
        //arr[x] = y ; Assigns y to the xth index of arr

        int[] arr2 = new int[arr.length]; //array of length 5
        Arrays.fill(arr2, 0);// fills array2 with 0 => [0,0,0,0,0]

        //Array copying
        // All methods use System.arraycopy() under the hood. Creates shallow copy for non-primitive arrays
        Arrays.copyOf(arr, arr.length); //From index 0 till length.  => [1,2,3,4,5]
        Arrays.copyOfRange(arr, 0, arr.length); // Arrays.copyOfRange(src, startInclusive, endExclusive)
        arr.clone(); // Using the object.clone() method. => [1,2,3,4,5]
        int[] arr6 = new int[arr.length];
        System.arraycopy(arr, 0, arr6, 0, arr.length);
        // System.arraycopy(src, srcStart, dst, dstStart, length) => void

        //Shallow copy example
        String[] strA = {"Alan", "Becky", "Chloe"};
        String[] strB = strA;
        strA[0] = "newAlan";// strB[0] is now also newAlan

        //Sorting.
        // Java uses Merge sort or Time sort depending on the version
        // O(n log n) time and O(n) space
        int[] arr7 = {7, 5, 8, 3, 8, 9};
        Arrays.sort(arr7); //[3, 5, 7, 8, 8, 9]  void method.

        int[][] arr2dA = {{5, 1}, {7, 1}, {8, 1}, {2, 1}};
        Arrays.sort(arr2dA, (a, b) -> Integer.compare(a[0], b[0]));
        //Arrays.sort(arr2dA, Comparator.comparingInt(a -> a[0]));
        //Collection.sort(theList, (a,b) -> Double.compare(a.get(0), b.get(0)));
        List<List<Double>> list = Arrays.asList(
                Arrays.asList(5.1, 2.1, 6.7),
                Arrays.asList(4.1, 2.1, 6.7),
                Arrays.asList(6.1, 2.3, 6.7));
        Collections.sort(list, (a, b) -> Double.compare(a.get(0), b.get(0)));
        //[[4.1, 2.1, 6.7], [5.1, 2.1, 6.7], [6.1, 2.3, 6.7]]

        //Array to list and list to array
        Integer[] arrTest1 ={1,2,3,4,5};
        //Following will not work if arrTest1 was int[]
        List<Integer> listTest1 = Arrays.asList(arrTest1);
        Integer[] arrTest2 = listTest1.toArray(new Integer[0]);

    }

    public static void main(String[] args) {
        /*
        int[] arr = {1,2,3,4,5} => Initialization of a an int array
        arr[x] => returns item at xth index
        arr[x] = y => Assigns y to the xth index of arr
        Arrays.copyOf(srcArr, length) => new array
        Arrays.copyOfRange(srcArr, startIndex, endIndex) => new array
        System.arraycopy(src, srcStart, dst, dstStart, length) => void
        Arrays.sort(arrSrc) => void
        Arrays.fill(src, val) => void
         */


        //Create the DS
        String[] strArr = {"Asia", "Europe", "Africa", "America", "Australia"};

        //First and last items
        String firstItem = strArr[0]; //Asia
        String lastItem = strArr[strArr.length - 1]; //Australia
        System.out.println(String.format("First iItem: %s \nLast item: %s", firstItem, lastItem));

        //Copy array (from inclusive, to exclusive)
        String[] copyArr = Arrays.copyOfRange(strArr, 0, strArr.length);
        System.out.println("Array copy: " + Arrays.toString(copyArr) + "\n"); //"Asia", "Europe", "Africa", "America", "Australia"

        //String as char array. Reverse string
        String str = "FooBar";
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - i - 1];
            charArr[charArr.length - i - 1] = temp;
        }
        String reversedString = new String(charArr);
        System.out.println("Reserved String: " + reversedString + "\n"); //raBooF

        //Arrays.copyOf(srcArr, length) => returns new array. if length > srcArray, then the rest will be filled with 0
        //Arrays.copyOfRange(srcArr, startIndex, endIndex) => returns new array. Start inclusive, end exclusive. If end> srcArr.length, rest filled with 0
        //System.arraycopy(src, srcStart, dst, dstStart, length) => void method. Copies items from src to dst.
        //Arrays.sort(arrSrc) => Void. Sorts the array. n * log n
        //Arrays.fill(src, val) => Void. Fills array with the given val.
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

        //Sort an array
        int[] arr5 = {3, 4, 2, 6, 9, 2, 5, 3};
        Arrays.sort(arr5);
        System.out.println("arr5 (sorted): " + Arrays.toString(arr5));

        //Compare elements in 2d arrays
        int[][] arrayA = new int[][]{{4, 2, 3}, {9, 7, 8}};
        System.out.println(Arrays.toString(arrayA));
        //two-dimensional array in Java is nothing but an array of a one-dimensional array,
        //you can also create a two-dimensional array where individual one-dimensional arrays have different length,
    }
}
