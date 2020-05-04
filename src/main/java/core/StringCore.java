package core;

/**
 * Common String methods:
 * charAt(i) -> the character in this String at a given index
 * contains(str) -> true if this String contains the other's characters inside it
 * endsWith(str) -> true if this String ends with the other's characters
 * equals(str) -> true if this String is the same as str
 * equalsIgnoreCase(str) -> true if this String is the same as str, ignoring capitalization
 * indexOf(str) -> first index in this String where given String begins (-1 if not found)
 * lastIndexOf(str) ->  last index in this String where given String begins (-1 if not found)
 * length() -> number of characters in this String
 * startsWith(str) ->  true if this String begins with the other's characters
 * substring(i, j) ->  characters in this String from index i (inclusive) to j (exclusive)
 * toLowerCase(), toUpperCase() -> a new String with all lowercase or uppercase letters
 * String.valueOf(number) -> converts the number (int, float, double etc.) to string
 * Integer.valueOf(String) -> converts the string to int. Could also be Double.valueOf(String)
 * String str = 1 + ""; -> Number + "" -> String.
 */

public class StringCore {
    public static void main(String[] args) {

        String a = " New York  "; //Initialized -> " New York  "
        a = a.trim(); //leading and trailing spaces removed -> "New York"
        a = a.replace(' ', '*'); // character replaced -> New*York
        a = a.replace("ew", "!!"); // seq of chars replaced -> N!!*York
        a = a.toUpperCase(); // -> N!!*YORK
        a = a.toLowerCase(); // -> n!!*york

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

        //***************//
        //VARIOUS TRICKS//
        //***************//
        //Is a given character letter or digit
        String str = "This is 2019!";
        bool = Character.isLetterOrDigit(str.charAt(0)); // true

        int num = 5;
        String strNum = "" + num; //converts to string

        String someNum = "33";
        int someNumInt = Integer.parseInt(someNum); // -> 33
        System.out.println(someNum);
        

        //*****************//
        //  STRING BUILDER //
        //*****************//
        //For multiple manipulations, use StringBuilder
        StringBuilder b = new StringBuilder("California");
        b.append(", CA"); // -> California, CA
        b.reverse(); // -> AC ,ainrofilaC
        b.reverse(); // -> California, CA
        b.deleteCharAt(b.length() - 1); // -> California, C
        b.delete(b.indexOf(","), b.lastIndexOf("C") + 1); // same as -> b.delete(10, 12+1); -> California
    }
}
