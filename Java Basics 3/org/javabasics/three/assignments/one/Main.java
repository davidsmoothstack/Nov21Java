package org.javabasics.three.assignments.one;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        try {
            final List<String> directories = listSubFiles("Java Basics 1", "Java Basics 2", "Java Basics 3");

            for (final String fileName : directories) {
                System.out.println(fileName);
            }
        }
        catch (final Exception e) {
            System.out.println("Error reading directories: " + e.getMessage());
        }
    }

    private static List<String> listSubFiles(final String... directoryPaths) throws
            IOException
    {
        final ArrayList<String> returnList = new ArrayList<>();

        for (final String dir : directoryPaths) {
            final File dirFile = new File(dir);

            final List<String> fileNames = Arrays.stream(dirFile.listFiles())
                    .map(File::getName)
                    .toList();

            final String[] subDirs = Arrays.stream(dirFile.listFiles())
                    .filter(File::isDirectory)
                    .map(File::getAbsolutePath)
                    .toArray(String[]::new);

            returnList.addAll(fileNames);
            // Recursive call
            returnList.addAll(listSubFiles(subDirs));
        }

        return returnList;
    }
}
