package three;

import java.util.Random;

public class Main {
  public static Random rng = new Random();

  public static void main(String[] args) {
    var buffer = new IntBuffer(3);
    var consumer = new IntConsumer(buffer);
    var producer = new IntProducer(buffer);

    consumer.start();
    producer.start();
  }

  public static Integer randomRange(Integer min, Integer max) {
    return rng.nextInt(max - min) + min;
  }
}
