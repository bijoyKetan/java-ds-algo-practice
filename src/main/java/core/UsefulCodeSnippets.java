package core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsefulCodeSnippets {

    /**
     * A class with a collection of useful methods that are often used
     * in various common use cases in Java.
     * @param args
     */

    public static void main(String[] args) {
        streammCollection();
    }

    //Reading from files and writing to files.
    public static void readLineJava8() {
        Path filePath = Paths.get("sample.xml");
        try {
            Stream<String> lines = Files.lines(filePath);
            lines
                    .filter(x -> x.contains("book"))
                    .forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLineJava8() {
        Path writePath = Paths.get("sampleOutput.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(writePath)) {
            writer.write("123");
            writer.write("\n456");
            writer.write("\n789");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Checking for duplicates in a hashmap and adding if not present
    public static void duplicateElementsMapCheck() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("Name", "Ketan");
        testMap.put("Location", "New York");
        testMap.put("Profession", "Engineer");
        List<String> headers = new ArrayList(Arrays.asList("Name", "Gender", "Occupation"));
        List<String> values = new ArrayList(Arrays.asList("Ketan", "Male", "Engineer"));
        for (int i = 0; i< headers.size(); i++){
            testMap.putIfAbsent(headers.get(i), values.get(i));
        }

        int[] nums = {1, 2, 5, 1, 3, 4, 7, 1, 3};
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i],0)+1);
        }
    }

    //Some common conversion from one type to another
    public static void typeConversions() {
        int iInt = 123;
        String iString = "553";

        //Convert string number to char[] and then pick each number
        char[] strToChar = iString.toCharArray();
        List<Integer> outputList = new ArrayList<>();
        for (int i=0; i<strToChar.length; i++) {
            outputList.add(Integer.parseInt(String.valueOf(strToChar[i])));
        }

        //Convert String number to integer directly
        int stringToInt = Integer.parseInt(iString);

        //Convert int to String
        String intToString = String.valueOf(iInt);

        //Put all the characters of a string into a char[] and print that array
        char[] stringToCharArray = new char [iString.length()];
        for (int i=0; i<iString.length(); i++) {
            stringToCharArray[i] = iString.charAt(i);
        }
        System.out.println("String to charArray is: " + Arrays.toString(stringToCharArray));
    }

    //Stream with collection example
    public static void streammCollection() {
        List<String> inputList = new ArrayList(Arrays.asList("Tom", "Sam", "Ron", "Monica"));
        //following results in [Sam]
        List<String> outputList = inputList
                .stream()
                .filter(x -> x.contains("am"))
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        //Iterating with index
        List<String> outputListWithIntStream = IntStream.range(0, inputList.size())
                .filter(i -> inputList.get(i).contains("am"))
                .mapToObj(i -> inputList.get(i).toUpperCase())
                .collect(Collectors.toList());
    }
}
