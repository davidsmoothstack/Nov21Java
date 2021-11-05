package three;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
  public static Random rng = new Random();

  public static void main(String[] args) {
    initialize(5, 20, 20);
  }

  /**
   * Creates a single buffer with any number of IntBuffers or IntProducers
   * 
   * @param bufferSize    Maximum size the buffer can contain
   * @param consumerCount Total number of IntConsumers
   * @param producerCount Total number of IntBuffers
   */
  public static void initialize(Integer bufferSize, Integer producerCount, Integer consumerCount) {
    var buffer = new IntBuffer(bufferSize);

    // Create and run the producers
    Stream.of(new IntProducer[producerCount])
        .parallel()
        .map(p -> new IntProducer(buffer))
        .forEach(p -> p.start());

    // Create and run the consumers
    Stream.of(new IntBuffer[consumerCount])
        .parallel()
        .map(c -> new IntConsumer(buffer))
        .forEach(c -> c.start());
  }

  public static Integer randomRange(Integer min, Integer max) {
    return rng.nextInt(max - min) + min;
  }
}
