package three;

import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static final Random rng = new Random();

    public static void main(final String[] args) {
        initialize(5, 20, 20);
    }

    /**
     * Creates a single buffer with any number of IntBuffers or IntProducers
     *
     * @param bufferSize    Maximum size the buffer can contain
     * @param consumerCount Total number of IntConsumers
     * @param producerCount Total number of IntBuffers
     */
    public static void initialize(final Integer bufferSize, final Integer producerCount, final Integer consumerCount) {
        final IntBuffer buffer = new IntBuffer(bufferSize);

        // Create and run the producers
        Stream.of(new IntProducer[producerCount])
                .parallel()
                .map(p -> new IntProducer(buffer))
                .forEach(Thread::start);

        // Create and run the consumers
        Stream.of(new IntBuffer[consumerCount])
                .parallel()
                .map(c -> new IntConsumer(buffer))
                .forEach(Thread::start);
    }

    public static Integer randomRange(final Integer min, final Integer max) {
        return rng.nextInt(max - min) + min;
    }
}
