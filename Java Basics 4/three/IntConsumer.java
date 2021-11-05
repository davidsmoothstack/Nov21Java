package three;

import java.lang.Thread;

public class IntConsumer extends Thread {
  private IntBuffer buffer;
  private static volatile int count;
  public Integer id;

  public IntConsumer(IntBuffer buffer) {
    super();
    this.buffer = buffer;
    this.id = ++count;
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (buffer) {
          if (!buffer.isEmpty()) {
            var integer = buffer.iterator().next();
            buffer.remove(integer);

            System.out.println(
                String.format("Consumer %d consumed %d", id, integer));
          }
        }

        Thread.sleep(Main.randomRange(0, 3_000));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
