package three;

import javax.swing.text.PlainView;

public class IntProducer extends Thread {
  private IntBuffer buffer;

  public IntProducer(IntBuffer buffer) {
    super();
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (buffer) {
          if (buffer.isFull())
            continue;

          var randomInt = Main.randomRange(1, 100_000);
          buffer.add(randomInt);
          System.out.println(randomInt + " produced");
        }

        Thread.sleep(Main.randomRange(200, 700));
      }
    }
    catch (Exception e) {
      System.out.println("Error in producer: " + e.getMessage());
    }
  }
}
