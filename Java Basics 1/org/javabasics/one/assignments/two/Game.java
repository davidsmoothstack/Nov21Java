package org.javabasics.one.assignments.two;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<GameOverListener> listeners = new ArrayList<GameOverListener>();
    private final int answer;
    // Accept answers between upper and lower ranges
    private final int upperRange;
    private final int lowerRange;
    // Minimum number user can guess
    private final int minGuess;
    // Maximum number user can guess
    private final int maxGuess;
    private int guessesLeft;

    public Game(final int totalGuesses, final int minimum, final int maximum) {
        this.guessesLeft = totalGuesses;
        this.minGuess = minimum;
        this.maxGuess = maximum;
        this.answer = this.getRandomNumber(this.minGuess, this.maxGuess);
        this.upperRange = this.answer + 10;
        this.lowerRange = this.answer - 10;
    }

    public void checkGuess(final int guess) {
        final var isValidGuess = this.validateGuess(guess);
        final var isGuessWithinTen = this.isWithinBounds(guess, this.lowerRange, this.upperRange);

        if (!isValidGuess) {
            System.out.println("Your guess has to be between " + this.minGuess + " and " + this.maxGuess);
            return;
        }

        if (isGuessWithinTen) {
            this.broadcastGameOver(true);
            return;
        }

        this.guessesLeft--;

        if (this.guessesLeft == 0) {
            this.broadcastGameOver(false);
            return;
        }

        System.out.println("Keep guessing!");
    }

    public void addListener(final GameOverListener listner) {
        this.listeners.add(listner);
    }

    private int getRandomNumber(final int min, final int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private boolean validateGuess(final int guess) {
        final var isValid = this.isWithinBounds(guess, this.minGuess, this.maxGuess);

        return isValid;
    }

    private boolean isWithinBounds(final int number, final int min, final int max) {
        return (number >= min && number <= max);
    }

    private void broadcastGameOver(final boolean isWin) {
        final String message;

        if (isWin)
            message = "The correct answer was " + this.answer + ". Good job";
        else
            message = "Sorry, the answer was " + this.answer;

        for (final GameOverListener listener : this.listeners)
            listener.onGameOver(message);
    }
}
