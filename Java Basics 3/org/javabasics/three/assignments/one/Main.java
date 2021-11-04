package org.javabasics.three.assignments.one;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws Exception {
    try {
      var directoryPath = ".";
      var directories = listSubFiles(directoryPath);

      for (var fileName : directories) {
        System.out.println(fileName);
      }
    }
    catch (Exception e) {
      System.out.println("Error reading directories: " + e.getMessage());
    }
  }

  private static List<String> listSubFiles(String... directoryPaths) throws IOException {
    var returnList = new ArrayList<String>();

    for (var dir : directoryPaths) {
      var dirFile = new File(dir);

      var fileNames = Arrays.stream(dirFile.listFiles())
          .map(f -> f.getName())
          .toList();

      var subDirs = Arrays.stream(dirFile.listFiles())
          .filter(file -> file.isDirectory())
          .map(file -> file.getAbsolutePath())
          .toArray(String[]::new);

      returnList.addAll(fileNames);
      // Recursive call
      returnList.addAll(listSubFiles(subDirs));
    }

    return returnList;
  }
}
