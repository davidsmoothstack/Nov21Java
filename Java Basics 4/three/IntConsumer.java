package three;

import java.lang.Thread;

public class IntConsumer extends Thread {
  private IntBuffer buffer;

  public IntConsumer(IntBuffer buffer) {
    super();
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (buffer) {
          if (!buffer.isEmpty()) {
            var integer = buffer.iterator().next();
            System.out.println(integer + " consumed");
            buffer.remove(integer);
          }
        }

        Thread.sleep(Main.randomRange(500, 5_000));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
