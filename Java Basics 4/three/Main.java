package three;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
  public static Random rng = new Random();

  public static void main(String[] args) {
    // oneOfEach(5);
    multiple(100, 5, 5);
  }

  /**
   * Creates one IntBuffer, IntConsumer and IntProducer
   * 
   * @param bufferSize Maximum size the buffer can contain
   */
  public static void oneOfEach(Integer bufferSize) {
    var buffer = new IntBuffer(bufferSize);
    var consumer = new IntConsumer(buffer);
    var producer = new IntProducer(buffer);

    consumer.start();
    producer.start();
  }

  /**
   * Creates a single buffer with any number of IntBuffers or IntProducers
   * 
   * @param bufferSize    Maximum size the buffer can contain
   * @param consumerCount Total number of IntConsumers
   * @param producerCount Total number of IntBuffers
   */
  public static void multiple(Integer bufferSize, Integer consumerCount, Integer producerCount) {
    var buffer = new IntBuffer(bufferSize);

    // Create and run the producers
    Stream.of(new IntProducer(buffer))
        .map(p -> new IntProducer(buffer))
        .forEach(p -> p.start());

    // Create and run the consumers
    Stream.of(new IntBuffer[consumerCount])
        .map(c -> new IntConsumer(buffer))
        .forEach(c -> c.start());
  }

  public static Integer randomRange(Integer min, Integer max) {
    return rng.nextInt(max - min) + min;
  }
}
