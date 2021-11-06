package org.javabasics.three.assignments.two;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        var outPath = Paths.get("Java Basics 3", "org", "javabasics", "three", "assignments", "two", "out");
        var outFile = Paths.get(outPath.toString(), "append-to-me.txt");

        try {
            if (! Files.exists(outPath))
                Files.createDirectory(outPath);

            var writer = new FileWriter(outFile.toString(), true);
            writer.write("Hello world\n");

            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
