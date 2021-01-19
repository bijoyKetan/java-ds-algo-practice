package core;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringCore {

    @Test
    public void coreStringMethods() {
        String str = "  A word  ";

        str.trim(); //leading and trailing spaces removed -> "A word"
        str.charAt(0); // char in this String at i
        str.contains("targetStr");// -> boolean
        str.startsWith("targetStr");//->  boolean
        str.endsWith("targetStr"); // -> boolean
        str.equals("targetStr");// -> case sensitive equality
        str.equalsIgnoreCase("targetStr");//-> case insensitive equality check
        str.length();//-> number of chars
        str.substring(0, str.length());//->  i (inclusive) to j (exclusive)
        str.toLowerCase();//-> new str with all lowercase
        str.toUpperCase();//-> new str with all uppercase
        String str2 = 1 + "";//-> Number + "" -> String.
        str.toCharArray(); //-> convert string to charArray
        str.indexOf("targetStr");//-> first index where str starts (else -1)
        str.lastIndexOf("targetStr");//->  last index where str starts (else -1)

        // *** CHAR ARRAY *** //
        char[] arr = new char[] {'l', 'o', 'v', 'e'};
        String.valueOf(arr); // "love"
        new String(arr); // "love"
        Arrays.toString(arr); //[l, o, v, e]
        //char[] to subString -> String(charArr, start, length)
        new String(arr, 1, 3);
        //"ove"

        // *** REPLACEMENT *** //
        String sentence = "It's a man, it's a plane, it's superman.";
        // Task: convert to lowercase and remove punctuations
        sentence = sentence
                .toLowerCase()
                .replaceAll("[,_!'.]", "");
        /*
        its a man its a plane its superman
        No need of escape characters inside []
        Each character is treated as literal inside [] and replaced
        Without [], escape character \\ needed e.g.
        sentence = sentence.replaceAll("\\.", "");
         */
        String a = " New York  "; //Initialized -> " New York  "
        a = a.trim(); //"New York"
        a = a.replace(' ', '*'); // character replaced -> New*York
        a = a.replace("ew", "!!"); // seq of chars replaced -> N!!*York
        a = a.toUpperCase(); // -> N!!*YORK
        a = a.toLowerCase(); // -> n!!*york


        // *** TYPE CONVERSIONS *** //
        String.valueOf(123);//-> number to string
        String.valueOf('c');//-> character to string

        Integer.parseInt("12345"); //String to int, preferred
        //Integer.valueOf("12345");

        Double.parseDouble("123.45"); //-> String to double, preferred
        //Double.valueOf("123.45");


        // *** STRING BUILDER *** //
        /* Strings are immutable in Java
        For string manipulation, use StringBuilder instead */
        StringBuilder sb = new StringBuilder("California");
        //StringBuilder sb = new StringBuilder();
        //sb.append("California");
        sb.append(", CA"); // -> California, CA
        sb.reverse(); // -> AC ,ainrofilaC
        sb.reverse(); // -> California, CA
        sb.deleteCharAt(sb.length() - 1); // -> California, C
        sb.delete(sb.indexOf(","), sb.lastIndexOf("C") + 1);
        // same as -> b.delete(10, 12+1); -> California
        sb.toString(); // California


        // *** MISC *** //
        //Is a given character letter or digit
        String str3 = "This is 2019!";
        Character.isLetterOrDigit(str.charAt(0)); // true
    }

    public static void main(String[] args) {

        /*
        Note: String in Java is immutable, but StringBuilder is immutable
        so, when a string is manipulated, a new string object is created in string pool and
        the reference is changed to point to new object by the original object is unchanged.
        We can prove that by comparing hashcode of the objects
        TO compare value of two string objects, use equals()
         */

        //String can be viewed as a char[]
        char[] charArray = {'L', 'o', 'c', 'k'};
        String c = new String(charArray); // -> Lock

        //Reverse String c in place
        char[] d = c.toCharArray();
        int size = d.length;
        for (int i = 0; i < size / 2; i++) {
            char temp = d[i];
            d[i] = d[size - i - 1];
            d[size - i - 1] = temp;
        }
        //-> kcoL

        //Reversing with two pointers
        char[] charArray2 = {'T', 'e', 'n', 't'};
        String e = new String(charArray2);
        int m = 0;
        int n = charArray2.length - 1;
        while (m < n) {
            char temp = charArray2[m];
            charArray2[m] = charArray2[n];
            charArray2[n] = temp;
            m++;
            n--;
        }
        // -> tneT

        //Other string methods
        String z = "Sample String...";
        boolean bool = z.contains("sa"); // bool -> false
        bool = z.startsWith("Sa"); // bool -> true
        bool = z.startsWith("ple", 3); //offset = index of the first letter. bool -> true
        bool = z.endsWith("g..."); // bool ->  true
        bool = z.equalsIgnoreCase("SAMPLE String..."); // -> true
        String zSubString = z.substring(1, z.length() - 1); // inclusive start and exclusive start -> ample String..

    }
}
