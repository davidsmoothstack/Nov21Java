package org.david.assignments.two;

import java.util.Scanner;

public class Main implements GameOverListener {
  Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().startGame();
  }

  public void startGame() {
    var game = new Game(5, 1, 100);
    game.addListener(this);

    while (true) {
      System.out.print("Please guess a number: ");
      var guess = getConsoleInput();
      game.checkGuess(guess);
    }
  }

  @Override
  public void onGameOver(String message) {
    System.out.println(message);
    scanner.close();
    System.exit(0);
  }

  private int getConsoleInput() {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Invalid number. Please guess again");
        continue;
      }
    }
  }
}
