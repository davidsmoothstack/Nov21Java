package org.javabasics.two.assignments.one;

public class Main {
    public static void main(final String[] args) {
        var total = 0;

        for (final var argument : args)
            total += Main.parseInput(argument);

        System.out.println("The total is: " + total);
    }

    private static Integer parseInput(final String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (final Exception e) {
            System.out.println(input + " is not a valid number. Please make sure all arguments are whole numbers");
            System.exit(0);
            return 0;
        }
    }
}
