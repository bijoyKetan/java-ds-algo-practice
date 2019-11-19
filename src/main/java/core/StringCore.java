package core;

public class StringCore {
    public static void main(String[] args) {
        System.out.println("The string class is working");

        String myString = "SampleString";
        String upperString = myString.toUpperCase();
        System.out.println("Upper: -> " + upperString);

        //Iterate through the elements of String
        for (char c : myString.toCharArray()) System.out.println(c);
        for (int i = 0; i < myString.length(); i++) System.out.println(myString.charAt(i));

        /*
        String booleans
        Starts with
        Ends with
        Contains
         */
        boolean startsWithSam = myString.toUpperCase().startsWith("SAM");
        boolean endsWithSam = myString.toUpperCase().endsWith("SAM");
        boolean containsSam = myString.toUpperCase().contains("SAM");
        System.out.println(
                "Starts with SAM -> " + startsWithSam + "\n" +
                        "Ends with SAM -> " + endsWithSam + "\n" +
                        "Contains SAM -> " + containsSam + "\n"
        );


        //Substring - last three characters
        String mySubStr = myString.substring(myString.length()-3, myString.length());
        System.out.println(mySubStr);


        /*
        Common String methods:
        charAt(i) -> the character in this String at a given index
        contains(str) -> true if this String contains the other's characters inside it
        endsWith(str) -> true if this String ends with the other's characters
        equals(str) -> true if this String is the same as str
        equalsIgnoreCase(str) -> true if this String is the same as str, ignoring capitalization
        indexOf(str) -> first index in this String where given String begins (-1 if not found)
        lastIndexOf(str) ->  last index in this String where given String begins (-1 if not found)
        length() -> number of characters in this String
        startsWith(str) ->  true if this String begins with the other's characters
        substring(i, j) ->  characters in this String from index i (inclusive) to j (exclusive)
        toLowerCase(), toUpperCase() -> a new String with all lowercase or uppercase letters
         */
    }
}
