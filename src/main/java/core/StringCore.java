package core;

/*
  Common String methods:
  charAt(i) -> char in this String at i
  contains(str) -> boolean
  endsWith(str) -> boolean
  equals(str) -> case sensitive equality
  equalsIgnoreCase(str) -> case insensitive equality check
  indexOf(str) -> first index where str starts (else -1)
  lastIndexOf(str) ->  last index where str starts (else -1)
  length() -> number of chars
  startsWith(str) ->  boolean
  substring(i, j) ->  i (inclusive) to j (exclusive)
  toLowerCase() -> new str with all lowercase
  toUpperCase() -> new str with all uppercase
  String.valueOf(number) -> number to string
  Integer.valueOf(String) -> String to integer
  Double.valueOf(String) -> String to double
  String str = 1 + ""; -> Number + "" -> String.
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
