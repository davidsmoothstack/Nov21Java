package org.javabasics.three.assignments.three;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      var inputPath = Paths.get("Java Basics 3", "org", "javabasics", "three", "assignments", "three", "in", "input.txt");
      var reader = new Scanner(inputPath);

      // Get first char from console args. If there are no args use e as the default value
      var charToCount = (args.length > 0) ? args[0].charAt(0) : 'e';
      var count = 0;

      while (reader.hasNextLine()) {
        count += reader.nextLine()
            .chars()
            .filter(charCode -> charCode == (int) charToCount)
            .count();
      }

      System.out.println("There are " + count + " " + charToCount + "'s");
      reader.close();
    }
    catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
