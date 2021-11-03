package org.javabasics.two.assignments.two;

public class Main {
  public static void main(String[] args) {
    Integer[][] arr = new Integer[10][10];

    populate2dArray(arr, 1, 100_000);
    var largest = getLargestElement(arr);

    System.out.println("The largest element in the array is " + largest);
  }

  private static Integer getRandomNumber(Integer min, Integer max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private static void populate2dArray(Integer[][] arr, Integer min, Integer max) {
    if (min >= max) {
      System.out.println("Min must be greater than max");
      System.exit(0);
    }

    for (int i = 0; i < arr.length; i++)
      for (int j = 0; j < arr[i].length; j++)
        arr[i][j] = getRandomNumber(min, max);
  }

  private static Integer getLargestElement(Integer[][] arr) {
    int largest = arr[0][0];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        var currentInt = arr[i][j];
        if (currentInt > largest)
          largest = currentInt;
      }
    }

    return largest;
  }
}
