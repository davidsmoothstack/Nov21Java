package three;

import java.util.Collection;

public class Producer<T> extends Thread {
  private Collection<T> buffer;

  public Producer(Collection<T> buffer) {
    super();
    this.buffer = buffer;
  }

  @Override
  public void run() {
    try {
      while (true) {

        synchronized (buffer) {
          var obj = (T) new Object();
          buffer.add(obj);
          System.out.println("Object " + obj.hashCode() + " produced");
        }

        Thread.sleep(500);
      }
    }
    catch (Exception e) {
      System.out.println("Error in producer: " + e.getMessage());
    }
  }
}
