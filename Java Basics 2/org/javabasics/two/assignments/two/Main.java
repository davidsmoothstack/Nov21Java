package org.javabasics.two.assignments.two;

public class Main {
    public static void main(final String[] args) {
        final Integer[][] arr = new Integer[100][100];

        populate2dArray(arr, 1, 100_000);
        final BiggestElement largest = getLargestElement(arr);

        System.out.printf("The largest element in the array is %d at position array[%d][%d]",
                largest.value(),
                largest.positionY(),
                largest.positionX());
    }

    private static Integer getRandomNumber(final Integer min, final Integer max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void populate2dArray(
            final Integer[][] arr,
            final Integer min,
            final Integer max)
    {
        if (min >= max) {
            System.out.println("Min must be greater than max");
            System.exit(0);
        }

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = getRandomNumber(min, max);
    }

    private static BiggestElement getLargestElement(final Integer[][] arr) {
        BiggestElement largest = new BiggestElement(arr[0][0], 0, 0);

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                final Integer currentInt = arr[y][x];
                if (currentInt > largest.value())
                    largest = new BiggestElement(currentInt, y, x);
            }
        }

        return largest;
    }
}
