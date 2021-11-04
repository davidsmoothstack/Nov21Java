package one;

public class Main {
  private volatile static Main instance;

  public static void main(String[] args) {
    var x = Main.getInstance();
    System.out.println(x.hashCode());
  }

  public static Main getInstance() {
    if (instance == null) {
      synchronized (Main.class) {
        if (instance == null)
          instance = new Main();
      }
    }

    return instance;
  }
}
