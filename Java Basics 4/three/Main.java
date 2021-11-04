package three;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    var buffer = new ArrayList<Integer>();
    var consumer = new Consumer<Integer>(buffer);
    var producer = new Producer<Integer>(buffer);

    consumer.start();
    producer.start();
  }
}
