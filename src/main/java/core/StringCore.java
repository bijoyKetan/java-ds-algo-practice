package core;


import org.junit.jupiter.api.Test;

public class StringCore {

    @Test
    public void coreStringMethods() {
        String str = "A word";

        str.charAt(0); // char in this String at i
        str.contains("targetStr");// -> boolean
        str.startsWith("targetStr");//->  boolean
        str.endsWith("targetStr"); // -> boolean
        str.equals("targetStr");// -> case sensitive equality
        str.equalsIgnoreCase("targetStr");//-> case insensitive equality check
        str.indexOf("targetStr");//-> first index where str starts (else -1)
        str.lastIndexOf("targetStr");//->  last index where str starts (else -1)
        str.length();//-> number of chars
        str.substring(0, str.length());//->  i (inclusive) to j (exclusive)
        str.toLowerCase();//-> new str with all lowercase
        str.toUpperCase();//-> new str with all uppercase
        String.valueOf(123);//-> number to string
        String.valueOf('c');//-> character to string
        Integer.valueOf("12345");//-> String to integer
        Double.valueOf("123.45");//-> String to double
        String str2 = 1 + "";//-> Number + "" -> String.
        str.toCharArray(); //-> convert string to charArray

        //Strings are immutable in Java
        //For string manipulation, use StringBuilder instead
        //While dealing with string input, we must need additional space
        //due to string immutability
        StringBuilder sb = new StringBuilder();
        sb.append("ab");
        sb.append("c");
        sb.toString(); //-> returns string, abc
    }

    public static void main(String[] args) {

        String a = " New York  "; //Initialized -> " New York  "
        a = a.trim(); //leading and trailing spaces removed -> "New York"
        a = a.replace(' ', '*'); // character replaced -> New*York
        a = a.replace("ew", "!!"); // seq of chars replaced -> N!!*York
        a = a.toUpperCase(); // -> N!!*YORK
        a = a.toLowerCase(); // -> n!!*york

        //Replacement
        String sentence = "It's a man, it's a plane, it's superman.";
        //convert to lowercase and remove punctuations
        sentence = sentence
                .toLowerCase()
                .replaceAll("[,_!'.]", "");
        //its a man its a plane its superman
        //No need of escape characters inside []
        //Each character is treated as literal inside [] and replaced
        //Without [], escape character \\ needed e.g.
        //sentence = sentence.replaceAll("\\.", "");


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
