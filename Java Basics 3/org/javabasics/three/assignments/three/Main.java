package org.javabasics.three.assignments.three;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        try {
            final Path inputPath = Paths.get("Java Basics 3", "org", "javabasics", "three", "assignments", "three", "in", "input.txt");
            final Scanner reader = new Scanner(inputPath);

            // Get first char from console args. If there are no args use e as the default value
            final char charToCount = (args.length > 0) ? args[0].charAt(0) : 'e';
            int count = 0;

            while (reader.hasNextLine()) {
                count += reader.nextLine()
                        .chars()
                        .filter(charCode -> charCode == (int) charToCount)
                        .count();
            }

            System.out.println("There are " + count + " " + charToCount + "'s");
            reader.close();
        }
        catch (final Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
