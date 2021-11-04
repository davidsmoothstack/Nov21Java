package three;

import java.lang.Thread;
import java.util.Collection;

public class Consumer<T> extends Thread {
  private Collection<T> buffer;

  public Consumer(Collection<T> buffer) {
    super();
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {
        synchronized (buffer) {
          var iterator = buffer.iterator();

          while (iterator.hasNext()) {
            var obj = iterator.next();
            System.out.println("Object " + obj.hashCode() + " consumed");
          }
        }

        Thread.sleep(2000);
      }
    }
    catch (Exception e) {
      System.out.println("Error in consumer: " + e.getMessage());
    }
  }
}
