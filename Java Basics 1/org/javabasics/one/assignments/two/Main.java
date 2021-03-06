package org.javabasics.one.assignments.two;

import java.util.Scanner;

public class Main implements GameOverListener {
    final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        new Main().startGame();
    }

    public void startGame() {
        final Game game = new Game(5, 1, 100);
        game.addListener(this);

        while (true) {
            System.out.print("Please guess a number: ");
            final int guess = this.getConsoleInput();
            game.checkGuess(guess);
        }
    }

    @Override
    public void onGameOver(final String message) {
        System.out.println(message);
        this.scanner.close();
        System.exit(0);
    }

    private int getConsoleInput() {
        while (true) {
            try {
                return Integer.parseInt(this.scanner.nextLine());
            }
            catch (final Exception e) {
                System.out.println("Invalid number. Please guess again");
            }
        }
    }
}
