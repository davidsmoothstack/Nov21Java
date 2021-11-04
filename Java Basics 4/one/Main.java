package one;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  private volatile static Main instance;

  public static void main(String[] args) {
    var threadList = Arrays.asList(new Thread[10]);

    threadList.stream()
        .map(t -> new Thread(
            () -> {
            }))
        .parallel()
        .forEach(t -> t.start());
  }

  public static Main getInstance() {
    if (instance == null) {
      synchronized (Main.class) {
        if (instance == null) {
          instance = new Main();
        }
      }
    }

    return instance;
  }
}
