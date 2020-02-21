package core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class UsefulCodeSnippets {

    /**
     * A class with a collection of useful methods that are often used
     * in various common use cases in Java.
     * @param args
     */

    public static void main(String[] args) {

    }


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
}
