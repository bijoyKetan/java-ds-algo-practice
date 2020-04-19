package core;

import java.util.*;

public class ArrayCore {

    public static void main(String[] args) {

        //Create the DS
        String[] strArr = {"Asia", "Europe", "Africa", "America", "Australia"};

        //First and last items
        String firstItem = strArr[0];
        String lastItem = strArr[strArr.length - 1];

        //Copy array
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


        //Print results
        System.out.println(String.format("First iItem: %s \nLast item: %s", firstItem, lastItem));
        System.out.println("Array copy: " + Arrays.toString(copyArr) + "\n");
        System.out.println("Reserved String: " + reversedString + "\n");
    }
}
