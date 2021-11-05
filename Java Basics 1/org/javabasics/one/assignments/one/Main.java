package org.javabasics.one.assignments.one;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("1)");
        printRightTriangle(4, TriangleGrowth.GROW);
        repeat(9, ".", true);

        System.out.println("2)");
        repeat(10, ".", true);
        printRightTriangle(4, TriangleGrowth.SHRINK);

        System.out.println("3)");
        printIsoscelesTriangle(7, TriangleGrowth.GROW);
        repeat(11, ".", true);

        System.out.println("4)");
        repeat(12, ".", true);
        printIsoscelesTriangle(7, TriangleGrowth.SHRINK);
    }

    private static void printRightTriangle(int width, TriangleGrowth growth) {
        var i = 1;
        var iterator = 1;
        Predicate<Integer> loopPredicate = n -> n <= width;

        if (growth == TriangleGrowth.SHRINK) {
            i = width;
            iterator = -1;
            loopPredicate = n -> n > 0;
        }

        for (; loopPredicate.test(i); i += iterator)
            repeat(i, "*", true);
    }

    private static void printIsoscelesTriangle(int width, TriangleGrowth growth) {
        // Triangle in the example always has a padding of 2
        var padding = 2;
        int spaceCount;
        int starCount;

        if (growth == TriangleGrowth.GROW) {
            spaceCount = Math.floorDiv(width, 2) + padding;
            starCount = 1;

            while (starCount <= width) {
                repeat(spaceCount, " ", false);
                repeat(starCount, "*", true);

                starCount += 2;
                spaceCount--;
            }
        }
        else {
            spaceCount = padding;
            starCount = width;

            while (starCount >= 1) {
                repeat(spaceCount, " ", false);
                repeat(starCount, "*", true);

                starCount -= 2;
                spaceCount++;
            }
        }
    }

    private static void repeat(int count, String content, boolean addNewLine) {
        for (var i = 0; i < count; i++)
            System.out.print(content);

        if (addNewLine)
            System.out.println();
    }
}
