package core;

import java.util.*;

public class ArrayCore {

    public static void main(String[] args) {

        //Create the DS
        String[] strArr = {"Asia", "Europe", "Africa", "America", "Australia"};

        //Iterate through and get first and last items
        Map<String, Object> arrMap = new HashMap<>();
        arrMap.put("FirstItem", strArr[0]);
        arrMap.put("LastItem", strArr[strArr.length - 1]);
        arrMap.put("StringArray", new ArrayList());

        for (int i = 0; i < strArr.length; i++) {
            List<String> s = (List<String>) arrMap.get("StringArray");
            s.add(strArr[i]);
            arrMap.put("StringArray", s);
        }

        //Copy array
        String[] copyArr = Arrays.copyOfRange(strArr, 0, strArr.length);

        //Reverse string with char[]
        String str = "FooBar";
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - i - 1];
            charArr[charArr.length - i - 1] = temp;
        }
        String reversedString = new String(charArr);


        //Print results
        System.out.println("arrMap: " + arrMap + "\n");
        System.out.println("Array copy: " + Arrays.toString(copyArr) + "\n");
        System.out.println("Reserved String: " + reversedString + "\n");
    }
}
