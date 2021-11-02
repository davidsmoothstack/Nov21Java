package org.javabasics.one.assignments.two;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private List<GameOverListener> listeners = new ArrayList<GameOverListener>();
  private int answer;
  private int guessesLeft;
  // Accept answers between upper and lower ranges
  private int upperRange;
  private int lowerRange;
  // Minimum number user can guess
  private int minGuess;
  // Maximum number user can guess
  private int maxGuess;

  public Game(int totalGuesses, int minimum, int maximum) {
    guessesLeft = totalGuesses;
    minGuess = minimum;
    maxGuess = maximum;
    answer = getRandomNumber(minGuess, maxGuess);
    upperRange = answer + 10;
    lowerRange = answer - 10;
  }

  public void checkGuess(int guess) {
    var isValidGuess = validateGuess(guess);
    var isGuessWithinTen = isWithinBounds(guess, lowerRange, upperRange);

    if (!isValidGuess) {
      System.out.println("Your guess has to be between " + minGuess + " and " + maxGuess);
      return;
    }

    if (isGuessWithinTen) {
      broadcastGameOver(true);
      return;
    }

    guessesLeft--;

    if (guessesLeft == 0) {
      broadcastGameOver(false);
      return;
    }

    System.out.println("Keep guessing!");
  }

  public void addListener(GameOverListener listner) {
    listeners.add(listner);
  }

  private int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private boolean validateGuess(int guess) {
    var isValid = isWithinBounds(guess, minGuess, maxGuess);

    if (!isValid)
      return false;

    return true;
  }

  private boolean isWithinBounds(int number, int min, int max) {
    return (number >= min && number <= max);
  }

  private void broadcastGameOver(boolean isWin) {
    String message;

    if (isWin)
      message = "The correct answer was " + answer + ". Good job";
    else
      message = "Sorry, the answer was " + answer;

    for (GameOverListener listener : listeners)
      listener.onGameOver(message);
  }
}
